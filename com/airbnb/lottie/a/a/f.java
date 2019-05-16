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
    private final com.airbnb.lottie.f kC;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lX;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> mk;
    private final String name;
    private final Path lS = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> ma = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.kC = fVar;
        if (iVar.dv() == null || iVar.cO() == null) {
            this.mk = null;
            this.lX = null;
            return;
        }
        this.lS.setFillType(iVar.getFillType());
        this.mk = iVar.dv().cz();
        this.mk.b(this);
        aVar.a(this.mk);
        this.lX = iVar.cO().cz();
        this.lX.b(this);
        aVar.a(this.lX);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bW() {
        this.kC.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.ma.add((k) bVar);
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
        this.paint.setColor(this.mk.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.lX.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.lS.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.ma.size()) {
                this.lS.addPath(this.ma.get(i3).getPath(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.lS, this.paint);
                com.airbnb.lottie.d.D("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lS.reset();
        for (int i = 0; i < this.ma.size(); i++) {
            this.lS.addPath(this.ma.get(i).getPath(), matrix);
        }
        this.lS.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
