package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.cj1;
import com.baidu.tieba.ej1;
/* loaded from: classes2.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public ej1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        cj1 b = cj1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
