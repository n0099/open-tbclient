package com.baidu.adp.lib.util;

import android.annotation.SuppressLint;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.IOUtils;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes.dex */
public class h {
    private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy年");
    private static SimpleDateFormat c = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat d = new SimpleDateFormat("M月d日");
    private static SimpleDateFormat e = new SimpleDateFormat("M月d日 HH:mm");
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat g = new SimpleDateFormat("MM-dd");
    private static final char[] h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] i = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
    private static byte[] j = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(Date date) {
        String format;
        synchronized (d) {
            format = d.format(date);
        }
        return format;
    }

    public static String a(long j2) {
        String format;
        Date date = new Date(j2);
        synchronized (a) {
            format = a.format(date);
        }
        return format;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(h[(bArr[i2] & 240) >>> 4]);
            sb.append(h[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public static String a(InputStream inputStream) {
        String str = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    inputStream.close();
                    str = a(messageDigest.digest());
                    return str;
                }
            }
        } catch (Exception e2) {
            f.a("StringHelper", "ToMd5", e2.toString());
            return str;
        }
    }

    public static String a(String str) {
        try {
            return a(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            return null;
        }
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
