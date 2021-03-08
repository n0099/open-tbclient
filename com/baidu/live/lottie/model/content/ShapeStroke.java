package com.baidu.live.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.a.q;
import java.util.List;
/* loaded from: classes9.dex */
public class ShapeStroke implements b {
    private final float Hn;
    private final List<com.baidu.live.lottie.model.a.b> Ho;
    private final com.baidu.live.lottie.model.a.a buS;
    private final com.baidu.live.lottie.model.a.d bva;
    private final com.baidu.live.lottie.model.a.b bvk;
    private final LineCapType bvl;
    private final LineJoinType bvm;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bvy;
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
        this.bvy = bVar;
        this.Ho = list;
        this.buS = aVar;
        this.bva = dVar;
        this.bvk = bVar2;
        this.bvl = lineCapType;
        this.bvm = lineJoinType;
        this.Hn = f;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new q(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.a Ob() {
        return this.buS;
    }

    public com.baidu.live.lottie.model.a.d NB() {
        return this.bva;
    }

    public com.baidu.live.lottie.model.a.b NK() {
        return this.bvk;
    }

    public List<com.baidu.live.lottie.model.a.b> jv() {
        return this.Ho;
    }

    public com.baidu.live.lottie.model.a.b NN() {
        return this.bvy;
    }

    public LineCapType NL() {
        return this.bvl;
    }

    public LineJoinType NM() {
        return this.bvm;
    }

    public float jx() {
        return this.Hn;
    }
}
