package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.content.ShapeStroke;
/* loaded from: classes10.dex */
public class q extends a {
    private final com.baidu.live.lottie.model.layer.a bso;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> bss;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> bsy;
    private final String name;

    public q(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(hVar, aVar, shapeStroke.NI().toPaintCap(), shapeStroke.NJ().toPaintJoin(), shapeStroke.jx(), shapeStroke.Ny(), shapeStroke.NH(), shapeStroke.jv(), shapeStroke.NK());
        this.bso = aVar;
        this.name = shapeStroke.getName();
        this.bsy = shapeStroke.NY().Ns();
        this.bsy.b(this);
        aVar.a(this.bsy);
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.bsy.getValue().intValue());
        if (this.bss != null) {
            this.paint.setColorFilter(this.bss.getValue());
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
            this.bsy.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Db) {
            if (cVar == null) {
                this.bss = null;
                return;
            }
            this.bss = new com.baidu.live.lottie.a.b.p(cVar);
            this.bss.b(this);
            this.bso.a(this.bsy);
        }
    }
}
