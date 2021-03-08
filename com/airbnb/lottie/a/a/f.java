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
/* loaded from: classes5.dex */
public class f implements d, j, a.InterfaceC0013a {
    private final com.airbnb.lottie.f Df;
    private final com.airbnb.lottie.model.layer.a EO;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> ET;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> EW;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Ff;
    private final String name;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> EX = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.EO = aVar;
        this.name = iVar.getName();
        this.Df = fVar;
        if (iVar.jN() == null || iVar.jh() == null) {
            this.Ff = null;
            this.ET = null;
            return;
        }
        this.path.setFillType(iVar.jo());
        this.Ff = iVar.jN().jb();
        this.Ff.b(this);
        aVar.a(this.Ff);
        this.ET = iVar.jh().jb();
        this.ET.b(this);
        aVar.a(this.ET);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
    public void ir() {
        this.Df.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.EX.add((l) bVar);
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
        this.paint.setColor(this.Ff.getValue().intValue());
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.ET.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.EW != null) {
            this.paint.setColorFilter(this.EW.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.EX.size(); i2++) {
            this.path.addPath(this.EX.get(i2).iu(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.c.bf("FillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.EX.size(); i++) {
            this.path.addPath(this.EX.get(i).iu(), matrix);
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
        if (t == com.airbnb.lottie.j.Ea) {
            this.Ff.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ed) {
            this.ET.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ex) {
            if (cVar == null) {
                this.EW = null;
                return;
            }
            this.EW = new com.airbnb.lottie.a.b.p(cVar);
            this.EW.b(this);
            this.EO.a(this.EW);
        }
    }
}
