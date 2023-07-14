package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.al1;
import com.baidu.tieba.cl1;
/* loaded from: classes4.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public cl1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        al1 b = al1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
