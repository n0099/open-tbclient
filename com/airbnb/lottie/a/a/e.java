package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jQ;
    private final Path lg = new Path();
    @Nullable
    private q lp;
    private final com.airbnb.lottie.a.b.a<?, PointF> lu;
    private final com.airbnb.lottie.a.b.a<?, PointF> lv;
    private final com.airbnb.lottie.model.content.a lw;
    private boolean lx;
    private final String name;

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.jQ = fVar;
        this.lu = aVar2.cE().ci();
        this.lv = aVar2.cu().ci();
        this.lw = aVar2;
        aVar.a(this.lu);
        aVar.a(this.lv);
        this.lu.b(this);
        this.lv.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        invalidate();
    }

    private void invalidate() {
        this.lx = false;
        this.jQ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bO() == ShapeTrimPath.Type.Simultaneously) {
                    this.lp = (q) bVar;
                    this.lp.a(this);
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
        if (this.lx) {
            return this.lg;
        }
        this.lg.reset();
        PointF value = this.lu.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.lg.reset();
        if (this.lw.isReversed()) {
            this.lg.moveTo(0.0f, -f2);
            this.lg.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.lg.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.lg.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.lg.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.lg.moveTo(0.0f, -f2);
            this.lg.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.lg.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.lg.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.lg.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.lv.getValue();
        this.lg.offset(value2.x, value2.y);
        this.lg.close();
        com.airbnb.lottie.c.f.a(this.lg, this.lp);
        this.lx = true;
        return this.lg;
    }
}
