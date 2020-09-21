package com.baidu.ar.face.a;

import android.text.TextUtils;
import com.baidu.ar.a.c;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final int[] pw = {3, 10, 10, 10, 10};
    private String pv;

    /* renamed from: com.baidu.ar.face.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0083a {
        public String pA;
        public String pB;
        public String pC;
        public String pD;
        public String px;
        public String py;
        public String pz;

        public C0083a() {
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public int[] od;
        public String pF;
        public String pG;
        public String pH;
        public String pI;
        public String pJ;
        public String pK;
        public String pL;
        public String pM;
        public C0083a pN;
        public C0083a pO;
        public C0083a pP;
        public int pQ;

        public b() {
        }
    }

    private void a(b bVar, JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("customize");
        bVar.pQ = 0;
        bVar.od = pw;
        if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("algo")) == null || (optJSONObject2 = optJSONObject.optJSONObject("algo_face")) == null) {
            return;
        }
        String optString = optJSONObject2.optString("level");
        if (!TextUtils.isEmpty(optString)) {
            if (optString.equals("high")) {
                bVar.pQ = 2;
            } else if (optString.equals("medium")) {
                bVar.pQ = 1;
            } else if (optString.equals("mediumlow")) {
                bVar.pQ = 0;
            } else if (optString.equals(Config.EXCEPTION_MEMORY_LOW)) {
                bVar.pQ = 0;
            }
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("detect_rate");
        if (optJSONArray == null || optJSONArray.length() < 5) {
            return;
        }
        try {
            int[] iArr = new int[5];
            for (int i = 0; i < 5; i++) {
                iArr[i] = optJSONArray.getInt(i) < pw[i] ? pw[i] : optJSONArray.getInt(i);
            }
            bVar.od = iArr;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private b b(String str, JSONObject jSONObject) {
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            bVar.pF = this.pv + jSONObject2.getString("detect_model");
            bVar.pG = this.pv + jSONObject2.getString("animate");
            bVar.pK = this.pv + jSONObject2.getString("expression");
            bVar.pH = this.pv + jSONObject2.getString("track1_heavy");
            bVar.pI = this.pv + jSONObject2.getString("track1_medium");
            bVar.pJ = this.pv + jSONObject2.getString("track1_lite");
            bVar.pL = this.pv + jSONObject2.getString(com.baidu.pass.biometrics.face.liveness.c.a.i);
            bVar.pM = this.pv + jSONObject2.getString("gender");
            bVar.pP = f(jSONObject2.getJSONObject("high_device_model"));
            bVar.pO = f(jSONObject2.getJSONObject("medium_device_model"));
            bVar.pN = f(jSONObject2.getJSONObject("low_device_model"));
            if (jSONObject == null) {
                bVar.pQ = c.ae();
                bVar.od = pw;
            } else {
                a(bVar, jSONObject);
            }
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private C0083a f(JSONObject jSONObject) {
        C0083a c0083a = new C0083a();
        try {
            c0083a.px = jSONObject.getString("track_param_0");
            if (TextUtils.isEmpty(c0083a.px)) {
                c0083a.px = "";
            } else {
                c0083a.px = this.pv + c0083a.px;
            }
            c0083a.py = jSONObject.getString("track_param_1");
            if (TextUtils.isEmpty(c0083a.py)) {
                c0083a.py = "";
            } else {
                c0083a.py = this.pv + c0083a.py;
            }
            c0083a.pz = jSONObject.getString("track_param_2");
            if (TextUtils.isEmpty(c0083a.pz)) {
                c0083a.pz = "";
            } else {
                c0083a.pz = this.pv + c0083a.pz;
            }
            c0083a.pA = jSONObject.getString("track_param_3");
            if (TextUtils.isEmpty(c0083a.pA)) {
                c0083a.pA = "";
            } else {
                c0083a.pA = this.pv + c0083a.pA;
            }
            c0083a.pB = jSONObject.getString("trackingSmoothAlpha");
            c0083a.pC = jSONObject.getString("trackingSmoothThreshold");
            c0083a.pD = jSONObject.getString("trackingMouthThreshold");
            return c0083a;
        } catch (JSONException e) {
            com.baidu.ar.g.b.b("FaceModelConfig", "parse DeviceModel error");
            e.printStackTrace();
            return null;
        }
    }

    public b a(String str, JSONObject jSONObject) {
        this.pv = str;
        return b("{\n  \"detect_model\": \"detect/enc_cut12_0916.model.lite.bin\",\n  \"animate\": \"animate/skeletonModel_v3.1.11.bin\",\n  \"expression\": \"animate/enc_exp_v0.1.5_int16.lite.bin\",\n  \"track1_heavy\": \"track/mPts_v3_gp_small_model_epoch378.lite.bin_enc\",\n  \"track1_medium\": \"track/mPts_v3_gp_small_model_epoch378.lite.bin_enc\",\n  \"track1_lite\": \"track/mPts_automl_mv3_5ms_64_pose_s_model_epoch327.lite.bin_enc\",\n  \"mouth\": \"track/enc_mouth_mv27ky_br13stm.lite.bin\",\n  \"gender\": \"attributes/gender_v1.bin\",\n  \"high_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/mPts_v3_gp_small_model_epoch378.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"medium_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/mPts_v3_gp_small_model_epoch378.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"low_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/mPts_automl_mv3_5ms_64_pose_s_model_epoch327.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  }\n}", jSONObject);
    }
}
