package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.ar.face.algo.FAUEnum;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static final HashMap<String, Integer> dkS = new HashMap<>(16);
    private static final HashMap<String, Integer> dkT;
    private static final HashMap<String, Integer> dkU;
    private int dkV = 201;
    private int dkW = 101;
    private int mInteractiveMode = 3;
    private int dkX = -1;
    private int dkY = -1;
    private int dkZ = -1;
    private boolean dla = true;

    static {
        dkS.put("VRModeProjectionSphere", 201);
        dkS.put("VRModeProjectionDome180", 202);
        dkS.put("VRModeProjectionDome230", 203);
        dkS.put("VRModeProjectionDome180Upper", 204);
        dkS.put("VRModeProjectionDome230Upper", 205);
        dkS.put("VRModeProjectionPlaneFit", 207);
        dkS.put("VRModeProjectionPlaneCrop", 208);
        dkS.put("VRModeProjectionPlaneFull", Integer.valueOf((int) FAUEnum.PR_TIMEOUT));
        dkS.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        dkS.put("VRModeProjectionMultiFishEyeVertical", 211);
        dkS.put("VRModeProjectionStereoSphereHorizontal", 212);
        dkS.put("VRModeProjectionStereoSphereVertical", 213);
        dkS.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        dkS.put("VRModeProjectionStereoPlaneFitVertical", 215);
        dkS.put("VRModeProjectionPlaneFullHorizontal", 216);
        dkS.put("VRModeProjectionPlaneFullVertical", 217);
        dkT = new HashMap<>(2);
        dkT.put("VRModeDisplayNormal", 101);
        dkT.put("VRModeDisplayGlass", 102);
        dkU = new HashMap<>(5);
        dkU.put("VRModeInteractiveMotion", 1);
        dkU.put("VRModeInteractiveTouch", 2);
        dkU.put("VRModeInteractiveMotionWithTouch", 3);
        dkU.put("VRModeInteractiveGVRMotion", 4);
        dkU.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b br(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && dkS.containsKey(optString)) {
            bVar.dkV = dkS.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && dkT.containsKey(optString2)) {
            bVar.dkW = dkT.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && dkU.containsKey(optString3)) {
            bVar.mInteractiveMode = dkU.get(optString3).intValue();
        }
        bVar.dkX = jSONObject.optInt("fov", -1);
        bVar.dkY = jSONObject.optInt("minFov", -1);
        bVar.dkZ = jSONObject.optInt("maxFov", -1);
        bVar.dla = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
