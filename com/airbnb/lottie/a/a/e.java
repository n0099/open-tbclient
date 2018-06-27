package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jY;
    @Nullable
    private q lA;
    private final com.airbnb.lottie.a.b.a<?, PointF> lE;
    private final com.airbnb.lottie.a.b.a<?, PointF> lF;
    private final com.airbnb.lottie.model.content.a lG;
    private boolean lH;
    private final Path lo = new Path();
    private final String name;

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.jY = fVar;
        this.lE = aVar2.cG().ck();
        this.lF = aVar2.cw().ck();
        this.lG = aVar2;
        aVar.a(this.lE);
        aVar.a(this.lF);
        this.lE.b(this);
        this.lF.b(this);
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

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
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
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.lo.reset();
        if (this.lG.isReversed()) {
            this.lo.moveTo(0.0f, -f2);
            this.lo.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.lo.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.lo.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.lo.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.lo.moveTo(0.0f, -f2);
            this.lo.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.lo.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.lo.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.lo.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.lF.getValue();
        this.lo.offset(value2.x, value2.y);
        this.lo.close();
        com.airbnb.lottie.c.f.a(this.lo, this.lA);
        this.lH = true;
        return this.lo;
    }
}
