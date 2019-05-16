package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.l;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PolystarShape implements b {
    private final Type mz;
    private final String name;
    private final com.airbnb.lottie.model.a.b oP;
    private final com.airbnb.lottie.model.a.b oQ;
    private final com.airbnb.lottie.model.a.b oR;
    private final com.airbnb.lottie.model.a.b oS;
    private final com.airbnb.lottie.model.a.b oT;
    private final m<PointF, PointF> om;
    private final com.airbnb.lottie.model.a.b oo;

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
        this.mz = type;
        this.oP = bVar;
        this.om = mVar;
        this.oo = bVar2;
        this.oQ = bVar3;
        this.oR = bVar4;
        this.oS = bVar5;
        this.oT = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dj() {
        return this.mz;
    }

    public com.airbnb.lottie.model.a.b dk() {
        return this.oP;
    }

    public m<PointF, PointF> cL() {
        return this.om;
    }

    public com.airbnb.lottie.model.a.b cN() {
        return this.oo;
    }

    public com.airbnb.lottie.model.a.b dl() {
        return this.oQ;
    }

    public com.airbnb.lottie.model.a.b dm() {
        return this.oR;
    }

    public com.airbnb.lottie.model.a.b dn() {
        return this.oS;
    }

    /* renamed from: do  reason: not valid java name */
    public com.airbnb.lottie.model.a.b m6do() {
        return this.oT;
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
