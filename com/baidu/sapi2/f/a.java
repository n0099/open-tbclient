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
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f11220c = "SapiScheme";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11221d = "3.0.5";

    /* renamed from: e  reason: collision with root package name */
    public static final int f11222e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final String f11223f = "3.0.5";

    /* renamed from: g  reason: collision with root package name */
    public static final String f11224g = "com.baidu.passport.securitycenter";

    /* renamed from: h  reason: collision with root package name */
    public static final String f11225h = "baiduppscapp";
    public static final String i = "otp";
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 4;
    public static final int o = 3001;
    public static final String p = "achieve_sc_app_data";

    /* renamed from: a  reason: collision with root package name */
    public SapiWebView.InvokeScAppCallback.InvokeScAppResult f11226a;

    /* renamed from: b  reason: collision with root package name */
    public b f11227b;

    public int a(Context context, String str, SapiWebView.InvokeScAppCallback invokeScAppCallback) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(f11224g, 0);
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
            return !a(context, context.getPackageName()) ? 3 : 0;
        }
        return 2;
    }

    public void a(Activity activity, String str, String str2, List<PassNameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
        this.f11226a = invokeScAppResult;
        a aVar = new a();
        if (!aVar.a((Context) activity, f11224g)) {
            this.f11226a.setInvokeResult(a(b.f11229b, b.f11231d));
            return;
        }
        try {
            aVar.a(activity, aVar.a(str, str2, list));
        } catch (Exception unused) {
            this.f11226a.setInvokeResult(a(b.f11228a, b.f11230c));
        }
    }

    public void a(int i2, int i3, Intent intent) {
        if (this.f11226a == null) {
            return;
        }
        this.f11226a.setInvokeResult(intent != null ? intent.getExtras().getString(p) : null);
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

    private String a(int i2, String str) {
        b bVar = new b();
        this.f11227b = bVar;
        bVar.setResultCode(i2);
        this.f11227b.setResultMsg(str);
        return this.f11227b.a();
    }
}
