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
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.IntentConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
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
    public SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult;
    public SchemeResult schemeResult;

    private String buildResult(int i, String str) {
        SchemeResult schemeResult = new SchemeResult();
        this.schemeResult = schemeResult;
        schemeResult.setResultCode(i);
        this.schemeResult.setResultMsg(str);
        return this.schemeResult.toJson();
    }

    private void startActivityForResult(Activity activity, String str) throws Exception {
        activity.startActivityForResult(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str)), 3001);
    }

    private String buildScheme(String str, String str2, List<PassNameValuePair> list) {
        String str3 = "baiduppscapp://v2/" + str + "?";
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new PassNameValuePair("minver", str2));
        return str3 + SapiUtils.createRequestParams(list);
    }

    public boolean checkPackageSign(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(SapiContext.getInstance().getAuthorizedPackages());
            hashMap.putAll(SapiContext.getInstance().getSCAuthorizedPackages());
            String packageSign = SapiUtils.getPackageSign(context, str);
            if (!TextUtils.isEmpty(packageSign)) {
                for (String str2 : hashMap.keySet()) {
                    if (str.matches(str2) && packageSign.equals(hashMap.get(str2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getInvokeScState(Context context, String str, SapiWebView.InvokeScAppCallback invokeScAppCallback) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(SC_APP_PACKAGENAME, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            if (SapiUtils.versionCompareTo(packageInfo.versionName, str) < 0) {
                return 1;
            }
            if (invokeScAppCallback == null) {
                return 4;
            }
            if (checkPackageSign(context, context.getPackageName())) {
                return 0;
            }
            return 3;
        }
        return 2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.invokeScAppResult == null) {
            return;
        }
        String str = null;
        if (intent != null) {
            str = intent.getExtras().getString(EXTRA_ACHIEVE_SC_APP_DATA);
        }
        this.invokeScAppResult.setInvokeResult(str);
    }

    public void invokeScApp(Activity activity, String str, String str2, List<PassNameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
        this.invokeScAppResult = invokeScAppResult;
        SapiScheme sapiScheme = new SapiScheme();
        if (!sapiScheme.checkPackageSign(activity, SC_APP_PACKAGENAME)) {
            this.invokeScAppResult.setInvokeResult(buildResult(-604, SchemeResult.ERROR_MSG_SC_PACKAGE_SIGN_ERROR));
            return;
        }
        try {
            sapiScheme.startActivityForResult(activity, sapiScheme.buildScheme(str, str2, list));
        } catch (Exception unused) {
            this.invokeScAppResult.setInvokeResult(buildResult(-603, SchemeResult.ERROR_MSG_SYSTEM_ERROR));
        }
    }
}
