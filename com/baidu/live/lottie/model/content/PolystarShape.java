package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes10.dex */
public class PolystarShape implements b {
    private final Type bsD;
    private final com.baidu.live.lottie.model.a.b btQ;
    private final com.baidu.live.lottie.model.a.b btR;
    private final com.baidu.live.lottie.model.a.b btS;
    private final com.baidu.live.lottie.model.a.b btT;
    private final com.baidu.live.lottie.model.a.b btU;
    private final m<PointF, PointF> btw;
    private final com.baidu.live.lottie.model.a.b bty;
    private final String name;

    /* loaded from: classes10.dex */
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

    public PolystarShape(String str, Type type, com.baidu.live.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.baidu.live.lottie.model.a.b bVar2, com.baidu.live.lottie.model.a.b bVar3, com.baidu.live.lottie.model.a.b bVar4, com.baidu.live.lottie.model.a.b bVar5, com.baidu.live.lottie.model.a.b bVar6) {
        this.name = str;
        this.bsD = type;
        this.btQ = bVar;
        this.btw = mVar;
        this.bty = bVar2;
        this.btR = bVar3;
        this.btS = bVar4;
        this.btT = bVar5;
        this.btU = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type NO() {
        return this.bsD;
    }

    public com.baidu.live.lottie.model.a.b NP() {
        return this.btQ;
    }

    public m<PointF, PointF> Nv() {
        return this.btw;
    }

    public com.baidu.live.lottie.model.a.b Nx() {
        return this.bty;
    }

    public com.baidu.live.lottie.model.a.b NQ() {
        return this.btR;
    }

    public com.baidu.live.lottie.model.a.b NR() {
        return this.btS;
    }

    public com.baidu.live.lottie.model.a.b NS() {
        return this.btT;
    }

    public com.baidu.live.lottie.model.a.b NT() {
        return this.btU;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.m(hVar, aVar, this);
    }
}
