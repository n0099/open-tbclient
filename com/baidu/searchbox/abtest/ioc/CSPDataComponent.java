package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.uj1;
import com.baidu.tieba.wj1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public wj1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        uj1 b = uj1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
