package com.baidu.mobstat;

import android.text.TextUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private String f3680a;

    /* renamed from: b  reason: collision with root package name */
    private String f3681b;
    private String c;
    private long d;
    private long e;
    private float f;
    private float g;
    private float h;
    private float i;
    private String j;
    private boolean k;
    private String l;

    public ao(String str, String str2, String str3, long j, long j2, float f, float f2, float f3, float f4, String str4, boolean z, String str5) {
        this.f3680a = str;
        this.f3681b = str2;
        this.c = str3;
        this.d = j;
        this.e = j2;
        this.f = f;
        this.g = f2;
        this.h = f3;
        this.i = f4;
        this.j = str4;
        this.k = z;
        this.l = str5;
    }

    public String a() {
        return this.f3680a;
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
            jSONObject.put("t", this.f3681b);
            jSONObject.put("d", this.d);
            long j2 = this.e - j;
            if (j2 <= 0) {
                j2 = 0;
            }
            jSONObject.put("ps", j2);
            jSONObject.put("at", 1);
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            jSONObject.put(Config.SESSTION_ACTIVITY_X_VIEW_HEIGHT, decimalFormat.format(this.f));
            jSONObject.put(Config.SESSTION_ACTIVITY_Y_VIEW_HEIGHT, decimalFormat.format(this.g));
            jSONObject.put(Config.SESSTION_ACTIVITY_X_TOTAL_HEIGHT, decimalFormat.format(this.h));
            jSONObject.put(Config.SESSTION_ACTIVITY_Y_TOTAL_HEIGHT, decimalFormat.format(this.i));
            jSONObject.put("h5", 0);
            jSONObject.put("sign", this.l);
        } catch (Exception e) {
            jSONObject = null;
        }
        return jSONObject;
    }
}
