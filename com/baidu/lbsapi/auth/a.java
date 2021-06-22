package com.baidu.lbsapi.auth;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6336a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f6337b = "BaiduApiAuth";

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + PreferencesUtil.LEFT_MOUNT + stackTraceElement.getLineNumber() + PreferencesUtil.RIGHT_MOUNT;
    }

    public static void a(String str) {
        if (!f6336a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        String str2 = f6337b;
        Log.d(str2, a() + ";" + str);
    }

    public static void b(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(f6337b, str);
    }

    public static void c(String str) {
        if (!f6336a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        String str2 = f6337b;
        Log.e(str2, a() + ";" + str);
    }
}
