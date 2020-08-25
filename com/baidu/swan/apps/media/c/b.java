package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static final HashMap<String, Integer> cCQ = new HashMap<>(16);
    private static final HashMap<String, Integer> cCR;
    private static final HashMap<String, Integer> cCS;
    private int cCT = 201;
    private int cCU = 101;
    private int cCV = 3;
    private int cCW = -1;
    private int cCX = -1;
    private int cCY = -1;
    private boolean cCZ = true;

    static {
        cCQ.put("VRModeProjectionSphere", 201);
        cCQ.put("VRModeProjectionDome180", 202);
        cCQ.put("VRModeProjectionDome230", 203);
        cCQ.put("VRModeProjectionDome180Upper", 204);
        cCQ.put("VRModeProjectionDome230Upper", 205);
        cCQ.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cCQ.put("VRModeProjectionPlaneCrop", 208);
        cCQ.put("VRModeProjectionPlaneFull", 209);
        cCQ.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cCQ.put("VRModeProjectionMultiFishEyeVertical", 211);
        cCQ.put("VRModeProjectionStereoSphereHorizontal", 212);
        cCQ.put("VRModeProjectionStereoSphereVertical", 213);
        cCQ.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cCQ.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cCQ.put("VRModeProjectionPlaneFullHorizontal", 216);
        cCQ.put("VRModeProjectionPlaneFullVertical", 217);
        cCR = new HashMap<>(2);
        cCR.put("VRModeDisplayNormal", 101);
        cCR.put("VRModeDisplayGlass", 102);
        cCS = new HashMap<>(5);
        cCS.put("VRModeInteractiveMotion", 1);
        cCS.put("VRModeInteractiveTouch", 2);
        cCS.put("VRModeInteractiveMotionWithTouch", 3);
        cCS.put("VRModeInteractiveGVRMotion", 4);
        cCS.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b aU(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cCQ.containsKey(optString)) {
            bVar.cCT = cCQ.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && cCR.containsKey(optString2)) {
            bVar.cCU = cCR.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cCS.containsKey(optString3)) {
            bVar.cCV = cCS.get(optString3).intValue();
        }
        bVar.cCW = jSONObject.optInt("fov", -1);
        bVar.cCX = jSONObject.optInt("minFov", -1);
        bVar.cCY = jSONObject.optInt("maxFov", -1);
        bVar.cCZ = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
