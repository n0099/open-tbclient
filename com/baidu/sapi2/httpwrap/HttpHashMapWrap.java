package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.SapiUtils;
import com.fun.ad.sdk.FunAdSdk;
import java.util.Map;
/* loaded from: classes3.dex */
public class HttpHashMapWrap extends HttpHashMap implements NoProguard {
    public HttpHashMapWrap() {
        putAll(Utils.buildCommonParams());
    }

    @Override // com.baidu.pass.http.HttpHashMap
    public void doSign(String str) {
        Map map = getMap();
        if (map != null && !map.containsKey(FunAdSdk.PLATFORM_SIG)) {
            put(FunAdSdk.PLATFORM_SIG, SapiUtils.calculateSig(getMap(), str));
        }
    }
}
