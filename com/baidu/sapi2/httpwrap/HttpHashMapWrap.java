package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.Map;
/* loaded from: classes19.dex */
public class HttpHashMapWrap extends HttpHashMap {
    public HttpHashMapWrap() {
        putAll(Utils.a());
    }

    @Override // com.baidu.pass.http.HttpHashMap
    public void doSign(String str) {
        Map map = getMap();
        if (map == null || map.containsKey("sig")) {
            return;
        }
        put("sig", SapiUtils.calculateSig(getMap(), str));
    }
}
