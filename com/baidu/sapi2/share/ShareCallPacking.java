package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ShareCallPacking {
    public static final String EXTRA_FACE_LOGIN_UID = "FACE_LOGIN_UID";
    private static final int a = 2006;
    private static final String b = "share_account";
    private static final String c = "share_fail_reason";

    /* loaded from: classes.dex */
    public interface ShareLoginCallBack {
        void onSuccess();
    }

    public boolean checkPkgSign(Context context, String str) {
        return d.a(context, str);
    }

    public void markLoginState(boolean z) {
        if (a.a().c(SapiAccountManager.getInstance().getConfignation().context)) {
            new c().a(z);
            d.a();
        }
    }

    public void startLoginShareActivityForResult(Activity activity, String str, String str2) {
        if (activity == null) {
            throw new IllegalArgumentException("loginActivity can't be null");
        }
        if (!TextUtils.isEmpty(str)) {
            ComponentName componentName = new ComponentName(str, "com.baidu.sapi2.activity.ShareActivity");
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.setComponent(componentName);
            activity.startActivityForResult(intent, a);
        } else {
            Toast.makeText(activity, Web2NativeLoginResult.ERROR_MSG_UNKNOWN, 0).show();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(activity));
        hashMap.put("device", Build.MODEL);
        StatService.onEvent("share_account_click", hashMap, false);
    }

    public void onLoginActivityActivityResult(Activity activity, ShareLoginCallBack shareLoginCallBack, int i, int i2, Intent intent) {
        int i3;
        String stringExtra;
        if (i == a) {
            if (activity == null || shareLoginCallBack == null) {
                throw new IllegalArgumentException("loginActivity and shareLoginCallBack can't be null");
            }
            if (i2 == -1) {
                SapiAccount sapiAccount = (SapiAccount) intent.getParcelableExtra("share_account");
                if (sapiAccount != null) {
                    SapiContext sapiContext = SapiContext.getInstance(activity);
                    sapiContext.setCurrentAccount(sapiAccount);
                    SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
                    sapiContext.addLoginAccount(sapiAccount);
                    new ShareCallPacking().markLoginState(false);
                    sapiContext.removeShareAccount(sapiAccount);
                    String stringExtra2 = intent.getStringExtra("FACE_LOGIN_UID");
                    if (!TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(SapiContext.getInstance(activity).getFaceLoginUid())) {
                        SapiContext.getInstance(activity).setFaceLoginUid(stringExtra2);
                    }
                    shareLoginCallBack.onSuccess();
                    stringExtra = "";
                    i3 = 0;
                } else {
                    i3 = 1;
                    stringExtra = SapiResult.ERROR_MSG_SHARE_ACCOUNT_IS_EMPTY;
                    Toast.makeText(activity, SapiResult.ERROR_MSG_SHARE_ACCOUNT_IS_EMPTY, 0).show();
                }
            } else {
                i3 = 2;
                stringExtra = intent.getStringExtra("share_fail_reason");
                Toast.makeText(activity, intent.getStringExtra("share_fail_reason"), 0).show();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cuid", SapiUtils.getClientId(activity));
            hashMap.put("device", Build.MODEL);
            hashMap.put("share_result", i3 + "");
            hashMap.put("fail_reason", stringExtra);
            StatService.onEvent("share_account_result", hashMap, false);
        }
    }
}
