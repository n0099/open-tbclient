package com.baidu.location;

import android.hardware.Sensor;
import android.os.Build;
import android.telephony.TelephonyManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a2 implements a0, n {
    String jf;
    private Sensor ji;
    String jj;
    private static a2 jk = null;
    public static String jc = null;
    public static String jg = null;
    String jh = null;
    int je = -1;
    int jd = -1;

    private a2() {
        this.jf = null;
        this.jj = null;
        try {
            this.jf = ((TelephonyManager) f.getServiceContext().getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            this.jf = "NULL";
        }
        try {
            this.jj = com.baidu.location.a.a.a.m65if(f.getServiceContext());
        } catch (Exception e2) {
            this.jj = null;
        }
        try {
            jc = f.getServiceContext().getPackageName();
        } catch (Exception e3) {
            jc = null;
        }
    }

    public static a2 cC() {
        if (jk == null) {
            jk = new a2();
        }
        return jk;
    }

    public String cA() {
        return this.jj != null ? "v5.01|" + this.jj + "|" + Build.MODEL : "v5.01" + this.jf + "|" + Build.MODEL;
    }

    public String cB() {
        return "&sdk=5.01" + cD();
    }

    public String cD() {
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.jj != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.jj);
        } else {
            stringBuffer.append("&im=");
            stringBuffer.append(this.jf);
        }
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception e) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(jc);
        } catch (Exception e2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(5.01f);
        return stringBuffer.toString();
    }

    /* renamed from: char  reason: not valid java name */
    public String m78char(boolean z) {
        return m79if(z, null);
    }

    public String cz() {
        return jc != null ? cA() + "|" + jc : cA();
    }

    /* renamed from: if  reason: not valid java name */
    public String m79if(boolean z, String str) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(5.01f);
        if (z && c.aF.equals("all")) {
            stringBuffer.append("&addr=all");
        }
        if (z) {
            if (str == null) {
                stringBuffer.append("&coor=gcj02");
            } else {
                stringBuffer.append("&coor=");
                stringBuffer.append(str);
            }
        }
        if (this.jj == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.jf);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.jj);
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
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

    public String t(String str) {
        return m79if(true, str);
    }

    /* renamed from: try  reason: not valid java name */
    public void m80try(String str, String str2) {
        jg = str;
        jc = str2;
    }
}
