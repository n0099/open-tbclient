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
public class f implements d, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jQ;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> ll;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> ly;
    private final String name;
    private final Path lg = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> lo = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.jQ = fVar;
        if (iVar.de() == null || iVar.cx() == null) {
            this.ly = null;
            this.ll = null;
            return;
        }
        this.lg.setFillType(iVar.getFillType());
        this.ly = iVar.de().ci();
        this.ly.b(this);
        aVar.a(this.ly);
        this.ll = iVar.cx().ci();
        this.ll.b(this);
        aVar.a(this.ll);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        this.jQ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.lo.add((k) bVar);
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
        this.paint.setColor(this.ly.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.ll.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.lg.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.lo.size()) {
                this.lg.addPath(this.lo.get(i3).getPath(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.lg, this.paint);
                com.airbnb.lottie.d.D("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lg.reset();
        for (int i = 0; i < this.lo.size(); i++) {
            this.lg.addPath(this.lo.get(i).getPath(), matrix);
        }
        this.lg.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
