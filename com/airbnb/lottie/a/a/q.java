package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes4.dex */
public class q extends a {
    private final com.airbnb.lottie.a.b.a<Integer, Integer> DK;
    private final com.airbnb.lottie.model.layer.a Ds;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Dz;
    private final String name;

    public q(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.jt().toPaintCap(), shapeStroke.ju().toPaintJoin(), shapeStroke.jx(), shapeStroke.jh(), shapeStroke.js(), shapeStroke.jv(), shapeStroke.jw());
        this.Ds = aVar;
        this.name = shapeStroke.getName();
        this.DK = shapeStroke.jN().jb();
        this.DK.b(this);
        aVar.a(this.DK);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.DK.getValue().intValue());
        if (this.Dz != null) {
            this.paint.setColorFilter(this.Dz.getValue());
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
        if (t == com.airbnb.lottie.j.Cz) {
            this.DK.a(cVar);
        } else if (t == com.airbnb.lottie.j.Db) {
            if (cVar == null) {
                this.Dz = null;
                return;
            }
            this.Dz = new com.airbnb.lottie.a.b.p(cVar);
            this.Dz.b(this);
            this.Ds.a(this.DK);
        }
    }
}
