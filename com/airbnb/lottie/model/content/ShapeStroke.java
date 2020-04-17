package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.b DJ;
    private final LineCapType DK;
    private final LineJoinType DM;
    private final float DN;
    private final List<com.airbnb.lottie.model.a.b> DO;
    private final com.airbnb.lottie.model.a.a Dm;
    private final com.airbnb.lottie.model.a.d Du;
    @Nullable
    private final com.airbnb.lottie.model.a.b Eb;
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
        this.Eb = bVar;
        this.DO = list;
        this.Dm = aVar;
        this.Du = dVar;
        this.DJ = bVar2;
        this.DK = lineCapType;
        this.DM = lineJoinType;
        this.DN = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a iy() {
        return this.Dm;
    }

    public com.airbnb.lottie.model.a.d hQ() {
        return this.Du;
    }

    public com.airbnb.lottie.model.a.b ib() {
        return this.DJ;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.airbnb.lottie.model.a.b> m7if() {
        return this.DO;
    }

    public com.airbnb.lottie.model.a.b ig() {
        return this.Eb;
    }

    public LineCapType ic() {
        return this.DK;
    }

    public LineJoinType ie() {
        return this.DM;
    }

    public float ih() {
        return this.DN;
    }
}
