package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final com.airbnb.lottie.model.layer.a BM;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> BT;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Cc;
    private final String name;

    public q(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.iu().toPaintCap(), shapeStroke.iv().toPaintJoin(), shapeStroke.iy(), shapeStroke.ih(), shapeStroke.it(), shapeStroke.iw(), shapeStroke.ix());
        this.BM = aVar;
        this.name = shapeStroke.getName();
        this.Cc = shapeStroke.iO().ia();
        this.Cc.b(this);
        aVar.a(this.Cc);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.Cc.getValue().intValue());
        if (this.BT != null) {
            this.paint.setColorFilter(this.BT.getValue());
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
        if (t == com.airbnb.lottie.k.AZ) {
            this.Cc.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bv) {
            if (cVar == null) {
                this.BT = null;
                return;
            }
            this.BT = new com.airbnb.lottie.a.b.p(cVar);
            this.BT.b(this);
            this.BM.a(this.Cc);
        }
    }
}
