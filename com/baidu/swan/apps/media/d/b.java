package com.baidu.swan.apps.media.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final HashMap<String, Integer> cdI = new HashMap<>(16);
    private static final HashMap<String, Integer> cdJ;
    private static final HashMap<String, Integer> cdK;
    private int cdL = 201;
    private int cdM = 101;
    private int cdN = 3;

    static {
        cdI.put("VRModeProjectionSphere", 201);
        cdI.put("VRModeProjectionDome180", 202);
        cdI.put("VRModeProjectionDome230", 203);
        cdI.put("VRModeProjectionDome180Upper", 204);
        cdI.put("VRModeProjectionDome230Upper", 205);
        cdI.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cdI.put("VRModeProjectionPlaneCrop", 208);
        cdI.put("VRModeProjectionPlaneFull", 209);
        cdI.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cdI.put("VRModeProjectionMultiFishEyeVertical", 211);
        cdI.put("VRModeProjectionStereoSphereHorizontal", 212);
        cdI.put("VRModeProjectionStereoSphereVertical", 213);
        cdI.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cdI.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cdI.put("VRModeProjectionPlaneFullHorizontal", 216);
        cdI.put("VRModeProjectionPlaneFullVertical", 217);
        cdJ = new HashMap<>(2);
        cdJ.put("VRModeDisplayNormal", 101);
        cdJ.put("VRModeDisplayGlass", 102);
        cdK = new HashMap<>(5);
        cdK.put("VRModeInteractiveMotion", 1);
        cdK.put("VRModeInteractiveTouch", 2);
        cdK.put("VRModeInteractiveMotionWithTouch", 3);
        cdK.put("VRModeInteractiveGVRMotion", 4);
        cdK.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b aA(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cdI.containsKey(optString)) {
            bVar.cdL = cdI.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && cdJ.containsKey(optString2)) {
            bVar.cdM = cdJ.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cdK.containsKey(optString3)) {
            bVar.cdN = cdK.get(optString3).intValue();
        }
        return bVar;
    }
}
