package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0007a {
    private final String name;
    private final com.airbnb.lottie.f nc;
    @Nullable
    private q oC;
    private final com.airbnb.lottie.a.b.a<?, PointF> oG;
    private final com.airbnb.lottie.a.b.a<?, PointF> oH;
    private final com.airbnb.lottie.model.content.a oI;
    private boolean oJ;
    private final Path ot = new Path();

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.nc = fVar;
        this.oG = aVar2.eb().dF();
        this.oH = aVar2.dR().dF();
        this.oI = aVar2;
        aVar.a(this.oG);
        aVar.a(this.oH);
        this.oG.b(this);
        this.oH.b(this);
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

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
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
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.ot.reset();
        if (this.oI.isReversed()) {
            this.ot.moveTo(0.0f, -f2);
            this.ot.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.ot.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.ot.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.ot.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.ot.moveTo(0.0f, -f2);
            this.ot.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.ot.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.ot.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.ot.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.oH.getValue();
        this.ot.offset(value2.x, value2.y);
        this.ot.close();
        com.airbnb.lottie.c.f.a(this.ot, this.oC);
        this.oJ = true;
        return this.ot;
    }
}
