package com.baidu.android.pushservice.e;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.PushSettings;
/* loaded from: classes2.dex */
public class b {
    public static void a(String str, String str2, Context context) {
        if (!PushSettings.c(context) || str2 == null) {
            return;
        }
        Log.d("BDPushSDK-" + str, str2);
    }

    public static void a(String str, Throwable th, Context context) {
        b(str, a.a(th), context);
    }

    public static void b(String str, String str2, Context context) {
        if (!PushSettings.c(context) || str2 == null) {
            return;
        }
        Log.e("BDPushSDK-" + str, str2);
    }

    public static void c(String str, String str2, Context context) {
        if (!PushSettings.c(context) || str2 == null) {
            return;
        }
        Log.i("BDPushSDK-" + str, str2);
    }

    public static void d(String str, String str2, Context context) {
        if (!PushSettings.c(context) || str2 == null) {
            return;
        }
        Log.w("BDPushSDK-" + str, str2);
    }
}
