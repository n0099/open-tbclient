package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private static final HashMap<String, Integer> ddJ = new HashMap<>(16);
    private static final HashMap<String, Integer> ddK;
    private static final HashMap<String, Integer> ddL;
    private int ddM = 201;
    private int ddN = 101;
    private int ddO = 3;
    private int ddP = -1;
    private int ddQ = -1;
    private int ddR = -1;
    private boolean ddS = true;

    static {
        ddJ.put("VRModeProjectionSphere", 201);
        ddJ.put("VRModeProjectionDome180", 202);
        ddJ.put("VRModeProjectionDome230", 203);
        ddJ.put("VRModeProjectionDome180Upper", 204);
        ddJ.put("VRModeProjectionDome230Upper", 205);
        ddJ.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        ddJ.put("VRModeProjectionPlaneCrop", 208);
        ddJ.put("VRModeProjectionPlaneFull", 209);
        ddJ.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        ddJ.put("VRModeProjectionMultiFishEyeVertical", 211);
        ddJ.put("VRModeProjectionStereoSphereHorizontal", 212);
        ddJ.put("VRModeProjectionStereoSphereVertical", 213);
        ddJ.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        ddJ.put("VRModeProjectionStereoPlaneFitVertical", 215);
        ddJ.put("VRModeProjectionPlaneFullHorizontal", 216);
        ddJ.put("VRModeProjectionPlaneFullVertical", 217);
        ddK = new HashMap<>(2);
        ddK.put("VRModeDisplayNormal", 101);
        ddK.put("VRModeDisplayGlass", 102);
        ddL = new HashMap<>(5);
        ddL.put("VRModeInteractiveMotion", 1);
        ddL.put("VRModeInteractiveTouch", 2);
        ddL.put("VRModeInteractiveMotionWithTouch", 3);
        ddL.put("VRModeInteractiveGVRMotion", 4);
        ddL.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b bh(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && ddJ.containsKey(optString)) {
            bVar.ddM = ddJ.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && ddK.containsKey(optString2)) {
            bVar.ddN = ddK.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && ddL.containsKey(optString3)) {
            bVar.ddO = ddL.get(optString3).intValue();
        }
        bVar.ddP = jSONObject.optInt("fov", -1);
        bVar.ddQ = jSONObject.optInt("minFov", -1);
        bVar.ddR = jSONObject.optInt("maxFov", -1);
        bVar.ddS = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
