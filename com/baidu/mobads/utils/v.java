package com.baidu.mobads.utils;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes2.dex */
public class v extends com.baidu.mobads.f.a<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8574a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f8575c;

    public v(t tVar, Context context) {
        this.f8575c = tVar;
        this.f8574a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.f.a
    /* renamed from: d */
    public String a() {
        String str;
        try {
            String string = Settings.System.getString(this.f8574a.getContentResolver(), "com.baidu.deviceid");
            if (string != null && !string.equals("")) {
                String string2 = Settings.System.getString(this.f8574a.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string2)) {
                    string2 = "0";
                }
                String stringBuffer = new StringBuffer(string2).reverse().toString();
                String unused = t.f8567e = string + FieldBuilder.SE + stringBuffer;
            }
        } catch (Throwable unused2) {
            String unused3 = t.f8567e = "";
        }
        h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        str = t.f8567e;
        return commonUtils.b(str);
    }
}
