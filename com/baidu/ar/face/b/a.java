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
    private static final int[] ol = {3, 10, 10, 10, 10};
    private String ok;

    /* renamed from: com.baidu.ar.face.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0083a {
        public String om;
        public String on;
        public String oo;
        public String op;
        public String oq;
        public String or;

        public C0083a() {
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public int[] mQ;
        public String oA;
        public C0083a oB;
        public C0083a oC;
        public C0083a oD;
        public int oE;
        public String ot;
        public String ou;
        public String ov;
        public String ow;
        public String ox;
        public String oy;
        public String oz;

        public b() {
        }
    }

    private void a(b bVar, JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("customize");
        bVar.oE = 0;
        bVar.mQ = ol;
        if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("algo")) == null || (optJSONObject2 = optJSONObject.optJSONObject("algo_face")) == null) {
            return;
        }
        String optString = optJSONObject2.optString(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
        if (!TextUtils.isEmpty(optString)) {
            if (optString.equals("high")) {
                bVar.oE = 2;
            } else if (optString.equals("medium")) {
                bVar.oE = 1;
            } else if (optString.equals("mediumlow")) {
                bVar.oE = 0;
            } else if (optString.equals(Config.EXCEPTION_MEMORY_LOW)) {
                bVar.oE = 0;
            }
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("detect_rate");
        if (optJSONArray == null || optJSONArray.length() < 5) {
            return;
        }
        try {
            int[] iArr = new int[5];
            for (int i = 0; i < 5; i++) {
                iArr[i] = optJSONArray.getInt(i) < ol[i] ? ol[i] : optJSONArray.getInt(i);
            }
            bVar.mQ = iArr;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private b b(String str, JSONObject jSONObject) {
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            bVar.ot = this.ok + jSONObject2.getString("detect_model");
            bVar.ou = this.ok + jSONObject2.getString("animate");
            bVar.oy = this.ok + jSONObject2.getString("expression");
            bVar.ov = this.ok + jSONObject2.getString("track1_heavy");
            bVar.ow = this.ok + jSONObject2.getString("track1_medium");
            bVar.ox = this.ok + jSONObject2.getString("track1_lite");
            bVar.oz = this.ok + jSONObject2.getString(LivenessStat.TYPE_LIVING_MOUTH);
            bVar.oA = this.ok + jSONObject2.getString("gender");
            bVar.oD = e(jSONObject2.getJSONObject("high_device_model"));
            bVar.oC = e(jSONObject2.getJSONObject("medium_device_model"));
            bVar.oB = e(jSONObject2.getJSONObject("low_device_model"));
            if (jSONObject == null) {
                bVar.oE = c.Q();
                bVar.mQ = ol;
            } else {
                a(bVar, jSONObject);
            }
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private C0083a e(JSONObject jSONObject) {
        C0083a c0083a = new C0083a();
        try {
            c0083a.om = jSONObject.getString("track_param_0");
            if (TextUtils.isEmpty(c0083a.om)) {
                c0083a.om = "";
            } else {
                c0083a.om = this.ok + c0083a.om;
            }
            c0083a.on = jSONObject.getString("track_param_1");
            if (TextUtils.isEmpty(c0083a.on)) {
                c0083a.on = "";
            } else {
                c0083a.on = this.ok + c0083a.on;
            }
            c0083a.oo = jSONObject.getString("track_param_2");
            if (TextUtils.isEmpty(c0083a.oo)) {
                c0083a.oo = "";
            } else {
                c0083a.oo = this.ok + c0083a.oo;
            }
            c0083a.op = jSONObject.getString("trackingSmoothAlpha");
            c0083a.oq = jSONObject.getString("trackingSmoothThreshold");
            c0083a.or = jSONObject.getString("trackingMouthThreshold");
            return c0083a;
        } catch (JSONException e) {
            com.baidu.ar.f.b.b("FaceModelConfig", "parse DeviceModel error");
            e.printStackTrace();
            return null;
        }
    }

    public b a(String str, JSONObject jSONObject) {
        this.ok = str;
        return b("{\n  \"detect_model\": \"detect/ardetect_recall0794_jiami.lite.bin\",\n  \"animate\": \"animate/skeletonModel_v3.1.11.bin\",\n  \"expression\": \"animate/enc_exp_v0.1.5_int16.lite.bin\",\n  \"track1_heavy\": \"track/v3gp_morph_btail5_wless_bs32_adam_441_s0-455.lite.bin_enc\",\n  \"track1_medium\": \"track/v3gp_morph_btail5_wless_bs32_adam_441_s0-455.lite.bin_enc\",\n  \"track1_lite\": \"track/automl_mv3_5ms_64_s_ftdongxiao.lite.bin_enc\",\n  \"mouth\": \"track/mouth_mv6_epoch320.lite.bin_enc\",\n  \"gender\": \"attributes/gender_v1.bin\",\n  \"high_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/v3gp_morph_btail5_wless_bs32_adam_441_s0-455.lite.bin_enc\",\n    \"track_param_2\": \"track/eye_mv1s_39p_v1212In32.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"0.1\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"medium_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/v3gp_morph_btail5_wless_bs32_adam_441_s0-455.lite.bin_enc\",\n    \"track_param_2\": \"track/eye_mv1s_39p_v1212In32.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"0.1\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"low_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/automl_mv3_5ms_64_s_ftdongxiao.lite.bin_enc\",\n    \"track_param_2\": \"track/eye_mv1s_39p_v1212In32.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"0.1\",\n    \"trackingSmoothThreshold\": \"1\"\n  }\n}", jSONObject);
    }
}
