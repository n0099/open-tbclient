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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GroupMessageManagerImpl {
    public static final String TAG = "GroupMessageManagerImpl";
    public static Context mContext;
    public static GroupMessageManagerImpl mInstance;
    public static Object mSyncLock = new Object();

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

    private void handleAddMemberMsg(ChatMsg chatMsg) {
        String valueOf = String.valueOf(chatMsg.getContacter());
        GroupMemberAddMsg groupMemberAddMsg = (GroupMemberAddMsg) chatMsg;
        ArrayList<String> memberBuids = groupMemberAddMsg.getMemberBuids();
        String str = TAG;
        LogUtils.d(str, "handleAddMemberMsg " + valueOf + GlideException.IndentedAppendable.INDENT + memberBuids.toString());
        String operator = groupMemberAddMsg.getOperator();
        String str2 = TAG;
        LogUtils.d(str2, "operator : (" + operator + ") and uid : (" + AccountManager.getUid(mContext) + SmallTailInfo.EMOTION_SUFFIX);
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

    private void handleAllowGroup(ChatMsg chatMsg) {
        String valueOf = String.valueOf(((GroupStarAlertMsg) chatMsg).getGroupid());
        int groupPermit = GroupInfoDAOImpl.setGroupPermit(mContext, valueOf, 0);
        String str = TAG;
        LogUtils.d(str, "STAR handlePermitGroup " + valueOf + "  ret=" + groupPermit);
    }

    private void handleChangeGroupInfoMsg(ChatMsg chatMsg) {
        GroupInfoChangeMsg groupInfoChangeMsg = (GroupInfoChangeMsg) chatMsg;
        String valueOf = String.valueOf(chatMsg.getContacter());
        if (groupInfoChangeMsg.getGroupname() != null) {
            GroupInfoDAOImpl.modifyGroupName(mContext, valueOf, groupInfoChangeMsg.getGroupname());
            ConversationManagerImpl.getInstance(mContext).updateConversationName(groupInfoChangeMsg.getGroupname(), 1, valueOf);
        }
    }

    private void handleDeleteGroup(ChatMsg chatMsg) {
        long groupid = ((GroupStarAlertMsg) chatMsg).getGroupid();
        String valueOf = String.valueOf(groupid);
        String str = TAG;
        LogUtils.d(str, "STAR handleDeleteGroup " + groupid);
        try {
            GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
            LogUtils.d(TAG, "handleDeleteGroup quitgroup");
            GroupInfoDAOImpl.quitGroup(mContext, valueOf);
            DialogRecordDBManager.getInstance(mContext).delete(1, groupid);
            ConversationManagerImpl.getInstance(mContext).deleteConversation(1, valueOf);
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            arrayList.add(chatMsg);
            ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList);
        } catch (Exception e2) {
            LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    private void handleDeleteMemberMsg(ChatMsg chatMsg) {
        GroupMemberDelMsg groupMemberDelMsg = (GroupMemberDelMsg) chatMsg;
        String valueOf = String.valueOf(groupMemberDelMsg.getContacter());
        ArrayList<String> memberBuids = groupMemberDelMsg.getMemberBuids();
        String str = TAG;
        LogUtils.d(str, "handleDeleteMemberMsg " + valueOf + GlideException.IndentedAppendable.INDENT + memberBuids.toString());
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberDelMsg.getGroupnum());
        GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(valueOf, memberBuids);
        GroupInfoDAOImpl.delGroupMember(mContext, valueOf, memberBuids);
        if (memberBuids.contains(AccountManager.getUid(mContext))) {
            if (chatMsg.isStarMessage()) {
                try {
                    GroupInfoDAOImpl.quitGroup(mContext, valueOf);
                    String str2 = TAG;
                    LogUtils.d(str2, "handleDeleteMemberMsg stargroup " + valueOf);
                    DialogRecordDBManager.getInstance(mContext).delete(1, groupMemberDelMsg.getContacter());
                    ConversationManagerImpl.getInstance(mContext).deleteConversation(1, valueOf);
                } catch (Exception e2) {
                    LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                }
                ArrayList<ChatMsg> arrayList = new ArrayList<>();
                arrayList.add(chatMsg);
                ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList);
                return;
            }
            String str3 = TAG;
            LogUtils.d(str3, "handleDeleteMemberMsg " + valueOf + " loginuser was kicked out");
            GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
            GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, 0);
        }
    }

    private void handleGroupSystemMessage(ChatMsg chatMsg) {
        if (chatMsg == null) {
            LogUtils.d(TAG, "handleGroupSystemMessage msg is null");
            return;
        }
        String str = TAG;
        LogUtils.d(str, "handleGroupSystemMessage msg type is " + chatMsg.getMsgType());
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

    private void handleJoinGroupMsg(ChatMsg chatMsg) {
        GroupMemberJoinMsg groupMemberJoinMsg = (GroupMemberJoinMsg) chatMsg;
        String valueOf = String.valueOf(groupMemberJoinMsg.getContacter());
        String memberBuid = groupMemberJoinMsg.getMemberBuid();
        String str = TAG;
        LogUtils.d(str, "handleJoinGroupMsg " + valueOf + GlideException.IndentedAppendable.INDENT + memberBuid);
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

    private void handleMasterChange(ChatMsg chatMsg) {
        String str = TAG;
        LogUtils.d(str, "STAR handleMasterChange " + chatMsg.toString());
        GroupStarMasterUpdateMsg groupStarMasterUpdateMsg = (GroupStarMasterUpdateMsg) chatMsg;
        String valueOf = String.valueOf(groupStarMasterUpdateMsg.getContacter());
        ArrayList<String> addedMemberBuids = groupStarMasterUpdateMsg.getAddedMemberBuids();
        String str2 = TAG;
        LogUtils.d(str2, "handleMasterChange " + valueOf + GlideException.IndentedAppendable.INDENT + addedMemberBuids);
        if (addedMemberBuids.contains(AccountManager.getUid(mContext))) {
            GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
            if (chatMsg.isStarMessage()) {
                GroupInfoDAOImpl.setGroupDisturb(mContext, valueOf, 1);
            }
        }
        int updateMasterAsCommon = GroupInfoDAOImpl.updateMasterAsCommon(mContext, valueOf, 0);
        String str3 = TAG;
        LogUtils.d(str3, "STAR updateMasterAsCommon " + updateMasterAsCommon);
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupStarMasterUpdateMsg.getGroupnum());
        GroupInfoSyncManagerImpl.addSyncGroupMemeber(valueOf, addedMemberBuids);
        ArrayList<String> pushoutBuid = groupStarMasterUpdateMsg.getPushoutBuid();
        if (pushoutBuid == null || pushoutBuid.size() <= 0) {
            return;
        }
        GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(valueOf, pushoutBuid);
        String str4 = TAG;
        LogUtils.d(str4, "handleMasterChange " + pushoutBuid);
        if (pushoutBuid.contains(AccountManager.getUid(mContext))) {
            String str5 = TAG;
            LogUtils.d(str5, "handleMasterChange " + valueOf + " loginuser was kicked out");
            GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
            GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, 0);
            return;
        }
        GroupInfoDAOImpl.delGroupMember(mContext, valueOf, pushoutBuid);
    }

    private void handleMemberNameChange(ChatMsg chatMsg) {
        GroupMemberNameChangeMsg groupMemberNameChangeMsg = (GroupMemberNameChangeMsg) chatMsg;
        String valueOf = String.valueOf(chatMsg.getContacter());
        String memberChangedid = groupMemberNameChangeMsg.memberChangedid();
        int updateMemberNickName = GroupInfoDAOImpl.updateMemberNickName(mContext, valueOf, memberChangedid, groupMemberNameChangeMsg.getNickname());
        if (updateMemberNickName == 0) {
            String str = TAG;
            LogUtils.d(str, "HHHandleMemberNameChange to --- update member nickname " + valueOf + " " + memberChangedid);
            GroupInfoSyncManagerImpl.syncAllMembers(mContext, valueOf);
        }
        String str2 = TAG;
        LogUtils.d(str2, "HHHandleMemberNameChange update member nickname " + updateMemberNickName);
    }

    private void handlePermitGroup(ChatMsg chatMsg) {
        String valueOf = String.valueOf(((GroupStarAlertMsg) chatMsg).getGroupid());
        int groupPermit = GroupInfoDAOImpl.setGroupPermit(mContext, valueOf, 1);
        String str = TAG;
        LogUtils.d(str, "STAR handlePermitGroup " + valueOf + "  ret=" + groupPermit);
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
            } catch (Exception e2) {
                LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(quitBuid);
        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberQuitMsg.getGroupnum());
        GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(valueOf, arrayList);
        String str = TAG;
        LogUtils.d(str, "handleQuitGroupMsg " + valueOf + GlideException.IndentedAppendable.INDENT + arrayList.toString());
        GroupInfoDAOImpl.delGroupMember(mContext, valueOf, arrayList);
        if (newMaster == null || "".equals(newMaster.trim())) {
            return;
        }
        GroupInfoDAOImpl.updateGroupMemberRole(mContext, valueOf, newMaster, 1);
    }

    private void handleStartJoin(ChatMsg chatMsg) {
        String str = TAG;
        LogUtils.d(str, "STAR handleStartJoin " + chatMsg.toString());
        GroupStarJoinMsg groupStarJoinMsg = (GroupStarJoinMsg) chatMsg;
        String valueOf = String.valueOf(groupStarJoinMsg.getContacter());
        ArrayList<String> memberBuid = groupStarJoinMsg.getMemberBuid();
        String str2 = TAG;
        LogUtils.d(str2, "handlestarJoinGroupMsg " + valueOf + GlideException.IndentedAppendable.INDENT + memberBuid);
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
        if (pushoutBuid == null || pushoutBuid.size() <= 0) {
            return;
        }
        GroupInfoSyncManagerImpl.deleteSyncGroupMemeber(valueOf, pushoutBuid);
        String str3 = TAG;
        LogUtils.d(str3, "handlestarJoinGroupMsg " + pushoutBuid);
        if (pushoutBuid.contains(AccountManager.getUid(mContext))) {
            String str4 = TAG;
            LogUtils.d(str4, "handleDeleteMemberMsg " + valueOf + " loginuser was kicked out");
            GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
            GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, 0);
            return;
        }
        GroupInfoDAOImpl.delGroupMember(mContext, valueOf, pushoutBuid);
    }

    private boolean isExistChatMsg(ArrayList<ChatMsg> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int msgType = arrayList.get(i).getMsgType();
            if ((msgType >= 0 && msgType <= 100) || msgType == 2001) {
                return true;
            }
            if ((msgType >= 1010 && msgType <= 1011) || msgType == 1007) {
                return true;
            }
        }
        return false;
    }

    private void recordLastMsg(String str, ChatObject chatObject, boolean z) {
        ArrayList<ChatMsg> fetchAllChatMsg;
        int unReadCount = GroupMessageDAOImpl.getUnReadCount(mContext, str);
        String str2 = TAG;
        LogUtils.e(str2, str + "   newmsgnum : " + unReadCount);
        if (z) {
            fetchAllChatMsg = GroupMessageDAOImpl.fetchLastChatMsg(mContext, str, null, 1L, true);
        } else {
            fetchAllChatMsg = GroupMessageDAOImpl.fetchAllChatMsg(mContext, str, null, 1L, true);
        }
        if (fetchAllChatMsg == null || fetchAllChatMsg.size() <= 0) {
            return;
        }
        ChatMsg chatMsg = fetchAllChatMsg.get(0);
        String recommendDescription = chatMsg.getRecommendDescription();
        String str3 = TAG;
        LogUtils.e(str3, str + "   content : " + chatMsg.toString());
        int clickState = Utility.getClickState(chatMsg);
        String str4 = TAG;
        LogUtils.e(str4, str + "   lastMsg : " + chatMsg.toString());
        ChatMessageDBManager.getInstance(mContext).recordLastMsg(chatObject, recommendDescription, chatMsg.getMsgTime(), unReadCount, 0, clickState, chatMsg.isStarMessage(), null);
    }

    public ArrayList<ChatMsg> addMsgs(ArrayList<ChatMsg> arrayList, boolean z) {
        int i;
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
                    } catch (Exception e2) {
                        LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                    }
                    return arrayList;
                }
            }
            LogUtils.d(TAG, "STAR receive group message ");
            ChatMsg chatMsg2 = arrayList.get(0);
            boolean isStarMessage = chatMsg2.isStarMessage();
            String valueOf2 = String.valueOf(String.valueOf(chatMsg2.getContacter()));
            if (!GroupInfoDAOImpl.isExistGroup(mContext, valueOf2)) {
                String str = TAG;
                LogUtils.d(str, "STAR table " + valueOf2 + " is not exist");
                i = GroupInfoDAOImpl.createGroup(mContext, valueOf2);
                if (isStarMessage) {
                    GroupInfoDAOImpl.setGroupType(mContext, valueOf2, 2);
                    GroupInfoDAOImpl.setGroupDisturb(mContext, valueOf2, 1);
                }
                GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf2);
            } else {
                String str2 = TAG;
                LogUtils.d(str2, "STAR group table " + valueOf2 + " has exist");
                i = 0;
            }
            if (i < 0) {
                String str3 = TAG;
                LogUtils.e(str3, "STAR create group table error " + i);
                return null;
            } else if (chatMsg2.getContacter() == 0) {
                LogUtils.e(TAG, "STAR group id is 0, return null");
                return null;
            } else {
                ChatObject chatObject = new ChatObject(mContext, chatMsg2.getCategory(), chatMsg2.getContacter(), chatMsg2.getPaid(), 3);
                String str4 = TAG;
                LogUtils.d(str4, "STAR receive group message, size is " + arrayList.size());
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ChatMsg chatMsg3 = arrayList.get(i2);
                        handleGroupSystemMessage(chatMsg3);
                        chatMsg3.setChatType(3);
                    }
                    GroupInfoSyncManagerImpl.activeSyncGroup(mContext, valueOf2);
                    ArrayList<Long> addChatMsg = GroupMessageDAOImpl.addChatMsg(mContext, valueOf2, arrayList);
                    String str5 = TAG;
                    LogUtils.d(str5, "msgs : ret " + addChatMsg + ",groupid: " + valueOf2);
                    String str6 = TAG;
                    LogUtils.d(str6, "msgs : msgs.size() " + arrayList.size() + ",groupid: " + valueOf2);
                    if (addChatMsg == null) {
                        String str7 = TAG;
                        LogUtils.d(str7, "STAR add chat msg error. ret " + addChatMsg + ",groupid: " + valueOf2);
                        return null;
                    } else if (addChatMsg.size() == 1 && addChatMsg.get(0).longValue() < 0) {
                        String str8 = TAG;
                        LogUtils.d(str8, "STAR add chat msg error. return.  ret = " + addChatMsg + ",groupid: " + valueOf2);
                        return arrayList;
                    } else {
                        if (addChatMsg.size() != arrayList.size()) {
                            String str9 = TAG;
                            LogUtils.e(str9, addChatMsg.size() + " ret.size() -- msgs.size()" + arrayList.size() + ",groupid: " + valueOf2);
                        }
                        boolean isActiveGroup = GroupMessageDAOImpl.isActiveGroup(mContext, valueOf2);
                        boolean isExistChatMsg = isActiveGroup ? false : isExistChatMsg(arrayList);
                        String str10 = TAG;
                        LogUtils.d(str10, "isActive : " + isActiveGroup + ",isExistChatMsg : " + isExistChatMsg + ",groupid: " + valueOf2);
                        if (isActiveGroup || isExistChatMsg) {
                            recordLastMsg(valueOf2, chatObject, isStarMessage);
                            if (!isActiveGroup) {
                                GroupInfoDAOImpl.activeGroupState(mContext, valueOf2);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<ChatMsg> getAllChatAndSystemMsg(String str, ChatMsg chatMsg, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return GroupMessageDAOImpl.fetchAllChatMsg(mContext, str, chatMsg, i, z);
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
}
