package com.baidu.swan.apps.w.a.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes10.dex */
public class d implements com.baidu.swan.apps.model.a {
    public com.baidu.swan.apps.w.a.a.c cLG;
    public b cMi;
    public c cMj;
    public a cMk;
    int cMl;
    public String id = "";
    public String title = "";
    public String cMf = "";
    public double cMb = 0.0d;
    public double cMh = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cLG = new com.baidu.swan.apps.w.a.a.c();
            this.cLG.parseFromJson(jSONObject);
            if (this.cLG.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.cMf = jSONObject.optString("iconPath");
                this.cMb = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.cMh = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ah.J(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ah.J(jSONObject.optInt("height"))) : -1;
                this.cMl = jSONObject.optInt("zIndex", 0) * 10;
                this.cMi = new b(this);
                this.cMi.parseFromJson(jSONObject.optJSONObject("callout"));
                this.cMj = new c(this);
                this.cMj.parseFromJson(jSONObject.optJSONObject("label"));
                this.cMk = new a();
                this.cMk.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cLG != null && this.cLG.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes10.dex */
    public static class b extends C0471d {
        public float auu;
        public String ava;
        public int bgColor;
        public int borderColor;
        public float cMm;

        @Override // com.baidu.swan.apps.w.a.a.d.C0471d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.auu = 0.0f;
            this.cMm = 0.0f;
            this.borderColor = -7829368;
            this.ava = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0471d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.auu = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.cMm = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("borderColor"), -7829368);
                this.ava = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes10.dex */
    public static class c extends C0471d implements com.baidu.swan.apps.model.a {
        public float auu;
        public int borderColor;
        public float cMm;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0471d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.cMm = 0.0f;
            this.borderColor = 0;
            this.auu = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0471d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("x", 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.cMm = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("borderColor"), 0);
                this.auu = (float) jSONObject.optDouble("borderRadius", 0.0d);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
    public static class C0471d implements com.baidu.swan.apps.model.a {
        private final d cMo;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float auA = com.baidu.swan.apps.w.a.d.u(10.0d);
        public int bgColor = 0;
        public float cMn = 0.0f;
        public String textAlign = "center";

        C0471d(d dVar) {
            this.cMo = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float u;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    u = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    u = com.baidu.swan.apps.w.a.d.u(10.0d);
                }
                this.auA = u;
                this.bgColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("bgColor"), 0);
                this.cMn = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
