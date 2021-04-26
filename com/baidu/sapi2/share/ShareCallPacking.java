package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import java.util.List;
/* loaded from: classes2.dex */
public class ShareCallPacking {
    public static final String EXTRA_APP_PKG = "PKG";
    public static final String EXTRA_CALL_TYPE_SHARE = "call_type_share";
    public static final String EXTRA_FROM_APP_TPL = "extra_from_app_tpl";
    public static final String EXTRA_LOGIN_TYPE_SHARE = "login_type_share";
    public static final String EXTRA_SDK_VERSION = "SDK_VERSION";
    public static final String EXTRA_SESSION_ID = "extra_session_id";
    public static final String EXTRA_TRACE_ID = "extra_trace_id";
    public static final String EXTRA_V2_FACE_LOGIN_UIDS = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final String LOGIN_TYPE_SHARE_V1_CHOICE = "choice_share";
    public static final String LOGIN_TYPE_SHARE_V2_CHOICE = "choice_share_v2";
    public static final int REQUEST_CODE_V2_SHARE_ACCOUNT = 20001;
    public static final int SHARE_V2_WITH_ACCOUNT_PKG_SDK_VERSION = 190;
    public static StatModel statModel;

    /* loaded from: classes2.dex */
    public static abstract class ShareLoginCallBack {
        public void onFailed(int i2, String str) {
        }

        public abstract void onSuccess();
    }

    /* loaded from: classes2.dex */
    public static class StatModel {
        public static final String KEY_ACCOUNT_APP = "account_app";
        public static final String KEY_ACCOUNT_TPL = "account_tpl";
        public static final String KEY_CALL_TYPE = "call_type";
        public static final String KEY_INDEX = "index";
        public static final String KEY_SHARE_VERSION = "share_version";
        public String accountTpl;
        public String appName;
        public int index;
        public String shareVersion;
    }

    public void asyncMarkLoginState(final int i2) {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.ShareCallPacking.1
            @Override // java.lang.Runnable
            public void run() {
                ShareCallPacking.this.syncMarkLoginState(i2);
            }
        }));
    }

    public boolean checkPkgSign(Context context, String str) {
        return ShareUtils.checkCalleeIdentity(context, str);
    }

    public void onLoginActivityActivityResult(ShareLoginCallBack shareLoginCallBack, int i2, int i3, Intent intent, List<PassNameValuePair> list, String str) {
        ShareUtils.onLoginActivityActivityResult(shareLoginCallBack, i2, i3, intent, this, list, str);
    }

    public void startLoginShareActivityForResult(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5, String str6) {
        ShareUtils.startLoginShareActivityForResult(activity, str, str2, str3, str4, list, str5, str6);
    }

    public void syncMarkLoginState(int i2) {
        new ShareStorage().syncSet(i2);
        ShareUtils.setShareStorageModel();
    }
}
