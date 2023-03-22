package com.baidu.searchbox.download.center.clearcache;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.uk6;
@Autowired
/* loaded from: classes2.dex */
public class ClearCacheRuntime {
    @Inject
    public static IClearCacheContext getClearCacheContext() {
        return uk6.a();
    }
}
