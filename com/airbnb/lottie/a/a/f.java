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
/* loaded from: classes3.dex */
public class f implements d, j, a.InterfaceC0007a {
    private final com.airbnb.lottie.f BJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> DC;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> DN;
    private final com.airbnb.lottie.model.layer.a Du;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Dy;
    private final String name;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> DD = new ArrayList();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.Du = aVar;
        this.name = iVar.getName();
        this.BJ = fVar;
        if (iVar.jO() == null || iVar.ji() == null) {
            this.DN = null;
            this.Dy = null;
            return;
        }
        this.path.setFillType(iVar.jp());
        this.DN = iVar.jO().jc();
        this.DN.b(this);
        aVar.a(this.DN);
        this.Dy = iVar.ji().jc();
        this.Dy.b(this);
        aVar.a(this.Dy);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        this.BJ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.DD.add((l) bVar);
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
        this.paint.setColor(this.DN.getValue().intValue());
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Dy.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.DC != null) {
            this.paint.setColorFilter(this.DC.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.DD.size(); i2++) {
            this.path.addPath(this.DD.get(i2).iv(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.c.bb("FillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.DD.size(); i++) {
            this.path.addPath(this.DD.get(i).iv(), matrix);
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
        if (t == com.airbnb.lottie.j.CB) {
            this.DN.a(cVar);
        } else if (t == com.airbnb.lottie.j.CE) {
            this.Dy.a(cVar);
        } else if (t == com.airbnb.lottie.j.Dd) {
            if (cVar == null) {
                this.DC = null;
                return;
            }
            this.DC = new com.airbnb.lottie.a.b.p(cVar);
            this.DC.b(this);
            this.Du.a(this.DC);
        }
    }
}
