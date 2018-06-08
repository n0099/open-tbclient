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
    private q lC;
    private final com.airbnb.lottie.a.b.a<?, PointF> lG;
    private final com.airbnb.lottie.a.b.a<?, PointF> lH;
    private final com.airbnb.lottie.model.content.a lI;
    private boolean lJ;
    private final Path lp = new Path();
    private final String name;

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.jY = fVar;
        this.lG = aVar2.cG().ck();
        this.lH = aVar2.cw().ck();
        this.lI = aVar2;
        aVar.a(this.lG);
        aVar.a(this.lH);
        this.lG.b(this);
        this.lH.b(this);
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

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
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
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.lp.reset();
        if (this.lI.isReversed()) {
            this.lp.moveTo(0.0f, -f2);
            this.lp.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.lp.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.lp.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.lp.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.lp.moveTo(0.0f, -f2);
            this.lp.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.lp.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.lp.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.lp.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.lH.getValue();
        this.lp.offset(value2.x, value2.y);
        this.lp.close();
        com.airbnb.lottie.c.f.a(this.lp, this.lC);
        this.lJ = true;
        return this.lp;
    }
}
