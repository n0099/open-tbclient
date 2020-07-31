package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes20.dex */
public class q extends a {
    private final com.airbnb.lottie.model.layer.a BO;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> BV;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Ce;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.iu().toPaintCap(), shapeStroke.iv().toPaintJoin(), shapeStroke.iy(), shapeStroke.ih(), shapeStroke.it(), shapeStroke.iw(), shapeStroke.ix());
        this.BO = aVar;
        this.name = shapeStroke.getName();
        this.Ce = shapeStroke.iO().ia();
        this.Ce.b(this);
        aVar.a(this.Ce);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.Ce.getValue().intValue());
        if (this.BV != null) {
            this.paint.setColorFilter(this.BV.getValue());
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
        if (t == com.airbnb.lottie.k.Bb) {
            this.Ce.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bx) {
            if (cVar == null) {
                this.BV = null;
                return;
            }
            this.BV = new com.airbnb.lottie.a.b.p(cVar);
            this.BV.b(this);
            this.BO.a(this.Ce);
        }
    }
}
