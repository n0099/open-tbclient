package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static final HashMap<String, Integer> cCU = new HashMap<>(16);
    private static final HashMap<String, Integer> cCV;
    private static final HashMap<String, Integer> cCW;
    private int cCX = 201;
    private int cCY = 101;
    private int cCZ = 3;
    private int cDa = -1;
    private int cDb = -1;
    private int cDc = -1;
    private boolean cDd = true;

    static {
        cCU.put("VRModeProjectionSphere", 201);
        cCU.put("VRModeProjectionDome180", 202);
        cCU.put("VRModeProjectionDome230", 203);
        cCU.put("VRModeProjectionDome180Upper", 204);
        cCU.put("VRModeProjectionDome230Upper", 205);
        cCU.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cCU.put("VRModeProjectionPlaneCrop", 208);
        cCU.put("VRModeProjectionPlaneFull", 209);
        cCU.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cCU.put("VRModeProjectionMultiFishEyeVertical", 211);
        cCU.put("VRModeProjectionStereoSphereHorizontal", 212);
        cCU.put("VRModeProjectionStereoSphereVertical", 213);
        cCU.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cCU.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cCU.put("VRModeProjectionPlaneFullHorizontal", 216);
        cCU.put("VRModeProjectionPlaneFullVertical", 217);
        cCV = new HashMap<>(2);
        cCV.put("VRModeDisplayNormal", 101);
        cCV.put("VRModeDisplayGlass", 102);
        cCW = new HashMap<>(5);
        cCW.put("VRModeInteractiveMotion", 1);
        cCW.put("VRModeInteractiveTouch", 2);
        cCW.put("VRModeInteractiveMotionWithTouch", 3);
        cCW.put("VRModeInteractiveGVRMotion", 4);
        cCW.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b aU(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cCU.containsKey(optString)) {
            bVar.cCX = cCU.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && cCV.containsKey(optString2)) {
            bVar.cCY = cCV.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cCW.containsKey(optString3)) {
            bVar.cCZ = cCW.get(optString3).intValue();
        }
        bVar.cDa = jSONObject.optInt("fov", -1);
        bVar.cDb = jSONObject.optInt("minFov", -1);
        bVar.cDc = jSONObject.optInt("maxFov", -1);
        bVar.cDd = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
