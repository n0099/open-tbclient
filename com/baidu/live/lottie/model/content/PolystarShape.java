package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes10.dex */
public class PolystarShape implements b {
    private final Type btP;
    private final m<PointF, PointF> buI;
    private final com.baidu.live.lottie.model.a.b buK;
    private final com.baidu.live.lottie.model.a.b bvc;
    private final com.baidu.live.lottie.model.a.b bvd;
    private final com.baidu.live.lottie.model.a.b bve;
    private final com.baidu.live.lottie.model.a.b bvf;
    private final com.baidu.live.lottie.model.a.b bvg;
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
        this.btP = type;
        this.bvc = bVar;
        this.buI = mVar;
        this.buK = bVar2;
        this.bvd = bVar3;
        this.bve = bVar4;
        this.bvf = bVar5;
        this.bvg = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type Ql() {
        return this.btP;
    }

    public com.baidu.live.lottie.model.a.b Qm() {
        return this.bvc;
    }

    public m<PointF, PointF> PS() {
        return this.buI;
    }

    public com.baidu.live.lottie.model.a.b PU() {
        return this.buK;
    }

    public com.baidu.live.lottie.model.a.b Qn() {
        return this.bvd;
    }

    public com.baidu.live.lottie.model.a.b Qo() {
        return this.bve;
    }

    public com.baidu.live.lottie.model.a.b Qp() {
        return this.bvf;
    }

    public com.baidu.live.lottie.model.a.b Qq() {
        return this.bvg;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.m(hVar, aVar, this);
    }
}
