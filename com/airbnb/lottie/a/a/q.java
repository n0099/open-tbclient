package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes4.dex */
public class q extends a {
    private final com.airbnb.lottie.model.layer.a fG;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> fN;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> fW;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.cE().toPaintCap(), shapeStroke.cF().toPaintJoin(), shapeStroke.cI(), shapeStroke.cs(), shapeStroke.cD(), shapeStroke.cG(), shapeStroke.cH());
        this.fG = aVar;
        this.name = shapeStroke.getName();
        this.fW = shapeStroke.cY().cm();
        this.fW.b(this);
        aVar.a(this.fW);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.fW.getValue().intValue());
        if (this.fN != null) {
            this.paint.setColorFilter(this.fN.getValue());
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
        if (t == com.airbnb.lottie.k.eM) {
            this.fW.a(cVar);
        } else if (t == com.airbnb.lottie.k.fk) {
            if (cVar == null) {
                this.fN = null;
                return;
            }
            this.fN = new com.airbnb.lottie.a.b.p(cVar);
            this.fN.b(this);
            this.fG.a(this.fW);
        }
    }
}
