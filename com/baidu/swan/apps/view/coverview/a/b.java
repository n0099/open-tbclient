package com.baidu.swan.apps.view.coverview.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.swan.apps.view.coverview.subview.CoverViewHelper;
import com.baidu.swan.apps.view.coverview.subview.ImageCoverView;
import com.baidu.swan.apps.view.coverview.subview.TextCoverView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/coverview");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("CoverView", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.i("CoverView", "handleSubAction subAction: " + str);
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            c.e("CoverView", "no params json");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        if (DEBUG) {
            Log.i("CoverView", "handleSubAction params: " + unitedSchemeEntity.getParam("params"));
        }
        com.baidu.swan.apps.view.coverview.b.a ao = ao(optParamsAsJo);
        if (ao == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        AbsoluteLayout fe = ac.fe(ao.aDU);
        if (fe == null) {
            c.e("CoverView", "can not find webView by #" + ao.aDU);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return a(str, context, ao, fe, unitedSchemeEntity, callbackHandler);
    }

    protected com.baidu.swan.apps.view.coverview.b.a ao(JSONObject jSONObject) {
        com.baidu.swan.apps.view.coverview.b.c cVar = new com.baidu.swan.apps.view.coverview.b.c();
        cVar.bcI = CoverViewHelper.Type.TEXT;
        try {
            cVar.parseFromJson(jSONObject);
        } catch (JSONException e) {
            c.e("CoverView", "model parse exception:", e);
        }
        return cVar;
    }

    protected boolean a(String str, Context context, @NonNull com.baidu.swan.apps.view.coverview.b.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 460013883:
                if (str.equals("/swan/coverview/insert")) {
                    c = 0;
                    break;
                }
                break;
            case 709195526:
                if (str.equals("/swan/coverview/remove")) {
                    c = 2;
                    break;
                }
                break;
            case 804960075:
                if (str.equals("/swan/coverview/update")) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
        }
    }

    public boolean a(Context context, @NonNull com.baidu.swan.apps.view.coverview.b.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        com.baidu.swan.apps.model.a.a.b bVar = aVar.aDW;
        if (bVar == null || !bVar.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.view.coverview.subview.a a = a(context, aVar.bcI);
        boolean a2 = new SwanAppNAViewContainer(context).a((View) a, aVar);
        a.a(aVar);
        a.setAlpha(aVar);
        a.setOnActionCallback(new com.baidu.swan.apps.view.coverview.a() { // from class: com.baidu.swan.apps.view.coverview.a.b.1
            @Override // com.baidu.swan.apps.view.coverview.a
            public void a(int i, View view, @Nullable Object obj) {
                com.baidu.swan.apps.view.coverview.b.a model = a.getModel();
                switch (i) {
                    case 0:
                    case 1:
                        if (model != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", "loadState");
                                jSONObject.put("parentId", model.aDV);
                                jSONObject.put("viewId", model.id);
                                jSONObject.put("loadState", i == 1 ? "finish" : "error");
                            } catch (JSONException e) {
                                c.e("CoverView", "loadState callback error", e);
                            }
                            b.this.a(callbackHandler, jSONObject, model.callback);
                            return;
                        }
                        return;
                    case 2:
                        CoverViewHelper.a clickPosition = a.getClickPosition();
                        if (model != null && clickPosition != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("type", "click");
                                jSONObject2.put("parentId", model.aDV);
                                jSONObject2.put("viewId", model.id);
                                jSONObject2.put(Config.EVENT_HEAT_X, com.baidu.swan.apps.an.z.af(clickPosition.x));
                                jSONObject2.put("y", com.baidu.swan.apps.an.z.af(clickPosition.y));
                            } catch (JSONException e2) {
                                c.e("CoverView", "click callback error", e2);
                            }
                            b.this.a(callbackHandler, jSONObject2, model.callback);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return a2;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return a2;
    }

    public boolean b(Context context, @NonNull com.baidu.swan.apps.view.coverview.b.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.model.a.a.b bVar = aVar.aDW;
        if (bVar == null || !bVar.isValid()) {
            c.e("CoverView", "position not valid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a == null) {
            c.e("CoverView", "can't find coverView:#" + aVar.id);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        boolean a2 = com.baidu.swan.apps.view.coverview.c.a.a(a, aVar);
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        return a2;
    }

    public boolean c(Context context, @NonNull com.baidu.swan.apps.view.coverview.b.a aVar, @NonNull AbsoluteLayout absoluteLayout, @NonNull UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(aVar, null);
        if (a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        boolean Qi = a.Qi();
        if (Qi) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        return Qi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        c.i("CoverView", "sendAsyncCallback info: " + jSONObject);
        if (!TextUtils.isEmpty(str)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }

    private com.baidu.swan.apps.view.coverview.subview.a a(Context context, CoverViewHelper.Type type) {
        switch (type) {
            case TEXT:
                return new TextCoverView(context);
            case IMAGE:
                return new ImageCoverView(context);
            default:
                return new TextCoverView(context);
        }
    }
}
