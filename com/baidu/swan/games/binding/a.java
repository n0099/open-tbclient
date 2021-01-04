package com.baidu.swan.games.binding;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.scheme.e;
/* loaded from: classes9.dex */
public final class a {
    private com.baidu.swan.apps.jsbridge.a.a cSG = new com.baidu.swan.apps.jsbridge.a.a();

    public void a(com.baidu.swan.games.f.a aVar, Context context) {
        UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
        this.cSG.a(aVar, context, aVar, unitedSchemeMainDispatcher);
        e.a(unitedSchemeMainDispatcher);
    }

    public void X(Activity activity) {
        this.cSG.E(activity);
    }
}
