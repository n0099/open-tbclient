package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ve1;
import com.baidu.tieba.xe1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public xe1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        ve1 b = ve1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
