package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.content.ShapeStroke;
/* loaded from: classes9.dex */
public class q extends a {
    private final com.baidu.live.lottie.model.layer.a btP;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> btT;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> btZ;
    private final String name;

    public q(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(hVar, aVar, shapeStroke.NL().toPaintCap(), shapeStroke.NM().toPaintJoin(), shapeStroke.jx(), shapeStroke.NB(), shapeStroke.NK(), shapeStroke.jv(), shapeStroke.NN());
        this.btP = aVar;
        this.name = shapeStroke.getName();
        this.btZ = shapeStroke.Ob().Nv();
        this.btZ.b(this);
        aVar.a(this.btZ);
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.btZ.getValue().intValue());
        if (this.btT != null) {
            this.paint.setColorFilter(this.btT.getValue());
        }
        super.c(canvas, matrix, i);
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        super.a(t, cVar);
        if (t == com.baidu.live.lottie.l.Eb) {
            this.btZ.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Ex) {
            if (cVar == null) {
                this.btT = null;
                return;
            }
            this.btT = new com.baidu.live.lottie.a.b.p(cVar);
            this.btT.b(this);
            this.btP.a(this.btZ);
        }
    }
}
