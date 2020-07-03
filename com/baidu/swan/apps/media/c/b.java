package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final HashMap<String, Integer> ctc = new HashMap<>(16);
    private static final HashMap<String, Integer> ctd;
    private static final HashMap<String, Integer> cte;
    private int ctf = 201;
    private int ctg = 101;
    private int cth = 3;
    private int cti = -1;
    private int ctj = -1;
    private int ctk = -1;
    private boolean ctl = true;

    static {
        ctc.put("VRModeProjectionSphere", 201);
        ctc.put("VRModeProjectionDome180", 202);
        ctc.put("VRModeProjectionDome230", 203);
        ctc.put("VRModeProjectionDome180Upper", 204);
        ctc.put("VRModeProjectionDome230Upper", 205);
        ctc.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        ctc.put("VRModeProjectionPlaneCrop", 208);
        ctc.put("VRModeProjectionPlaneFull", 209);
        ctc.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        ctc.put("VRModeProjectionMultiFishEyeVertical", 211);
        ctc.put("VRModeProjectionStereoSphereHorizontal", 212);
        ctc.put("VRModeProjectionStereoSphereVertical", 213);
        ctc.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        ctc.put("VRModeProjectionStereoPlaneFitVertical", 215);
        ctc.put("VRModeProjectionPlaneFullHorizontal", 216);
        ctc.put("VRModeProjectionPlaneFullVertical", 217);
        ctd = new HashMap<>(2);
        ctd.put("VRModeDisplayNormal", 101);
        ctd.put("VRModeDisplayGlass", 102);
        cte = new HashMap<>(5);
        cte.put("VRModeInteractiveMotion", 1);
        cte.put("VRModeInteractiveTouch", 2);
        cte.put("VRModeInteractiveMotionWithTouch", 3);
        cte.put("VRModeInteractiveGVRMotion", 4);
        cte.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b aL(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && ctc.containsKey(optString)) {
            bVar.ctf = ctc.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && ctd.containsKey(optString2)) {
            bVar.ctg = ctd.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && cte.containsKey(optString3)) {
            bVar.cth = cte.get(optString3).intValue();
        }
        bVar.cti = jSONObject.optInt("fov", -1);
        bVar.ctj = jSONObject.optInt("minFov", -1);
        bVar.ctk = jSONObject.optInt("maxFov", -1);
        bVar.ctl = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
