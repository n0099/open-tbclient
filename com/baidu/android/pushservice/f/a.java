package com.baidu.android.pushservice.f;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.PushSettings;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes10.dex */
public class a {
    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public static void a(String str, String str2, Context context) {
        if (!PushSettings.e(context) || str2 == null) {
            return;
        }
        Log.d("BDPushSDK-" + str, str2);
    }

    public static void a(String str, Throwable th, Context context) {
        b(str, a(th), context);
    }

    public static void b(String str, String str2, Context context) {
        if (!PushSettings.e(context) || str2 == null) {
            return;
        }
        Log.e("BDPushSDK-" + str, str2);
    }

    public static void c(String str, String str2, Context context) {
        if (!PushSettings.e(context) || str2 == null) {
            return;
        }
        Log.i("BDPushSDK-" + str, str2);
    }
}
