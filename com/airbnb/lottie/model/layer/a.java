package com.airbnb.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0013a, com.airbnb.lottie.model.f {
    final com.airbnb.lottie.f Df;
    final o FD;
    private final String HS;
    final Layer HV;
    @Nullable
    private com.airbnb.lottie.a.b.g HW;
    @Nullable
    private a HX;
    @Nullable
    private a HY;
    private List<a> Ia;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint HK = new Paint(1);
    private final Paint HL = new Paint(1);
    private final Paint HM = new Paint(1);
    private final Paint HN = new Paint(1);
    private final Paint HO = new Paint();
    private final RectF rect = new RectF();
    private final RectF HP = new RectF();
    private final RectF HQ = new RectF();
    private final RectF HR = new RectF();
    final Matrix HU = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> Ib = new ArrayList();
    private boolean visible = true;

    abstract void d(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.d dVar) {
        switch (layer.kb()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, dVar.bh(layer.getRefId()), dVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer);
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                com.airbnb.lottie.c.warn("Unknown layer type " + layer.kb());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.Df = fVar;
        this.HV = layer;
        this.HS = layer.getName() + "#draw";
        this.HO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.HL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.HM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.kc() == Layer.MatteType.Invert) {
            this.HN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.HN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.FD = layer.jK().jk();
        this.FD.a((a.InterfaceC0013a) this);
        if (layer.iL() != null && !layer.iL().isEmpty()) {
            this.HW = new com.airbnb.lottie.a.b.g(layer.iL());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.HW.iM()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.HW.iN()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        jT();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
    public void ir() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer jR() {
        return this.HV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.HX = aVar;
    }

    boolean jS() {
        return this.HX != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.HY = aVar;
    }

    private void jT() {
        if (!this.HV.jY().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.HV.jY());
            cVar.iF();
            cVar.b(new a.InterfaceC0013a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
                public void ir() {
                    a.this.setVisible(cVar.getValue().floatValue() == 1.0f);
                }
            });
            setVisible(cVar.getValue().floatValue() == 1.0f);
            a(cVar);
            return;
        }
        setVisible(true);
    }

    private void invalidateSelf() {
        this.Df.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    private void b(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.Ib.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void d(RectF rectF, Matrix matrix) {
        this.HU.set(matrix);
        this.HU.preConcat(this.FD.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.beginSection(this.HS);
        if (!this.visible) {
            com.airbnb.lottie.c.bf(this.HS);
            return;
        }
        jV();
        com.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.Ia.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.Ia.get(size).FD.getMatrix());
        }
        com.airbnb.lottie.c.bf("Layer#parentMatrix");
        int intValue = (int) (((this.FD.iP().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!jS() && !jU()) {
            this.matrix.preConcat(this.FD.getMatrix());
            com.airbnb.lottie.c.beginSection("Layer#drawLayer");
            d(canvas, this.matrix, intValue);
            com.airbnb.lottie.c.bf("Layer#drawLayer");
            m(com.airbnb.lottie.c.bf(this.HS));
            return;
        }
        com.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        d(this.rect, this.matrix);
        f(this.rect, this.matrix);
        this.matrix.preConcat(this.FD.getMatrix());
        e(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.c.bf("Layer#computeBounds");
        com.airbnb.lottie.c.beginSection("Layer#saveLayer");
        b(canvas, this.rect, this.HK, true);
        com.airbnb.lottie.c.bf("Layer#saveLayer");
        f(canvas);
        com.airbnb.lottie.c.beginSection("Layer#drawLayer");
        d(canvas, this.matrix, intValue);
        com.airbnb.lottie.c.bf("Layer#drawLayer");
        if (jU()) {
            b(canvas, this.matrix);
        }
        if (jS()) {
            com.airbnb.lottie.c.beginSection("Layer#drawMatte");
            com.airbnb.lottie.c.beginSection("Layer#saveLayer");
            b(canvas, this.rect, this.HN, false);
            com.airbnb.lottie.c.bf("Layer#saveLayer");
            f(canvas);
            this.HX.c(canvas, matrix, intValue);
            com.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c.bf("Layer#restoreLayer");
            com.airbnb.lottie.c.bf("Layer#drawMatte");
        }
        com.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.bf("Layer#restoreLayer");
        m(com.airbnb.lottie.c.bf(this.HS));
    }

    private void m(float f) {
        this.Df.getComposition().getPerformanceTracker().c(this.HV.getName(), f);
    }

    private void f(Canvas canvas) {
        com.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.HO);
        com.airbnb.lottie.c.bf("Layer#clearLayer");
    }

    private void e(RectF rectF, Matrix matrix) {
        this.HP.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (jU()) {
            int size = this.HW.iL().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.HW.iM().get(i).getValue());
                this.path.transform(matrix);
                switch (this.HW.iL().get(i).jy()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.HR, false);
                        if (i == 0) {
                            this.HP.set(this.HR);
                        } else {
                            this.HP.set(Math.min(this.HP.left, this.HR.left), Math.min(this.HP.top, this.HR.top), Math.max(this.HP.right, this.HR.right), Math.max(this.HP.bottom, this.HR.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.HP.left), Math.max(rectF.top, this.HP.top), Math.min(rectF.right, this.HP.right), Math.min(rectF.bottom, this.HP.bottom));
        }
    }

    private void f(RectF rectF, Matrix matrix) {
        if (jS() && this.HV.kc() != Layer.MatteType.Invert) {
            this.HX.d(this.HQ, matrix);
            rectF.set(Math.max(rectF.left, this.HQ.left), Math.max(rectF.top, this.HQ.top), Math.min(rectF.right, this.HQ.right), Math.min(rectF.bottom, this.HQ.bottom));
        }
    }

    private void b(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z;
        switch (maskMode) {
            case MaskModeSubtract:
                paint = this.HM;
                break;
            default:
                paint = this.HL;
                break;
        }
        int size = this.HW.iL().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.HW.iL().get(i).jy() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.airbnb.lottie.c.beginSection("Layer#drawMask");
            com.airbnb.lottie.c.beginSection("Layer#saveLayer");
            b(canvas, this.rect, paint, false);
            com.airbnb.lottie.c.bf("Layer#saveLayer");
            f(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.HW.iL().get(i2).jy() == maskMode) {
                    this.path.set(this.HW.iM().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.HK.getAlpha();
                    this.HK.setAlpha((int) (this.HW.iN().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.HK);
                    this.HK.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c.bf("Layer#restoreLayer");
            com.airbnb.lottie.c.bf("Layer#drawMask");
        }
    }

    boolean jU() {
        return (this.HW == null || this.HW.iM().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(boolean z) {
        if (z != this.visible) {
            this.visible = z;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.FD.setProgress(f);
        if (this.HW != null) {
            for (int i = 0; i < this.HW.iM().size(); i++) {
                this.HW.iM().get(i).setProgress(f);
            }
        }
        if (this.HV.jW() != 0.0f) {
            f /= this.HV.jW();
        }
        if (this.HX != null) {
            this.HX.setProgress(this.HX.HV.jW() * f);
        }
        for (int i2 = 0; i2 < this.Ib.size(); i2++) {
            this.Ib.get(i2).setProgress(f);
        }
    }

    private void jV() {
        if (this.Ia == null) {
            if (this.HY == null) {
                this.Ia = Collections.emptyList();
                return;
            }
            this.Ia = new ArrayList();
            for (a aVar = this.HY; aVar != null; aVar = aVar.HY) {
                this.Ia.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.HV.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.bo(getName());
                if (eVar.j(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.k(getName(), i)) {
                b(eVar, eVar.i(getName(), i) + i, list, eVar2);
            }
        }
    }

    void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        this.FD.b(t, cVar);
    }
}
