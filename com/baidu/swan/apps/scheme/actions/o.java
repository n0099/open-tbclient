package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.aj;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class o extends aa {
    public o(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/openApp");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        final JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
            return false;
        }
        final String optString = b.optString("cb");
        if (DEBUG) {
            Log.i("OpenAppAction", "params is " + b.toString());
        }
        final String optString2 = b.optString("open", "");
        c(eVar, optString2);
        eVar.aoR().d("scope_open_app", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.scheme.actions.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: c */
            public void H(com.baidu.swan.apps.setting.oauth.e eVar2) {
                if (eVar2 == null || eVar2.forbidden) {
                    if (aa.DEBUG) {
                        Log.i("OpenAppAction", "no configuration of authority");
                    }
                    com.baidu.swan.apps.setting.oauth.c.a(10005, callbackHandler, optString);
                    com.baidu.swan.apps.statistic.h.b(10005, eVar2);
                } else if (o.this.a(eVar2, optString2)) {
                    o.this.a(context, b, callbackHandler, optString);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，用户未达到最低使用要求").toString());
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    private void c(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull String str) {
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mSource = eVar.QJ().agK();
        eVar2.v("appkey", eVar.getAppId());
        eVar2.v(Config.ROM, "Android");
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        eVar2.v("schema", str);
        com.baidu.swan.apps.statistic.h.a("1303", eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.apps.setting.oauth.e eVar, String str) {
        if (eVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.apps.runtime.e.aoF() == null && com.baidu.swan.apps.runtime.e.aoF().QJ() == null) {
            return false;
        }
        String agK = com.baidu.swan.apps.runtime.e.aoF().QJ().agK();
        if (TextUtils.isEmpty(agK)) {
            agK = "NA";
        }
        JSONObject jSONObject = eVar.cEy;
        if (jSONObject == null || jSONObject.keys() == null) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(FaceBaseDTO.KEY_BUSINESS_SCENE);
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        for (int i = 0; i < length; i++) {
            if (agK.equals(optJSONArray.optString(i))) {
                return true;
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
        int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            if (str.startsWith(optJSONArray2.optString(i2))) {
                return true;
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY);
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("launch_count", -1);
            int optInt2 = optJSONObject.optInt("daily_duration", -1);
            if (optInt >= 0 || optInt2 >= 0) {
                return ai.atI() >= optInt || ai.atJ() >= ((long) (optInt2 * 60000));
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        String optString = jSONObject.optString("open");
        boolean a = !TextUtils.isEmpty(optString) ? aj.a(context, optString, callbackHandler, str) : false;
        boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
        if (DEBUG) {
            Log.i("OpenAppAction", "open app result=" + a + "\nisNeedDownload=" + optBoolean);
        }
        if (!optBoolean) {
            if (!a) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
                return;
            }
            return;
        }
        boolean Z = !a ? aj.Z(context, jSONObject.optString("download")) : true;
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(Z ? 0 : 1001, Z ? "下载APP成功" : "下载APP失败").toString());
    }
}
