package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.lk1;
import com.baidu.tieba.nk1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public nk1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        lk1 b = lk1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
