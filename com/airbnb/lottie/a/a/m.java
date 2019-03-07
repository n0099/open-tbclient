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
    private final String name;
    private final com.airbnb.lottie.f nc;
    @Nullable
    private q oC;
    private final com.airbnb.lottie.a.b.a<?, PointF> oG;
    private final com.airbnb.lottie.a.b.a<?, PointF> oH;
    private boolean oJ;
    private final com.airbnb.lottie.a.b.a<?, Float> ph;
    private final Path ot = new Path();
    private final RectF rect = new RectF();

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.nc = fVar;
        this.oH = fVar2.dR().dF();
        this.oG = fVar2.eb().dF();
        this.ph = fVar2.ev().dF();
        aVar.a(this.oH);
        aVar.a(this.oG);
        aVar.a(this.ph);
        this.oH.b(this);
        this.oG.b(this);
        this.ph.b(this);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void dc() {
        invalidate();
    }

    private void invalidate() {
        this.oJ = false;
        this.nc.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).dl() == ShapeTrimPath.Type.Simultaneously) {
                    this.oC = (q) bVar;
                    this.oC.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.oJ) {
            return this.ot;
        }
        this.ot.reset();
        PointF value = this.oG.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.ph == null ? 0.0f : this.ph.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.oH.getValue();
        this.ot.moveTo(value2.x + f, (value2.y - f2) + min);
        this.ot.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.ot.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.ot.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.ot.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.ot.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.ot.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.ot.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.ot.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.ot.close();
        com.airbnb.lottie.c.f.a(this.ot, this.oC);
        this.oJ = true;
        return this.ot;
    }
}
