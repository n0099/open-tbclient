package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f kC;
    private final Path lS = new Path();
    @Nullable
    private q mb;
    private final com.airbnb.lottie.a.b.a<?, PointF> mg;
    private final com.airbnb.lottie.a.b.a<?, PointF> mh;
    private final com.airbnb.lottie.model.content.a mi;
    private boolean mj;
    private final String name;

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.kC = fVar;
        this.mg = aVar2.cV().cz();
        this.mh = aVar2.cL().cz();
        this.mi = aVar2;
        aVar.a(this.mg);
        aVar.a(this.mh);
        this.mg.b(this);
        this.mh.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bW() {
        invalidate();
    }

    private void invalidate() {
        this.mj = false;
        this.kC.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cf() == ShapeTrimPath.Type.Simultaneously) {
                    this.mb = (q) bVar;
                    this.mb.a(this);
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
        if (this.mj) {
            return this.lS;
        }
        this.lS.reset();
        PointF value = this.mg.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.lS.reset();
        if (this.mi.isReversed()) {
            this.lS.moveTo(0.0f, -f2);
            this.lS.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.lS.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.lS.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.lS.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.lS.moveTo(0.0f, -f2);
            this.lS.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.lS.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.lS.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.lS.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.mh.getValue();
        this.lS.offset(value2.x, value2.y);
        this.lS.close();
        com.airbnb.lottie.c.f.a(this.lS, this.mb);
        this.mj = true;
        return this.lS;
    }
}
