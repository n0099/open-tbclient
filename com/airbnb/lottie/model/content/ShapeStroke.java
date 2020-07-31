package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes20.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.a DT;
    @Nullable
    private final com.airbnb.lottie.model.a.b EF;
    private final com.airbnb.lottie.model.a.d Eb;
    private final com.airbnb.lottie.model.a.b Eo;
    private final LineCapType Ep;
    private final LineJoinType Eq;
    private final float Er;
    private final List<com.airbnb.lottie.model.a.b> Es;
    private final String name;

    /* loaded from: classes20.dex */
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

    /* loaded from: classes20.dex */
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
        this.EF = bVar;
        this.Es = list;
        this.DT = aVar;
        this.Eb = dVar;
        this.Eo = bVar2;
        this.Ep = lineCapType;
        this.Eq = lineJoinType;
        this.Er = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a iO() {
        return this.DT;
    }

    public com.airbnb.lottie.model.a.d ih() {
        return this.Eb;
    }

    public com.airbnb.lottie.model.a.b it() {
        return this.Eo;
    }

    public List<com.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    public com.airbnb.lottie.model.a.b ix() {
        return this.EF;
    }

    public LineCapType iu() {
        return this.Ep;
    }

    public LineJoinType iv() {
        return this.Eq;
    }

    public float iy() {
        return this.Er;
    }
}
