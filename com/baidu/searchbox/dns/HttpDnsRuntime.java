package com.baidu.searchbox.dns;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.zk9;
@Autowired
/* loaded from: classes3.dex */
public class HttpDnsRuntime {
    @Inject(force = true)
    public static IHttpDnsConfig getHttpDnsConfig() {
        return zk9.a();
    }
}
