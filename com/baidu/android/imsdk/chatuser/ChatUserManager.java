package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChatUserManager extends BaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ChatUserManager() {
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

    @Deprecated
    public static ArrayList<ChatUser> getChatUser(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatUserManagerImpl.getInstance(context).getChatUser();
        }
        return (ArrayList) invokeL.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, context) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context);
    }

    public static void syncUsersProfileBatch(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, null, context) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).syncUsersAttr();
    }

    public static ChatUser getChatUserSync(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, context, j)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return ChatUserManagerImpl.getInstance(context).getChatUserSync(j);
        }
        return (ChatUser) invokeLJ.objValue;
    }

    public static void getUnconcernedUserDisturb(Context context, IGetUnconcernedMsgListener iGetUnconcernedMsgListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, iGetUnconcernedMsgListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUnconcernedUserDisturb(iGetUnconcernedMsgListener);
    }

    @Deprecated
    public static boolean isUserExist(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, context, j)) == null) {
            if (BaseManager.isNullContext(context) || 0 > j) {
                return false;
            }
            return ChatUserManagerImpl.getInstance(context).isUserExist(j);
        }
        return invokeLJ.booleanValue;
    }

    public static void getUKbyBuid(Context context, long j, IGetUkByBuidListener iGetUkByBuidListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{context, Long.valueOf(j), iGetUkByBuidListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUKbyBuid(j, iGetUkByBuidListener);
    }

    public static void getUsersProfileBatch(Context context, ArrayList<Long> arrayList, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65543, null, context, arrayList, iGetUsersProfileBatchListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUsersProfileBatch(arrayList, iGetUsersProfileBatchListener);
    }

    public static void getUsersStatus(Context context, ArrayList<Long> arrayList, IGetUserStatusListener iGetUserStatusListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65545, null, context, arrayList, iGetUserStatusListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUsersStatus(arrayList, iGetUserStatusListener);
    }

    public static void getUser(Context context, long j, IGetUserListener iGetUserListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65541, null, new Object[]{context, Long.valueOf(j), iGetUserListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUser(j, 0, iGetUserListener);
    }

    public static void getUserByBuid(Context context, long j, IGetUserListener iGetUserListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{context, Long.valueOf(j), iGetUserListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUserByBuid(j, 0, iGetUserListener);
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{context, arrayList, Boolean.valueOf(z), iGetUsersProfileBatchListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUsersProfileBatchByBuid(arrayList, z, iGetUsersProfileBatchListener);
    }

    public static void setUserBlack(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iUserPrivacyListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).setUserPrivacy(j, -1, i, iUserPrivacyListener);
    }

    public static void setUserDisturb(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65549, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iUserPrivacyListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).setUserPrivacy(j, i, -1, iUserPrivacyListener);
    }
}
