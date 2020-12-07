package com.baidu.ar.face.a;

import android.text.TextUtils;
import com.baidu.ar.a.c;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final int[] pM = {3, 10, 10, 10, 10};
    private String pL;

    /* renamed from: com.baidu.ar.face.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0086a {
        public String pN;
        public String pO;
        public String pP;
        public String pQ;
        public String pR;
        public String pS;
        public String pT;

        public C0086a() {
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public int[] ot;
        public String pV;
        public String pW;
        public String pX;
        public String pY;
        public String pZ;
        public String qa;
        public String qb;
        public String qc;
        public C0086a qd;
        public C0086a qe;
        public C0086a qf;
        public int qg;

        public b() {
        }
    }

    private void a(b bVar, JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("customize");
        bVar.qg = 0;
        bVar.ot = pM;
        if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("algo")) == null || (optJSONObject2 = optJSONObject.optJSONObject("algo_face")) == null) {
            return;
        }
        String optString = optJSONObject2.optString("level");
        if (!TextUtils.isEmpty(optString)) {
            if (optString.equals("high")) {
                bVar.qg = 2;
            } else if (optString.equals("medium")) {
                bVar.qg = 1;
            } else if (optString.equals("mediumlow")) {
                bVar.qg = 0;
            } else if (optString.equals(Config.EXCEPTION_MEMORY_LOW)) {
                bVar.qg = 0;
            }
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("detect_rate");
        if (optJSONArray == null || optJSONArray.length() < 5) {
            return;
        }
        try {
            int[] iArr = new int[5];
            for (int i = 0; i < 5; i++) {
                iArr[i] = optJSONArray.getInt(i) < pM[i] ? pM[i] : optJSONArray.getInt(i);
            }
            bVar.ot = iArr;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private b b(String str, JSONObject jSONObject) {
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            bVar.pV = this.pL + jSONObject2.getString("detect_model");
            bVar.pW = this.pL + jSONObject2.getString("animate");
            bVar.qa = this.pL + jSONObject2.getString("expression");
            bVar.pX = this.pL + jSONObject2.getString("track1_heavy");
            bVar.pY = this.pL + jSONObject2.getString("track1_medium");
            bVar.pZ = this.pL + jSONObject2.getString("track1_lite");
            bVar.qb = this.pL + jSONObject2.getString(com.baidu.pass.biometrics.face.liveness.c.a.i);
            bVar.qc = this.pL + jSONObject2.getString("gender");
            bVar.qf = f(jSONObject2.getJSONObject("high_device_model"));
            bVar.qe = f(jSONObject2.getJSONObject("medium_device_model"));
            bVar.qd = f(jSONObject2.getJSONObject("low_device_model"));
            if (jSONObject == null) {
                bVar.qg = c.ag();
                bVar.ot = pM;
            } else {
                a(bVar, jSONObject);
            }
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private C0086a f(JSONObject jSONObject) {
        C0086a c0086a = new C0086a();
        try {
            c0086a.pN = jSONObject.getString("track_param_0");
            if (TextUtils.isEmpty(c0086a.pN)) {
                c0086a.pN = "";
            } else {
                c0086a.pN = this.pL + c0086a.pN;
            }
            c0086a.pO = jSONObject.getString("track_param_1");
            if (TextUtils.isEmpty(c0086a.pO)) {
                c0086a.pO = "";
            } else {
                c0086a.pO = this.pL + c0086a.pO;
            }
            c0086a.pP = jSONObject.getString("track_param_2");
            if (TextUtils.isEmpty(c0086a.pP)) {
                c0086a.pP = "";
            } else {
                c0086a.pP = this.pL + c0086a.pP;
            }
            c0086a.pQ = jSONObject.getString("track_param_3");
            if (TextUtils.isEmpty(c0086a.pQ)) {
                c0086a.pQ = "";
            } else {
                c0086a.pQ = this.pL + c0086a.pQ;
            }
            c0086a.pR = jSONObject.getString("trackingSmoothAlpha");
            c0086a.pS = jSONObject.getString("trackingSmoothThreshold");
            c0086a.pT = jSONObject.getString("trackingMouthThreshold");
            return c0086a;
        } catch (JSONException e) {
            com.baidu.ar.h.b.b("FaceModelConfig", "parse DeviceModel error");
            e.printStackTrace();
            return null;
        }
    }

    public b a(String str, JSONObject jSONObject) {
        this.pL = str;
        return b("{\n  \"detect_model\": \"detect/enc_zhibo_0849_initsize320.lite.bin\",\n  \"animate\": \"animate/skeletonModel_v3.1.11.bin\",\n  \"expression\": \"animate/enc_exp_v0.1.5_int16.lite.bin\",\n  \"track1_heavy\": \"track/v3_pose_occlu_s_0729.lite.bin_enc\",\n  \"track1_medium\": \"track/v3_pose_occlu_s_0729.lite.bin_enc\",\n  \"track1_lite\": \"track/mPts_automl_mv3_5ms_64_pose_s_model_epoch327.lite.bin_enc\",\n  \"mouth\": \"track/enc_mouth_mv27ky_br13stm.lite.bin\",\n  \"gender\": \"attributes/gender_v1.bin\",\n  \"high_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/v3_pose_occlu_s_0729.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"medium_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/v3_pose_occlu_s_0729.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"low_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/mPts_automl_mv3_5ms_64_pose_s_model_epoch327.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  }\n}", jSONObject);
    }
}
