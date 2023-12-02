package com.baidu.searchbox.http;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.kpa;
@Autowired
/* loaded from: classes4.dex */
public class HttpRuntime {
    @Inject(force = false)
    public static IHttpContext getHttpContext() {
        return kpa.a();
    }
}
