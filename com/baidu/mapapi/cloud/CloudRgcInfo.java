package com.baidu.mapapi.cloud;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes2.dex */
public class CloudRgcInfo {
    public int geoTableId;
    public String location;

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(HttpClient.isHttpsEnable ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/cloudrgc/v1" : "http://api.map.baidu.com/sdkproxy/lbs_androidsdk/cloudrgc/v1");
        sb.append('?');
        String str = this.location;
        if (str != null && !str.equals("")) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                String[] split = this.location.split(",");
                try {
                    LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1])));
                    this.location = gcjToBaidu.latitude + "," + gcjToBaidu.longitude;
                } catch (Exception unused) {
                }
            }
            sb.append("location=" + this.location);
            if (this.geoTableId != 0) {
                sb.append("&geotable_id=" + this.geoTableId);
                sb.append("&coord_type=bd09ll&extensions=pois&from=android_map_sdk");
                return sb.toString();
            }
        }
        return null;
    }
}
