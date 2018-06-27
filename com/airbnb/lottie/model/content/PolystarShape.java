package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.l;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PolystarShape implements b {
    private final Type lV;
    private final m<PointF, PointF> nK;
    private final com.airbnb.lottie.model.a.b nM;
    private final String name;
    private final com.airbnb.lottie.model.a.b om;
    private final com.airbnb.lottie.model.a.b on;
    private final com.airbnb.lottie.model.a.b oo;
    private final com.airbnb.lottie.model.a.b oq;
    private final com.airbnb.lottie.model.a.b or;

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
        this.lV = type;
        this.om = bVar;
        this.nK = mVar;
        this.nM = bVar2;
        this.on = bVar3;
        this.oo = bVar4;
        this.oq = bVar5;
        this.or = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type cU() {
        return this.lV;
    }

    public com.airbnb.lottie.model.a.b cV() {
        return this.om;
    }

    public m<PointF, PointF> cw() {
        return this.nK;
    }

    public com.airbnb.lottie.model.a.b cy() {
        return this.nM;
    }

    public com.airbnb.lottie.model.a.b cW() {
        return this.on;
    }

    public com.airbnb.lottie.model.a.b cX() {
        return this.oo;
    }

    public com.airbnb.lottie.model.a.b cY() {
        return this.oq;
    }

    public com.airbnb.lottie.model.a.b cZ() {
        return this.or;
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
