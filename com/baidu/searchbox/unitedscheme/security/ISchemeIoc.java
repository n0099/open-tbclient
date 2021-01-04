package com.baidu.searchbox.unitedscheme.security;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes15.dex */
public interface ISchemeIoc {
    public static final ISchemeIoc EMPTY = new ISchemeIoc() { // from class: com.baidu.searchbox.unitedscheme.security.ISchemeIoc.1
        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public boolean needShowConfirmWindow(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            return false;
        }

        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public void showConfirmDialog(Context context, UnitedSchemeBaseDispatcher.ConfirmDialogCallback confirmDialogCallback) {
        }

        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public void doStatistic(String str, String str2) {
        }

        @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
        public void showSchemeNotSupportDialog(Context context) {
        }
    };

    void doStatistic(String str, String str2);

    boolean needShowConfirmWindow(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    void showConfirmDialog(Context context, UnitedSchemeBaseDispatcher.ConfirmDialogCallback confirmDialogCallback);

    void showSchemeNotSupportDialog(Context context);
}
