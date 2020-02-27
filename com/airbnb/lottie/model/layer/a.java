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
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0010a, com.airbnb.lottie.model.f {
    final o gz;
    private final String iY;
    final Layer jb;
    @Nullable
    private com.airbnb.lottie.a.b.g jc;
    @Nullable
    private a jd;
    @Nullable
    private a je;
    private List<a> jf;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint iQ = new Paint(1);
    private final Paint iR = new Paint(1);
    private final Paint iS = new Paint(1);
    private final Paint iT = new Paint(1);
    private final Paint iU = new Paint();
    private final RectF rect = new RectF();
    private final RectF iV = new RectF();
    private final RectF iW = new RectF();
    private final RectF iX = new RectF();
    final Matrix iZ = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> jg = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.g gVar, com.airbnb.lottie.e eVar) {
        switch (layer.dn()) {
            case Shape:
                return new e(gVar, layer);
            case PreComp:
                return new b(gVar, layer, eVar.H(layer.getRefId()), eVar);
            case Solid:
                return new f(gVar, layer);
            case Image:
                return new c(gVar, layer);
            case Null:
                return new d(gVar, layer);
            case Text:
                return new g(gVar, layer);
            default:
                com.airbnb.lottie.d.warn("Unknown layer type " + layer.dn());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, Layer layer) {
        this.lottieDrawable = gVar;
        this.jb = layer;
        this.iY = layer.getName() + "#draw";
        this.iU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.iS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.m7do() == Layer.MatteType.Invert) {
            this.iT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.iT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.gz = layer.cW().cw();
        this.gz.a((a.InterfaceC0010a) this);
        if (layer.bX() != null && !layer.bX().isEmpty()) {
            this.jc = new com.airbnb.lottie.a.b.g(layer.bX());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.jc.bY()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.jc.bZ()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        df();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bD() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dd() {
        return this.jb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.jd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean de() {
        return this.jd != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.je = aVar;
    }

    private void df() {
        if (!this.jb.dk().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.jb.dk());
            cVar.bR();
            cVar.b(new a.InterfaceC0010a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
                public void bD() {
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
        this.lottieDrawable.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.jg.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.iZ.set(matrix);
        this.iZ.preConcat(this.gz.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.iY);
        if (!this.visible) {
            com.airbnb.lottie.d.F(this.iY);
            return;
        }
        dh();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.jf.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.jf.get(size).gz.getMatrix());
        }
        com.airbnb.lottie.d.F("Layer#parentMatrix");
        int intValue = (int) (((this.gz.cb().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!de() && !dg()) {
            this.matrix.preConcat(this.gz.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.F("Layer#drawLayer");
            k(com.airbnb.lottie.d.F(this.iY));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.gz.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.F("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.iQ, true);
        com.airbnb.lottie.d.F("Layer#saveLayer");
        e(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.F("Layer#drawLayer");
        if (dg()) {
            a(canvas, this.matrix);
        }
        if (de()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.iT, false);
            com.airbnb.lottie.d.F("Layer#saveLayer");
            e(canvas);
            this.jd.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.F("Layer#restoreLayer");
            com.airbnb.lottie.d.F("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.F("Layer#restoreLayer");
        k(com.airbnb.lottie.d.F(this.iY));
    }

    private void k(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.jb.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.iU);
        com.airbnb.lottie.d.F("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.iV.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dg()) {
            int size = this.jc.bX().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.jc.bY().get(i).getValue());
                this.path.transform(matrix);
                switch (this.jc.bX().get(i).cK()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.iX, false);
                        if (i == 0) {
                            this.iV.set(this.iX);
                        } else {
                            this.iV.set(Math.min(this.iV.left, this.iX.left), Math.min(this.iV.top, this.iX.top), Math.max(this.iV.right, this.iX.right), Math.max(this.iV.bottom, this.iX.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.iV.left), Math.max(rectF.top, this.iV.top), Math.min(rectF.right, this.iV.right), Math.min(rectF.bottom, this.iV.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (de() && this.jb.m7do() != Layer.MatteType.Invert) {
            this.jd.a(this.iW, matrix);
            rectF.set(Math.max(rectF.left, this.iW.left), Math.max(rectF.top, this.iW.top), Math.min(rectF.right, this.iW.right), Math.min(rectF.bottom, this.iW.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z;
        switch (maskMode) {
            case MaskModeSubtract:
                paint = this.iS;
                break;
            default:
                paint = this.iR;
                break;
        }
        int size = this.jc.bX().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.jc.bX().get(i).cK() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.airbnb.lottie.d.F("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.jc.bX().get(i2).cK() == maskMode) {
                    this.path.set(this.jc.bY().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.iQ.getAlpha();
                    this.iQ.setAlpha((int) (this.jc.bZ().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.iQ);
                    this.iQ.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.F("Layer#restoreLayer");
            com.airbnb.lottie.d.F("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dg() {
        return (this.jc == null || this.jc.bY().isEmpty()) ? false : true;
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
        this.gz.setProgress(f);
        if (this.jc != null) {
            for (int i = 0; i < this.jc.bY().size(); i++) {
                this.jc.bY().get(i).setProgress(f);
            }
        }
        if (this.jb.di() != 0.0f) {
            f /= this.jb.di();
        }
        if (this.jd != null) {
            this.jd.setProgress(this.jd.jb.di() * f);
        }
        for (int i2 = 0; i2 < this.jg.size(); i2++) {
            this.jg.get(i2).setProgress(f);
        }
    }

    private void dh() {
        if (this.jf == null) {
            if (this.je == null) {
                this.jf = Collections.emptyList();
                return;
            }
            this.jf = new ArrayList();
            for (a aVar = this.je; aVar != null; aVar = aVar.je) {
                this.jf.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.jb.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.c(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.O(getName());
                if (eVar.e(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.f(getName(), i)) {
                b(eVar, eVar.d(getName(), i) + i, list, eVar2);
            }
        }
    }

    void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        this.gz.b(t, cVar);
    }
}
