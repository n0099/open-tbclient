package com.baidu.cloudbase.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public class b {
    public static String anN;
    public static String anO;

    public static String Y(Context context) {
        return z(context, AlaRecorderLog.Protocol.RTC);
    }

    public static String Z(Context context) {
        if (TextUtils.isEmpty(anN)) {
            tZ();
        }
        return y(context, anN) + File.separator + "jniLibs" + File.separator + getCPUType();
    }

    public static void dn(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "armeabi-v7a";
        }
        anO = str;
    }

    public static String getCPUType() {
        return TextUtils.isEmpty(anO) ? "armeabi-v7a" : anO;
    }

    public static String m(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = Y(context);
        }
        return str2 + File.separator + md5(str);
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b2 : MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(str.getBytes())) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2.toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean n(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        String m = m(context, str, str2);
        return com.baidu.cloudbase.d.a.isExists(m + File.separator + "jniLibs" + File.separator + getCPUType() + File.separator + "libjingle_peerconnection_so.so");
    }

    public static String tZ() {
        anN = "https://b.bdstatic.com/searchbox/androidvideo/" + ua();
        return anN;
    }

    public static String ua() {
        return getCPUType() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + AlaRecorderLog.Protocol.RTC + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "5.4.15.zip";
    }

    public static String y(Context context, String str) {
        return m(context, str, Y(context));
    }

    public static String z(Context context, String str) {
        if (context == null) {
            return null;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        sb.append(File.separator);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
