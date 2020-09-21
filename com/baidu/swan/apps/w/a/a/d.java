package com.baidu.swan.apps.w.a.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes3.dex */
public class d implements com.baidu.swan.apps.model.a {
    public b cAd;
    public c cAe;
    public a cAf;
    int cAg;
    public com.baidu.swan.apps.w.a.a.c czB;
    public String id = "";
    public String title = "";
    public String cAa = "";
    public double czW = 0.0d;
    public double cAc = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.czB = new com.baidu.swan.apps.w.a.a.c();
            this.czB.parseFromJson(jSONObject);
            if (this.czB.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.cAa = jSONObject.optString("iconPath");
                this.czW = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.cAc = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ah.H(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ah.H(jSONObject.optInt("height"))) : -1;
                this.cAg = jSONObject.optInt("zIndex", 0) * 10;
                this.cAd = new b(this);
                this.cAd.parseFromJson(jSONObject.optJSONObject("callout"));
                this.cAe = new c(this);
                this.cAe.parseFromJson(jSONObject.optJSONObject("label"));
                this.cAf = new a();
                this.cAf.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.czB != null && this.czB.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class b extends C0454d {
        public float atL;
        public String aur;
        public int bgColor;
        public int borderColor;
        public float cAh;

        @Override // com.baidu.swan.apps.w.a.a.d.C0454d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.atL = 0.0f;
            this.cAh = 0.0f;
            this.borderColor = -7829368;
            this.aur = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0454d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.atL = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.cAh = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("borderColor"), -7829368);
                this.aur = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class c extends C0454d implements com.baidu.swan.apps.model.a {
        public float atL;
        public int borderColor;
        public float cAh;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0454d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.cAh = 0.0f;
            this.borderColor = 0;
            this.atL = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0454d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("x", 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.cAh = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("borderColor"), 0);
                this.atL = (float) jSONObject.optDouble("borderRadius", 0.0d);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class a implements com.baidu.swan.apps.model.a {
        public double x = 0.5d;
        public double y = 1.0d;

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            double d;
            double d2 = 0.0d;
            if (jSONObject != null) {
                this.x = Math.abs(jSONObject.optDouble("x", 0.5d));
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
    /* renamed from: com.baidu.swan.apps.w.a.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0454d implements com.baidu.swan.apps.model.a {
        private final d cAj;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float atR = com.baidu.swan.apps.w.a.d.r(10.0d);
        public int bgColor = 0;
        public float cAi = 0.0f;
        public String textAlign = "center";

        C0454d(d dVar) {
            this.cAj = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float r;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    r = Math.abs(com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    r = com.baidu.swan.apps.w.a.d.r(10.0d);
                }
                this.atR = r;
                this.bgColor = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("bgColor"), 0);
                this.cAi = com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
