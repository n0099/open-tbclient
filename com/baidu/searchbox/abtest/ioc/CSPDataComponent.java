package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.al1;
import com.baidu.tieba.cl1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public cl1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        al1 b = al1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
