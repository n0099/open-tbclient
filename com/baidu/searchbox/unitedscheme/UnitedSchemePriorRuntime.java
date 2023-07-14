package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider;
import com.baidu.tieba.bl1;
import com.baidu.tieba.dl1;
/* loaded from: classes4.dex */
public class UnitedSchemePriorRuntime {
    @Inject(force = false)
    public dl1<UnitedSchemeBaseInterceptor> sInterceptChainList;
    @Inject(force = false)
    public dl1<UnitedSchemeBasePriorDispatcher> sPriorSubDispatchersList;

    public void initsInterceptChainList() {
        bl1 b = bl1.b();
        this.sInterceptChainList = b;
        b.a(new UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider());
    }

    public void initsPriorSubDispatchersList() {
        bl1 b = bl1.b();
        this.sPriorSubDispatchersList = b;
        b.a(new UnitedSchemeBasePriorDispatcher_UnitedSchemePriorRuntime_ListProvider());
    }

    public UnitedSchemePriorRuntime() {
        initsInterceptChainList();
        initsPriorSubDispatchersList();
    }
}
