package com.baidu.platform.core.e;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
/* loaded from: classes5.dex */
public class c extends com.baidu.platform.base.e {
    public c(PoiDetailShareURLOption poiDetailShareURLOption) {
        a(poiDetailShareURLOption);
    }

    private void a(PoiDetailShareURLOption poiDetailShareURLOption) {
        this.a.a("url", ("http://wapmap.baidu.com/s?tn=Detail&pid=" + poiDetailShareURLOption.mUid + "&smsf=3") + HttpClient.getPhoneInfo());
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.p();
    }
}
