package com.baidu.swan.apps.media.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final HashMap<String, Integer> bEZ = new HashMap<>(16);
    private static final HashMap<String, Integer> bFa;
    private static final HashMap<String, Integer> bFb;
    private int bFc = 201;
    private int bFd = 101;
    private int bFe = 3;

    static {
        bEZ.put("VRModeProjectionSphere", 201);
        bEZ.put("VRModeProjectionDome180", 202);
        bEZ.put("VRModeProjectionDome230", 203);
        bEZ.put("VRModeProjectionDome180Upper", 204);
        bEZ.put("VRModeProjectionDome230Upper", 205);
        bEZ.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        bEZ.put("VRModeProjectionPlaneCrop", 208);
        bEZ.put("VRModeProjectionPlaneFull", 209);
        bEZ.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        bEZ.put("VRModeProjectionMultiFishEyeVertical", 211);
        bEZ.put("VRModeProjectionStereoSphereHorizontal", 212);
        bEZ.put("VRModeProjectionStereoSphereVertical", 213);
        bEZ.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        bEZ.put("VRModeProjectionStereoPlaneFitVertical", 215);
        bEZ.put("VRModeProjectionPlaneFullHorizontal", 216);
        bEZ.put("VRModeProjectionPlaneFullVertical", 217);
        bFa = new HashMap<>(2);
        bFa.put("VRModeDisplayNormal", 101);
        bFa.put("VRModeDisplayGlass", 102);
        bFb = new HashMap<>(5);
        bFb.put("VRModeInteractiveMotion", 1);
        bFb.put("VRModeInteractiveTouch", 2);
        bFb.put("VRModeInteractiveMotionWithTouch", 3);
        bFb.put("VRModeInteractiveGVRMotion", 4);
        bFb.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b ap(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && bEZ.containsKey(optString)) {
            bVar.bFc = bEZ.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && bFa.containsKey(optString2)) {
            bVar.bFd = bFa.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && bFb.containsKey(optString3)) {
            bVar.bFe = bFb.get(optString3).intValue();
        }
        return bVar;
    }
}
