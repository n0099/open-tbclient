package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.dl1;
import com.baidu.tieba.fl1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public fl1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        dl1 b = dl1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
