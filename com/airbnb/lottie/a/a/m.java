package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class m implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f kC;
    private final com.airbnb.lottie.a.b.a<?, Float> mJ;
    @Nullable
    private q mb;
    private final com.airbnb.lottie.a.b.a<?, PointF> mg;
    private final com.airbnb.lottie.a.b.a<?, PointF> mh;
    private boolean mj;
    private final String name;
    private final Path lS = new Path();
    private final RectF rect = new RectF();

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.kC = fVar;
        this.mh = fVar2.cL().cz();
        this.mg = fVar2.cV().cz();
        this.mJ = fVar2.dp().cz();
        aVar.a(this.mh);
        aVar.a(this.mg);
        aVar.a(this.mJ);
        this.mh.b(this);
        this.mg.b(this);
        this.mJ.b(this);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
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

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.mj) {
            return this.lS;
        }
        this.lS.reset();
        PointF value = this.mg.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.mJ == null ? 0.0f : this.mJ.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.mh.getValue();
        this.lS.moveTo(value2.x + f, (value2.y - f2) + min);
        this.lS.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.lS.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.lS.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.lS.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.lS.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.lS.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.lS.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.lS.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.lS.close();
        com.airbnb.lottie.c.f.a(this.lS, this.mb);
        this.mj = true;
        return this.lS;
    }
}
