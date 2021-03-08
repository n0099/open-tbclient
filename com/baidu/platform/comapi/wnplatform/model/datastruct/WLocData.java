package com.baidu.platform.comapi.wnplatform.model.datastruct;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WLocData implements Cloneable {
    public static final double LOCDEFAULT = -1.0d;
    public float accuracy;
    public double altitude;
    public int coordType;
    public float direction;
    public int indoorState;
    public int isIbeacon;
    public boolean isIndoorMode;
    public String networkLocType;
    public int satellitesNum;
    public float speed;
    public String tag;
    public int timeStamp;
    public double latitude = -1.0d;
    public double longitude = -1.0d;
    public String buildingId = "";
    public String floorId = "";

    public int getLocType() {
        return this.isIndoorMode ? 2 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public WLocData m25clone() {
        WLocData wLocData = new WLocData();
        synchronized (this) {
            wLocData.accuracy = this.accuracy;
            wLocData.direction = this.direction;
            wLocData.latitude = this.latitude;
            wLocData.longitude = this.longitude;
            wLocData.satellitesNum = this.satellitesNum;
            wLocData.speed = this.speed;
            wLocData.altitude = this.altitude;
            wLocData.coordType = this.coordType;
            wLocData.buildingId = this.buildingId;
            wLocData.floorId = this.floorId;
            wLocData.networkLocType = this.networkLocType;
            wLocData.isIbeacon = this.isIbeacon;
            wLocData.isIndoorMode = this.isIndoorMode;
            wLocData.indoorState = this.indoorState;
        }
        return wLocData;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lng", new BigDecimal(this.longitude).setScale(5, RoundingMode.UP));
            jSONObject.put("lat", new BigDecimal(this.latitude).setScale(5, RoundingMode.UP));
            jSONObject.put("speed", new BigDecimal(this.speed).setScale(2, RoundingMode.UP));
            jSONObject.put("dir", new BigDecimal(this.direction).setScale(2, RoundingMode.UP));
            jSONObject.put("acc", new BigDecimal(this.accuracy).setScale(2, RoundingMode.UP));
            jSONObject.put("alt", new BigDecimal(this.altitude).setScale(1, RoundingMode.UP));
            jSONObject.put("bui", this.buildingId);
            jSONObject.put("floor", this.floorId);
            jSONObject.put("locType", getLocType());
            jSONObject.put("timestamp", this.timeStamp);
            jSONObject.put("tag", this.tag);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
