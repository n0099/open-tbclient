package com.baidu.swan.apps.q.a.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.aiapps.apps.a.e;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/privateGetUserInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
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
        a(context, callbackHandler, bVar, optString);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void a(Context context, CallbackHandler callbackHandler, b bVar, String str) {
        HashSet hashSet = new HashSet();
        hashSet.add("BoxAccount_uid");
        hashSet.add("BoxAccount_bduss");
        hashSet.add("user_login_nickname_key");
        hashSet.add("user_login_portrait_key");
        Map<String, String> a = com.baidu.tieba.aiapps.apps.a.a.a(context, hashSet);
        String str2 = a.get("BoxAccount_uid");
        if (TextUtils.isEmpty(a.get("BoxAccount_bduss")) || TextUtils.isEmpty(str2)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(10003).toString());
            return;
        }
        Bundle ah = ah(context, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("displayname", a.get("user_login_nickname_key"));
            jSONObject.put(IntentConfig.PORTRAIT, a.get("user_login_portrait_key"));
            if (ah.containsKey("key_gender")) {
                jSONObject.put("gender", String.valueOf(ah.getInt("key_gender")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }

    private Bundle ah(Context context, String str) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_uid", str);
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, e.class, bundle2);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult : bundle;
        }
        return bundle;
    }
}
