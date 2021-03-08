package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.ar.face.algo.FAUEnum;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static final HashMap<String, Integer> doG = new HashMap<>(16);
    private static final HashMap<String, Integer> doH;
    private static final HashMap<String, Integer> doI;
    private int doJ = 201;
    private int doK = 101;
    private int mInteractiveMode = 3;
    private int doL = -1;
    private int doM = -1;
    private int doN = -1;
    private boolean doO = true;

    static {
        doG.put("VRModeProjectionSphere", 201);
        doG.put("VRModeProjectionDome180", 202);
        doG.put("VRModeProjectionDome230", 203);
        doG.put("VRModeProjectionDome180Upper", 204);
        doG.put("VRModeProjectionDome230Upper", 205);
        doG.put("VRModeProjectionPlaneFit", 207);
        doG.put("VRModeProjectionPlaneCrop", 208);
        doG.put("VRModeProjectionPlaneFull", Integer.valueOf((int) FAUEnum.PR_TIMEOUT));
        doG.put("VRModeProjectionMultiFishEyeHorizontal", 210);
        doG.put("VRModeProjectionMultiFishEyeVertical", 211);
        doG.put("VRModeProjectionStereoSphereHorizontal", 212);
        doG.put("VRModeProjectionStereoSphereVertical", 213);
        doG.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        doG.put("VRModeProjectionStereoPlaneFitVertical", 215);
        doG.put("VRModeProjectionPlaneFullHorizontal", 216);
        doG.put("VRModeProjectionPlaneFullVertical", 217);
        doH = new HashMap<>(2);
        doH.put("VRModeDisplayNormal", 101);
        doH.put("VRModeDisplayGlass", 102);
        doI = new HashMap<>(5);
        doI.put("VRModeInteractiveMotion", 1);
        doI.put("VRModeInteractiveTouch", 2);
        doI.put("VRModeInteractiveMotionWithTouch", 3);
        doI.put("VRModeInteractiveGVRMotion", 4);
        doI.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b bq(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && doG.containsKey(optString)) {
            bVar.doJ = doG.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && doH.containsKey(optString2)) {
            bVar.doK = doH.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && doI.containsKey(optString3)) {
            bVar.mInteractiveMode = doI.get(optString3).intValue();
        }
        bVar.doL = jSONObject.optInt("fov", -1);
        bVar.doM = jSONObject.optInt("minFov", -1);
        bVar.doN = jSONObject.optInt("maxFov", -1);
        bVar.doO = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
