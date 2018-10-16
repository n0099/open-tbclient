package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes2.dex */
public abstract class BoxAction<DispatcherT extends UnitedSchemeAbsDispatcher> {
    public final DispatcherT dispatcher;
    public final String name;

    public abstract boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    public BoxAction(DispatcherT dispatchert, String str) {
        this.dispatcher = dispatchert;
        this.name = str;
    }
}
