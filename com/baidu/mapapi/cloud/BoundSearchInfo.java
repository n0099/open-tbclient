package com.baidu.mapapi.cloud;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public class BoundSearchInfo extends BaseCloudSearchInfo {
    public String bound;

    public BoundSearchInfo() {
        if (HttpClient.isHttpsEnable) {
            this.f1994a = "https://api.map.baidu.com/geosearch/v2/bound";
        } else {
            this.f1994a = "http://api.map.baidu.com/geosearch/v2/bound";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.cloud.BaseCloudSearchInfo, com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (super.a() != null) {
            sb.append(super.a());
            if (this.bound == null || this.bound.equals("")) {
                return null;
            }
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                try {
                    String[] split = this.bound.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    String[] split2 = split[0].split(",");
                    String[] split3 = split[1].split(",");
                    LatLng latLng = new LatLng(Double.parseDouble(split2[1]), Double.parseDouble(split2[0]));
                    LatLng latLng2 = new LatLng(Double.parseDouble(split3[1]), Double.parseDouble(split3[0]));
                    LatLng gcjToBaidu = CoordTrans.gcjToBaidu(latLng);
                    LatLng gcjToBaidu2 = CoordTrans.gcjToBaidu(latLng2);
                    this.bound = gcjToBaidu.longitude + "," + gcjToBaidu.latitude + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + gcjToBaidu2.longitude + "," + gcjToBaidu2.latitude;
                } catch (Exception e) {
                }
            }
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("bounds");
            sb.append("=");
            sb.append(this.bound);
            return sb.toString();
        }
        return null;
    }
}
