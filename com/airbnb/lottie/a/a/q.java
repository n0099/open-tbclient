package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final com.airbnb.lottie.a.b.a<Integer, Integer> BC;
    private final com.airbnb.lottie.model.layer.a Bm;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Bt;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.ic().toPaintCap(), shapeStroke.ie().toPaintJoin(), shapeStroke.ih(), shapeStroke.hQ(), shapeStroke.ib(), shapeStroke.m7if(), shapeStroke.ig());
        this.Bm = aVar;
        this.name = shapeStroke.getName();
        this.BC = shapeStroke.iy().hK();
        this.BC.b(this);
        aVar.a(this.BC);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.BC.getValue().intValue());
        if (this.Bt != null) {
            this.paint.setColorFilter(this.Bt.getValue());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((q) t, (com.airbnb.lottie.e.c<q>) cVar);
        if (t == com.airbnb.lottie.k.Aw) {
            this.BC.a(cVar);
        } else if (t == com.airbnb.lottie.k.AV) {
            if (cVar == null) {
                this.Bt = null;
                return;
            }
            this.Bt = new com.airbnb.lottie.a.b.p(cVar);
            this.Bt.b(this);
            this.Bm.a(this.BC);
        }
    }
}
