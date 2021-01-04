package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes3.dex */
public class q extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> DC;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> DN;
    private final com.airbnb.lottie.model.layer.a Du;
    private final String name;

    public q(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.ju().toPaintCap(), shapeStroke.jv().toPaintJoin(), shapeStroke.jy(), shapeStroke.ji(), shapeStroke.jt(), shapeStroke.jw(), shapeStroke.jx());
        this.Du = aVar;
        this.name = shapeStroke.getName();
        this.DN = shapeStroke.jO().jc();
        this.DN.b(this);
        aVar.a(this.DN);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.DN.getValue().intValue());
        if (this.DC != null) {
            this.paint.setColorFilter(this.DC.getValue());
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
        if (t == com.airbnb.lottie.j.CC) {
            this.DN.a(cVar);
        } else if (t == com.airbnb.lottie.j.Dd) {
            if (cVar == null) {
                this.DC = null;
                return;
            }
            this.DC = new com.airbnb.lottie.a.b.p(cVar);
            this.DC.b(this);
            this.Du.a(this.DN);
        }
    }
}
