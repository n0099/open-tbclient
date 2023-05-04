package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ji9;
@Autowired
/* loaded from: classes2.dex */
public class BaiduIdentityRuntime {
    @Inject
    public static IBaiduIdentityContext getBaiduIdentityContext() {
        return ji9.a();
    }
}
