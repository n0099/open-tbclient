package com.baidu.swan.apps.scheme.actions.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.e;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    private FloatButton bmK;
    private com.baidu.swan.apps.scheme.actions.c.a bmL;
    private e bmM;
    private String mPackageName;

    public b(j jVar) {
        super(jVar, "/swan/showOpenAppGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        final JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
            return false;
        } else if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not instanceof SwanAppActivity");
            return false;
        } else {
            final String optString = c.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            this.mPackageName = c.optString("name");
            if (TextUtils.isEmpty(this.mPackageName)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                return false;
            }
            this.bmL = com.baidu.swan.apps.scheme.actions.c.a.RN();
            this.bmL.hK(this.mPackageName);
            if (this.bmL.RP() != null) {
                this.bmK = f(context, c);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
            com.baidu.swan.apps.v.b.b AJ = bVar.AJ();
            if (AJ == null || TextUtils.isEmpty(AJ.KE())) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launchInfo or source is empty");
                return false;
            }
            final String KE = AJ.KE();
            bVar.Rd().c("mapp_open_external_app", new com.baidu.swan.apps.an.d.a<e>() { // from class: com.baidu.swan.apps.scheme.actions.c.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: c */
                public void B(e eVar) {
                    if (eVar == null || eVar.forbidden) {
                        FloatButton RP = b.this.bmL.RP();
                        if (RP != null) {
                            RP.setVisibility(8);
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
                    } else if (b.this.a(eVar, c.optString("scheme"))) {
                        b.this.bmM = eVar;
                        SwanAppActivity swanAppActivity = (SwanAppActivity) context;
                        b.this.bmL = com.baidu.swan.apps.scheme.actions.c.a.RN();
                        if (b.this.bmL.RP() == null) {
                            b.this.bmK = b.this.f(context, c);
                            b.this.a(optString, c, callbackHandler, swanAppActivity);
                        }
                        bVar.Rj().putBoolean(KE, true);
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
    public FloatButton f(Context context, JSONObject jSONObject) {
        this.bmL.a((SwanAppActivity) context, jSONObject);
        return this.bmL.RO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(e eVar, String str) {
        if (eVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : eVar.bos) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final JSONObject jSONObject, final CallbackHandler callbackHandler, final Activity activity) {
        if (callbackHandler != null && !TextUtils.isEmpty(str)) {
            this.bmK.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.scheme.actions.c.a.b.2
                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    boolean z;
                    if (ac.isAppInstalled(activity, b.this.mPackageName)) {
                        String optString = jSONObject.optString("scheme");
                        b.this.a(activity, optString, b.this.aF(b.this.bmM.bot.get(0), optString), callbackHandler, str);
                        return;
                    }
                    try {
                        String optString2 = jSONObject.optString("downloadUrl");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", optString2);
                        z = ac.Z(activity, jSONObject2.toString());
                    } catch (JSONException e) {
                        if (b.DEBUG) {
                            e.printStackTrace();
                        }
                        z = false;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void Lt() {
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
            aVar.ct(true).hi(str2).a(new com.baidu.swan.apps.view.b.a()).cv(false);
            aVar.c(string, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.c.a.b.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    boolean Y = ac.Y(activity, str);
                    callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(Y ? 0 : 1001, Y ? "open app success" : "open app fail").toString());
                }
            });
            aVar.d(string2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.c.a.b.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
            aVar.Qu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aF(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str4 = "";
        String str5 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equals("slogan_base")) {
                    str4 = jSONObject.optString(next);
                }
                str5 = str2.contains(next) ? jSONObject.optString(next) : str5;
            }
            str3 = str4;
        } catch (JSONException e) {
            str3 = str4;
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str5)) {
            return null;
        }
        return str3 + str5;
    }
}
