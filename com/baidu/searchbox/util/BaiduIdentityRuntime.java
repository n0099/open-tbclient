package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.l59;
@Autowired
/* loaded from: classes2.dex */
public class BaiduIdentityRuntime {
    @Inject
    public static IBaiduIdentityContext getBaiduIdentityContext() {
        return l59.a();
    }
}
