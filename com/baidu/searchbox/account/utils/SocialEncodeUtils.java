package com.baidu.searchbox.account.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.NativeBds;
import com.baidu.searchbox.config.AppConfig;
import org.apache.commons.codec.binary4util.bdapp.Base64;
/* loaded from: classes12.dex */
public final class SocialEncodeUtils {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "SocialEncodeUtils";
    public static final String TAG_SOCIAL = "baiduuid_";
    public static final String TAG_TEL = "tel_";

    private SocialEncodeUtils() {
    }

    public static String getSocialEncryption(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.encode(NativeBds.ae(str2, str), 11));
        } catch (Exception e) {
            if (DEBUG) {
                Log.i(TAG, "getSocialEncryption plainText:" + str + ", exception:" + e);
            }
            return "";
        }
    }

    public static String getSocialDecrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(NativeBds.dae(str2, Base64.decode(str, 11)));
        } catch (Exception e) {
            if (DEBUG) {
                Log.i(TAG, "getSocialDecrypt plainText:" + str + ", exception:" + e);
            }
            return "";
        } catch (UnsatisfiedLinkError e2) {
            if (!DEBUG) {
                return "";
            }
            Log.i(TAG, "Only Debug Mode Throw ：UnsatisfiedLinkError exception:" + e2);
            throw e2;
        }
    }
}
