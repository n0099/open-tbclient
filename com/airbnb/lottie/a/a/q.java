package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final com.airbnb.lottie.model.layer.a fJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> fQ;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> fZ;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.cF().toPaintCap(), shapeStroke.cG().toPaintJoin(), shapeStroke.cJ(), shapeStroke.ct(), shapeStroke.cE(), shapeStroke.cH(), shapeStroke.cI());
        this.fJ = aVar;
        this.name = shapeStroke.getName();
        this.fZ = shapeStroke.cZ().cn();
        this.fZ.b(this);
        aVar.a(this.fZ);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.fZ.getValue().intValue());
        if (this.fQ != null) {
            this.paint.setColorFilter(this.fQ.getValue());
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
        if (t == com.airbnb.lottie.k.eN) {
            this.fZ.a(cVar);
        } else if (t == com.airbnb.lottie.k.fo) {
            if (cVar == null) {
                this.fQ = null;
                return;
            }
            this.fQ = new com.airbnb.lottie.a.b.p(cVar);
            this.fQ.b(this);
            this.fJ.a(this.fZ);
        }
    }
}
