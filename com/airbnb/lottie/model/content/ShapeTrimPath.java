package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.model.a.b;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type pz;
    private final com.airbnb.lottie.model.a.b rH;
    private final com.airbnb.lottie.model.a.b rI;
    private final com.airbnb.lottie.model.a.b rz;

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
        this.pz = type;
        this.rH = bVar;
        this.rI = bVar2;
        this.rz = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dm() {
        return this.pz;
    }

    public com.airbnb.lottie.model.a.b eE() {
        return this.rI;
    }

    public com.airbnb.lottie.model.a.b eF() {
        return this.rH;
    }

    public com.airbnb.lottie.model.a.b ey() {
        return this.rz;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.rH + ", end: " + this.rI + ", offset: " + this.rz + "}";
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
