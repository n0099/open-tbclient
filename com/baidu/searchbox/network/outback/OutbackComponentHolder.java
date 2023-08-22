package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ik1;
import com.baidu.tieba.kk1;
/* loaded from: classes4.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public kk1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        ik1 b = ik1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
