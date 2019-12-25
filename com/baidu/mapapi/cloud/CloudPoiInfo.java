package com.baidu.mapapi.cloud;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.sapi2.activity.SlideActiviy;
import com.coloros.mcssdk.mode.CommandMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CloudPoiInfo {
    public String address;
    public String city;
    public String direction;
    public int distance;
    public String district;
    public Map<String, Object> extras;
    public int geotableId;
    public double latitude;
    public double longitude;
    public String poiId;
    public String province;
    public String tags;
    public String title;
    public int uid;
    public int weight;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        this.uid = jSONObject.optInt("uid");
        this.poiId = jSONObject.optString("uid");
        jSONObject.remove("uid");
        this.geotableId = jSONObject.optInt("geotable_id");
        jSONObject.remove("geotable_id");
        this.title = jSONObject.optString("title");
        jSONObject.remove("title");
        this.address = jSONObject.optString(SlideActiviy.ADDRESS_PAGE_NAME);
        jSONObject.remove(SlideActiviy.ADDRESS_PAGE_NAME);
        this.province = jSONObject.optString("province");
        jSONObject.remove("province");
        this.city = jSONObject.optString("city");
        jSONObject.remove("city");
        this.district = jSONObject.optString("district");
        jSONObject.remove("district");
        JSONArray optJSONArray = jSONObject.optJSONArray("location");
        if (optJSONArray != null) {
            this.longitude = optJSONArray.optDouble(0);
            this.latitude = optJSONArray.optDouble(1);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                LatLng baiduToGcj = CoordTrans.baiduToGcj(new LatLng(this.latitude, this.longitude));
                this.longitude = baiduToGcj.longitude;
                this.latitude = baiduToGcj.latitude;
            }
        }
        jSONObject.remove("location");
        this.tags = jSONObject.optString(CommandMessage.TYPE_TAGS);
        jSONObject.remove(CommandMessage.TYPE_TAGS);
        this.distance = jSONObject.optInt("distance");
        jSONObject.remove("distance");
        this.weight = jSONObject.optInt(TableDefine.SessionColumns.COLUMN_WEIGHT);
        jSONObject.remove(TableDefine.SessionColumns.COLUMN_WEIGHT);
        this.extras = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.extras.put(next, jSONObject.opt(next));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        this.title = jSONObject.optString("name");
        this.address = jSONObject.optString(SlideActiviy.ADDRESS_PAGE_NAME);
        this.tags = jSONObject.optString("tag");
        JSONObject optJSONObject = jSONObject.optJSONObject("location");
        if (optJSONObject != null) {
            this.longitude = optJSONObject.optDouble("lng");
            this.latitude = optJSONObject.optDouble("lat");
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                LatLng baiduToGcj = CoordTrans.baiduToGcj(new LatLng(this.latitude, this.longitude));
                this.longitude = baiduToGcj.longitude;
                this.latitude = baiduToGcj.latitude;
            }
        }
        this.direction = jSONObject.optString("direction");
        this.distance = jSONObject.optInt("distance");
    }
}
