package com.baidu.live.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes9.dex */
public class e implements j, l, a.InterfaceC0192a {
    private boolean Fe;
    @Nullable
    private r btU;
    private final com.baidu.live.lottie.a.b.a<?, PointF> btW;
    private final com.baidu.live.lottie.a.b.a<?, PointF> btX;
    private final com.baidu.live.lottie.model.content.a btY;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public e(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.lottieDrawable = hVar;
        this.btW = aVar2.NF().Nv();
        this.btX = aVar2.Ny().Nv();
        this.btY = aVar2;
        aVar.a(this.btW);
        aVar.a(this.btX);
        this.btW.b(this);
        this.btX.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0192a
    public void ir() {
        invalidate();
    }

    private void invalidate() {
        this.Fe = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).Nl() == ShapeTrimPath.Type.Simultaneously) {
                    this.btU = (r) bVar;
                    this.btU.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iu() {
        if (this.Fe) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.btW.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.path.reset();
        if (this.btY.isReversed()) {
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
        PointF value2 = this.btX.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.baidu.live.lottie.d.f.a(this.path, this.btU);
        this.Fe = true;
        return this.path;
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.Eg) {
            this.btW.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Eh) {
            this.btX.a(cVar);
        }
    }
}
