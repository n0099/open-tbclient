package com.baidu.searchbox.ng.ai.apps.scheme;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.ioc.ISchemeIoc;
/* loaded from: classes2.dex */
public class SchemeIocImpl implements ISchemeIoc {
    private static final String SCHEME_HEAD = "tiebaclient";

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
        return SCHEME_HEAD;
    }
}
