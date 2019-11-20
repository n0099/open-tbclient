package com.baidu.swan.apps.scheme.actions;

import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
/* loaded from: classes2.dex */
public abstract class c<DispatcherT extends UnitedSchemeAbsDispatcher> {
    public final DispatcherT blj;
    public final String name;

    public c(DispatcherT dispatchert, String str) {
        this.blj = dispatchert;
        this.name = str;
    }
}
