package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.b DN;
    private final LineCapType DO;
    private final LineJoinType DQ;
    private final float DR;
    private final List<com.airbnb.lottie.model.a.b> DS;
    private final com.airbnb.lottie.model.a.a Dp;
    private final com.airbnb.lottie.model.a.d Dx;
    @Nullable
    private final com.airbnb.lottie.model.a.b Ee;
    private final String name;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    public ShapeStroke(String str, @Nullable com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.a aVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.Ee = bVar;
        this.DS = list;
        this.Dp = aVar;
        this.Dx = dVar;
        this.DN = bVar2;
        this.DO = lineCapType;
        this.DQ = lineJoinType;
        this.DR = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a iy() {
        return this.Dp;
    }

    public com.airbnb.lottie.model.a.d hQ() {
        return this.Dx;
    }

    public com.airbnb.lottie.model.a.b ib() {
        return this.DN;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.airbnb.lottie.model.a.b> m7if() {
        return this.DS;
    }

    public com.airbnb.lottie.model.a.b ig() {
        return this.Ee;
    }

    public LineCapType ic() {
        return this.DO;
    }

    public LineJoinType ie() {
        return this.DQ;
    }

    public float ih() {
        return this.DR;
    }
}
