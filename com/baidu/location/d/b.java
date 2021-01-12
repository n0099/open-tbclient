package com.baidu.location.d;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.a.n;
import com.tencent.connect.common.Constants;
import java.util.Locale;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f2625a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f2626b = null;
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
        stringBuffer.append(7.63f);
        if (z) {
            if (j.g.equals("all")) {
                stringBuffer.append("&addr=allj");
            }
            if (j.i) {
                stringBuffer.append("&adtp=n2");
            }
            if (j.h || j.k || j.l || j.j) {
                stringBuffer.append("&sema=");
                if (j.h) {
                    stringBuffer.append("aptag|");
                }
                if (j.j) {
                    stringBuffer.append("aptagd|");
                }
                if (j.k) {
                    stringBuffer.append("poiregion|");
                }
                if (j.l) {
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
            String j = com.baidu.location.b.e.j();
            if (j != null) {
                stringBuffer.append(j);
            }
        }
        if (this.f2626b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.f2625a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.f2626b);
            if (this.f2625a != null && !this.f2625a.equals("NULL") && !this.f2626b.contains(new StringBuffer(this.f2625a).reverse().toString())) {
                stringBuffer.append("&Aim=");
                stringBuffer.append(this.f2625a);
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
        String b2 = j.b();
        if (b2 != null) {
            stringBuffer.append("&laip=");
            stringBuffer.append(b2);
        }
        float d2 = n.a().d();
        if (d2 != 0.0f) {
            stringBuffer.append("&altv=");
            stringBuffer.append(String.format(Locale.US, "%.5f", Float.valueOf(d2)));
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
            this.f2625a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e2) {
            this.f2625a = "NULL";
        }
        try {
            this.f2626b = CommonParam.a(context);
        } catch (Exception e3) {
            this.f2626b = null;
        }
        try {
            this.c = com.baidu.android.bbalbs.common.util.b.c(context);
        } catch (Exception e4) {
            this.c = null;
        }
        try {
            d = context.getPackageName();
        } catch (Exception e5) {
            d = null;
        }
        j.o = "" + this.f2626b;
        this.j = true;
    }

    public void a(String str, String str2) {
        e = str;
        d = str2;
    }
}
