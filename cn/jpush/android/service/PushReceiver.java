package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.d.d.aa;
import cn.jiguang.d.d.l;
import cn.jiguang.d.d.o;
import cn.jiguang.g.h;
import cn.jiguang.g.i;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class PushReceiver extends BroadcastReceiver implements Runnable {
    private static final String TAG = "PushReceiver";
    private Context appContext;
    private Intent theIntent;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            cn.jiguang.e.c.c(TAG, "Received null intent broadcast. Give up processing.");
            return;
        }
        try {
            String action = intent.getAction();
            cn.jiguang.e.c.a(TAG, "onReceive - " + action);
            if (TextUtils.isEmpty(action)) {
                cn.jiguang.e.c.c(TAG, "Received action is null");
                return;
            }
            this.appContext = context.getApplicationContext();
            this.theIntent = intent;
            try {
                if (action.equals("cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY") && intent.getBooleanExtra("debug_notification", false)) {
                    String stringExtra = intent.getStringExtra("toastText");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        Toast makeText = Toast.makeText(context, stringExtra, 0);
                        try {
                            View view = makeText.getView();
                            if (view instanceof LinearLayout) {
                                View childAt = ((LinearLayout) view).getChildAt(0);
                                if (childAt instanceof TextView) {
                                    TextView textView = (TextView) childAt;
                                    if (!i.a(stringExtra)) {
                                        textView.setText(stringExtra);
                                    }
                                    textView.setTextSize(13.0f);
                                }
                            }
                        } catch (Exception e) {
                        }
                        makeText.show();
                        return;
                    }
                }
                cn.jiguang.api.e.a("SDK_MAIN", this, new int[0]);
            } catch (Throwable th) {
                cn.jiguang.e.c.c(TAG, "onReceiver error:" + th);
            }
        } catch (NullPointerException e2) {
            cn.jiguang.e.c.c(TAG, "Received no action intent broadcast. Give up processing.");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Method declaredMethod;
        boolean z = true;
        try {
            Context context = this.appContext;
            Intent intent = this.theIntent;
            if (this.theIntent == null || this.theIntent.getAction() == null || context == null) {
                return;
            }
            if (!cn.jiguang.d.a.d(context)) {
                cn.jiguang.e.c.c(TAG, "onReceive :JCoreInterface init failed");
                return;
            }
            String action = this.theIntent.getAction();
            if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                cn.jiguang.d.a.a(context, true, 500L);
            } else if (action.equals("android.intent.action.USER_PRESENT")) {
                o.a(context, false);
                cn.jiguang.d.a.a(context, true, 0L);
            } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REMOVED")) {
                String dataString = intent.getDataString();
                if (dataString == null) {
                    cn.jiguang.e.c.c(TAG, action + ": Get no data from intent.");
                    return;
                } else if (dataString.trim().length() <= 8 || !dataString.startsWith("package:")) {
                    cn.jiguang.e.c.c(TAG, "Get wrong data string from intent: " + dataString);
                    return;
                } else {
                    String substring = dataString.substring(8);
                    if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                        cn.jiguang.a.c.c.a(context, h.h(substring, cn.jiguang.g.d.a(cn.jiguang.g.d.Q(context, substring))));
                    } else if (!cn.jiguang.g.a.i(context, substring)) {
                        cn.jiguang.a.c.c.a(context, h.a(substring));
                        cn.jiguang.d.f.a.a(context, substring);
                    }
                    cn.jiguang.a.c.c.a(context, substring);
                }
            } else if (action.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo == null || 2 == networkInfo.getType() || 3 == networkInfo.getType()) {
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                if (booleanExtra) {
                    extras.putBoolean("connection-state", false);
                } else if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    extras.putBoolean("connection-state", true);
                    aa.a(context);
                } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                    extras.putBoolean("connection-state", false);
                }
                l.bY().d(context, "intent.CONNECTIVITY_CHANGE", extras);
            } else if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") || action.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    try {
                        Class<?> cls = Class.forName("android.os.PowerManager");
                        if (cls != null) {
                            if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                                Method declaredMethod2 = cls.getDeclaredMethod("isDeviceIdleMode", new Class[0]);
                                z = declaredMethod2 != null ? ((Boolean) declaredMethod2.invoke(powerManager, new Object[0])).booleanValue() : true;
                            } else if (action.equals("android.os.action.POWER_SAVE_MODE_CHANGED") && (declaredMethod = cls.getDeclaredMethod("isPowerSaveMode", new Class[0])) != null) {
                                z = ((Boolean) declaredMethod.invoke(powerManager, new Object[0])).booleanValue();
                            }
                            if (!z) {
                                o.a(context, false);
                                cn.jiguang.d.a.a(context, true, 0L);
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
            } else if (action.equals("cn.jpush.android.intent.ACTION_REPORT_HISTORY")) {
                aa.a(context);
            }
            cn.jiguang.d.d.e.bT();
            cn.jiguang.d.d.e.b(context, intent.getStringExtra("sdktype"), intent);
        } catch (Throwable th2) {
            cn.jiguang.e.c.c(TAG, "onReceiver error:" + th2.getMessage());
        }
    }
}
