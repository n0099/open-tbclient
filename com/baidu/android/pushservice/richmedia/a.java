package com.baidu.android.pushservice.richmedia;

import com.baidu.browser.core.util.BdUtil;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    DefaultHttpClient f604a;
    private l b = l.a(a.class.getName());

    public a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, BdUtil.UTF8);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
        this.f604a = new DefaultHttpClient(basicHttpParams);
        this.f604a.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(3, false));
    }

    public HttpResponse a(String str, String str2, Map map, List list) {
        HttpPost httpPost;
        if (str.equals("GET")) {
            httpPost = new HttpGet(str2);
        } else {
            HttpPost httpPost2 = new HttpPost(str2);
            if (list != null && list.size() > 0) {
                httpPost2.setEntity(new UrlEncodedFormEntity(list, BdUtil.UTF8));
            }
            httpPost = httpPost2;
        }
        this.b.b("url:" + str2);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                httpPost.setHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return this.f604a.execute(httpPost);
    }
}
