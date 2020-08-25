package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes18.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.d EG;
    private final com.airbnb.lottie.model.a.b EU;
    private final LineCapType EV;
    private final LineJoinType EW;
    private final float EX;
    private final List<com.airbnb.lottie.model.a.b> EY;
    private final com.airbnb.lottie.model.a.a Ex;
    @Nullable
    private final com.airbnb.lottie.model.a.b Fk;
    private final String name;

    /* loaded from: classes18.dex */
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

    /* loaded from: classes18.dex */
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
        this.Fk = bVar;
        this.EY = list;
        this.Ex = aVar;
        this.EG = dVar;
        this.EU = bVar2;
        this.EV = lineCapType;
        this.EW = lineJoinType;
        this.EX = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a kn() {
        return this.Ex;
    }

    public com.airbnb.lottie.model.a.d jH() {
        return this.EG;
    }

    public com.airbnb.lottie.model.a.b jS() {
        return this.EU;
    }

    public List<com.airbnb.lottie.model.a.b> jV() {
        return this.EY;
    }

    public com.airbnb.lottie.model.a.b jW() {
        return this.Fk;
    }

    public LineCapType jT() {
        return this.EV;
    }

    public LineJoinType jU() {
        return this.EW;
    }

    public float jX() {
        return this.EX;
    }
}
