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
    private final com.airbnb.lottie.f jR;
    private final com.airbnb.lottie.a.b.a<?, Float> lV;
    @Nullable
    private q lq;
    private final com.airbnb.lottie.a.b.a<?, PointF> lv;
    private final com.airbnb.lottie.a.b.a<?, PointF> lw;
    private boolean ly;
    private final String name;
    private final Path lh = new Path();
    private final RectF rect = new RectF();

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.jR = fVar;
        this.lw = fVar2.cu().ci();
        this.lv = fVar2.cE().ci();
        this.lV = fVar2.cY().ci();
        aVar.a(this.lw);
        aVar.a(this.lv);
        aVar.a(this.lV);
        this.lw.b(this);
        this.lv.b(this);
        this.lV.b(this);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        invalidate();
    }

    private void invalidate() {
        this.ly = false;
        this.jR.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bO() == ShapeTrimPath.Type.Simultaneously) {
                    this.lq = (q) bVar;
                    this.lq.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.ly) {
            return this.lh;
        }
        this.lh.reset();
        PointF value = this.lv.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.lV == null ? 0.0f : this.lV.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.lw.getValue();
        this.lh.moveTo(value2.x + f, (value2.y - f2) + min);
        this.lh.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.lh.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.lh.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.lh.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.lh.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.lh.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.lh.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.lh.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.lh.close();
        com.airbnb.lottie.c.f.a(this.lh, this.lq);
        this.ly = true;
        return this.lh;
    }
}
