package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i implements b {
    @Nullable
    private final com.airbnb.lottie.model.a.a nG;
    @Nullable
    private final com.airbnb.lottie.model.a.d nO;
    private final Path.FillType nY;
    private final String name;
    private final boolean oA;

    private i(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.oA = z;
        this.nY = fillType;
        this.nG = aVar;
        this.nO = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static i v(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            com.airbnb.lottie.model.a.a d = optJSONObject != null ? a.C0007a.d(optJSONObject, eVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            return new i(optString, jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, d, optJSONObject2 != null ? d.a.g(optJSONObject2, eVar) : null);
        }
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.airbnb.lottie.model.a.a dg() {
        return this.nG;
    }

    @Nullable
    public com.airbnb.lottie.model.a.d cz() {
        return this.nO;
    }

    public Path.FillType getFillType() {
        return this.nY;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=" + (this.nG == null ? "null" : Integer.toHexString(this.nG.cm().intValue())) + ", fillEnabled=" + this.oA + ", opacity=" + (this.nO == null ? "null" : this.nO.cm()) + '}';
    }
}
