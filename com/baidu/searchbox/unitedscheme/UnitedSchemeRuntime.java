package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider;
import com.baidu.tieba.fj1;
import com.baidu.tieba.hj1;
/* loaded from: classes2.dex */
public class UnitedSchemeRuntime {
    @Inject(force = false)
    public hj1<UnitedSchemeBaseInterceptor> sInterceptChainList;
    @Inject(force = false)
    public hj1<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsInterceptChainList() {
        fj1 b = fj1.b();
        this.sInterceptChainList = b;
        b.a(new UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider());
    }

    public void initsSubDispatchersList() {
        fj1 b = fj1.b();
        this.sSubDispatchersList = b;
        b.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }

    public UnitedSchemeRuntime() {
        initsInterceptChainList();
        initsSubDispatchersList();
    }
}
