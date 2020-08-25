package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes18.dex */
public class PolystarShape implements b {
    private final Type Db;
    private final m<PointF, PointF> ED;
    private final com.airbnb.lottie.model.a.b EF;
    private final com.airbnb.lottie.model.a.b Fd;
    private final com.airbnb.lottie.model.a.b Fe;
    private final com.airbnb.lottie.model.a.b Ff;
    private final com.airbnb.lottie.model.a.b Fg;
    private final com.airbnb.lottie.model.a.b Fh;
    private final String name;

    /* loaded from: classes18.dex */
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
        this.Db = type;
        this.Fd = bVar;
        this.ED = mVar;
        this.EF = bVar2;
        this.Fe = bVar3;
        this.Ff = bVar4;
        this.Fg = bVar5;
        this.Fh = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type kb() {
        return this.Db;
    }

    public com.airbnb.lottie.model.a.b kc() {
        return this.Fd;
    }

    public m<PointF, PointF> jE() {
        return this.ED;
    }

    public com.airbnb.lottie.model.a.b jG() {
        return this.EF;
    }

    public com.airbnb.lottie.model.a.b kd() {
        return this.Fe;
    }

    public com.airbnb.lottie.model.a.b ke() {
        return this.Ff;
    }

    public com.airbnb.lottie.model.a.b kf() {
        return this.Fg;
    }

    public com.airbnb.lottie.model.a.b kg() {
        return this.Fh;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
