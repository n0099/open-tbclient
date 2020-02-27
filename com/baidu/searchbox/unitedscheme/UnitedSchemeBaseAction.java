package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
/* loaded from: classes12.dex */
public abstract class UnitedSchemeBaseAction<DispatcherT extends UnitedSchemeAbsDispatcher> {
    private static final String TAG = UnitedSchemeBaseAction.class.getSimpleName();
    public final DispatcherT dispatcher;

    public abstract String getActionName();

    public abstract boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    public UnitedSchemeBaseAction(DispatcherT dispatchert) {
        this.dispatcher = dispatchert;
    }
}
