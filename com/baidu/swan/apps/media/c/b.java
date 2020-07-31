package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private static final HashMap<String, Integer> cvg = new HashMap<>(16);
    private static final HashMap<String, Integer> cvh;
    private static final HashMap<String, Integer> cvi;
    private int cvj = 201;
    private int cvk = 101;
    private int cvl = 3;
    private int cvm = -1;
    private int cvn = -1;
    private int cvo = -1;
    private boolean cvp = true;

    static {
        cvg.put("VRModeProjectionSphere", 201);
        cvg.put("VRModeProjectionDome180", 202);
        cvg.put("VRModeProjectionDome230", 203);
        cvg.put("VRModeProjectionDome180Upper", 204);
        cvg.put("VRModeProjectionDome230Upper", 205);
        cvg.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        cvg.put("VRModeProjectionPlaneCrop", 208);
        cvg.put("VRModeProjectionPlaneFull", 209);
        cvg.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        cvg.put("VRModeProjectionMultiFishEyeVertical", 211);
        cvg.put("VRModeProjectionStereoSphereHorizontal", 212);
        cvg.put("VRModeProjectionStereoSphereVertical", 213);
        cvg.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        cvg.put("VRModeProjectionStereoPlaneFitVertical", 215);
        cvg.put("VRModeProjectionPlaneFullHorizontal", 216);
        cvg.put("VRModeProjectionPlaneFullVertical", 217);
        cvh = new HashMap<>(2);
        cvh.put("VRModeDisplayNormal", 101);
        cvh.put("VRModeDisplayGlass", 102);
        cvi = new HashMap<>(5);
        cvi.put("VRModeInteractiveMotion", 1);
        cvi.put("VRModeInteractiveTouch", 2);
        cvi.put("VRModeInteractiveMotionWithTouch", 3);
        cvi.put("VRModeInteractiveGVRMotion", 4);
        cvi.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b aO(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && cvg.containsKey(optString)) {
            bVar.cvj = cvg.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && cvh.containsKey(optString2)) {
            bVar.cvk = cvh.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cvi.containsKey(optString3)) {
            bVar.cvl = cvi.get(optString3).intValue();
        }
        bVar.cvm = jSONObject.optInt("fov", -1);
        bVar.cvn = jSONObject.optInt("minFov", -1);
        bVar.cvo = jSONObject.optInt("maxFov", -1);
        bVar.cvp = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
