package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes4.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.a hG;
    private final com.airbnb.lottie.model.a.d hO;
    @Nullable
    private final com.airbnb.lottie.model.a.b iD;
    private final com.airbnb.lottie.model.a.b ie;

    /* renamed from: if  reason: not valid java name */
    private final LineCapType f1if;
    private final LineJoinType ig;
    private final float ii;
    private final List<com.airbnb.lottie.model.a.b> ij;
    private final String name;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
        this.iD = bVar;
        this.ij = list;
        this.hG = aVar;
        this.hO = dVar;
        this.ie = bVar2;
        this.f1if = lineCapType;
        this.ig = lineJoinType;
        this.ii = f;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a cY() {
        return this.hG;
    }

    public com.airbnb.lottie.model.a.d cs() {
        return this.hO;
    }

    public com.airbnb.lottie.model.a.b cD() {
        return this.ie;
    }

    public List<com.airbnb.lottie.model.a.b> cG() {
        return this.ij;
    }

    public com.airbnb.lottie.model.a.b cH() {
        return this.iD;
    }

    public LineCapType cE() {
        return this.f1if;
    }

    public LineJoinType cF() {
        return this.ig;
    }

    public float cI() {
        return this.ii;
    }
}
