package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import com.baidu.searchbox.ng.ai.apps.statistic.search.SearchFlowEvent;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UbcFlowJarAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/ubcFlowJar";
    private static final String LOG_TAG = "UbcFlowJarAction";

    public UbcFlowJarAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
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
                if (optString.equals(AiAppsPerformanceUBC.ID_PERFORMANCED_FLOW)) {
                    c = 0;
                    break;
                }
                break;
            case 54610:
                if (optString.equals(AiAppsSearchFlowUBC.ID_SEARCH_FLOW)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AiAppsPerformanceUBC.requireSession().record(parseEvents(optParamsAsJo.optJSONArray("data"))).h5FlowDone();
                break;
            case 1:
                handleDataForSearchFlow(optParamsAsJo.optJSONArray("data"));
                break;
            default:
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "unknown flowId");
                return false;
        }
        AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.UbcFlowJarAction.1
            @Override // java.lang.Runnable
            public void run() {
                AiAppsUtils.onPreloadNextEnv();
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    List<UbcFlowEvent> parseEvents(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent parseEvent = parseEvent(jSONArray.optJSONObject(i));
            if (parseEvent != null) {
                parseEvent.srcType("FE");
                arrayList.add(parseEvent);
            }
        }
        return arrayList;
    }

    UbcFlowEvent parseEvent(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong(HttpConstants.TIMESTAMP);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).time(optLong);
    }

    private void handleDataForSearchFlow(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(AiAppsSearchFlowUBC.FE_DATA_ERRTYPE);
                    String optString2 = optJSONObject.optString("timeStamp");
                    SearchFlowEvent searchFlowEvent = new SearchFlowEvent(SearchFlowEvent.ID_NOT_REACH);
                    searchFlowEvent.timestamp = Long.valueOf(optString2).longValue();
                    searchFlowEvent.data = optString;
                    searchFlowEvent.eventType = SearchFlowEvent.EventType.END;
                    AiAppsSearchFlowUBC.addEvent(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
            }
        }
    }
}
