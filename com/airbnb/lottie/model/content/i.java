package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.d;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i implements b {
    private final String name;
    private final Path.FillType oC;
    @Nullable
    private final com.airbnb.lottie.model.a.a oh;
    @Nullable
    private final com.airbnb.lottie.model.a.d or;
    private final boolean pd;

    private i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.pd = z;
        this.oC = fillType;
        this.oh = aVar;
        this.or = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static i v(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            com.airbnb.lottie.model.a.a d = optJSONObject != null ? a.C0008a.d(optJSONObject, eVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Config.OS);
            return new i(optString, jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, d, optJSONObject2 != null ? d.a.g(optJSONObject2, eVar) : null);
        }
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a dC() {
        return this.oh;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d cU() {
        return this.or;
    }

    public Path.FillType de() {
        return this.oC;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=" + (this.oh == null ? "null" : Integer.toHexString(this.oh.cH().intValue())) + ", fillEnabled=" + this.pd + ", opacity=" + (this.or == null ? "null" : this.or.cH()) + '}';
    }
}
