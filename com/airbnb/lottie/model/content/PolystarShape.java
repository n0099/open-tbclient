package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final Type Cp;
    private final m<PointF, PointF> DY;
    private final com.airbnb.lottie.model.a.b EA;
    private final com.airbnb.lottie.model.a.b EB;
    private final com.airbnb.lottie.model.a.b Ea;
    private final com.airbnb.lottie.model.a.b Ex;
    private final com.airbnb.lottie.model.a.b Ey;
    private final com.airbnb.lottie.model.a.b Ez;
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
        this.Cp = type;
        this.Ex = bVar;
        this.DY = mVar;
        this.Ea = bVar2;
        this.Ey = bVar3;
        this.Ez = bVar4;
        this.EA = bVar5;
        this.EB = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type iC() {
        return this.Cp;
    }

    public com.airbnb.lottie.model.a.b iD() {
        return this.Ex;
    }

    public m<PointF, PointF> ie() {
        return this.DY;
    }

    public com.airbnb.lottie.model.a.b ig() {
        return this.Ea;
    }

    public com.airbnb.lottie.model.a.b iE() {
        return this.Ey;
    }

    public com.airbnb.lottie.model.a.b iF() {
        return this.Ez;
    }

    public com.airbnb.lottie.model.a.b iG() {
        return this.EA;
    }

    public com.airbnb.lottie.model.a.b iH() {
        return this.EB;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
