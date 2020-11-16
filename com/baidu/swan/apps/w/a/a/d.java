package com.baidu.swan.apps.w.a.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes7.dex */
public class d implements com.baidu.swan.apps.model.a {
    int azi;
    public b cYN;
    public c cYO;
    public a cYP;
    public com.baidu.swan.apps.w.a.a.c cYl;
    public String id = "";
    public String title = "";
    public String cYK = "";
    public double cYG = 0.0d;
    public double cYM = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cYl = new com.baidu.swan.apps.w.a.a.c();
            this.cYl.parseFromJson(jSONObject);
            if (this.cYl.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.cYK = jSONObject.optString("iconPath");
                this.cYG = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.cYM = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ah.M(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ah.M(jSONObject.optInt("height"))) : -1;
                this.azi = jSONObject.optInt("zIndex", 0) * 10;
                this.cYN = new b(this);
                this.cYN.parseFromJson(jSONObject.optJSONObject("callout"));
                this.cYO = new c(this);
                this.cYO.parseFromJson(jSONObject.optJSONObject("label"));
                this.cYP = new a();
                this.cYP.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cYl != null && this.cYl.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes7.dex */
    public static class b extends C0495d {
        public int bgColor;
        public int borderColor;
        public float cYQ;
        public float cYR;
        public String ciz;

        @Override // com.baidu.swan.apps.w.a.a.d.C0495d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.cYQ = 0.0f;
            this.cYR = 0.0f;
            this.borderColor = -7829368;
            this.ciz = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0495d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.cYQ = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.cYR = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("borderColor"), -7829368);
                this.ciz = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes7.dex */
    public static class c extends C0495d implements com.baidu.swan.apps.model.a {
        public int borderColor;
        public float cYQ;
        public float cYR;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0495d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.cYR = 0.0f;
            this.borderColor = 0;
            this.cYQ = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0495d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("x", 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.cYR = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("borderColor"), 0);
                this.cYQ = (float) jSONObject.optDouble("borderRadius", 0.0d);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
    public static class C0495d implements com.baidu.swan.apps.model.a {
        private final d cYU;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float cYS = com.baidu.swan.apps.w.a.d.u(10.0d);
        public int bgColor = 0;
        public float cYT = 0.0f;
        public String textAlign = "center";

        C0495d(d dVar) {
            this.cYU = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float u;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    u = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    u = com.baidu.swan.apps.w.a.d.u(10.0d);
                }
                this.cYS = u;
                this.bgColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("bgColor"), 0);
                this.cYT = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
