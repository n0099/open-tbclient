package cn.jiguang.g;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class i {
    private static String a = "0123456789ABCDEF";
    private static SimpleDateFormat b = new SimpleDateFormat("mm:ss:SSS", Locale.ENGLISH);

    public static CharSequence a(CharSequence charSequence, int i) {
        return (i < 0 || i >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i);
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static boolean a(String str, String str2) {
        return (str == null || str2 == null || !str.equals(str2)) ? false : true;
    }

    public static String b(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (byte b2 : digest) {
                stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15)).append("0123456789ABCDEF".charAt(b2 & 15));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String c(String str) {
        return a(str) ? "" : Pattern.compile("[^\\w#$@\\-一-龥]+").matcher(str).replaceAll("");
    }

    public static boolean d(String str) {
        if (a(str)) {
            return false;
        }
        try {
            return Pattern.compile("[\\x20-\\x7E]+").matcher(str).matches();
        } catch (Throwable th) {
            return true;
        }
    }

    public static boolean e(String str) {
        if (a(str)) {
            return false;
        }
        try {
            return Pattern.compile("([A-Fa-f0-9]{2}[-:]){5,}[A-Fa-f0-9]{2}").matcher(str).matches();
        } catch (Throwable th) {
            return true;
        }
    }
}
