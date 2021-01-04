package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes3.dex */
public class PolystarShape implements b {
    private final Type Eb;
    private final com.airbnb.lottie.model.a.b FA;
    private final com.airbnb.lottie.model.a.b FZ;
    private final m<PointF, PointF> Fy;
    private final com.airbnb.lottie.model.a.b Ga;
    private final com.airbnb.lottie.model.a.b Gb;
    private final com.airbnb.lottie.model.a.b Gc;
    private final com.airbnb.lottie.model.a.b Gd;
    private final String name;

    /* loaded from: classes3.dex */
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
        this.Eb = type;
        this.FZ = bVar;
        this.Fy = mVar;
        this.FA = bVar2;
        this.Ga = bVar3;
        this.Gb = bVar4;
        this.Gc = bVar5;
        this.Gd = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type jC() {
        return this.Eb;
    }

    public com.airbnb.lottie.model.a.b jD() {
        return this.FZ;
    }

    public m<PointF, PointF> jf() {
        return this.Fy;
    }

    public com.airbnb.lottie.model.a.b jh() {
        return this.FA;
    }

    public com.airbnb.lottie.model.a.b jE() {
        return this.Ga;
    }

    public com.airbnb.lottie.model.a.b jF() {
        return this.Gb;
    }

    public com.airbnb.lottie.model.a.b jG() {
        return this.Gc;
    }

    public com.airbnb.lottie.model.a.b jH() {
        return this.Gd;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
