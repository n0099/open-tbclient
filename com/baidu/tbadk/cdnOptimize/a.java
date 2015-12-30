package com.baidu.tbadk.cdnOptimize;

import com.baidu.location.LocationClientOption;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int Tg = 300;
    public int Th = 5000;
    public int Ti = 10000;
    public int Tj = 1500;
    public int Tk = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public int Tl = 6000;
    public boolean Tm = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.Tg = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.Th = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.Ti = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.Tj = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.Tk = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.Tl = optInt6;
                }
                this.Tm = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
