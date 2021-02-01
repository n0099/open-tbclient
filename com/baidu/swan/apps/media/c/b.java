package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.ar.face.algo.FAUEnum;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private static final HashMap<String, Integer> dnc = new HashMap<>(16);
    private static final HashMap<String, Integer> dnd;
    private static final HashMap<String, Integer> dne;
    private int dnf = 201;
    private int dng = 101;
    private int mInteractiveMode = 3;
    private int dnh = -1;
    private int dni = -1;
    private int dnj = -1;
    private boolean dnk = true;

    static {
        dnc.put("VRModeProjectionSphere", 201);
        dnc.put("VRModeProjectionDome180", 202);
        dnc.put("VRModeProjectionDome230", 203);
        dnc.put("VRModeProjectionDome180Upper", 204);
        dnc.put("VRModeProjectionDome230Upper", 205);
        dnc.put("VRModeProjectionPlaneFit", 207);
        dnc.put("VRModeProjectionPlaneCrop", 208);
        dnc.put("VRModeProjectionPlaneFull", Integer.valueOf((int) FAUEnum.PR_TIMEOUT));
        dnc.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        dnc.put("VRModeProjectionMultiFishEyeVertical", 211);
        dnc.put("VRModeProjectionStereoSphereHorizontal", 212);
        dnc.put("VRModeProjectionStereoSphereVertical", 213);
        dnc.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        dnc.put("VRModeProjectionStereoPlaneFitVertical", 215);
        dnc.put("VRModeProjectionPlaneFullHorizontal", 216);
        dnc.put("VRModeProjectionPlaneFullVertical", 217);
        dnd = new HashMap<>(2);
        dnd.put("VRModeDisplayNormal", 101);
        dnd.put("VRModeDisplayGlass", 102);
        dne = new HashMap<>(5);
        dne.put("VRModeInteractiveMotion", 1);
        dne.put("VRModeInteractiveTouch", 2);
        dne.put("VRModeInteractiveMotionWithTouch", 3);
        dne.put("VRModeInteractiveGVRMotion", 4);
        dne.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b bo(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && dnc.containsKey(optString)) {
            bVar.dnf = dnc.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && dnd.containsKey(optString2)) {
            bVar.dng = dnd.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && dne.containsKey(optString3)) {
            bVar.mInteractiveMode = dne.get(optString3).intValue();
        }
        bVar.dnh = jSONObject.optInt("fov", -1);
        bVar.dni = jSONObject.optInt("minFov", -1);
        bVar.dnj = jSONObject.optInt("maxFov", -1);
        bVar.dnk = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
