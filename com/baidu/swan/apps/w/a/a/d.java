package com.baidu.swan.apps.w.a.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.aq.ai;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes7.dex */
public class d implements com.baidu.swan.apps.model.a {
    public com.baidu.swan.apps.w.a.a.c cpG;
    public b cqi;
    public c cqj;
    public a cqk;
    int cql;
    public String id = "";
    public String title = "";
    public String cqf = "";
    public double cqb = 0.0d;
    public double cqh = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cpG = new com.baidu.swan.apps.w.a.a.c();
            this.cpG.parseFromJson(jSONObject);
            if (this.cpG.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.cqf = jSONObject.optString("iconPath");
                this.cqb = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.cqh = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ai.D(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ai.D(jSONObject.optInt("height"))) : -1;
                this.cql = jSONObject.optInt("zIndex", 0) * 10;
                this.cqi = new b(this);
                this.cqi.parseFromJson(jSONObject.optJSONObject("callout"));
                this.cqj = new c(this);
                this.cqj.parseFromJson(jSONObject.optJSONObject("label"));
                this.cqk = new a();
                this.cqk.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cpG != null && this.cpG.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes7.dex */
    public static class b extends C0413d {
        public String aoP;
        public float aoj;
        public int bgColor;
        public int borderColor;
        public float cqm;

        @Override // com.baidu.swan.apps.w.a.a.d.C0413d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.aoj = 0.0f;
            this.cqm = 0.0f;
            this.borderColor = -7829368;
            this.aoP = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0413d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.aoj = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.cqm = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.N(jSONObject.optString("borderColor"), -7829368);
                this.aoP = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.N(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes7.dex */
    public static class c extends C0413d implements com.baidu.swan.apps.model.a {
        public float aoj;
        public int borderColor;
        public float cqm;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0413d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.cqm = 0.0f;
            this.borderColor = 0;
            this.aoj = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0413d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.k(jSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.k(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.k(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.k(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.cqm = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.N(jSONObject.optString("borderColor"), 0);
                this.aoj = (float) jSONObject.optDouble("borderRadius", 0.0d);
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
    /* renamed from: com.baidu.swan.apps.w.a.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0413d implements com.baidu.swan.apps.model.a {
        private final d cqo;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float aop = com.baidu.swan.apps.w.a.d.k(10.0d);
        public int bgColor = 0;
        public float cqn = 0.0f;
        public String textAlign = "center";

        C0413d(d dVar) {
            this.cqo = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float k;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.N(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    k = Math.abs(com.baidu.swan.apps.w.a.d.k(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    k = com.baidu.swan.apps.w.a.d.k(10.0d);
                }
                this.aop = k;
                this.bgColor = com.baidu.swan.apps.w.a.d.N(jSONObject.optString("bgColor"), 0);
                this.cqn = com.baidu.swan.apps.w.a.d.k(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
