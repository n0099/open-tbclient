package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.content.ShapeStroke;
/* loaded from: classes10.dex */
public class q extends a {
    private final com.baidu.live.lottie.model.layer.a btA;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> btE;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> btK;
    private final String name;

    public q(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(hVar, aVar, shapeStroke.Qf().toPaintCap(), shapeStroke.Qg().toPaintJoin(), shapeStroke.jy(), shapeStroke.PV(), shapeStroke.Qe(), shapeStroke.jw(), shapeStroke.Qh());
        this.btA = aVar;
        this.name = shapeStroke.getName();
        this.btK = shapeStroke.Qv().PP();
        this.btK.b(this);
        aVar.a(this.btK);
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.btK.getValue().intValue());
        if (this.btE != null) {
            this.paint.setColorFilter(this.btE.getValue());
        }
        super.c(canvas, matrix, i);
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        super.a(t, cVar);
        if (t == com.baidu.live.lottie.l.CC) {
            this.btK.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Dd) {
            if (cVar == null) {
                this.btE = null;
                return;
            }
            this.btE = new com.baidu.live.lottie.a.b.p(cVar);
            this.btE.b(this);
            this.btA.a(this.btK);
        }
    }
}
