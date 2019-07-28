package com.baidu.swan.apps.x.a.a;

import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();
    public b aAR;
    public c aAS;
    public a aAT;
    public com.baidu.swan.apps.x.a.a.c aAr;
    public String id = "";
    public String title = "";
    public String aAN = "";
    public double aAH = 0.0d;
    public double aAQ = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aAr = new com.baidu.swan.apps.x.a.a.c();
            this.aAr.parseFromJson(jSONObject);
            if (this.aAr.isValid()) {
                this.id = jSONObject.optString("markerId");
                this.title = jSONObject.optString("title");
                this.aAN = jSONObject.optString("iconPath");
                this.aAH = jSONObject.optDouble("rotate", 0.0d);
                this.aAQ = Math.abs(jSONObject.optDouble("alpha", 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(z.ad(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(z.ad(jSONObject.optInt("height"))) : -1;
                this.aAR = new b();
                this.aAR.parseFromJson(jSONObject.optJSONObject("callout"));
                this.aAS = new c();
                this.aAS.parseFromJson(jSONObject.optJSONObject("label"));
                this.aAT = new a();
                this.aAT.parseFromJson(jSONObject.optJSONObject("anchor"));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return this.aAr != null && this.aAr.isValid();
    }

    /* loaded from: classes2.dex */
    public static class b extends C0196d {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static final String TAG = b.class.getSimpleName();
        public String abR;
        public float abe;
        public int bgColor;

        public b() {
            super();
            this.abe = 0.0f;
            this.abR = "BYCLICK";
            this.bgColor = -1;
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0196d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.abe = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderRadius", 0.0d)));
                this.abR = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
                this.bgColor = com.baidu.swan.apps.x.a.d.B(jSONObject.optString("bgColor"), -1);
            }
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0196d, com.baidu.swan.apps.model.a
        public boolean isValid() {
            return super.isValid();
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends C0196d implements com.baidu.swan.apps.model.a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static final String TAG = c.class.getSimpleName();
        public float aAU;
        public float abe;
        public int borderColor;
        public float x;
        public float y;

        public c() {
            super();
            this.x = 0.0f;
            this.y = 0.0f;
            this.aAU = 0.0f;
            this.borderColor = 0;
            this.abe = 0.0f;
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0196d, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d));
                this.y = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("y", 0.0d));
                if (this.x == 0.0f && this.y == 0.0f) {
                    this.x = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("anchorX", 0.0d));
                    this.y = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("anchorY", 0.0d));
                }
                this.aAU = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderWidth", 0.0d)));
                this.borderColor = com.baidu.swan.apps.x.a.d.B(jSONObject.optString("borderColor"), 0);
                this.abe = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("borderRadius", 0.0d)));
            }
        }

        @Override // com.baidu.swan.apps.x.a.a.d.C0196d, com.baidu.swan.apps.model.a
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
    public static class C0196d implements com.baidu.swan.apps.model.a {
        public float aAV;
        public float abk;
        public int bgColor;
        public int color;
        public String content;
        public String textAlign;

        private C0196d() {
            this.content = "";
            this.color = ViewCompat.MEASURED_STATE_MASK;
            this.abk = com.baidu.swan.apps.x.a.d.f(10.0d);
            this.bgColor = 0;
            this.aAV = 0.0f;
            this.textAlign = "center";
        }

        @Override // com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = com.baidu.swan.apps.x.a.d.B(jSONObject.optString("color"), ViewCompat.MEASURED_STATE_MASK);
                this.abk = jSONObject.has("fontSize") ? Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("fontSize", 0.0d))) : com.baidu.swan.apps.x.a.d.f(10.0d);
                this.bgColor = com.baidu.swan.apps.x.a.d.B(jSONObject.optString("bgColor"), 0);
                this.aAV = com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("padding", 0.0d));
                this.textAlign = jSONObject.has("textAlign") ? jSONObject.optString("textAlign") : "center";
            }
        }

        @Override // com.baidu.swan.apps.model.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
