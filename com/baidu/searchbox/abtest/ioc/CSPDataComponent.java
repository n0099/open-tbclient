package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.mf1;
import com.baidu.tieba.of1;
/* loaded from: classes3.dex */
public class CSPDataComponent {
    @Inject
    public of1<ICSPDataService> cspServiceHolder;

    public void initcspServiceHolder() {
        mf1 b = mf1.b();
        this.cspServiceHolder = b;
        b.a(new ICSPDataService_CSPDataComponent_Provider());
    }

    public CSPDataComponent() {
        initcspServiceHolder();
    }
}
