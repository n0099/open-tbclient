package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.d8a;
@Autowired
/* loaded from: classes4.dex */
public class BaiduIdentityRuntime {
    @Inject
    public static IBaiduIdentityContext getBaiduIdentityContext() {
        return d8a.a();
    }
}
