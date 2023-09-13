package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.mk1;
import com.baidu.tieba.ok1;
/* loaded from: classes4.dex */
public class OutbackComponentHolder {
    @Inject(force = false)
    public ok1<IOutbackContext> outbackContextHolder;

    public void initoutbackContextHolder() {
        mk1 b = mk1.b();
        this.outbackContextHolder = b;
        b.a(new IOutbackContext_OutbackComponentHolder_Provider());
    }

    public OutbackComponentHolder() {
        initoutbackContextHolder();
    }
}
