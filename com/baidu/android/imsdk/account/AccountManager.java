package com.baidu.android.imsdk.account;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes5.dex */
public class AccountManager extends BaseManager {
    public static void init(Context context) {
        AccountManagerImpl.getInstance(context);
    }

    public static void login(Context context, String str, ILoginListener iLoginListener) {
        if (isNullContext(context)) {
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

    public static long getAppid(Context context) {
        if (isNullContext(context)) {
            return -1L;
        }
        return AccountManagerImpl.getInstance(context).getAppid();
    }

    public static String getToken(Context context) {
        return isNullContext(context) ? "" : AccountManagerImpl.getInstance(context).getToken();
    }

    public static void logout(Context context, ILoginListener iLoginListener) {
        if (!isNullContext(context)) {
            AccountManagerImpl.getInstance(context).logout(1, iLoginListener);
        }
    }

    public static boolean isLogin(Context context) {
        if (isNullContext(context)) {
            return false;
        }
        return AccountManagerImpl.getInstance(context).isLogin();
    }

    public static long getUK(Context context) {
        if (isNullContext(context)) {
            return -1L;
        }
        return AccountManagerImpl.getInstance(context).getUK();
    }

    public static boolean setAppid(Context context, long j) {
        if (isNullContext(context)) {
            return false;
        }
        return AccountManagerImpl.getInstance(context).setAppid(j);
    }

    public static boolean clearToken(Context context, String str) {
        if (isNullContext(context)) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener != null && (removeListener instanceof ILoginListener)) {
                ((ILoginListener) removeListener).onLogoutResult(1005, "Context is null", -1);
            }
            return false;
        }
        return AccountManagerImpl.getInstance(context).clearToken(str);
    }

    public static void disconnect(Context context) {
        if (!isNullContext(context)) {
            AccountManagerImpl.getInstance(context).disconnect(null);
        }
    }

    public static boolean setUid(Context context, String str) {
        if (isNullContext(context) || TextUtils.isEmpty(str)) {
            return false;
        }
        return AccountManagerImpl.getInstance(context).setUid(str);
    }

    public static String getUid(Context context) {
        return isNullContext(context) ? "" : AccountManagerImpl.getInstance(context).getUid();
    }

    public static boolean setEnv(Context context, int i) {
        if (isNullContext(context)) {
            return false;
        }
        return AccountManagerImpl.getInstance(context).setEnv(context, i);
    }

    public static void registerToDoAfterLoginListener(Context context, TodoAfterLogin todoAfterLogin) {
        if (!isNullContext(context)) {
            AccountManagerImpl.getInstance(context).registerToDoAfterLoginListener(todoAfterLogin);
        }
    }

    public static void registerToDoBeforeLogoutListener(Context context, TodoBeforeLogout todoBeforeLogout) {
        if (!isNullContext(context)) {
            AccountManagerImpl.getInstance(context).registerToDoBeforeLogoutListener(todoBeforeLogout);
        }
    }

    public static boolean clearUid(Context context) {
        if (isNullContext(context)) {
            return false;
        }
        return AccountManagerImpl.getInstance(context).clearUid(context);
    }

    public static void getUidByUk(Context context, long[] jArr, IGetUidByUkListener iGetUidByUkListener) {
        if (isNullContext(context)) {
            if (iGetUidByUkListener != null) {
                iGetUidByUkListener.onGetUidByUkResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, jArr, null);
                return;
            }
            return;
        }
        AccountManagerImpl.getInstance(context).getUidByUk(jArr, iGetUidByUkListener);
    }

    public static void setZhidaAppid(Context context, long j, String str, ISwitchZhidaListener iSwitchZhidaListener) {
        if (isNullContext(context) || j < 0) {
            if (iSwitchZhidaListener != null) {
                iSwitchZhidaListener.onSwitchZhidaResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                return;
            }
            return;
        }
        AccountManagerImpl.getInstance(context).setZhidaAppid(j, str, iSwitchZhidaListener);
    }

    public static void setNofityPaid(Context context, long j) {
        AccountManagerImpl.getInstance(context).setNotifyPaid(j);
    }

    public static void setNotificationPrivacy(Context context, int i, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        if (isNullContext(context)) {
            if (iSetNotificationPrivacyListener != null) {
                iSetNotificationPrivacyListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                return;
            }
            return;
        }
        AccountManagerImpl.getInstance(context).setNotificationPrivacy(i, iSetNotificationPrivacyListener);
    }

    public static int getNotificationPrivacy(Context context) {
        return AccountManagerImpl.getInstance(context).getNotificationPrivacy(context);
    }

    public static boolean isCuidLogin(Context context) {
        int loginType = AccountManagerImpl.getInstance(context).getLoginType();
        LogUtils.d(TAG, "isCuidLogin loginType: " + loginType);
        return loginType == 6;
    }

    public static int getLoginState(Context context) {
        return AccountManagerImpl.getInstance(context).getLoginState();
    }

    public static void setLogStateChangedListener(Context context, ILoginStateChangedListener iLoginStateChangedListener) {
        AccountManagerImpl.getInstance(context).setLogStateChangedListener(iLoginStateChangedListener);
    }

    public static void retryLogin(Context context, ILoginListener iLoginListener) {
        AccountManagerImpl.getInstance(context).login(1, Utility.getAccessToken(context), getUid(context), "", "", iLoginListener);
    }

    public static void setUpdateSwitch(Context context, int i) {
        AccountManagerImpl.getInstance(context).setUpdateSwitch(i);
    }

    public static void setMediaRole(Context context, boolean z) {
        AccountManagerImpl.getInstance(context).setMediaRole(z);
    }

    public static boolean getMediaRole(Context context) {
        return AccountManagerImpl.getInstance(context).getMediaRole();
    }

    public static void getMsgSettingSwitchStatus(Context context, IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        if (isNullContext(context)) {
            if (iGetMsgSettingSwitchListener != null) {
                iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(1005, Constants.ERROR_MSG_PARAMETER_ERROR, 0, 0);
                return;
            }
            return;
        }
        AccountManagerImpl.getInstance(context).getMsgSettingSwitchStatus(iGetMsgSettingSwitchListener);
    }

    public static void setMsgSettingSwitchStatus(Context context, int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        if (isNullContext(context)) {
            if (iSetMsgSettingSwitchListener != null) {
                iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                return;
            }
            return;
        }
        AccountManagerImpl.getInstance(context).setMsgSettingSwitchStatus(i, i2, iSetMsgSettingSwitchListener);
    }
}
