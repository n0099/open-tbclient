package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class m implements k, a.InterfaceC0009a {
    private final String name;
    private final com.airbnb.lottie.f nh;
    @Nullable
    private q oH;
    private final com.airbnb.lottie.a.b.a<?, PointF> oL;
    private final com.airbnb.lottie.a.b.a<?, PointF> oM;
    private boolean oO;
    private final com.airbnb.lottie.a.b.a<?, Float> pp;
    private final Path oy = new Path();
    private final RectF rect = new RectF();

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.nh = fVar;
        this.oM = fVar2.dS().dG();
        this.oL = fVar2.ec().dG();
        this.pp = fVar2.ew().dG();
        aVar.a(this.oM);
        aVar.a(this.oL);
        aVar.a(this.pp);
        this.oM.b(this);
        this.oL.b(this);
        this.pp.b(this);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void dd() {
        invalidate();
    }

    private void invalidate() {
        this.oO = false;
        this.nh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).dm() == ShapeTrimPath.Type.Simultaneously) {
                    this.oH = (q) bVar;
                    this.oH.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.oO) {
            return this.oy;
        }
        this.oy.reset();
        PointF value = this.oL.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.pp == null ? 0.0f : this.pp.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.oM.getValue();
        this.oy.moveTo(value2.x + f, (value2.y - f2) + min);
        this.oy.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.oy.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.oy.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.oy.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.oy.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.oy.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.oy.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.oy.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.oy.close();
        com.airbnb.lottie.c.f.a(this.oy, this.oH);
        this.oO = true;
        return this.oy;
    }
}
