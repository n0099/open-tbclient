package com.baidu.swan.apps.scheme;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
/* loaded from: classes8.dex */
public class c implements ISchemeIoc {
    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
    public boolean needShowConfirmWindow(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
    public void showConfirmDialog(Context context, UnitedSchemeBaseDispatcher.ConfirmDialogCallback confirmDialogCallback) {
        if (confirmDialogCallback != null) {
            confirmDialogCallback.onConfirm();
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
    public void doStatistic(String str, String str2) {
        com.baidu.swan.apps.statistic.b.onEvent(str, str2);
    }

    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
    public void showSchemeNotSupportDialog(Context context) {
    }
}
