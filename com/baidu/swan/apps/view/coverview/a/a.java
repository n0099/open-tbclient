package com.baidu.swan.apps.view.coverview.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.coverview.subview.CoverViewHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swan/coverimage");
    }

    @Override // com.baidu.swan.apps.view.coverview.a.b
    protected boolean a(String str, Context context, @NonNull com.baidu.swan.apps.view.coverview.b.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 279649557:
                if (str.equals("/swan/coverimage/insert")) {
                    c = 0;
                    break;
                }
                break;
            case 528831200:
                if (str.equals("/swan/coverimage/remove")) {
                    c = 2;
                    break;
                }
                break;
            case 624595749:
                if (str.equals("/swan/coverimage/update")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a(context, aVar, absoluteLayout, unitedSchemeEntity, callbackHandler);
            case 1:
                return b(context, aVar, absoluteLayout, unitedSchemeEntity, callbackHandler);
            case 2:
                return c(context, aVar, absoluteLayout, unitedSchemeEntity, callbackHandler);
            default:
                return false;
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.a.b
    protected com.baidu.swan.apps.view.coverview.b.a am(JSONObject jSONObject) {
        com.baidu.swan.apps.view.coverview.b.b bVar = new com.baidu.swan.apps.view.coverview.b.b();
        bVar.aZe = CoverViewHelper.Type.IMAGE;
        try {
            bVar.parseFromJson(jSONObject);
        } catch (JSONException e) {
            c.e("CoverImage", "model parse exception:", e);
        }
        return bVar;
    }
}
