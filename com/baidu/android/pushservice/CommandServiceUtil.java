package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.f.k;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class CommandServiceUtil {
    private static final String TAG = "CommandServiceUtil";

    private static void callBackService(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("bd.cross.request.SOURCE_SERVICE");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            intent.setPackage(stringExtra2);
            intent.setClassName(stringExtra2, stringExtra);
            intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
            intent.putExtra("bd.cross.request.SENDING", false);
            context.startService(intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a(TAG, e);
        }
    }

    public static void onStartCommand(Context context, Intent intent, int i, int i2) {
        Log.d(TAG, " CommandServiceUtil onStartCommand " + intent.toUri(0));
        String action = intent.getAction();
        com.baidu.android.pushservice.e.a.c(TAG, "action = " + action);
        u.b("CommandService#onStartCommand#action = " + action, context);
        try {
            if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(action)) {
                u.b("push_passthrough: receive  click delete and notified action", context.getApplicationContext());
                com.baidu.android.pushservice.e.a.c(TAG, "handle passthrough notification " + action);
                k.a(context.getApplicationContext(), intent.hasExtra(PbActivityConfig.KEY_MSG_ID) ? intent.getStringExtra(PbActivityConfig.KEY_MSG_ID) : null, intent.hasExtra("app_id") ? intent.getStringExtra("app_id") : null, action);
            } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                String stringExtra = intent.getStringExtra("app_id");
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_MSG_ID);
                ((PublicMsg) intent.getParcelableExtra("public_msg")).handlePrivateNotification(context.getApplicationContext(), action, stringExtra2, stringExtra);
                int intExtra = intent.getIntExtra("hw_push_type", 0);
                String stringExtra3 = intent.getStringExtra("hw_gid");
                if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action)) {
                    com.baidu.android.pushservice.h.f.a(context.getApplicationContext(), stringExtra2, intExtra, stringExtra3 + "", 1);
                } else if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                    com.baidu.android.pushservice.h.f.a(context.getApplicationContext(), stringExtra2, intExtra, stringExtra3 + "");
                }
            } else {
                if (intent.hasExtra("command_type")) {
                    r0 = intent.getStringExtra("command_type");
                    com.baidu.android.pushservice.e.a.c(TAG, "-- command_type -- " + r0);
                }
                if ("reflect_receiver".equals(r0)) {
                    reflectReceiver(context, intent);
                } else if (intent.hasExtra("bd.cross.request.COMMAND_TYPE")) {
                    String stringExtra4 = intent.getStringExtra("bd.cross.request.COMMAND_TYPE");
                    if ("bd.cross.command.MESSAGE_DELIVER".equals(stringExtra4)) {
                        reflectReceiver(context, intent);
                    } else if ("bd.cross.command.MESSAGE_ACK".equals(stringExtra4)) {
                        callBackService(context, intent);
                    }
                }
            }
        } catch (RuntimeException e) {
            com.baidu.android.pushservice.e.a.e(TAG, "runtime e: " + e);
        }
    }

    private static void reflectReceiver(Context context, Intent intent) {
        String c = u.c(context, context.getPackageName(), intent.getAction());
        u.b("CommandService#onStartCommand#reflectReceiver#recevier = " + c, context);
        if (TextUtils.isEmpty(c)) {
            com.baidu.android.pushservice.e.a.b(TAG, " reflectReceiver error: receiver for: " + intent.getAction() + " not found, package: " + context.getPackageName());
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            return;
        }
        try {
            Class<?> cls = Class.forName(c);
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            String[] strArr = {"android.content.Context", "android.content.Intent"};
            Method method = cls.getMethod("onReceive", Context.class, Intent.class);
            intent.setClassName(context.getPackageName(), c);
            method.invoke(newInstance, context.getApplicationContext(), intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a(TAG, e);
        }
    }
}
