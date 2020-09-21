package com.baidu.sapi2.f;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes25.dex */
public class a {
    public static final String c = "SapiScheme";
    public static final String d = "3.0.5";
    public static final int e = 2;
    public static final String f = "3.0.5";
    public static final String g = "com.baidu.passport.securitycenter";
    public static final String h = "baiduppscapp";
    public static final String i = "otp";
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 4;
    public static final int o = 3001;
    public static final String p = "achieve_sc_app_data";
    private SapiWebView.InvokeScAppCallback.InvokeScAppResult a;
    private b b;

    public int a(Context context, String str, SapiWebView.InvokeScAppCallback invokeScAppCallback) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(g, 0);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (packageInfo != null) {
            if (SapiUtils.versionCompareTo(packageInfo.versionName, str) < 0) {
                return 1;
            }
            if (invokeScAppCallback == null) {
                return 4;
            }
            return !a(context, context.getPackageName()) ? 3 : 0;
        }
        return 2;
    }

    public void a(Activity activity, String str, String str2, List<PassNameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
        this.a = invokeScAppResult;
        a aVar = new a();
        if (!aVar.a((Context) activity, g)) {
            this.a.setInvokeResult(a(b.b, b.d));
            return;
        }
        try {
            aVar.a(activity, aVar.a(str, str2, list));
        } catch (Exception e2) {
            this.a.setInvokeResult(a(b.a, b.c));
        }
    }

    public void a(int i2, int i3, Intent intent) {
        if (this.a != null) {
            String str = null;
            if (intent != null) {
                str = intent.getExtras().getString(p);
            }
            this.a.setInvokeResult(str);
        }
    }

    private String a(String str, String str2, List<PassNameValuePair> list) {
        String str3 = "baiduppscapp://v2/" + str + "?";
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new PassNameValuePair("minver", str2));
        return str3 + SapiUtils.createRequestParams(list);
    }

    private void a(Activity activity, String str) throws Exception {
        activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), 3001);
    }

    public boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
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
        return false;
    }

    private String a(int i2, String str) {
        this.b = new b();
        this.b.setResultCode(i2);
        this.b.setResultMsg(str);
        return this.b.a();
    }
}
