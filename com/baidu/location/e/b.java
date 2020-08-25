package com.baidu.location.e;

import android.content.Context;
import android.os.Build;
import com.baidu.lbsapi.auth.LBSAuthManager;
/* loaded from: classes20.dex */
public class b {
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static String h = null;
    public static int i = 0;
    public static int j = -2;
    public static long k = -1;
    public String a;
    public String b;
    public String c;
    public String d;
    private boolean l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a {
        public static final b a = new b();
    }

    private b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.l = false;
        if (com.baidu.location.f.getServiceContext() != null) {
            a(com.baidu.location.f.getServiceContext());
        }
    }

    public static b a() {
        return a.a;
    }

    public String a(boolean z) {
        return a(z, (String) null);
    }

    public String a(boolean z, String str) {
        String c;
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.02f);
        if (z) {
            if (l.g.equals("all")) {
                stringBuffer.append("&addr=allj2");
            }
            if (l.i) {
                stringBuffer.append("&adtp=n2");
            }
            if (l.h || l.k || l.l || l.j) {
                stringBuffer.append("&sema=");
                if (l.h) {
                    stringBuffer.append("aptag|");
                }
                if (l.j) {
                    stringBuffer.append("aptagd2|");
                }
                if (l.k) {
                    stringBuffer.append("poiregion|");
                }
                if (l.l) {
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
            String l = com.baidu.location.c.f.l();
            if (l != null) {
                stringBuffer.append(l);
            }
        }
        if (this.c == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.c);
            if (this.a != null && !this.a.equals("NULL") && !this.c.contains(new StringBuffer(this.a).reverse().toString())) {
                stringBuffer.append("&Aim=");
                stringBuffer.append(this.a);
            }
        }
        if (this.b != null) {
            stringBuffer.append("&snd=");
            stringBuffer.append(this.b);
        }
        if (this.d != null) {
            stringBuffer.append("&Aid=");
            stringBuffer.append(this.d);
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(com.baidu.location.f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        if (z && (c = l.c()) != null) {
            stringBuffer.append("&laip=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK_INT);
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
        if (context == null || this.l) {
            return;
        }
        try {
            this.c = LBSAuthManager.getInstance(context).getCUID();
        } catch (Exception e2) {
            this.c = null;
        }
        try {
            e = context.getPackageName();
        } catch (Exception e3) {
            e = null;
        }
        l.o = "" + this.c;
        this.l = true;
    }

    public void a(String str, String str2) {
        f = str;
        e = str2;
    }

    public String b() {
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.c != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.c);
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
            stringBuffer.append(e);
        } catch (Exception e3) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.02f);
        return stringBuffer.toString();
    }
}
