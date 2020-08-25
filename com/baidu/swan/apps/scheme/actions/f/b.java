package com.baidu.swan.apps.scheme.actions.f;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "LocationResult";
    public final double altitude;
    public final double cTB;
    public final double cTC = 0.0d;
    public final double cTD;
    public final String city;
    public final String cityCode;
    public final String coorType;
    public final String country;
    public final String countryCode;
    public final String district;
    public final double latitude;
    public final double longitude;
    public final String province;
    public final float speed;
    public final String street;
    public final String streetNumber;

    public b(String str, double d, double d2, float f, double d3, double d4, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.coorType = str;
        this.longitude = d;
        this.latitude = d2;
        this.speed = f;
        this.cTB = d3;
        this.altitude = d4;
        this.cTD = d3;
        this.country = str2;
        this.countryCode = str3;
        this.city = str4;
        this.cityCode = str5;
        this.province = str6;
        this.district = str7;
        this.street = str8;
        this.streetNumber = str9;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("longitude", this.longitude);
            jSONObject.put("latitude", this.latitude);
            jSONObject.put("speed", this.speed);
            jSONObject.put("accuracy", this.cTB);
            jSONObject.put("altitude", this.altitude);
            jSONObject.put("verticalAccuracy", this.cTC);
            jSONObject.put("horizontalAccuracy", this.cTD);
            jSONObject.put("country", this.country);
            jSONObject.put("countryCode", this.countryCode);
            jSONObject.put("city", this.city);
            jSONObject.put("cityCode", this.cityCode);
            jSONObject.put("province", this.province);
            jSONObject.put("district", this.district);
            jSONObject.put("street", this.street);
            jSONObject.put("streetNumber", this.streetNumber);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "toJSON error: " + Log.getStackTraceString(e));
            }
        }
        return jSONObject;
    }
}
