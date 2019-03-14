package com.baidu.mapapi.cloud;

import android.net.http.Headers;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class NearbySearchInfo extends BaseCloudSearchInfo {
    public String location;
    public int radius;

    public NearbySearchInfo() {
        if (HttpClient.isHttpsEnable) {
            this.a = "https://api.map.baidu.com/geosearch/v2/nearby";
        } else {
            this.a = "http://api.map.baidu.com/geosearch/v2/nearby";
        }
        this.radius = 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.cloud.BaseCloudSearchInfo, com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (super.a() != null) {
            sb.append(super.a());
            if (this.location == null || this.location.equals("")) {
                return null;
            }
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                String[] split = this.location.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                try {
                    LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    this.location = gcjToBaidu.longitude + Constants.ACCEPT_TIME_SEPARATOR_SP + gcjToBaidu.latitude;
                } catch (Exception e) {
                }
            }
            sb.append("&");
            sb.append(Headers.LOCATION);
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
        return null;
    }
}
