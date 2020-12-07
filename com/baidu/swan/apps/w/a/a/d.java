package com.baidu.swan.apps.w.a.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.swan.apps.ap.ah;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes25.dex */
public class d implements com.baidu.swan.apps.model.a {
    int aBM;
    public b dfN;
    public c dfO;
    public a dfP;
    public com.baidu.swan.apps.w.a.a.c dfk;
    public String id = "";
    public String title = "";
    public String dfK = "";
    public double dfF = 0.0d;
    public double dfM = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dfk = new com.baidu.swan.apps.w.a.a.c();
            this.dfk.parseFromJson(jSONObject);
            if (this.dfk.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.dfK = jSONObject.optString("iconPath");
                this.dfF = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.dfM = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ah.M(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ah.M(jSONObject.optInt("height"))) : -1;
                this.aBM = jSONObject.optInt("zIndex", 0) * 10;
                this.dfN = new b(this);
                this.dfN.parseFromJson(jSONObject.optJSONObject("callout"));
                this.dfO = new c(this);
                this.dfO.parseFromJson(jSONObject.optJSONObject("label"));
                this.dfP = new a();
                this.dfP.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.dfk != null && this.dfk.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes25.dex */
    public static class b extends C0507d {
        public int bgColor;
        public int borderColor;
        public String cph;
        public float dfQ;
        public float dfR;

        @Override // com.baidu.swan.apps.w.a.a.d.C0507d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.dfQ = 0.0f;
            this.dfR = 0.0f;
            this.borderColor = -7829368;
            this.cph = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0507d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.dfQ = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.dfR = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.T(jSONObject.optString("borderColor"), -7829368);
                this.cph = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.T(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes25.dex */
    public static class c extends C0507d implements com.baidu.swan.apps.model.a {
        public int borderColor;
        public float dfQ;
        public float dfR;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0507d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.dfR = 0.0f;
            this.borderColor = 0;
            this.dfQ = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0507d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("x", 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.dfR = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.T(jSONObject.optString("borderColor"), 0);
                this.dfQ = (float) jSONObject.optDouble("borderRadius", 0.0d);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes25.dex */
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
    /* loaded from: classes25.dex */
    public static class C0507d implements com.baidu.swan.apps.model.a {
        private final d dfU;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float dfS = com.baidu.swan.apps.w.a.d.u(10.0d);
        public int bgColor = 0;
        public float dfT = 0.0f;
        public String textAlign = "center";

        C0507d(d dVar) {
            this.dfU = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float u;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.T(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    u = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    u = com.baidu.swan.apps.w.a.d.u(10.0d);
                }
                this.dfS = u;
                this.bgColor = com.baidu.swan.apps.w.a.d.T(jSONObject.optString("bgColor"), 0);
                this.dfT = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
