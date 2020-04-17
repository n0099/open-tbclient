package com.baidu.swan.apps.z.a.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.as.af;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.model.a {
    public b bYG;
    public c bYH;
    public a bYI;
    int bYJ;
    public com.baidu.swan.apps.z.a.a.c bYd;
    public String id = "";
    public String title = "";
    public String bYD = "";
    public double bYy = 0.0d;
    public double bYF = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bYd = new com.baidu.swan.apps.z.a.a.c();
            this.bYd.parseFromJson(jSONObject);
            if (this.bYd.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.bYD = jSONObject.optString("iconPath");
                this.bYy = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.bYF = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(af.C(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(af.C(jSONObject.optInt("height"))) : -1;
                this.bYJ = jSONObject.optInt("zIndex", 0) * 10;
                this.bYG = new b(this);
                this.bYG.parseFromJson(jSONObject.optJSONObject("callout"));
                this.bYH = new c(this);
                this.bYH.parseFromJson(jSONObject.optJSONObject("label"));
                this.bYI = new a();
                this.bYI.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.bYd != null && this.bYd.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes11.dex */
    public static class b extends C0341d {
        public String alT;
        public float aln;
        public int bgColor;

        @Override // com.baidu.swan.apps.z.a.a.d.C0341d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.aln = 0.0f;
            this.alT = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.z.a.a.d.C0341d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.aln = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.alT = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.z.a.d.J(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes11.dex */
    public static class c extends C0341d implements com.baidu.swan.apps.model.a {
        public float aln;
        public float bYK;
        public int borderColor;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.z.a.a.d.C0341d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.bYK = 0.0f;
            this.borderColor = 0;
            this.aln = 0.0f;
        }

        @Override // com.baidu.swan.apps.z.a.a.d.C0341d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d));
                this.y = com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.bYK = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.z.a.d.J(jSONObject.optString("borderColor"), 0);
                this.aln = (float) jSONObject.optDouble("borderRadius", 0.0d);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes11.dex */
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
    /* loaded from: classes11.dex */
    public static class C0341d implements com.baidu.swan.apps.model.a {
        private final d bYM;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float alt = com.baidu.swan.apps.z.a.d.k(10.0d);
        public int bgColor = 0;
        public float bYL = 0.0f;
        public String textAlign = "center";

        C0341d(d dVar) {
            this.bYM = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.z.a.d.J(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                this.alt = jSONObject.has("fontSize") ? Math.abs(com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble("fontSize", 0.0d))) : com.baidu.swan.apps.z.a.d.k(10.0d);
                this.bgColor = com.baidu.swan.apps.z.a.d.J(jSONObject.optString("bgColor"), 0);
                this.bYL = com.baidu.swan.apps.z.a.d.k(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
