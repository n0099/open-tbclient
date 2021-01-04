package com.baidu.live.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
/* loaded from: classes10.dex */
public class o {
    private final a<PointF, PointF> buo;
    private final a<?, PointF> bup;
    private final a<com.baidu.live.lottie.e.d, com.baidu.live.lottie.e.d> buq;
    private final a<Float, Float> bur;
    private final a<Integer, Integer> bus;
    @Nullable
    private final a<?, Float> but;
    @Nullable
    private final a<?, Float> buu;
    private final Matrix matrix = new Matrix();

    public o(com.baidu.live.lottie.model.a.l lVar) {
        this.buo = lVar.PR().PP();
        this.bup = lVar.PS().PP();
        this.buq = lVar.PT().PP();
        this.bur = lVar.PU().PP();
        this.bus = lVar.PV().PP();
        if (lVar.PW() != null) {
            this.but = lVar.PW().PP();
        } else {
            this.but = null;
        }
        if (lVar.PX() != null) {
            this.buu = lVar.PX().PP();
        } else {
            this.buu = null;
        }
    }

    public void a(com.baidu.live.lottie.model.layer.a aVar) {
        aVar.a(this.buo);
        aVar.a(this.bup);
        aVar.a(this.buq);
        aVar.a(this.bur);
        aVar.a(this.bus);
        if (this.but != null) {
            aVar.a(this.but);
        }
        if (this.buu != null) {
            aVar.a(this.buu);
        }
    }

    public void a(a.InterfaceC0194a interfaceC0194a) {
        this.buo.b(interfaceC0194a);
        this.bup.b(interfaceC0194a);
        this.buq.b(interfaceC0194a);
        this.bur.b(interfaceC0194a);
        this.bus.b(interfaceC0194a);
        if (this.but != null) {
            this.but.b(interfaceC0194a);
        }
        if (this.buu != null) {
            this.buu.b(interfaceC0194a);
        }
    }

    public void setProgress(float f) {
        this.buo.setProgress(f);
        this.bup.setProgress(f);
        this.buq.setProgress(f);
        this.bur.setProgress(f);
        this.bus.setProgress(f);
        if (this.but != null) {
            this.but.setProgress(f);
        }
        if (this.buu != null) {
            this.buu.setProgress(f);
        }
    }

    public a<?, Integer> PK() {
        return this.bus;
    }

    @Nullable
    public a<?, Float> PL() {
        return this.but;
    }

    @Nullable
    public a<?, Float> PM() {
        return this.buu;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.bup.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.bur.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.baidu.live.lottie.e.d value2 = this.buq.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.buo.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.bup.getValue();
        PointF value2 = this.buo.getValue();
        com.baidu.live.lottie.e.d value3 = this.buq.getValue();
        float floatValue = this.bur.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.CF) {
            this.buo.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CG) {
            this.bup.a(cVar);
        } else if (t == com.baidu.live.lottie.l.btw) {
            this.buq.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CK) {
            this.bur.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CD) {
            this.bus.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Da && this.but != null) {
            this.but.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Db && this.buu != null) {
            this.buu.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
