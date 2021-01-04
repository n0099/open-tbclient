package com.baidu.swan.apps.w.a.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.swan.apps.ao.ah;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes9.dex */
public class d implements com.baidu.swan.apps.model.a {
    int aCd;
    public b dkH;
    public c dkI;
    public a dkJ;
    public com.baidu.swan.apps.w.a.a.c dke;
    public String id = "";
    public String title = "";
    public String dkE = "";
    public double dkz = 0.0d;
    public double dkG = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dke = new com.baidu.swan.apps.w.a.a.c();
            this.dke.parseFromJson(jSONObject);
            if (this.dke.isValid()) {
                this.id = jSONObject.optString("markerId");
                if (TextUtils.isEmpty(this.id)) {
                    this.id = jSONObject.optString("id");
                }
                this.title = jSONObject.optString("title");
                this.dkE = jSONObject.optString("iconPath");
                this.dkz = jSONObject.optDouble(RotateImageAction.ACTION_NAME, 0.0d);
                this.dkG = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(ah.O(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(ah.O(jSONObject.optInt("height"))) : -1;
                this.aCd = jSONObject.optInt("zIndex", 0) * 10;
                this.dkH = new b(this);
                this.dkH.parseFromJson(jSONObject.optJSONObject("callout"));
                this.dkI = new c(this);
                this.dkI.parseFromJson(jSONObject.optJSONObject("label"));
                this.dkJ = new a();
                this.dkJ.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.dke != null && this.dke.isValid();
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes9.dex */
    public static class b extends C0500d {
        public int bgColor;
        public int borderColor;
        public float borderWidth;
        public String cwn;
        public float dkK;

        @Override // com.baidu.swan.apps.w.a.a.d.C0500d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        b(d dVar) {
            super(dVar);
            this.dkK = 0.0f;
            this.borderWidth = 0.0f;
            this.borderColor = -7829368;
            this.cwn = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0500d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.dkK = (float) jSONObject.optDouble("borderRadius", 0.0d);
                this.borderWidth = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("borderColor"), -7829368);
                this.cwn = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("bgColor"), -1);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes9.dex */
    public static class c extends C0500d implements com.baidu.swan.apps.model.a {
        public int borderColor;
        public float borderWidth;
        public float dkK;
        public float x;
        public float y;

        @Override // com.baidu.swan.apps.w.a.a.d.C0500d, com.baidu.swan.apps.model.a
        public /* bridge */ /* synthetic */ boolean isValid() {
            return super.isValid();
        }

        c(d dVar) {
            super(dVar);
            this.x = 0.0f;
            this.y = 0.0f;
            this.borderWidth = 0.0f;
            this.borderColor = 0;
            this.dkK = 0.0f;
        }

        @Override // com.baidu.swan.apps.w.a.a.d.C0500d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("x", 0.0d));
                this.y = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.borderWidth = (float) jSONObject.optDouble("borderWidth", 0.0d);
                this.borderColor = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("borderColor"), 0);
                this.dkK = (float) jSONObject.optDouble("borderRadius", 0.0d);
            }
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
    public static class C0500d implements com.baidu.swan.apps.model.a {
        private final d dkN;
        public String content = "";
        public int color = ViewCompat.MEASURED_STATE_MASK;
        public float dkL = com.baidu.swan.apps.w.a.d.u(10.0d);
        public int bgColor = 0;
        public float dkM = 0.0f;
        public String textAlign = "center";

        C0500d(d dVar) {
            this.dkN = dVar;
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            float u;
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                if (jSONObject.has("fontSize")) {
                    u = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    u = com.baidu.swan.apps.w.a.d.u(10.0d);
                }
                this.dkL = u;
                this.bgColor = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("bgColor"), 0);
                this.dkM = com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
