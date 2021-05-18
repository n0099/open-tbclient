package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    public String f8631a;

    /* renamed from: b  reason: collision with root package name */
    public String f8632b;

    /* renamed from: c  reason: collision with root package name */
    public String f8633c;

    /* renamed from: d  reason: collision with root package name */
    public long f8634d;

    /* renamed from: e  reason: collision with root package name */
    public long f8635e;

    /* renamed from: f  reason: collision with root package name */
    public float f8636f;

    /* renamed from: g  reason: collision with root package name */
    public float f8637g;

    /* renamed from: h  reason: collision with root package name */
    public float f8638h;

    /* renamed from: i  reason: collision with root package name */
    public float f8639i;
    public String j;
    public boolean k;
    public String l;

    public ao(String str, String str2, String str3, long j, long j2, float f2, float f3, float f4, float f5, String str4, boolean z, String str5) {
        this.f8631a = str;
        this.f8632b = str2;
        this.f8633c = str3;
        this.f8634d = j;
        this.f8635e = j2;
        this.f8636f = f2;
        this.f8637g = f3;
        this.f8638h = f4;
        this.f8639i = f5;
        this.j = str4;
        this.k = z;
        this.l = str5;
    }

    public String a() {
        return this.f8631a;
    }

    public String b() {
        return this.j;
    }

    public JSONObject a(long j, String str, String str2) {
        if (TextUtils.isEmpty(this.l)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", str);
            jSONObject.put("t", this.f8632b);
            jSONObject.put("d", this.f8634d);
            long j2 = this.f8635e - j;
            if (j2 <= 0) {
                j2 = 0;
            }
            jSONObject.put("ps", j2);
            jSONObject.put("at", 1);
            DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator(IStringUtil.EXTENSION_SEPARATOR);
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            jSONObject.put(Config.SESSTION_ACTIVITY_X_VIEW_HEIGHT, decimalFormat.format(this.f8636f));
            jSONObject.put(Config.SESSTION_ACTIVITY_Y_VIEW_HEIGHT, decimalFormat.format(this.f8637g));
            jSONObject.put(Config.SESSTION_ACTIVITY_X_TOTAL_HEIGHT, decimalFormat.format(this.f8638h));
            jSONObject.put(Config.SESSTION_ACTIVITY_Y_TOTAL_HEIGHT, decimalFormat.format(this.f8639i));
            jSONObject.put("h5", 0);
            jSONObject.put("sign", this.l);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
