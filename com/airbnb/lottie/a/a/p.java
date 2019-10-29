package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes2.dex */
public class p extends a {
    private final com.airbnb.lottie.a.b.a<Integer, Integer> eJ;
    private final String name;

    public p(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.cC().toPaintCap(), shapeStroke.cD().toPaintJoin(), shapeStroke.cn(), shapeStroke.cB(), shapeStroke.cE(), shapeStroke.cF());
        this.name = shapeStroke.getName();
        this.eJ = shapeStroke.cV().bY();
        this.eJ.b(this);
        aVar.a(this.eJ);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.eJ.getValue().intValue());
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
