package com.baidu.mapapi.cloud;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class LocalSearchInfo extends BaseCloudSearchInfo {
    public String region;

    public LocalSearchInfo() {
        if (HttpClient.isHttpsEnable) {
            this.f2669a = "https://api.map.baidu.com/geosearch/v2/local";
        } else {
            this.f2669a = "http://api.map.baidu.com/geosearch/v2/local";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.cloud.BaseCloudSearchInfo, com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (super.a() != null) {
            sb.append(super.a());
            if (this.region == null || this.region.equals("") || this.region.length() > 25) {
                return null;
            }
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("region");
            sb.append("=");
            try {
                sb.append(URLEncoder.encode(this.region, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
        return null;
    }
}
