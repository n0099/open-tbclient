package com.baidu.searchbox.account.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.NativeBds;
import com.baidu.searchbox.config.AppConfig;
import org.apache.commons.codec.binary4util.bdapp.Base64;
/* loaded from: classes2.dex */
public final class SocialEncodeUtils {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "SocialEncodeUtils";
    public static final String TAG_SOCIAL = "baiduuid_";
    public static final String TAG_TEL = "tel_";

    public static String getSocialDecrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(NativeBds.dae(str2, Base64.decode(str, 11)));
        } catch (Exception e2) {
            if (DEBUG) {
                Log.i(TAG, "getSocialDecrypt plainText:" + str + ", exception:" + e2);
                return "";
            }
            return "";
        } catch (UnsatisfiedLinkError e3) {
            if (DEBUG) {
                Log.i(TAG, "Only Debug Mode Throw ：UnsatisfiedLinkError exception:" + e3);
                throw e3;
            }
            return "";
        }
    }

    public static String getSocialEncryption(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.encode(NativeBds.ae(str2, str), 11));
        } catch (Exception e2) {
            if (DEBUG) {
                Log.i(TAG, "getSocialEncryption plainText:" + str + ", exception:" + e2);
            }
            return "";
        }
    }
}
