package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.model.a.b;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type pu;
    private final com.airbnb.lottie.model.a.b rD;
    private final com.airbnb.lottie.model.a.b rE;
    private final com.airbnb.lottie.model.a.b rv;

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
        this.pu = type;
        this.rD = bVar;
        this.rE = bVar2;
        this.rv = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dl() {
        return this.pu;
    }

    public com.airbnb.lottie.model.a.b eD() {
        return this.rE;
    }

    public com.airbnb.lottie.model.a.b eE() {
        return this.rD;
    }

    public com.airbnb.lottie.model.a.b ex() {
        return this.rv;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.rD + ", end: " + this.rE + ", offset: " + this.rv + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ShapeTrimPath B(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return new ShapeTrimPath(jSONObject.optString("nm"), Type.forId(jSONObject.optInt("m", 1)), b.a.a(jSONObject.optJSONObject(NotifyType.SOUND), eVar, false), b.a.a(jSONObject.optJSONObject("e"), eVar, false), b.a.a(jSONObject.optJSONObject("o"), eVar, false));
        }
    }
}
