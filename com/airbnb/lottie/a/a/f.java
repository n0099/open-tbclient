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
public class f implements d, a.InterfaceC0009a {
    private final String name;
    private final com.airbnb.lottie.f nh;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> oD;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> oP;
    private final Path oy = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> oG = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.nh = fVar;
        if (iVar.eD() == null || iVar.dW() == null) {
            this.oP = null;
            this.oD = null;
            return;
        }
        this.oy.setFillType(iVar.getFillType());
        this.oP = iVar.eD().dH();
        this.oP.b(this);
        aVar.a(this.oP);
        this.oD = iVar.dW().dH();
        this.oD.b(this);
        aVar.a(this.oD);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void de() {
        this.nh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.oG.add((k) bVar);
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
        this.paint.setColor(this.oP.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.oD.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.oy.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.oG.size()) {
                this.oy.addPath(this.oG.get(i3).getPath(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.oy, this.paint);
                com.airbnb.lottie.d.U("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.oy.reset();
        for (int i = 0; i < this.oG.size(); i++) {
            this.oy.addPath(this.oG.get(i).getPath(), matrix);
        }
        this.oy.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
