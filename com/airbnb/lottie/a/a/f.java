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
/* loaded from: classes10.dex */
public class f implements d, j, a.InterfaceC0011a {
    private final com.airbnb.lottie.model.layer.a CK;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> CP;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> CW;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Df;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> CX = new ArrayList();

    public f(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.CK = aVar;
        this.name = iVar.getName();
        this.lottieDrawable = gVar;
        if (iVar.kp() == null || iVar.jJ() == null) {
            this.Df = null;
            this.CP = null;
            return;
        }
        this.path.setFillType(iVar.jQ());
        this.Df = iVar.kp().jD();
        this.Df.b(this);
        aVar.a(this.Df);
        this.CP = iVar.jJ().jD();
        this.CP.b(this);
        aVar.a(this.CP);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0011a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.CX.add((l) bVar);
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
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("FillContent#draw");
        this.paint.setColor(this.Df.getValue().intValue());
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.CP.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.CW != null) {
            this.paint.setColorFilter(this.CW.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.CX.size(); i2++) {
            this.path.addPath(this.CX.get(i2).iW(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.bb("FillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.CX.size(); i++) {
            this.path.addPath(this.CX.get(i).iW(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.BV) {
            this.Df.a(cVar);
        } else if (t == com.airbnb.lottie.k.BY) {
            this.CP.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cs) {
            if (cVar == null) {
                this.CW = null;
                return;
            }
            this.CW = new com.airbnb.lottie.a.b.p(cVar);
            this.CW.b(this);
            this.CK.a(this.CW);
        }
    }
}
