package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.a hJ;
    private final com.airbnb.lottie.model.a.d hR;
    @Nullable
    private final com.airbnb.lottie.model.a.b iF;
    private final com.airbnb.lottie.model.a.b ig;
    private final LineCapType ii;
    private final LineJoinType ij;
    private final float ik;
    private final List<com.airbnb.lottie.model.a.b> il;
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
        this.iF = bVar;
        this.il = list;
        this.hJ = aVar;
        this.hR = dVar;
        this.ig = bVar2;
        this.ii = lineCapType;
        this.ij = lineJoinType;
        this.ik = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a cZ() {
        return this.hJ;
    }

    public com.airbnb.lottie.model.a.d ct() {
        return this.hR;
    }

    public com.airbnb.lottie.model.a.b cE() {
        return this.ig;
    }

    public List<com.airbnb.lottie.model.a.b> cH() {
        return this.il;
    }

    public com.airbnb.lottie.model.a.b cI() {
        return this.iF;
    }

    public LineCapType cF() {
        return this.ii;
    }

    public LineJoinType cG() {
        return this.ij;
    }

    public float cJ() {
        return this.ik;
    }
}
