package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
/* loaded from: classes4.dex */
public abstract class UnitedSchemeBaseAction<DispatcherT extends UnitedSchemeAbsDispatcher> {
    public static final String TAG = "UnitedSchemeBaseAction";
    public final DispatcherT dispatcher;

    public abstract String getActionName();

    public abstract boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    public UnitedSchemeBaseAction(DispatcherT dispatchert) {
        this.dispatcher = dispatchert;
    }
}
