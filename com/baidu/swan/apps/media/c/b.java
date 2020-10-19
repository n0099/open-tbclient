package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static final HashMap<String, Integer> cQY = new HashMap<>(16);
    private static final HashMap<String, Integer> cQZ;
    private static final HashMap<String, Integer> cRa;
    private int cRb = 201;
    private int cRc = 101;
    private int cRd = 3;
    private int cRe = -1;
    private int cRf = -1;
    private int cRg = -1;
    private boolean cRh = true;

    static {
        cQY.put("VRModeProjectionSphere", 201);
        cQY.put("VRModeProjectionDome180", 202);
        cQY.put("VRModeProjectionDome230", 203);
        cQY.put("VRModeProjectionDome180Upper", 204);
        cQY.put("VRModeProjectionDome230Upper", 205);
        cQY.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cQY.put("VRModeProjectionPlaneCrop", 208);
        cQY.put("VRModeProjectionPlaneFull", 209);
        cQY.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cQY.put("VRModeProjectionMultiFishEyeVertical", 211);
        cQY.put("VRModeProjectionStereoSphereHorizontal", 212);
        cQY.put("VRModeProjectionStereoSphereVertical", 213);
        cQY.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cQY.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cQY.put("VRModeProjectionPlaneFullHorizontal", 216);
        cQY.put("VRModeProjectionPlaneFullVertical", 217);
        cQZ = new HashMap<>(2);
        cQZ.put("VRModeDisplayNormal", 101);
        cQZ.put("VRModeDisplayGlass", 102);
        cRa = new HashMap<>(5);
        cRa.put("VRModeInteractiveMotion", 1);
        cRa.put("VRModeInteractiveTouch", 2);
        cRa.put("VRModeInteractiveMotionWithTouch", 3);
        cRa.put("VRModeInteractiveGVRMotion", 4);
        cRa.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b be(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cQY.containsKey(optString)) {
            bVar.cRb = cQY.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && cQZ.containsKey(optString2)) {
            bVar.cRc = cQZ.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cRa.containsKey(optString3)) {
            bVar.cRd = cRa.get(optString3).intValue();
        }
        bVar.cRe = jSONObject.optInt("fov", -1);
        bVar.cRf = jSONObject.optInt("minFov", -1);
        bVar.cRg = jSONObject.optInt("maxFov", -1);
        bVar.cRh = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
