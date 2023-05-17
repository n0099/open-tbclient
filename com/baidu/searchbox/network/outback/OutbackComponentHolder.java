package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.uj1;
import com.baidu.tieba.wj1;
/* loaded from: classes3.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public wj1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        uj1 b = uj1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
