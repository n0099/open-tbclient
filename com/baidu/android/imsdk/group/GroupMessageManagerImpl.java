package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupInfoChangeMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberAddMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberDelMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberJoinMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberNameChangeMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberQuitMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarAlertMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarJoinMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarMasterUpdateMsg;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class GroupMessageManagerImpl {
    private static Context mContext;
    private static GroupMessageManagerImpl mInstance;
    private static final String TAG = GroupMessageManagerImpl.class.getSimpleName();
    protected static Object mSyncLock = new Object();

    public static GroupMessageManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (mSyncLock) {
                if (mInstance == null) {
                    mContext = context.getApplicationContext();
                    mInstance = new GroupMessageManagerImpl();
                }
            }
        }
        return mInstance;
    }

    private GroupMessageManagerImpl() {
    }

    public ArrayList<ChatMsg> getAllChatMsg(String str, ChatMsg chatMsg, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(mContext, str, chatMsg, i, z);
    }

    public ArrayList<ChatMsg> getAllSystemMsg(String str, ChatMsg chatMsg, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return GroupMessageDAOImpl.fetchGroupSystemMsg(mContext, str, chatMsg, i, z);
    }

    public ArrayList<ChatMsg> getAllChatAndSystemMsg(String str, ChatMsg chatMsg, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return GroupMessageDAOImpl.fetchAllChatMsg(mContext, str, chatMsg, i, z);
    }

    private boolean isExistChatMsg(ArrayList<ChatMsg> arrayList) {
        int i;
        for (i = 0; i < arrayList.size(); i = i + 1) {
            int msgType = arrayList.get(i).getMsgType();
            if ((msgType < 0 || msgType > 100) && msgType != 2001) {
                i = ((msgType < 1010 || msgType > 1011) && msgType != 1007) ? i + 1 : 0;
                return true;
            }
            return true;
        }
        return false;
    }

    public ArrayList<ChatMsg> addMsgs(ArrayList<ChatMsg> arrayList, boolean z) {
        if (arrayList != null && arrayList.size() > 0) {
            ChatMsg chatMsg = arrayList.get(arrayList.size() - 1);
            if (chatMsg.getMsgType() == 1003) {
                GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) chatMsg;
                String valueOf = String.valueOf(groupMemberQuitMsg.getContacter());
                String quitBuid = groupMemberQuitMsg.getQuitBuid();
                if (quitBuid != null && quitBuid.equals(AccountManager.getUid(mContext))) {
                    try {
                        LogUtils.d(TAG, "GroupMessageManager quitgroup");
                        GroupInfoDAOImpl.quitGroup(mContext, valueOf);
                        DialogRecordDBManager.getInstance(mContext).delete(1, groupMemberQuitMsg.getContacter());
                        ConversationManagerImpl.getInstance(mContext).deleteConversation(1, valueOf);
                        return arrayList;
                    } catch (Exception e) {
                        LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                        return arrayList;
                    }
                }
            }
            LogUtils.d(TAG, "STAR receive group message ");
            ChatMsg chatMsg2 = arrayList.get(0);
            boolean isStarMessage = chatMsg2.isStarMessage();
            String valueOf2 = String.valueOf(String.valueOf(chatMsg2.getContacter()));
            int i = 0;
            if (!GroupInfoDAOImpl.isExistGroup(mContext, valueOf2)) {
                LogUtils.d(TAG, "STAR table " + valueOf2 + " is not exist");
                i = GroupInfoDAOImpl.createGroup(mContext, valueOf2);
                if (isStarMessage) {
                    GroupInfoDAOImpl.setGroupType(mContext, valueOf2, 2);
                    GroupInfoDAOImpl.setGroupDisturb(mContext, valueOf2, 1);
                }
                GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf2);
            } else {
                LogUtils.d(TAG, "STAR group table " + valueOf2 + " has exist");
            }
            if (i < 0) {
                LogUtils.e(TAG, "STAR create group table error " + i);
                return null;
            } else if (chatMsg2.getContacter() == 0) {
                LogUtils.e(TAG, "STAR group id is 0, return null");
                return null;
            } else {
                ChatObject chatObject = new ChatObject(mContext, chatMsg2.getCategory(), chatMsg2.getContacter(), chatMsg2.getPaid(), 3);
                LogUtils.d(TAG, "STAR receive group message, size is " + arrayList.size());
                if (arrayList != null && arrayList.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= arrayList.size()) {
                            break;
                        }
                        ChatMsg chatMsg3 = arrayList.get(i3);
                        handleGroupSystemMessage(chatMsg3);
                        chatMsg3.setChatType(3);
                        i2 = i3 + 1;
                    }
                    GroupInfoSyncManagerImpl.activeSyncGroup(mContext, valueOf2);
                    ArrayList<Long> addChatMsg = GroupMessageDAOImpl.addChatMsg(mContext, valueOf2, arrayList);
                    LogUtils.d(TAG, "msgs : ret " + addChatMsg + ",groupid: " + valueOf2);
                    LogUtils.d(TAG, "msgs : msgs.size() " + arrayList.size() + ",groupid: " + valueOf2);
                    if (addChatMsg == null) {
                        LogUtils.d(TAG, "STAR add chat msg error. ret " + addChatMsg + ",groupid: " + valueOf2);
                        return null;
                    } else if (addChatMsg.size() == 1 && addChatMsg.get(0).longValue() < 0) {
                        LogUtils.d(TAG, "STAR add chat msg error. return.  ret = " + addChatMsg + ",groupid: " + valueOf2);
                        return arrayList;
                    } else {
                        if (addChatMsg.size() != arrayList.size()) {
                            LogUtils.e(TAG, addChatMsg.size() + " ret.size() -- msgs.size()" + arrayList.size() + ",groupid: " + valueOf2);
                        }
                        boolean isActiveGroup = GroupMessageDAOImpl.isActiveGroup(mContext, valueOf2);
                        boolean z2 = false;
                        if (!isActiveGroup) {
                            z2 = isExistChatMsg(arrayList);
                        }
                        LogUtils.d(TAG, "isActive : " + isActiveGroup + ",isExistChatMsg : " + z2 + ",groupid: " + valueOf2);
                        if (isActiveGroup || z2) {
                            recordLastMsg(valueOf2, chatObject, isStarMessage);
                            if (!isActiveGroup) {
                                GroupInfoDAOImpl.activeGroupState(mContext, valueOf2);
                                return arrayList;
                            }
                            return arrayList;
                        }
                        return arrayList;
                    }
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    private void recordLastMsg(String str, ChatObject chatObject, boolean z) {
        ArrayList<ChatMsg> fetchAllChatMsg;
        int unReadCount = GroupMessageDAOImpl.getUnReadCount(mContext, str);
        LogUtils.e(TAG, str + "   newmsgnum : " + unReadCount);
        if (z) {
            fetchAllChatMsg = GroupMessageDAOImpl.fetchLastChatMsg(mContext, str, null, 1L, true);
        } else {
            fetchAllChatMsg = GroupMessageDAOImpl.fetchAllChatMsg(mContext, str, null, 1L, true);
        }
        if (fetchAllChatMsg != null && fetchAllChatMsg.size() > 0) {
            ChatMsg chatMsg = fetchAllChatMsg.get(0);
            String recommendDescription = chatMsg.getRecommendDescription();
            LogUtils.e(TAG, str + "   content : " + chatMsg.toString());
            int clickState = Utility.getClickState(chatMsg);
            LogUtils.e(TAG, str + "   lastMsg : " + chatMsg.toString());
            ChatMessageDBManager.getInstance(mContext).recordLastMsg(chatObject, recommendDescription, chatMsg.getMsgTime(), unReadCount, 0, clickState, chatMsg.isStarMessage(), null);
        }
    }

    private void handleGroupSystemMessage(ChatMsg chatMsg) {
        if (chatMsg == null) {
            LogUtils.d(TAG, "handleGroupSystemMessage msg is null");
            return;
        }
        LogUtils.d(TAG, "handleGroupSystemMessage msg type is " + chatMsg.getMsgType());
        switch (chatMsg.getMsgType()) {
            case 1001:
                handleAddMemberMsg(chatMsg);
                return;
            case 1002:
                handleJoinGroupMsg(chatMsg);
                return;
            case 1003:
                handleQuitGroupMsg(chatMsg);
                return;
            case 1004:
                handleDeleteMemberMsg(chatMsg);
                return;
            case 1005:
                handleChangeGroupInfoMsg(chatMsg);
                return;
            case 1006:
            default:
                return;
            case 1007:
                handleStartJoin(chatMsg);
                return;
            case 1008:
                handleMasterChange(chatMsg);
                return;
            case 1009:
                handleDeleteGroup(chatMsg);
                return;
            case 1010:
                handlePermitGroup(chatMsg);
                return;
            case 1011:
                handleAllowGroup(chatMsg);
                return;
            case 1012:
                handleMemberNameChange(chatMsg);
                return;
        }
    }

    private void handleStartJoin(ChatMsg chatMsg) {
        LogUtils.d(TAG, "STAR handleStartJoin " + chatMsg.toString());
        GroupStarJoinMsg groupStarJoinMsg = (GroupStarJoinMsg) chatMsg;
        String valueOf = String.valueOf(groupStarJoinMsg.getContacter());
        ArrayList<String> memberBuid = groupStarJoinMsg.getMemberBuid();
        LogUtils.d(TAG, "handlestarJoinGroupMsg " + valueOf + "  " + memberBuid);
        if (memberBuid.contains(AccountManager.getUid(mContext))) {
            GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf);
            GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
            if (chatMsg.isStarMessage()) {
                GroupInfoDAOImpl.setGroupDisturb(mContext, valueOf, 1);
            }
        } else {
            GroupInfoSyncManagerImpl.addSyncGroupMemeber(valueOf, memberBuid);
        }
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupStarJoinMsg.getGroupnum());
        ArrayList<String> pushoutBuid = groupStarJoinMsg.getPushoutBuid();
        if (pushoutBuid != null && pushoutBuid.size() > 0) {
            GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(valueOf, pushoutBuid);
            LogUtils.d(TAG, "handlestarJoinGroupMsg " + pushoutBuid);
            if (pushoutBuid.contains(AccountManager.getUid(mContext))) {
                LogUtils.d(TAG, "handleDeleteMemberMsg " + valueOf + " loginuser was kicked out");
                GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
                GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, 0);
                return;
            }
            GroupInfoDAOImpl.delGroupMember(mContext, valueOf, pushoutBuid);
        }
    }

    private void handleMasterChange(ChatMsg chatMsg) {
        LogUtils.d(TAG, "STAR handleMasterChange " + chatMsg.toString());
        GroupStarMasterUpdateMsg groupStarMasterUpdateMsg = (GroupStarMasterUpdateMsg) chatMsg;
        String valueOf = String.valueOf(groupStarMasterUpdateMsg.getContacter());
        ArrayList<String> addedMemberBuids = groupStarMasterUpdateMsg.getAddedMemberBuids();
        LogUtils.d(TAG, "handleMasterChange " + valueOf + "  " + addedMemberBuids);
        if (addedMemberBuids.contains(AccountManager.getUid(mContext))) {
            GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
            if (chatMsg.isStarMessage()) {
                GroupInfoDAOImpl.setGroupDisturb(mContext, valueOf, 1);
            }
        }
        LogUtils.d(TAG, "STAR updateMasterAsCommon " + GroupInfoDAOImpl.updateMasterAsCommon(mContext, valueOf, 0));
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupStarMasterUpdateMsg.getGroupnum());
        GroupInfoSyncManagerImpl.addSyncGroupMemeber(valueOf, addedMemberBuids);
        ArrayList<String> pushoutBuid = groupStarMasterUpdateMsg.getPushoutBuid();
        if (pushoutBuid != null && pushoutBuid.size() > 0) {
            GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(valueOf, pushoutBuid);
            LogUtils.d(TAG, "handleMasterChange " + pushoutBuid);
            if (pushoutBuid.contains(AccountManager.getUid(mContext))) {
                LogUtils.d(TAG, "handleMasterChange " + valueOf + " loginuser was kicked out");
                GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
                GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, 0);
                return;
            }
            GroupInfoDAOImpl.delGroupMember(mContext, valueOf, pushoutBuid);
        }
    }

    private void handleDeleteGroup(ChatMsg chatMsg) {
        long groupid = ((GroupStarAlertMsg) chatMsg).getGroupid();
        String valueOf = String.valueOf(groupid);
        LogUtils.d(TAG, "STAR handleDeleteGroup " + groupid);
        try {
            GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
            LogUtils.d(TAG, "handleDeleteGroup quitgroup");
            GroupInfoDAOImpl.quitGroup(mContext, valueOf);
            DialogRecordDBManager.getInstance(mContext).delete(1, groupid);
            ConversationManagerImpl.getInstance(mContext).deleteConversation(1, valueOf);
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            arrayList.add(chatMsg);
            ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList);
        } catch (Exception e) {
            LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    private void handlePermitGroup(ChatMsg chatMsg) {
        String valueOf = String.valueOf(((GroupStarAlertMsg) chatMsg).getGroupid());
        LogUtils.d(TAG, "STAR handlePermitGroup " + valueOf + "  ret=" + GroupInfoDAOImpl.setGroupPermit(mContext, valueOf, 1));
    }

    private void handleAllowGroup(ChatMsg chatMsg) {
        String valueOf = String.valueOf(((GroupStarAlertMsg) chatMsg).getGroupid());
        LogUtils.d(TAG, "STAR handlePermitGroup " + valueOf + "  ret=" + GroupInfoDAOImpl.setGroupPermit(mContext, valueOf, 0));
    }

    private void handleAddMemberMsg(ChatMsg chatMsg) {
        String valueOf = String.valueOf(chatMsg.getContacter());
        GroupMemberAddMsg groupMemberAddMsg = (GroupMemberAddMsg) chatMsg;
        ArrayList<String> memberBuids = groupMemberAddMsg.getMemberBuids();
        LogUtils.d(TAG, "handleAddMemberMsg " + valueOf + "  " + memberBuids.toString());
        String operator = groupMemberAddMsg.getOperator();
        LogUtils.d(TAG, "operator : (" + operator + ") and uid : (" + AccountManager.getUid(mContext) + ")");
        if (AccountManager.getUid(mContext).equals(operator)) {
            GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
        }
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberAddMsg.getGroupnum());
        if (memberBuids.contains(AccountManager.getUid(mContext))) {
            GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf);
        } else {
            GroupInfoSyncManagerImpl.addSyncGroupMemeber(valueOf, memberBuids);
        }
    }

    private void handleJoinGroupMsg(ChatMsg chatMsg) {
        GroupMemberJoinMsg groupMemberJoinMsg = (GroupMemberJoinMsg) chatMsg;
        String valueOf = String.valueOf(groupMemberJoinMsg.getContacter());
        String memberBuid = groupMemberJoinMsg.getMemberBuid();
        LogUtils.d(TAG, "handleJoinGroupMsg " + valueOf + "  " + memberBuid);
        if (memberBuid.contains(AccountManager.getUid(mContext))) {
            GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
            if (chatMsg.isStarMessage()) {
                GroupInfoDAOImpl.setGroupDisturb(mContext, valueOf, 1);
            }
        }
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberJoinMsg.getGroupnum());
        ArrayList arrayList = new ArrayList();
        arrayList.add(memberBuid);
        GroupInfoSyncManagerImpl.addSyncGroupMemeber(valueOf, arrayList);
    }

    private void handleDeleteMemberMsg(ChatMsg chatMsg) {
        GroupMemberDelMsg groupMemberDelMsg = (GroupMemberDelMsg) chatMsg;
        String valueOf = String.valueOf(groupMemberDelMsg.getContacter());
        ArrayList<String> memberBuids = groupMemberDelMsg.getMemberBuids();
        LogUtils.d(TAG, "handleDeleteMemberMsg " + valueOf + "  " + memberBuids.toString());
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberDelMsg.getGroupnum());
        GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(valueOf, memberBuids);
        GroupInfoDAOImpl.delGroupMember(mContext, valueOf, memberBuids);
        if (memberBuids.contains(AccountManager.getUid(mContext))) {
            if (chatMsg.isStarMessage()) {
                try {
                    GroupInfoDAOImpl.quitGroup(mContext, valueOf);
                    LogUtils.d(TAG, "handleDeleteMemberMsg stargroup " + valueOf);
                    DialogRecordDBManager.getInstance(mContext).delete(1, groupMemberDelMsg.getContacter());
                    ConversationManagerImpl.getInstance(mContext).deleteConversation(1, valueOf);
                } catch (Exception e) {
                    LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                }
                ArrayList<ChatMsg> arrayList = new ArrayList<>();
                arrayList.add(chatMsg);
                ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList);
                return;
            }
            LogUtils.d(TAG, "handleDeleteMemberMsg " + valueOf + " loginuser was kicked out");
            GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
            GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, 0);
        }
    }

    private void handleQuitGroupMsg(ChatMsg chatMsg) {
        LogUtils.d(TAG, "STAR handleQuitGroupMsg");
        GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) chatMsg;
        String valueOf = String.valueOf(groupMemberQuitMsg.getContacter());
        String quitBuid = groupMemberQuitMsg.getQuitBuid();
        String newMaster = groupMemberQuitMsg.getNewMaster();
        if (quitBuid != null && quitBuid.equals(AccountManager.getUid(mContext))) {
            try {
                GroupInfoDAOImpl.quitGroup(mContext, valueOf);
                LogUtils.d(TAG, "handleQuitGroupMsg quitgroup");
                DialogRecordDBManager.getInstance(mContext).delete(1, groupMemberQuitMsg.getContacter());
                ConversationManagerImpl.getInstance(mContext).deleteConversation(1, valueOf);
                return;
            } catch (Exception e) {
                LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(quitBuid);
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberQuitMsg.getGroupnum());
        GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(valueOf, arrayList);
        LogUtils.d(TAG, "handleQuitGroupMsg " + valueOf + "  " + arrayList.toString());
        GroupInfoDAOImpl.delGroupMember(mContext, valueOf, arrayList);
        if (newMaster != null && !"".equals(newMaster.trim())) {
            GroupInfoDAOImpl.updateGroupMemberRole(mContext, valueOf, newMaster, 1);
        }
    }

    private void handleChangeGroupInfoMsg(ChatMsg chatMsg) {
        GroupInfoChangeMsg groupInfoChangeMsg = (GroupInfoChangeMsg) chatMsg;
        String valueOf = String.valueOf(chatMsg.getContacter());
        if (groupInfoChangeMsg.getGroupname() != null) {
            GroupInfoDAOImpl.modifyGroupName(mContext, valueOf, groupInfoChangeMsg.getGroupname());
            ConversationManagerImpl.getInstance(mContext).updateConversationName(groupInfoChangeMsg.getGroupname(), 1, valueOf);
        }
    }

    private void handleMemberNameChange(ChatMsg chatMsg) {
        GroupMemberNameChangeMsg groupMemberNameChangeMsg = (GroupMemberNameChangeMsg) chatMsg;
        String valueOf = String.valueOf(chatMsg.getContacter());
        String memberChangedid = groupMemberNameChangeMsg.memberChangedid();
        int updateMemberNickName = GroupInfoDAOImpl.updateMemberNickName(mContext, valueOf, memberChangedid, groupMemberNameChangeMsg.getNickname());
        if (updateMemberNickName == 0) {
            LogUtils.d(TAG, "HHHandleMemberNameChange to --- update member nickname " + valueOf + " " + memberChangedid);
            GroupInfoSyncManagerImpl.syncAllMembers(mContext, valueOf);
        }
        LogUtils.d(TAG, "HHHandleMemberNameChange update member nickname " + updateMemberNickName);
    }
}
