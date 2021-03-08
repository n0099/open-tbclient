package com.baidu.android.pushservice.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class a {
    private static String a(Context context, String str) {
        try {
            byte[] digest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return "";
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(Context context, String str, long j) {
        return a(context, String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j)));
    }
}
