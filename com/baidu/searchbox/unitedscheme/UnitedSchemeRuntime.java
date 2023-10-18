package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.we1;
import com.baidu.tieba.ye1;
/* loaded from: classes4.dex */
public class UnitedSchemeRuntime {
    @Inject(force = false)
    public ye1<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsSubDispatchersList() {
        we1 b = we1.b();
        this.sSubDispatchersList = b;
        b.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }

    public UnitedSchemeRuntime() {
        initsSubDispatchersList();
    }
}
