package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes10.dex */
public class q extends a {
    private final com.airbnb.lottie.model.layer.a CK;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> CW;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Df;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.jV().toPaintCap(), shapeStroke.jW().toPaintJoin(), shapeStroke.jZ(), shapeStroke.jJ(), shapeStroke.jU(), shapeStroke.jX(), shapeStroke.jY());
        this.CK = aVar;
        this.name = shapeStroke.getName();
        this.Df = shapeStroke.kp().jD();
        this.Df.b(this);
        aVar.a(this.Df);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.Df.getValue().intValue());
        if (this.CW != null) {
            this.paint.setColorFilter(this.CW.getValue());
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
        if (t == com.airbnb.lottie.k.BW) {
            this.Df.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cs) {
            if (cVar == null) {
                this.CW = null;
                return;
            }
            this.CW = new com.airbnb.lottie.a.b.p(cVar);
            this.CW.b(this);
            this.CK.a(this.Df);
        }
    }
}
