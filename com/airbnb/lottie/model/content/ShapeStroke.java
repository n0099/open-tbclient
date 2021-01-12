package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes3.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.b FN;
    private final LineCapType FO;
    private final LineJoinType FP;
    private final float FQ;
    private final List<com.airbnb.lottie.model.a.b> FR;
    private final com.airbnb.lottie.model.a.a Fr;
    private final com.airbnb.lottie.model.a.d Fz;
    @Nullable
    private final com.airbnb.lottie.model.a.b Ge;
    private final String name;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        this.Ge = bVar;
        this.FR = list;
        this.Fr = aVar;
        this.Fz = dVar;
        this.FN = bVar2;
        this.FO = lineCapType;
        this.FP = lineJoinType;
        this.FQ = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a jO() {
        return this.Fr;
    }

    public com.airbnb.lottie.model.a.d ji() {
        return this.Fz;
    }

    public com.airbnb.lottie.model.a.b jt() {
        return this.FN;
    }

    public List<com.airbnb.lottie.model.a.b> jw() {
        return this.FR;
    }

    public com.airbnb.lottie.model.a.b jx() {
        return this.Ge;
    }

    public LineCapType ju() {
        return this.FO;
    }

    public LineJoinType jv() {
        return this.FP;
    }

    public float jy() {
        return this.FQ;
    }
}
