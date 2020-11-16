package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class PolystarShape implements b {
    private final Type Ds;
    private final m<PointF, PointF> EV;
    private final com.airbnb.lottie.model.a.b EX;
    private final com.airbnb.lottie.model.a.b Fu;
    private final com.airbnb.lottie.model.a.b Fv;
    private final com.airbnb.lottie.model.a.b Fw;
    private final com.airbnb.lottie.model.a.b Fx;
    private final com.airbnb.lottie.model.a.b Fy;
    private final String name;

    /* loaded from: classes16.dex */
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
        this.Ds = type;
        this.Fu = bVar;
        this.EV = mVar;
        this.EX = bVar2;
        this.Fv = bVar3;
        this.Fw = bVar4;
        this.Fx = bVar5;
        this.Fy = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type kd() {
        return this.Ds;
    }

    public com.airbnb.lottie.model.a.b ke() {
        return this.Fu;
    }

    public m<PointF, PointF> jG() {
        return this.EV;
    }

    public com.airbnb.lottie.model.a.b jI() {
        return this.EX;
    }

    public com.airbnb.lottie.model.a.b kf() {
        return this.Fv;
    }

    public com.airbnb.lottie.model.a.b kg() {
        return this.Fw;
    }

    public com.airbnb.lottie.model.a.b kh() {
        return this.Fx;
    }

    public com.airbnb.lottie.model.a.b ki() {
        return this.Fy;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
