package com.baidu.swan.apps.media.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final HashMap<String, Integer> cdO = new HashMap<>(16);
    private static final HashMap<String, Integer> cdP;
    private static final HashMap<String, Integer> cdQ;
    private int cdR = 201;
    private int cdS = 101;
    private int cdT = 3;

    static {
        cdO.put("VRModeProjectionSphere", 201);
        cdO.put("VRModeProjectionDome180", 202);
        cdO.put("VRModeProjectionDome230", 203);
        cdO.put("VRModeProjectionDome180Upper", 204);
        cdO.put("VRModeProjectionDome230Upper", 205);
        cdO.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cdO.put("VRModeProjectionPlaneCrop", 208);
        cdO.put("VRModeProjectionPlaneFull", 209);
        cdO.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cdO.put("VRModeProjectionMultiFishEyeVertical", 211);
        cdO.put("VRModeProjectionStereoSphereHorizontal", 212);
        cdO.put("VRModeProjectionStereoSphereVertical", 213);
        cdO.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cdO.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cdO.put("VRModeProjectionPlaneFullHorizontal", 216);
        cdO.put("VRModeProjectionPlaneFullVertical", 217);
        cdP = new HashMap<>(2);
        cdP.put("VRModeDisplayNormal", 101);
        cdP.put("VRModeDisplayGlass", 102);
        cdQ = new HashMap<>(5);
        cdQ.put("VRModeInteractiveMotion", 1);
        cdQ.put("VRModeInteractiveTouch", 2);
        cdQ.put("VRModeInteractiveMotionWithTouch", 3);
        cdQ.put("VRModeInteractiveGVRMotion", 4);
        cdQ.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b aA(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cdO.containsKey(optString)) {
            bVar.cdR = cdO.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && cdP.containsKey(optString2)) {
            bVar.cdS = cdP.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cdQ.containsKey(optString3)) {
            bVar.cdT = cdQ.get(optString3).intValue();
        }
        return bVar;
    }
}
