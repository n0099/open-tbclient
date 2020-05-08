package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final Type BP;
    private final com.airbnb.lottie.model.a.b DX;
    private final com.airbnb.lottie.model.a.b DY;
    private final com.airbnb.lottie.model.a.b DZ;
    private final m<PointF, PointF> Du;
    private final com.airbnb.lottie.model.a.b Dw;
    private final com.airbnb.lottie.model.a.b Ea;
    private final com.airbnb.lottie.model.a.b Eb;
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
        this.BP = type;
        this.DX = bVar;
        this.Du = mVar;
        this.Dw = bVar2;
        this.DY = bVar3;
        this.DZ = bVar4;
        this.Ea = bVar5;
        this.Eb = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type il() {
        return this.BP;
    }

    public com.airbnb.lottie.model.a.b im() {
        return this.DX;
    }

    public m<PointF, PointF> hN() {
        return this.Du;
    }

    public com.airbnb.lottie.model.a.b hP() {
        return this.Dw;
    }

    public com.airbnb.lottie.model.a.b in() {
        return this.DY;
    }

    public com.airbnb.lottie.model.a.b ip() {
        return this.DZ;
    }

    public com.airbnb.lottie.model.a.b iq() {
        return this.Ea;
    }

    public com.airbnb.lottie.model.a.b ir() {
        return this.Eb;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
