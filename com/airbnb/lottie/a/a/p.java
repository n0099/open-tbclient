package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes2.dex */
public class p extends a {
    private final String name;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> oK;

    public p(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.ei().toPaintCap(), shapeStroke.ej().toPaintJoin(), shapeStroke.dU(), shapeStroke.eh(), shapeStroke.ek(), shapeStroke.el());
        this.name = shapeStroke.getName();
        this.oK = shapeStroke.eB().dF();
        this.oK.b(this);
        aVar.a(this.oK);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.oK.getValue().intValue());
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
