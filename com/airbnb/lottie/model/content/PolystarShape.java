package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes4.dex */
public class PolystarShape implements b {
    private final Type gk;
    private final m<PointF, PointF> hL;
    private final com.airbnb.lottie.model.a.b hN;
    private final com.airbnb.lottie.model.a.b iA;
    private final com.airbnb.lottie.model.a.b iq;
    private final com.airbnb.lottie.model.a.b ir;
    private final com.airbnb.lottie.model.a.b iu;
    private final com.airbnb.lottie.model.a.b iz;
    private final String name;

    /* loaded from: classes4.dex */
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
        this.gk = type;
        this.iq = bVar;
        this.hL = mVar;
        this.hN = bVar2;
        this.ir = bVar3;
        this.iu = bVar4;
        this.iz = bVar5;
        this.iA = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type cM() {
        return this.gk;
    }

    public com.airbnb.lottie.model.a.b cN() {
        return this.iq;
    }

    public m<PointF, PointF> cp() {
        return this.hL;
    }

    public com.airbnb.lottie.model.a.b cr() {
        return this.hN;
    }

    public com.airbnb.lottie.model.a.b cO() {
        return this.ir;
    }

    public com.airbnb.lottie.model.a.b cP() {
        return this.iu;
    }

    public com.airbnb.lottie.model.a.b cQ() {
        return this.iz;
    }

    public com.airbnb.lottie.model.a.b cR() {
        return this.iA;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
