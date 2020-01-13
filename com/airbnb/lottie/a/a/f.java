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
/* loaded from: classes5.dex */
public class f implements d, j, a.InterfaceC0010a {
    private final com.airbnb.lottie.model.layer.a fG;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> fK;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> fN;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> fW;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> fO = new ArrayList();

    public f(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.fG = aVar;
        this.name = iVar.getName();
        this.lottieDrawable = gVar;
        if (iVar.cY() == null || iVar.cs() == null) {
            this.fW = null;
            this.fK = null;
            return;
        }
        this.path.setFillType(iVar.cz());
        this.fW = iVar.cY().cm();
        this.fW.b(this);
        aVar.a(this.fW);
        this.fK = iVar.cs().cm();
        this.fK.b(this);
        aVar.a(this.fK);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bC() {
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
                    this.fO.add((l) bVar);
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
        this.paint.setColor(this.fW.getValue().intValue());
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.fK.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.fN != null) {
            this.paint.setColorFilter(this.fN.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.fO.size(); i2++) {
            this.path.addPath(this.fO.get(i2).bF(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.F("FillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.fO.size(); i++) {
            this.path.addPath(this.fO.get(i).bF(), matrix);
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
        if (t == com.airbnb.lottie.k.eK) {
            this.fW.a(cVar);
        } else if (t == com.airbnb.lottie.k.eN) {
            this.fK.a(cVar);
        } else if (t == com.airbnb.lottie.k.fj) {
            if (cVar == null) {
                this.fN = null;
                return;
            }
            this.fN = new com.airbnb.lottie.a.b.p(cVar);
            this.fN.b(this);
            this.fG.a(this.fN);
        }
    }
}
