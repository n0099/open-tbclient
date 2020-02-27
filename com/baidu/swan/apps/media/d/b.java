package com.baidu.swan.apps.media.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final HashMap<String, Integer> bEM = new HashMap<>(16);
    private static final HashMap<String, Integer> bEN;
    private static final HashMap<String, Integer> bEO;
    private int bEP = 201;
    private int bEQ = 101;
    private int bER = 3;

    static {
        bEM.put("VRModeProjectionSphere", 201);
        bEM.put("VRModeProjectionDome180", 202);
        bEM.put("VRModeProjectionDome230", 203);
        bEM.put("VRModeProjectionDome180Upper", 204);
        bEM.put("VRModeProjectionDome230Upper", 205);
        bEM.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        bEM.put("VRModeProjectionPlaneCrop", 208);
        bEM.put("VRModeProjectionPlaneFull", 209);
        bEM.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        bEM.put("VRModeProjectionMultiFishEyeVertical", 211);
        bEM.put("VRModeProjectionStereoSphereHorizontal", 212);
        bEM.put("VRModeProjectionStereoSphereVertical", 213);
        bEM.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        bEM.put("VRModeProjectionStereoPlaneFitVertical", 215);
        bEM.put("VRModeProjectionPlaneFullHorizontal", 216);
        bEM.put("VRModeProjectionPlaneFullVertical", 217);
        bEN = new HashMap<>(2);
        bEN.put("VRModeDisplayNormal", 101);
        bEN.put("VRModeDisplayGlass", 102);
        bEO = new HashMap<>(5);
        bEO.put("VRModeInteractiveMotion", 1);
        bEO.put("VRModeInteractiveTouch", 2);
        bEO.put("VRModeInteractiveMotionWithTouch", 3);
        bEO.put("VRModeInteractiveGVRMotion", 4);
        bEO.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b ap(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && bEM.containsKey(optString)) {
            bVar.bEP = bEM.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && bEN.containsKey(optString2)) {
            bVar.bEQ = bEN.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && bEO.containsKey(optString3)) {
            bVar.bER = bEO.get(optString3).intValue();
        }
        return bVar;
    }
}
