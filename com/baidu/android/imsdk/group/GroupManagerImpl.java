package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupInviteMsg;
import com.baidu.android.imsdk.chatmessage.request.IMQueryFansUnreadRequest;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
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
import com.baidu.android.imsdk.group.request.IMGetFansJoinGroupApplyCountRequest;
import com.baidu.android.imsdk.group.request.IMGetFansJoinGroupApplyState;
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
import com.baidu.android.imsdk.group.request.IMSetFansGroupWelcomeDataRequest;
import com.baidu.android.imsdk.group.request.IMSetFansGroupWelcomeDisplayScopeRequest;
import com.baidu.android.imsdk.group.request.IMSetGroupNoticeRequest;
import com.baidu.android.imsdk.group.request.IMSetNickNameRequest;
import com.baidu.android.imsdk.group.request.IMUpdateGroupNameRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.utils.DataUtil;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
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

    private boolean isValidGroupName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (str == null) {
                return true;
            }
            if (str.length() <= 32 && !EmojionUtils.containsEmoji(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ArrayList<GroupMember> getNickName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            return GroupInfoDAOImpl.getMemberNickname(mContext, str);
        }
        return (ArrayList) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatMsg getInviteMsg(String str, int i, long j, long j2) {
        String str2;
        String uid;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
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
            if (TextUtils.isEmpty(AccountManager.getUid(mContext))) {
                uid = "0";
            } else {
                uid = AccountManager.getUid(mContext);
            }
            fansGroupInviteMsg.setSenderUid(uid);
            fansGroupInviteMsg.setCategory(0);
            fansGroupInviteMsg.setChatType(i);
            fansGroupInviteMsg.setContacterBduid(String.valueOf(j));
            fansGroupInviteMsg.setContacter(j2);
            fansGroupInviteMsg.setMsgTime(System.currentTimeMillis() / 1000);
            return fansGroupInviteMsg;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public void getGroupMember(int i, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), str, arrayList, bIMValueCallBack}) == null) {
            if (str == null) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                }
            } else if (AccountManager.isLogin(mContext)) {
                if (i == 1) {
                    IMQueryMemberRequest iMQueryMemberRequest = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, arrayList, 1);
                    HttpHelper.executor(mContext, iMQueryMemberRequest, iMQueryMemberRequest);
                    return;
                }
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
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                }
            }
        }
    }

    private void uploadGroupRequestFailInfo(int i, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4}) == null) {
            CaseUbc.DebugInfo debugInfo = new CaseUbc.DebugInfo();
            debugInfo.curClassName = TAG;
            debugInfo.extInfo = str;
            debugInfo.extInfo += ",param groupId = " + str3;
            debugInfo.extInfo += ",custom param = " + str4;
            CaseUbc.debugUbc(mContext, str2, i, "", debugInfo);
        }
    }

    public void addGroupMembers(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, arrayList, bIMValueCallBack) == null) {
            long longByString = Utility.getLongByString(str, 0L);
            int i = 0;
            if (longByString > 0 && arrayList != null && arrayList.size() != 0 && arrayList.size() <= 64) {
                if (AccountManager.isLogin(mContext)) {
                    IMAddGroupMemberRequest iMAddGroupMemberRequest = new IMAddGroupMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), longByString, arrayList, false);
                    HttpHelper.executor(mContext, iMAddGroupMemberRequest, iMAddGroupMemberRequest);
                    return;
                }
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (arrayList != null) {
                    i = arrayList.size();
                }
                uploadGroupRequestFailInfo(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, "addGroupMembers", str, "request members size = " + i);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                    return;
                }
                return;
            }
            if (arrayList != null) {
                i = arrayList.size();
            }
            uploadGroupRequestFailInfo(1005, Constants.ERROR_MSG_PARAMETER_ERROR, "addGroupMembers", str, "request members size = " + i);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        }
    }

    public void getAllGroupMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        int i;
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
            if (groupInfo != null && groupInfo.size() > 0) {
                i = groupInfo.get(0).getNum();
            } else {
                i = 0;
            }
            ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(mContext, str, arrayList, 0);
            if (groupMember != null && groupMember.size() > 0) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(0, Constants.ERROR_MSG_SUCCESS, groupMember);
                }
                if (i > 0 && groupMember.size() != i) {
                    LogUtils.d(TAG, "to update group member");
                    IMQueryMemberRequest iMQueryMemberRequest = new IMQueryMemberRequest(mContext, "", AccountManager.getAppid(mContext), str, arrayList, 1);
                    HttpHelper.executor(mContext, iMQueryMemberRequest, iMQueryMemberRequest);
                    return;
                }
                return;
            }
            IMQueryMemberRequest iMQueryMemberRequest2 = new IMQueryMemberRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, arrayList, 1);
            HttpHelper.executor(mContext, iMQueryMemberRequest2, iMQueryMemberRequest2);
        }
    }

    public void getFansGroupOwnerInfo(String str, boolean z, BIMValueCallBack<GroupMember> bIMValueCallBack) {
        GroupInfo groupInfo;
        GroupMember groupOwner;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(str)) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, "groupId empty", null);
                }
            } else if (z && (groupOwner = GroupMessageManagerImpl.getInstance(mContext).getGroupOwner(str)) != null) {
                bIMValueCallBack.onResult(0, "success", groupOwner);
            } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                ArrayList<GroupInfo> groupInfo2 = GroupInfoDAOImpl.getGroupInfo(mContext, arrayList2);
                if (groupInfo2 != null && groupInfo2.size() > 0 && (groupInfo = groupInfo2.get(0)) != null) {
                    arrayList = new ArrayList();
                    arrayList.add(String.valueOf(groupInfo.getBuid()));
                }
                IMQueryFansMemberRequest iMQueryFansMemberRequest = new IMQueryFansMemberRequest(mContext, ListenerManager.getInstance().addListener(new BIMValueCallBack<ArrayList<GroupMember>>(this, bIMValueCallBack) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GroupManagerImpl this$0;
                    public final /* synthetic */ BIMValueCallBack val$requestCallback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bIMValueCallBack};
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
                        this.val$requestCallback = bIMValueCallBack;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                    public void onResult(int i, String str2, ArrayList<GroupMember> arrayList3) {
                        GroupMember groupMember;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, arrayList3) == null) {
                            if (i == 0 && !DataUtil.isListEmpty(arrayList3)) {
                                Iterator<GroupMember> it = arrayList3.iterator();
                                while (it.hasNext()) {
                                    groupMember = it.next();
                                    if (groupMember.getRole() == 1) {
                                        break;
                                    }
                                }
                            }
                            groupMember = null;
                            this.val$requestCallback.onResult(i, str2, groupMember);
                        }
                    }
                }), str, arrayList);
                HttpHelper.executor(mContext, iMQueryFansMemberRequest, iMQueryFansMemberRequest);
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                }
            }
        }
    }

    public void getGroupsInfo(int i, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048600, this, i, arrayList, bIMValueCallBack) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                if (AccountManager.isLogin(mContext)) {
                    if (i == 1) {
                        IMQueryGroupRequest iMQueryGroupRequest = new IMQueryGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), arrayList, false, null);
                        HttpHelper.executor(mContext, iMQueryGroupRequest, iMQueryGroupRequest);
                        return;
                    }
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
                } else if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                }
            } else if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            }
        }
    }

    public void createGroup(int i, String str, ArrayList<String> arrayList, BIMValueCallBack<CreateResultInfo> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, arrayList, bIMValueCallBack}) == null) {
            if (!isValidGroupName(str)) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                }
            } else if (AccountManager.isLogin(mContext)) {
                IMCreateGroupRequest iMCreateGroupRequest = new IMCreateGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), i, str, arrayList);
                HttpHelper.executor(mContext, iMCreateGroupRequest, iMCreateGroupRequest);
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                }
            }
        }
    }

    public void getFansGroupMember(String str, ArrayList<String> arrayList, boolean z, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, arrayList, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            if (str == null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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

    public void delFansGroupMember(String str, ArrayList<String> arrayList, int i, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, str, arrayList, i, bIMValueCallBack) == null) {
            if (str != null && arrayList != null && arrayList.size() != 0) {
                if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                    IMDelFansGroupMemberRequest iMDelFansGroupMemberRequest = new IMDelFansGroupMemberRequest(mContext, str, arrayList, ListenerManager.getInstance().addListener(bIMValueCallBack), i);
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

    public void setFansGroupWelcomeData(String str, String str2, int i, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048612, this, str, str2, i, bIMValueCallBack) == null) {
            if (str == null) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, "group id is null", null);
                }
            } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMSetFansGroupWelcomeDataRequest iMSetFansGroupWelcomeDataRequest = new IMSetFansGroupWelcomeDataRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, str2, i);
                HttpHelper.executor(mContext, iMSetFansGroupWelcomeDataRequest, iMSetFansGroupWelcomeDataRequest);
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                }
            }
        }
    }

    public void delGroupMember(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, arrayList, bIMValueCallBack) == null) {
            try {
                j = Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                String str2 = TAG;
                LogUtils.e(str2, "groupId : " + str, e);
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
            } catch (NumberFormatException e) {
                String str2 = TAG;
                LogUtils.e(str2, "groupId : " + str, e);
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

    public void getFansGroupUnreadStatus(BIMValueCallBack<Integer> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
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

    public void getForwardUserList(BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
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

    public void getGroupList(BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bIMValueCallBack) == null) {
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

    public void getCurrentUserGroupApplyStateFromServer(String str, BIMValueCallBack<Integer> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMGetFansJoinGroupApplyState iMGetFansJoinGroupApplyState = new IMGetFansJoinGroupApplyState(mContext, str, ListenerManager.getInstance().addListener(bIMValueCallBack));
                HttpHelper.executor(mContext, iMGetFansJoinGroupApplyState, iMGetFansJoinGroupApplyState);
                return;
            }
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, 0);
            }
        }
    }

    public void getFansGroupInviteMembers(String str, BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, str, bIMValueCallBack) != null) || bIMValueCallBack == null) {
            return;
        }
        if (str == null) {
            bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            IMGetFansGroupInviteMember iMGetFansGroupInviteMember = new IMGetFansGroupInviteMember(mContext, str, ListenerManager.getInstance().addListener(bIMValueCallBack));
            HttpHelper.executor(mContext, iMGetFansGroupInviteMember, iMGetFansGroupInviteMember);
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void getFansGroupAdministrators(String str, BIMValueCallBack<List<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bIMValueCallBack) == null) {
            if (TextUtils.isEmpty(str)) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, "groupId empty", null);
                    return;
                }
                return;
            }
            bIMValueCallBack.onResult(0, "succeed", GroupMessageManagerImpl.getInstance(mContext).getGroupAdministrators(str));
        }
    }

    public void getGlobalDisturbStatus(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, bIMValueCallBack) == null) {
            IMQueryGlobalConfRequest iMQueryGlobalConfRequest = new IMQueryGlobalConfRequest(context, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext));
            HttpHelper.executor(mContext, iMQueryGlobalConfRequest, iMQueryGlobalConfRequest);
        }
    }

    public String getNickName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
            return GroupInfoDAOImpl.getNickName(mContext, str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public int getRole(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            return GroupInfoDAOImpl.getRole(mContext, str, str2);
        }
        return invokeLL.intValue;
    }

    public void getFansGroupApplyCountFromServer(List<String> list, BIMValueCallBack<ArrayList<GroupApplyBean>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, list, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMGetFansJoinGroupApplyCountRequest iMGetFansJoinGroupApplyCountRequest = new IMGetFansJoinGroupApplyCountRequest(mContext, list, ListenerManager.getInstance().addListener(bIMValueCallBack));
                HttpHelper.executor(mContext, iMGetFansJoinGroupApplyCountRequest, iMGetFansJoinGroupApplyCountRequest);
                return;
            }
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void getFansGroupList(boolean z, BIMValueCallBack<List<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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

    public void getFansGroupNormalRoleMembers(String str, BIMValueCallBack<List<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, bIMValueCallBack) == null) {
            if (TextUtils.isEmpty(str)) {
                String str2 = TAG;
                LogUtils.d(str2, "getGroupNormalRoleMembers failed, groupId empty:" + TextUtils.isEmpty(str));
                bIMValueCallBack.onResult(1005, " groupId empty", null);
                return;
            }
            bIMValueCallBack.onResult(0, "succeed", GroupInfoDAOImpl.getGroupNormalRoleMembers(mContext, str));
        }
    }

    public void getFansGroupQrCode(String str, BIMValueCallBack<IMQueryFansGroupQrCodeRequest.QrCode> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
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

    public void getPaidAndUkByBduid(List<Long> list, BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, list, bIMValueCallBack) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
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

    public void getFansGroupInfo(ArrayList<String> arrayList, boolean z, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{arrayList, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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

    public void sendFansGroupInviteMsg(String str, List<Long> list, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, str, list, iSendMessageListener) == null) {
            if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext) && !TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                new AtomicInteger(list.size());
                getPaidAndUkByBduid(list, new BIMValueCallBack<List<IMQueryMemberPauidRequest.UserId>>(this, str, iSendMessageListener) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GroupManagerImpl this$0;
                    public final /* synthetic */ String val$groupId;
                    public final /* synthetic */ ISendMessageListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, iSendMessageListener};
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
                        this.val$groupId = str;
                        this.val$listener = iSendMessageListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                    public void onResult(int i, String str2, List<IMQueryMemberPauidRequest.UserId> list2) {
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, list2) == null) {
                            if (i == 0 && list2 != null) {
                                for (IMQueryMemberPauidRequest.UserId userId : list2) {
                                    long pauid = userId.getPauid();
                                    int i3 = (pauid > 0L ? 1 : (pauid == 0L ? 0 : -1));
                                    if (i3 == 0) {
                                        pauid = userId.getUk();
                                    }
                                    if (i3 == 0) {
                                        i2 = 0;
                                    } else {
                                        i2 = 7;
                                    }
                                    ChatMsg inviteMsg = this.this$0.getInviteMsg(this.val$groupId, i2, userId.getBduid(), pauid);
                                    BIMValueCallBack<SendMsgResponse> bIMValueCallBack = new BIMValueCallBack<SendMsgResponse>(this) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass6 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        /* JADX DEBUG: Method merged with bridge method */
                                        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                        public void onResult(int i4, String str3, SendMsgResponse sendMsgResponse) {
                                            ChatMsg chatMsg;
                                            Interceptable interceptable3 = $ic;
                                            if ((interceptable3 == null || interceptable3.invokeILL(1048576, this, i4, str3, sendMsgResponse) == null) && this.this$1.val$listener != null) {
                                                if (sendMsgResponse == null) {
                                                    chatMsg = null;
                                                } else {
                                                    chatMsg = sendMsgResponse.msg;
                                                }
                                                this.this$1.val$listener.onSendMessageResult(i4, chatMsg);
                                            }
                                        }
                                    };
                                    SendMsgParam.SendMsgParamConstruct sendMsgParamConstruct = new SendMsgParam.SendMsgParamConstruct(this) { // from class: com.baidu.android.imsdk.group.GroupManagerImpl.6.2
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass6 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        @Override // com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam.SendMsgParamConstruct
                                        public void construct(SendMsgParam sendMsgParam) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, sendMsgParam) == null) {
                                                BIMManager.sendChatMsg(GroupManagerImpl.mContext, sendMsgParam);
                                            }
                                        }
                                    };
                                    if (i3 == 0) {
                                        SendMsgParam.newInstanceByUk(GroupManagerImpl.mContext, inviteMsg, pauid, bIMValueCallBack, sendMsgParamConstruct);
                                    } else {
                                        SendMsgParam.newInstanceByPa(GroupManagerImpl.mContext, inviteMsg, pauid, bIMValueCallBack, sendMsgParamConstruct);
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

    public void setFansGroupWelcomeDisplayScope(String str, int i, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048613, this, str, i, bIMValueCallBack) == null) {
            if (TextUtils.isEmpty(str)) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, "group id is null", null);
                }
            } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMSetFansGroupWelcomeDisplayScopeRequest iMSetFansGroupWelcomeDisplayScopeRequest = new IMSetFansGroupWelcomeDisplayScopeRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, i);
                HttpHelper.executor(mContext, iMSetFansGroupWelcomeDisplayScopeRequest, iMSetFansGroupWelcomeDisplayScopeRequest);
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                }
            }
        }
    }

    public void setGroupNotice(String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048615, this, str, str2, bIMValueCallBack) == null) {
            if (str == null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
            } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                IMSetGroupNoticeRequest iMSetGroupNoticeRequest = new IMSetGroupNoticeRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, str2);
                HttpHelper.executor(mContext, iMSetGroupNoticeRequest, iMSetGroupNoticeRequest);
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
            }
        }
    }

    public void updateGroupName(String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048618, this, str, str2, bIMValueCallBack) == null) {
            if (str != null && str2 != null && isValidGroupName(str2)) {
                if (AccountManager.isLogin(mContext)) {
                    IMUpdateGroupNameRequest iMUpdateGroupNameRequest = new IMUpdateGroupNameRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), str, str2);
                    HttpHelper.executor(mContext, iMUpdateGroupNameRequest, iMUpdateGroupNameRequest);
                    return;
                }
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
                }
            } else if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
            }
        }
    }

    public void getFansGroupUserInfo(String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, arrayList, bIMValueCallBack) == null) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$result = arrayList5;
                                        }

                                        @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
                                        public void onGetUsersProfileBatchResult(int i, String str2, ArrayList<Long> arrayList6, ArrayList<ChatUser> arrayList7) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, arrayList6, arrayList7}) == null) {
                                                if (i == 0 && arrayList7 != null && arrayList7.size() > 0) {
                                                    Iterator<ChatUser> it3 = arrayList7.iterator();
                                                    while (it3.hasNext()) {
                                                        ChatUser next = it3.next();
                                                        GroupMember groupMember2 = new GroupMember(this.this$1.val$groupId, next.getUk(), next.getUserName(), next.getBuid(), 0, 0L);
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

    public void setGroupDisturb(String str, int i, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048614, this, str, i, bIMValueCallBack) == null) {
            IMGroupSetRequest iMGroupSetRequest = new IMGroupSetRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), str, AccountManager.getAppid(mContext), i);
            HttpHelper.executor(mContext, iMGroupSetRequest, iMGroupSetRequest);
        }
    }

    public boolean updateGroupMemberRole(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048617, this, str, str2, i)) == null) {
            return GroupMessageManagerImpl.getInstance(mContext).updateGroupMemberRole(str, str2, i);
        }
        return invokeLLI.booleanValue;
    }

    public void getGroupList(BIMValueCallBack<ArrayList<String>> bIMValueCallBack, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, bIMValueCallBack, i, i2) == null) {
            if (AccountManager.isLogin(mContext)) {
                ArrayList<String> groupList = GroupInfoDAOImpl.getGroupList(mContext, true, i, i2);
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

    public void getStarOnline(String str, BIMValueCallBack<Integer> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, str, bIMValueCallBack) == null) {
            try {
                j = Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                String str2 = TAG;
                LogUtils.e(str2, "groupId : " + str, e);
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

    public void joinStarGroup(String str, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, bIMValueCallBack) == null) {
            try {
                j = Long.valueOf(str).longValue();
            } catch (Exception e) {
                LogUtils.e(TAG, e.getMessage());
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
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, bIMValueCallBack) == null) {
            try {
                j = Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                String str2 = TAG;
                LogUtils.e(str2, "groupId : " + str, e);
                j = -1;
            }
            if (0 > j) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
                }
            } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
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
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, bIMValueCallBack) == null) {
            try {
                j = Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                String str2 = TAG;
                LogUtils.e(str2, "groupId : " + str, e);
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
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, bIMValueCallBack) == null) {
            try {
                j = Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                String str2 = TAG;
                LogUtils.e(str2, "groupId : " + str, e);
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void joinGroup(String str, String str2, int i, String str3, boolean z, BIMValueCallBack<String> bIMValueCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, str2, Integer.valueOf(i), str3, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            long j2 = -1;
            try {
                j = Long.valueOf(str).longValue();
            } catch (Exception e) {
                e = e;
                j = -1;
            }
            try {
                j2 = Long.valueOf(str2).longValue();
            } catch (Exception e2) {
                e = e2;
                LogUtils.e(TAG, e.getMessage());
                long j3 = j2;
                if (j >= 0) {
                }
            }
            long j32 = j2;
            if (j >= 0) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, str);
                }
            } else if (AccountManager.isLogin(mContext)) {
                IMJoinGroupRequest iMJoinGroupRequest = new IMJoinGroupRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), z, str, j32, i, str3);
                HttpHelper.executor(mContext, iMJoinGroupRequest, iMJoinGroupRequest);
            } else {
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, str);
                }
            }
        }
    }

    public void setNickName(String str, long j, String str2, boolean z, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{str, Long.valueOf(j), str2, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            IMSetNickNameRequest iMSetNickNameRequest = new IMSetNickNameRequest(mContext, ListenerManager.getInstance().addListener(bIMValueCallBack), AccountManager.getAppid(mContext), z, str, str2, j);
            HttpHelper.executor(mContext, iMSetNickNameRequest, iMSetNickNameRequest);
        }
    }
}
