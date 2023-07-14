package com.baidu.searchbox.http;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.s5a;
@Autowired
/* loaded from: classes3.dex */
public class HttpRuntime {
    @Inject(force = false)
    public static IHttpContext getHttpContext() {
        return s5a.a();
    }
}
