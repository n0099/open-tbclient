package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class r extends aa {
    public r(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/openStatisticFlowJar");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("flowId");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty flowId");
            return false;
        }
        char c = 65535;
        switch (optString.hashCode()) {
            case 53647:
                if (optString.equals("670")) {
                    c = 0;
                    break;
                }
                break;
            case 54610:
                if (optString.equals("772")) {
                    c = 1;
                    break;
                }
                break;
            case 55357:
                if (optString.equals("805")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.swan.apps.performance.i.aHz().aS(v(optParamsAsJo.optJSONArray("data"))).aHg();
                break;
            case 1:
                w(optParamsAsJo.optJSONArray("data"));
                break;
            case 2:
                x(optParamsAsJo.optJSONArray("data"));
                break;
            default:
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "unknown flowId");
                return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    List<UbcFlowEvent> v(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent bd = bd(jSONArray.optJSONObject(i));
            if (bd != null) {
                bd.ru("FE");
                arrayList.add(bd);
            }
        }
        return arrayList;
    }

    UbcFlowEvent bd(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).cy(optLong);
    }

    private void w(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SearchFlowEvent from FE, data: " + jSONArray);
            }
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    String optString2 = optJSONObject.optString("errorType");
                    String optString3 = optJSONObject.optString("timeStamp");
                    SearchFlowEvent searchFlowEvent = new SearchFlowEvent(optString);
                    searchFlowEvent.timestamp = Long.valueOf(optString3).longValue();
                    searchFlowEvent.data = optString2;
                    searchFlowEvent.dOs = SearchFlowEvent.EventType.END;
                    com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void x(JSONArray jSONArray) {
        long longValue;
        com.baidu.swan.apps.core.d.e asU = com.baidu.swan.apps.v.f.aDG().asU();
        if (asU != null) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                if (jSONObject != null) {
                    String string = jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    String optString = jSONObject.optString("timeStamp");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            longValue = Long.valueOf(optString).longValue();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        asU.a(new com.baidu.swan.apps.statistic.a.g(string, longValue));
                    }
                    longValue = 0;
                    asU.a(new com.baidu.swan.apps.statistic.a.g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
