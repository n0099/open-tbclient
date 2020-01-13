package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements j, l, a.InterfaceC0010a {
    @Nullable
    private r fP;
    private final com.airbnb.lottie.a.b.a<?, PointF> fS;
    private final com.airbnb.lottie.a.b.a<?, PointF> fT;
    private final com.airbnb.lottie.model.content.a fU;
    private boolean fV;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public e(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.lottieDrawable = gVar;
        this.fS = aVar2.cw().cm();
        this.fT = aVar2.cp().cm();
        this.fU = aVar2;
        aVar.a(this.fS);
        aVar.a(this.fT);
        this.fS.b(this);
        this.fT.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bC() {
        invalidate();
    }

    private void invalidate() {
        this.fV = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).bM() == ShapeTrimPath.Type.Simultaneously) {
                    this.fP = (r) bVar;
                    this.fP.a(this);
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

    @Override // com.airbnb.lottie.a.a.l
    public Path bF() {
        if (this.fV) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.fS.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.path.reset();
        if (this.fU.isReversed()) {
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
        PointF value2 = this.fT.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.airbnb.lottie.d.f.a(this.path, this.fP);
        this.fV = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.eQ) {
            this.fS.a(cVar);
        } else if (t == com.airbnb.lottie.k.eR) {
            this.fT.a(cVar);
        }
    }
}
