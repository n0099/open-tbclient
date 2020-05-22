package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
                com.baidu.swan.apps.performance.g.alx().aj(s(optParamsAsJo.optJSONArray("data"))).ald();
                UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler);
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.r.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.atP();
                    }
                });
                break;
            case 1:
                t(optParamsAsJo.optJSONArray("data"));
                break;
            case 2:
                u(optParamsAsJo.optJSONArray("data"));
                break;
            default:
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "unknown flowId");
                return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    List<UbcFlowEvent> s(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent aq = aq(jSONArray.optJSONObject(i));
            if (aq != null) {
                aq.mF("FE");
                arrayList.add(aq);
            }
        }
        return arrayList;
    }

    UbcFlowEvent aq(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).bg(optLong);
    }

    private void t(JSONArray jSONArray) {
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
                    searchFlowEvent.cGJ = SearchFlowEvent.EventType.END;
                    com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void u(JSONArray jSONArray) {
        long longValue;
        com.baidu.swan.apps.core.d.d YQ = com.baidu.swan.apps.w.f.ahV().YQ();
        if (YQ != null) {
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
                        YQ.a(new com.baidu.swan.apps.statistic.a.g(string, longValue));
                    }
                    longValue = 0;
                    YQ.a(new com.baidu.swan.apps.statistic.a.g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
