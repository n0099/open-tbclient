package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.group.request.IMQueryFansGroupQrCodeRequest;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BIMGroupManager extends BaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BIMGroupManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addGroupMembers(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65537, null, context, str, arrayList, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).addGroupMembers(str, arrayList, bIMValueCallBack);
    }

    public static void delGroupMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, context, str, arrayList, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).delGroupMember(str, arrayList, bIMValueCallBack);
    }

    public static void delStarMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65542, null, context, str, arrayList, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).delStarMember(str, arrayList, bIMValueCallBack);
    }

    public static void getFansGroupInfo(Context context, ArrayList<String> arrayList, boolean z, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, arrayList, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupInfo(arrayList, z, bIMValueCallBack);
        }
    }

    public static void getFansGroupUserInfo(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65555, null, context, str, arrayList, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupUserInfo(str, arrayList, bIMValueCallBack);
        }
    }

    public static void getGroupList(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(65560, null, context, bIMValueCallBack, i, i2) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getGroupList(bIMValueCallBack, i, i2);
    }

    public static void getGroupMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65562, null, context, str, arrayList, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        if (arrayList == null) {
            GroupManagerImpl.getInstance(context).getAllGroupMember(str, arrayList, bIMValueCallBack);
        } else {
            GroupManagerImpl.getInstance(context).getGroupMember(0, str, arrayList, bIMValueCallBack);
        }
    }

    public static void sendFansGroupInviteMsg(Context context, String str, List<Long> list, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65577, null, context, str, list, iSendMessageListener) == null) {
            GroupManagerImpl.getInstance(context).sendFansGroupInviteMsg(str, list, iSendMessageListener);
        }
    }

    public static void setFansGroupWelcomeDisplayScope(Context context, String str, int i, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65579, null, context, str, i, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).setFansGroupWelcomeDisplayScope(str, i, bIMValueCallBack);
        }
    }

    public static void setFansNickName(Context context, String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65580, null, context, str, str2, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).setNickName(str, Utility.getLongByString(AccountManager.getUid(context), 0L), str2, true, bIMValueCallBack);
    }

    public static void setGroupNotice(Context context, String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65581, null, context, str, str2, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).setGroupNotice(str, str2, bIMValueCallBack);
        }
    }

    public static void updateGroupName(Context context, String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65584, null, context, str, str2, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).updateGroupName(str, str2, bIMValueCallBack);
        }
    }

    public static void clearStarGroup(Context context, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65538, null, context, j) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        try {
            String valueOf = String.valueOf(j);
            String str = BaseManager.TAG;
            LogUtils.d(str, "clearStarGroup quitgroup " + j);
            DialogRecordDBManager.getInstance(context).delete(1, j);
            ConversationManagerImpl.getInstance(context).deleteConversation(1, valueOf);
            GroupInfoDAOImpl.quitGroup(context, valueOf);
        } catch (Exception unused) {
            LogUtils.d(BaseManager.TAG, "ClearStarGroup exception, this is normal for device sync logic");
        }
    }

    public static void createGroup(Context context, int i, String str, ArrayList<String> arrayList, BIMValueCallBack<CreateResultInfo> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i), str, arrayList, bIMValueCallBack}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).createGroup(i, str, arrayList, bIMValueCallBack);
    }

    public static void delFansGroupMember(Context context, String str, ArrayList<String> arrayList, int i, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, arrayList, Integer.valueOf(i), bIMValueCallBack}) == null) {
            GroupManagerImpl.getInstance(context).delFansGroupMember(str, arrayList, i, bIMValueCallBack);
        }
    }

    public static void getFansGroupMember(Context context, String str, ArrayList<String> arrayList, boolean z, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, str, arrayList, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupMember(str, arrayList, z, bIMValueCallBack);
        }
    }

    public static void joinFansGroup(Context context, String str, String str2, int i, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65570, null, new Object[]{context, str, str2, Integer.valueOf(i), bIMValueCallBack}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).joinGroup(str, str2, i, null, true, bIMValueCallBack);
    }

    public static void setFansGroupWelcomeData(Context context, String str, String str2, int i, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65578, null, new Object[]{context, str, str2, Integer.valueOf(i), bIMValueCallBack}) == null) {
            GroupManagerImpl.getInstance(context).setFansGroupWelcomeData(str, str2, i, bIMValueCallBack);
        }
    }

    public static void setNickName(Context context, String str, long j, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65582, null, new Object[]{context, str, Long.valueOf(j), str2, bIMValueCallBack}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).setNickName(str, j, str2, false, bIMValueCallBack);
    }

    public static void getCurrentUserGroupApplyStateFromServer(Context context, String str, BIMValueCallBack<Integer> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, str, bIMValueCallBack) == null) {
            if (!BaseManager.isNullContext(context) && !TextUtils.isEmpty(str)) {
                GroupManagerImpl.getInstance(context).getCurrentUserGroupApplyStateFromServer(str, bIMValueCallBack);
            } else if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, "param invalid", 0);
            }
        }
    }

    public static void getFansGroupApplyCountFromServer(Context context, List<String> list, BIMValueCallBack<ArrayList<GroupApplyBean>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, list, bIMValueCallBack) == null) {
            if (!BaseManager.isNullContext(context) && list != null && list.size() != 0) {
                GroupManagerImpl.getInstance(context).getFansGroupApplyCountFromServer(list, bIMValueCallBack);
            } else if (bIMValueCallBack != null) {
                bIMValueCallBack.onResult(1005, "param invalid", null);
            }
        }
    }

    public static ArrayList<GroupMember> getGroupMember(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65561, null, context, str, i)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(context, str, null, i);
            if (i == 0 || groupMember == null || (groupMember != null && groupMember.size() > 0)) {
                GroupManagerImpl.getInstance(context).getGroupMember(1, str, null, null);
            }
            return groupMember;
        }
        return (ArrayList) invokeLLI.objValue;
    }

    public static String getNickName(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return GroupManagerImpl.getInstance(context).getNickName(str, String.valueOf(j));
        }
        return (String) invokeCommon.objValue;
    }

    public static int getRole(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return GroupManagerImpl.getInstance(context).getRole(str, String.valueOf(j));
        }
        return invokeCommon.intValue;
    }

    public static void getFansGroupAdministrators(Context context, String str, BIMValueCallBack<List<GroupMember>> bIMValueCallBack) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, str, bIMValueCallBack) == null) {
            if (!BaseManager.isNullContext(context) && !TextUtils.isEmpty(str)) {
                GroupManagerImpl.getInstance(context).getFansGroupAdministrators(str, bIMValueCallBack);
            } else if (bIMValueCallBack != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("param invalid");
                if (BaseManager.isNullContext(context)) {
                    str2 = "context is null";
                } else {
                    str2 = "group id empty";
                }
                sb.append(str2);
                bIMValueCallBack.onResult(1005, sb.toString(), null);
            }
        }
    }

    public static ArrayList<ChatMsg> getFansGroupAtUnread(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) == null) {
            if (context == null) {
                return null;
            }
            return GroupMessageDAOImpl.getFansGroupAtUnread(context.getApplicationContext(), str, str2);
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static void getFansGroupInviteMembers(Context context, String str, BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupInviteMembers(str, bIMValueCallBack);
        }
    }

    public static void getFansGroupNormalRoleMembers(Context context, String str, BIMValueCallBack<List<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, str, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupNormalRoleMembers(str, bIMValueCallBack);
        }
    }

    public static void getFansGroupQrCode(Context context, String str, BIMValueCallBack<IMQueryFansGroupQrCodeRequest.QrCode> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, context, str, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupQrCode(str, bIMValueCallBack);
        }
    }

    public static void getGroupInfo(Context context, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65558, null, context, arrayList, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getGroupsInfo(0, arrayList, bIMValueCallBack);
    }

    public static void getStarOnline(Context context, String str, BIMValueCallBack<Integer> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65567, null, context, str, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getStarOnline(str, bIMValueCallBack);
    }

    public static void isInSpecificFansGroup(Context context, String str, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, context, str, bIMValueCallBack) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(AccountManager.getUid(context));
            getFansGroupMember(context, str, arrayList, true, bIMValueCallBack);
        }
    }

    public static void joinStarGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65572, null, context, str, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).joinStarGroup(str, bIMValueCallBack);
    }

    public static void quitFansGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, str, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).quitFansGroup(str, bIMValueCallBack);
        }
    }

    public static void quitGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65574, null, context, str, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).quitGroup(str, bIMValueCallBack);
    }

    public static void quitStarGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65575, null, context, str, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).quitStarGroup(str, bIMValueCallBack);
    }

    public static void getFansGroupList(Context context, BIMValueCallBack<List<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupList(false, bIMValueCallBack);
        }
    }

    public static void getFansGroupUnreadStatus(Context context, BIMValueCallBack<Integer> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupUnreadStatus(bIMValueCallBack);
        }
    }

    public static void getForwardUserList(Context context, BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, context, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getForwardUserList(bIMValueCallBack);
        }
    }

    public static void getGlobalDisturbStatus(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getGlobalDisturbStatus(context, bIMValueCallBack);
        }
    }

    public static void getGroupList(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65559, null, context, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getAllGroupList(bIMValueCallBack);
    }

    public static int getGroupUnread(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, str)) == null) {
            if (context == null) {
                return 0;
            }
            return GroupMessageDAOImpl.getUnReadCount(context.getApplicationContext(), str);
        }
        return invokeLL.intValue;
    }

    public static ArrayList<GroupMember> getNickName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, str)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return GroupManagerImpl.getInstance(context).getNickName(str);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static void registerApplyCountChangeListener(Context context, BIMValuesCallBack<Long, Integer> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65576, null, context, bIMValuesCallBack) == null) && context != null && bIMValuesCallBack != null) {
            GroupUpdateManager.getInstance(context).registerApplyCountChangeListener(bIMValuesCallBack);
        }
    }

    public static void unregisterApplyCountChangeListener(Context context, BIMValuesCallBack<Long, Integer> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65583, null, context, bIMValuesCallBack) == null) && context != null && bIMValuesCallBack != null) {
            GroupUpdateManager.getInstance(context).unregisterApplyCountChangeListener(bIMValuesCallBack);
        }
    }

    public static void getFansGroupOwnerInfo(Context context, String str, boolean z, BIMValueCallBack<GroupMember> bIMValueCallBack) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, str, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            if (!BaseManager.isNullContext(context) && !TextUtils.isEmpty(str)) {
                GroupManagerImpl.getInstance(context).getFansGroupOwnerInfo(str, z, bIMValueCallBack);
            } else if (bIMValueCallBack != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("param invalid");
                if (BaseManager.isNullContext(context)) {
                    str2 = "context is null";
                } else {
                    str2 = "group id empty";
                }
                sb.append(str2);
                bIMValueCallBack.onResult(1005, sb.toString(), null);
            }
        }
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65568, null, context) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context);
    }

    public static void joinGroup(Context context, String str, String str2, int i, String str3, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65571, null, new Object[]{context, str, str2, Integer.valueOf(i), str3, bIMValueCallBack}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).joinGroup(str, str2, i, str3, false, bIMValueCallBack);
    }
}
