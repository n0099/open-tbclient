package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f mp;
    private final Path nJ = new Path();
    @Nullable
    private q nS;
    private final com.airbnb.lottie.a.b.a<?, PointF> nW;
    private final com.airbnb.lottie.a.b.a<?, PointF> nX;
    private final com.airbnb.lottie.model.content.a nY;
    private boolean nZ;
    private final String name;

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.mp = fVar;
        this.nW = aVar2.dL().dp();
        this.nX = aVar2.dB().dp();
        this.nY = aVar2;
        aVar.a(this.nW);
        aVar.a(this.nX);
        this.nW.b(this);
        this.nX.b(this);
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

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
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
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.nJ.reset();
        if (this.nY.isReversed()) {
            this.nJ.moveTo(0.0f, -f2);
            this.nJ.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.nJ.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.nJ.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.nJ.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.nJ.moveTo(0.0f, -f2);
            this.nJ.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.nJ.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.nJ.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.nJ.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.nX.getValue();
        this.nJ.offset(value2.x, value2.y);
        this.nJ.close();
        com.airbnb.lottie.c.f.a(this.nJ, this.nS);
        this.nZ = true;
        return this.nJ;
    }
}
