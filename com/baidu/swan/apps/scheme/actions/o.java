package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.al;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
        eVar.arH().d("scope_open_app", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.scheme.actions.o.1
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
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    private void c(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull String str) {
        com.baidu.swan.apps.statistic.a.e eVar2 = new com.baidu.swan.apps.statistic.a.e();
        eVar2.mSource = eVar.Se().ajg();
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
        boolean z = true;
        if (eVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String ajg = com.baidu.swan.apps.runtime.d.arr().arn().arz().ajg();
        if (TextUtils.isEmpty(ajg)) {
            ajg = "NA";
        }
        JSONObject jSONObject = eVar.cMs;
        if (jSONObject == null || jSONObject.keys() == null) {
            return false;
        }
        if (DEBUG) {
            Log.i("OpenAppAction", "source: " + ajg + " openUrl:" + str + " 配置数据:" + jSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(FaceBaseDTO.KEY_BUSINESS_SCENE);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        if (length > 0) {
            boolean z2 = false;
            for (int i = 0; i < length; i++) {
                if (ajg.equals(optJSONArray.optString(i))) {
                    z2 = true;
                }
            }
            return (z2 && b(str, optJSONArray2)) ? false : false;
        }
        return b(str, optJSONArray2);
    }

    private boolean b(String str, JSONArray jSONArray) {
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        String decode = Uri.decode(str);
        for (int i = 0; i < length; i++) {
            if (decode.startsWith(Uri.decode(jSONArray.optString(i)))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        String optString = jSONObject.optString("open");
        boolean a = !TextUtils.isEmpty(optString) ? al.a(context, optString, callbackHandler, str) : false;
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
        boolean aa = !a ? al.aa(context, jSONObject.optString("download")) : true;
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(aa ? 0 : 1001, aa ? "下载APP成功" : "下载APP失败").toString());
    }
}
