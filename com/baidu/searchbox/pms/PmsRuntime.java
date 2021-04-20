package com.baidu.searchbox.pms;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import d.b.c.i.c;
@Autowired
/* loaded from: classes2.dex */
public class PmsRuntime {
    @Inject(force = false)
    public static IPmsContext getPmsContext() {
        return c.a();
    }
}
