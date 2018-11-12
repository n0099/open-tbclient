package com.baidu.searchbox.ng.ai.apps.impl.map.action.function;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.OpenLocationModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OpenLocationAction extends AbsMapBaseAction {
    private static final boolean DEBUG = false;
    private static final String TAG = OpenLocationAction.class.getSimpleName();

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    protected boolean doAction(Context context, MapModel mapModel, WebView webView, AiApp aiApp, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.i("map", "OpenLocationAction start");
        if (!mapModel.isValid()) {
            AiAppsLog.e("map", "model is invalid");
            return false;
        }
        MapLocationFragment.newInstance(getBundleParams((OpenLocationModel) mapModel)).startFragment();
        AiAppsLog.i("map", "OpenLocationAction end");
        return true;
    }

    private Bundle getBundleParams(OpenLocationModel openLocationModel) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", openLocationModel.slaveId);
        bundle.putDouble(CoordinateModel.LATITUDE, openLocationModel.coordinate.latitude);
        bundle.putDouble(CoordinateModel.LONGITUDE, openLocationModel.coordinate.longitude);
        bundle.putDouble("scale", openLocationModel.scale);
        bundle.putString("name", openLocationModel.name);
        bundle.putString(OpenLocationModel.ADDRESS, openLocationModel.address);
        return bundle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.AbsMapBaseAction
    public OpenLocationModel getModel(UnitedSchemeEntity unitedSchemeEntity) {
        OpenLocationModel openLocationModel;
        JSONException e;
        JSONObject jSONObject;
        if (unitedSchemeEntity == null) {
            return null;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            AiAppsLog.e("map", "entity Params is empty");
            return null;
        }
        try {
            jSONObject = new JSONObject(params.get("params"));
            openLocationModel = new OpenLocationModel();
        } catch (JSONException e2) {
            openLocationModel = null;
            e = e2;
        }
        try {
            openLocationModel.parseFromJson(jSONObject);
            return openLocationModel;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            AiAppsLog.e("map", "entity Params json parse error");
            return openLocationModel;
        }
    }
}
