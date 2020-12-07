package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes7.dex */
public class q extends a {
    private final com.airbnb.lottie.model.layer.a DH;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> DQ;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> DZ;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.jV().toPaintCap(), shapeStroke.jW().toPaintJoin(), shapeStroke.jZ(), shapeStroke.jJ(), shapeStroke.jU(), shapeStroke.jX(), shapeStroke.jY());
        this.DH = aVar;
        this.name = shapeStroke.getName();
        this.DZ = shapeStroke.kp().jD();
        this.DZ.b(this);
        aVar.a(this.DZ);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.DZ.getValue().intValue());
        if (this.DQ != null) {
            this.paint.setColorFilter(this.DQ.getValue());
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
        if (t == com.airbnb.lottie.k.CO) {
            this.DZ.a(cVar);
        } else if (t == com.airbnb.lottie.k.Do) {
            if (cVar == null) {
                this.DQ = null;
                return;
            }
            this.DQ = new com.airbnb.lottie.a.b.p(cVar);
            this.DQ.b(this);
            this.DH.a(this.DZ);
        }
    }
}
