package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.el1;
import com.baidu.tieba.gl1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public gl1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        el1 b = el1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
