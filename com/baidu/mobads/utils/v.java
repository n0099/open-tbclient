package com.baidu.mobads.utils;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
/* loaded from: classes5.dex */
class v extends com.baidu.mobads.f.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3511a;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, Context context) {
        this.c = tVar;
        this.f3511a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.f.a
    /* renamed from: d */
    public String a() {
        String str;
        try {
            String string = Settings.System.getString(this.f3511a.getContentResolver(), "com.baidu.deviceid");
            if (string != null && !string.equals("")) {
                String string2 = Settings.System.getString(this.f3511a.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string2)) {
                    string2 = "0";
                }
                String unused = t.e = string + "|" + new StringBuffer(string2).reverse().toString();
            }
        } catch (Throwable th) {
            String unused2 = t.e = "";
        }
        h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        str = t.e;
        return commonUtils.b(str);
    }
}
