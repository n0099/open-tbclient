package com.baidu.swan.games.binding;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.scheme.e;
/* loaded from: classes11.dex */
public final class a {
    private com.baidu.swan.apps.jsbridge.a.a bTQ = new com.baidu.swan.apps.jsbridge.a.a();

    public void a(com.baidu.swan.games.f.a aVar, Context context) {
        UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
        this.bTQ.a(aVar, context, aVar, unitedSchemeMainDispatcher);
        e.a(unitedSchemeMainDispatcher);
    }

    public void T(Activity activity) {
        this.bTQ.E(activity);
    }
}
