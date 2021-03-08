package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes5.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.a GM;
    private final com.airbnb.lottie.model.a.d GW;
    @Nullable
    private final com.airbnb.lottie.model.a.b HA;
    private final com.airbnb.lottie.model.a.b Hk;
    private final LineCapType Hl;
    private final LineJoinType Hm;
    private final float Hn;
    private final List<com.airbnb.lottie.model.a.b> Ho;
    private final String name;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        this.HA = bVar;
        this.Ho = list;
        this.GM = aVar;
        this.GW = dVar;
        this.Hk = bVar2;
        this.Hl = lineCapType;
        this.Hm = lineJoinType;
        this.Hn = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a jN() {
        return this.GM;
    }

    public com.airbnb.lottie.model.a.d jh() {
        return this.GW;
    }

    public com.airbnb.lottie.model.a.b js() {
        return this.Hk;
    }

    public List<com.airbnb.lottie.model.a.b> jv() {
        return this.Ho;
    }

    public com.airbnb.lottie.model.a.b jw() {
        return this.HA;
    }

    public LineCapType jt() {
        return this.Hl;
    }

    public LineJoinType ju() {
        return this.Hm;
    }

    public float jx() {
        return this.Hn;
    }
}
