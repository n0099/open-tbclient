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
/* loaded from: classes5.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0010a, com.airbnb.lottie.model.f {
    final o gv;
    private final String iU;
    final Layer iW;
    @Nullable
    private com.airbnb.lottie.a.b.g iX;
    @Nullable
    private a iY;
    @Nullable
    private a iZ;
    private List<a> jb;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint iM = new Paint(1);
    private final Paint iN = new Paint(1);
    private final Paint iO = new Paint(1);
    private final Paint iP = new Paint(1);
    private final Paint iQ = new Paint();
    private final RectF rect = new RectF();
    private final RectF iR = new RectF();
    private final RectF iS = new RectF();
    private final RectF iT = new RectF();
    final Matrix iV = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> jc = new ArrayList();
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
        this.iW = layer;
        this.iU = layer.getName() + "#draw";
        this.iQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.iO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dn() == Layer.MatteType.Invert) {
            this.iP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.iP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.gv = layer.cV().cv();
        this.gv.a((a.InterfaceC0010a) this);
        if (layer.bW() != null && !layer.bW().isEmpty()) {
            this.iX = new com.airbnb.lottie.a.b.g(layer.bW());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.iX.bX()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.iX.bY()) {
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
        return this.iW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.iY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dd() {
        return this.iY != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.iZ = aVar;
    }

    private void de() {
        if (!this.iW.dj().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.iW.dj());
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
        this.jc.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.iV.set(matrix);
        this.iV.preConcat(this.gv.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.iU);
        if (!this.visible) {
            com.airbnb.lottie.d.F(this.iU);
            return;
        }
        dg();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.jb.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.jb.get(size).gv.getMatrix());
        }
        com.airbnb.lottie.d.F("Layer#parentMatrix");
        int intValue = (int) (((this.gv.ca().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dd() && !df()) {
            this.matrix.preConcat(this.gv.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.F("Layer#drawLayer");
            k(com.airbnb.lottie.d.F(this.iU));
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
        a(canvas, this.rect, this.iM, true);
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
            a(canvas, this.rect, this.iP, false);
            com.airbnb.lottie.d.F("Layer#saveLayer");
            e(canvas);
            this.iY.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.F("Layer#restoreLayer");
            com.airbnb.lottie.d.F("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.F("Layer#restoreLayer");
        k(com.airbnb.lottie.d.F(this.iU));
    }

    private void k(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.iW.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.iQ);
        com.airbnb.lottie.d.F("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.iR.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (df()) {
            int size = this.iX.bW().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.iX.bX().get(i).getValue());
                this.path.transform(matrix);
                switch (this.iX.bW().get(i).cJ()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.iT, false);
                        if (i == 0) {
                            this.iR.set(this.iT);
                        } else {
                            this.iR.set(Math.min(this.iR.left, this.iT.left), Math.min(this.iR.top, this.iT.top), Math.max(this.iR.right, this.iT.right), Math.max(this.iR.bottom, this.iT.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.iR.left), Math.max(rectF.top, this.iR.top), Math.min(rectF.right, this.iR.right), Math.min(rectF.bottom, this.iR.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dd() && this.iW.dn() != Layer.MatteType.Invert) {
            this.iY.a(this.iS, matrix);
            rectF.set(Math.max(rectF.left, this.iS.left), Math.max(rectF.top, this.iS.top), Math.min(rectF.right, this.iS.right), Math.min(rectF.bottom, this.iS.bottom));
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
                paint = this.iO;
                break;
            default:
                paint = this.iN;
                break;
        }
        int size = this.iX.bW().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.iX.bW().get(i).cJ() != maskMode) {
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
                if (this.iX.bW().get(i2).cJ() == maskMode) {
                    this.path.set(this.iX.bX().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.iM.getAlpha();
                    this.iM.setAlpha((int) (this.iX.bY().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.iM);
                    this.iM.setAlpha(alpha);
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
        return (this.iX == null || this.iX.bX().isEmpty()) ? false : true;
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
        if (this.iX != null) {
            for (int i = 0; i < this.iX.bX().size(); i++) {
                this.iX.bX().get(i).setProgress(f);
            }
        }
        if (this.iW.dh() != 0.0f) {
            f /= this.iW.dh();
        }
        if (this.iY != null) {
            this.iY.setProgress(this.iY.iW.dh() * f);
        }
        for (int i2 = 0; i2 < this.jc.size(); i2++) {
            this.jc.get(i2).setProgress(f);
        }
    }

    private void dg() {
        if (this.jb == null) {
            if (this.iZ == null) {
                this.jb = Collections.emptyList();
                return;
            }
            this.jb = new ArrayList();
            for (a aVar = this.iZ; aVar != null; aVar = aVar.iZ) {
                this.jb.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.iW.getName();
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
