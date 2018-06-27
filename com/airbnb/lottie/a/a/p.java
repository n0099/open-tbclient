package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes2.dex */
public class p extends a {
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lI;
    private final String name;

    public p(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.cN().toPaintCap(), shapeStroke.cO().toPaintJoin(), shapeStroke.cz(), shapeStroke.cM(), shapeStroke.cP(), shapeStroke.cQ());
        this.name = shapeStroke.getName();
        this.lI = shapeStroke.dg().ck();
        this.lI.b(this);
        aVar.a(this.lI);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.lI.getValue().intValue());
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
