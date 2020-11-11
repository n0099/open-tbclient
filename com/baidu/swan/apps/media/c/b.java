package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static final HashMap<String, Integer> dfr = new HashMap<>(16);
    private static final HashMap<String, Integer> dfs;
    private static final HashMap<String, Integer> dft;
    private int dfu = 201;
    private int dfv = 101;
    private int dfw = 3;
    private int dfx = -1;
    private int dfy = -1;
    private int dfz = -1;
    private boolean dfA = true;

    static {
        dfr.put("VRModeProjectionSphere", 201);
        dfr.put("VRModeProjectionDome180", 202);
        dfr.put("VRModeProjectionDome230", 203);
        dfr.put("VRModeProjectionDome180Upper", 204);
        dfr.put("VRModeProjectionDome230Upper", 205);
        dfr.put("VRModeProjectionPlaneFit", Integer.valueOf((int) HttpStatus.SC_MULTI_STATUS));
        dfr.put("VRModeProjectionPlaneCrop", 208);
        dfr.put("VRModeProjectionPlaneFull", 209);
        dfr.put("VRModeProjectionMultiFishEyeHorizontal", Integer.valueOf((int) Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST));
        dfr.put("VRModeProjectionMultiFishEyeVertical", 211);
        dfr.put("VRModeProjectionStereoSphereHorizontal", 212);
        dfr.put("VRModeProjectionStereoSphereVertical", 213);
        dfr.put("VRModeProjectionStereoPlaneFitHorizontal", 214);
        dfr.put("VRModeProjectionStereoPlaneFitVertical", 215);
        dfr.put("VRModeProjectionPlaneFullHorizontal", 216);
        dfr.put("VRModeProjectionPlaneFullVertical", 217);
        dfs = new HashMap<>(2);
        dfs.put("VRModeDisplayNormal", 101);
        dfs.put("VRModeDisplayGlass", 102);
        dft = new HashMap<>(5);
        dft.put("VRModeInteractiveMotion", 1);
        dft.put("VRModeInteractiveTouch", 2);
        dft.put("VRModeInteractiveMotionWithTouch", 3);
        dft.put("VRModeInteractiveGVRMotion", 4);
        dft.put("VRModeInteractiveGVRMotionWithTouch", 5);
    }

    public b bn(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("projectionMode");
        if (!TextUtils.isEmpty(optString) && dfr.containsKey(optString)) {
            bVar.dfu = dfr.get(optString).intValue();
        }
        String optString2 = jSONObject.optString("displayMode");
        if (!TextUtils.isEmpty(optString2) && dfs.containsKey(optString2)) {
            bVar.dfv = dfs.get(optString2).intValue();
        }
        String optString3 = jSONObject.optString("interactiveMode");
        if (!TextUtils.isEmpty(optString3) && dft.containsKey(optString3)) {
            bVar.dfw = dft.get(optString3).intValue();
        }
        bVar.dfx = jSONObject.optInt("fov", -1);
        bVar.dfy = jSONObject.optInt("minFov", -1);
        bVar.dfz = jSONObject.optInt("maxFov", -1);
        bVar.dfA = jSONObject.optBoolean("pinchEnable", true);
        return bVar;
    }
}
