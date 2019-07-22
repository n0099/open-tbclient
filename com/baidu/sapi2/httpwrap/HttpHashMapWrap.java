package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes.dex */
public class HttpHashMapWrap extends HttpHashMap {
    public HttpHashMapWrap() {
        putAll(Utils.buildCommonParams());
    }

    @Override // com.baidu.pass.http.HttpHashMap
    public void doSign(String str) {
        put("sig", SapiUtils.calculateSig(getMap(), str));
    }
}
