package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class m implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f kB;
    private final com.airbnb.lottie.a.b.a<?, Float> mI;
    @Nullable
    private q ma;
    private final com.airbnb.lottie.a.b.a<?, PointF> mf;
    private final com.airbnb.lottie.a.b.a<?, PointF> mg;
    private boolean mi;
    private final String name;
    private final Path lR = new Path();
    private final RectF rect = new RectF();

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.kB = fVar;
        this.mg = fVar2.cR().cF();
        this.mf = fVar2.db().cF();
        this.mI = fVar2.dw().cF();
        aVar.a(this.mg);
        aVar.a(this.mf);
        aVar.a(this.mI);
        this.mg.b(this);
        this.mf.b(this);
        this.mI.b(this);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ca() {
        invalidate();
    }

    private void invalidate() {
        this.mi = false;
        this.kB.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).ck() == ShapeTrimPath.Type.Simultaneously) {
                    this.ma = (q) bVar;
                    this.ma.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path cd() {
        if (this.mi) {
            return this.lR;
        }
        this.lR.reset();
        PointF value = this.mf.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.mI == null ? 0.0f : this.mI.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.mg.getValue();
        this.lR.moveTo(value2.x + f, (value2.y - f2) + min);
        this.lR.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.lR.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.lR.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.lR.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.lR.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.lR.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.lR.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.lR.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.lR.close();
        com.airbnb.lottie.c.f.a(this.lR, this.ma);
        this.mi = true;
        return this.lR;
    }
}
