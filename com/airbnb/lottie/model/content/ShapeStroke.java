package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.a hK;
    private final com.airbnb.lottie.model.a.d hS;
    @Nullable
    private final com.airbnb.lottie.model.a.b iG;
    private final com.airbnb.lottie.model.a.b ii;
    private final LineCapType ij;
    private final LineJoinType ik;
    private final float il;
    private final List<com.airbnb.lottie.model.a.b> im;
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
        this.iG = bVar;
        this.im = list;
        this.hK = aVar;
        this.hS = dVar;
        this.ii = bVar2;
        this.ij = lineCapType;
        this.ik = lineJoinType;
        this.il = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a cZ() {
        return this.hK;
    }

    public com.airbnb.lottie.model.a.d ct() {
        return this.hS;
    }

    public com.airbnb.lottie.model.a.b cE() {
        return this.ii;
    }

    public List<com.airbnb.lottie.model.a.b> cH() {
        return this.im;
    }

    public com.airbnb.lottie.model.a.b cI() {
        return this.iG;
    }

    public LineCapType cF() {
        return this.ij;
    }

    public LineJoinType cG() {
        return this.ik;
    }

    public float cJ() {
        return this.il;
    }
}
