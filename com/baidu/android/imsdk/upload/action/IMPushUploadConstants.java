package com.baidu.android.imsdk.upload.action;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public class IMPushUploadConstants {
    public static final String BIM_LOG_ID = "log-id";
    public static final int ERROR_CODE = -1;
    public static final String ONLINE_URL = "https://pimlog.baidu.com/LogService/PushIMLog";
    public static final String TAG = "BIMUploadUbc";
    public static final int VERSION = 1;

    /* loaded from: classes9.dex */
    public static class Service {
        public static final String BAIDU_APP = "baidu_app";
    }

    @SuppressLint({"DefaultLocale"})
    public static String sign(Context context, String str, long j) {
        return md5(context, String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j)));
    }

    private static String md5(Context context, String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));
            }
            Log.d(TAG, "sign origin :" + str + ", md5: " + sb.toString());
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "md5 exception ", e);
            return "";
        }
    }
}
