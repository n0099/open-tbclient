package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider;
import d.a.c0.a.b.b;
import d.a.c0.a.b.d;
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
        b b2 = b.b();
        this.sInterceptChainList = b2;
        b2.a(new UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider());
    }

    public void initsSubDispatchersList() {
        b b2 = b.b();
        this.sSubDispatchersList = b2;
        b2.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }
}
