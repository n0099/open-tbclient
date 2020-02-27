package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final Type go;
    private final m<PointF, PointF> hP;
    private final com.airbnb.lottie.model.a.b hR;
    private final com.airbnb.lottie.model.a.b iA;
    private final com.airbnb.lottie.model.a.b iB;
    private final com.airbnb.lottie.model.a.b iC;
    private final com.airbnb.lottie.model.a.b iD;
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
        this.go = type;
        this.iz = bVar;
        this.hP = mVar;
        this.hR = bVar2;
        this.iA = bVar3;
        this.iB = bVar4;
        this.iC = bVar5;
        this.iD = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type cN() {
        return this.go;
    }

    public com.airbnb.lottie.model.a.b cO() {
        return this.iz;
    }

    public m<PointF, PointF> cq() {
        return this.hP;
    }

    public com.airbnb.lottie.model.a.b cs() {
        return this.hR;
    }

    public com.airbnb.lottie.model.a.b cP() {
        return this.iA;
    }

    public com.airbnb.lottie.model.a.b cQ() {
        return this.iB;
    }

    public com.airbnb.lottie.model.a.b cR() {
        return this.iC;
    }

    public com.airbnb.lottie.model.a.b cS() {
        return this.iD;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
