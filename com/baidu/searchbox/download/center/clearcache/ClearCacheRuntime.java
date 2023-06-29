package com.baidu.searchbox.download.center.clearcache;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.aw6;
@Autowired
/* loaded from: classes3.dex */
public class ClearCacheRuntime {
    @Inject
    public static IClearCacheContext getClearCacheContext() {
        return aw6.a();
    }
}
