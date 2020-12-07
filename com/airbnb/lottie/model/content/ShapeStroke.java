package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes7.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.a FG;
    private final com.airbnb.lottie.model.a.d FO;
    private final com.airbnb.lottie.model.a.b Gd;
    private final LineCapType Ge;
    private final LineJoinType Gf;
    private final float Gg;
    private final List<com.airbnb.lottie.model.a.b> Gh;
    @Nullable
    private final com.airbnb.lottie.model.a.b Gt;
    private final String name;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
        this.Gt = bVar;
        this.Gh = list;
        this.FG = aVar;
        this.FO = dVar;
        this.Gd = bVar2;
        this.Ge = lineCapType;
        this.Gf = lineJoinType;
        this.Gg = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a kp() {
        return this.FG;
    }

    public com.airbnb.lottie.model.a.d jJ() {
        return this.FO;
    }

    public com.airbnb.lottie.model.a.b jU() {
        return this.Gd;
    }

    public List<com.airbnb.lottie.model.a.b> jX() {
        return this.Gh;
    }

    public com.airbnb.lottie.model.a.b jY() {
        return this.Gt;
    }

    public LineCapType jV() {
        return this.Ge;
    }

    public LineJoinType jW() {
        return this.Gf;
    }

    public float jZ() {
        return this.Gg;
    }
}
