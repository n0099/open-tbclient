package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.aj1;
import com.baidu.tieba.cj1;
/* loaded from: classes2.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public cj1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        aj1 b = aj1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
