package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes3.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.d FB;
    private final com.airbnb.lottie.model.a.b FP;
    private final LineCapType FQ;
    private final LineJoinType FR;
    private final float FT;
    private final List<com.airbnb.lottie.model.a.b> FU;
    private final com.airbnb.lottie.model.a.a Ft;
    @Nullable
    private final com.airbnb.lottie.model.a.b Gg;
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
        this.Gg = bVar;
        this.FU = list;
        this.Ft = aVar;
        this.FB = dVar;
        this.FP = bVar2;
        this.FQ = lineCapType;
        this.FR = lineJoinType;
        this.FT = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a jO() {
        return this.Ft;
    }

    public com.airbnb.lottie.model.a.d ji() {
        return this.FB;
    }

    public com.airbnb.lottie.model.a.b jt() {
        return this.FP;
    }

    public List<com.airbnb.lottie.model.a.b> jw() {
        return this.FU;
    }

    public com.airbnb.lottie.model.a.b jx() {
        return this.Gg;
    }

    public LineCapType ju() {
        return this.FQ;
    }

    public LineJoinType jv() {
        return this.FR;
    }

    public float jy() {
        return this.FT;
    }
}
