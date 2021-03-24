package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.UUID;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1563a = "cn.com.chinatelecom.gateway.lib.c.c";

    /* renamed from: b  reason: collision with root package name */
    public static String f1564b = "";

    public static String a() {
        String uuid = UUID.randomUUID().toString();
        try {
            uuid = UUID.nameUUIDFromBytes((uuid + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f1564b)) {
            String b2 = b(context);
            f1564b = b2;
            if (TextUtils.isEmpty(b2)) {
                String c2 = c(context);
                f1564b = c2;
                a(context, c2);
            }
        }
        return f1564b;
    }

    public static String a(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b2 : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b2 >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        b.a(context, "key_d_i_u", str);
    }

    public static String b(Context context) {
        return b.b(context, "key_d_i_u", "");
    }

    public static String c(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            String lowerCase = !TextUtils.isEmpty(string) ? string.toLowerCase() : UUID.randomUUID().toString();
            return TextUtils.isEmpty(lowerCase) ? "default" : a(lowerCase + "default");
        }
    }
}
