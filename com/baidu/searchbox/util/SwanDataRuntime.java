package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.d19;
@Autowired
/* loaded from: classes3.dex */
public class SwanDataRuntime {
    @Inject
    public static ISwanData getISwanData() {
        return d19.a();
    }
}
