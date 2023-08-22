package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.jk1;
import com.baidu.tieba.lk1;
/* loaded from: classes4.dex */
public class UnitedSchemeRuntime {
    @Inject(force = false)
    public lk1<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsSubDispatchersList() {
        jk1 b = jk1.b();
        this.sSubDispatchersList = b;
        b.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }

    public UnitedSchemeRuntime() {
        initsSubDispatchersList();
    }
}
