package com.baidu.swan.apps.scheme.actions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes9.dex */
public class aa extends SwanAppDownloadAction {
    public aa(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/installApp4Ad");
    }

    @Override // com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction
    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @Nullable com.baidu.swan.apps.runtime.e eVar) {
        return false;
    }
}
