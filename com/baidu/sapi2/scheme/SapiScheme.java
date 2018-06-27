package com.baidu.sapi2.scheme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SapiScheme {
    public static final String ACTION_SC_APP_OTP = "otp";
    public static final String EXTRA_ACHIEVE_SC_APP_DATA = "achieve_sc_app_data";
    public static final int REQUEST_CODE_START_SC_APP_VERIFY = 3001;
    public static final String SCHEME_CUR_SUP_SC_MIN_APP_VERSION = "3.0.5";
    public static final int SCHEME_PROTOCOL_VER = 2;
    public static final String SCHEME_SUP_MIN_SC_APP_VER = "3.0.5";
    public static final String SC_APP_PACKAGENAME = "com.baidu.passport.securitycenter";
    public static final String SC_APP_SCHEME = "baiduppscapp";
    public static final int SC_APP_STATE_APP_NOT_INVALID = 3;
    public static final int SC_APP_STATE_CAN_INVOKE = 0;
    public static final int SC_APP_STATE_NEED_UPGRADE = 1;
    public static final int SC_APP_STATE_UNINSTALLED = 2;
    public static final int SC_APP_STATE_UNSUP_INVOKE_SC = 4;
    public static final String TAG = "SapiScheme";
    private SapiWebView.InvokeScAppCallback.InvokeScAppResult a;
    private a b;

    public int getInvokeScState(Context context, String str, SapiWebView.InvokeScAppCallback invokeScAppCallback) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(SC_APP_PACKAGENAME, 0);
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (packageInfo == null) {
            return 2;
        }
        if (SapiUtils.compareVersion(packageInfo.versionName, str) < 0) {
            return 1;
        }
        if (invokeScAppCallback == null) {
            return 4;
        }
        return !checkPackageSign(context, context.getPackageName()) ? 3 : 0;
    }

    public void invokeScApp(Activity activity, String str, String str2, List<NameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
        this.a = invokeScAppResult;
        SapiScheme sapiScheme = new SapiScheme();
        if (!sapiScheme.checkPackageSign(activity, SC_APP_PACKAGENAME)) {
            this.a.setInvokeResult(a(a.b, a.d));
            return;
        }
        try {
            sapiScheme.a(activity, sapiScheme.a(str, str2, list));
        } catch (Exception e) {
            this.a.setInvokeResult(a(a.a, a.c));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.a != null) {
            String str = null;
            if (intent != null) {
                str = intent.getExtras().getString(EXTRA_ACHIEVE_SC_APP_DATA);
            }
            this.a.setInvokeResult(str);
        }
    }

    private String a(String str, String str2, List<NameValuePair> list) {
        String str3 = "baiduppscapp://v2/" + str + "?";
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new BasicNameValuePair("minver", str2));
        return str3 + SapiUtils.createRequestParams(list);
    }

    private void a(Activity activity, String str) throws Exception {
        activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), 3001);
    }

    public boolean checkPackageSign(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(SapiContext.getInstance(context).getAuthorizedPackages());
        hashMap.putAll(SapiContext.getInstance(context).getSCAuthorizedPackages());
        String packageSign = SapiUtils.getPackageSign(context, str);
        if (!TextUtils.isEmpty(packageSign)) {
            for (String str2 : hashMap.keySet()) {
                if (str.matches(str2) && packageSign.equals(hashMap.get(str2))) {
                    return true;
                }
            }
        }
        return false;
    }

    private String a(int i, String str) {
        this.b = new a();
        this.b.setResultCode(i);
        this.b.setResultMsg(str);
        return this.b.a();
    }
}
