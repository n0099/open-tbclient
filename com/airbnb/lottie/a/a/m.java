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
    private q lC;
    private final com.airbnb.lottie.a.b.a<?, PointF> lG;
    private final com.airbnb.lottie.a.b.a<?, PointF> lH;
    private boolean lJ;
    private final Path lp = new Path();
    private final RectF lr = new RectF();
    private final com.airbnb.lottie.a.b.a<?, Float> mg;
    private final String name;

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.jY = fVar;
        this.lH = fVar2.cw().ck();
        this.lG = fVar2.cG().ck();
        this.mg = fVar2.da().ck();
        aVar.a(this.lH);
        aVar.a(this.lG);
        aVar.a(this.mg);
        this.lH.b(this);
        this.lG.b(this);
        this.mg.b(this);
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
        this.lJ = false;
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
                    this.lC = (q) bVar;
                    this.lC.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.lJ) {
            return this.lp;
        }
        this.lp.reset();
        PointF value = this.lG.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.mg == null ? 0.0f : this.mg.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.lH.getValue();
        this.lp.moveTo(value2.x + f, (value2.y - f2) + min);
        this.lp.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.lr.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.lp.arcTo(this.lr, 0.0f, 90.0f, false);
        }
        this.lp.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.lr.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.lp.arcTo(this.lr, 90.0f, 90.0f, false);
        }
        this.lp.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.lr.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.lp.arcTo(this.lr, 180.0f, 90.0f, false);
        }
        this.lp.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.lr.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.lp.arcTo(this.lr, 270.0f, 90.0f, false);
        }
        this.lp.close();
        com.airbnb.lottie.c.f.a(this.lp, this.lC);
        this.lJ = true;
        return this.lp;
    }
}
