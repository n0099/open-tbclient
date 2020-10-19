package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import cn.com.chinatelecom.account.api.Helper;
/* loaded from: classes6.dex */
public class j implements g {
    @Override // cn.com.chinatelecom.account.api.c.g
    public String a() {
        return Helper.cepahsul();
    }

    @Override // cn.com.chinatelecom.account.api.c.g
    public String a(Context context, String str, String str2, String str3, long j, String str4) {
        return Helper.dnepah(context, str, str2, str3, j, str4);
    }

    @Override // cn.com.chinatelecom.account.api.c.g
    public String a(Context context, String str, String str2, String str3, String str4, long j, String str5) {
        return Helper.cinetw(context, str, str2, str3, str4, j, str5);
    }

    @Override // cn.com.chinatelecom.account.api.c.g
    public String a(String str, String str2) {
        try {
            return new String(Helper.dnepmret(cn.com.chinatelecom.account.api.a.c.a(str), str2));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    @Override // cn.com.chinatelecom.account.api.c.g
    public String b() {
        return Helper.cemppmul();
    }

    @Override // cn.com.chinatelecom.account.api.c.g
    public String b(Context context, String str, String str2, String str3, long j, String str4) {
        return Helper.dnepmo(context, str, str2, str3, j, str4);
    }

    @Override // cn.com.chinatelecom.account.api.c.g
    public String b(String str, String str2) {
        try {
            return new String(Helper.dnenwret(cn.com.chinatelecom.account.api.a.c.a(str), str2));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    @Override // cn.com.chinatelecom.account.api.c.g
    public String c() {
        return Helper.cemnetwul();
    }
}
