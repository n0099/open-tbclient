package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.hl1;
import com.baidu.tieba.jl1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public jl1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        hl1 b = hl1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
