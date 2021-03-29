package com.baidu.mapapi.cloud;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes2.dex */
public class BoundSearchInfo extends BaseCloudSearchInfo {
    public String bound;

    public BoundSearchInfo() {
        this.f6756a = HttpClient.isHttpsEnable ? "https://api.map.baidu.com/geosearch/v2/bound" : "http://api.map.baidu.com/geosearch/v2/bound";
    }

    @Override // com.baidu.mapapi.cloud.BaseCloudSearchInfo, com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (super.a() != null) {
            sb.append(super.a());
            String str = this.bound;
            if (str != null && !str.equals("")) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    try {
                        String[] split = this.bound.split(";");
                        String[] split2 = split[0].split(",");
                        String[] split3 = split[1].split(",");
                        LatLng latLng = new LatLng(Double.parseDouble(split2[1]), Double.parseDouble(split2[0]));
                        LatLng latLng2 = new LatLng(Double.parseDouble(split3[1]), Double.parseDouble(split3[0]));
                        LatLng gcjToBaidu = CoordTrans.gcjToBaidu(latLng);
                        LatLng gcjToBaidu2 = CoordTrans.gcjToBaidu(latLng2);
                        this.bound = gcjToBaidu.longitude + "," + gcjToBaidu.latitude + ";" + gcjToBaidu2.longitude + "," + gcjToBaidu2.latitude;
                    } catch (Exception unused) {
                    }
                }
                sb.append("&");
                sb.append("bounds");
                sb.append("=");
                sb.append(this.bound);
                return sb.toString();
            }
        }
        return null;
    }
}
