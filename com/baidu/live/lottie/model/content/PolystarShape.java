package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes9.dex */
public class PolystarShape implements b {
    private final m<PointF, PointF> buX;
    private final com.baidu.live.lottie.model.a.b buZ;
    private final Type bue;
    private final com.baidu.live.lottie.model.a.b bvr;
    private final com.baidu.live.lottie.model.a.b bvs;
    private final com.baidu.live.lottie.model.a.b bvt;
    private final com.baidu.live.lottie.model.a.b bvu;
    private final com.baidu.live.lottie.model.a.b bvv;
    private final String name;

    /* loaded from: classes9.dex */
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
        this.bue = type;
        this.bvr = bVar;
        this.buX = mVar;
        this.buZ = bVar2;
        this.bvs = bVar3;
        this.bvt = bVar4;
        this.bvu = bVar5;
        this.bvv = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type NR() {
        return this.bue;
    }

    public com.baidu.live.lottie.model.a.b NS() {
        return this.bvr;
    }

    public m<PointF, PointF> Ny() {
        return this.buX;
    }

    public com.baidu.live.lottie.model.a.b NA() {
        return this.buZ;
    }

    public com.baidu.live.lottie.model.a.b NT() {
        return this.bvs;
    }

    public com.baidu.live.lottie.model.a.b NU() {
        return this.bvt;
    }

    public com.baidu.live.lottie.model.a.b NV() {
        return this.bvu;
    }

    public com.baidu.live.lottie.model.a.b NW() {
        return this.bvv;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.m(hVar, aVar, this);
    }
}
