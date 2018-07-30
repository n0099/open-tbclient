package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.model.a.b;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShapeTrimPath implements b {
    private final Type mc;
    private final String name;
    private final com.airbnb.lottie.model.a.b oi;
    private final com.airbnb.lottie.model.a.b ot;
    private final com.airbnb.lottie.model.a.b ou;

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
        this.mc = type;
        this.ot = bVar;
        this.ou = bVar2;
        this.oi = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type bO() {
        return this.mc;
    }

    public com.airbnb.lottie.model.a.b dg() {
        return this.ou;
    }

    public com.airbnb.lottie.model.a.b dh() {
        return this.ot;
    }

    public com.airbnb.lottie.model.a.b da() {
        return this.oi;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.ot + ", end: " + this.ou + ", offset: " + this.oi + "}";
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
