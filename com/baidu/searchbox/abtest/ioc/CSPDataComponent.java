package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.nf1;
import com.baidu.tieba.pf1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public pf1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        nf1 b = nf1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
