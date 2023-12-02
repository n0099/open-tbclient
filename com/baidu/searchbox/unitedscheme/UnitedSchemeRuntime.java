package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.rf1;
import com.baidu.tieba.tf1;
/* loaded from: classes4.dex */
public class UnitedSchemeRuntime {
    @Inject(force = false)
    public tf1<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsSubDispatchersList() {
        rf1 b = rf1.b();
        this.sSubDispatchersList = b;
        b.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }

    public UnitedSchemeRuntime() {
        initsSubDispatchersList();
    }
}
