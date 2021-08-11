package com.baidu.android.imsdk.group;

import android.content.Context;
import android.util.Log;
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
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BIMGroupManager extends BaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BIMGroupManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addGroupMembers(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, context, str, arrayList, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).addGroupMembers(str, arrayList, bIMValueCallBack);
    }

    public static void clearStarGroup(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65538, null, context, j2) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        try {
            String valueOf = String.valueOf(j2);
            String str = BaseManager.TAG;
            LogUtils.d(str, "clearStarGroup quitgroup " + j2);
            DialogRecordDBManager.getInstance(context).delete(1, j2);
            ConversationManagerImpl.getInstance(context).deleteConversation(1, valueOf);
            GroupInfoDAOImpl.quitGroup(context, valueOf);
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            LogUtils.d(BaseManager.TAG, "ClearStarGroup exception, this is normal for device sync logic");
        }
    }

    public static void createGroup(Context context, int i2, String str, ArrayList<String> arrayList, BIMValueCallBack<CreateResultInfo> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), str, arrayList, bIMValueCallBack}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).createGroup(i2, str, arrayList, bIMValueCallBack);
    }

    public static void delFansGroupMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, arrayList, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).delFansGroupMember(str, arrayList, bIMValueCallBack);
        }
    }

    public static void delGroupMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, context, str, arrayList, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).delGroupMember(str, arrayList, bIMValueCallBack);
    }

    public static void delStarMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, arrayList, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).delStarMember(str, arrayList, bIMValueCallBack);
    }

    public static ArrayList<ChatMsg> getFansGroupAtUnread(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) ? GroupMessageDAOImpl.getFansGroupAtUnread(context, str, str2) : (ArrayList) invokeLLL.objValue;
    }

    public static void getFansGroupInfo(Context context, ArrayList<String> arrayList, boolean z, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, arrayList, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupInfo(arrayList, z, bIMValueCallBack);
        }
    }

    public static void getFansGroupInviteMembers(Context context, String str, BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, str, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupInviteMembers(str, bIMValueCallBack);
        }
    }

    public static void getFansGroupList(Context context, BIMValueCallBack<List<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupList(false, bIMValueCallBack);
        }
    }

    public static void getFansGroupMember(Context context, String str, ArrayList<String> arrayList, boolean z, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, str, arrayList, Boolean.valueOf(z), bIMValueCallBack}) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupMember(str, arrayList, z, bIMValueCallBack);
        }
    }

    public static void getFansGroupQrCode(Context context, String str, BIMValueCallBack<IMQueryFansGroupQrCodeRequest.QrCode> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupQrCode(str, bIMValueCallBack);
        }
    }

    public static void getFansGroupUnreadStatus(Context context, BIMValueCallBack<Integer> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupUnreadStatus(bIMValueCallBack);
        }
    }

    public static void getFansGroupUserInfo(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65550, null, context, str, arrayList, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupUserInfo(str, arrayList, bIMValueCallBack);
        }
    }

    public static void getForwardUserList(Context context, BIMValueCallBack<GroupSortUserList> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getForwardUserList(bIMValueCallBack);
        }
    }

    public static void getGlobalDisturbStatus(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).getGlobalDisturbStatus(context, bIMValueCallBack);
        }
    }

    public static void getGroupInfo(Context context, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65553, null, context, arrayList, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getGroupsInfo(0, arrayList, bIMValueCallBack);
    }

    public static void getGroupList(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, context, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getAllGroupList(bIMValueCallBack);
    }

    public static void getGroupMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65557, null, context, str, arrayList, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        if (arrayList == null) {
            GroupManagerImpl.getInstance(context).getAllGroupMember(str, arrayList, bIMValueCallBack);
        } else {
            GroupManagerImpl.getInstance(context).getGroupMember(0, str, arrayList, bIMValueCallBack);
        }
    }

    public static int getGroupUnread(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) ? GroupMessageDAOImpl.getUnReadCount(context, str) : invokeLL.intValue;
    }

    public static String getNickName(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{context, str, Long.valueOf(j2)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return GroupManagerImpl.getInstance(context).getNickName(str, String.valueOf(j2));
        }
        return (String) invokeCommon.objValue;
    }

    public static void getStarOnline(Context context, String str, BIMValueCallBack<Integer> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65561, null, context, str, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getStarOnline(str, bIMValueCallBack);
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, context) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context);
    }

    public static void isInSpecificFansGroup(Context context, String str, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, null, context, str, bIMValueCallBack) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(AccountManager.getUid(context));
            getFansGroupMember(context, str, arrayList, true, bIMValueCallBack);
        }
    }

    public static void joinFansGroup(Context context, String str, String str2, int i2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{context, str, str2, Integer.valueOf(i2), bIMValueCallBack}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).joinGroup(str, str2, i2, null, true, bIMValueCallBack);
    }

    public static void joinGroup(Context context, String str, String str2, int i2, String str3, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{context, str, str2, Integer.valueOf(i2), str3, bIMValueCallBack}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).joinGroup(str, str2, i2, str3, false, bIMValueCallBack);
    }

    public static void joinStarGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65566, null, context, str, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).joinStarGroup(str, bIMValueCallBack);
    }

    public static void quitFansGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65567, null, context, str, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).quitFansGroup(str, bIMValueCallBack);
        }
    }

    public static void quitGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65568, null, context, str, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).quitGroup(str, bIMValueCallBack);
    }

    public static void quitStarGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65569, null, context, str, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).quitStarGroup(str, bIMValueCallBack);
    }

    public static void sendFansGroupInviteMsg(Context context, String str, List<Long> list, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65570, null, context, str, list, iSendMessageListener) == null) {
            GroupManagerImpl.getInstance(context).sendFansGroupInviteMsg(str, list, iSendMessageListener);
        }
    }

    public static void setFansNickName(Context context, String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65571, null, context, str, str2, bIMValueCallBack) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).setNickName(str, Utility.getLongByString(AccountManager.getUid(context), 0L), str2, true, bIMValueCallBack);
    }

    public static void setNickName(Context context, String str, long j2, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{context, str, Long.valueOf(j2), str2, bIMValueCallBack}) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).setNickName(str, j2, str2, false, bIMValueCallBack);
    }

    public static void updateGroupName(Context context, String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65573, null, context, str, str2, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).updateGroupName(str, str2, bIMValueCallBack);
        }
    }

    public static void getGroupList(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65555, null, context, bIMValueCallBack, i2, i3) == null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getGroupList(bIMValueCallBack, i2, i3);
    }

    public static ArrayList<GroupMember> getNickName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return GroupManagerImpl.getInstance(context).getNickName(str);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static ArrayList<GroupMember> getGroupMember(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65556, null, context, str, i2)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(context, str, null, i2);
            if (i2 == 0 || groupMember == null || (groupMember != null && groupMember.size() > 0)) {
                GroupManagerImpl.getInstance(context).getGroupMember(1, str, null, null);
            }
            return groupMember;
        }
        return (ArrayList) invokeLLI.objValue;
    }
}
