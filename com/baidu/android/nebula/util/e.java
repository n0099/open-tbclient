package com.baidu.android.nebula.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.CommonParam;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f684a = e.class.getSimpleName();
    private static e b;
    private Context c;
    private long e;
    private String f;
    private String g;
    private String i;
    private String j;
    private String k;
    private String m;
    private String p;
    private String d = "0.0.0.0";
    private String h = "";
    private String l = "xcloud";
    private String n = "app_moblie_txt";
    private String o = SocialConstants.TRUE;

    private e(Context context) {
        b(context);
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                b = new e(context);
            }
            eVar = b;
        }
        return eVar;
    }

    private String b(String str) {
        try {
            return URLEncoder.encode(str, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private String c(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.densityDpi;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append("_");
        stringBuffer.append(i2);
        stringBuffer.append("_");
        stringBuffer.append(SocialConstants.ANDROID_CLIENT_TYPE);
        stringBuffer.append("_");
        stringBuffer.append(this.d);
        stringBuffer.append("_");
        stringBuffer.append(i3);
        return stringBuffer.toString();
    }

    private String d() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        return str.replace("_", "-") + "_" + str2.replace("_", "-") + "_" + Build.VERSION.SDK_INT + "_" + Build.MANUFACTURER.replace("_", "-");
    }

    private String d(Context context) {
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager != null ? telephonyManager.getDeviceId() : null;
        } catch (Exception e) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    private String e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1);
        String string = sharedPreferences.getString("xboss_appid", "000000");
        if (!"000000".equals(string)) {
            return string;
        }
        InputStream resourceAsStream = e.class.getResourceAsStream("/appidconfig.ini");
        if (resourceAsStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            try {
                string = bufferedReader.readLine();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        }
        if (!TextUtils.isEmpty(string)) {
            sharedPreferences.edit().putString("xboss_appid", string);
            return string;
        }
        String str = "000000";
        Iterator it = com.baidu.android.moplus.util.b.g(context).iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String str3 = ((ResolveInfo) it.next()).activityInfo.packageName;
            try {
                str = context.createPackageContext(str3, 0).getSharedPreferences(str3 + ".push_sync", 0).getString("xboss_appid", "000000");
            } catch (PackageManager.NameNotFoundException e5) {
                str = str2;
            }
            if (!"000000".equals(str)) {
                return str;
            }
        }
    }

    public String a() {
        return this.i;
    }

    public String a(String str) {
        if (str.indexOf("?") < 0) {
            str = str + "?";
        }
        if (!str.endsWith("&") && !str.endsWith("?")) {
            str = str + "&";
        }
        String b2 = b(this.m);
        String b3 = b(this.k);
        String b4 = b(this.j);
        String b5 = b(this.c.getPackageName());
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

    public String a(String str, boolean z) {
        if (str.indexOf("?") < 0) {
            str = str + "?";
        }
        if (!str.endsWith("&") && !str.endsWith("?")) {
            str = str + "&";
        }
        StringBuffer stringBuffer = new StringBuffer();
        String b2 = b(this.m);
        String b3 = b(this.l);
        String b4 = b(this.j);
        String b5 = b(this.k);
        String b6 = b(this.n);
        String b7 = b(this.o);
        stringBuffer.append("cuid@" + b2 + ",");
        stringBuffer.append("osname@" + b3 + ",");
        stringBuffer.append("cua@" + b4 + ",");
        stringBuffer.append("cut@" + b5 + ",");
        stringBuffer.append("csrc@" + b6 + ",");
        stringBuffer.append("ctv@" + b7 + ",");
        String b8 = b(stringBuffer.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);
        stringBuffer2.append("pkgname=" + b(this.p));
        stringBuffer2.append("&");
        stringBuffer2.append("ver=" + b(String.valueOf(this.e)));
        stringBuffer2.append("&");
        if (z) {
            stringBuffer2.append("vfrom=" + b(SocialConstants.TRUE));
            stringBuffer2.append("&");
        }
        stringBuffer2.append("pu=" + b8);
        return stringBuffer2.toString();
    }

    public String b() {
        return this.h;
    }

    public void b(Context context) {
        this.c = context.getApplicationContext();
        PackageInfo b2 = com.baidu.android.systemmonitor.d.a.b(context, context.getPackageName());
        this.e = b2.versionCode;
        this.d = b2.versionName;
        this.p = b2.packageName;
        this.h = (String) b2.applicationInfo.loadLabel(this.c.getPackageManager());
        this.f = Build.VERSION.RELEASE;
        this.g = d(this.c);
        this.i = e(context);
        this.j = c(this.c);
        this.k = d();
        this.m = CommonParam.getCUID(this.c);
    }

    public String c() {
        return this.d;
    }
}
