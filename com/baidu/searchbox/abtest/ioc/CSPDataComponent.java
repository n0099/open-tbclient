package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ik1;
import com.baidu.tieba.kk1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public kk1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        ik1 b = ik1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
