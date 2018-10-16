package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0009a {
    private final String name;
    private final com.airbnb.lottie.f nh;
    @Nullable
    private q oH;
    private final com.airbnb.lottie.a.b.a<?, PointF> oL;
    private final com.airbnb.lottie.a.b.a<?, PointF> oM;
    private final com.airbnb.lottie.model.content.a oN;
    private boolean oO;
    private final Path oy = new Path();

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.nh = fVar;
        this.oL = aVar2.ed().dH();
        this.oM = aVar2.dT().dH();
        this.oN = aVar2;
        aVar.a(this.oL);
        aVar.a(this.oM);
        this.oL.b(this);
        this.oM.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void de() {
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
                if ((bVar instanceof q) && ((q) bVar).dn() == ShapeTrimPath.Type.Simultaneously) {
                    this.oH = (q) bVar;
                    this.oH.a(this);
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
        if (this.oO) {
            return this.oy;
        }
        this.oy.reset();
        PointF value = this.oL.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.oy.reset();
        if (this.oN.isReversed()) {
            this.oy.moveTo(0.0f, -f2);
            this.oy.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.oy.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.oy.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.oy.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.oy.moveTo(0.0f, -f2);
            this.oy.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.oy.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.oy.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.oy.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.oM.getValue();
        this.oy.offset(value2.x, value2.y);
        this.oy.close();
        com.airbnb.lottie.c.f.a(this.oy, this.oH);
        this.oO = true;
        return this.oy;
    }
}
