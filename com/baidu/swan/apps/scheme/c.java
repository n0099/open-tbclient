package com.baidu.swan.apps.scheme;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc;
import com.baidu.swan.ubc.r;
/* loaded from: classes2.dex */
public class c implements ISchemeIoc {
    @Override // com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc
    public boolean needShowConfirmWindow(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    @Override // com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc
    public void showConfirmDialog(Context context, UnitedSchemeBaseDispatcher.ConfirmDialogCallback confirmDialogCallback) {
        if (confirmDialogCallback != null) {
            confirmDialogCallback.onConfirm();
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc
    public String getSchemeHead() {
        return com.baidu.swan.apps.u.a.CK().vw();
    }

    @Override // com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc
    public void doStatistic(String str, String str2) {
        r.onEvent(str, str2);
    }
}
