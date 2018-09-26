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
    private final com.airbnb.lottie.f mp;
    @Nullable
    private q nS;
    private final com.airbnb.lottie.a.b.a<?, PointF> nW;
    private final com.airbnb.lottie.a.b.a<?, PointF> nX;
    private boolean nZ;
    private final String name;
    private final com.airbnb.lottie.a.b.a<?, Float> oy;
    private final Path nJ = new Path();
    private final RectF rect = new RectF();

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.mp = fVar;
        this.nX = fVar2.dB().dp();
        this.nW = fVar2.dL().dp();
        this.oy = fVar2.ef().dp();
        aVar.a(this.nX);
        aVar.a(this.nW);
        aVar.a(this.oy);
        this.nX.b(this);
        this.nW.b(this);
        this.oy.b(this);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        invalidate();
    }

    private void invalidate() {
        this.nZ = false;
        this.mp.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cV() == ShapeTrimPath.Type.Simultaneously) {
                    this.nS = (q) bVar;
                    this.nS.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.nZ) {
            return this.nJ;
        }
        this.nJ.reset();
        PointF value = this.nW.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.oy == null ? 0.0f : this.oy.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.nX.getValue();
        this.nJ.moveTo(value2.x + f, (value2.y - f2) + min);
        this.nJ.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.nJ.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.nJ.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.nJ.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.nJ.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.nJ.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.nJ.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.nJ.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.nJ.close();
        com.airbnb.lottie.c.f.a(this.nJ, this.nS);
        this.nZ = true;
        return this.nJ;
    }
}
