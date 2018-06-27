package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes.dex */
public class ShareCallPacking {
    public static final String EXTRA_FACE_LOGIN_MODEL = "FACE_LOGIN_MODEL";
    public static final String EXTRA_FACE_LOGIN_UID = "FACE_LOGIN_UID";
    public static final int REQUEST_CODE_V2_SHARE_ACCOUNT = 20001;

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
