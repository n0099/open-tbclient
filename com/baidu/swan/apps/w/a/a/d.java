package com.baidu.swan.apps.w.a.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ao.ah;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes8.dex */
public class d implements com.baidu.swan.apps.model.a {
    int azd;
    public b djH;
    public c djI;
    public a djJ;
    public com.baidu.swan.apps.w.a.a.c dje;
    public String id = "";
    public String title = "";
    public String djE = "";
    public double djz = 0.0d;
    public double djG = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dje = new com.baidu.swan.apps.w.a.a.c();
            this.dje.parseFromJson(jSONObject);
            if (this.dje.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.djE = jSONObject.optString("iconPath");
                this.djz = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.djG = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ah.T(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ah.T(jSONObject.optInt("height"))) : -1;
                this.azd = jSONObject.optInt("zIndex", 0) * 10;
                this.djH = new b(this);
                this.djH.parseFromJson(jSONObject.optJSONObject("callout"));
                this.djI = new c(this);
                this.djI.parseFromJson(jSONObject.optJSONObject("label"));
                this.djJ = new a();
                this.djJ.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.dje != null && this.dje.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes8.dex */
    public static class b extends C0486d {
        public int bgColor;
        public int borderColor;
        public float borderWidth;
        public String cuP;
        public float djK;

        @Override // com.baidu.swan.apps.w.a.a.d.C0486d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.djK = 0.0f;
            this.borderWidth = 0.0f;
            this.borderColor = -7829368;
            this.cuP = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0486d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.djK = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.borderWidth = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.Y(jSONObject.optString("borderColor"), -7829368);
                this.cuP = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.Y(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes8.dex */
    public static class c extends C0486d implements com.baidu.swan.apps.model.a {
        public int borderColor;
        public float borderWidth;
        public float djK;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0486d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.borderWidth = 0.0f;
            this.borderColor = 0;
            this.djK = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0486d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.borderWidth = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.Y(jSONObject.optString("borderColor"), 0);
                this.djK = (float) jSONObject.optDouble("borderRadius", 0.0d);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
    public static class C0486d implements com.baidu.swan.apps.model.a {
        private final d djN;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float djL = com.baidu.swan.apps.w.a.d.o(10.0d);
        public int bgColor = 0;
        public float djM = 0.0f;
        public String textAlign = "center";

        C0486d(d dVar) {
            this.djN = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float o;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.Y(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    o = Math.abs(com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    o = com.baidu.swan.apps.w.a.d.o(10.0d);
                }
                this.djL = o;
                this.bgColor = com.baidu.swan.apps.w.a.d.Y(jSONObject.optString("bgColor"), 0);
                this.djM = com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
