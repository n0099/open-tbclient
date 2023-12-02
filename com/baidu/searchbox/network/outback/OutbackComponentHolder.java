package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.qf1;
import com.baidu.tieba.sf1;
/* loaded from: classes4.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public sf1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        qf1 b = qf1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
