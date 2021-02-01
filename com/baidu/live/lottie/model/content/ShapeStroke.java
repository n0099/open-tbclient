package com.baidu.live.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.a.q;
import java.util.List;
/* loaded from: classes10.dex */
public class ShapeStroke implements b {
    private final float FQ;
    private final List<com.baidu.live.lottie.model.a.b> FR;
    private final com.baidu.live.lottie.model.a.b btJ;
    private final LineCapType btK;
    private final LineJoinType btL;
    @Nullable
    private final com.baidu.live.lottie.model.a.b btX;
    private final com.baidu.live.lottie.model.a.a btr;
    private final com.baidu.live.lottie.model.a.d btz;
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

    public ShapeStroke(String str, @Nullable com.baidu.live.lottie.model.a.b bVar, List<com.baidu.live.lottie.model.a.b> list, com.baidu.live.lottie.model.a.a aVar, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.btX = bVar;
        this.FR = list;
        this.btr = aVar;
        this.btz = dVar;
        this.btJ = bVar2;
        this.btK = lineCapType;
        this.btL = lineJoinType;
        this.FQ = f;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new q(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.a NY() {
        return this.btr;
    }

    public com.baidu.live.lottie.model.a.d Ny() {
        return this.btz;
    }

    public com.baidu.live.lottie.model.a.b NH() {
        return this.btJ;
    }

    public List<com.baidu.live.lottie.model.a.b> jv() {
        return this.FR;
    }

    public com.baidu.live.lottie.model.a.b NK() {
        return this.btX;
    }

    public LineCapType NI() {
        return this.btK;
    }

    public LineJoinType NJ() {
        return this.btL;
    }

    public float jx() {
        return this.FQ;
    }
}
