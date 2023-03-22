package com.baidu.searchbox.pms;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.nl;
@Autowired
/* loaded from: classes2.dex */
public class PmsRuntime {
    @Inject(force = false)
    public static IPmsContext getPmsContext() {
        return nl.a();
    }
}
