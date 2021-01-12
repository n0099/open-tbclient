package com.baidu.live.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.a.q;
import java.util.List;
/* loaded from: classes9.dex */
public class ShapeStroke implements b {
    private final float FQ;
    private final List<com.baidu.live.lottie.model.a.b> FR;
    private final com.baidu.live.lottie.model.a.a bpP;
    private final com.baidu.live.lottie.model.a.d bpX;
    private final com.baidu.live.lottie.model.a.b bqh;
    private final LineCapType bqi;
    private final LineJoinType bqj;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bqv;
    private final String name;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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

    public ShapeStroke(String str, @Nullable com.baidu.live.lottie.model.a.b bVar, List<com.baidu.live.lottie.model.a.b> list, com.baidu.live.lottie.model.a.a aVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.bqv = bVar;
        this.FR = list;
        this.bpP = aVar;
        this.bpX = dVar;
        this.bqh = bVar2;
        this.bqi = lineCapType;
        this.bqj = lineJoinType;
        this.FQ = f;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new q(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.a MA() {
        return this.bpP;
    }

    public com.baidu.live.lottie.model.a.d Ma() {
        return this.bpX;
    }

    public com.baidu.live.lottie.model.a.b Mj() {
        return this.bqh;
    }

    public List<com.baidu.live.lottie.model.a.b> jw() {
        return this.FR;
    }

    public com.baidu.live.lottie.model.a.b Mm() {
        return this.bqv;
    }

    public LineCapType Mk() {
        return this.bqi;
    }

    public LineJoinType Ml() {
        return this.bqj;
    }

    public float jy() {
        return this.FQ;
    }
}
