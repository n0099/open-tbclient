package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.dk1;
import com.baidu.tieba.fk1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public fk1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        dk1 b = dk1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
