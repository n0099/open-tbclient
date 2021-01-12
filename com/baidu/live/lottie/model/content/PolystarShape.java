package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes9.dex */
public class PolystarShape implements b {
    private final m<PointF, PointF> bpU;
    private final com.baidu.live.lottie.model.a.b bpW;
    private final Type bpc;
    private final com.baidu.live.lottie.model.a.b bqo;
    private final com.baidu.live.lottie.model.a.b bqp;
    private final com.baidu.live.lottie.model.a.b bqq;
    private final com.baidu.live.lottie.model.a.b bqr;
    private final com.baidu.live.lottie.model.a.b bqs;
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
        this.bpc = type;
        this.bqo = bVar;
        this.bpU = mVar;
        this.bpW = bVar2;
        this.bqp = bVar3;
        this.bqq = bVar4;
        this.bqr = bVar5;
        this.bqs = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type Mq() {
        return this.bpc;
    }

    public com.baidu.live.lottie.model.a.b Mr() {
        return this.bqo;
    }

    public m<PointF, PointF> LX() {
        return this.bpU;
    }

    public com.baidu.live.lottie.model.a.b LZ() {
        return this.bpW;
    }

    public com.baidu.live.lottie.model.a.b Ms() {
        return this.bqp;
    }

    public com.baidu.live.lottie.model.a.b Mt() {
        return this.bqq;
    }

    public com.baidu.live.lottie.model.a.b Mu() {
        return this.bqr;
    }

    public com.baidu.live.lottie.model.a.b Mv() {
        return this.bqs;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.m(hVar, aVar, this);
    }
}
