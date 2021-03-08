package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class PolystarShape implements b {
    private final Type Fs;
    private final m<PointF, PointF> GR;
    private final com.airbnb.lottie.model.a.b GV;
    private final com.airbnb.lottie.model.a.b Ht;
    private final com.airbnb.lottie.model.a.b Hu;
    private final com.airbnb.lottie.model.a.b Hv;
    private final com.airbnb.lottie.model.a.b Hw;
    private final com.airbnb.lottie.model.a.b Hx;
    private final String name;

    /* loaded from: classes5.dex */
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
        this.Fs = type;
        this.Ht = bVar;
        this.GR = mVar;
        this.GV = bVar2;
        this.Hu = bVar3;
        this.Hv = bVar4;
        this.Hw = bVar5;
        this.Hx = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type jB() {
        return this.Fs;
    }

    public com.airbnb.lottie.model.a.b jC() {
        return this.Ht;
    }

    public m<PointF, PointF> je() {
        return this.GR;
    }

    public com.airbnb.lottie.model.a.b jg() {
        return this.GV;
    }

    public com.airbnb.lottie.model.a.b jD() {
        return this.Hu;
    }

    public com.airbnb.lottie.model.a.b jE() {
        return this.Hv;
    }

    public com.airbnb.lottie.model.a.b jF() {
        return this.Hw;
    }

    public com.airbnb.lottie.model.a.b jG() {
        return this.Hx;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
