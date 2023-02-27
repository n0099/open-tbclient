package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.kk1;
import com.baidu.tieba.mk1;
/* loaded from: classes2.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public mk1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        kk1 b = kk1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
