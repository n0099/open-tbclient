package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.mk1;
import com.baidu.tieba.ok1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public ok1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        mk1 b = mk1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
