package com.baidu.searchbox.download.center.clearcache;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ex6;
@Autowired
/* loaded from: classes3.dex */
public class ClearCacheRuntime {
    @Inject
    public static IClearCacheContext getClearCacheContext() {
        return ex6.a();
    }
}
