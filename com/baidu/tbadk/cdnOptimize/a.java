package com.baidu.tbadk.cdnOptimize;

import com.baidu.location.LocationClientOption;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int Sr = 300;
    public int Ss = 5000;
    public int St = 10000;
    public int Su = 1500;
    public int Sv = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public int Sw = 6000;
    public boolean Sx = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.Sr = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.Ss = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.St = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.Su = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.Sv = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.Sw = optInt6;
                }
                this.Sx = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
