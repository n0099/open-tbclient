package com.baidu.mapapi.cloud;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
/* loaded from: classes2.dex */
public class DetailSearchInfo extends BaseSearchInfo {
    public String poiId;
    public int uid;

    public DetailSearchInfo() {
        this.f6755a = HttpClient.isHttpsEnable ? "https://api.map.baidu.com/geosearch/v2/detail/" : "http://api.map.baidu.com/geosearch/v2/detail/";
    }

    @Override // com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        String str;
        if (this.uid == 0 && ((str = this.poiId) == null || str.equals(""))) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6755a);
        String str2 = this.poiId;
        if (str2 == null || str2.equals("")) {
            sb.append(this.uid);
        } else {
            sb.append(this.poiId);
        }
        sb.append('?');
        String str3 = this.ak;
        if (str3 != null && !str3.equals("") && this.ak.length() <= 50) {
            sb.append(ContentUtil.RESULT_KEY_AK);
            sb.append("=");
            sb.append(this.ak);
            if (this.geoTableId != 0) {
                sb.append("&");
                sb.append("geotable_id");
                sb.append("=");
                sb.append(this.geoTableId);
                String str4 = this.sn;
                if (str4 != null && !str4.equals("") && this.sn.length() <= 50) {
                    sb.append("&");
                    sb.append(IXAdRequestInfo.SN);
                    sb.append("=");
                    sb.append(this.sn);
                }
                return sb.toString();
            }
        }
        return null;
    }
}
