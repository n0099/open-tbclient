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
    private final com.airbnb.lottie.f mp;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> nO;
    private final String name;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> oa;
    private final Path nJ = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> nR = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.mp = fVar;
        if (iVar.el() == null || iVar.dE() == null) {
            this.oa = null;
            this.nO = null;
            return;
        }
        this.nJ.setFillType(iVar.getFillType());
        this.oa = iVar.el().dp();
        this.oa.b(this);
        aVar.a(this.oa);
        this.nO = iVar.dE().dp();
        this.nO.b(this);
        aVar.a(this.nO);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        this.mp.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.nR.add((k) bVar);
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
        this.paint.setColor(this.oa.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.nO.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.nJ.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.nR.size()) {
                this.nJ.addPath(this.nR.get(i3).getPath(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.nJ, this.paint);
                com.airbnb.lottie.d.U("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.nJ.reset();
        for (int i = 0; i < this.nR.size(); i++) {
            this.nJ.addPath(this.nR.get(i).getPath(), matrix);
        }
        this.nJ.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
