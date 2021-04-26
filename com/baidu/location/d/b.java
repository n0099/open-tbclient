package com.baidu.location.d;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.a.n;
import com.tencent.connect.common.Constants;
import java.util.Locale;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static String f6944d;

    /* renamed from: e  reason: collision with root package name */
    public static String f6945e;

    /* renamed from: f  reason: collision with root package name */
    public static String f6946f;

    /* renamed from: g  reason: collision with root package name */
    public static String f6947g;

    /* renamed from: h  reason: collision with root package name */
    public static int f6948h;

    /* renamed from: i  reason: collision with root package name */
    public static b f6949i;

    /* renamed from: a  reason: collision with root package name */
    public String f6950a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f6951b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f6952c = null;
    public boolean j = false;

    public b() {
        if (com.baidu.location.f.getServiceContext() != null) {
            a(com.baidu.location.f.getServiceContext());
        }
    }

    public static b a() {
        if (f6949i == null) {
            f6949i = new b();
        }
        return f6949i;
    }

    public String a(boolean z) {
        return a(z, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(boolean z, String str) {
        String b2;
        float d2;
        String str2;
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.63f);
        if (z) {
            if (j.f6991g.equals("all")) {
                stringBuffer.append("&addr=allj");
            }
            if (j.f6993i) {
                stringBuffer.append("&adtp=n2");
            }
            if (j.f6992h || j.k || j.l || j.j) {
                stringBuffer.append("&sema=");
                if (j.f6992h) {
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
                str = "&coor=gcj02";
            } else {
                stringBuffer.append("&coor=");
            }
            stringBuffer.append(str);
            String j = com.baidu.location.b.e.j();
            if (j != null) {
                stringBuffer.append(j);
            }
        }
        if (this.f6951b != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.f6951b);
            String str3 = this.f6950a;
            str2 = (str3 == null || str3.equals("NULL") || this.f6951b.contains(new StringBuffer(this.f6950a).reverse().toString())) ? "&Aim=" : "&Aim=";
            if (this.f6952c != null) {
                stringBuffer.append("&Aid=");
                stringBuffer.append(this.f6952c);
            }
            stringBuffer.append("&fw=");
            stringBuffer.append(com.baidu.location.f.getFrameVersion());
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            b2 = j.b();
            if (b2 != null) {
                stringBuffer.append("&laip=");
                stringBuffer.append(b2);
            }
            d2 = n.a().d();
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
                String str4 = Build.VERSION.RELEASE;
                if (str4 != null && str4.length() > 6) {
                    str4 = str4.substring(0, 6);
                }
                stringBuffer.append(str4);
            }
            return stringBuffer.toString();
        }
        str2 = "&im=";
        stringBuffer.append(str2);
        stringBuffer.append(this.f6950a);
        if (this.f6952c != null) {
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(com.baidu.location.f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        b2 = j.b();
        if (b2 != null) {
        }
        d2 = n.a().d();
        if (d2 != 0.0f) {
        }
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        if (z) {
        }
        return stringBuffer.toString();
    }

    public void a(Context context) {
        if (context == null || this.j) {
            return;
        }
        try {
            this.f6950a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            this.f6950a = "NULL";
        }
        try {
            this.f6951b = CommonParam.a(context);
        } catch (Exception unused2) {
            this.f6951b = null;
        }
        try {
            this.f6952c = com.baidu.android.bbalbs.common.util.b.c(context);
        } catch (Exception unused3) {
            this.f6952c = null;
        }
        try {
            f6944d = context.getPackageName();
        } catch (Exception unused4) {
            f6944d = null;
        }
        j.o = "" + this.f6951b;
        this.j = true;
    }

    public void a(String str, String str2) {
        f6945e = str;
        f6944d = str2;
    }
}
