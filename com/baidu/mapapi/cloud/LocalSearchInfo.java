package com.baidu.mapapi.cloud;

import com.baidu.mapapi.http.HttpClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class LocalSearchInfo extends BaseCloudSearchInfo {
    public String region;

    public LocalSearchInfo() {
        if (HttpClient.isHttpsEnable) {
            this.a = "https://api.map.baidu.com/geosearch/v2/local";
        } else {
            this.a = "http://api.map.baidu.com/geosearch/v2/local";
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
            sb.append("&");
            sb.append("region");
            sb.append("=");
            try {
                sb.append(URLEncoder.encode(this.region, HTTP.UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
        return null;
    }
}
