package com.baidu.nadcore.download.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import c.a.a0.j.i.a;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class NotificationReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTENT_PARAMS_KEY_DOWNLOAD_FILE_PATH = "key_download_path";
    public static final String INTENT_PARAMS_KEY_EXTRA_PARAM = "key_extra_param";
    public static final String INTENT_PARAMS_KEY_NOTIFICATION_ID = "key_notification_id";
    public static final String INTENT_PARAMS_KEY_NOTIFY_TYPE = "key_notify_type";
    public static final String INTENT_PARAMS_KEY_PACKAGE_NAME = "key_package_name";
    public static final String RECEIVER_ACTION_CLICK_BUTTON = "com.baidu.nadcore.action.CLICK_BUTTON";
    public static final String RECEIVER_ACTION_CLICK_ITEM = "com.baidu.nadcore.action.CLICK_ITEM";
    public static final String RECEIVER_ACTION_DOWNLOAD_SUCCESS = "com.baidu.nadcore.action.DOWNLOAD_SUCCESS";
    public static final String RECEIVER_ACTION_REMOVE_ITEM = "com.baidu.nadcore.action.REMOVE_ITEM";
    public static final String TAG = "NotificationReceiver";
    public transient /* synthetic */ FieldHolder $fh;

    public NotificationReceiver() {
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

    private void collapseStatusBar(Context context) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            try {
                Object systemService = context.getSystemService("statusbar");
                if (Build.VERSION.SDK_INT <= 16) {
                    method = systemService.getClass().getMethod("collapse", new Class[0]);
                } else {
                    method = systemService.getClass().getMethod("collapsePanels", new Class[0]);
                }
                method.invoke(systemService, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void installApk(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || a.b(str2)) {
            return;
        }
        a.c(new File(str));
    }

    private void onNotificationClick(Context context, String str, String str2, String str3, String str4, String str5) {
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, str, str2, str3, str4, str5}) == null) {
            if (TextUtils.equals(str, "notify_type_uninstall")) {
                installApk(str3, str2);
                str6 = ClogBuilder.LogType.DOWNLOAD_INSTALL.type;
            } else {
                a.g(str2);
                str6 = ClogBuilder.LogType.OPEN_APP.type;
            }
            collapseStatusBar(context);
            c.a.a0.j.e.a.f().g(str6, str5, str4, str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            int intExtra = intent.getIntExtra(INTENT_PARAMS_KEY_NOTIFICATION_ID, -1);
            String stringExtra = intent.getStringExtra(INTENT_PARAMS_KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(INTENT_PARAMS_KEY_DOWNLOAD_FILE_PATH);
            String stringExtra3 = intent.getStringExtra(INTENT_PARAMS_KEY_NOTIFY_TYPE);
            String stringExtra4 = intent.getStringExtra(INTENT_PARAMS_KEY_EXTRA_PARAM);
            switch (action.hashCode()) {
                case -1188361885:
                    if (action.equals(RECEIVER_ACTION_CLICK_BUTTON)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 271595908:
                    if (action.equals(RECEIVER_ACTION_CLICK_ITEM)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1267922740:
                    if (action.equals(RECEIVER_ACTION_REMOVE_ITEM)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1894906278:
                    if (action.equals(RECEIVER_ACTION_DOWNLOAD_SUCCESS)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                installApk(stringExtra2, stringExtra);
            } else if (c2 == 1) {
                onNotificationClick(context, stringExtra3, stringExtra, stringExtra2, stringExtra4, ClogBuilder.Area.AD_NOTIFICATION_ITEM_CLICK.type);
            } else if (c2 != 2) {
                if (c2 != 3) {
                    return;
                }
                c.a.a0.j.e.a.f().g(ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.AD_NOTIFICATION_REMOVE.type, stringExtra4, stringExtra3);
            } else {
                onNotificationClick(context, stringExtra3, stringExtra, stringExtra2, stringExtra4, ClogBuilder.Area.AD_NOTIFICATION_BTN_CLICK.type);
                if (intExtra != -1) {
                    c.a.a0.j.e.a.f().a(intExtra);
                }
            }
        }
    }
}
