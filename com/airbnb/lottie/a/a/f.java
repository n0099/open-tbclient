package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d, a.InterfaceC0007a {
    private final com.airbnb.lottie.f cG;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> dX;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> ej;
    private final String name;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> ea = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.cG = fVar;
        if (iVar.cV() == null || iVar.cn() == null) {
            this.ej = null;
            this.dX = null;
            return;
        }
        this.path.setFillType(iVar.cx());
        this.ej = iVar.cV().bY();
        this.ej.b(this);
        aVar.a(this.ej);
        this.dX = iVar.cn().bY();
        this.dX.b(this);
        aVar.a(this.dX);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        this.cG.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.ea.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("FillContent#draw");
        this.paint.setColor(this.ej.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.dX.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.path.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.ea.size()) {
                this.path.addPath(this.ea.get(i3).bw(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.d.D("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.ea.size(); i++) {
            this.path.addPath(this.ea.get(i).bw(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
