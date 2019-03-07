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
    private final String name;
    private final com.airbnb.lottie.f nc;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> oK;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> oy;
    private final Path ot = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> oB = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.nc = fVar;
        if (iVar.eB() == null || iVar.dU() == null) {
            this.oK = null;
            this.oy = null;
            return;
        }
        this.ot.setFillType(iVar.getFillType());
        this.oK = iVar.eB().dF();
        this.oK.b(this);
        aVar.a(this.oK);
        this.oy = iVar.dU().dF();
        this.oy.b(this);
        aVar.a(this.oy);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void dc() {
        this.nc.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.oB.add((k) bVar);
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
        this.paint.setColor(this.oK.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.oy.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.ot.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.oB.size()) {
                this.ot.addPath(this.oB.get(i3).getPath(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.ot, this.paint);
                com.airbnb.lottie.d.U("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.ot.reset();
        for (int i = 0; i < this.oB.size(); i++) {
            this.ot.addPath(this.oB.get(i).getPath(), matrix);
        }
        this.ot.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
