package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupCancelAdminMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansInfoUpdateMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansSetAdminMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansSetOwnerMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupBannedMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupClearNoticeMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupDisbandMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupInfoChangeMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupJoinAuditCloseMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupJoinAuditOpenMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberAddMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberDelMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberJoinMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberNameChangeMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberQuitMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupReplyUpdateMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupSettingNoticeMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarAlertMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarJoinMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupStarMasterUpdateMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupUnbannedMsg;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.MsgRepliedData;
import com.baidu.android.imsdk.chatmessage.messages.SetGroupWelcomeDisplayScopeMsg;
import com.baidu.android.imsdk.chatmessage.messages.SetGroupWelcomeMsg;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MultiplePair;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class GroupMessageManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GroupMessageManagerImpl";
    public static Context mContext;
    public static GroupMessageManagerImpl mInstance;
    public static Object mSyncLock;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, List<GroupMember>> mGroupMemberMap;

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
                return;
            }
        }
        this.mGroupMemberMap = new HashMap();
    }

    public boolean updateGroupMemberRole(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, str, str2, i)) == null) {
            if (GroupInfoDAOImpl.updateGroupMemberRole(mContext, str, str2, i) > 0) {
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    private boolean checkMemberType(long j, String str, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i)})) == null) {
            List<GroupMember> groupCreatorAndAdmin = getGroupCreatorAndAdmin(str);
            if (groupCreatorAndAdmin != null && groupCreatorAndAdmin.size() != 0) {
                for (GroupMember groupMember : groupCreatorAndAdmin) {
                    if (groupMember.getBduid() == j && groupMember.getRole() == i) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void fetchAndNotifyGroupJoinApplyCountIfNeed(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        new ArrayList().add(str);
        GroupJoinApplyBiz.fetchJoinGroupApplyCountIfNeed(mContext, str, new BIMValuesCallBack<Long, Integer>(this) { // from class: com.baidu.android.imsdk.group.GroupMessageManagerImpl.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GroupMessageManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.media.listener.BIMValuesCallBack
            public void onResult(int i, String str2, Long l, Integer num) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, l, num}) == null) && i == 0 && l.longValue() > 0) {
                    this.this$0.updateAndNotifyApplyCount(l.longValue(), num.intValue());
                }
            }
        });
    }

    private void handleDeleteMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, chatMsg) == null) {
            ChatMsgManagerImpl.getInstance(mContext).broadDeleteMsg(mContext, chatMsg);
        }
    }

    private void handleGroupBandStateChangeMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, chatMsg) == null) {
            String valueOf = String.valueOf(chatMsg.getContacter());
            GroupInfoSyncManagerImpl.addSyncGroupInfo(valueOf);
            GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
        }
    }

    private boolean isAtCurrentUser(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, chatMsg)) == null) {
            String uid = AccountManager.getUid(mContext);
            if (chatMsg.getMsgType() != 40 || !((FansGroupAtMsg) chatMsg).isGroupAtUserById(uid)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean isSendFromGroupCreator(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, this, chatMsg)) == null) {
            long longByString = Utility.getLongByString(chatMsg.getSenderUid(), 0L);
            if (longByString <= 0) {
                return false;
            }
            return checkMemberType(longByString, String.valueOf(chatMsg.getContacter()), 1);
        }
        return invokeL.booleanValue;
    }

    private List<GroupMember> getGroupCreatorAndAdmin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            Map<String, List<GroupMember>> map = this.mGroupMemberMap;
            if (map == null) {
                return null;
            }
            List<GroupMember> list = map.get(str);
            if ((list == null || list.isEmpty()) && (list = GroupInfoDAOImpl.getGroupOwnerAndAdmins(mContext, str)) != null) {
                this.mGroupMemberMap.put(str, list);
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static GroupMessageManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
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
        if (interceptable == null || interceptable.invokeL(65546, this, chatMsg) == null) {
            String valueOf = String.valueOf(((GroupStarAlertMsg) chatMsg).getGroupid());
            int groupPermit = GroupInfoDAOImpl.setGroupPermit(mContext, valueOf, 0);
            String str = TAG;
            LogUtils.d(str, "STAR handlePermitGroup " + valueOf + "  ret=" + groupPermit);
        }
    }

    private void handleChangeGroupInfoMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, chatMsg) == null) {
            GroupInfoChangeMsg groupInfoChangeMsg = (GroupInfoChangeMsg) chatMsg;
            String valueOf = String.valueOf(chatMsg.getContacter());
            if (groupInfoChangeMsg.getGroupname() != null) {
                GroupInfoDAOImpl.modifyGroupName(mContext, valueOf, groupInfoChangeMsg.getGroupname());
                ConversationManagerImpl.getInstance(mContext).updateConversationName(groupInfoChangeMsg.getGroupname(), 1, valueOf);
            }
        }
    }

    private void handleDisbandMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, chatMsg) == null) {
            GroupDisbandMsg groupDisbandMsg = (GroupDisbandMsg) chatMsg;
            try {
                LogUtils.d(TAG, "GroupMessageManager GroupDisbandMsg");
                quitGroupByGroupId(groupDisbandMsg.getContacter());
                ArrayList<ChatMsg> arrayList = new ArrayList<>();
                arrayList.add(chatMsg);
                ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList);
            } catch (Exception unused) {
                LogUtils.d(TAG, "handleDisbandMsg exception, this is normal for device sync logic");
            }
        }
    }

    private void handlePermitGroup(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, chatMsg) == null) {
            String valueOf = String.valueOf(((GroupStarAlertMsg) chatMsg).getGroupid());
            int groupPermit = GroupInfoDAOImpl.setGroupPermit(mContext, valueOf, 1);
            String str = TAG;
            LogUtils.d(str, "STAR handlePermitGroup " + valueOf + "  ret=" + groupPermit);
        }
    }

    private boolean isGroupCoupon(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return false;
            }
            long longByString = Utility.getLongByString(chatMsg.getSenderUid(), 0L);
            if (longByString <= 0) {
                return false;
            }
            String uid = AccountManager.getUid(mContext);
            if (TextUtils.isEmpty(uid) || TextUtils.equals(String.valueOf(longByString), uid) || chatMsg.getMsgType() != 60) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public List<GroupMember> getGroupAdministrators(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            List<GroupMember> groupCreatorAndAdmin = getGroupCreatorAndAdmin(str);
            if (groupCreatorAndAdmin == null) {
                return null;
            }
            Iterator<GroupMember> it = groupCreatorAndAdmin.iterator();
            while (it.hasNext()) {
                if (it.next().getRole() == 1) {
                    it.remove();
                }
            }
            return groupCreatorAndAdmin;
        }
        return (List) invokeL.objValue;
    }

    public GroupMember getGroupOwner(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<GroupMember> groupCreatorAndAdmin = getGroupCreatorAndAdmin(str);
            if (groupCreatorAndAdmin != null && groupCreatorAndAdmin.size() != 0) {
                for (GroupMember groupMember : groupCreatorAndAdmin) {
                    if (groupMember.getRole() == 1) {
                        return groupMember;
                    }
                }
            }
            return null;
        }
        return (GroupMember) invokeL.objValue;
    }

    private String getMemberRoleDisplayName(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65544, this, j, str)) == null) {
            List<GroupMember> groupCreatorAndAdmin = getGroupCreatorAndAdmin(str);
            if (groupCreatorAndAdmin != null && groupCreatorAndAdmin.size() != 0) {
                for (GroupMember groupMember : groupCreatorAndAdmin) {
                    if (groupMember.getBduid() == j) {
                        return groupMember.getRoleDisplayName();
                    }
                }
            }
            return "";
        }
        return (String) invokeJL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAndNotifyApplyCount(long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65573, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) != null) || j <= 0) {
            return;
        }
        GroupUpdateManager.getInstance(mContext).onApplyCountChanged(j, i);
        updateAndNotifyChatSession(j, i);
    }

    private void handleAddMemberMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, chatMsg) == null) {
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
        if (interceptable == null || interceptable.invokeL(65549, this, chatMsg) == null) {
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
                    } catch (Exception unused) {
                        LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
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

    private void handleGroupSystemMessage(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, chatMsg) == null) {
            if (chatMsg == null) {
                LogUtils.d(TAG, "handleGroupSystemMessage msg is null");
                return;
            }
            String str = TAG;
            LogUtils.d(str, "handleGroupSystemMessage msg type is " + chatMsg.getMsgType());
            int msgType = chatMsg.getMsgType();
            if (msgType != 1016) {
                if (msgType != 5001) {
                    if (msgType != 1019 && msgType != 1020) {
                        switch (msgType) {
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
                            default:
                                switch (msgType) {
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
                                    default:
                                        return;
                                }
                        }
                    }
                    handleGroupBandStateChangeMsg(chatMsg);
                    return;
                }
                handleGroupReplyMsgUpdate((GroupReplyUpdateMsg) chatMsg);
                return;
            }
            handleDeleteMsg(chatMsg);
        }
    }

    private void handleDeleteGroup(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, chatMsg) == null) {
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
            } catch (Exception unused) {
                LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
            }
        }
    }

    private void handleMemberNameChange(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, chatMsg) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, arrayList)) == null) {
            for (int i = 0; i < arrayList.size(); i++) {
                int msgType = arrayList.get(i).getMsgType();
                int groupType = arrayList.get(i).getGroupType();
                if ((msgType >= 0 && msgType <= 100) || msgType == 2001) {
                    return true;
                }
                if ((msgType >= 1010 && msgType <= 1011) || msgType == 1007) {
                    return true;
                }
                if ((msgType == 1005 && groupType == 3) || msgType == 1019 || msgType == 1020) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isSendFromGroupAdmin(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, this, chatMsg)) == null) {
            long longByString = Utility.getLongByString(chatMsg.getSenderUid(), 0L);
            if (longByString <= 0) {
                return false;
            }
            String uid = AccountManager.getUid(mContext);
            if (TextUtils.isEmpty(uid) || TextUtils.equals(String.valueOf(longByString), uid)) {
                return false;
            }
            return checkMemberType(longByString, String.valueOf(chatMsg.getContacter()), 2);
        }
        return invokeL.booleanValue;
    }

    private void quitGroupByGroupId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65570, this, j) == null) {
            String valueOf = String.valueOf(j);
            GroupInfoDAOImpl.quitGroup(mContext, valueOf);
            String str = TAG;
            LogUtils.d(str, "quitGroupByGroupId groupID = " + j);
            DialogRecordDBManager.getInstance(mContext).delete(1, j);
            ConversationManagerImpl.getInstance(mContext).deleteConversation(1, valueOf);
            this.mGroupMemberMap.remove(String.valueOf(j));
        }
    }

    private void handleFansAddMemberMsg(ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, chatMsg, str) == null) {
            String valueOf = String.valueOf(chatMsg.getContacter());
            GroupMemberAddMsg groupMemberAddMsg = (GroupMemberAddMsg) chatMsg;
            ArrayList<String> memberBuids = groupMemberAddMsg.getMemberBuids();
            String str2 = TAG;
            LogUtils.d(str2, "handleAddMemberMsg " + valueOf + GlideException.IndentedAppendable.INDENT + memberBuids.toString());
            String operator = groupMemberAddMsg.getOperator();
            String str3 = TAG;
            LogUtils.d(str3, "operator : (" + operator + ") and uid : (" + AccountManager.getUid(mContext) + SmallTailInfo.EMOTION_SUFFIX);
            if ((memberBuids != null && memberBuids.size() > 0 && memberBuids.contains(AccountManager.getUid(mContext))) || AccountManager.getUid(mContext).equals(operator)) {
                GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
            }
            GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberAddMsg.getGroupnum());
            GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf, chatMsg.getGroupType());
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            arrayList.add(chatMsg);
            ChatMsgManagerImpl.getInstance(mContext).sendMessageBroadcast(mContext, arrayList);
        }
    }

    private void handleGroupApplyCountRemind(int i, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65554, this, i, chatMsg) == null) {
            long contacter = chatMsg.getContacter();
            if (contacter <= 0) {
                return;
            }
            String uid = AccountManager.getUid(mContext);
            if (i == 1017) {
                FansSetOwnerMsg fansSetOwnerMsg = (FansSetOwnerMsg) chatMsg;
                long longByString = Utility.getLongByString(fansSetOwnerMsg.getOldOwner(), 0L);
                long longByString2 = Utility.getLongByString(fansSetOwnerMsg.getNewOwner(), 0L);
                if (longByString != 0 && longByString2 != 0 && fansSetOwnerMsg.getContacter() > 0) {
                    if (TextUtils.equals(String.valueOf(longByString2), uid)) {
                        fetchAndNotifyGroupJoinApplyCountIfNeed(String.valueOf(contacter));
                    } else if (TextUtils.equals(String.valueOf(longByString), uid)) {
                        updateAndNotifyApplyCount(contacter, 0);
                    }
                }
            } else if (i == 1018) {
                long member = ((FansGroupCancelAdminMsg) chatMsg).getMember();
                if (member > 0 && TextUtils.equals(uid, String.valueOf(member))) {
                    updateAndNotifyApplyCount(contacter, 0);
                }
            } else if (i == 1015 && ((FansSetAdminMsg) chatMsg).getBduids().contains(uid)) {
                fetchAndNotifyGroupJoinApplyCountIfNeed(String.valueOf(contacter));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x042f, code lost:
        if (r7.get(0).getGroupCapacity() > r2.getGroupnum()) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0431, code lost:
        r21 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x03b5, code lost:
        if (r7.get(0).getGroupCapacity() > r1.getGroupnum()) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleFansGroupSystemMessage(ArrayList<ChatMsg> arrayList) {
        long j;
        long j2;
        ArrayList<String> arrayList2;
        ArrayList<GroupInfo> arrayList3;
        long j3;
        long j4;
        long j5;
        BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack;
        ArrayList<GroupInfo> arrayList4;
        ArrayList<GroupInfo> arrayList5;
        BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                String valueOf = String.valueOf(arrayList.get(0).getContacter());
                ArrayList<String> arrayList6 = new ArrayList<>();
                arrayList6.add(valueOf);
                ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList6);
                if (groupInfo != null && groupInfo.size() > 0) {
                    GroupInfo groupInfo2 = groupInfo.get(0);
                    j = groupInfo2.getMembersVersion();
                    j2 = groupInfo2.getInfoVersion();
                } else {
                    j = Long.MAX_VALUE;
                    j2 = Long.MAX_VALUE;
                }
                Iterator<ChatMsg> it = arrayList.iterator();
                BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack3 = null;
                BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack4 = null;
                ArrayList<String> arrayList7 = null;
                boolean z = false;
                long j6 = 0;
                long j7 = 0;
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    Iterator<ChatMsg> it2 = it;
                    next.setChatType(57);
                    int msgType = next.getMsgType();
                    boolean z2 = z;
                    if (msgType != 5001) {
                        switch (msgType) {
                            case 1001:
                                arrayList2 = arrayList6;
                                arrayList3 = groupInfo;
                                j3 = j;
                                j4 = j2;
                                j5 = j7;
                                bIMValueCallBack = bIMValueCallBack3;
                                handleFansAddMemberMsg(next, valueOf);
                                break;
                            case 1002:
                                arrayList2 = arrayList6;
                                arrayList3 = groupInfo;
                                j3 = j;
                                j4 = j2;
                                long j8 = j7;
                                bIMValueCallBack = bIMValueCallBack3;
                                GroupMemberJoinMsg groupMemberJoinMsg = (GroupMemberJoinMsg) next;
                                if (TextUtils.equals(groupMemberJoinMsg.getMemberBuid(), AccountManager.getUid(mContext))) {
                                    GroupInfoDAOImpl.setGroupState(mContext, valueOf, 0);
                                }
                                if (groupMemberJoinMsg.getMemberVersion() > j3) {
                                    GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberJoinMsg.getGroupnum());
                                }
                                GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
                                j5 = Math.max(groupMemberJoinMsg.getMemberVersion(), j8);
                                if (arrayList3 != null && arrayList3.size() > 0) {
                                    if (arrayList3.get(0).getGroupCapacity() <= groupMemberJoinMsg.getGroupnum()) {
                                        updateAndNotifyApplyCount(Long.valueOf(valueOf).longValue(), 0);
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                                break;
                            case 1003:
                                arrayList2 = arrayList6;
                                arrayList3 = groupInfo;
                                j3 = j;
                                j4 = j2;
                                j5 = j7;
                                bIMValueCallBack = bIMValueCallBack3;
                                GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) next;
                                String quitBuid = groupMemberQuitMsg.getQuitBuid();
                                if (TextUtils.equals(quitBuid, AccountManager.getUid(mContext))) {
                                    quitGroupByGroupId(groupMemberQuitMsg.getContacter());
                                    updateAndNotifyApplyCount(Long.valueOf(valueOf).longValue(), 0);
                                } else {
                                    j5 = Math.max(groupMemberQuitMsg.getMemberVersion(), j5);
                                    if (groupMemberQuitMsg.getMemberVersion() > j3) {
                                        ArrayList arrayList8 = new ArrayList();
                                        arrayList8.add(quitBuid);
                                        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberQuitMsg.getGroupnum());
                                        GroupInfoDAOImpl.delGroupMember(mContext, valueOf, arrayList8);
                                    }
                                    GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
                                    if (arrayList3 != null) {
                                        if (arrayList3.size() > 0) {
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 1004:
                                arrayList2 = arrayList6;
                                arrayList4 = groupInfo;
                                j3 = j;
                                j4 = j2;
                                j5 = j7;
                                bIMValueCallBack = bIMValueCallBack3;
                                GroupMemberDelMsg groupMemberDelMsg = (GroupMemberDelMsg) next;
                                ArrayList<String> memberBuids = groupMemberDelMsg.getMemberBuids();
                                if (memberBuids.contains(AccountManager.getUid(mContext))) {
                                    updateAndNotifyApplyCount(Long.valueOf(valueOf).longValue(), 0);
                                    quitGroupByGroupId(groupMemberDelMsg.getContacter());
                                    ArrayList<ChatMsg> arrayList9 = new ArrayList<>();
                                    arrayList9.add(next);
                                    ChatMsgManagerImpl.getInstance(mContext).broadDeleteGroupMsg(mContext, arrayList9);
                                } else {
                                    if (groupMemberDelMsg.getMemberVersion() > j3) {
                                        GroupInfoDAOImpl.modifyGroupMemberNumber(mContext, valueOf, groupMemberDelMsg.getGroupnum());
                                        GroupInfoDAOImpl.delGroupMember(mContext, valueOf, memberBuids);
                                    }
                                    j5 = Math.max(groupMemberDelMsg.getMemberVersion(), j5);
                                    GroupInfoDAOImpl.activeGroupState(mContext, valueOf);
                                    if (arrayList4 != null && arrayList4.size() > 0) {
                                        arrayList3 = arrayList4;
                                        break;
                                    }
                                }
                                arrayList3 = arrayList4;
                                break;
                            case 1005:
                                arrayList2 = arrayList6;
                                arrayList4 = groupInfo;
                                j3 = j;
                                j4 = j2;
                                j5 = j7;
                                bIMValueCallBack = bIMValueCallBack3;
                                GroupInfoChangeMsg groupInfoChangeMsg = (GroupInfoChangeMsg) next;
                                if (groupInfoChangeMsg.getInfoVersion() > j4) {
                                    GroupInfoDAOImpl.modifyGroupName(mContext, valueOf, groupInfoChangeMsg.getGroupname());
                                    ConversationManagerImpl.getInstance(mContext).updateConversationName(groupInfoChangeMsg.getGroupname(), 1, valueOf);
                                }
                                j6 = Math.max(groupInfoChangeMsg.getInfoVersion(), j6);
                                arrayList3 = arrayList4;
                                break;
                            default:
                                switch (msgType) {
                                    case 1012:
                                        arrayList2 = arrayList6;
                                        arrayList4 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        long j9 = j7;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        GroupMemberNameChangeMsg groupMemberNameChangeMsg = (GroupMemberNameChangeMsg) next;
                                        if (groupMemberNameChangeMsg.getMemberVersion() > j3) {
                                            String memberChangedid = groupMemberNameChangeMsg.memberChangedid();
                                            GroupInfoDAOImpl.updateMemberNickName(mContext, valueOf, memberChangedid, groupMemberNameChangeMsg.getNickname());
                                            ChatSession chatSession = ChatMsgManager.getChatSession(mContext, 1, next.getContacter());
                                            if (chatSession != null && TextUtils.equals(memberChangedid, String.valueOf(chatSession.getLastMsgUid()))) {
                                                chatSession.setLastMsgName(groupMemberNameChangeMsg.getNickname());
                                                ChatMessageDBManager.getInstance(mContext).updateChatSession(4, chatSession);
                                            }
                                        }
                                        j5 = Math.max(groupMemberNameChangeMsg.getMemberVersion(), j9);
                                        arrayList3 = arrayList4;
                                        break;
                                    case 1013:
                                        arrayList2 = arrayList6;
                                        arrayList4 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        handleDisbandMsg(next);
                                        arrayList3 = arrayList4;
                                        break;
                                    case 1014:
                                        arrayList2 = arrayList6;
                                        arrayList4 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        j6 = Math.max(((FansInfoUpdateMsg) next).getInfoVersion(), j6);
                                        arrayList3 = arrayList4;
                                        break;
                                    case 1015:
                                        arrayList2 = arrayList6;
                                        arrayList4 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        long j10 = j7;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        FansSetAdminMsg fansSetAdminMsg = (FansSetAdminMsg) next;
                                        ArrayList arrayList10 = new ArrayList();
                                        if (fansSetAdminMsg.getBduids() != null) {
                                            for (String str : fansSetAdminMsg.getBduids()) {
                                                arrayList10.add(Long.valueOf(Utility.getLongByString(str, 0L)));
                                            }
                                        }
                                        j5 = Math.max(fansSetAdminMsg.getMemberVersion(), j10);
                                        j6 = Math.max(fansSetAdminMsg.getGroupVersion(), j6);
                                        BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack5 = new BIMValueCallBack<ArrayList<GroupMember>>(this, fansSetAdminMsg) { // from class: com.baidu.android.imsdk.group.GroupMessageManagerImpl.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ GroupMessageManagerImpl this$0;
                                            public final /* synthetic */ FansSetAdminMsg val$setAdminMsg;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, fansSetAdminMsg};
                                                    interceptable2.invokeUnInit(65536, newInitContext);
                                                    int i = newInitContext.flag;
                                                    if ((i & 1) != 0) {
                                                        int i2 = i & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable2.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$0 = this;
                                                this.val$setAdminMsg = fansSetAdminMsg;
                                            }

                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                            public void onResult(int i, String str2, ArrayList<GroupMember> arrayList11) {
                                                Interceptable interceptable2 = $ic;
                                                if ((interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, arrayList11) == null) && i == 0) {
                                                    ArrayList<ChatMsg> arrayList12 = new ArrayList<>();
                                                    arrayList12.add(this.val$setAdminMsg);
                                                    ChatMsgManagerImpl.getInstance(GroupMessageManagerImpl.mContext).sendMessageBroadcast(GroupMessageManagerImpl.mContext, arrayList12);
                                                }
                                            }
                                        };
                                        handleGroupRoleChanged(1015, fansSetAdminMsg);
                                        bIMValueCallBack4 = bIMValueCallBack5;
                                        arrayList3 = arrayList4;
                                        break;
                                    case 1016:
                                        arrayList2 = arrayList6;
                                        arrayList5 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        handleDeleteMsg(next);
                                        arrayList3 = arrayList5;
                                        break;
                                    case 1017:
                                        arrayList2 = arrayList6;
                                        arrayList5 = groupInfo;
                                        long j11 = j7;
                                        FansSetOwnerMsg fansSetOwnerMsg = (FansSetOwnerMsg) next;
                                        String oldOwner = fansSetOwnerMsg.getOldOwner();
                                        String newOwner = fansSetOwnerMsg.getNewOwner();
                                        if (!TextUtils.isEmpty(oldOwner) && !TextUtils.isEmpty(newOwner)) {
                                            ArrayList arrayList11 = new ArrayList();
                                            bIMValueCallBack = bIMValueCallBack3;
                                            ArrayList arrayList12 = new ArrayList();
                                            j4 = j2;
                                            j3 = j;
                                            arrayList11.add(Long.valueOf(Utility.getLongByString(oldOwner, 0L)));
                                            arrayList12.add(Long.valueOf(Utility.getLongByString(newOwner, 0L)));
                                            GroupInfoDAOImpl.updateGroupMembersRole(mContext, valueOf, arrayList11, 0);
                                            GroupInfoDAOImpl.updateGroupMembersRole(mContext, valueOf, arrayList12, 1);
                                            String uid = AccountManager.getUid(mContext);
                                            j6 = (TextUtils.equals(oldOwner, uid) || TextUtils.equals(newOwner, uid)) ? Long.MAX_VALUE : Long.MAX_VALUE;
                                            ArrayList<String> arrayList13 = new ArrayList<>();
                                            arrayList13.add(oldOwner);
                                            arrayList13.add(newOwner);
                                            j5 = Math.max(fansSetOwnerMsg.getGroupMemberVersion(), j11);
                                            bIMValueCallBack4 = new BIMValueCallBack<ArrayList<GroupMember>>(this, fansSetOwnerMsg) { // from class: com.baidu.android.imsdk.group.GroupMessageManagerImpl.3
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ GroupMessageManagerImpl this$0;
                                                public final /* synthetic */ FansSetOwnerMsg val$setOwnerMsg;

                                                {
                                                    Interceptable interceptable2 = $ic;
                                                    if (interceptable2 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this, fansSetOwnerMsg};
                                                        interceptable2.invokeUnInit(65536, newInitContext);
                                                        int i = newInitContext.flag;
                                                        if ((i & 1) != 0) {
                                                            int i2 = i & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable2.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                    this.val$setOwnerMsg = fansSetOwnerMsg;
                                                }

                                                /* JADX DEBUG: Method merged with bridge method */
                                                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                                public void onResult(int i, String str2, ArrayList<GroupMember> arrayList14) {
                                                    Interceptable interceptable2 = $ic;
                                                    if ((interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, arrayList14) == null) && i == 0) {
                                                        ArrayList<ChatMsg> arrayList15 = new ArrayList<>();
                                                        arrayList15.add(this.val$setOwnerMsg);
                                                        ChatMsgManagerImpl.getInstance(GroupMessageManagerImpl.mContext).sendMessageBroadcast(GroupMessageManagerImpl.mContext, arrayList15);
                                                    }
                                                }
                                            };
                                            handleGroupRoleChanged(1017, next);
                                            arrayList7 = arrayList13;
                                            arrayList3 = arrayList5;
                                            break;
                                        } else {
                                            return;
                                        }
                                        break;
                                    case 1018:
                                        FansGroupCancelAdminMsg fansGroupCancelAdminMsg = (FansGroupCancelAdminMsg) next;
                                        arrayList2 = arrayList6;
                                        ArrayList<GroupInfo> arrayList14 = groupInfo;
                                        long max = Math.max(fansGroupCancelAdminMsg.getMemberVersion(), j7);
                                        j6 = Math.max(fansGroupCancelAdminMsg.getGroupVersion(), j6);
                                        ArrayList<String> arrayList15 = new ArrayList<>();
                                        arrayList15.add(String.valueOf(fansGroupCancelAdminMsg.getMember()));
                                        BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack6 = new BIMValueCallBack<ArrayList<GroupMember>>(this, fansGroupCancelAdminMsg) { // from class: com.baidu.android.imsdk.group.GroupMessageManagerImpl.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ GroupMessageManagerImpl this$0;
                                            public final /* synthetic */ FansGroupCancelAdminMsg val$cancelAdminMsg;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, fansGroupCancelAdminMsg};
                                                    interceptable2.invokeUnInit(65536, newInitContext);
                                                    int i = newInitContext.flag;
                                                    if ((i & 1) != 0) {
                                                        int i2 = i & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable2.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$0 = this;
                                                this.val$cancelAdminMsg = fansGroupCancelAdminMsg;
                                            }

                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                            public void onResult(int i, String str2, ArrayList<GroupMember> arrayList16) {
                                                Interceptable interceptable2 = $ic;
                                                if ((interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, arrayList16) == null) && i == 0) {
                                                    ArrayList<ChatMsg> arrayList17 = new ArrayList<>();
                                                    arrayList17.add(this.val$cancelAdminMsg);
                                                    ChatMsgManagerImpl.getInstance(GroupMessageManagerImpl.mContext).sendMessageBroadcast(GroupMessageManagerImpl.mContext, arrayList17);
                                                }
                                            }
                                        };
                                        handleGroupRoleChanged(1018, next);
                                        arrayList7 = arrayList15;
                                        bIMValueCallBack4 = bIMValueCallBack6;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = max;
                                        arrayList3 = arrayList14;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        break;
                                    case 1019:
                                        j6 = Math.max(((GroupBannedMsg) next).getInfoVersion(), j6);
                                        updateAndNotifyApplyCount(Long.parseLong(valueOf), 0);
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        z2 = false;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        break;
                                    case 1020:
                                        j6 = Math.max(((GroupUnbannedMsg) next).getInfoVersion(), j6);
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        z2 = true;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        break;
                                    case 1021:
                                    case 1022:
                                    case 1023:
                                    case 1024:
                                        if (msgType == 1024) {
                                            j6 = Math.max(((GroupJoinAuditOpenMsg) next).getGroupVersion(), j6);
                                        }
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        z2 = true;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        break;
                                    case 1025:
                                        j6 = Math.max(((GroupJoinAuditCloseMsg) next).getGroupVersion(), j6);
                                        updateAndNotifyApplyCount(Long.valueOf(valueOf).longValue(), 0);
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        z2 = false;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        break;
                                    case 1026:
                                        GroupSettingNoticeMsg groupSettingNoticeMsg = (GroupSettingNoticeMsg) next;
                                        groupSettingNoticeMsg.setGroupId(valueOf);
                                        j6 = Math.max(groupSettingNoticeMsg.getInfoVersion(), j6);
                                        bIMValueCallBack2 = new BIMValueCallBack<ArrayList<GroupInfo>>(this, groupSettingNoticeMsg) { // from class: com.baidu.android.imsdk.group.GroupMessageManagerImpl.4
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ GroupMessageManagerImpl this$0;
                                            public final /* synthetic */ GroupSettingNoticeMsg val$settingNoticeMsg;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, groupSettingNoticeMsg};
                                                    interceptable2.invokeUnInit(65536, newInitContext);
                                                    int i = newInitContext.flag;
                                                    if ((i & 1) != 0) {
                                                        int i2 = i & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable2.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$0 = this;
                                                this.val$settingNoticeMsg = groupSettingNoticeMsg;
                                            }

                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                            public void onResult(int i, String str2, ArrayList<GroupInfo> arrayList16) {
                                                Interceptable interceptable2 = $ic;
                                                if ((interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, arrayList16) == null) && i == 0) {
                                                    ArrayList<ChatMsg> arrayList17 = new ArrayList<>();
                                                    arrayList17.add(this.val$settingNoticeMsg);
                                                    ChatMsgManagerImpl.getInstance(GroupMessageManagerImpl.mContext).sendMessageBroadcast(GroupMessageManagerImpl.mContext, arrayList17);
                                                }
                                            }
                                        };
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        bIMValueCallBack = bIMValueCallBack2;
                                        break;
                                    case 1027:
                                        GroupClearNoticeMsg groupClearNoticeMsg = (GroupClearNoticeMsg) next;
                                        groupClearNoticeMsg.setGroupId(valueOf);
                                        j6 = Math.max(groupClearNoticeMsg.getInfoVersion(), j6);
                                        bIMValueCallBack2 = new BIMValueCallBack<ArrayList<GroupInfo>>(this, groupClearNoticeMsg) { // from class: com.baidu.android.imsdk.group.GroupMessageManagerImpl.5
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ GroupMessageManagerImpl this$0;
                                            public final /* synthetic */ GroupClearNoticeMsg val$clearNoticeMsg;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, groupClearNoticeMsg};
                                                    interceptable2.invokeUnInit(65536, newInitContext);
                                                    int i = newInitContext.flag;
                                                    if ((i & 1) != 0) {
                                                        int i2 = i & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable2.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$0 = this;
                                                this.val$clearNoticeMsg = groupClearNoticeMsg;
                                            }

                                            /* JADX DEBUG: Method merged with bridge method */
                                            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                            public void onResult(int i, String str2, ArrayList<GroupInfo> arrayList16) {
                                                Interceptable interceptable2 = $ic;
                                                if ((interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, arrayList16) == null) && i == 0) {
                                                    ArrayList<ChatMsg> arrayList17 = new ArrayList<>();
                                                    arrayList17.add(this.val$clearNoticeMsg);
                                                    ChatMsgManagerImpl.getInstance(GroupMessageManagerImpl.mContext).sendMessageBroadcast(GroupMessageManagerImpl.mContext, arrayList17);
                                                }
                                            }
                                        };
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        bIMValueCallBack = bIMValueCallBack2;
                                        break;
                                    case 1028:
                                        j6 = Math.max(((SetGroupWelcomeMsg) next).getGroupVersion(), j6);
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        break;
                                    case 1029:
                                        j6 = Math.max(((SetGroupWelcomeDisplayScopeMsg) next).getGroupVersion(), j6);
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        break;
                                    default:
                                        arrayList2 = arrayList6;
                                        arrayList3 = groupInfo;
                                        j3 = j;
                                        j4 = j2;
                                        j5 = j7;
                                        bIMValueCallBack = bIMValueCallBack3;
                                        break;
                                }
                        }
                    } else {
                        arrayList2 = arrayList6;
                        arrayList3 = groupInfo;
                        j3 = j;
                        j4 = j2;
                        j5 = j7;
                        bIMValueCallBack = bIMValueCallBack3;
                        handleGroupReplyMsgUpdate((GroupReplyUpdateMsg) next);
                    }
                    bIMValueCallBack3 = bIMValueCallBack;
                    it = it2;
                    j2 = j4;
                    j = j3;
                    j7 = j5;
                    groupInfo = arrayList3;
                    z = z2;
                    arrayList6 = arrayList2;
                }
                ArrayList<String> arrayList16 = arrayList6;
                boolean z3 = z;
                long j12 = j;
                long j13 = j2;
                long j14 = j7;
                BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack7 = bIMValueCallBack3;
                if (j13 <= j6) {
                    LogUtils.d(TAG, "getFansGroupInfo sInfoVersion = " + j13 + " maxInfoVersion = " + j6);
                    GroupManagerImpl.getInstance(mContext).getFansGroupInfo(arrayList16, true, bIMValueCallBack7);
                }
                if (j12 <= j14) {
                    LogUtils.d(TAG, "getFansGroupMember sMemberVersion = " + j12 + " maxMemberVersion = " + j14);
                    GroupManagerImpl.getInstance(mContext).getFansGroupMember(valueOf, arrayList7, true, bIMValueCallBack4);
                }
                if (z3) {
                    fetchAndNotifyGroupJoinApplyCountIfNeed(valueOf);
                    return;
                }
                return;
            }
            LogUtils.d(TAG, "handleGroupSystemMessage msg is null");
        }
    }

    private void handleGroupReplyMsgUpdate(GroupReplyUpdateMsg groupReplyUpdateMsg) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, groupReplyUpdateMsg) == null) {
            long groupId = groupReplyUpdateMsg.getGroupId();
            long msgId = groupReplyUpdateMsg.getMsgId();
            if (groupId > 0 && msgId > 0) {
                int msgRepliedStatus = groupReplyUpdateMsg.getMsgRepliedStatus();
                String msgRepliedStatusDisplayText = groupReplyUpdateMsg.getMsgRepliedStatusDisplayText();
                ChatMsg fetchChatMsgByMsgId = GroupMessageDAOImpl.fetchChatMsgByMsgId(mContext, String.valueOf(groupId), msgId);
                if (fetchChatMsgByMsgId != null && !TextUtils.isEmpty(fetchChatMsgByMsgId.getMsgContent())) {
                    String updatedMsgContent = MsgRepliedData.getUpdatedMsgContent(fetchChatMsgByMsgId.getMsgContent(), msgRepliedStatus, msgRepliedStatusDisplayText);
                    if (!TextUtils.isEmpty(updatedMsgContent) && GroupMessageDAOImpl.updateMsgContent(mContext, String.valueOf(groupId), msgId, updatedMsgContent) > 0) {
                        fetchChatMsgByMsgId.setMsgContent(updatedMsgContent);
                        ChatMsgManagerImpl.getInstance(mContext).sendMsgUpdatedBroadcast(mContext, fetchChatMsgByMsgId);
                        return;
                    }
                    return;
                }
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("handleGroupReplyMsgUpdate chat msg invalid:");
                if (fetchChatMsgByMsgId == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                LogUtils.d(str, sb.toString());
            }
        }
    }

    private void handleJoinGroupMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, chatMsg) == null) {
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

    private void handleQuitGroupMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, chatMsg) == null) {
            LogUtils.d(TAG, "STAR handleQuitGroupMsg");
            GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) chatMsg;
            String valueOf = String.valueOf(groupMemberQuitMsg.getContacter());
            String quitBuid = groupMemberQuitMsg.getQuitBuid();
            String newMaster = groupMemberQuitMsg.getNewMaster();
            if (quitBuid != null && quitBuid.equals(AccountManager.getUid(mContext))) {
                try {
                    quitGroupByGroupId(groupMemberQuitMsg.getContacter());
                    return;
                } catch (Exception unused) {
                    LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
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

    public MultiplePair<Integer, Long, Long, String> getImportantReminderMsg(List<ChatMsg> list) {
        InterceptResult invokeL;
        String memberRoleDisplayName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list != null && list.size() != 0) {
                int i = 1;
                for (int size = list.size() - 1; size >= 0; size--) {
                    ChatMsg chatMsg = list.get(size);
                    if (chatMsg != null) {
                        if (chatMsg.isMsgRead()) {
                            break;
                        }
                        boolean isSendFromGroupCreator = isSendFromGroupCreator(chatMsg);
                        boolean isSendFromGroupAdmin = isSendFromGroupAdmin(chatMsg);
                        boolean isAtCurrentUser = isAtCurrentUser(chatMsg);
                        boolean isGroupCoupon = isGroupCoupon(chatMsg);
                        if (isAtCurrentUser || isSendFromGroupCreator || isSendFromGroupAdmin || isGroupCoupon) {
                            long msgId = chatMsg.getMsgId();
                            long longByString = Utility.getLongByString(chatMsg.getSenderUid(), 0L);
                            if (!isSendFromGroupCreator && isAtCurrentUser) {
                                memberRoleDisplayName = "";
                            } else {
                                memberRoleDisplayName = getMemberRoleDisplayName(longByString, String.valueOf(chatMsg.getContacterId()));
                                if (isAtCurrentUser) {
                                    i = 2;
                                } else if (isSendFromGroupAdmin) {
                                    i = 5;
                                } else {
                                    i = 4;
                                    if (isGroupCoupon) {
                                        i = 3;
                                    }
                                }
                            }
                            return new MultiplePair<>(Integer.valueOf(i), Long.valueOf(msgId), Long.valueOf(longByString), memberRoleDisplayName);
                        }
                    }
                }
            }
            return null;
        }
        return (MultiplePair) invokeL.objValue;
    }

    public boolean isValidGroup(ChatMsg chatMsg) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMsg)) == null) {
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

    private void handleMasterChange(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, chatMsg) == null) {
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
        if (interceptable == null || interceptable.invokeL(65564, this, chatMsg) == null) {
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

    private void handleRemindMsgByChangeRole(int i, ChatMsg chatMsg) {
        ChatSession chatRecord;
        String roleDisplayName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(65563, this, i, chatMsg) != null) || (chatRecord = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(1, chatMsg.getContacter())) == null) {
            return;
        }
        if (i == 1017) {
            FansSetOwnerMsg fansSetOwnerMsg = (FansSetOwnerMsg) chatMsg;
            long longByString = Utility.getLongByString(fansSetOwnerMsg.getOldOwner(), 0L);
            long longByString2 = Utility.getLongByString(fansSetOwnerMsg.getNewOwner(), 0L);
            if (longByString != 0 && longByString2 != 0) {
                if (longByString == chatRecord.getRemindUid()) {
                    if (chatRecord.getRemindType() == 2) {
                        chatRecord.setRemindType(1);
                        chatRecord.setRemindRoleDisplayName("");
                    } else if (chatRecord.getRemindType() == 4) {
                        chatRecord.setRemindMsgId(0L);
                        chatRecord.setRemindRoleDisplayName("");
                        chatRecord.setRemindUid(0L);
                        chatRecord.setRemindType(0);
                    }
                }
                if (longByString2 == chatRecord.getRemindUid()) {
                    GroupMember groupOwner = getGroupOwner(String.valueOf(chatRecord.getContacter()));
                    if (groupOwner == null) {
                        roleDisplayName = "群主";
                    } else {
                        roleDisplayName = groupOwner.getRoleDisplayName();
                    }
                    if (chatRecord.getRemindType() == 1) {
                        chatRecord.setRemindType(2);
                        chatRecord.setRemindRoleDisplayName(roleDisplayName);
                    } else if (chatRecord.getRemindType() == 5) {
                        chatRecord.setRemindRoleDisplayName(roleDisplayName);
                        chatRecord.setRemindType(4);
                    }
                }
                chatRecord.setHandlerChangeRole(true);
                ChatMessageDBManager.getInstance(mContext).updateChatSession(4, chatRecord);
            } else {
                return;
            }
        } else if (i == 1018 && chatRecord.getRemindUid() == ((FansGroupCancelAdminMsg) chatMsg).getMember()) {
            chatRecord.setRemindMsgId(0L);
            chatRecord.setRemindRoleDisplayName("");
            chatRecord.setRemindUid(0L);
            chatRecord.setRemindType(0);
            chatRecord.setHandlerChangeRole(true);
            ChatMessageDBManager.getInstance(mContext).updateChatSession(4, chatRecord);
        }
        removeMemberFromMap(String.valueOf(chatRecord.getContacter()), null);
    }

    private void recordLastMsg(String str, ChatObject chatObject, boolean z, int i, long j, long j2, String str2) {
        ArrayList<ChatMsg> fetchAllChatMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, this, new Object[]{str, chatObject, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str2}) == null) {
            int unReadCount = GroupMessageDAOImpl.getUnReadCount(mContext, str);
            String str3 = TAG;
            LogUtils.e(str3, str + "   newmsgnum : " + unReadCount);
            if (z) {
                fetchAllChatMsg = GroupMessageDAOImpl.fetchLastChatMsg(mContext, str, null, 1L, true);
            } else {
                fetchAllChatMsg = GroupMessageDAOImpl.fetchAllChatMsg(mContext, str, null, 1L, true);
            }
            if (fetchAllChatMsg != null && fetchAllChatMsg.size() > 0) {
                ChatMsg chatMsg = fetchAllChatMsg.get(0);
                String recommendDescription = chatMsg.getRecommendDescription();
                if ((chatMsg instanceof HtmlMsg) && !TextUtils.isEmpty(chatMsg.getLocalUrl())) {
                    recommendDescription = chatMsg.getLocalUrl();
                }
                String str4 = recommendDescription;
                int clickState = Utility.getClickState(chatMsg);
                String str5 = TAG;
                LogUtils.e(str5, str + "   lastMsg : " + chatMsg);
                ChatMessageDBManager.getInstance(mContext).recordLastMsg(chatObject, str4, chatMsg.getMsgTime(), unReadCount, 0, clickState, chatMsg.isStarMessage(), null, chatMsg.getSenderUid(), i, j, j2, str2, "", 0, 0L, 0);
            }
        }
    }

    private void removeMemberFromMap(String str, GroupMember groupMember) {
        Map<String, List<GroupMember>> map;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65572, this, str, groupMember) != null) || (map = this.mGroupMemberMap) == null) {
            return;
        }
        if (groupMember == null) {
            map.remove(str);
            return;
        }
        List<GroupMember> list = map.get(str);
        if (list != null && list.size() != 0) {
            list.remove(groupMember);
        }
    }

    public void handleGroupRoleChanged(int i, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, chatMsg) == null) {
            handleRemindMsgByChangeRole(i, chatMsg);
            handleGroupApplyCountRemind(i, chatMsg);
        }
    }

    public ArrayList<ChatMsg> addMsgs(ArrayList<ChatMsg> arrayList, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        boolean z2;
        long j;
        long j2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, arrayList, z)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                ChatMsg chatMsg = arrayList.get(arrayList.size() - 1);
                int i3 = 0;
                if (chatMsg.getMsgType() == 1003) {
                    GroupMemberQuitMsg groupMemberQuitMsg = (GroupMemberQuitMsg) chatMsg;
                    String quitBuid = groupMemberQuitMsg.getQuitBuid();
                    if (quitBuid != null && quitBuid.equals(AccountManager.getUid(mContext))) {
                        try {
                            quitGroupByGroupId(groupMemberQuitMsg.getContacter());
                        } catch (Exception unused) {
                            LogUtils.d(TAG, "handleQuitGroupMsg exception, this is normal for device sync logic");
                        }
                        return arrayList;
                    }
                } else if (chatMsg.getMsgType() == 1013) {
                    handleDisbandMsg(chatMsg);
                    updateAndNotifyApplyCount(chatMsg.getContacter(), 0);
                    return arrayList;
                }
                LogUtils.d(TAG, "STAR receive group message ");
                ChatMsg chatMsg2 = arrayList.get(0);
                boolean isStarMessage = chatMsg2.isStarMessage();
                String valueOf = String.valueOf(chatMsg2.getContacter());
                if (!GroupInfoDAOImpl.isExistGroup(mContext, valueOf)) {
                    LogUtils.d(TAG, "STAR table " + valueOf + " is not exist");
                    i = GroupInfoDAOImpl.createGroup(mContext, valueOf);
                    if (isStarMessage) {
                        GroupInfoDAOImpl.setGroupType(mContext, valueOf, 2);
                        GroupInfoDAOImpl.setGroupDisturb(mContext, valueOf, 1);
                    }
                    GroupInfoSyncManagerImpl.activeSyncAllMembers(mContext, valueOf, chatMsg2.getGroupType());
                } else {
                    LogUtils.d(TAG, "STAR group table " + valueOf + " has exist");
                    i = 0;
                }
                if (i < 0) {
                    LogUtils.e(TAG, "STAR create group table error " + i);
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
                    LogUtils.d(TAG, "STAR receive group message, size is " + arrayList.size());
                    if (arrayList.size() > 0) {
                        if (i2 != 57) {
                            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                ChatMsg chatMsg3 = arrayList.get(i4);
                                handleGroupSystemMessage(chatMsg3);
                                chatMsg3.setChatType(3);
                            }
                        } else {
                            handleFansGroupSystemMessage(arrayList);
                        }
                        GroupInfoSyncManagerImpl.activeSyncGroup(mContext, valueOf);
                        ArrayList<Long> addChatMsg = GroupMessageDAOImpl.addChatMsg(mContext, valueOf, arrayList);
                        LogUtils.d(TAG, "msgs : ret " + addChatMsg + ",groupid: " + valueOf);
                        LogUtils.d(TAG, "msgs : msgs.size() " + arrayList.size() + ",groupid: " + valueOf);
                        if (addChatMsg == null) {
                            LogUtils.d(TAG, "STAR add chat msg error. ret " + addChatMsg + ",groupid: " + valueOf);
                            return null;
                        } else if (addChatMsg.size() == 1 && addChatMsg.get(0).longValue() < 0) {
                            LogUtils.d(TAG, "STAR add chat msg error. return.  ret = " + addChatMsg + ",groupid: " + valueOf);
                            return arrayList;
                        } else {
                            if (addChatMsg.size() != arrayList.size()) {
                                LogUtils.e(TAG, addChatMsg.size() + " ret.size() -- msgs.size()" + arrayList.size() + ",groupid: " + valueOf);
                            }
                            boolean isActiveGroup = GroupMessageDAOImpl.isActiveGroup(mContext, valueOf);
                            if (!isActiveGroup) {
                                z2 = isExistChatMsg(arrayList);
                            } else {
                                z2 = false;
                            }
                            LogUtils.d(TAG, "isActive : " + isActiveGroup + ",isExistChatMsg : " + z2 + ",groupid: " + valueOf);
                            if (isActiveGroup || z2) {
                                MultiplePair<Integer, Long, Long, String> importantReminderMsg = getImportantReminderMsg(arrayList);
                                if (importantReminderMsg != null) {
                                    int intValue = ((Integer) ((Pair) importantReminderMsg).first).intValue();
                                    long longValue = ((Long) ((Pair) importantReminderMsg).second).longValue();
                                    long longValue2 = importantReminderMsg.third.longValue();
                                    str = importantReminderMsg.fourth;
                                    j2 = longValue2;
                                    j = longValue;
                                    i3 = intValue;
                                } else {
                                    j = 0;
                                    j2 = 0;
                                    str = "";
                                }
                                recordLastMsg(valueOf, chatObject, isStarMessage, i3, j, j2, str);
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

    public void updateAndNotifyChatSession(long j, int i) {
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) != null) || (chatRecord = ChatSessionManagerImpl.getInstance(mContext).getChatRecord(1, j)) == null) {
            return;
        }
        chatRecord.addExt(GroupSessionManager.KEY_GROUP_APPLY_COUNT, String.valueOf(i));
        ChatSessionManagerImpl.getInstance(mContext).updateUserSessionExtAndNotify(1, j, chatRecord.getExt());
    }
}
