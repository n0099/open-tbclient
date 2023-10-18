package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ve1;
import com.baidu.tieba.xe1;
/* loaded from: classes4.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public xe1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        ve1 b = ve1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
