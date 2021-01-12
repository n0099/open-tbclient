package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.content.ShapeStroke;
/* loaded from: classes9.dex */
public class q extends a {
    private final com.baidu.live.lottie.model.layer.a boN;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> boR;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> boX;
    private final String name;

    public q(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(hVar, aVar, shapeStroke.Mk().toPaintCap(), shapeStroke.Ml().toPaintJoin(), shapeStroke.jy(), shapeStroke.Ma(), shapeStroke.Mj(), shapeStroke.jw(), shapeStroke.Mm());
        this.boN = aVar;
        this.name = shapeStroke.getName();
        this.boX = shapeStroke.MA().LU();
        this.boX.b(this);
        aVar.a(this.boX);
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.boX.getValue().intValue());
        if (this.boR != null) {
            this.paint.setColorFilter(this.boR.getValue());
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
        if (t == com.baidu.live.lottie.l.Cz) {
            this.boX.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Db) {
            if (cVar == null) {
                this.boR = null;
                return;
            }
            this.boR = new com.baidu.live.lottie.a.b.p(cVar);
            this.boR.b(this);
            this.boN.a(this.boX);
        }
    }
}
