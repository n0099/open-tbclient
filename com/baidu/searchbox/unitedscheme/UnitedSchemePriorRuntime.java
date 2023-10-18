package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider;
import com.baidu.tieba.we1;
import com.baidu.tieba.ye1;
/* loaded from: classes4.dex */
public class UnitedSchemePriorRuntime {
    @Inject(force = false)
    public ye1<UnitedSchemeBaseInterceptor> sInterceptChainList;
    @Inject(force = false)
    public ye1<UnitedSchemeBasePriorDispatcher> sPriorSubDispatchersList;

    public void initsInterceptChainList() {
        we1 b = we1.b();
        this.sInterceptChainList = b;
        b.a(new UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider());
    }

    public void initsPriorSubDispatchersList() {
        we1 b = we1.b();
        this.sPriorSubDispatchersList = b;
        b.a(new UnitedSchemeBasePriorDispatcher_UnitedSchemePriorRuntime_ListProvider());
    }

    public UnitedSchemePriorRuntime() {
        initsInterceptChainList();
        initsPriorSubDispatchersList();
    }
}
