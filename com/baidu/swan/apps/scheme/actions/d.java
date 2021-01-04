package com.baidu.swan.apps.scheme.actions;

import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
/* loaded from: classes9.dex */
public abstract class d<DispatcherT extends UnitedSchemeAbsDispatcher> {
    public final DispatcherT dispatcher;
    public final String name;

    public d(DispatcherT dispatchert, String str) {
        this.dispatcher = dispatchert;
        this.name = str;
    }
}
