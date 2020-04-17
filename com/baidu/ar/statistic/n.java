package com.baidu.ar.statistic;

import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
final class n extends j implements e {
    @Override // com.baidu.ar.statistic.j
    protected JSONObject a(JSONObject jSONObject, a aVar) {
        return jSONObject;
    }

    @Override // com.baidu.ar.statistic.j
    protected Map<String, Object> f(List<a> list) {
        return null;
    }

    @Override // com.baidu.ar.statistic.j
    protected void f(JSONObject jSONObject) {
    }

    @Override // com.baidu.ar.statistic.j
    protected void g(JSONObject jSONObject) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        String fm = com.baidu.ar.f.q.fm();
        newRequest.setUrl(fm).setMethod("POST").setBody("info=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).addHeader("Content-Type: application/x-www-form-urlencoded");
        newRequest.execute();
    }
}
