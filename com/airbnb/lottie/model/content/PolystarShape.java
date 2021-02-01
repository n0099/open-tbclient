package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes4.dex */
public class PolystarShape implements b {
    private final Type DZ;
    private final com.airbnb.lottie.model.a.b FX;
    private final com.airbnb.lottie.model.a.b FY;
    private final com.airbnb.lottie.model.a.b FZ;
    private final m<PointF, PointF> Fw;
    private final com.airbnb.lottie.model.a.b Fy;
    private final com.airbnb.lottie.model.a.b Ga;
    private final com.airbnb.lottie.model.a.b Gb;
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
        this.DZ = type;
        this.FX = bVar;
        this.Fw = mVar;
        this.Fy = bVar2;
        this.FY = bVar3;
        this.FZ = bVar4;
        this.Ga = bVar5;
        this.Gb = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type jB() {
        return this.DZ;
    }

    public com.airbnb.lottie.model.a.b jC() {
        return this.FX;
    }

    public m<PointF, PointF> je() {
        return this.Fw;
    }

    public com.airbnb.lottie.model.a.b jg() {
        return this.Fy;
    }

    public com.airbnb.lottie.model.a.b jD() {
        return this.FY;
    }

    public com.airbnb.lottie.model.a.b jE() {
        return this.FZ;
    }

    public com.airbnb.lottie.model.a.b jF() {
        return this.Ga;
    }

    public com.airbnb.lottie.model.a.b jG() {
        return this.Gb;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
