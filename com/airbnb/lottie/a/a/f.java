package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d, j, a.InterfaceC0007a {
    private final com.airbnb.lottie.f BH;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> DK;
    private final com.airbnb.lottie.model.layer.a Ds;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Dw;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Dz;
    private final String name;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> DA = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.Ds = aVar;
        this.name = iVar.getName();
        this.BH = fVar;
        if (iVar.jN() == null || iVar.jh() == null) {
            this.DK = null;
            this.Dw = null;
            return;
        }
        this.path.setFillType(iVar.jo());
        this.DK = iVar.jN().jb();
        this.DK.b(this);
        aVar.a(this.DK);
        this.Dw = iVar.jh().jb();
        this.Dw.b(this);
        aVar.a(this.Dw);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ir() {
        this.BH.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.DA.add((l) bVar);
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
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.beginSection("FillContent#draw");
        this.paint.setColor(this.DK.getValue().intValue());
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Dw.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.Dz != null) {
            this.paint.setColorFilter(this.Dz.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.DA.size(); i2++) {
            this.path.addPath(this.DA.get(i2).iu(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.c.bb("FillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.DA.size(); i++) {
            this.path.addPath(this.DA.get(i).iu(), matrix);
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
        if (t == com.airbnb.lottie.j.Cy) {
            this.DK.a(cVar);
        } else if (t == com.airbnb.lottie.j.CC) {
            this.Dw.a(cVar);
        } else if (t == com.airbnb.lottie.j.Db) {
            if (cVar == null) {
                this.Dz = null;
                return;
            }
            this.Dz = new com.airbnb.lottie.a.b.p(cVar);
            this.Dz.b(this);
            this.Ds.a(this.Dz);
        }
    }
}
