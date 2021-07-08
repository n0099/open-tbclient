package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GroupManagerImpl";
    public static Context mContext;
    public static volatile GroupManagerImpl mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public IHeartBeat mHeartbeat;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1867817590, "Lcom/baidu/android/imsdk/group/GroupManagerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1867817590, "Lcom/baidu/android/imsdk/group/GroupManagerImpl;");
        }
    }

    public GroupManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHeartbeat = new IHeartBeat(this) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GroupManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.internal.IHeartBeat
            public void onHeartBeat() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    GroupInfoSyncManagerImpl.activeSyncAllGroup(GroupManagerImpl.mContext);
                }
            }
        };
        IMSDK.getInstance(mContext).registerHeartbeatListener(this.mHeartbeat);
    }

    public static synchronized GroupManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        GroupManagerImpl groupManagerImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (GroupManagerImpl.class) {
                if (mInstance == null) {
                    mContext = context.getApplicationContext();
                    mInstance = new GroupManagerImpl();
                }
                groupManagerImpl = mInstance;
            }
            return groupManagerImpl;
        }
        return (GroupManagerImpl) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatMsg getInviteMsg(String str, int i2, long j, long j2) {
        String str2;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
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
        return (ChatMsg) invokeCommon.objValue;
    }

    private boolean isValidGroupName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            if (str == null) {
                return true;
            }
            return str.length() <= 32 && !EmojionUtils.containsEmoji(str);
        }
        return invokeL.booleanValue;
    }

    public void addGroupMembers(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, arrayList, bIMValueCallBack) == null) {
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
    }

    public void createGroup(int i2, String str, ArrayList<String> arrayList, BIMValueCallBack<CreateResultInfo> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, arrayList, bIMValueCallBack}) == null) {
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
    }

    public void delFansGroupMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, arrayList, bIMValueCallBack) == null) {
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
    }

    public void delGroupMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, arrayList, bIMValueCallBack) == null) {
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
    }

    public void delStarMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, arrayList, bIMValueCallBack) == null) {
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
    }

    public void getAllGroupList(BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bIMValueCallBack) == null) {
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
    }

    public void getAllGroupMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, arrayList, bIMValueCallBack) == null) {
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
    }

    public void getFansGroupInfo(ArrayList<String> arrayList, boolean z, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{arrayList, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                if (AccountManager.isLogin(mContext)) {
                    TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, z, arrayList, bIMValueCallBack) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ GroupManagerImpl this$0;
                        public final /* synthetic */ ArrayList val$groupIds;
                        public final /* synthetic */ BIMValueCallBack val$listener;
                        public final /* synthetic */ boolean val$network;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Boolean.valueOf(z), arrayList, bIMValueCallBack};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$network = z;
                            this.val$groupIds = arrayList;
                            this.val$listener = bIMValueCallBack;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (!this.val$network) {
                                    ArrayList<GroupInfo> groupInfo = GroupInfoDAOImpl.getGroupInfo(GroupManagerImpl.mContext, this.val$groupIds);
                                    if (groupInfo != null && groupInfo.size() == this.val$groupIds.size()) {
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
                                        this.val$listener.onResult(0, null, groupInfo);
                                        return;
                                    }
                                }
                                IMQueryFansGroupRequest iMQueryFansGroupRequest = new IMQueryFansGroupRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(this.val$listener), this.val$groupIds);
                                HttpHelper.executor(GroupManagerImpl.mContext, iMQueryFansGroupRequest, iMQueryFansGroupRequest);
                            }
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
    }

    public void getFansGroupInviteMembers(String str, BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bIMValueCallBack) == null) || bIMValueCallBack == null) {
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

    public void getFansGroupList(boolean z, BIMValueCallBack<List<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext)) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, z, bIMValueCallBack) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GroupManagerImpl this$0;
                    public final /* synthetic */ BIMValueCallBack val$listener;
                    public final /* synthetic */ boolean val$network;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z), bIMValueCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$network = z;
                        this.val$listener = bIMValueCallBack;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!this.val$network) {
                                this.val$listener.onResult(0, null, GroupInfoDAOImpl.getAllFansGroupList(GroupManagerImpl.mContext));
                                return;
                            }
                            IMQueryFansGroupListRequest iMQueryFansGroupListRequest = new IMQueryFansGroupListRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(this.val$listener));
                            HttpHelper.executor(GroupManagerImpl.mContext, iMQueryFansGroupListRequest, iMQueryFansGroupListRequest);
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void getFansGroupMember(String str, ArrayList<String> arrayList, boolean z, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, arrayList, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            if (str == null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            } else if (AccountManager.isLogin(mContext)) {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, z, str, arrayList, bIMValueCallBack) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GroupManagerImpl this$0;
                    public final /* synthetic */ ArrayList val$buids;
                    public final /* synthetic */ String val$groupId;
                    public final /* synthetic */ BIMValueCallBack val$listener;
                    public final /* synthetic */ boolean val$network;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z), str, arrayList, bIMValueCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$network = z;
                        this.val$groupId = str;
                        this.val$buids = arrayList;
                        this.val$listener = bIMValueCallBack;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList arrayList2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!this.val$network) {
                                ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(GroupManagerImpl.mContext, this.val$groupId, this.val$buids, 0);
                                if ((this.val$buids == null && groupMember != null && groupMember.size() > 0) || ((arrayList2 = this.val$buids) != null && groupMember != null && arrayList2.size() == groupMember.size())) {
                                    this.val$listener.onResult(0, null, groupMember);
                                    return;
                                }
                            }
                            IMQueryFansMemberRequest iMQueryFansMemberRequest = new IMQueryFansMemberRequest(GroupManagerImpl.mContext, ListenerManager.getInstance().addListener(this.val$listener), this.val$groupId, this.val$buids);
                            HttpHelper.executor(GroupManagerImpl.mContext, iMQueryFansMemberRequest, iMQueryFansMemberRequest);
                        }
                    }
                });
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                }
            }
        }
    }

    public void getFansGroupQrCode(String str, BIMValueCallBack<IMQueryFansGroupQrCodeRequest.QrCode> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, bIMValueCallBack) == null) {
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
    }

    public void getFansGroupUnreadStatus(BIMValueCallBack<Integer> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bIMValueCallBack) == null) {
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
    }

    public void getFansGroupUserInfo(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, arrayList, bIMValueCallBack) == null) {
            if (str == null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            } else {
                TaskManager.getInstance(mContext).submitForNetWork(new Runnable(this, str, arrayList, bIMValueCallBack) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GroupManagerImpl this$0;
                    public final /* synthetic */ ArrayList val$buids;
                    public final /* synthetic */ String val$groupId;
                    public final /* synthetic */ BIMValueCallBack val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, arrayList, bIMValueCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$groupId = str;
                        this.val$buids = arrayList;
                        this.val$listener = bIMValueCallBack;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(GroupManagerImpl.mContext, this.val$groupId, this.val$buids, 0);
                            ArrayList arrayList2 = this.val$buids;
                            if (arrayList2 != null && arrayList2.size() != 0 && (groupMember == null || groupMember.size() != this.val$buids.size())) {
                                ArrayList arrayList3 = new ArrayList();
                                if (groupMember != null && groupMember.size() > 0) {
                                    Iterator<GroupMember> it = groupMember.iterator();
                                    while (it.hasNext()) {
                                        arrayList3.add(Long.valueOf(it.next().getBduid()));
                                    }
                                }
                                ArrayList arrayList4 = new ArrayList();
                                Iterator it2 = this.val$buids.iterator();
                                while (it2.hasNext()) {
                                    long longByString = Utility.getLongByString((String) it2.next(), 0L);
                                    if (longByString != 0) {
                                        arrayList4.add(Long.valueOf(longByString));
                                    }
                                }
                                arrayList4.removeAll(arrayList3);
                                ArrayList arrayList5 = new ArrayList();
                                if (groupMember != null) {
                                    arrayList5.addAll(groupMember);
                                }
                                if (arrayList4.size() > 0) {
                                    ChatUserManager.getUsersProfileBatch(GroupManagerImpl.mContext, arrayList4, new IGetUsersProfileBatchListener(this, arrayList5) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.3.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass3 this$1;
                                        public final /* synthetic */ ArrayList val$result;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, arrayList5};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$result = arrayList5;
                                        }

                                        @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
                                        public void onGetUsersProfileBatchResult(int i2, String str2, ArrayList<Long> arrayList6, ArrayList<ChatUser> arrayList7) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, arrayList6, arrayList7}) == null) {
                                                if (i2 == 0 && arrayList7 != null && arrayList7.size() > 0) {
                                                    Iterator<ChatUser> it3 = arrayList7.iterator();
                                                    while (it3.hasNext()) {
                                                        ChatUser next = it3.next();
                                                        GroupMember groupMember2 = new GroupMember(this.this$1.val$groupId, next.getUk(), next.getUserName(), next.getBuid(), 2, 0L);
                                                        groupMember2.setPortrait(next.getIconUrl());
                                                        this.val$result.add(groupMember2);
                                                    }
                                                }
                                                this.this$1.val$listener.onResult(0, "", this.val$result);
                                            }
                                        }
                                    });
                                    return;
                                } else {
                                    this.val$listener.onResult(0, "", arrayList5);
                                    return;
                                }
                            }
                            this.val$listener.onResult(0, "", groupMember);
                        }
                    }
                });
            }
        }
    }

    public void getForwardUserList(BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bIMValueCallBack) == null) {
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
    }

    public void getGlobalDisturbStatus(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, bIMValueCallBack) == null) {
            IMQueryGlobalConfRequest iMQueryGlobalConfRequest = new IMQueryGlobalConfRequest(context, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext));
            HttpHelper.executor(mContext, iMQueryGlobalConfRequest, iMQueryGlobalConfRequest);
        }
    }

    public void getGroupList(BIMValueCallBack<ArrayList<String>> bIMValueCallBack, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, bIMValueCallBack, i2, i3) == null) {
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
    }

    public void getGroupMember(int i2, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), str, arrayList, bIMValueCallBack}) == null) {
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
                if (groupMember == null || groupMember.size() <= 0) {
                    IMQueryMemberRequest iMQueryMemberRequest2 = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, arrayList, 1);
                    HttpHelper.executor(mContext, iMQueryMemberRequest2, iMQueryMemberRequest2);
                } else if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, groupMember);
                }
            }
        }
    }

    public void getGroupsInfo(int i2, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048595, this, i2, arrayList, bIMValueCallBack) == null) {
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
    }

    public String getNickName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) ? GroupInfoDAOImpl.getNickName(mContext, str, str2) : (String) invokeLL.objValue;
    }

    public void getPaidAndUkByBduid(List<Long> list, BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, list, bIMValueCallBack) == null) {
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
    }

    public void getStarOnline(String str, BIMValueCallBack<Integer> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, bIMValueCallBack) == null) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void joinGroup(String str, String str2, int i2, String str3, boolean z, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Boolean.valueOf(z), bIMValueCallBack}) == null) {
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
    }

    public void joinStarGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, bIMValueCallBack) == null) {
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
    }

    public void quitFansGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, bIMValueCallBack) == null) {
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
    }

    public void quitGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, bIMValueCallBack) == null) {
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
    }

    public void quitStarGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, bIMValueCallBack) == null) {
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
    }

    public void sendFansGroupInviteMsg(String str, List<Long> list, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, str, list, iSendMessageListener) == null) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                getPaidAndUkByBduid(list, new BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>>(this, str, new AtomicInteger(list.size()), iSendMessageListener) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GroupManagerImpl this$0;
                    public final /* synthetic */ AtomicInteger val$count;
                    public final /* synthetic */ String val$groupId;
                    public final /* synthetic */ ISendMessageListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, r8, iSendMessageListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$groupId = str;
                        this.val$count = r8;
                        this.val$listener = iSendMessageListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                    public void onResult(int i2, String str2, List<IMQueryMemberPauidRequest.UserId> list2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, list2) == null) {
                            if (i2 == 0 && list2 != null) {
                                for (IMQueryMemberPauidRequest.UserId userId : list2) {
                                    long pauid = userId.getPauid();
                                    int i3 = (pauid > 0L ? 1 : (pauid == 0L ? 0 : -1));
                                    long uk = i3 == 0 ? userId.getUk() : pauid;
                                    int i4 = i3 == 0 ? 0 : 7;
                                    ChatMsg inviteMsg = this.this$0.getInviteMsg(this.val$groupId, i4, userId.getBduid(), uk);
                                    if (AccountManager.getMediaRole(GroupManagerImpl.mContext)) {
                                        String paThirdId = PaManagerImpl.getInstance(GroupManagerImpl.mContext).getPaThirdId(pauid);
                                        int businessType = Utility.getBusinessType(i4, 0);
                                        ChatMsgManagerImpl.getInstance(GroupManagerImpl.mContext).mediaSendChatMsg(userId.getBduid(), businessType, pauid, paThirdId, inviteMsg, new IMediaSendChatMsgListener(this, businessType, userId, pauid, paThirdId) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass6 this$1;
                                            public final /* synthetic */ int val$businessType;
                                            public final /* synthetic */ long val$paid;
                                            public final /* synthetic */ String val$thirdId;
                                            public final /* synthetic */ IMQueryMemberPauidRequest.UserId val$userId;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, Integer.valueOf(businessType), userId, Long.valueOf(pauid), paThirdId};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i5 = newInitContext.flag;
                                                    if ((i5 & 1) != 0) {
                                                        int i6 = i5 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$1 = this;
                                                this.val$businessType = businessType;
                                                this.val$userId = userId;
                                                this.val$paid = pauid;
                                                this.val$thirdId = paThirdId;
                                            }

                                            @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                                            public void onMediaSendChatMsgResult(int i5, ChatMsg chatMsg) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i5, chatMsg) == null) {
                                                    if (i5 == 0) {
                                                        Utility.transformMediaNotify(GroupManagerImpl.mContext, this.val$businessType, this.val$userId.getBduid(), this.val$paid, this.val$thirdId, 2, -1L);
                                                    }
                                                    if (this.this$1.val$count.decrementAndGet() == 0) {
                                                        this.this$1.val$listener.onSendMessageResult(0, chatMsg);
                                                    }
                                                }
                                            }
                                        });
                                    } else {
                                        ChatMsgManagerImpl.getInstance(GroupManagerImpl.mContext).sendMessage(inviteMsg, new ISendMessageListener(this, userId) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass6 this$1;
                                            public final /* synthetic */ IMQueryMemberPauidRequest.UserId val$userId;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, userId};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i5 = newInitContext.flag;
                                                    if ((i5 & 1) != 0) {
                                                        int i6 = i5 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$1 = this;
                                                this.val$userId = userId;
                                            }

                                            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
                                            public void onSendMessageResult(int i5, ChatMsg chatMsg) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i5, chatMsg) == null) {
                                                    if (i5 == 0) {
                                                        Utility.transformMediaNotify(GroupManagerImpl.mContext, 1, this.val$userId.getBduid(), -1L, "", 2, -1L);
                                                    }
                                                    if (this.this$1.val$count.decrementAndGet() == 0) {
                                                        this.this$1.val$listener.onSendMessageResult(0, chatMsg);
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }
                                return;
                            }
                            this.val$listener.onSendMessageResult(6, null);
                        }
                    }
                });
            } else if (iSendMessageListener != null) {
                iSendMessageListener.onSendMessageResult(1005, null);
            }
        }
    }

    public void setGroupDisturb(String str, int i2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048606, this, str, i2, bIMValueCallBack) == null) {
            IMGroupSetRequest iMGroupSetRequest = new IMGroupSetRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, AccountManager.getAppid(mContext), i2);
            HttpHelper.executor(mContext, iMGroupSetRequest, iMGroupSetRequest);
        }
    }

    public void setNickName(String str, long j, String str2, boolean z, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{str, Long.valueOf(j), str2, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            IMSetNickNameRequest iMSetNickNameRequest = new IMSetNickNameRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), z, str, str2, j);
            HttpHelper.executor(mContext, iMSetNickNameRequest, iMSetNickNameRequest);
        }
    }

    public void updateGroupName(String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, str, str2, bIMValueCallBack) == null) {
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
    }

    public ArrayList<GroupMember> getNickName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? GroupInfoDAOImpl.getMemberNickname(mContext, str) : (ArrayList) invokeL.objValue;
    }

    public void getGroupList(BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bIMValueCallBack) == null) {
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
}
