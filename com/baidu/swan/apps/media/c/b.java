package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static final HashMap<String, Integer> cZu = new HashMap<>(16);
    private static final HashMap<String, Integer> cZv;
    private static final HashMap<String, Integer> cZw;
    private int cZx = 201;
    private int cZy = 101;
    private int cZz = 3;
    private int cZA = -1;
    private int cZB = -1;
    private int cZC = -1;
    private boolean cZD = true;

    static {
        cZu.put("VRModeProjectionSphere", 201);
        cZu.put("VRModeProjectionDome180", 202);
        cZu.put("VRModeProjectionDome230", 203);
        cZu.put("VRModeProjectionDome180Upper", 204);
        cZu.put("VRModeProjectionDome230Upper", 205);
        cZu.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cZu.put("VRModeProjectionPlaneCrop", 208);
        cZu.put("VRModeProjectionPlaneFull", 209);
        cZu.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cZu.put("VRModeProjectionMultiFishEyeVertical", 211);
        cZu.put("VRModeProjectionStereoSphereHorizontal", 212);
        cZu.put("VRModeProjectionStereoSphereVertical", 213);
        cZu.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cZu.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cZu.put("VRModeProjectionPlaneFullHorizontal", 216);
        cZu.put("VRModeProjectionPlaneFullVertical", 217);
        cZv = new HashMap<>(2);
        cZv.put("VRModeDisplayNormal", 101);
        cZv.put("VRModeDisplayGlass", 102);
        cZw = new HashMap<>(5);
        cZw.put("VRModeInteractiveMotion", 1);
        cZw.put("VRModeInteractiveTouch", 2);
        cZw.put("VRModeInteractiveMotionWithTouch", 3);
        cZw.put("VRModeInteractiveGVRMotion", 4);
        cZw.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b bh(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cZu.containsKey(optString)) {
            bVar.cZx = cZu.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && cZv.containsKey(optString2)) {
            bVar.cZy = cZv.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cZw.containsKey(optString3)) {
            bVar.cZz = cZw.get(optString3).intValue();
        }
        bVar.cZA = jSONObject.optInt("fov", -1);
        bVar.cZB = jSONObject.optInt("minFov", -1);
        bVar.cZC = jSONObject.optInt("maxFov", -1);
        bVar.cZD = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
