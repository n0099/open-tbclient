package com.baidu.sapi2.b;

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
/* loaded from: classes6.dex */
public class a {
    public static final String a = "SapiScheme";
    public static final String b = "3.0.5";
    public static final int c = 2;
    public static final String d = "3.0.5";
    public static final String e = "com.baidu.passport.securitycenter";
    public static final String f = "baiduppscapp";
    public static final String g = "otp";
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final int m = 3001;
    public static final String n = "achieve_sc_app_data";
    private SapiWebView.InvokeScAppCallback.InvokeScAppResult o;
    private b p;

    public int a(Context context, String str, SapiWebView.InvokeScAppCallback invokeScAppCallback) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(e, 0);
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
        this.o = invokeScAppResult;
        a aVar = new a();
        if (!aVar.a((Context) activity, e)) {
            this.o.setInvokeResult(a(b.b, b.d));
            return;
        }
        try {
            aVar.a(activity, aVar.a(str, str2, list));
        } catch (Exception e2) {
            this.o.setInvokeResult(a(b.a, b.c));
        }
    }

    public void a(int i2, int i3, Intent intent) {
        if (this.o != null) {
            String str = null;
            if (intent != null) {
                str = intent.getExtras().getString(n);
            }
            this.o.setInvokeResult(str);
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

    private String a(int i2, String str) {
        this.p = new b();
        this.p.setResultCode(i2);
        this.p.setResultMsg(str);
        return this.p.a();
    }
}
