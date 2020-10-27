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
    public b cUE;
    public c cUF;
    public a cUG;
    int cUH;
    public com.baidu.swan.apps.w.a.a.c cUc;
    public String id = "";
    public String title = "";
    public String cUB = "";
    public double cUx = 0.0d;
    public double cUD = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cUc = new com.baidu.swan.apps.w.a.a.c();
            this.cUc.parseFromJson(jSONObject);
            if (this.cUc.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.cUB = jSONObject.optString("iconPath");
                this.cUx = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.cUD = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ah.L(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ah.L(jSONObject.optInt("height"))) : -1;
                this.cUH = jSONObject.optInt("zIndex", 0) * 10;
                this.cUE = new b(this);
                this.cUE.parseFromJson(jSONObject.optJSONObject("callout"));
                this.cUF = new c(this);
                this.cUF.parseFromJson(jSONObject.optJSONObject("label"));
                this.cUG = new a();
                this.cUG.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cUc != null && this.cUc.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes10.dex */
    public static class b extends C0485d {
        public float auv;
        public String avb;
        public int bgColor;
        public int borderColor;
        public float cUI;

        @Override // com.baidu.swan.apps.w.a.a.d.C0485d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.auv = 0.0f;
            this.cUI = 0.0f;
            this.borderColor = -7829368;
            this.avb = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0485d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.auv = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.cUI = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("borderColor"), -7829368);
                this.avb = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes10.dex */
    public static class c extends C0485d implements com.baidu.swan.apps.model.a {
        public float auv;
        public int borderColor;
        public float cUI;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0485d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.cUI = 0.0f;
            this.borderColor = 0;
            this.auv = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0485d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("x", 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.cUI = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("borderColor"), 0);
                this.auv = (float) jSONObject.optDouble("borderRadius", 0.0d);
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
    public static class C0485d implements com.baidu.swan.apps.model.a {
        private final d cUK;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float auB = com.baidu.swan.apps.w.a.d.v(10.0d);
        public int bgColor = 0;
        public float cUJ = 0.0f;
        public String textAlign = "center";

        C0485d(d dVar) {
            this.cUK = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float v;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    v = Math.abs(com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    v = com.baidu.swan.apps.w.a.d.v(10.0d);
                }
                this.auB = v;
                this.bgColor = com.baidu.swan.apps.w.a.d.Q(jSONObject.optString("bgColor"), 0);
                this.cUJ = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
