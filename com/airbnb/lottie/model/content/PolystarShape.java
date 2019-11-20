package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.l;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PolystarShape implements b {
    private final Type ex;
    private final com.airbnb.lottie.model.a.b gK;
    private final com.airbnb.lottie.model.a.b gL;
    private final com.airbnb.lottie.model.a.b gM;
    private final com.airbnb.lottie.model.a.b gN;
    private final com.airbnb.lottie.model.a.b gO;
    private final m<PointF, PointF> gj;
    private final com.airbnb.lottie.model.a.b gl;
    private final String name;

    /* loaded from: classes2.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        Type(int i) {
            this.value = i;
        }

        static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    private PolystarShape(String str, Type type, com.airbnb.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.b bVar2, com.airbnb.lottie.model.a.b bVar3, com.airbnb.lottie.model.a.b bVar4, com.airbnb.lottie.model.a.b bVar5, com.airbnb.lottie.model.a.b bVar6) {
        this.name = str;
        this.ex = type;
        this.gK = bVar;
        this.gj = mVar;
        this.gl = bVar2;
        this.gL = bVar3;
        this.gM = bVar4;
        this.gN = bVar5;
        this.gO = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type cJ() {
        return this.ex;
    }

    public com.airbnb.lottie.model.a.b cK() {
        return this.gK;
    }

    public m<PointF, PointF> ck() {
        return this.gj;
    }

    public com.airbnb.lottie.model.a.b cm() {
        return this.gl;
    }

    public com.airbnb.lottie.model.a.b cL() {
        return this.gL;
    }

    public com.airbnb.lottie.model.a.b cM() {
        return this.gM;
    }

    public com.airbnb.lottie.model.a.b cN() {
        return this.gN;
    }

    public com.airbnb.lottie.model.a.b cO() {
        return this.gO;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new l(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static PolystarShape s(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            com.airbnb.lottie.model.a.b bVar;
            com.airbnb.lottie.model.a.b bVar2;
            String optString = jSONObject.optString("nm");
            Type forValue = Type.forValue(jSONObject.optInt("sy"));
            com.airbnb.lottie.model.a.b a = b.a.a(jSONObject.optJSONObject("pt"), eVar, false);
            m<PointF, PointF> h = com.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar);
            com.airbnb.lottie.model.a.b a2 = b.a.a(jSONObject.optJSONObject("r"), eVar, false);
            com.airbnb.lottie.model.a.b e = b.a.e(jSONObject.optJSONObject("or"), eVar);
            com.airbnb.lottie.model.a.b a3 = b.a.a(jSONObject.optJSONObject("os"), eVar, false);
            if (forValue == Type.Star) {
                bVar2 = b.a.e(jSONObject.optJSONObject("ir"), eVar);
                bVar = b.a.a(jSONObject.optJSONObject("is"), eVar, false);
            } else {
                bVar = null;
                bVar2 = null;
            }
            return new PolystarShape(optString, forValue, a, h, a2, bVar2, e, bVar, a3);
        }
    }
}
