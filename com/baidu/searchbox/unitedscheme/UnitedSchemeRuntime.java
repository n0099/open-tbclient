package com.baidu.searchbox.unitedscheme;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.bl1;
import com.baidu.tieba.dl1;
/* loaded from: classes4.dex */
public class UnitedSchemeRuntime {
    @Inject(force = false)
    public dl1<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsSubDispatchersList() {
        bl1 b = bl1.b();
        this.sSubDispatchersList = b;
        b.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
    }

    public UnitedSchemeRuntime() {
        initsSubDispatchersList();
    }
}
