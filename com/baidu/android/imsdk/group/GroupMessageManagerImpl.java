package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansInfoUpdateMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupDisbandMsg;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class GroupMessageManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GroupMessageManagerImpl";
    public static Context mContext;
    public static GroupMessageManagerImpl mInstance;
    public static Object mSyncLock;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(888804109, "Lcom/baidu/android/imsdk/group/GroupMessageManagerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(888804109, "Lcom/baidu/android/imsdk/group/GroupMessageManagerImpl;");
                return;
            }
        }
        mSyncLock = new Object();
    }

    public GroupMessageManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static GroupMessageManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
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
        return (GroupMessageManagerImpl) invokeL.objValue;
    }

    private void handleAllowGroup(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, chatMsg) == null) {
            String valueOf = String.valueOf(((GroupStarAlertMsg) chatMsg).getGroupid());
            int groupPermit = GroupInfoDAOImpl.setGroupPermit(mContext, valueOf, 0);
            String str = TAG;
            LogUtils.d(str, "STAR handlePermitGroup " + valueOf + "  ret=" + groupPermit);
        }
    }

    private void handleChangeGroupInfoMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, chatMsg) == null) {
            GroupInfoChangeMsg groupInfoChangeMsg = (GroupInfoChangeMsg) chatMsg;
            String valueOf = String.valueOf(chatMsg.getContacter());
            if (groupInfoChangeMsg.getGroupname() != null) {
                GroupInfoDAOImpl.modifyGroupName(mContext, valueOf, groupInfoChangeMsg.getGroupname());
                ConversationManagerImpl.getInstance(mContext).updateConversationName(groupInfoChangeMsg.getGroupname(), 1, valueOf);
            }
        }
    }

    private void handlePermitGroup(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, chatMsg) == null) {
            String valueOf = String.valueOf(((GroupStarAlertMsg) chatMsg).getGroupid());
            int groupPermit = GroupInfoDAOImpl.setGroupPermit(mContext, valueOf, 1);
            String str = TAG;
            LogUtils.d(str, "STAR handlePermitGroup " + valueOf + "  ret=" + groupPermit);
        }
    }

    private void quitGroupByGroupId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65554, this, j) == null) {
            String valueOf = String.valueOf(j);
            GroupInfoDAOImpl.quitGroup(mContext, valueOf);
            String str = TAG;
            LogUtils.d(str, "quitGroupByGroupId groupID = " + j);
            DialogRecordDBManager.getInstance(mContext).delete(1, j);
            ConversationManagerImpl.getInstance(mContext).deleteConversation(1, valueOf);
        }
    }

    private void handleAddMemberMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, chatMsg) == null) {
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
                GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf, chatMsg.getGroupType());
            } else {
                GroupInfoSyncManagerImpl.addSyncGroupMemeber(valueOf, memberBuids);
            }
        }
    }

    private void handleDeleteMemberMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, chatMsg) == null) {
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
                        quitGroupByGroupId(groupMemberDelMsg.getContacter());
                    } catch (Exception e) {
                        LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                    }
                    ArrayList<ChatMsg> arrayList = new ArrayList<>();
                    arrayList.add(chatMsg);
                    ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList);
                    return;
                }
                String str2 = TAG;
                LogUtils.d(str2, "handleDeleteMemberMsg " + valueOf + " loginuser was kicked out");
                GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
                GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, 0);
            }
        }
    }

    private void handleQuitGroupMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, chatMsg) == null) {
            LogUtils.d(TAG, "STAR handleQuitGroupMsg");
            GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) chatMsg;
            String valueOf = String.valueOf(groupMemberQuitMsg.getContacter());
            String quitBuid = groupMemberQuitMsg.getQuitBuid();
            String newMaster = groupMemberQuitMsg.getNewMaster();
            if (quitBuid != null && quitBuid.equals(AccountManager.getUid(mContext))) {
                try {
                    quitGroupByGroupId(groupMemberQuitMsg.getContacter());
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
            String str = TAG;
            LogUtils.d(str, "handleQuitGroupMsg " + valueOf + GlideException.IndentedAppendable.INDENT + arrayList.toString());
            GroupInfoDAOImpl.delGroupMember(mContext, valueOf, arrayList);
            if (newMaster != null && !"".equals(newMaster.trim())) {
                GroupInfoDAOImpl.updateGroupMemberRole(mContext, valueOf, newMaster, 1);
            }
        }
    }

    private void handleDeleteGroup(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, chatMsg) == null) {
            long groupid = ((GroupStarAlertMsg) chatMsg).getGroupid();
            String valueOf = String.valueOf(groupid);
            String str = TAG;
            LogUtils.d(str, "STAR handleDeleteGroup " + groupid);
            try {
                GroupInfoDAOImpl.deletedGroupMember(mContext, valueOf);
                LogUtils.d(TAG, "handleDeleteGroup quitgroup");
                quitGroupByGroupId(groupid);
                ArrayList<ChatMsg> arrayList = new ArrayList<>();
                arrayList.add(chatMsg);
                ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList);
            } catch (Exception e) {
                LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
    }

    private void handleGroupSystemMessage(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, chatMsg) == null) {
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
    }

    private void handleJoinGroupMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, chatMsg) == null) {
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
    }

    public boolean isValidGroup(ChatMsg chatMsg) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, chatMsg)) == null) {
            int msgType = chatMsg.getMsgType();
            if (msgType != 1003 && msgType != 1013 && msgType != 1004) {
                return true;
            }
            long contacter = chatMsg.getContacter();
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(contacter));
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
            if (groupInfo != null && groupInfo.size() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (msgType == 1003) {
                if (TextUtils.equals(((GroupMemberQuitMsg) chatMsg).getQuitBuid(), AccountManager.getUid(mContext))) {
                    if (!z) {
                        quitGroupByGroupId(contacter);
                    }
                    return false;
                }
            } else if (msgType == 1013) {
                if (!z) {
                    quitGroupByGroupId(contacter);
                }
                return false;
            } else if (msgType == 1004 && ((GroupMemberDelMsg) chatMsg).getMemberBuids().contains(AccountManager.getUid(mContext))) {
                if (!z) {
                    quitGroupByGroupId(contacter);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void handleDisbandMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, chatMsg) == null) {
            GroupDisbandMsg groupDisbandMsg = (GroupDisbandMsg) chatMsg;
            try {
                LogUtils.d(TAG, "GroupMessageManager GroupDisbandMsg");
                quitGroupByGroupId(groupDisbandMsg.getContacter());
                ArrayList<ChatMsg> arrayList = new ArrayList<>();
                arrayList.add(chatMsg);
                ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList);
            } catch (Exception e) {
                LogUtils.d(TAG, "handleDisbandMsg exception, this is normal for device sync logic");
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
    }

    private void handleMemberNameChange(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, chatMsg) == null) {
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
    }

    private boolean isExistChatMsg(ArrayList<ChatMsg> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, arrayList)) == null) {
            for (int i = 0; i < arrayList.size(); i++) {
                int msgType = arrayList.get(i).getMsgType();
                int groupType = arrayList.get(i).getGroupType();
                if ((msgType >= 0 && msgType <= 100) || msgType == 2001) {
                    return true;
                }
                if ((msgType >= 1010 && msgType <= 1011) || msgType == 1007) {
                    return true;
                }
                if (msgType == 1005 && groupType == 3) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void handleFansGroupSystemMessage(ArrayList<ChatMsg> arrayList) {
        long j;
        Iterator<ChatMsg> it;
        ArrayList<String> arrayList2;
        long max;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                String valueOf = String.valueOf(arrayList.get(0).getContacter());
                ArrayList<String> arrayList3 = new ArrayList<>();
                arrayList3.add(valueOf);
                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList3);
                long j2 = Long.MAX_VALUE;
                if (groupInfo != null && groupInfo.size() > 0) {
                    GroupInfo groupInfo2 = groupInfo.get(0);
                    j2 = groupInfo2.getMembersVersion();
                    j = groupInfo2.getInfoVersion();
                } else {
                    j = Long.MAX_VALUE;
                }
                Iterator<ChatMsg> it2 = arrayList.iterator();
                long j3 = 0;
                long j4 = 0;
                while (it2.hasNext()) {
                    ChatMsg next = it2.next();
                    next.setChatType(57);
                    int msgType = next.getMsgType();
                    switch (msgType) {
                        case 1002:
                            it = it2;
                            arrayList2 = arrayList3;
                            GroupMemberJoinMsg groupMemberJoinMsg = (GroupMemberJoinMsg) next;
                            if (TextUtils.equals(groupMemberJoinMsg.getMemberBuid(), AccountManager.getUid(mContext))) {
                                GroupInfoDAOImpl.setGroupState(mContext, valueOf, 0);
                            }
                            if (groupMemberJoinMsg.getMemberVersion() > j2) {
                                GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberJoinMsg.getGroupnum());
                            }
                            GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
                            j4 = Math.max(groupMemberJoinMsg.getMemberVersion(), j4);
                            continue;
                            it2 = it;
                            arrayList3 = arrayList2;
                        case 1003:
                            it = it2;
                            arrayList2 = arrayList3;
                            GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) next;
                            String quitBuid = groupMemberQuitMsg.getQuitBuid();
                            if (TextUtils.equals(quitBuid, AccountManager.getUid(mContext))) {
                                quitGroupByGroupId(groupMemberQuitMsg.getContacter());
                                break;
                            } else {
                                j4 = Math.max(groupMemberQuitMsg.getMemberVersion(), j4);
                                if (groupMemberQuitMsg.getMemberVersion() > j2) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(quitBuid);
                                    GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberQuitMsg.getGroupnum());
                                    GroupInfoDAOImpl.delGroupMember(mContext, valueOf, arrayList4);
                                }
                                GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
                                break;
                            }
                        case 1004:
                            it = it2;
                            arrayList2 = arrayList3;
                            GroupMemberDelMsg groupMemberDelMsg = (GroupMemberDelMsg) next;
                            ArrayList<String> memberBuids = groupMemberDelMsg.getMemberBuids();
                            if (memberBuids.contains(AccountManager.getUid(mContext))) {
                                quitGroupByGroupId(groupMemberDelMsg.getContacter());
                                ArrayList<ChatMsg> arrayList5 = new ArrayList<>();
                                arrayList5.add(next);
                                ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList5);
                                break;
                            } else {
                                if (groupMemberDelMsg.getMemberVersion() > j2) {
                                    GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberDelMsg.getGroupnum());
                                    GroupInfoDAOImpl.delGroupMember(mContext, valueOf, memberBuids);
                                }
                                max = Math.max(groupMemberDelMsg.getMemberVersion(), j4);
                                GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
                                j4 = max;
                                break;
                            }
                        case 1005:
                            it = it2;
                            arrayList2 = arrayList3;
                            GroupInfoChangeMsg groupInfoChangeMsg = (GroupInfoChangeMsg) next;
                            if (groupInfoChangeMsg.getInfoVersion() > j) {
                                GroupInfoDAOImpl.modifyGroupName(mContext, valueOf, groupInfoChangeMsg.getGroupname());
                                ConversationManagerImpl.getInstance(mContext).updateConversationName(groupInfoChangeMsg.getGroupname(), 1, valueOf);
                            }
                            j3 = Math.max(groupInfoChangeMsg.getInfoVersion(), j3);
                            break;
                        default:
                            switch (msgType) {
                                case 1012:
                                    GroupMemberNameChangeMsg groupMemberNameChangeMsg = (GroupMemberNameChangeMsg) next;
                                    if (groupMemberNameChangeMsg.getMemberVersion() > j2) {
                                        String memberChangedid = groupMemberNameChangeMsg.memberChangedid();
                                        it = it2;
                                        GroupInfoDAOImpl.updateMemberNickName(mContext, valueOf, memberChangedid, groupMemberNameChangeMsg.getNickname());
                                        arrayList2 = arrayList3;
                                        ChatSession chatSession = ChatMsgManager.getChatSession(mContext, 1, next.getContacter());
                                        if (chatSession != null && TextUtils.equals(memberChangedid, String.valueOf(chatSession.getLastMsgUid()))) {
                                            chatSession.setLastMsgName(groupMemberNameChangeMsg.getNickname());
                                            ChatMessageDBManager.getInstance(mContext).updateChatSession(1, chatSession);
                                        }
                                    } else {
                                        it = it2;
                                        arrayList2 = arrayList3;
                                    }
                                    max = Math.max(groupMemberNameChangeMsg.getMemberVersion(), j4);
                                    j4 = max;
                                    break;
                                case 1013:
                                    handleDisbandMsg(next);
                                    it = it2;
                                    arrayList2 = arrayList3;
                                    break;
                                case 1014:
                                    j3 = Math.max(((FansInfoUpdateMsg) next).getInfoVersion(), j3);
                                    it = it2;
                                    arrayList2 = arrayList3;
                                    continue;
                                default:
                                    it = it2;
                                    arrayList2 = arrayList3;
                                    break;
                            }
                            it2 = it;
                            arrayList3 = arrayList2;
                            break;
                    }
                    it2 = it;
                    arrayList3 = arrayList2;
                }
                ArrayList<String> arrayList6 = arrayList3;
                if (j < j3) {
                    LogUtils.d(TAG, "getFansGroupInfo sInfoVersion = " + j + " maxInfoVersion = " + j3);
                    GroupManagerImpl.getInstance(mContext).getFansGroupInfo(arrayList6, true, null);
                }
                if (j2 < j4) {
                    LogUtils.d(TAG, "getFansGroupMember sMemberVersion = " + j2 + " maxMemberVersion = " + j4);
                    GroupManagerImpl.getInstance(mContext).getFansGroupMember(valueOf, null, true, null);
                    return;
                }
                return;
            }
            LogUtils.d(TAG, "handleGroupSystemMessage msg is null");
        }
    }

    private void handleMasterChange(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, chatMsg) == null) {
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
            if (pushoutBuid != null && pushoutBuid.size() > 0) {
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
        }
    }

    private void handleStartJoin(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, chatMsg) == null) {
            String str = TAG;
            LogUtils.d(str, "STAR handleStartJoin " + chatMsg.toString());
            GroupStarJoinMsg groupStarJoinMsg = (GroupStarJoinMsg) chatMsg;
            String valueOf = String.valueOf(groupStarJoinMsg.getContacter());
            ArrayList<String> memberBuid = groupStarJoinMsg.getMemberBuid();
            String str2 = TAG;
            LogUtils.d(str2, "handlestarJoinGroupMsg " + valueOf + GlideException.IndentedAppendable.INDENT + memberBuid);
            if (memberBuid.contains(AccountManager.getUid(mContext))) {
                GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf, chatMsg.getGroupType());
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
        }
    }

    private void recordLastMsg(String str, ChatObject chatObject, boolean z) {
        ArrayList<ChatMsg> fetchAllChatMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65555, this, str, chatObject, z) == null) {
            int unReadCount = GroupMessageDAOImpl.getUnReadCount(mContext, str);
            String str2 = TAG;
            LogUtils.e(str2, str + "   newmsgnum : " + unReadCount);
            if (z) {
                fetchAllChatMsg = GroupMessageDAOImpl.fetchLastChatMsg(mContext, str, null, 1L, true);
            } else {
                fetchAllChatMsg = GroupMessageDAOImpl.fetchAllChatMsg(mContext, str, null, 1L, true);
            }
            if (fetchAllChatMsg != null && fetchAllChatMsg.size() > 0) {
                ChatMsg chatMsg = fetchAllChatMsg.get(0);
                String recommendDescription = chatMsg.getRecommendDescription();
                String str3 = TAG;
                LogUtils.e(str3, str + "   content : " + chatMsg.toString());
                int clickState = Utility.getClickState(chatMsg);
                String str4 = TAG;
                LogUtils.e(str4, str + "   lastMsg : " + chatMsg.toString());
                ChatMessageDBManager.getInstance(mContext).recordLastMsg(chatObject, recommendDescription, chatMsg.getMsgTime(), unReadCount, 0, clickState, chatMsg.isStarMessage(), null, chatMsg.getSenderUid());
            }
        }
    }

    public ArrayList<ChatMsg> addMsgs(ArrayList<ChatMsg> arrayList, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, arrayList, z)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                ChatMsg chatMsg = arrayList.get(arrayList.size() - 1);
                if (chatMsg.getMsgType() == 1003) {
                    GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) chatMsg;
                    String quitBuid = groupMemberQuitMsg.getQuitBuid();
                    if (quitBuid != null && quitBuid.equals(AccountManager.getUid(mContext))) {
                        try {
                            quitGroupByGroupId(groupMemberQuitMsg.getContacter());
                        } catch (Exception e) {
                            LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                        }
                        return arrayList;
                    }
                } else if (chatMsg.getMsgType() == 1013) {
                    handleDisbandMsg(chatMsg);
                    return arrayList;
                }
                LogUtils.d(TAG, "STAR receive group message ");
                boolean z2 = false;
                ChatMsg chatMsg2 = arrayList.get(0);
                boolean isStarMessage = chatMsg2.isStarMessage();
                String valueOf = String.valueOf(chatMsg2.getContacter());
                if (!GroupInfoDAOImpl.isExistGroup(mContext, valueOf)) {
                    String str = TAG;
                    LogUtils.d(str, "STAR table " + valueOf + " is not exist");
                    i = GroupInfoDAOImpl.createGroup(mContext, valueOf);
                    if (isStarMessage) {
                        GroupInfoDAOImpl.setGroupType(mContext, valueOf, 2);
                        GroupInfoDAOImpl.setGroupDisturb(mContext, valueOf, 1);
                    }
                    GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf, chatMsg2.getGroupType());
                } else {
                    String str2 = TAG;
                    LogUtils.d(str2, "STAR group table " + valueOf + " has exist");
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
                    if (chatMsg2.getGroupType() == 3) {
                        i2 = 57;
                    } else {
                        i2 = 3;
                    }
                    ChatObject chatObject = new ChatObject(mContext, chatMsg2.getCategory(), chatMsg2.getContacter(), chatMsg2.getPaid(), i2);
                    String str4 = TAG;
                    LogUtils.d(str4, "STAR receive group message, size is " + arrayList.size());
                    if (arrayList.size() > 0) {
                        if (i2 != 57) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                ChatMsg chatMsg3 = arrayList.get(i3);
                                handleGroupSystemMessage(chatMsg3);
                                chatMsg3.setChatType(3);
                            }
                        } else {
                            handleFansGroupSystemMessage(arrayList);
                        }
                        GroupInfoSyncManagerImpl.activeSyncGroup(mContext, valueOf);
                        ArrayList<Long> addChatMsg = GroupMessageDAOImpl.addChatMsg(mContext, valueOf, arrayList);
                        String str5 = TAG;
                        LogUtils.d(str5, "msgs : ret " + addChatMsg + ",groupid: " + valueOf);
                        String str6 = TAG;
                        LogUtils.d(str6, "msgs : msgs.size() " + arrayList.size() + ",groupid: " + valueOf);
                        if (addChatMsg == null) {
                            String str7 = TAG;
                            LogUtils.d(str7, "STAR add chat msg error. ret " + addChatMsg + ",groupid: " + valueOf);
                            return null;
                        } else if (addChatMsg.size() == 1 && addChatMsg.get(0).longValue() < 0) {
                            String str8 = TAG;
                            LogUtils.d(str8, "STAR add chat msg error. return.  ret = " + addChatMsg + ",groupid: " + valueOf);
                            return arrayList;
                        } else {
                            if (addChatMsg.size() != arrayList.size()) {
                                String str9 = TAG;
                                LogUtils.e(str9, addChatMsg.size() + " ret.size() -- msgs.size()" + arrayList.size() + ",groupid: " + valueOf);
                            }
                            boolean isActiveGroup = GroupMessageDAOImpl.isActiveGroup(mContext, valueOf);
                            if (!isActiveGroup) {
                                z2 = isExistChatMsg(arrayList);
                            }
                            String str10 = TAG;
                            LogUtils.d(str10, "isActive : " + isActiveGroup + ",isExistChatMsg : " + z2 + ",groupid: " + valueOf);
                            if (isActiveGroup || z2) {
                                recordLastMsg(valueOf, chatObject, isStarMessage);
                                if (!isActiveGroup) {
                                    GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLZ.objValue;
    }

    public ArrayList<ChatMsg> getAllChatAndSystemMsg(String str, ChatMsg chatMsg, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, chatMsg, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!TextUtils.isEmpty(str)) {
                return GroupMessageDAOImpl.fetchAllChatMsg(mContext, str, chatMsg, i, z);
            }
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> getAllChatMsg(String str, ChatMsg chatMsg, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, chatMsg, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!TextUtils.isEmpty(str)) {
                return GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(mContext, str, chatMsg, i, z);
            }
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> getAllSystemMsg(String str, ChatMsg chatMsg, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, chatMsg, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!TextUtils.isEmpty(str)) {
                return GroupMessageDAOImpl.fetchGroupSystemMsg(mContext, str, chatMsg, i, z);
            }
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }
}
