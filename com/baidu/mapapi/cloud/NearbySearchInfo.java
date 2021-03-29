package com.baidu.mapapi.cloud;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes2.dex */
public class NearbySearchInfo extends BaseCloudSearchInfo {
    public String location;
    public int radius;

    public NearbySearchInfo() {
        this.f6756a = HttpClient.isHttpsEnable ? "https://api.map.baidu.com/geosearch/v2/nearby" : "http://api.map.baidu.com/geosearch/v2/nearby";
        this.radius = 1000;
    }

    @Override // com.baidu.mapapi.cloud.BaseCloudSearchInfo, com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (super.a() != null) {
            sb.append(super.a());
            String str = this.location;
            if (str != null && !str.equals("")) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    String[] split = this.location.split(",");
                    try {
                        LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                        this.location = gcjToBaidu.longitude + "," + gcjToBaidu.latitude;
                    } catch (Exception unused) {
                    }
                }
                sb.append("&");
                sb.append("location");
                sb.append("=");
                sb.append(this.location);
                if (this.radius >= 0) {
                    sb.append("&");
                    sb.append("radius");
                    sb.append("=");
                    sb.append(this.radius);
                }
                return sb.toString();
            }
        }
        return null;
    }
}
