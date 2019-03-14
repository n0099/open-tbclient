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
    public com.baidu.swan.apps.x.a.a.c ayI;
    public b azh;
    public c azi;
    public a azj;
    public String id = "";
    public String title = "";
    public String azd = "";
    public double ayY = 0.0d;
    public double azg = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ayI = new com.baidu.swan.apps.x.a.a.c();
            this.ayI.parseFromJson(jSONObject);
            if (this.ayI.isValid()) {
                this.id = jSONObject.optString("markerId");
                this.title = jSONObject.optString("title");
                this.azd = jSONObject.optString("iconPath");
                this.ayY = jSONObject.optDouble("rotate", 0.0d);
                this.azg = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(x.ad(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(x.ad(jSONObject.optInt("height"))) : -1;
                this.azh = new b();
                this.azh.parseFromJson(jSONObject.optJSONObject("callout"));
                this.azi = new c();
                this.azi.parseFromJson(jSONObject.optJSONObject("label"));
                this.azj = new a();
                this.azj.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.ayI != null && this.ayI.isValid();
    }

    /* loaded from: classes2.dex */
    public static class b extends C0186d {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static final String TAG = b.class.getSimpleName();
        public float acO;
        public String adA;
        public int bgColor;

        public b() {
            super();
            this.acO = 0.0f;
            this.adA = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0186d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.acO = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderRadius", 0.0d)));
                this.adA = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
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
        public float acO;
        public float azk;
        public int borderColor;
        public float x;
        public float y;

        public c() {
            super();
            this.x = 0.0f;
            this.y = 0.0f;
            this.azk = 0.0f;
            this.borderColor = 0;
            this.acO = 0.0f;
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
                this.azk = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderWidth", 0.0d)));
                this.borderColor = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("borderColor"), 0);
                this.acO = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderRadius", 0.0d)));
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
        public float acU;
        public float azl;
        public int bgColor;
        public int color;
        public String content;
        public String textAlign;

        private C0186d() {
            this.content = "";
            this.color = ViewCompat.MEASURED_STATE_MASK;
            this.acU = com.baidu.swan.apps.x.a.d.f(10.0d);
            this.bgColor = 0;
            this.azl = 0.0f;
            this.textAlign = "center";
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                this.acU = jSONObject.has("fontSize") ? Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("fontSize", 0.0d))) : com.baidu.swan.apps.x.a.d.f(10.0d);
                this.bgColor = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("bgColor"), 0);
                this.azl = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
