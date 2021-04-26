package com.baidu.mapapi.cloud;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudRgcResult {
    public AddressCompents addressCompents;
    public String customLocationDescription;
    public List<CloudPoiInfo> customPois;
    public String formattedAddress;
    public LatLng location;
    public String message;
    public List<PoiInfo> pois;
    public String recommendedLocationDescription;
    public int status;

    /* loaded from: classes2.dex */
    public class AddressCompents {
        public int adminAreaCode;
        public String city;
        public String country;
        public String countryCode;
        public String district;
        public String province;
        public String street;
        public String streetNumber;

        public AddressCompents() {
        }

        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                this.country = jSONObject.optString("country");
                this.province = jSONObject.optString("province");
                this.city = jSONObject.optString("city");
                this.district = jSONObject.optString("district");
                this.street = jSONObject.optString("street");
                this.streetNumber = jSONObject.optString("street_number");
                this.adminAreaCode = jSONObject.optInt("admin_area_code");
                this.countryCode = jSONObject.optString("country_code");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class PoiInfo {
        public String address;
        public String direction;
        public int distance;
        public LatLng location;
        public String name;
        public String tag;
        public String uid;

        public PoiInfo() {
        }

        public void parseFromJSON(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                this.name = jSONObject.optString("name");
                this.uid = jSONObject.optString("id");
                this.address = jSONObject.optString("address");
                this.tag = jSONObject.optString("tag");
                JSONObject optJSONObject = jSONObject.optJSONObject("location");
                if (optJSONObject != null) {
                    this.location = new LatLng(optJSONObject.optDouble(SuggestAddrField.KEY_LAT), optJSONObject.optDouble(SuggestAddrField.KEY_LNG));
                    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                        this.location = CoordTrans.baiduToGcj(this.location);
                    }
                }
                this.direction = jSONObject.optString("direction");
                this.distance = jSONObject.optInt("distance");
            }
        }
    }

    public void parseFromJSON(JSONObject jSONObject) throws JSONException {
        try {
            this.status = jSONObject.optInt("status");
            this.message = jSONObject.optString("message");
            if (this.status == 6 || this.status == 7 || this.status == 8 || this.status == 9) {
                this.status = 1;
            }
            if (this.status != 0) {
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("location");
            if (optJSONObject != null) {
                this.location = new LatLng(optJSONObject.optDouble(SuggestAddrField.KEY_LAT), optJSONObject.optDouble(SuggestAddrField.KEY_LNG));
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    this.location = CoordTrans.baiduToGcj(this.location);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("address_component");
            if (optJSONObject2 != null) {
                AddressCompents addressCompents = new AddressCompents();
                this.addressCompents = addressCompents;
                addressCompents.a(optJSONObject2);
            }
            this.formattedAddress = jSONObject.optString("formatted_address");
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray != null) {
                this.pois = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        PoiInfo poiInfo = new PoiInfo();
                        poiInfo.parseFromJSON(optJSONObject3);
                        this.pois.add(poiInfo);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("custom_pois");
            if (optJSONArray2 != null) {
                this.customPois = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject4 != null) {
                        CloudPoiInfo cloudPoiInfo = new CloudPoiInfo();
                        cloudPoiInfo.b(optJSONObject4);
                        this.customPois.add(cloudPoiInfo);
                    }
                }
            }
            this.customLocationDescription = jSONObject.optString("custom_location_description");
            this.recommendedLocationDescription = jSONObject.optString("recommended_location_description");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
