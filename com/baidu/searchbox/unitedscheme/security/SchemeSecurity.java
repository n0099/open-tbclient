package com.baidu.searchbox.unitedscheme.security;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeRuntime;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes19.dex */
public class SchemeSecurity {
    public static boolean needShowConfirmWindow(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        ISchemeIoc schemeIoc = SchemeRuntime.getSchemeIoc();
        if (schemeIoc == null) {
            return false;
        }
        return schemeIoc.needShowConfirmWindow(context, unitedSchemeEntity, callbackHandler);
    }
}
