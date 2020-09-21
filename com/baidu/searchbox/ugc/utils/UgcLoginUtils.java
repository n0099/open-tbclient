package com.baidu.searchbox.ugc.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.NativeBds;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import org.apache.commons.codec.binary4util.bdapp.Base64;
/* loaded from: classes4.dex */
public class UgcLoginUtils {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "UgcLoginUtils";
    public static final String TAG_TEL = "tel_";
    public static final String TAG_UID = "baiduuid_";
    public static final String UGC_LOGIN_SRC = "ugc_fabu";

    public static boolean isLogin() {
        BoxAccountManager boxAccountManager = (BoxAccountManager) c.a(BoxAccountManager.SERVICE_REFERENCE);
        return boxAccountManager != null && boxAccountManager.isLogin();
    }

    public static boolean isGuestLogin() {
        BoxAccountManager boxAccountManager = (BoxAccountManager) c.a(BoxAccountManager.SERVICE_REFERENCE);
        return boxAccountManager != null && boxAccountManager.isGuestLogin();
    }

    public static void login(ILoginResultListener iLoginResultListener, UserAccountActionItem.UserAccountAction userAccountAction, UserAccountActionItem.UserAccountType userAccountType, String str) {
        BoxAccountManager boxAccountManager = (BoxAccountManager) c.a(BoxAccountManager.SERVICE_REFERENCE);
        LoginParams build = new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(userAccountAction, userAccountType, str)).build();
        if (boxAccountManager != null) {
            boxAccountManager.combineLogin(AppRuntime.getAppContext(), build, 2, iLoginResultListener);
        }
    }

    public static void bindPhone(ILoginResultListener iLoginResultListener, UserAccountActionItem.UserAccountAction userAccountAction, UserAccountActionItem.UserAccountType userAccountType, String str) {
        ((BoxAccountManager) c.a(BoxAccountManager.SERVICE_REFERENCE)).bindPhone(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(userAccountAction, userAccountType, str)).build(), iLoginResultListener);
    }

    public static String getUgcEncryption(String str, String str2) {
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

    public static String getUK() {
        BoxAccountManager boxAccountManager = (BoxAccountManager) c.a(BoxAccountManager.SERVICE_REFERENCE);
        String session = (boxAccountManager == null || !boxAccountManager.isLogin()) ? null : boxAccountManager.getSession(BoxAccountManager.SESSION_UID);
        if (TextUtils.isEmpty(session)) {
            return null;
        }
        return getUgcEncryption(session, "baiduuid_");
    }
}
