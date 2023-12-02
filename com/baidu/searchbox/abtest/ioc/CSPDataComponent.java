package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.qf1;
import com.baidu.tieba.sf1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public sf1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        qf1 b = qf1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
