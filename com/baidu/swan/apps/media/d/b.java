package com.baidu.swan.apps.media.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final HashMap<String, Integer> bEO = new HashMap<>(16);
    private static final HashMap<String, Integer> bEP;
    private static final HashMap<String, Integer> bEQ;
    private int bER = 201;
    private int bES = 101;
    private int bET = 3;

    static {
        bEO.put("VRModeProjectionSphere", 201);
        bEO.put("VRModeProjectionDome180", 202);
        bEO.put("VRModeProjectionDome230", 203);
        bEO.put("VRModeProjectionDome180Upper", 204);
        bEO.put("VRModeProjectionDome230Upper", 205);
        bEO.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        bEO.put("VRModeProjectionPlaneCrop", 208);
        bEO.put("VRModeProjectionPlaneFull", 209);
        bEO.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        bEO.put("VRModeProjectionMultiFishEyeVertical", 211);
        bEO.put("VRModeProjectionStereoSphereHorizontal", 212);
        bEO.put("VRModeProjectionStereoSphereVertical", 213);
        bEO.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        bEO.put("VRModeProjectionStereoPlaneFitVertical", 215);
        bEO.put("VRModeProjectionPlaneFullHorizontal", 216);
        bEO.put("VRModeProjectionPlaneFullVertical", 217);
        bEP = new HashMap<>(2);
        bEP.put("VRModeDisplayNormal", 101);
        bEP.put("VRModeDisplayGlass", 102);
        bEQ = new HashMap<>(5);
        bEQ.put("VRModeInteractiveMotion", 1);
        bEQ.put("VRModeInteractiveTouch", 2);
        bEQ.put("VRModeInteractiveMotionWithTouch", 3);
        bEQ.put("VRModeInteractiveGVRMotion", 4);
        bEQ.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b ap(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && bEO.containsKey(optString)) {
            bVar.bER = bEO.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && bEP.containsKey(optString2)) {
            bVar.bES = bEP.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && bEQ.containsKey(optString3)) {
            bVar.bET = bEQ.get(optString3).intValue();
        }
        return bVar;
    }
}
