package com.baidu.searchbox.http;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.a69;
@Autowired
/* loaded from: classes2.dex */
public class HttpRuntime {
    @Inject(force = false)
    public static IHttpContext getHttpContext() {
        return a69.a();
    }
}
