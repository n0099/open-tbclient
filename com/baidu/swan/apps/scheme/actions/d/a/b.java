package com.baidu.swan.apps.scheme.actions.d.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.c;
import com.baidu.swan.apps.setting.oauth.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends aa {
    private FloatButton dJX;
    private com.baidu.swan.apps.scheme.actions.d.a dJY;
    private e dJZ;
    private String mPackageName;

    public b(j jVar) {
        super(jVar, "/swanAPI/showOpenAppGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not instanceof SwanAppActivity");
            return false;
        } else {
            final String optString = b2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            this.mPackageName = b2.optString("name");
            if (TextUtils.isEmpty(this.mPackageName)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                return false;
            }
            this.dJY = com.baidu.swan.apps.scheme.actions.d.a.aNz();
            this.dJY.te(this.mPackageName);
            if (this.dJY.aNB() != null) {
                this.dJX = k(context, b2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
            b.a aju = eVar.aju();
            if (aju == null || TextUtils.isEmpty(aju.aCv())) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launchInfo or source is empty");
                return false;
            }
            final String aCv = aju.aCv();
            eVar.aMw().e("mapp_open_external_app", new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.apps.scheme.actions.d.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: c */
                public void L(e eVar2) {
                    if (eVar2 == null || eVar2.forbidden) {
                        FloatButton aNB = b.this.dJY.aNB();
                        if (aNB != null) {
                            aNB.setVisibility(8);
                        }
                        c.a(10005, callbackHandler, optString);
                        h.b(10005, eVar2);
                    } else if (b.this.b(eVar2, b2.optString("scheme"))) {
                        b.this.dJZ = eVar2;
                        SwanAppActivity swanAppActivity = (SwanAppActivity) context;
                        b.this.dJY = com.baidu.swan.apps.scheme.actions.d.a.aNz();
                        if (b.this.dJY.aNB() == null) {
                            b.this.dJX = b.this.k(context, b2);
                            b.this.a(optString, b2, callbackHandler, swanAppActivity);
                        }
                        eVar.aMC().a(aCv, true);
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatButton k(Context context, JSONObject jSONObject) {
        this.dJY.a((SwanAppActivity) context, jSONObject);
        return this.dJY.aNA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(e eVar, String str) {
        if (eVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : eVar.dLM) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final JSONObject jSONObject, final CallbackHandler callbackHandler, final Activity activity) {
        if (callbackHandler != null && !TextUtils.isEmpty(str)) {
            this.dJX.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.scheme.actions.d.a.b.2
                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    boolean z;
                    if (ak.isAppInstalled(activity, b.this.mPackageName)) {
                        String optString = jSONObject.optString("scheme");
                        b.this.a(activity, optString, b.this.cy(b.this.dJZ.dLN.get(0), optString), callbackHandler, str);
                        return;
                    }
                    try {
                        String optString2 = jSONObject.optString("downloadUrl");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", optString2);
                        z = ak.as(activity, jSONObject2.toString());
                    } catch (JSONException e) {
                        if (b.DEBUG) {
                            e.printStackTrace();
                        }
                        z = false;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aDv() {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity, final String str, String str2, final CallbackHandler callbackHandler, final String str3) {
        if ((activity instanceof SwanAppActivity) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String string = activity.getString(a.h.aiapps_ok);
            String string2 = activity.getString(a.h.aiapps_cancel);
            g.a aVar = new g.a(activity);
            aVar.gT(true).sp(str2).a(new com.baidu.swan.apps.view.c.a()).gV(false);
            aVar.a(string, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.d.a.b.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    boolean launchApp = ak.launchApp(activity, str);
                    callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(launchApp ? 0 : 1001, launchApp ? "open app success" : "open app fail").toString());
                }
            });
            aVar.b(string2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.d.a.b.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
            aVar.aLx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cy(String str, String str2) {
        JSONException e;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = "";
        String str4 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            String str5 = "";
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    String optString = next.equals("slogan_base") ? jSONObject.optString(next) : str5;
                    try {
                        str4 = str2.contains(next) ? jSONObject.optString(next) : str4;
                        str5 = optString;
                    } catch (JSONException e2) {
                        e = e2;
                        str3 = optString;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        if (TextUtils.isEmpty(str3)) {
                        }
                        return null;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str3 = str5;
                }
            }
            str3 = str5;
        } catch (JSONException e4) {
            e = e4;
        }
        if (!TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return null;
        }
        return str3 + str4;
    }
}
