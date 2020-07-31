package com.baidu.live.data;

import com.baidu.live.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLocationData implements Serializable {
    public static final String LOCATION_DATA = "location_data";
    public String location = "";
    public String lng = "";
    public String lat = "";
    public double distance = 0.0d;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.location = jSONObject.optString("location");
                this.lng = jSONObject.optString("lng");
                this.lat = jSONObject.optString("lat");
                this.distance = jSONObject.optLong("distance");
            } catch (Exception e) {
            }
        }
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("location", this.location);
            jSONObject.put("lng", this.lng);
            jSONObject.put("lat", this.lat);
            jSONObject.put("distance", this.distance);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
