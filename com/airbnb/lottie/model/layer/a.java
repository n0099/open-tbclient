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
/* loaded from: classes4.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0007a, com.airbnb.lottie.model.f {
    final com.airbnb.lottie.f BH;
    final o Ek;
    @Nullable
    private a GA;
    @Nullable
    private a GC;
    private List<a> GD;
    private final String Gw;
    final Layer Gy;
    @Nullable
    private com.airbnb.lottie.a.b.g Gz;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint Go = new Paint(1);
    private final Paint Gp = new Paint(1);
    private final Paint Gq = new Paint(1);
    private final Paint Gr = new Paint(1);
    private final Paint Gs = new Paint();
    private final RectF rect = new RectF();
    private final RectF Gt = new RectF();
    private final RectF Gu = new RectF();
    private final RectF Gv = new RectF();
    final Matrix Gx = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> GF = new ArrayList();
    private boolean visible = true;

    abstract void d(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.d dVar) {
        switch (layer.kb()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, dVar.bd(layer.getRefId()), dVar);
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
        this.BH = fVar;
        this.Gy = layer;
        this.Gw = layer.getName() + "#draw";
        this.Gs.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Gp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Gq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.kc() == Layer.MatteType.Invert) {
            this.Gr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Gr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.Ek = layer.jK().jk();
        this.Ek.a((a.InterfaceC0007a) this);
        if (layer.iL() != null && !layer.iL().isEmpty()) {
            this.Gz = new com.airbnb.lottie.a.b.g(layer.iL());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.Gz.iM()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.Gz.iN()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        jT();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ir() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer jR() {
        return this.Gy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.GA = aVar;
    }

    boolean jS() {
        return this.GA != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.GC = aVar;
    }

    private void jT() {
        if (!this.Gy.jY().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.Gy.jY());
            cVar.iF();
            cVar.b(new a.InterfaceC0007a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
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
        this.BH.invalidateSelf();
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
        this.GF.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void d(RectF rectF, Matrix matrix) {
        this.Gx.set(matrix);
        this.Gx.preConcat(this.Ek.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.beginSection(this.Gw);
        if (!this.visible) {
            com.airbnb.lottie.c.bb(this.Gw);
            return;
        }
        jV();
        com.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.GD.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.GD.get(size).Ek.getMatrix());
        }
        com.airbnb.lottie.c.bb("Layer#parentMatrix");
        int intValue = (int) (((this.Ek.iP().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!jS() && !jU()) {
            this.matrix.preConcat(this.Ek.getMatrix());
            com.airbnb.lottie.c.beginSection("Layer#drawLayer");
            d(canvas, this.matrix, intValue);
            com.airbnb.lottie.c.bb("Layer#drawLayer");
            i(com.airbnb.lottie.c.bb(this.Gw));
            return;
        }
        com.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        d(this.rect, this.matrix);
        f(this.rect, this.matrix);
        this.matrix.preConcat(this.Ek.getMatrix());
        e(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.c.bb("Layer#computeBounds");
        com.airbnb.lottie.c.beginSection("Layer#saveLayer");
        b(canvas, this.rect, this.Go, true);
        com.airbnb.lottie.c.bb("Layer#saveLayer");
        f(canvas);
        com.airbnb.lottie.c.beginSection("Layer#drawLayer");
        d(canvas, this.matrix, intValue);
        com.airbnb.lottie.c.bb("Layer#drawLayer");
        if (jU()) {
            b(canvas, this.matrix);
        }
        if (jS()) {
            com.airbnb.lottie.c.beginSection("Layer#drawMatte");
            com.airbnb.lottie.c.beginSection("Layer#saveLayer");
            b(canvas, this.rect, this.Gr, false);
            com.airbnb.lottie.c.bb("Layer#saveLayer");
            f(canvas);
            this.GA.c(canvas, matrix, intValue);
            com.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c.bb("Layer#restoreLayer");
            com.airbnb.lottie.c.bb("Layer#drawMatte");
        }
        com.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.bb("Layer#restoreLayer");
        i(com.airbnb.lottie.c.bb(this.Gw));
    }

    private void i(float f) {
        this.BH.getComposition().getPerformanceTracker().c(this.Gy.getName(), f);
    }

    private void f(Canvas canvas) {
        com.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Gs);
        com.airbnb.lottie.c.bb("Layer#clearLayer");
    }

    private void e(RectF rectF, Matrix matrix) {
        this.Gt.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (jU()) {
            int size = this.Gz.iL().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.Gz.iM().get(i).getValue());
                this.path.transform(matrix);
                switch (this.Gz.iL().get(i).jy()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.Gv, false);
                        if (i == 0) {
                            this.Gt.set(this.Gv);
                        } else {
                            this.Gt.set(Math.min(this.Gt.left, this.Gv.left), Math.min(this.Gt.top, this.Gv.top), Math.max(this.Gt.right, this.Gv.right), Math.max(this.Gt.bottom, this.Gv.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Gt.left), Math.max(rectF.top, this.Gt.top), Math.min(rectF.right, this.Gt.right), Math.min(rectF.bottom, this.Gt.bottom));
        }
    }

    private void f(RectF rectF, Matrix matrix) {
        if (jS() && this.Gy.kc() != Layer.MatteType.Invert) {
            this.GA.d(this.Gu, matrix);
            rectF.set(Math.max(rectF.left, this.Gu.left), Math.max(rectF.top, this.Gu.top), Math.min(rectF.right, this.Gu.right), Math.min(rectF.bottom, this.Gu.bottom));
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
                paint = this.Gq;
                break;
            default:
                paint = this.Gp;
                break;
        }
        int size = this.Gz.iL().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.Gz.iL().get(i).jy() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.airbnb.lottie.c.beginSection("Layer#drawMask");
            com.airbnb.lottie.c.beginSection("Layer#saveLayer");
            b(canvas, this.rect, paint, false);
            com.airbnb.lottie.c.bb("Layer#saveLayer");
            f(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.Gz.iL().get(i2).jy() == maskMode) {
                    this.path.set(this.Gz.iM().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Go.getAlpha();
                    this.Go.setAlpha((int) (this.Gz.iN().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.Go);
                    this.Go.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c.bb("Layer#restoreLayer");
            com.airbnb.lottie.c.bb("Layer#drawMask");
        }
    }

    boolean jU() {
        return (this.Gz == null || this.Gz.iM().isEmpty()) ? false : true;
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
        this.Ek.setProgress(f);
        if (this.Gz != null) {
            for (int i = 0; i < this.Gz.iM().size(); i++) {
                this.Gz.iM().get(i).setProgress(f);
            }
        }
        if (this.Gy.jW() != 0.0f) {
            f /= this.Gy.jW();
        }
        if (this.GA != null) {
            this.GA.setProgress(this.GA.Gy.jW() * f);
        }
        for (int i2 = 0; i2 < this.GF.size(); i2++) {
            this.GF.get(i2).setProgress(f);
        }
    }

    private void jV() {
        if (this.GD == null) {
            if (this.GC == null) {
                this.GD = Collections.emptyList();
                return;
            }
            this.GD = new ArrayList();
            for (a aVar = this.GC; aVar != null; aVar = aVar.GC) {
                this.GD.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.Gy.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.bk(getName());
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
        this.Ek.b(t, cVar);
    }
}
