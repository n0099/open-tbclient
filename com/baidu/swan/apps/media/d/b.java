package com.baidu.swan.apps.media.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static final HashMap<String, Integer> bAG = new HashMap<>(16);
    private static final HashMap<String, Integer> bAH;
    private static final HashMap<String, Integer> bAI;
    private int bAJ = 201;
    private int bAK = 101;
    private int bAL = 3;

    static {
        bAG.put("VRModeProjectionSphere", 201);
        bAG.put("VRModeProjectionDome180", 202);
        bAG.put("VRModeProjectionDome230", 203);
        bAG.put("VRModeProjectionDome180Upper", 204);
        bAG.put("VRModeProjectionDome230Upper", 205);
        bAG.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        bAG.put("VRModeProjectionPlaneCrop", 208);
        bAG.put("VRModeProjectionPlaneFull", 209);
        bAG.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        bAG.put("VRModeProjectionMultiFishEyeVertical", 211);
        bAG.put("VRModeProjectionStereoSphereHorizontal", 212);
        bAG.put("VRModeProjectionStereoSphereVertical", 213);
        bAG.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        bAG.put("VRModeProjectionStereoPlaneFitVertical", 215);
        bAG.put("VRModeProjectionPlaneFullHorizontal", 216);
        bAG.put("VRModeProjectionPlaneFullVertical", 217);
        bAH = new HashMap<>(2);
        bAH.put("VRModeDisplayNormal", 101);
        bAH.put("VRModeDisplayGlass", 102);
        bAI = new HashMap<>(5);
        bAI.put("VRModeInteractiveMotion", 1);
        bAI.put("VRModeInteractiveTouch", 2);
        bAI.put("VRModeInteractiveMotionWithTouch", 3);
        bAI.put("VRModeInteractiveGVRMotion", 4);
        bAI.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b ap(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && bAG.containsKey(optString)) {
            bVar.bAJ = bAG.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && bAH.containsKey(optString2)) {
            bVar.bAK = bAH.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && bAI.containsKey(optString3)) {
            bVar.bAL = bAI.get(optString3).intValue();
        }
        return bVar;
    }
}
