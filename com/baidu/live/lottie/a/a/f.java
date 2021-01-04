package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class f implements d, j, a.InterfaceC0194a {
    private final com.baidu.live.lottie.model.layer.a btA;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> btC;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> btE;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> btK;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> DD = new ArrayList();

    public f(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.i iVar) {
        this.btA = aVar;
        this.name = iVar.getName();
        this.lottieDrawable = hVar;
        if (iVar.Qv() == null || iVar.PV() == null) {
            this.btK = null;
            this.btC = null;
            return;
        }
        this.path.setFillType(iVar.jp());
        this.btK = iVar.Qv().PP();
        this.btK.b(this);
        aVar.a(this.btK);
        this.btC = iVar.PV().PP();
        this.btC.b(this);
        aVar.a(this.btC);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
    public void is() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
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

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection("FillContent#draw");
        this.paint.setColor(this.btK.getValue().intValue());
        this.paint.setAlpha(com.baidu.live.lottie.d.e.clamp((int) (((this.btC.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.btE != null) {
            this.paint.setColorFilter(this.btE.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.DD.size(); i2++) {
            this.path.addPath(this.DD.get(i2).iv(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.baidu.live.lottie.d.bb("FillContent#draw");
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.DD.size(); i++) {
            this.path.addPath(this.DD.get(i).iv(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.CB) {
            this.btK.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CE) {
            this.btC.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Dd) {
            if (cVar == null) {
                this.btE = null;
                return;
            }
            this.btE = new com.baidu.live.lottie.a.b.p(cVar);
            this.btE.b(this);
            this.btA.a(this.btE);
        }
    }
}
