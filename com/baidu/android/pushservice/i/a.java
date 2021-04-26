package com.baidu.android.pushservice.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return "";
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(Context context, String str, long j) {
        return a(context, String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j)));
    }
}
