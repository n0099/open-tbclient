package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.model.a.b;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type oG;
    private final com.airbnb.lottie.model.a.b qL;
    private final com.airbnb.lottie.model.a.b qT;
    private final com.airbnb.lottie.model.a.b qU;

    /* loaded from: classes2.dex */
    public enum Type {
        Simultaneously,
        Individually;

        static Type forId(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    throw new IllegalArgumentException("Unknown trim path type " + i);
            }
        }
    }

    private ShapeTrimPath(String str, Type type, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, com.airbnb.lottie.model.a.b bVar3) {
        this.name = str;
        this.oG = type;
        this.qT = bVar;
        this.qU = bVar2;
        this.qL = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type cV() {
        return this.oG;
    }

    public com.airbnb.lottie.model.a.b en() {
        return this.qU;
    }

    public com.airbnb.lottie.model.a.b eo() {
        return this.qT;
    }

    public com.airbnb.lottie.model.a.b eh() {
        return this.qL;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.qT + ", end: " + this.qU + ", offset: " + this.qL + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ShapeTrimPath B(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return new ShapeTrimPath(jSONObject.optString("nm"), Type.forId(jSONObject.optInt(Config.MODEL, 1)), b.a.a(jSONObject.optJSONObject("s"), eVar, false), b.a.a(jSONObject.optJSONObject("e"), eVar, false), b.a.a(jSONObject.optJSONObject(Config.OS), eVar, false));
        }
    }
}
