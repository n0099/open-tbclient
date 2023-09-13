package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.nk1;
import com.baidu.tieba.pk1;
/* loaded from: classes4.dex */
public class UnitedSchemeRuntime {
    @Inject(force = false)
    public pk1<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsSubDispatchersList() {
        nk1 b = nk1.b();
        this.sSubDispatchersList = b;
        b.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }

    public UnitedSchemeRuntime() {
        initsSubDispatchersList();
    }
}
