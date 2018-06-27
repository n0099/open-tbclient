package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class m implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jY;
    @Nullable
    private q lA;
    private final com.airbnb.lottie.a.b.a<?, PointF> lE;
    private final com.airbnb.lottie.a.b.a<?, PointF> lF;
    private boolean lH;
    private final com.airbnb.lottie.a.b.a<?, Float> md;
    private final String name;
    private final Path lo = new Path();
    private final RectF rect = new RectF();

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.jY = fVar;
        this.lF = fVar2.cw().ck();
        this.lE = fVar2.cG().ck();
        this.md = fVar2.da().ck();
        aVar.a(this.lF);
        aVar.a(this.lE);
        aVar.a(this.md);
        this.lF.b(this);
        this.lE.b(this);
        this.md.b(this);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        invalidate();
    }

    private void invalidate() {
        this.lH = false;
        this.jY.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bQ() == ShapeTrimPath.Type.Simultaneously) {
                    this.lA = (q) bVar;
                    this.lA.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.lH) {
            return this.lo;
        }
        this.lo.reset();
        PointF value = this.lE.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.md == null ? 0.0f : this.md.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.lF.getValue();
        this.lo.moveTo(value2.x + f, (value2.y - f2) + min);
        this.lo.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.lo.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.lo.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.lo.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.lo.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.lo.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.lo.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.lo.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.lo.close();
        com.airbnb.lottie.c.f.a(this.lo, this.lA);
        this.lH = true;
        return this.lo;
    }
}
