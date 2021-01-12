package com.baidu.live.tbadk.location;

import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LocationInfo {
    public String city;
    public String cityCode;
    public String county;
    public double latitude;
    public double longitude;
    public String prov;
    public String street;

    public void parserJsonStr(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    this.prov = jSONObject.optString("prov");
                    this.city = jSONObject.optString("city");
                    this.county = jSONObject.optString("county");
                    this.cityCode = jSONObject.optString("city-code");
                    this.street = jSONObject.optString("street");
                    this.latitude = jSONObject.optDouble("latitude");
                    this.longitude = jSONObject.optDouble("longitude");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getCurCityName() {
        if (!StringUtils.isNull(this.city)) {
            return this.city;
        }
        if (StringUtils.isNull(this.prov)) {
            return "";
        }
        return this.prov;
    }
}
