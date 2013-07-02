package com.baidu.android.nebula.localserver.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.CommonParam;
import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public final class d {
    private static final String a = d.class.getSimpleName();
    private static d b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Context g;

    private d(Context context) {
        b(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d(context.getApplicationContext());
            }
            dVar = b;
        }
        return dVar;
    }

    private String b(String str) {
        try {
            return URLEncoder.encode(str, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private void b(Context context) {
        this.g = context;
        this.c = CommonParam.getCUID(context);
        this.e = a();
        this.d = c(context);
    }

    private String c(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.densityDpi;
        try {
            this.f = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append("_");
        stringBuffer.append(i2);
        stringBuffer.append("_");
        stringBuffer.append("android");
        stringBuffer.append("_");
        stringBuffer.append(this.f);
        stringBuffer.append("_");
        stringBuffer.append(i3);
        return stringBuffer.toString();
    }

    public String a() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        return str.replace("_", "-") + "_" + str2 + "_" + Build.VERSION.SDK_INT + "_" + Build.MANUFACTURER.replace("_", "-");
    }

    public String a(String str) {
        if (str.indexOf("?") < 0) {
            str = str + "?";
        }
        if (!str.endsWith("&") && !str.endsWith("?")) {
            str = str + "&";
        }
        String b2 = b(this.c);
        String b3 = b(this.e);
        String b4 = b(this.d);
        String b5 = b(this.g.getPackageName());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("cuid=" + b2);
        stringBuffer.append("&");
        stringBuffer.append("cua=" + b4);
        stringBuffer.append("&");
        stringBuffer.append("cut=" + b3);
        stringBuffer.append("&");
        stringBuffer.append("sdfrom=" + b5);
        stringBuffer.append("&");
        stringBuffer.append("lcid=miiasdk");
        return stringBuffer.toString();
    }
}
