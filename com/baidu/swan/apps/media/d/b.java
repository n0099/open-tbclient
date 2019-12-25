package com.baidu.swan.apps.media.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private static final HashMap<String, Integer> bzT = new HashMap<>(16);
    private static final HashMap<String, Integer> bzU;
    private static final HashMap<String, Integer> bzV;
    private int bzW = 201;
    private int bzX = 101;
    private int bzY = 3;

    static {
        bzT.put("VRModeProjectionSphere", 201);
        bzT.put("VRModeProjectionDome180", 202);
        bzT.put("VRModeProjectionDome230", 203);
        bzT.put("VRModeProjectionDome180Upper", 204);
        bzT.put("VRModeProjectionDome230Upper", 205);
        bzT.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        bzT.put("VRModeProjectionPlaneCrop", 208);
        bzT.put("VRModeProjectionPlaneFull", 209);
        bzT.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        bzT.put("VRModeProjectionMultiFishEyeVertical", 211);
        bzT.put("VRModeProjectionStereoSphereHorizontal", 212);
        bzT.put("VRModeProjectionStereoSphereVertical", 213);
        bzT.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        bzT.put("VRModeProjectionStereoPlaneFitVertical", 215);
        bzT.put("VRModeProjectionPlaneFullHorizontal", 216);
        bzT.put("VRModeProjectionPlaneFullVertical", 217);
        bzU = new HashMap<>(2);
        bzU.put("VRModeDisplayNormal", 101);
        bzU.put("VRModeDisplayGlass", 102);
        bzV = new HashMap<>(5);
        bzV.put("VRModeInteractiveMotion", 1);
        bzV.put("VRModeInteractiveTouch", 2);
        bzV.put("VRModeInteractiveMotionWithTouch", 3);
        bzV.put("VRModeInteractiveGVRMotion", 4);
        bzV.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b ap(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && bzT.containsKey(optString)) {
            bVar.bzW = bzT.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && bzU.containsKey(optString2)) {
            bVar.bzX = bzU.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && bzV.containsKey(optString3)) {
            bVar.bzY = bzV.get(optString3).intValue();
        }
        return bVar;
    }
}
