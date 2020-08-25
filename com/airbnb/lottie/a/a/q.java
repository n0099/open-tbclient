package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes18.dex */
public class q extends a {
    private final com.airbnb.lottie.a.b.a<Integer, Integer> CJ;
    private final com.airbnb.lottie.model.layer.a Cs;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Cz;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.jT().toPaintCap(), shapeStroke.jU().toPaintJoin(), shapeStroke.jX(), shapeStroke.jH(), shapeStroke.jS(), shapeStroke.jV(), shapeStroke.jW());
        this.Cs = aVar;
        this.name = shapeStroke.getName();
        this.CJ = shapeStroke.kn().jB();
        this.CJ.b(this);
        aVar.a(this.CJ);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.CJ.getValue().intValue());
        if (this.Cz != null) {
            this.paint.setColorFilter(this.Cz.getValue());
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
        if (t == com.airbnb.lottie.k.BF) {
            this.CJ.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cb) {
            if (cVar == null) {
                this.Cz = null;
                return;
            }
            this.Cz = new com.airbnb.lottie.a.b.p(cVar);
            this.Cz.b(this);
            this.Cs.a(this.CJ);
        }
    }
}
