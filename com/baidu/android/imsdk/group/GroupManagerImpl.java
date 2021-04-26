package com.baidu.android.imsdk.group;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.request.IMAddGroupMemberRequest;
import com.baidu.android.imsdk.group.request.IMCreateGroupRequest;
import com.baidu.android.imsdk.group.request.IMDelGroupMemberRequest;
import com.baidu.android.imsdk.group.request.IMDelStarMemberRequest;
import com.baidu.android.imsdk.group.request.IMGetStarOnlineRequest;
import com.baidu.android.imsdk.group.request.IMGroupSetRequest;
import com.baidu.android.imsdk.group.request.IMJoinGroupRequest;
import com.baidu.android.imsdk.group.request.IMJoinStarGroupRequest;
import com.baidu.android.imsdk.group.request.IMQueryGlobalConfRequest;
import com.baidu.android.imsdk.group.request.IMQueryGroupListRequest;
import com.baidu.android.imsdk.group.request.IMQueryGroupRequest;
import com.baidu.android.imsdk.group.request.IMQueryMemberRequest;
import com.baidu.android.imsdk.group.request.IMQuitGroupRequest;
import com.baidu.android.imsdk.group.request.IMQuitStarGroupRequest;
import com.baidu.android.imsdk.group.request.IMSetNickNameRequest;
import com.baidu.android.imsdk.group.request.IMUpdateGroupNameRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IHeartBeat;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
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

    private boolean isValidGroupName(String str) {
        if (str == null) {
            return true;
        }
        return str.length() <= 32 && !EmojionUtils.containsEmoji(str);
    }

    public void addGroupMembers(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        long j;
        try {
            j = Long.parseLong(str);
        } catch (Exception e2) {
            LogUtils.e(TAG, Constants.ERROR_MSG_PARAMETER_ERROR);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            j = 0;
        }
        if (j <= 0 || arrayList == null || arrayList.size() == 0 || arrayList.size() > 64) {
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        } else if (AccountManager.isLogin(mContext)) {
            IMAddGroupMemberRequest iMAddGroupMemberRequest = new IMAddGroupMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), j, arrayList, false);
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
            IMQueryMemberRequest iMQueryMemberRequest2 = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, arrayList, 1);
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
                Iterator<GroupInfo> it = groupInfo.iterator();
                while (it.hasNext()) {
                    GroupInfo next = it.next();
                    next.setHeadUrl(next.getHeadUrl());
                }
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void joinGroup(String str, String str2, int i2, String str3, BIMValueCallBack<String> bIMValueCallBack) {
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
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            if (!AccountManager.isLogin(mContext)) {
            }
        }
        long j32 = j2;
        if ((j >= 0 || j32 < 0) && bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
        }
        if (!AccountManager.isLogin(mContext)) {
            IMJoinGroupRequest iMJoinGroupRequest = new IMJoinGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, j32, i2, str3);
            HttpHelper.executor(mContext, iMJoinGroupRequest, iMJoinGroupRequest);
            return;
        }
        LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        if (bIMValueCallBack != null) {
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
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
            IMQuitGroupRequest iMQuitGroupRequest = new IMQuitGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, AccountManager.getUid(mContext));
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

    public void setGroupDisturb(String str, int i2, BIMValueCallBack<String> bIMValueCallBack) {
        IMGroupSetRequest iMGroupSetRequest = new IMGroupSetRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, AccountManager.getAppid(mContext), i2);
        HttpHelper.executor(mContext, iMGroupSetRequest, iMGroupSetRequest);
    }

    public void setNickName(String str, long j, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        IMSetNickNameRequest iMSetNickNameRequest = new IMSetNickNameRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, str2, j);
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
