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
    private final com.airbnb.lottie.f jY;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lI;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lu;
    private final String name;
    private final Path lo = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> ly = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.jY = fVar;
        if (iVar.dg() == null || iVar.cz() == null) {
            this.lI = null;
            this.lu = null;
            return;
        }
        this.lo.setFillType(iVar.getFillType());
        this.lI = iVar.dg().ck();
        this.lI.b(this);
        aVar.a(this.lI);
        this.lu = iVar.cz().ck();
        this.lu.b(this);
        aVar.a(this.lu);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        this.jY.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.ly.add((k) bVar);
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
        this.paint.setColor(this.lI.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.lu.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.lo.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.ly.size()) {
                this.lo.addPath(this.ly.get(i3).getPath(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.lo, this.paint);
                com.airbnb.lottie.d.D("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lo.reset();
        for (int i = 0; i < this.ly.size(); i++) {
            this.lo.addPath(this.ly.get(i).getPath(), matrix);
        }
        this.lo.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
