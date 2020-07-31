package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes20.dex */
public class n implements j, l, a.InterfaceC0010a {
    @Nullable
    private r BX;
    private final com.airbnb.lottie.a.b.a<?, PointF> Ca;
    private final com.airbnb.lottie.a.b.a<?, PointF> Cb;
    private boolean Cd;
    private final com.airbnb.lottie.a.b.a<?, Float> Cz;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final RectF rect = new RectF();

    public n(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar) {
        this.name = fVar.getName();
        this.lottieDrawable = gVar;
        this.Cb = fVar.ie().ia();
        this.Ca = fVar.il().ia();
        this.Cz = fVar.iI().ia();
        aVar.a(this.Cb);
        aVar.a(this.Ca);
        aVar.a(this.Cz);
        this.Cb.b(this);
        this.Ca.b(this);
        this.Cz.b(this);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void hq() {
        invalidate();
    }

    private void invalidate() {
        this.Cd = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).hA() == ShapeTrimPath.Type.Simultaneously) {
                    this.BX = (r) bVar;
                    this.BX.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path ht() {
        if (this.Cd) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.Ca.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.Cz == null ? 0.0f : this.Cz.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.Cb.getValue();
        this.path.moveTo(value2.x + f, (value2.y - f2) + min);
        this.path.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.path.close();
        com.airbnb.lottie.d.f.a(this.path, this.BX);
        this.Cd = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
    }
}
