package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupInviteMsg;
import com.baidu.android.imsdk.chatmessage.request.IMQueryFansUnreadRequest;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.request.IMAddGroupMemberRequest;
import com.baidu.android.imsdk.group.request.IMCreateGroupRequest;
import com.baidu.android.imsdk.group.request.IMDelFansGroupMemberRequest;
import com.baidu.android.imsdk.group.request.IMDelGroupMemberRequest;
import com.baidu.android.imsdk.group.request.IMDelStarMemberRequest;
import com.baidu.android.imsdk.group.request.IMGetFansGroupInviteMember;
import com.baidu.android.imsdk.group.request.IMGetStarOnlineRequest;
import com.baidu.android.imsdk.group.request.IMGroupSetRequest;
import com.baidu.android.imsdk.group.request.IMJoinGroupRequest;
import com.baidu.android.imsdk.group.request.IMJoinStarGroupRequest;
import com.baidu.android.imsdk.group.request.IMQueryFansGroupListRequest;
import com.baidu.android.imsdk.group.request.IMQueryFansGroupQrCodeRequest;
import com.baidu.android.imsdk.group.request.IMQueryFansGroupRequest;
import com.baidu.android.imsdk.group.request.IMQueryFansMemberRequest;
import com.baidu.android.imsdk.group.request.IMQueryForwardUserList;
import com.baidu.android.imsdk.group.request.IMQueryGlobalConfRequest;
import com.baidu.android.imsdk.group.request.IMQueryGroupListRequest;
import com.baidu.android.imsdk.group.request.IMQueryGroupRequest;
import com.baidu.android.imsdk.group.request.IMQueryMemberPauidRequest;
import com.baidu.android.imsdk.group.request.IMQueryMemberRequest;
import com.baidu.android.imsdk.group.request.IMQuitGroupRequest;
import com.baidu.android.imsdk.group.request.IMQuitStarGroupRequest;
import com.baidu.android.imsdk.group.request.IMSetNickNameRequest;
import com.baidu.android.imsdk.group.request.IMUpdateGroupNameRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IHeartBeat;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupManagerImpl {
    public static final String TAG = "GroupManagerImpl";
    public static Context mContext;
    public static volatile GroupManagerImpl mInstance;
    public IHeartBeat mHeartbeat = new IHeartBeat() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.1
        @Override // com.baidu.android.imsdk.internal.IHeartBeat
        public void onHeartBeat() {
            GroupInfoSyncManagerImpl.activeSyncAllGroup(GroupManagerImpl.mContext);
        }
    };

    public GroupManagerImpl() {
        IMSDK.getInstance(mContext).registerHeartbeatListener(this.mHeartbeat);
    }

    public static synchronized GroupManagerImpl getInstance(Context context) {
        GroupManagerImpl groupManagerImpl;
        synchronized (GroupManagerImpl.class) {
            if (mInstance == null) {
                mContext = context.getApplicationContext();
                mInstance = new GroupManagerImpl();
            }
            groupManagerImpl = mInstance;
        }
        return groupManagerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatMsg getInviteMsg(String str, int i2, long j, long j2) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("group_id", Utility.getLongByString(str, 0L));
            jSONObject.put("invitor", AccountManager.getUid(mContext));
            str2 = jSONObject.toString();
        } catch (JSONException unused) {
            str2 = "";
        }
        FansGroupInviteMsg fansGroupInviteMsg = new FansGroupInviteMsg();
        fansGroupInviteMsg.setMsgContent(str2);
        fansGroupInviteMsg.setFromUser(AccountManager.getUK(mContext));
        fansGroupInviteMsg.setStatus(1);
        fansGroupInviteMsg.setSenderUid(TextUtils.isEmpty(AccountManager.getUid(mContext)) ? "0" : AccountManager.getUid(mContext));
        fansGroupInviteMsg.setCategory(0);
        fansGroupInviteMsg.setChatType(i2);
        fansGroupInviteMsg.setContacterBduid(String.valueOf(j));
        fansGroupInviteMsg.setContacter(j2);
        fansGroupInviteMsg.setMsgTime(System.currentTimeMillis() / 1000);
        return fansGroupInviteMsg;
    }

    private boolean isValidGroupName(String str) {
        if (str == null) {
            return true;
        }
        return str.length() <= 32 && !EmojionUtils.containsEmoji(str);
    }

    public void addGroupMembers(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        long longByString = Utility.getLongByString(str, 0L);
        if (longByString <= 0 || arrayList == null || arrayList.size() == 0 || arrayList.size() > 64) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMAddGroupMemberRequest iMAddGroupMemberRequest = new IMAddGroupMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), longByString, arrayList, false);
            HttpHelper.executor(mContext, iMAddGroupMemberRequest, iMAddGroupMemberRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void createGroup(int i2, String str, ArrayList<String> arrayList, BIMValueCallBack<CreateResultInfo> bIMValueCallBack) {
        if (!isValidGroupName(str)) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMCreateGroupRequest iMCreateGroupRequest = new IMCreateGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), i2, str, arrayList);
            HttpHelper.executor(mContext, iMCreateGroupRequest, iMCreateGroupRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void delFansGroupMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        if (str != null && arrayList != null && arrayList.size() != 0) {
            if (AccountManager.isLogin(mContext)) {
                IMDelFansGroupMemberRequest iMDelFansGroupMemberRequest = new IMDelFansGroupMemberRequest(mContext, str, arrayList, ListenerManager.getInstance().addListener(bIMValueCallBack));
                HttpHelper.executor(mContext, iMDelFansGroupMemberRequest, iMDelFansGroupMemberRequest);
                return;
            }
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                return;
            }
            return;
        }
        bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
    }

    public void delGroupMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        long j;
        try {
            j = Long.valueOf(str).longValue();
        } catch (NumberFormatException e2) {
            String str2 = TAG;
            LogUtils.e(str2, "groupId : " + str, e2);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            j = -1;
        }
        if (0 > j) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if ((arrayList == null || arrayList.size() == 0) && bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (AccountManager.isLogin(mContext)) {
            IMDelGroupMemberRequest iMDelGroupMemberRequest = new IMDelGroupMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, arrayList);
            HttpHelper.executor(mContext, iMDelGroupMemberRequest, iMDelGroupMemberRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void delStarMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        long j;
        try {
            j = Long.valueOf(str).longValue();
        } catch (NumberFormatException e2) {
            String str2 = TAG;
            LogUtils.e(str2, "groupId : " + str, e2);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            j = -1;
        }
        if (0 > j) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if ((arrayList == null || arrayList.size() == 0) && bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (AccountManager.isLogin(mContext)) {
            IMDelStarMemberRequest iMDelStarMemberRequest = new IMDelStarMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, arrayList);
            HttpHelper.executor(mContext, iMDelStarMemberRequest, iMDelStarMemberRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void getAllGroupList(BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        if (AccountManager.isLogin(mContext)) {
            ArrayList<String> allGroupList = GroupInfoDAOImpl.getAllGroupList(mContext);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(0, "", allGroupList);
                return;
            }
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getAllGroupMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        if (str == null) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                return;
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(str);
        ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList2);
        int num = (groupInfo == null || groupInfo.size() <= 0) ? 0 : groupInfo.get(0).getNum();
        ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(mContext, str, arrayList, 0);
        if (groupMember != null && groupMember.size() > 0) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, groupMember);
            }
            if (num <= 0 || groupMember.size() == num) {
                return;
            }
            LogUtils.d(TAG, "to update group member");
            IMQueryMemberRequest iMQueryMemberRequest = new IMQueryMemberRequest(mContext, "", AccountManager.getAppid(mContext), str, arrayList, 1);
            HttpHelper.executor(mContext, iMQueryMemberRequest, iMQueryMemberRequest);
            return;
        }
        IMQueryMemberRequest iMQueryMemberRequest2 = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, arrayList, 1);
        HttpHelper.executor(mContext, iMQueryMemberRequest2, iMQueryMemberRequest2);
    }

    public void getFansGroupInfo(final ArrayList<String> arrayList, final boolean z, final BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        if (arrayList != null && arrayList.size() != 0) {
            if (AccountManager.isLogin(mContext)) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z2;
                        if (!z) {
                            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(GroupManagerImpl.mContext, arrayList);
                            if (groupInfo != null && groupInfo.size() == arrayList.size()) {
                                z2 = true;
                                Iterator<GroupInfo> it = groupInfo.iterator();
                                while (it.hasNext()) {
                                    if (it.next().getType() != 3) {
                                        z2 = false;
                                        break;
                                    }
                                }
                            } else {
                                z2 = false;
                                break;
                            }
                            if (z2) {
                                bIMValueCallBack.onResult(0, null, groupInfo);
                                return;
                            }
                        }
                        IMQueryFansGroupRequest iMQueryFansGroupRequest = new IMQueryFansGroupRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), arrayList);
                        HttpHelper.executor(GroupManagerImpl.mContext, iMQueryFansGroupRequest, iMQueryFansGroupRequest);
                    }
                });
                return;
            }
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                return;
            }
            return;
        }
        bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
    }

    public void getFansGroupInviteMembers(String str, BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        if (bIMValueCallBack == null) {
            return;
        }
        if (str == null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (AccountManager.isLogin(mContext)) {
            IMGetFansGroupInviteMember iMGetFansGroupInviteMember = new IMGetFansGroupInviteMember(mContext, str, ListenerManager.getInstance().addListener(bIMValueCallBack));
            HttpHelper.executor(mContext, iMGetFansGroupInviteMember, iMGetFansGroupInviteMember);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getFansGroupList(final boolean z, final BIMValueCallBack<List<GroupInfo>> bIMValueCallBack) {
        if (AccountManager.isLogin(mContext)) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!z) {
                        bIMValueCallBack.onResult(0, null, GroupInfoDAOImpl.getAllFansGroupList(GroupManagerImpl.mContext));
                        return;
                    }
                    IMQueryFansGroupListRequest iMQueryFansGroupListRequest = new IMQueryFansGroupListRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(bIMValueCallBack));
                    HttpHelper.executor(GroupManagerImpl.mContext, iMQueryFansGroupListRequest, iMQueryFansGroupListRequest);
                }
            });
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getFansGroupMember(final String str, final ArrayList<String> arrayList, final boolean z, final BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        if (str == null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (AccountManager.isLogin(mContext)) {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList2;
                    if (!z) {
                        ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(GroupManagerImpl.mContext, str, arrayList, 0);
                        if ((arrayList == null && groupMember != null && groupMember.size() > 0) || ((arrayList2 = arrayList) != null && groupMember != null && arrayList2.size() == groupMember.size())) {
                            bIMValueCallBack.onResult(0, null, groupMember);
                            return;
                        }
                    }
                    IMQueryFansMemberRequest iMQueryFansMemberRequest = new IMQueryFansMemberRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, arrayList);
                    HttpHelper.executor(GroupManagerImpl.mContext, iMQueryFansMemberRequest, iMQueryFansMemberRequest);
                }
            });
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void getFansGroupQrCode(String str, BIMValueCallBack<IMQueryFansGroupQrCodeRequest.QrCode> bIMValueCallBack) {
        if (AccountManager.isLogin(mContext)) {
            IMQueryFansGroupQrCodeRequest iMQueryFansGroupQrCodeRequest = new IMQueryFansGroupQrCodeRequest(mContext, str, ListenerManager.getInstance().addListener(bIMValueCallBack));
            HttpHelper.executor(mContext, iMQueryFansGroupQrCodeRequest, iMQueryFansGroupQrCodeRequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getFansGroupUnreadStatus(BIMValueCallBack<Integer> bIMValueCallBack) {
        if (AccountManager.isLogin(mContext)) {
            IMQueryFansUnreadRequest iMQueryFansUnreadRequest = new IMQueryFansUnreadRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack));
            HttpHelper.executor(mContext, iMQueryFansUnreadRequest, iMQueryFansUnreadRequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getFansGroupUserInfo(final String str, final ArrayList<String> arrayList, final BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        if (str == null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else {
            TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(GroupManagerImpl.mContext, str, arrayList, 0);
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2 != null && arrayList2.size() != 0 && (groupMember == null || groupMember.size() != arrayList.size())) {
                        ArrayList arrayList3 = new ArrayList();
                        if (groupMember != null && groupMember.size() > 0) {
                            Iterator<GroupMember> it = groupMember.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(Long.valueOf(it.next().getBduid()));
                            }
                        }
                        ArrayList arrayList4 = new ArrayList();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            long longByString = Utility.getLongByString((String) it2.next(), 0L);
                            if (longByString != 0) {
                                arrayList4.add(Long.valueOf(longByString));
                            }
                        }
                        arrayList4.removeAll(arrayList3);
                        final ArrayList arrayList5 = new ArrayList();
                        if (groupMember != null) {
                            arrayList5.addAll(groupMember);
                        }
                        if (arrayList4.size() > 0) {
                            ChatUserManager.getUsersProfileBatch(GroupManagerImpl.mContext, arrayList4, new IGetUsersProfileBatchListener() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.3.1
                                @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
                                public void onGetUsersProfileBatchResult(int i2, String str2, ArrayList<Long> arrayList6, ArrayList<ChatUser> arrayList7) {
                                    if (i2 == 0 && arrayList7 != null && arrayList7.size() > 0) {
                                        Iterator<ChatUser> it3 = arrayList7.iterator();
                                        while (it3.hasNext()) {
                                            ChatUser next = it3.next();
                                            GroupMember groupMember2 = new GroupMember(str, next.getUk(), next.getUserName(), next.getBuid(), 2, 0L);
                                            groupMember2.setPortrait(next.getIconUrl());
                                            arrayList5.add(groupMember2);
                                        }
                                    }
                                    bIMValueCallBack.onResult(0, "", arrayList5);
                                }
                            });
                            return;
                        } else {
                            bIMValueCallBack.onResult(0, "", arrayList5);
                            return;
                        }
                    }
                    bIMValueCallBack.onResult(0, "", groupMember);
                }
            });
        }
    }

    public void getForwardUserList(BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        if (AccountManager.isLogin(mContext)) {
            IMQueryForwardUserList iMQueryForwardUserList = new IMQueryForwardUserList(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack));
            HttpHelper.executor(mContext, iMQueryForwardUserList, iMQueryForwardUserList);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getGlobalDisturbStatus(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        IMQueryGlobalConfRequest iMQueryGlobalConfRequest = new IMQueryGlobalConfRequest(context, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext));
        HttpHelper.executor(mContext, iMQueryGlobalConfRequest, iMQueryGlobalConfRequest);
    }

    public void getGroupList(BIMValueCallBack<ArrayList<String>> bIMValueCallBack, int i2, int i3) {
        if (AccountManager.isLogin(mContext)) {
            ArrayList<String> groupList = GroupInfoDAOImpl.getGroupList(mContext, true, i2, i3);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, groupList);
                return;
            }
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getGroupMember(int i2, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        if (str == null) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (!AccountManager.isLogin(mContext)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else if (i2 == 1) {
            IMQueryMemberRequest iMQueryMemberRequest = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, arrayList, 1);
            HttpHelper.executor(mContext, iMQueryMemberRequest, iMQueryMemberRequest);
        } else {
            ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(mContext, str, arrayList, 0);
            if (groupMember != null && groupMember.size() > 0) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, groupMember);
                    return;
                }
                return;
            }
            long appid = AccountManager.getAppid(mContext);
            IMQueryMemberRequest iMQueryMemberRequest2 = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), appid, str, arrayList, 1);
            HttpHelper.executor(mContext, iMQueryMemberRequest2, iMQueryMemberRequest2);
        }
    }

    public void getGroupsInfo(int i2, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        if (arrayList == null || arrayList.size() == 0) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (!AccountManager.isLogin(mContext)) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        } else if (i2 == 1) {
            IMQueryGroupRequest iMQueryGroupRequest = new IMQueryGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), arrayList, false, null);
            HttpHelper.executor(mContext, iMQueryGroupRequest, iMQueryGroupRequest);
        } else {
            ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList);
            if (groupInfo != null && groupInfo.size() > 0) {
                LogUtils.d(TAG, "getGroupsInfo 0");
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, groupInfo);
                    return;
                }
                return;
            }
            LogUtils.d(TAG, "getGroupsInfo 1");
            IMQueryGroupRequest iMQueryGroupRequest2 = new IMQueryGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), arrayList, false, null);
            HttpHelper.executor(mContext, iMQueryGroupRequest2, iMQueryGroupRequest2);
        }
    }

    public String getNickName(String str, String str2) {
        return GroupInfoDAOImpl.getNickName(mContext, str, str2);
    }

    public void getPaidAndUkByBduid(List<Long> list, BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>> bIMValueCallBack) {
        if (AccountManager.isLogin(mContext)) {
            IMQueryMemberPauidRequest iMQueryMemberPauidRequest = new IMQueryMemberPauidRequest(mContext, list, ListenerManager.getInstance().addListener(bIMValueCallBack));
            HttpHelper.executor(mContext, iMQueryMemberPauidRequest, iMQueryMemberPauidRequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getStarOnline(String str, BIMValueCallBack<Integer> bIMValueCallBack) {
        long j;
        try {
            j = Long.valueOf(str).longValue();
        } catch (NumberFormatException e2) {
            String str2 = TAG;
            LogUtils.e(str2, "groupId : " + str, e2);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            j = -1;
        }
        if (0 > j) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMGetStarOnlineRequest iMGetStarOnlineRequest = new IMGetStarOnlineRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str);
            HttpHelper.executor(mContext, iMGetStarOnlineRequest, iMGetStarOnlineRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void joinGroup(String str, String str2, int i2, String str3, boolean z, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        long j2 = -1;
        try {
            j = Long.valueOf(str).longValue();
        } catch (Exception e2) {
            e = e2;
            j = -1;
        }
        try {
            j2 = Long.valueOf(str2).longValue();
        } catch (Exception e3) {
            e = e3;
            LogUtils.e(TAG, e.getMessage());
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
            long j3 = j2;
            if (j >= 0) {
            }
            if (bIMValueCallBack == null) {
            }
        }
        long j32 = j2;
        if (j >= 0 || j32 < 0) {
            if (bIMValueCallBack == null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMJoinGroupRequest iMJoinGroupRequest = new IMJoinGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), z, str, j32, i2, str3);
            HttpHelper.executor(mContext, iMJoinGroupRequest, iMJoinGroupRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
            }
        }
    }

    public void joinStarGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        try {
            j = Long.valueOf(str).longValue();
        } catch (Exception e2) {
            LogUtils.e(TAG, e2.getMessage());
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            j = -1;
        }
        if (j < 0 && bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
        }
        if (AccountManager.isLogin(mContext)) {
            IMJoinStarGroupRequest iMJoinStarGroupRequest = new IMJoinStarGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str);
            HttpHelper.executor(mContext, iMJoinStarGroupRequest, iMJoinStarGroupRequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
        }
    }

    public void quitFansGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        try {
            j = Long.valueOf(str).longValue();
        } catch (NumberFormatException e2) {
            String str2 = TAG;
            LogUtils.e(str2, "groupId : " + str, e2);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            j = -1;
        }
        if (0 > j) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMQuitGroupRequest iMQuitGroupRequest = new IMQuitGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, true);
            HttpHelper.executor(mContext, iMQuitGroupRequest, iMQuitGroupRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
            }
        }
    }

    public void quitGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        try {
            j = Long.valueOf(str).longValue();
        } catch (NumberFormatException e2) {
            String str2 = TAG;
            LogUtils.e(str2, "groupId : " + str, e2);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            j = -1;
        }
        if (0 > j) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMQuitGroupRequest iMQuitGroupRequest = new IMQuitGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, false);
            HttpHelper.executor(mContext, iMQuitGroupRequest, iMQuitGroupRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
            }
        }
    }

    public void quitStarGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        try {
            j = Long.valueOf(str).longValue();
        } catch (NumberFormatException e2) {
            String str2 = TAG;
            LogUtils.e(str2, "groupId : " + str, e2);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            j = -1;
        }
        if (0 > j) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMQuitStarGroupRequest iMQuitStarGroupRequest = new IMQuitStarGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, AccountManager.getUid(mContext));
            HttpHelper.executor(mContext, iMQuitStarGroupRequest, iMQuitStarGroupRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
            }
        }
    }

    public void sendFansGroupInviteMsg(final String str, List<Long> list, final ISendMessageListener iSendMessageListener) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            final AtomicInteger atomicInteger = new AtomicInteger(list.size());
            getPaidAndUkByBduid(list, new BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>>() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i2, String str2, List<IMQueryMemberPauidRequest.UserId> list2) {
                    if (i2 == 0 && list2 != null) {
                        for (final IMQueryMemberPauidRequest.UserId userId : list2) {
                            final long pauid = userId.getPauid();
                            int i3 = (pauid > 0L ? 1 : (pauid == 0L ? 0 : -1));
                            long uk = i3 == 0 ? userId.getUk() : pauid;
                            int i4 = i3 == 0 ? 0 : 7;
                            ChatMsg inviteMsg = GroupManagerImpl.this.getInviteMsg(str, i4, userId.getBduid(), uk);
                            if (AccountManager.getMediaRole(GroupManagerImpl.mContext)) {
                                final String paThirdId = PaManagerImpl.getInstance(GroupManagerImpl.mContext).getPaThirdId(pauid);
                                final int businessType = Utility.getBusinessType(i4, 0);
                                ChatMsgManagerImpl.getInstance(GroupManagerImpl.mContext).mediaSendChatMsg(userId.getBduid(), businessType, pauid, paThirdId, inviteMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6.1
                                    @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                                    public void onMediaSendChatMsgResult(int i5, ChatMsg chatMsg) {
                                        if (i5 == 0) {
                                            Utility.transformMediaNotify(GroupManagerImpl.mContext, businessType, userId.getBduid(), pauid, paThirdId, 2, -1L);
                                        }
                                        if (atomicInteger.decrementAndGet() == 0) {
                                            iSendMessageListener.onSendMessageResult(0, chatMsg);
                                        }
                                    }
                                });
                            } else {
                                ChatMsgManagerImpl.getInstance(GroupManagerImpl.mContext).sendMessage(inviteMsg, new ISendMessageListener() { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6.2
                                    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
                                    public void onSendMessageResult(int i5, ChatMsg chatMsg) {
                                        if (i5 == 0) {
                                            Utility.transformMediaNotify(GroupManagerImpl.mContext, 1, userId.getBduid(), -1L, "", 2, -1L);
                                        }
                                        if (atomicInteger.decrementAndGet() == 0) {
                                            iSendMessageListener.onSendMessageResult(0, chatMsg);
                                        }
                                    }
                                });
                            }
                        }
                        return;
                    }
                    iSendMessageListener.onSendMessageResult(6, null);
                }
            });
        } else if (iSendMessageListener != null) {
            iSendMessageListener.onSendMessageResult(1005, null);
        }
    }

    public void setGroupDisturb(String str, int i2, BIMValueCallBack<String> bIMValueCallBack) {
        IMGroupSetRequest iMGroupSetRequest = new IMGroupSetRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, AccountManager.getAppid(mContext), i2);
        HttpHelper.executor(mContext, iMGroupSetRequest, iMGroupSetRequest);
    }

    public void setNickName(String str, long j, String str2, boolean z, BIMValueCallBack<String> bIMValueCallBack) {
        IMSetNickNameRequest iMSetNickNameRequest = new IMSetNickNameRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), z, str, str2, j);
        HttpHelper.executor(mContext, iMSetNickNameRequest, iMSetNickNameRequest);
    }

    public void updateGroupName(String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        if (str == null || str2 == null || !isValidGroupName(str2)) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMUpdateGroupNameRequest iMUpdateGroupNameRequest = new IMUpdateGroupNameRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, str2);
            HttpHelper.executor(mContext, iMUpdateGroupNameRequest, iMUpdateGroupNameRequest);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
            }
        }
    }

    public ArrayList<GroupMember> getNickName(String str) {
        return GroupInfoDAOImpl.getMemberNickname(mContext, str);
    }

    public void getGroupList(BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        if (AccountManager.isLogin(mContext)) {
            IMQueryGroupListRequest iMQueryGroupListRequest = new IMQueryGroupListRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext));
            HttpHelper.executor(mContext, iMQueryGroupListRequest, iMQueryGroupListRequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }
}
