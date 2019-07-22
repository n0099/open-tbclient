package com.baidu.swan.apps.scheme.actions;

import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
/* loaded from: classes2.dex */
public abstract class c<DispatcherT extends UnitedSchemeAbsDispatcher> {
    public final DispatcherT aRZ;
    public final String name;

    public c(DispatcherT dispatchert, String str) {
        this.aRZ = dispatchert;
        this.name = str;
    }
}
