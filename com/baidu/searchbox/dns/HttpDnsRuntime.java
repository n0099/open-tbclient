package com.baidu.searchbox.dns;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.pf9;
@Autowired
/* loaded from: classes2.dex */
public class HttpDnsRuntime {
    @Inject(force = true)
    public static IHttpDnsConfig getHttpDnsConfig() {
        return pf9.a();
    }
}
