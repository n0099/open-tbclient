package com.baidu.live.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes10.dex */
public class e implements j, l, a.InterfaceC0194a {
    private boolean DM;
    @Nullable
    private r btF;
    private final com.baidu.live.lottie.a.b.a<?, PointF> btH;
    private final com.baidu.live.lottie.a.b.a<?, PointF> btI;
    private final com.baidu.live.lottie.model.content.a btJ;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public e(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.lottieDrawable = hVar;
        this.btH = aVar2.PZ().PP();
        this.btI = aVar2.PS().PP();
        this.btJ = aVar2;
        aVar.a(this.btH);
        aVar.a(this.btI);
        this.btH.b(this);
        this.btI.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
    public void is() {
        invalidate();
    }

    private void invalidate() {
        this.DM = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).PF() == ShapeTrimPath.Type.Simultaneously) {
                    this.btF = (r) bVar;
                    this.btF.a(this);
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
    public Path iv() {
        if (this.DM) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.btH.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.path.reset();
        if (this.btJ.isReversed()) {
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
        PointF value2 = this.btI.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.baidu.live.lottie.d.f.a(this.path, this.btF);
        this.DM = true;
        return this.path;
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.CH) {
            this.btH.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CI) {
            this.btI.a(cVar);
        }
    }
}
