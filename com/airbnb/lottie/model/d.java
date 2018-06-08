package com.airbnb.lottie.model;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    @ColorInt
    public int color;
    public String fontName;
    int nj;
    double nk;
    public double nl;
    public boolean nm;
    public int size;
    @ColorInt
    public int strokeColor;
    public int strokeWidth;
    public String text;
    public int tracking;

    d(String str, String str2, int i, int i2, int i3, double d, double d2, @ColorInt int i4, @ColorInt int i5, int i6, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.size = i;
        this.nj = i2;
        this.tracking = i3;
        this.nk = d;
        this.nl = d2;
        this.color = i4;
        this.strokeColor = i5;
        this.strokeWidth = i6;
        this.nm = z;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static d d(JSONObject jSONObject) {
            String optString = jSONObject.optString(Info.kBaiduTimeKey);
            String optString2 = jSONObject.optString("f");
            int optInt = jSONObject.optInt(NotifyType.SOUND);
            int optInt2 = jSONObject.optInt("j");
            int optInt3 = jSONObject.optInt("tr");
            double optDouble = jSONObject.optDouble("lh");
            double optDouble2 = jSONObject.optDouble("ls");
            JSONArray optJSONArray = jSONObject.optJSONArray("fc");
            int argb = Color.argb(255, (int) (optJSONArray.optDouble(0) * 255.0d), (int) (optJSONArray.optDouble(1) * 255.0d), (int) (optJSONArray.optDouble(2) * 255.0d));
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sc");
            int i = 0;
            if (optJSONArray2 != null) {
                i = Color.argb(255, (int) (optJSONArray2.optDouble(0) * 255.0d), (int) (optJSONArray2.optDouble(1) * 255.0d), (int) (optJSONArray2.optDouble(2) * 255.0d));
            }
            return new d(optString, optString2, optInt, optInt2, optInt3, optDouble, optDouble2, argb, i, jSONObject.optInt(TbConfig.SW_APID), jSONObject.optBoolean("of"));
        }
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.nk);
        return (((((((((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size) * 31) + this.nj) * 31) + this.tracking) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
