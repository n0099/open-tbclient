package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.model.a.b;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShapeTrimPath implements b {
    private final Type mm;
    private final String name;
    private final com.airbnb.lottie.model.a.b oD;
    private final com.airbnb.lottie.model.a.b oE;
    private final com.airbnb.lottie.model.a.b ov;

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
        this.mm = type;
        this.oD = bVar;
        this.oE = bVar2;
        this.ov = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type bQ() {
        return this.mm;
    }

    public com.airbnb.lottie.model.a.b di() {
        return this.oE;
    }

    public com.airbnb.lottie.model.a.b dj() {
        return this.oD;
    }

    public com.airbnb.lottie.model.a.b dc() {
        return this.ov;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.oD + ", end: " + this.oE + ", offset: " + this.ov + "}";
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
