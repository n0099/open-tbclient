package com.baidu.searchbox.http;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.n4a;
@Autowired
/* loaded from: classes3.dex */
public class HttpRuntime {
    @Inject(force = false)
    public static IHttpContext getHttpContext() {
        return n4a.a();
    }
}
