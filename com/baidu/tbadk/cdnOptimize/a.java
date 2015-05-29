package com.baidu.tbadk.cdnOptimize;

import com.baidu.location.LocationClientOption;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int NT = 300;
    public int NU = 5000;
    public int NV = 10000;
    public int NW = 1500;
    public int NX = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    public int NY = 6000;
    public boolean NZ = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.NT = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.NU = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.NV = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.NW = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.NX = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.NY = optInt6;
                }
                this.NZ = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
