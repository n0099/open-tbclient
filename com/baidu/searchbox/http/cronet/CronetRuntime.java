package com.baidu.searchbox.http.cronet;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes3.dex */
public class CronetRuntime {
    @Inject(force = false)
    public static ICronet getCronet() {
        return ICronet.EMPTY;
    }
}
