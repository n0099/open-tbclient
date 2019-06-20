package com.baidu.swan.apps.g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class b extends z {
    private String mCallback;

    public b(j jVar) {
        super(jVar, "/swan/scanCode");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            c.i("scanCode", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        this.mCallback = o.cY(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            c.i("scanCode", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.u.a.DJ().a(bVar.getActivity(), new a() { // from class: com.baidu.swan.apps.g.b.1
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
