package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f dh;
    @Nullable
    private q eB;
    private final com.airbnb.lottie.a.b.a<?, PointF> eF;
    private final com.airbnb.lottie.a.b.a<?, PointF> eG;
    private final com.airbnb.lottie.model.content.a eH;
    private boolean eI;
    private final String name;
    private final Path path = new Path();

    public e(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.dh = fVar;
        this.eF = aVar2.cu().bY();
        this.eG = aVar2.ck().bY();
        this.eH = aVar2;
        aVar.a(this.eF);
        aVar.a(this.eG);
        this.eF.b(this);
        this.eG.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        invalidate();
    }

    private void invalidate() {
        this.eI = false;
        this.dh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bD() == ShapeTrimPath.Type.Simultaneously) {
                    this.eB = (q) bVar;
                    this.eB.a(this);
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
    public Path bw() {
        if (this.eI) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.eF.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.path.reset();
        if (this.eH.isReversed()) {
            this.path.moveTo(0.0f, -f2);
            this.path.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.path.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.path.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.path.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.path.moveTo(0.0f, -f2);
            this.path.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.path.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.path.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.path.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.eG.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.airbnb.lottie.c.f.a(this.path, this.eB);
        this.eI = true;
        return this.path;
    }
}
