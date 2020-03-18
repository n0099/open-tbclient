package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final Type gn;
    private final m<PointF, PointF> hO;
    private final com.airbnb.lottie.model.a.b hQ;
    private final com.airbnb.lottie.model.a.b iA;
    private final com.airbnb.lottie.model.a.b iB;
    private final com.airbnb.lottie.model.a.b iC;
    private final com.airbnb.lottie.model.a.b iu;
    private final com.airbnb.lottie.model.a.b iz;
    private final String name;

    /* loaded from: classes6.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, com.airbnb.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.b bVar2, com.airbnb.lottie.model.a.b bVar3, com.airbnb.lottie.model.a.b bVar4, com.airbnb.lottie.model.a.b bVar5, com.airbnb.lottie.model.a.b bVar6) {
        this.name = str;
        this.gn = type;
        this.iu = bVar;
        this.hO = mVar;
        this.hQ = bVar2;
        this.iz = bVar3;
        this.iA = bVar4;
        this.iB = bVar5;
        this.iC = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type cN() {
        return this.gn;
    }

    public com.airbnb.lottie.model.a.b cO() {
        return this.iu;
    }

    public m<PointF, PointF> cq() {
        return this.hO;
    }

    public com.airbnb.lottie.model.a.b cs() {
        return this.hQ;
    }

    public com.airbnb.lottie.model.a.b cP() {
        return this.iz;
    }

    public com.airbnb.lottie.model.a.b cQ() {
        return this.iA;
    }

    public com.airbnb.lottie.model.a.b cR() {
        return this.iB;
    }

    public com.airbnb.lottie.model.a.b cS() {
        return this.iC;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
