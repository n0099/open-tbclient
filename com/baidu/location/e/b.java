package com.baidu.location.e;

import android.content.Context;
import android.os.Build;
import com.baidu.android.bbalbs.common.util.CommonParam;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static String f6719e;

    /* renamed from: f  reason: collision with root package name */
    public static String f6720f;

    /* renamed from: g  reason: collision with root package name */
    public static String f6721g;

    /* renamed from: h  reason: collision with root package name */
    public static String f6722h;

    /* renamed from: i  reason: collision with root package name */
    public static int f6723i;
    public static b j;

    /* renamed from: a  reason: collision with root package name */
    public String f6724a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f6725b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f6726c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f6727d = null;
    public boolean k = false;

    public b() {
        if (com.baidu.location.f.getServiceContext() != null) {
            a(com.baidu.location.f.getServiceContext());
        }
    }

    public static b a() {
        if (j == null) {
            j = new b();
        }
        return j;
    }

    public String a(boolean z) {
        return a(z, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(boolean z, String str) {
        String c2;
        String str2;
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.93f);
        if (z) {
            if (k.f6768g.equals("all")) {
                stringBuffer.append("&addr=allj");
            }
            if (k.f6770i) {
                stringBuffer.append("&adtp=n2");
            }
            if (k.f6769h || k.k || k.l || k.j) {
                stringBuffer.append("&sema=");
                if (k.f6769h) {
                    stringBuffer.append("aptag|");
                }
                if (k.j) {
                    stringBuffer.append("aptagd|");
                }
                if (k.k) {
                    stringBuffer.append("poiregion|");
                }
                if (k.l) {
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
            String j2 = com.baidu.location.c.e.j();
            if (j2 != null) {
                stringBuffer.append(j2);
            }
        }
        if (this.f6726c != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.f6726c);
            String str3 = this.f6724a;
            str2 = (str3 == null || str3.equals("NULL") || this.f6726c.contains(new StringBuffer(this.f6724a).reverse().toString())) ? "&Aim=" : "&Aim=";
            if (this.f6725b != null) {
                stringBuffer.append("&snd=");
                stringBuffer.append(this.f6725b);
            }
            if (this.f6727d != null) {
                stringBuffer.append("&Aid=");
                stringBuffer.append(this.f6727d);
            }
            stringBuffer.append("&fw=");
            stringBuffer.append(com.baidu.location.f.getFrameVersion());
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            c2 = k.c();
            if (c2 != null) {
                stringBuffer.append("&laip=");
                stringBuffer.append(c2);
            }
            stringBuffer.append("&resid=");
            stringBuffer.append("12");
            stringBuffer.append("&os=A");
            stringBuffer.append(Build.VERSION.SDK_INT);
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
        stringBuffer.append(this.f6724a);
        if (this.f6725b != null) {
        }
        if (this.f6727d != null) {
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(com.baidu.location.f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        c2 = k.c();
        if (c2 != null) {
        }
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK_INT);
        if (z) {
        }
        return stringBuffer.toString();
    }

    public void a(Context context) {
        if (context == null || this.k) {
            return;
        }
        try {
            this.f6726c = CommonParam.getCUID(context);
        } catch (Exception unused) {
            this.f6726c = null;
        }
        try {
            f6719e = context.getPackageName();
        } catch (Exception unused2) {
            f6719e = null;
        }
        k.o = "" + this.f6726c;
        this.k = true;
    }

    public void a(String str, String str2) {
        f6720f = str;
        f6719e = str2;
    }
}
