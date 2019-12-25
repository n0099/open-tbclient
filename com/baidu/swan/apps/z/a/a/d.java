package com.baidu.swan.apps.z.a.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.as.af;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes9.dex */
public class d implements com.baidu.swan.apps.model.a {
    public com.baidu.swan.apps.z.a.a.c buN;
    public b bvq;
    public c bvr;
    public a bvs;
    int bvt;
    public String id = "";
    public String title = "";
    public String iconPath = "";
    public double bvi = 0.0d;
    public double bvp = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.buN = new com.baidu.swan.apps.z.a.a.c();
            this.buN.parseFromJson(jSONObject);
            if (this.buN.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.iconPath = jSONObject.optString("iconPath");
                this.bvi = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.bvp = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(af.T(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(af.T(jSONObject.optInt("height"))) : -1;
                this.bvt = jSONObject.optInt("zIndex", 0) * 10;
                this.bvq = new b(this);
                this.bvq.parseFromJson(jSONObject.optJSONObject("callout"));
                this.bvr = new c(this);
                this.bvr.parseFromJson(jSONObject.optJSONObject("label"));
                this.bvs = new a();
                this.bvs.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.buN != null && this.buN.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes9.dex */
    public static class b extends C0299d {
        public String RK;
        public float Rf;
        public int bgColor;

        @Override // com.baidu.swan.apps.z.a.a.d.C0299d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.Rf = 0.0f;
            this.RK = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.z.a.a.d.C0299d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.Rf = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.RK = jSONObject.has(LogConfig.KEY_DISPLAY) ? jSONObject.optString(LogConfig.KEY_DISPLAY) : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes9.dex */
    public static class c extends C0299d implements com.baidu.swan.apps.model.a {
        public float Rf;
        public int borderColor;
        public float bvu;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.z.a.a.d.C0299d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.bvu = 0.0f;
            this.borderColor = 0;
            this.Rf = 0.0f;
        }

        @Override // com.baidu.swan.apps.z.a.a.d.C0299d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d));
                this.y = com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.bvu = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("borderColor"), 0);
                this.Rf = (float) jSONObject.optDouble("borderRadius", 0.0d);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes9.dex */
    public static class a implements com.baidu.swan.apps.model.a {
        public double x = 0.5d;
        public double y = 1.0d;

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            double d;
            double d2 = 0.0d;
            if (jSONObject != null) {
                this.x = Math.abs(jSONObject.optDouble(Config.EVENT_HEAT_X, 0.5d));
                this.y = Math.abs(jSONObject.optDouble("y", 1.0d));
                if (this.x < 0.0d) {
                    d = 0.0d;
                } else {
                    d = this.x > 1.0d ? 1.0d : this.x;
                }
                this.x = d;
                if (this.y >= 0.0d) {
                    d2 = this.y > 1.0d ? 1.0d : this.y;
                }
                this.y = d2;
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SwanCommentWar"})
    /* renamed from: com.baidu.swan.apps.z.a.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0299d implements com.baidu.swan.apps.model.a {
        private final d bvw;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float Rl = com.baidu.swan.apps.z.a.d.f(10.0d);
        public int bgColor = 0;
        public float bvv = 0.0f;
        public String textAlign = "center";

        C0299d(d dVar) {
            this.bvw = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                this.Rl = jSONObject.has("fontSize") ? Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("fontSize", 0.0d))) : com.baidu.swan.apps.z.a.d.f(10.0d);
                this.bgColor = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("bgColor"), 0);
                this.bvv = com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
