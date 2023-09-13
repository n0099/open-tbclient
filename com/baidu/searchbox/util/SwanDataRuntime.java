package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.uaa;
@Autowired
/* loaded from: classes4.dex */
public class SwanDataRuntime {
    @Inject
    public static ISwanData getISwanData() {
        return uaa.a();
    }
}
