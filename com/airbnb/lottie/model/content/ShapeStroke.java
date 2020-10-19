package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes10.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.a EP;
    private final com.airbnb.lottie.model.a.d EY;
    @Nullable
    private final com.airbnb.lottie.model.a.b FB;
    private final com.airbnb.lottie.model.a.b Fl;
    private final LineCapType Fm;
    private final LineJoinType Fn;
    private final float Fo;
    private final List<com.airbnb.lottie.model.a.b> Fp;
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

    public ShapeStroke(String str, @Nullable com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.a aVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.FB = bVar;
        this.Fp = list;
        this.EP = aVar;
        this.EY = dVar;
        this.Fl = bVar2;
        this.Fm = lineCapType;
        this.Fn = lineJoinType;
        this.Fo = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a kp() {
        return this.EP;
    }

    public com.airbnb.lottie.model.a.d jJ() {
        return this.EY;
    }

    public com.airbnb.lottie.model.a.b jU() {
        return this.Fl;
    }

    public List<com.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    public com.airbnb.lottie.model.a.b jY() {
        return this.FB;
    }

    public LineCapType jV() {
        return this.Fm;
    }

    public LineJoinType jW() {
        return this.Fn;
    }

    public float jZ() {
        return this.Fo;
    }
}
