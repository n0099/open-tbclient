package com.baidu.mapapi.cloud;

import com.baidu.mapapi.http.HttpClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class LocalSearchInfo extends BaseCloudSearchInfo {
    public String region;

    public LocalSearchInfo() {
        this.f7027a = HttpClient.isHttpsEnable ? "https://api.map.baidu.com/geosearch/v2/local" : "http://api.map.baidu.com/geosearch/v2/local";
    }

    @Override // com.baidu.mapapi.cloud.BaseCloudSearchInfo, com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (super.a() != null) {
            sb.append(super.a());
            String str = this.region;
            if (str != null && !str.equals("") && this.region.length() <= 25) {
                sb.append("&");
                sb.append("region");
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(this.region, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                return sb.toString();
            }
        }
        return null;
    }
}
