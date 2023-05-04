package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ej1;
import com.baidu.tieba.gj1;
/* loaded from: classes2.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public gj1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        ej1 b = ej1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
