package com.baidu.searchbox.unitedscheme.intercept;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes6.dex */
public abstract class UnitedSchemeBaseInterceptor implements UnitedSchemeAbsInterceptor {
    public abstract String getInterceptorName();

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }
}
