package com.baidu.mobads.utils;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class w extends com.baidu.mobads.f.a<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8576a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f8577c;

    public w(t tVar, Context context) {
        this.f8577c = tVar;
        this.f8576a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (r5.length() <= 0) goto L11;
     */
    @Override // com.baidu.mobads.f.a
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            str2 = t.j;
            if (str2 == null && this.f8576a != null) {
                h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
                String unused = t.j = this.f8576a.getSharedPreferences("__x_adsdk_agent_header__", 0).getString("guid", "");
                str3 = t.j;
                if (str3 != null) {
                    str8 = t.j;
                }
                String unused2 = t.j = commonUtils.md5(this.f8577c.getMacAddress(this.f8576a) + "&" + this.f8577c.getIMEI(this.f8576a) + "&&");
                str4 = t.j;
                if (str4 != null) {
                    str6 = t.j;
                    if (str6.length() > 0) {
                        SharedPreferences.Editor edit = this.f8576a.getSharedPreferences("__x_adsdk_agent_header__", 0).edit();
                        str7 = t.j;
                        edit.putString("guid", str7).commit();
                    }
                }
                String unused3 = t.j = "";
                str5 = t.j;
                return str5;
            }
        } catch (Throwable unused4) {
            String unused5 = t.j = "";
        }
        str = t.j;
        return str;
    }
}
