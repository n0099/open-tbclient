package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes2.dex */
public interface IAiAppTTSIoc {
    boolean resume(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    boolean speak(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    boolean stop(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    boolean suspend(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);
}
