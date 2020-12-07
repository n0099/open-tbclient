package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.ar.face.algo.FAUEnum;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b {
    private static final HashMap<String, Integer> dkI = new HashMap<>(16);
    private static final HashMap<String, Integer> dkJ;
    private static final HashMap<String, Integer> dkK;
    private int dkL = 201;
    private int dkM = 101;
    private int dkN = 3;
    private int dkO = -1;
    private int dkP = -1;
    private int dkQ = -1;
    private boolean dkR = true;

    static {
        dkI.put("VRModeProjectionSphere", 201);
        dkI.put("VRModeProjectionDome180", 202);
        dkI.put("VRModeProjectionDome230", 203);
        dkI.put("VRModeProjectionDome180Upper", 204);
        dkI.put("VRModeProjectionDome230Upper", 205);
        dkI.put("VRModeProjectionPlaneFit", 207);
        dkI.put("VRModeProjectionPlaneCrop", Integer.valueOf((int) FAUEnum.PR_ANIMATE_FAILED));
        dkI.put("VRModeProjectionPlaneFull", Integer.valueOf((int) FAUEnum.PR_TIMEOUT));
        dkI.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        dkI.put("VRModeProjectionMultiFishEyeVertical", 211);
        dkI.put("VRModeProjectionStereoSphereHorizontal", 212);
        dkI.put("VRModeProjectionStereoSphereVertical", 213);
        dkI.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        dkI.put("VRModeProjectionStereoPlaneFitVertical", 215);
        dkI.put("VRModeProjectionPlaneFullHorizontal", 216);
        dkI.put("VRModeProjectionPlaneFullVertical", 217);
        dkJ = new HashMap<>(2);
        dkJ.put("VRModeDisplayNormal", 101);
        dkJ.put("VRModeDisplayGlass", 102);
        dkK = new HashMap<>(5);
        dkK.put("VRModeInteractiveMotion", 1);
        dkK.put("VRModeInteractiveTouch", 2);
        dkK.put("VRModeInteractiveMotionWithTouch", 3);
        dkK.put("VRModeInteractiveGVRMotion", 4);
        dkK.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b bj(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && dkI.containsKey(optString)) {
            bVar.dkL = dkI.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && dkJ.containsKey(optString2)) {
            bVar.dkM = dkJ.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && dkK.containsKey(optString3)) {
            bVar.dkN = dkK.get(optString3).intValue();
        }
        bVar.dkO = jSONObject.optInt("fov", -1);
        bVar.dkP = jSONObject.optInt("minFov", -1);
        bVar.dkQ = jSONObject.optInt("maxFov", -1);
        bVar.dkR = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
