package com.baidu.swan.apps.media.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final HashMap<String, Integer> bEN = new HashMap<>(16);
    private static final HashMap<String, Integer> bEO;
    private static final HashMap<String, Integer> bEP;
    private int bEQ = 201;
    private int bER = 101;
    private int bES = 3;

    static {
        bEN.put("VRModeProjectionSphere", 201);
        bEN.put("VRModeProjectionDome180", 202);
        bEN.put("VRModeProjectionDome230", 203);
        bEN.put("VRModeProjectionDome180Upper", 204);
        bEN.put("VRModeProjectionDome230Upper", 205);
        bEN.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        bEN.put("VRModeProjectionPlaneCrop", 208);
        bEN.put("VRModeProjectionPlaneFull", 209);
        bEN.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        bEN.put("VRModeProjectionMultiFishEyeVertical", 211);
        bEN.put("VRModeProjectionStereoSphereHorizontal", 212);
        bEN.put("VRModeProjectionStereoSphereVertical", 213);
        bEN.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        bEN.put("VRModeProjectionStereoPlaneFitVertical", 215);
        bEN.put("VRModeProjectionPlaneFullHorizontal", 216);
        bEN.put("VRModeProjectionPlaneFullVertical", 217);
        bEO = new HashMap<>(2);
        bEO.put("VRModeDisplayNormal", 101);
        bEO.put("VRModeDisplayGlass", 102);
        bEP = new HashMap<>(5);
        bEP.put("VRModeInteractiveMotion", 1);
        bEP.put("VRModeInteractiveTouch", 2);
        bEP.put("VRModeInteractiveMotionWithTouch", 3);
        bEP.put("VRModeInteractiveGVRMotion", 4);
        bEP.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b ap(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && bEN.containsKey(optString)) {
            bVar.bEQ = bEN.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && bEO.containsKey(optString2)) {
            bVar.bER = bEO.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && bEP.containsKey(optString3)) {
            bVar.bES = bEP.get(optString3).intValue();
        }
        return bVar;
    }
}
