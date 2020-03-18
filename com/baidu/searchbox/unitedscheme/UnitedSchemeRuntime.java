package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.a.a.a;
import com.baidu.pyramid.a.a.b;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider;
/* loaded from: classes7.dex */
public class UnitedSchemeRuntime {
    b<UnitedSchemeBaseInterceptor> sInterceptChainList;
    b<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsInterceptChainList() {
        this.sInterceptChainList = a.EU();
        this.sInterceptChainList.a(new UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider());
    }

    public void initsSubDispatchersList() {
        this.sSubDispatchersList = a.EU();
        this.sSubDispatchersList.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }

    public UnitedSchemeRuntime() {
        initsInterceptChainList();
        initsSubDispatchersList();
    }
}
