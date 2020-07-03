package com.baidu.swan.apps.x.a.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.aq.ag;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.model.a {
    public com.baidu.swan.apps.x.a.a.c cnA;
    public b cod;
    public c coe;
    public a cof;
    int cog;
    public String id = "";
    public String title = "";
    public String coa = "";
    public double cnV = 0.0d;
    public double coc = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cnA = new com.baidu.swan.apps.x.a.a.c();
            this.cnA.parseFromJson(jSONObject);
            if (this.cnA.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.coa = jSONObject.optString("iconPath");
                this.cnV = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.coc = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ag.D(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ag.D(jSONObject.optInt("height"))) : -1;
                this.cog = jSONObject.optInt("zIndex", 0) * 10;
                this.cod = new b(this);
                this.cod.parseFromJson(jSONObject.optJSONObject("callout"));
                this.coe = new c(this);
                this.coe.parseFromJson(jSONObject.optJSONObject("label"));
                this.cof = new a();
                this.cof.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cnA != null && this.cnA.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes11.dex */
    public static class b extends C0408d {
        public String aoT;
        public float aon;
        public int bgColor;
        public int borderColor;
        public float coh;

        @Override // com.baidu.swan.apps.x.a.a.d.C0408d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.aon = 0.0f;
            this.coh = 0.0f;
            this.borderColor = -7829368;
            this.aoT = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0408d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.aon = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.coh = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("borderColor"), -7829368);
                this.aoT = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes11.dex */
    public static class c extends C0408d implements com.baidu.swan.apps.model.a {
        public float aon;
        public int borderColor;
        public float coh;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.x.a.a.d.C0408d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.coh = 0.0f;
            this.borderColor = 0;
            this.aon = 0.0f;
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0408d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.x.a.d.k(jSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d));
                this.y = com.baidu.swan.apps.x.a.d.k(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.x.a.d.k(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.x.a.d.k(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.coh = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("borderColor"), 0);
                this.aon = (float) jSONObject.optDouble("borderRadius", 0.0d);
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
    /* renamed from: com.baidu.swan.apps.x.a.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0408d implements com.baidu.swan.apps.model.a {
        private final d coj;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float aot = com.baidu.swan.apps.x.a.d.k(10.0d);
        public int bgColor = 0;
        public float coi = 0.0f;
        public String textAlign = "center";

        C0408d(d dVar) {
            this.coj = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float k;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    k = Math.abs(com.baidu.swan.apps.x.a.d.k(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    k = com.baidu.swan.apps.x.a.d.k(10.0d);
                }
                this.aot = k;
                this.bgColor = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("bgColor"), 0);
                this.coi = com.baidu.swan.apps.x.a.d.k(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
