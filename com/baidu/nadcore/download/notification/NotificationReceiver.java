package com.baidu.nadcore.download.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.bl0;
import com.baidu.tieba.gk0;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class NotificationReceiver extends BroadcastReceiver {
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

    private void collapseStatusBar(Context context) {
        Method method;
        try {
            Object systemService = context.getSystemService("statusbar");
            if (Build.VERSION.SDK_INT <= 16) {
                method = systemService.getClass().getMethod("collapse", new Class[0]);
            } else {
                method = systemService.getClass().getMethod("collapsePanels", new Class[0]);
            }
            method.invoke(systemService, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void installApk(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !bl0.c(str2)) {
            bl0.d(new File(str));
        }
    }

    private void onNotificationClick(Context context, String str, String str2, String str3, String str4, String str5) {
        String str6;
        if (TextUtils.equals(str, "notify_type_uninstall")) {
            installApk(str3, str2);
            str6 = ClogBuilder.LogType.DOWNLOAD_INSTALL.type;
        } else {
            bl0.g(str2);
            str6 = ClogBuilder.LogType.OPEN_APP.type;
        }
        collapseStatusBar(context);
        gk0.f().h(str6, str5, str4, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        char c;
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
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 271595908:
                if (action.equals(RECEIVER_ACTION_CLICK_ITEM)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1267922740:
                if (action.equals(RECEIVER_ACTION_REMOVE_ITEM)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1894906278:
                if (action.equals(RECEIVER_ACTION_DOWNLOAD_SUCCESS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c == 3) {
                        gk0.f().h(ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.AD_NOTIFICATION_REMOVE.type, stringExtra4, stringExtra3);
                        return;
                    }
                    return;
                }
                onNotificationClick(context, stringExtra3, stringExtra, stringExtra2, stringExtra4, ClogBuilder.Area.AD_NOTIFICATION_BTN_CLICK.type);
                if (intExtra != -1) {
                    gk0.f().a(intExtra);
                    return;
                }
                return;
            }
            onNotificationClick(context, stringExtra3, stringExtra, stringExtra2, stringExtra4, ClogBuilder.Area.AD_NOTIFICATION_ITEM_CLICK.type);
            return;
        }
        installApk(stringExtra2, stringExtra);
    }
}
