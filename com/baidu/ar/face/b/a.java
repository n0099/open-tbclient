package com.baidu.ar.face.b;

import android.text.TextUtils;
import com.baidu.ar.a.c;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static final int[] oK = {3, 10, 10, 10, 10};
    private String oJ;

    /* renamed from: com.baidu.ar.face.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0084a {
        public String oL;
        public String oM;
        public String oN;
        public String oO;
        public String oP;
        public String oQ;
        public String oR;

        public C0084a() {
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public int[] nn;
        public String oT;
        public String oU;
        public String oV;
        public String oW;
        public String oX;
        public String oY;
        public String oZ;
        public String pa;
        public C0084a pb;
        public C0084a pc;
        public C0084a pd;
        public int pe;

        public b() {
        }
    }

    private void a(b bVar, JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("customize");
        bVar.pe = 0;
        bVar.nn = oK;
        if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("algo")) == null || (optJSONObject2 = optJSONObject.optJSONObject("algo_face")) == null) {
            return;
        }
        String optString = optJSONObject2.optString(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
        if (!TextUtils.isEmpty(optString)) {
            if (optString.equals("high")) {
                bVar.pe = 2;
            } else if (optString.equals("medium")) {
                bVar.pe = 1;
            } else if (optString.equals("mediumlow")) {
                bVar.pe = 0;
            } else if (optString.equals(Config.EXCEPTION_MEMORY_LOW)) {
                bVar.pe = 0;
            }
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("detect_rate");
        if (optJSONArray == null || optJSONArray.length() < 5) {
            return;
        }
        try {
            int[] iArr = new int[5];
            for (int i = 0; i < 5; i++) {
                iArr[i] = optJSONArray.getInt(i) < oK[i] ? oK[i] : optJSONArray.getInt(i);
            }
            bVar.nn = iArr;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private b b(String str, JSONObject jSONObject) {
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            bVar.oT = this.oJ + jSONObject2.getString("detect_model");
            bVar.oU = this.oJ + jSONObject2.getString("animate");
            bVar.oY = this.oJ + jSONObject2.getString("expression");
            bVar.oV = this.oJ + jSONObject2.getString("track1_heavy");
            bVar.oW = this.oJ + jSONObject2.getString("track1_medium");
            bVar.oX = this.oJ + jSONObject2.getString("track1_lite");
            bVar.oZ = this.oJ + jSONObject2.getString(LivenessStat.TYPE_LIVING_MOUTH);
            bVar.pa = this.oJ + jSONObject2.getString("gender");
            bVar.pd = f(jSONObject2.getJSONObject("high_device_model"));
            bVar.pc = f(jSONObject2.getJSONObject("medium_device_model"));
            bVar.pb = f(jSONObject2.getJSONObject("low_device_model"));
            if (jSONObject == null) {
                bVar.pe = c.ae();
                bVar.nn = oK;
            } else {
                a(bVar, jSONObject);
            }
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private C0084a f(JSONObject jSONObject) {
        C0084a c0084a = new C0084a();
        try {
            c0084a.oL = jSONObject.getString("track_param_0");
            if (TextUtils.isEmpty(c0084a.oL)) {
                c0084a.oL = "";
            } else {
                c0084a.oL = this.oJ + c0084a.oL;
            }
            c0084a.oM = jSONObject.getString("track_param_1");
            if (TextUtils.isEmpty(c0084a.oM)) {
                c0084a.oM = "";
            } else {
                c0084a.oM = this.oJ + c0084a.oM;
            }
            c0084a.oN = jSONObject.getString("track_param_2");
            if (TextUtils.isEmpty(c0084a.oN)) {
                c0084a.oN = "";
            } else {
                c0084a.oN = this.oJ + c0084a.oN;
            }
            c0084a.oO = jSONObject.getString("track_param_3");
            if (TextUtils.isEmpty(c0084a.oO)) {
                c0084a.oO = "";
            } else {
                c0084a.oO = this.oJ + c0084a.oO;
            }
            c0084a.oP = jSONObject.getString("trackingSmoothAlpha");
            c0084a.oQ = jSONObject.getString("trackingSmoothThreshold");
            c0084a.oR = jSONObject.getString("trackingMouthThreshold");
            return c0084a;
        } catch (JSONException e) {
            com.baidu.ar.f.b.b("FaceModelConfig", "parse DeviceModel error");
            e.printStackTrace();
            return null;
        }
    }

    public b a(String str, JSONObject jSONObject) {
        this.oJ = str;
        return b("{\n  \"detect_model\": \"detect/ar_detect_recall08891_jiami.lite.bin\",\n  \"animate\": \"animate/skeletonModel_v3.1.11.bin\",\n  \"expression\": \"animate/enc_exp_v0.1.5_int16.lite.bin\",\n  \"track1_heavy\": \"track/v3gpS_sft0.1_br1.3_RER0.15_PO90_170K_224pts_388_397.lite.bin_enc\",\n  \"track1_medium\": \"track/v3gpS_sft0.1_br1.3_RER0.15_PO90_170K_224pts_388_397.lite.bin_enc\",\n  \"track1_lite\": \"track/automl_mv3_5ms_64_s_ftdongxiao.lite.bin_enc\",\n  \"mouth\": \"track/mouth_mv6_epoch320.lite.bin_enc\",\n  \"gender\": \"attributes/gender_v1.bin\",\n  \"high_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/v3gpS_sft0.1_br1.3_RER0.15_PO90_170K_224pts_388_397.lite.bin_enc\",\n    \"track_param_2\": \"track/eye_mv6_32x32_half_br1.3_model_epoch176.lite.bin_enc\",\n    \"track_param_3\": \"track/iris_v6gp_24x24_iris_epoch261.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"0.1\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"medium_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/v3gpS_sft0.1_br1.3_RER0.15_PO90_170K_224pts_388_397.lite.bin_enc\",\n    \"track_param_2\": \"track/eye_mv6_32x32_half_br1.3_model_epoch176.lite.bin_enc\",\n    \"track_param_3\": \"track/iris_v6gp_24x24_iris_epoch261.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"0.1\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"low_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/automl_mv3_5ms_64_s_ftdongxiao.lite.bin_enc\",\n    \"track_param_2\": \"track/eye_mv6_32x32_half_br1.3_model_epoch176.lite.bin_enc\",\n    \"track_param_3\": \"track/iris_v6gp_24x24_iris_epoch261.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"0.1\",\n    \"trackingSmoothThreshold\": \"1\"\n  }\n}", jSONObject);
    }
}
