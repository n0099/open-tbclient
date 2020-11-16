package com.baidu.swan.bdprivate.extensions.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes7.dex */
public class a extends SwanAppDownloadAction {
    public a(j jVar) {
        super(jVar, "/swanAPI/installApp4Ad");
    }

    @Override // com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction
    protected boolean a(@NonNull UnitedSchemeEntity unitedSchemeEntity, @Nullable e eVar) {
        return false;
    }
}
