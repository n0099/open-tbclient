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
/* loaded from: classes4.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0010a, com.airbnb.lottie.model.f {
    final o gv;
    private final String iV;
    final Layer iX;
    @Nullable
    private com.airbnb.lottie.a.b.g iY;
    @Nullable
    private a iZ;
    @Nullable
    private a jb;
    private List<a> jc;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint iN = new Paint(1);
    private final Paint iO = new Paint(1);
    private final Paint iP = new Paint(1);
    private final Paint iQ = new Paint(1);
    private final Paint iR = new Paint();
    private final RectF rect = new RectF();
    private final RectF iS = new RectF();
    private final RectF iT = new RectF();
    private final RectF iU = new RectF();
    final Matrix iW = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> jd = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.g gVar, com.airbnb.lottie.e eVar) {
        switch (layer.dm()) {
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
                com.airbnb.lottie.d.warn("Unknown layer type " + layer.dm());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, Layer layer) {
        this.lottieDrawable = gVar;
        this.iX = layer;
        this.iV = layer.getName() + "#draw";
        this.iR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.iP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dn() == Layer.MatteType.Invert) {
            this.iQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.iQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.gv = layer.cV().cv();
        this.gv.a((a.InterfaceC0010a) this);
        if (layer.bW() != null && !layer.bW().isEmpty()) {
            this.iY = new com.airbnb.lottie.a.b.g(layer.bW());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.iY.bX()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.iY.bY()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        de();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bC() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dc() {
        return this.iX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.iZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dd() {
        return this.iZ != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.jb = aVar;
    }

    private void de() {
        if (!this.iX.dj().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.iX.dj());
            cVar.bQ();
            cVar.b(new a.InterfaceC0010a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
                public void bC() {
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
        this.jd.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.iW.set(matrix);
        this.iW.preConcat(this.gv.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.iV);
        if (!this.visible) {
            com.airbnb.lottie.d.F(this.iV);
            return;
        }
        dg();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.jc.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.jc.get(size).gv.getMatrix());
        }
        com.airbnb.lottie.d.F("Layer#parentMatrix");
        int intValue = (int) (((this.gv.ca().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dd() && !df()) {
            this.matrix.preConcat(this.gv.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.F("Layer#drawLayer");
            k(com.airbnb.lottie.d.F(this.iV));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.gv.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.F("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.iN, true);
        com.airbnb.lottie.d.F("Layer#saveLayer");
        e(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.F("Layer#drawLayer");
        if (df()) {
            a(canvas, this.matrix);
        }
        if (dd()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.iQ, false);
            com.airbnb.lottie.d.F("Layer#saveLayer");
            e(canvas);
            this.iZ.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.F("Layer#restoreLayer");
            com.airbnb.lottie.d.F("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.F("Layer#restoreLayer");
        k(com.airbnb.lottie.d.F(this.iV));
    }

    private void k(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.iX.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.iR);
        com.airbnb.lottie.d.F("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.iS.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (df()) {
            int size = this.iY.bW().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.iY.bX().get(i).getValue());
                this.path.transform(matrix);
                switch (this.iY.bW().get(i).cJ()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.iU, false);
                        if (i == 0) {
                            this.iS.set(this.iU);
                        } else {
                            this.iS.set(Math.min(this.iS.left, this.iU.left), Math.min(this.iS.top, this.iU.top), Math.max(this.iS.right, this.iU.right), Math.max(this.iS.bottom, this.iU.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.iS.left), Math.max(rectF.top, this.iS.top), Math.min(rectF.right, this.iS.right), Math.min(rectF.bottom, this.iS.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dd() && this.iX.dn() != Layer.MatteType.Invert) {
            this.iZ.a(this.iT, matrix);
            rectF.set(Math.max(rectF.left, this.iT.left), Math.max(rectF.top, this.iT.top), Math.min(rectF.right, this.iT.right), Math.min(rectF.bottom, this.iT.bottom));
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
                paint = this.iP;
                break;
            default:
                paint = this.iO;
                break;
        }
        int size = this.iY.bW().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.iY.bW().get(i).cJ() != maskMode) {
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
                if (this.iY.bW().get(i2).cJ() == maskMode) {
                    this.path.set(this.iY.bX().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.iN.getAlpha();
                    this.iN.setAlpha((int) (this.iY.bY().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.iN);
                    this.iN.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.F("Layer#restoreLayer");
            com.airbnb.lottie.d.F("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean df() {
        return (this.iY == null || this.iY.bX().isEmpty()) ? false : true;
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
        this.gv.setProgress(f);
        if (this.iY != null) {
            for (int i = 0; i < this.iY.bX().size(); i++) {
                this.iY.bX().get(i).setProgress(f);
            }
        }
        if (this.iX.dh() != 0.0f) {
            f /= this.iX.dh();
        }
        if (this.iZ != null) {
            this.iZ.setProgress(this.iZ.iX.dh() * f);
        }
        for (int i2 = 0; i2 < this.jd.size(); i2++) {
            this.jd.get(i2).setProgress(f);
        }
    }

    private void dg() {
        if (this.jc == null) {
            if (this.jb == null) {
                this.jc = Collections.emptyList();
                return;
            }
            this.jc = new ArrayList();
            for (a aVar = this.jb; aVar != null; aVar = aVar.jb) {
                this.jc.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.iX.getName();
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
        this.gv.b(t, cVar);
    }
}
