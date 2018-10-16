package com.baidu.searchbox.ng.ai.apps.scheme.actions.location;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LocationResult {
    public static final String COOR_TYPE_BD = "bd09ll";
    public static final String COOR_TYPE_BDMKT = "bd09";
    public static final String COOR_TYPE_GCJ = "gcj02";
    public static final String COOR_TYPE_WGS84 = "wgs84";
    public static final String GCJ02_TO_WGS84 = "gcj2wgs";
    private static final double NO_SUPPORT_V_ACCURACY_VALUE = 0.0d;
    public final double accuracy;
    public final double altitude;
    public final String city;
    public final String cityCode;
    public final String coorType;
    public final String country;
    public final String countryCode;
    public final String district;
    public final double horizontalAccuracy;
    public final double latitude;
    public final double longitude;
    public final String province;
    public final float speed;
    public final String street;
    public final String streetNumber;
    public final double verticalAccuracy = 0.0d;
    private static boolean DEBUG = false;
    private static String TAG = LocationResult.class.getSimpleName();

    public LocationResult(String str, double d, double d2, float f, double d3, double d4, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.coorType = str;
        this.longitude = d;
        this.latitude = d2;
        this.speed = f;
        this.accuracy = d3;
        this.altitude = d4;
        this.horizontalAccuracy = d3;
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
            jSONObject.put("coorType", this.coorType);
            jSONObject.put("longitude", this.longitude);
            jSONObject.put("latitude", this.latitude);
            jSONObject.put("speed", this.speed);
            jSONObject.put("accuracy", this.accuracy);
            jSONObject.put("altitude", this.altitude);
            jSONObject.put("verticalAccuracy", this.verticalAccuracy);
            jSONObject.put("horizontalAccuracy", this.horizontalAccuracy);
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
