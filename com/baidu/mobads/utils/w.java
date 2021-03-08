package com.baidu.mobads.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
class w extends com.baidu.mobads.f.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2497a;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, Context context) {
        this.c = tVar;
        this.f2497a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (r1.length() <= 0) goto L10;
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
            if (str2 == null && this.f2497a != null) {
                h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
                String unused = t.j = this.f2497a.getSharedPreferences("__x_adsdk_agent_header__", 0).getString("guid", "");
                str3 = t.j;
                if (str3 != null) {
                    str8 = t.j;
                }
                String unused2 = t.j = commonUtils.md5(this.c.getMacAddress(this.f2497a) + ETAG.ITEM_SEPARATOR + this.c.getIMEI(this.f2497a) + ETAG.ITEM_SEPARATOR + ETAG.ITEM_SEPARATOR);
                str4 = t.j;
                if (str4 != null) {
                    str6 = t.j;
                    if (str6.length() > 0) {
                        SharedPreferences.Editor edit = this.f2497a.getSharedPreferences("__x_adsdk_agent_header__", 0).edit();
                        str7 = t.j;
                        edit.putString("guid", str7).commit();
                    }
                }
                String unused3 = t.j = "";
                str5 = t.j;
                return str5;
            }
        } catch (Throwable th) {
            String unused4 = t.j = "";
        }
        str = t.j;
        return str;
    }
}
