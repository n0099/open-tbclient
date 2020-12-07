package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.a.a.b;
import com.baidu.pyramid.a.a.d;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider;
/* loaded from: classes20.dex */
public class UnitedSchemeRuntime {
    d<UnitedSchemeBaseInterceptor> sInterceptChainList;
    d<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsInterceptChainList() {
        this.sInterceptChainList = b.afE();
        this.sInterceptChainList.b(new UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider());
    }

    public void initsSubDispatchersList() {
        this.sSubDispatchersList = b.afE();
        this.sSubDispatchersList.b(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }

    public UnitedSchemeRuntime() {
        initsInterceptChainList();
        initsSubDispatchersList();
    }
}
