package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.MultipartHashMap;
import com.baidu.sapi2.utils.SapiUtils;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes3.dex */
public class MultipartHashMapWrap extends MultipartHashMap {
    public MultipartHashMapWrap() {
        putAll(Utils.buildCommonParams());
    }

    @Override // com.baidu.pass.http.HttpHashMap
    public void doSign(String str) {
        put(FunAdSdk.PLATFORM_SIG, SapiUtils.calculateSig(getMap(), str));
    }
}
