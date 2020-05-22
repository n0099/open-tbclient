package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final HashMap<String, Integer> cop = new HashMap<>(16);
    private static final HashMap<String, Integer> coq;
    private static final HashMap<String, Integer> cor;
    private int cos = 201;
    private int cot = 101;
    private int cou = 3;
    private int cov = -1;
    private int cow = -1;
    private int cox = -1;
    private boolean coy = true;

    static {
        cop.put("VRModeProjectionSphere", 201);
        cop.put("VRModeProjectionDome180", 202);
        cop.put("VRModeProjectionDome230", 203);
        cop.put("VRModeProjectionDome180Upper", 204);
        cop.put("VRModeProjectionDome230Upper", 205);
        cop.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cop.put("VRModeProjectionPlaneCrop", 208);
        cop.put("VRModeProjectionPlaneFull", 209);
        cop.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cop.put("VRModeProjectionMultiFishEyeVertical", 211);
        cop.put("VRModeProjectionStereoSphereHorizontal", 212);
        cop.put("VRModeProjectionStereoSphereVertical", 213);
        cop.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cop.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cop.put("VRModeProjectionPlaneFullHorizontal", 216);
        cop.put("VRModeProjectionPlaneFullVertical", 217);
        coq = new HashMap<>(2);
        coq.put("VRModeDisplayNormal", 101);
        coq.put("VRModeDisplayGlass", 102);
        cor = new HashMap<>(5);
        cor.put("VRModeInteractiveMotion", 1);
        cor.put("VRModeInteractiveTouch", 2);
        cor.put("VRModeInteractiveMotionWithTouch", 3);
        cor.put("VRModeInteractiveGVRMotion", 4);
        cor.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b aE(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cop.containsKey(optString)) {
            bVar.cos = cop.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && coq.containsKey(optString2)) {
            bVar.cot = coq.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cor.containsKey(optString3)) {
            bVar.cou = cor.get(optString3).intValue();
        }
        bVar.cov = jSONObject.optInt("fov", -1);
        bVar.cow = jSONObject.optInt("minFov", -1);
        bVar.cox = jSONObject.optInt("maxFov", -1);
        bVar.coy = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
