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
    int aAT;
    public com.baidu.swan.apps.w.a.a.c cZV;
    public c daA;
    public a daB;
    public b daz;
    public String id = "";
    public String title = "";
    public String dav = "";
    public double daq = 0.0d;
    public double dax = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cZV = new com.baidu.swan.apps.w.a.a.c();
            this.cZV.parseFromJson(jSONObject);
            if (this.cZV.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.dav = jSONObject.optString("iconPath");
                this.daq = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.dax = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ah.N(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ah.N(jSONObject.optInt("height"))) : -1;
                this.aAT = jSONObject.optInt("zIndex", 0) * 10;
                this.daz = new b(this);
                this.daz.parseFromJson(jSONObject.optJSONObject("callout"));
                this.daA = new c(this);
                this.daA.parseFromJson(jSONObject.optJSONObject("label"));
                this.daB = new a();
                this.daB.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.cZV != null && this.cZV.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes10.dex */
    public static class b extends C0497d {
        public float auv;
        public String avb;
        public int bgColor;
        public int borderColor;
        public float daC;

        @Override // com.baidu.swan.apps.w.a.a.d.C0497d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.auv = 0.0f;
            this.daC = 0.0f;
            this.borderColor = -7829368;
            this.avb = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0497d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.auv = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.daC = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("borderColor"), -7829368);
                this.avb = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes10.dex */
    public static class c extends C0497d implements com.baidu.swan.apps.model.a {
        public float auv;
        public int borderColor;
        public float daC;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0497d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.daC = 0.0f;
            this.borderColor = 0;
            this.auv = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0497d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("x", 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.daC = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("borderColor"), 0);
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
    public static class C0497d implements com.baidu.swan.apps.model.a {
        private final d daE;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float auB = com.baidu.swan.apps.w.a.d.v(10.0d);
        public int bgColor = 0;
        public float daD = 0.0f;
        public String textAlign = "center";

        C0497d(d dVar) {
            this.daE = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float v;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    v = Math.abs(com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    v = com.baidu.swan.apps.w.a.d.v(10.0d);
                }
                this.auB = v;
                this.bgColor = com.baidu.swan.apps.w.a.d.S(jSONObject.optString("bgColor"), 0);
                this.daD = com.baidu.swan.apps.w.a.d.v(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
