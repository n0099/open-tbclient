package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ig9;
@Autowired
/* loaded from: classes2.dex */
public class SwanDataRuntime {
    @Inject
    public static ISwanData getISwanData() {
        return ig9.a();
    }
}
