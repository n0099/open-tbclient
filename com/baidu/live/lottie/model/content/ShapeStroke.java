package com.baidu.live.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.a.q;
import java.util.List;
/* loaded from: classes10.dex */
public class ShapeStroke implements b {
    private final float FT;
    private final List<com.baidu.live.lottie.model.a.b> FU;
    private final com.baidu.live.lottie.model.a.a buD;
    private final com.baidu.live.lottie.model.a.d buL;
    private final com.baidu.live.lottie.model.a.b buV;
    private final LineCapType buW;
    private final LineJoinType buX;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bvj;
    private final String name;

    /* loaded from: classes10.dex */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            switch (this) {
                case Butt:
                    return Paint.Cap.BUTT;
                case Round:
                    return Paint.Cap.ROUND;
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    /* loaded from: classes10.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            switch (this) {
                case Bevel:
                    return Paint.Join.BEVEL;
                case Miter:
                    return Paint.Join.MITER;
                case Round:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    public ShapeStroke(String str, @Nullable com.baidu.live.lottie.model.a.b bVar, List<com.baidu.live.lottie.model.a.b> list, com.baidu.live.lottie.model.a.a aVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.bvj = bVar;
        this.FU = list;
        this.buD = aVar;
        this.buL = dVar;
        this.buV = bVar2;
        this.buW = lineCapType;
        this.buX = lineJoinType;
        this.FT = f;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new q(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.a Qv() {
        return this.buD;
    }

    public com.baidu.live.lottie.model.a.d PV() {
        return this.buL;
    }

    public com.baidu.live.lottie.model.a.b Qe() {
        return this.buV;
    }

    public List<com.baidu.live.lottie.model.a.b> jw() {
        return this.FU;
    }

    public com.baidu.live.lottie.model.a.b Qh() {
        return this.bvj;
    }

    public LineCapType Qf() {
        return this.buW;
    }

    public LineJoinType Qg() {
        return this.buX;
    }

    public float jy() {
        return this.FT;
    }
}
