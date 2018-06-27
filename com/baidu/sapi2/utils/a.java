package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import com.baidu.sapi2.SmsService;
import java.io.FileInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class a {
    private static final String a = "file:///android_asset/";

    public static boolean a(String str, String str2) {
        return a(str, str2, null, null);
    }

    @TargetApi(4)
    public static boolean a(String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        try {
            return SmsService.sendSms(str2, str, pendingIntent, pendingIntent2);
        } catch (Throwable th) {
            return false;
        }
    }

    public static InputStream a(Context context, String str) {
        InputStream fileInputStream;
        try {
            if (str.startsWith(a)) {
                fileInputStream = context.getAssets().open(str.replace(a, ""));
            } else {
                fileInputStream = new FileInputStream(str);
            }
            return fileInputStream;
        } catch (Exception e) {
            return null;
        }
    }
}
