package com.baidu.swan.apps.q.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.aiapps.apps.a.c;
import com.baidu.tieba.aiapps.apps.c.d;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends z {
    private int axt;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.q.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0158a {
        void x(JSONObject jSONObject);
    }

    public a(j jVar) {
        super(jVar, "/swan/privateGetUserInfo");
        this.axt = -1;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        try {
            a(context, callbackHandler, bVar, optString);
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void a(Context context, final CallbackHandler callbackHandler, b bVar, final String str) throws JSONException {
        HashSet hashSet = new HashSet();
        hashSet.add("bd_box_uid");
        hashSet.add("bd_box_bduss");
        hashSet.add("bd_box_display_name");
        hashSet.add("bd_box_avatar_url");
        Map<String, String> a = c.a(context, hashSet);
        String str2 = a.get("bd_box_uid");
        if (TextUtils.isEmpty(a.get("bd_box_bduss")) || TextUtils.isEmpty(str2)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(10003).toString());
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, a.get("bd_box_display_name"));
        jSONObject.put(IntentConfig.PORTRAIT, a.get("bd_box_avatar_url"));
        if (this.axt != -1) {
            a(callbackHandler, str, jSONObject);
        } else {
            a(new InterfaceC0158a() { // from class: com.baidu.swan.apps.q.a.a.a.1
                @Override // com.baidu.swan.apps.q.a.a.a.InterfaceC0158a
                public void x(JSONObject jSONObject2) {
                    if (jSONObject2 == null) {
                        a.this.a(callbackHandler, str, jSONObject);
                        return;
                    }
                    a.this.axt = a.this.w(jSONObject2);
                    a.this.a(callbackHandler, str, jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        if (this.axt != -1) {
            try {
                jSONObject.put("gender", String.valueOf(this.axt));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONObject == null) {
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    optJSONObject = optJSONArray.getJSONObject(0);
                } else {
                    if (DEBUG) {
                        Log.d("BaseJsonData", "Invalid data field!");
                    }
                    optJSONObject = null;
                }
            }
            if (optJSONObject == null || (jSONObject2 = optJSONObject.getJSONObject("userx")) == null || (jSONObject3 = jSONObject2.getJSONObject(Config.EVENT_ATTR)) == null || (jSONObject4 = jSONObject3.getJSONObject("dataset")) == null) {
                return -1;
            }
            return jSONObject4.optInt("gender");
        } catch (JSONException e) {
            return -1;
        }
    }

    private void a(final InterfaceC0158a interfaceC0158a) {
        if (interfaceC0158a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gender", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(d.sZ(com.baidu.tieba.aiapps.apps.c.a.aFi()))).addParam("data", jSONObject.toString()).cookieManager(com.baidu.swan.apps.u.a.EH().Ff())).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.apps.q.a.a.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: x */
                public void onSuccess(String str, int i) {
                    try {
                        interfaceC0158a.x(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        interfaceC0158a.x(null);
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    interfaceC0158a.x(null);
                }
            });
        }
    }
}
