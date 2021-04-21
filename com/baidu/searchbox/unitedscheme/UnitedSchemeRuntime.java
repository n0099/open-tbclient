package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider;
import d.b.c0.a.b.b;
import d.b.c0.a.b.d;
/* loaded from: classes2.dex */
public class UnitedSchemeRuntime {
    @Inject(force = false)
    public d<UnitedSchemeBaseInterceptor> sInterceptChainList;
    @Inject(force = false)
    public d<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public UnitedSchemeRuntime() {
        initsInterceptChainList();
        initsSubDispatchersList();
    }

    public void initsInterceptChainList() {
        b c2 = b.c();
        this.sInterceptChainList = c2;
        c2.b(new UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider());
    }

    public void initsSubDispatchersList() {
        b c2 = b.c();
        this.sSubDispatchersList = c2;
        c2.b(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }
}
