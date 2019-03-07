package com.baidu.location.g;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.android.bbalbs.common.util.DeviceId;
import com.baidu.location.a.k;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.tencent.connect.common.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b {
    public String a = null;
    public String b = null;
    public String c = null;
    private boolean j = false;
    private static b i = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static int h = 0;

    private b() {
        if (com.baidu.location.f.getServiceContext() != null) {
            a(com.baidu.location.f.getServiceContext());
        }
    }

    public static b a() {
        if (i == null) {
            i = new b();
        }
        return i;
    }

    public String a(boolean z) {
        return a(z, (String) null);
    }

    public String a(boolean z, String str) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.8f);
        if (z) {
            if (g.g.equals("all")) {
                stringBuffer.append("&addr=allj");
            }
            if (g.i) {
                stringBuffer.append("&adtp=n2");
            }
            if (g.h || g.k || g.l || g.j) {
                stringBuffer.append("&sema=");
                if (g.h) {
                    stringBuffer.append("aptag|");
                }
                if (g.j) {
                    stringBuffer.append("aptagd|");
                }
                if (g.k) {
                    stringBuffer.append("poiregion|");
                }
                if (g.l) {
                    stringBuffer.append("regular");
                }
            }
        }
        if (z) {
            if (str == null) {
                stringBuffer.append("&coor=gcj02");
            } else {
                stringBuffer.append("&coor=");
                stringBuffer.append(str);
            }
            String j = com.baidu.location.e.d.j();
            if (j != null) {
                stringBuffer.append(j);
            }
        }
        if (this.b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.b);
            if (this.a != null && !this.a.equals("NULL") && !this.b.contains(new StringBuffer(this.a).reverse().toString())) {
                stringBuffer.append("&Aim=");
                stringBuffer.append(this.a);
            }
        }
        if (this.c != null) {
            stringBuffer.append("&Aid=");
            stringBuffer.append(this.c);
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(com.baidu.location.f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        String b = g.b();
        if (b != null) {
            stringBuffer.append("&laip=");
            stringBuffer.append(b);
        }
        float b2 = k.a().b();
        if (b2 != 0.0f) {
            stringBuffer.append("&altv=");
            stringBuffer.append(String.format(Locale.US, "%.5f", Float.valueOf(b2)));
        }
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        if (z) {
            stringBuffer.append("&sv=");
            String str2 = Build.VERSION.RELEASE;
            if (str2 != null && str2.length() > 6) {
                str2 = str2.substring(0, 6);
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public void a(Context context) {
        if (context == null || this.j) {
            return;
        }
        try {
            this.a = ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
        } catch (Exception e2) {
            this.a = "NULL";
        }
        try {
            this.b = CommonParam.getCUID(context);
        } catch (Exception e3) {
            this.b = null;
        }
        try {
            this.c = DeviceId.getAndroidId(context);
        } catch (Exception e4) {
            this.c = null;
        }
        try {
            d = context.getPackageName();
        } catch (Exception e5) {
            d = null;
        }
        g.o = "" + this.b;
        this.j = true;
    }

    public void a(String str, String str2) {
        e = str;
        d = str2;
    }

    public String b() {
        return this.b != null ? "v7.8|" + this.b + "|" + Build.MODEL : "v7.8|" + this.a + "|" + Build.MODEL;
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.b != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.b);
        } else {
            stringBuffer.append("&im=");
            stringBuffer.append(this.a);
        }
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception e2) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(d);
        } catch (Exception e3) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.8f);
        return stringBuffer.toString();
    }

    public String d() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.b);
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.8f);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&stp=1");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        stringBuffer.append("&prod=");
        stringBuffer.append(e + ":" + d);
        stringBuffer.append(g.e(com.baidu.location.f.getServiceContext()));
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        return stringBuffer.toString();
    }
}
