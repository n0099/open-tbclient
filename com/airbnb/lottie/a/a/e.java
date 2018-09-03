package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jR;
    private final Path lh = new Path();
    @Nullable
    private q lq;
    private final com.airbnb.lottie.a.b.a<?, PointF> lv;
    private final com.airbnb.lottie.a.b.a<?, PointF> lw;
    private final com.airbnb.lottie.model.content.a lx;
    private boolean ly;
    private final String name;

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.jR = fVar;
        this.lv = aVar2.cE().ci();
        this.lw = aVar2.cu().ci();
        this.lx = aVar2;
        aVar.a(this.lv);
        aVar.a(this.lw);
        this.lv.b(this);
        this.lw.b(this);
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

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
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
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.lh.reset();
        if (this.lx.isReversed()) {
            this.lh.moveTo(0.0f, -f2);
            this.lh.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.lh.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.lh.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.lh.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.lh.moveTo(0.0f, -f2);
            this.lh.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.lh.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.lh.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.lh.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.lw.getValue();
        this.lh.offset(value2.x, value2.y);
        this.lh.close();
        com.airbnb.lottie.c.f.a(this.lh, this.lq);
        this.ly = true;
        return this.lh;
    }
}
