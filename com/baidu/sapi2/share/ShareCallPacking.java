package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes.dex */
public class ShareCallPacking {
    public static final String EXTRA_APP_PKG = "PKG";
    public static final String EXTRA_FACE_LOGIN_MODEL = "FACE_LOGIN_MODEL";
    public static final String EXTRA_FACE_LOGIN_UID = "FACE_LOGIN_UID";
    public static final String EXTRA_SDK_VERSION = "SDK_VERSION";
    public static final String EXTRA_V2_FACE_LOGIN_UIDS = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final String LOGIN_TYPE_SHARE_V1_CHOICE = "choice_share";
    public static final String LOGIN_TYPE_SHARE_V2_CHOICE = "choice_share_v2";
    public static final int REQUEST_CODE_V2_SHARE_ACCOUNT = 20001;
    public static final int SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION = 190;
    public static StatModel statModel;

    /* loaded from: classes.dex */
    public static class StatModel {
        public static final String KEY_ACCOUNT_APP = "account_app";
        public static final String KEY_ACCOUNT_TPL = "account_tpl";
        public static final String KEY_INDEX = "index";
        public String accountTpl;
        public String appName;
        public int index;
    }

    public boolean checkPkgSign(Context context, String str) {
        return c.a(context, str);
    }

    public void markLoginState(boolean z) {
        if (a.a().c(SapiAccountManager.getInstance().getConfignation().context)) {
            new ShareStorage().a(z);
            c.a();
        }
        SapiAccountManager.getInstance().getAccountService().refreshOpenidToUid();
    }

    public void startLoginShareActivityForResult(Activity activity, String str, String str2) {
        c.a(activity, str, str2);
    }

    public void onLoginActivityActivityResult(ShareLoginCallBack shareLoginCallBack, int i, int i2, Intent intent) {
        c.a(shareLoginCallBack, i, i2, intent, this);
    }

    /* loaded from: classes.dex */
    public static abstract class ShareLoginCallBack {
        public abstract void onSuccess();

        public void onFailed(int i, String str) {
        }
    }
}
