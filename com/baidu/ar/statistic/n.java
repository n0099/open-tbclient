package com.baidu.ar.statistic;

import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class n extends j implements e {
    @Override // com.baidu.ar.statistic.j
    public JSONObject a(JSONObject jSONObject, a aVar) {
        return jSONObject;
    }

    @Override // com.baidu.ar.statistic.j
    public void g(JSONObject jSONObject) {
    }

    @Override // com.baidu.ar.statistic.j
    public void h(JSONObject jSONObject) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        String gR = s.gR();
        newRequest.setUrl(gR).setMethod("POST").setBody("info=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).addHeader("Content-Type: application/x-www-form-urlencoded");
        newRequest.execute();
    }

    @Override // com.baidu.ar.statistic.j
    public Map<String, Object> i(List<a> list) {
        return null;
    }
}
