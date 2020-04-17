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
    final o Ca;
    private final String Et;
    final Layer Ev;
    @Nullable
    private com.airbnb.lottie.a.b.g Ew;
    @Nullable
    private a Ex;
    @Nullable
    private a Ey;
    private List<a> Ez;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint El = new Paint(1);
    private final Paint Em = new Paint(1);
    private final Paint En = new Paint(1);
    private final Paint Eo = new Paint(1);
    private final Paint Ep = new Paint();
    private final RectF rect = new RectF();
    private final RectF Eq = new RectF();
    private final RectF Er = new RectF();
    private final RectF Es = new RectF();
    final Matrix Eu = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> EA = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.g gVar, com.airbnb.lottie.e eVar) {
        switch (layer.iM()) {
            case Shape:
                return new e(gVar, layer);
            case PreComp:
                return new b(gVar, layer, eVar.aX(layer.getRefId()), eVar);
            case Solid:
                return new f(gVar, layer);
            case Image:
                return new c(gVar, layer);
            case Null:
                return new d(gVar, layer);
            case Text:
                return new g(gVar, layer);
            default:
                com.airbnb.lottie.d.warn("Unknown layer type " + layer.iM());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, Layer layer) {
        this.lottieDrawable = gVar;
        this.Ev = layer;
        this.Et = layer.getName() + "#draw";
        this.Ep.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Em.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.En.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.iN() == Layer.MatteType.Invert) {
            this.Eo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Eo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.Ca = layer.iv().hT();
        this.Ca.a((a.InterfaceC0010a) this);
        if (layer.hu() != null && !layer.hu().isEmpty()) {
            this.Ew = new com.airbnb.lottie.a.b.g(layer.hu());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.Ew.hv()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.Ew.hw()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        iE();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void ha() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer iC() {
        return this.Ev;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.Ex = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iD() {
        return this.Ex != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.Ey = aVar;
    }

    private void iE() {
        if (!this.Ev.iJ().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.Ev.iJ());
            cVar.ho();
            cVar.b(new a.InterfaceC0010a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
                public void ha() {
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
        this.EA.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.Eu.set(matrix);
        this.Eu.preConcat(this.Ca.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.Et);
        if (!this.visible) {
            com.airbnb.lottie.d.aV(this.Et);
            return;
        }
        iG();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.Ez.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.Ez.get(size).Ca.getMatrix());
        }
        com.airbnb.lottie.d.aV("Layer#parentMatrix");
        int intValue = (int) (((this.Ca.hy().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!iD() && !iF()) {
            this.matrix.preConcat(this.Ca.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.aV("Layer#drawLayer");
            h(com.airbnb.lottie.d.aV(this.Et));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.Ca.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.aV("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.El, true);
        com.airbnb.lottie.d.aV("Layer#saveLayer");
        e(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.aV("Layer#drawLayer");
        if (iF()) {
            a(canvas, this.matrix);
        }
        if (iD()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.Eo, false);
            com.airbnb.lottie.d.aV("Layer#saveLayer");
            e(canvas);
            this.Ex.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.aV("Layer#restoreLayer");
            com.airbnb.lottie.d.aV("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.aV("Layer#restoreLayer");
        h(com.airbnb.lottie.d.aV(this.Et));
    }

    private void h(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.Ev.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Ep);
        com.airbnb.lottie.d.aV("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.Eq.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (iF()) {
            int size = this.Ew.hu().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.Ew.hv().get(i).getValue());
                this.path.transform(matrix);
                switch (this.Ew.hu().get(i).ii()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.Es, false);
                        if (i == 0) {
                            this.Eq.set(this.Es);
                        } else {
                            this.Eq.set(Math.min(this.Eq.left, this.Es.left), Math.min(this.Eq.top, this.Es.top), Math.max(this.Eq.right, this.Es.right), Math.max(this.Eq.bottom, this.Es.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Eq.left), Math.max(rectF.top, this.Eq.top), Math.min(rectF.right, this.Eq.right), Math.min(rectF.bottom, this.Eq.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (iD() && this.Ev.iN() != Layer.MatteType.Invert) {
            this.Ex.a(this.Er, matrix);
            rectF.set(Math.max(rectF.left, this.Er.left), Math.max(rectF.top, this.Er.top), Math.min(rectF.right, this.Er.right), Math.min(rectF.bottom, this.Er.bottom));
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
                paint = this.En;
                break;
            default:
                paint = this.Em;
                break;
        }
        int size = this.Ew.hu().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.Ew.hu().get(i).ii() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.airbnb.lottie.d.aV("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.Ew.hu().get(i2).ii() == maskMode) {
                    this.path.set(this.Ew.hv().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.El.getAlpha();
                    this.El.setAlpha((int) (this.Ew.hw().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.El);
                    this.El.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.aV("Layer#restoreLayer");
            com.airbnb.lottie.d.aV("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iF() {
        return (this.Ew == null || this.Ew.hv().isEmpty()) ? false : true;
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
        this.Ca.setProgress(f);
        if (this.Ew != null) {
            for (int i = 0; i < this.Ew.hv().size(); i++) {
                this.Ew.hv().get(i).setProgress(f);
            }
        }
        if (this.Ev.iH() != 0.0f) {
            f /= this.Ev.iH();
        }
        if (this.Ex != null) {
            this.Ex.setProgress(this.Ex.Ev.iH() * f);
        }
        for (int i2 = 0; i2 < this.EA.size(); i2++) {
            this.EA.get(i2).setProgress(f);
        }
    }

    private void iG() {
        if (this.Ez == null) {
            if (this.Ey == null) {
                this.Ez = Collections.emptyList();
                return;
            }
            this.Ez = new ArrayList();
            for (a aVar = this.Ey; aVar != null; aVar = aVar.Ey) {
                this.Ez.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.Ev.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.be(getName());
                if (eVar.i(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.j(getName(), i)) {
                b(eVar, eVar.h(getName(), i) + i, list, eVar2);
            }
        }
    }

    void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        this.Ca.b(t, cVar);
    }
}
