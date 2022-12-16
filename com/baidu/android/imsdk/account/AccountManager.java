package com.baidu.android.imsdk.account;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AccountManager extends BaseManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AccountManager() {
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

    public static boolean clearToken(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (BaseManager.isNullContext(context)) {
                IMListener removeListener = ListenerManager.getInstance().removeListener(str);
                if (removeListener != null && (removeListener instanceof ILoginListener)) {
                    ((ILoginListener) removeListener).onLogoutResult(1005, "Context is null", -1);
                    return false;
                }
                return false;
            }
            return AccountManagerImpl.getInstance(context).clearToken(str);
        }
        return invokeLL.booleanValue;
    }

    public static boolean clearUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return AccountManagerImpl.getInstance(context).clearUid(context);
        }
        return invokeL.booleanValue;
    }

    public static void disconnect(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, context) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        AccountManagerImpl.getInstance(context).disconnect(null);
    }

    public static long getAppid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return AccountManagerImpl.getInstance(context).getAppid();
        }
        return invokeL.longValue;
    }

    public static int getLoginState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return AccountManagerImpl.getInstance(context).getLoginState();
        }
        return invokeL.intValue;
    }

    public static boolean getMediaRole(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return AccountManagerImpl.getInstance(context).getMediaRole();
        }
        return invokeL.booleanValue;
    }

    public static int getNotificationPrivacy(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return AccountManagerImpl.getInstance(context).getNotificationPrivacy(context);
        }
        return invokeL.intValue;
    }

    public static String getToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return "";
            }
            return AccountManagerImpl.getInstance(context).getToken();
        }
        return (String) invokeL.objValue;
    }

    public static long getUK(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return AccountManagerImpl.getInstance(context).getUK();
        }
        return invokeL.longValue;
    }

    public static String getUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return "";
            }
            return AccountManagerImpl.getInstance(context).getUid();
        }
        return (String) invokeL.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            AccountManagerImpl.getInstance(context);
        }
    }

    public static boolean isLogin(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return AccountManagerImpl.getInstance(context).isLogin();
        }
        return invokeL.booleanValue;
    }

    public static void getMsgSettingSwitchStatus(Context context, IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, iGetMsgSettingSwitchListener) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iGetMsgSettingSwitchListener != null) {
                    iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(1005, Constants.ERROR_MSG_PARAMETER_ERROR, 0, 0);
                    return;
                }
                return;
            }
            AccountManagerImpl.getInstance(context).getMsgSettingSwitchStatus(iGetMsgSettingSwitchListener);
        }
    }

    public static void logout(Context context, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65553, null, context, iLoginListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        AccountManagerImpl.getInstance(context).logout(1, iLoginListener);
    }

    public static void registerToDoAfterLoginListener(Context context, TodoAfterLogin todoAfterLogin) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65554, null, context, todoAfterLogin) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        AccountManagerImpl.getInstance(context).registerToDoAfterLoginListener(todoAfterLogin);
    }

    public static void registerToDoBeforeLogoutListener(Context context, TodoBeforeLogout todoBeforeLogout) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65555, null, context, todoBeforeLogout) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        AccountManagerImpl.getInstance(context).registerToDoBeforeLogoutListener(todoBeforeLogout);
    }

    public static void retryLogin(Context context, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, context, iLoginListener) == null) {
            AccountManagerImpl.getInstance(context).login(1, Utility.getAccessToken(context), getUid(context), "", "", iLoginListener);
        }
    }

    public static boolean setAppid(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65557, null, context, j)) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return AccountManagerImpl.getInstance(context).setAppid(j);
        }
        return invokeLJ.booleanValue;
    }

    public static boolean setEnv(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, context, i)) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return AccountManagerImpl.getInstance(context).setEnv(context, i);
        }
        return invokeLI.booleanValue;
    }

    public static void setLogStateChangedListener(Context context, ILoginStateChangedListener iLoginStateChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, iLoginStateChangedListener) == null) {
            AccountManagerImpl.getInstance(context).setLogStateChangedListener(iLoginStateChangedListener);
        }
    }

    public static void setMediaRole(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65560, null, context, z) == null) {
            AccountManagerImpl.getInstance(context).setMediaRole(z);
        }
    }

    public static void setUK(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65563, null, context, j) == null) {
            AccountManagerImpl.getInstance(context).setUK(j);
        }
    }

    public static boolean setUid(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, context, str)) == null) {
            if (!BaseManager.isNullContext(context) && !TextUtils.isEmpty(str)) {
                return AccountManagerImpl.getInstance(context).setUid(str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void setUpdateSwitch(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65565, null, context, i) == null) {
            AccountManagerImpl.getInstance(context).setUpdateSwitch(i);
        }
    }

    public static void getUidByUk(Context context, long[] jArr, IGetUidByUkListener iGetUidByUkListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, jArr, iGetUidByUkListener) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iGetUidByUkListener != null) {
                    iGetUidByUkListener.onGetUidByUkResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, jArr, null);
                    return;
                }
                return;
            }
            AccountManagerImpl.getInstance(context).getUidByUk(jArr, iGetUidByUkListener);
        }
    }

    public static void setNotificationPrivacy(Context context, int i, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65562, null, context, i, iSetNotificationPrivacyListener) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iSetNotificationPrivacyListener != null) {
                    iSetNotificationPrivacyListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                    return;
                }
                return;
            }
            AccountManagerImpl.getInstance(context).setNotificationPrivacy(i, iSetNotificationPrivacyListener);
        }
    }

    public static boolean isCuidLogin(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            int loginType = AccountManagerImpl.getInstance(context).getLoginType();
            String str = BaseManager.TAG;
            LogUtils.d(str, "isCuidLogin loginType: " + loginType);
            if (loginType == 6) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void login(Context context, String str, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, str, iLoginListener) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                }
            } else if (TextUtils.isEmpty(str)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                }
            } else if (TextUtils.isEmpty(AccountManagerImpl.getInstance(context).getUid())) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "uid is required and must be set using setUid() method before login");
                }
            } else {
                AccountManagerImpl.getInstance(context).login(AccountManagerImpl.getInstance(context).getLoginType(), getUid(context), str, AccountManagerImpl.getInstance(context).getFrom(), AccountManagerImpl.getInstance(context).getcFrom(), iLoginListener);
            }
        }
    }

    public static void setMsgSettingSwitchStatus(Context context, int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), iSetMsgSettingSwitchListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iSetMsgSettingSwitchListener != null) {
                    iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                    return;
                }
                return;
            }
            AccountManagerImpl.getInstance(context).setMsgSettingSwitchStatus(i, i2, iSetMsgSettingSwitchListener);
        }
    }
}
