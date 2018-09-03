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
    private final com.airbnb.lottie.f jR;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lA;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lm;
    private final String name;
    private final Path lh = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> lp = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.jR = fVar;
        if (iVar.de() == null || iVar.cx() == null) {
            this.lA = null;
            this.lm = null;
            return;
        }
        this.lh.setFillType(iVar.getFillType());
        this.lA = iVar.de().ci();
        this.lA.b(this);
        aVar.a(this.lA);
        this.lm = iVar.cx().ci();
        this.lm.b(this);
        aVar.a(this.lm);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        this.jR.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.lp.add((k) bVar);
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
        this.paint.setColor(this.lA.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.lm.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.lh.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.lp.size()) {
                this.lh.addPath(this.lp.get(i3).getPath(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.lh, this.paint);
                com.airbnb.lottie.d.D("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lh.reset();
        for (int i = 0; i < this.lp.size(); i++) {
            this.lh.addPath(this.lp.get(i).getPath(), matrix);
        }
        this.lh.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
