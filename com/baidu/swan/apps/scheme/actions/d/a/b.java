package com.baidu.swan.apps.scheme.actions.d.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.c;
import com.baidu.swan.apps.setting.oauth.e;
import com.baidu.swan.apps.x.b.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends ab {
    private FloatButton cqO;
    private com.baidu.swan.apps.scheme.actions.d.a cqP;
    private e cqQ;
    private String mPackageName;

    public b(j jVar) {
        super(jVar, "/swanAPI/showOpenAppGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not instanceof SwanAppActivity");
            return false;
        } else {
            final String optString = b.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            this.mPackageName = b.optString("name");
            if (TextUtils.isEmpty(this.mPackageName)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                return false;
            }
            this.cqP = com.baidu.swan.apps.scheme.actions.d.a.alU();
            this.cqP.mE(this.mPackageName);
            if (this.cqP.alW() != null) {
                this.cqO = l(context, b);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
            b.a Ov = eVar.Ov();
            if (Ov == null || TextUtils.isEmpty(Ov.adA())) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launchInfo or source is empty");
                return false;
            }
            final String adA = Ov.adA();
            eVar.akW().d("mapp_open_external_app", new com.baidu.swan.apps.as.d.b<e>() { // from class: com.baidu.swan.apps.scheme.actions.d.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: c */
                public void F(e eVar2) {
                    if (eVar2 == null || eVar2.forbidden) {
                        FloatButton alW = b.this.cqP.alW();
                        if (alW != null) {
                            alW.setVisibility(8);
                        }
                        c.a(10005, callbackHandler, optString);
                    } else if (b.this.b(eVar2, b.optString(SuspensionBallEntity.KEY_SCHEME))) {
                        b.this.cqQ = eVar2;
                        SwanAppActivity swanAppActivity = (SwanAppActivity) context;
                        b.this.cqP = com.baidu.swan.apps.scheme.actions.d.a.alU();
                        if (b.this.cqP.alW() == null) {
                            b.this.cqO = b.this.l(context, b);
                            b.this.a(optString, b, callbackHandler, swanAppActivity);
                        }
                        eVar.alc().a(adA, (Boolean) true);
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
    public FloatButton l(Context context, JSONObject jSONObject) {
        this.cqP.a((SwanAppActivity) context, jSONObject);
        return this.cqP.alV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(e eVar, String str) {
        if (eVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : eVar.csv) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final JSONObject jSONObject, final CallbackHandler callbackHandler, final Activity activity) {
        if (callbackHandler != null && !TextUtils.isEmpty(str)) {
            this.cqO.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.scheme.actions.d.a.b.2
                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    boolean z;
                    if (ai.isAppInstalled(activity, b.this.mPackageName)) {
                        String optString = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
                        b.this.a(activity, optString, b.this.bs(b.this.cqQ.csw.get(0), optString), callbackHandler, str);
                        return;
                    }
                    try {
                        String optString2 = jSONObject.optString("downloadUrl");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", optString2);
                        z = ai.Z(activity, jSONObject2.toString());
                    } catch (JSONException e) {
                        if (b.DEBUG) {
                            e.printStackTrace();
                        }
                        z = false;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aez() {
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
            aVar.ey(true).lV(str2).a(new com.baidu.swan.apps.view.c.a()).eA(false);
            aVar.a(string, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.d.a.b.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    boolean launchApp = ai.launchApp(activity, str);
                    callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(launchApp ? 0 : 1001, launchApp ? "open app success" : "open app fail").toString());
                }
            });
            aVar.b(string2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.d.a.b.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
            aVar.akw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bs(String str, String str2) {
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
