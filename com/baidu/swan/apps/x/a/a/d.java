package com.baidu.swan.apps.x.a.a;

import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.x;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    public com.baidu.swan.apps.x.a.a.c ayL;
    public b azk;
    public c azl;
    public a azm;
    public String id = "";
    public String title = "";
    public String azg = "";
    public double azb = 0.0d;
    public double azj = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ayL = new com.baidu.swan.apps.x.a.a.c();
            this.ayL.parseFromJson(jSONObject);
            if (this.ayL.isValid()) {
                this.id = jSONObject.optString("markerId");
                this.title = jSONObject.optString("title");
                this.azg = jSONObject.optString("iconPath");
                this.azb = jSONObject.optDouble("rotate", 0.0d);
                this.azj = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(x.ad(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(x.ad(jSONObject.optInt("height"))) : -1;
                this.azk = new b();
                this.azk.parseFromJson(jSONObject.optJSONObject("callout"));
                this.azl = new c();
                this.azl.parseFromJson(jSONObject.optJSONObject("label"));
                this.azm = new a();
                this.azm.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.ayL != null && this.ayL.isValid();
    }

    /* loaded from: classes2.dex */
    public static class b extends C0186d {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static final String TAG = b.class.getSimpleName();
        public float acT;
        public String adF;
        public int bgColor;

        public b() {
            super();
            this.acT = 0.0f;
            this.adF = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0186d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.acT = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderRadius", 0.0d)));
                this.adF = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("bgColor"), -1);
            }
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0186d, com.baidu.swan.apps.model.a
        public boolean isValid() {
            return super.isValid();
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends C0186d implements com.baidu.swan.apps.model.a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static final String TAG = c.class.getSimpleName();
        public float acT;
        public float azn;
        public int borderColor;
        public float x;
        public float y;

        public c() {
            super();
            this.x = 0.0f;
            this.y = 0.0f;
            this.azn = 0.0f;
            this.borderColor = 0;
            this.acT = 0.0f;
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0186d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d));
                this.y = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.azn = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderWidth", 0.0d)));
                this.borderColor = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("borderColor"), 0);
                this.acT = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderRadius", 0.0d)));
            }
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0186d, com.baidu.swan.apps.model.a
        public boolean isValid() {
            return super.isValid();
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements com.baidu.swan.apps.model.a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static final String TAG = a.class.getSimpleName();
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
    /* renamed from: com.baidu.swan.apps.x.a.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0186d implements com.baidu.swan.apps.model.a {
        public float acZ;
        public float azo;
        public int bgColor;
        public int color;
        public String content;
        public String textAlign;

        private C0186d() {
            this.content = "";
            this.color = ViewCompat.MEASURED_STATE_MASK;
            this.acZ = com.baidu.swan.apps.x.a.d.f(10.0d);
            this.bgColor = 0;
            this.azo = 0.0f;
            this.textAlign = "center";
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                this.acZ = jSONObject.has("fontSize") ? Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("fontSize", 0.0d))) : com.baidu.swan.apps.x.a.d.f(10.0d);
                this.bgColor = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("bgColor"), 0);
                this.azo = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
