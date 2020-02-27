package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final com.airbnb.lottie.model.layer.a fK;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> fR;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> gb;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.cF().toPaintCap(), shapeStroke.cG().toPaintJoin(), shapeStroke.cJ(), shapeStroke.ct(), shapeStroke.cE(), shapeStroke.cH(), shapeStroke.cI());
        this.fK = aVar;
        this.name = shapeStroke.getName();
        this.gb = shapeStroke.cZ().cn();
        this.gb.b(this);
        aVar.a(this.gb);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.gb.getValue().intValue());
        if (this.fR != null) {
            this.paint.setColorFilter(this.fR.getValue());
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
        if (t == com.airbnb.lottie.k.eO) {
            this.gb.a(cVar);
        } else if (t == com.airbnb.lottie.k.fq) {
            if (cVar == null) {
                this.fR = null;
                return;
            }
            this.fR = new com.airbnb.lottie.a.b.p(cVar);
            this.fR.b(this);
            this.fK.a(this.gb);
        }
    }
}
