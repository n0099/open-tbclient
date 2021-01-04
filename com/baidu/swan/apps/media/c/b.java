package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.ar.face.algo.FAUEnum;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private static final HashMap<String, Integer> dpI = new HashMap<>(16);
    private static final HashMap<String, Integer> dpJ;
    private static final HashMap<String, Integer> dpK;
    private int dpL = 201;
    private int dpM = 101;
    private int mInteractiveMode = 3;
    private int dpN = -1;
    private int dpO = -1;
    private int dpP = -1;
    private boolean dpQ = true;

    static {
        dpI.put("VRModeProjectionSphere", 201);
        dpI.put("VRModeProjectionDome180", 202);
        dpI.put("VRModeProjectionDome230", 203);
        dpI.put("VRModeProjectionDome180Upper", 204);
        dpI.put("VRModeProjectionDome230Upper", 205);
        dpI.put("VRModeProjectionPlaneFit", 207);
        dpI.put("VRModeProjectionPlaneCrop", 208);
        dpI.put("VRModeProjectionPlaneFull", Integer.valueOf((int) FAUEnum.PR_TIMEOUT));
        dpI.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        dpI.put("VRModeProjectionMultiFishEyeVertical", 211);
        dpI.put("VRModeProjectionStereoSphereHorizontal", 212);
        dpI.put("VRModeProjectionStereoSphereVertical", 213);
        dpI.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        dpI.put("VRModeProjectionStereoPlaneFitVertical", 215);
        dpI.put("VRModeProjectionPlaneFullHorizontal", 216);
        dpI.put("VRModeProjectionPlaneFullVertical", 217);
        dpJ = new HashMap<>(2);
        dpJ.put("VRModeDisplayNormal", 101);
        dpJ.put("VRModeDisplayGlass", 102);
        dpK = new HashMap<>(5);
        dpK.put("VRModeInteractiveMotion", 1);
        dpK.put("VRModeInteractiveTouch", 2);
        dpK.put("VRModeInteractiveMotionWithTouch", 3);
        dpK.put("VRModeInteractiveGVRMotion", 4);
        dpK.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b br(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && dpI.containsKey(optString)) {
            bVar.dpL = dpI.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && dpJ.containsKey(optString2)) {
            bVar.dpM = dpJ.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && dpK.containsKey(optString3)) {
            bVar.mInteractiveMode = dpK.get(optString3).intValue();
        }
        bVar.dpN = jSONObject.optInt("fov", -1);
        bVar.dpO = jSONObject.optInt("minFov", -1);
        bVar.dpP = jSONObject.optInt("maxFov", -1);
        bVar.dpQ = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
