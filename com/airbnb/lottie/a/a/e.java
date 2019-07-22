package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f kB;
    private final Path lR = new Path();
    @Nullable
    private q ma;
    private final com.airbnb.lottie.a.b.a<?, PointF> mf;
    private final com.airbnb.lottie.a.b.a<?, PointF> mg;
    private final com.airbnb.lottie.model.content.a mh;
    private boolean mi;
    private final String name;

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.kB = fVar;
        this.mf = aVar2.db().cF();
        this.mg = aVar2.cR().cF();
        this.mh = aVar2;
        aVar.a(this.mf);
        aVar.a(this.mg);
        this.mf.b(this);
        this.mg.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ca() {
        invalidate();
    }

    private void invalidate() {
        this.mi = false;
        this.kB.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).ck() == ShapeTrimPath.Type.Simultaneously) {
                    this.ma = (q) bVar;
                    this.ma.a(this);
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
    public Path cd() {
        if (this.mi) {
            return this.lR;
        }
        this.lR.reset();
        PointF value = this.mf.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.lR.reset();
        if (this.mh.isReversed()) {
            this.lR.moveTo(0.0f, -f2);
            this.lR.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.lR.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.lR.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.lR.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.lR.moveTo(0.0f, -f2);
            this.lR.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.lR.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.lR.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.lR.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.mg.getValue();
        this.lR.offset(value2.x, value2.y);
        this.lR.close();
        com.airbnb.lottie.c.f.a(this.lR, this.ma);
        this.mi = true;
        return this.lR;
    }
}
