package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.l;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type pe;
    private final m<PointF, PointF> qP;
    private final com.airbnb.lottie.model.a.b qR;
    private final com.airbnb.lottie.model.a.b rr;
    private final com.airbnb.lottie.model.a.b rs;
    private final com.airbnb.lottie.model.a.b rt;
    private final com.airbnb.lottie.model.a.b ru;
    private final com.airbnb.lottie.model.a.b rv;

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
        this.pe = type;
        this.rr = bVar;
        this.qP = mVar;
        this.qR = bVar2;
        this.rs = bVar3;
        this.rt = bVar4;
        this.ru = bVar5;
        this.rv = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type er() {
        return this.pe;
    }

    public com.airbnb.lottie.model.a.b es() {
        return this.rr;
    }

    public m<PointF, PointF> dT() {
        return this.qP;
    }

    public com.airbnb.lottie.model.a.b dV() {
        return this.qR;
    }

    public com.airbnb.lottie.model.a.b et() {
        return this.rs;
    }

    public com.airbnb.lottie.model.a.b eu() {
        return this.rt;
    }

    public com.airbnb.lottie.model.a.b ev() {
        return this.ru;
    }

    public com.airbnb.lottie.model.a.b ew() {
        return this.rv;
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
            com.airbnb.lottie.model.a.b a = b.a.a(jSONObject.optJSONObject(Config.PLATFORM_TYPE), eVar, false);
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
