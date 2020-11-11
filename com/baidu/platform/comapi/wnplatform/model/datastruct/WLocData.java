package com.baidu.platform.comapi.wnplatform.model.datastruct;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WLocData implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f3133a;
    public float accuracy;
    public double altitude;
    private int b;
    private int c;
    public int coordType;
    private String d;
    public float direction;
    public int indoorState;
    public boolean isIndoorMode;
    public String networkLocType;
    public float speed;
    public double latitude = -1.0d;
    public double longitude = -1.0d;
    public String buildingId = "";
    public String floorId = "";

    public int getLocType() {
        return this.isIndoorMode ? 2 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public WLocData m31clone() {
        WLocData wLocData = new WLocData();
        synchronized (this) {
            wLocData.accuracy = this.accuracy;
            wLocData.direction = this.direction;
            wLocData.latitude = this.latitude;
            wLocData.longitude = this.longitude;
            wLocData.f3133a = this.f3133a;
            wLocData.speed = this.speed;
            wLocData.altitude = this.altitude;
            wLocData.coordType = this.coordType;
            wLocData.buildingId = this.buildingId;
            if (this.floorId != null && !this.floorId.isEmpty()) {
                wLocData.floorId = this.floorId.toUpperCase();
            } else {
                wLocData.floorId = this.floorId;
            }
            wLocData.networkLocType = this.networkLocType;
            wLocData.b = this.b;
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
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_DIR, new BigDecimal(this.direction).setScale(2, RoundingMode.UP));
            jSONObject.put("acc", new BigDecimal(this.accuracy).setScale(2, RoundingMode.UP));
            jSONObject.put("alt", new BigDecimal(this.altitude).setScale(1, RoundingMode.UP));
            jSONObject.put("bui", this.buildingId);
            jSONObject.put("floor", this.floorId);
            jSONObject.put("locType", getLocType());
            jSONObject.put("timestamp", this.c);
            jSONObject.put("tag", this.d);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
