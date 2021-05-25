package com.baidu.location.e;

import android.content.Context;
import android.os.Build;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static String f6676e;

    /* renamed from: f  reason: collision with root package name */
    public static String f6677f;

    /* renamed from: g  reason: collision with root package name */
    public static String f6678g;

    /* renamed from: h  reason: collision with root package name */
    public static String f6679h;

    /* renamed from: i  reason: collision with root package name */
    public static int f6680i;
    public static b j;

    /* renamed from: a  reason: collision with root package name */
    public String f6681a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f6682b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f6683c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f6684d = null;
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
            if (k.f6725g.equals("all")) {
                stringBuffer.append("&addr=allj");
            }
            if (k.f6727i) {
                stringBuffer.append("&adtp=n2");
            }
            if (k.f6726h || k.k || k.l || k.j) {
                stringBuffer.append("&sema=");
                if (k.f6726h) {
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
        if (this.f6683c != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.f6683c);
            String str3 = this.f6681a;
            str2 = (str3 == null || str3.equals("NULL") || this.f6683c.contains(new StringBuffer(this.f6681a).reverse().toString())) ? "&Aim=" : "&Aim=";
            if (this.f6682b != null) {
                stringBuffer.append("&snd=");
                stringBuffer.append(this.f6682b);
            }
            if (this.f6684d != null) {
                stringBuffer.append("&Aid=");
                stringBuffer.append(this.f6684d);
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
            stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
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
        stringBuffer.append(this.f6681a);
        if (this.f6682b != null) {
        }
        if (this.f6684d != null) {
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
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
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
            this.f6683c = CommonParam.getCUID(context);
        } catch (Exception unused) {
            this.f6683c = null;
        }
        try {
            f6676e = context.getPackageName();
        } catch (Exception unused2) {
            f6676e = null;
        }
        k.o = "" + this.f6683c;
        this.k = true;
    }

    public void a(String str, String str2) {
        f6677f = str;
        f6676e = str2;
    }
}
