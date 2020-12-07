package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes7.dex */
public class PolystarShape implements b {
    private final Type Em;
    private final m<PointF, PointF> FL;
    private final com.airbnb.lottie.model.a.b FN;
    private final com.airbnb.lottie.model.a.b Gm;
    private final com.airbnb.lottie.model.a.b Gn;
    private final com.airbnb.lottie.model.a.b Go;
    private final com.airbnb.lottie.model.a.b Gp;
    private final com.airbnb.lottie.model.a.b Gq;
    private final String name;

    /* loaded from: classes7.dex */
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
        this.Em = type;
        this.Gm = bVar;
        this.FL = mVar;
        this.FN = bVar2;
        this.Gn = bVar3;
        this.Go = bVar4;
        this.Gp = bVar5;
        this.Gq = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type kd() {
        return this.Em;
    }

    public com.airbnb.lottie.model.a.b ke() {
        return this.Gm;
    }

    public m<PointF, PointF> jG() {
        return this.FL;
    }

    public com.airbnb.lottie.model.a.b jI() {
        return this.FN;
    }

    public com.airbnb.lottie.model.a.b kf() {
        return this.Gn;
    }

    public com.airbnb.lottie.model.a.b kg() {
        return this.Go;
    }

    public com.airbnb.lottie.model.a.b kh() {
        return this.Gp;
    }

    public com.airbnb.lottie.model.a.b ki() {
        return this.Gq;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
