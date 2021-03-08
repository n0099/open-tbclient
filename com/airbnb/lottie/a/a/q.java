package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes5.dex */
public class q extends a {
    private final com.airbnb.lottie.model.layer.a EO;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> EW;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Ff;
    private final String name;

    public q(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.jt().toPaintCap(), shapeStroke.ju().toPaintJoin(), shapeStroke.jx(), shapeStroke.jh(), shapeStroke.js(), shapeStroke.jv(), shapeStroke.jw());
        this.EO = aVar;
        this.name = shapeStroke.getName();
        this.Ff = shapeStroke.jN().jb();
        this.Ff.b(this);
        aVar.a(this.Ff);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.Ff.getValue().intValue());
        if (this.EW != null) {
            this.paint.setColorFilter(this.EW.getValue());
        }
        super.c(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a(t, cVar);
        if (t == com.airbnb.lottie.j.Eb) {
            this.Ff.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ex) {
            if (cVar == null) {
                this.EW = null;
                return;
            }
            this.EW = new com.airbnb.lottie.a.b.p(cVar);
            this.EW.b(this);
            this.EO.a(this.Ff);
        }
    }
}
