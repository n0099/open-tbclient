package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static final HashMap<String, Integer> cEU = new HashMap<>(16);
    private static final HashMap<String, Integer> cEV;
    private static final HashMap<String, Integer> cEW;
    private int cEX = 201;
    private int cEY = 101;
    private int cEZ = 3;
    private int cFa = -1;
    private int cFb = -1;
    private int cFc = -1;
    private boolean cFd = true;

    static {
        cEU.put("VRModeProjectionSphere", 201);
        cEU.put("VRModeProjectionDome180", 202);
        cEU.put("VRModeProjectionDome230", 203);
        cEU.put("VRModeProjectionDome180Upper", 204);
        cEU.put("VRModeProjectionDome230Upper", 205);
        cEU.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cEU.put("VRModeProjectionPlaneCrop", 208);
        cEU.put("VRModeProjectionPlaneFull", 209);
        cEU.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cEU.put("VRModeProjectionMultiFishEyeVertical", 211);
        cEU.put("VRModeProjectionStereoSphereHorizontal", 212);
        cEU.put("VRModeProjectionStereoSphereVertical", 213);
        cEU.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cEU.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cEU.put("VRModeProjectionPlaneFullHorizontal", 216);
        cEU.put("VRModeProjectionPlaneFullVertical", 217);
        cEV = new HashMap<>(2);
        cEV.put("VRModeDisplayNormal", 101);
        cEV.put("VRModeDisplayGlass", 102);
        cEW = new HashMap<>(5);
        cEW.put("VRModeInteractiveMotion", 1);
        cEW.put("VRModeInteractiveTouch", 2);
        cEW.put("VRModeInteractiveMotionWithTouch", 3);
        cEW.put("VRModeInteractiveGVRMotion", 4);
        cEW.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b aX(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cEU.containsKey(optString)) {
            bVar.cEX = cEU.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && cEV.containsKey(optString2)) {
            bVar.cEY = cEV.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cEW.containsKey(optString3)) {
            bVar.cEZ = cEW.get(optString3).intValue();
        }
        bVar.cFa = jSONObject.optInt("fov", -1);
        bVar.cFb = jSONObject.optInt("minFov", -1);
        bVar.cFc = jSONObject.optInt("maxFov", -1);
        bVar.cFd = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
