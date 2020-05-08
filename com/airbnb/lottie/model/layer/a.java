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
    @Nullable
    private a EA;
    @Nullable
    private a EB;
    private List<a> ED;
    private final String Ew;
    final Layer Ey;
    @Nullable
    private com.airbnb.lottie.a.b.g Ez;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint Eo = new Paint(1);
    private final Paint Ep = new Paint(1);
    private final Paint Eq = new Paint(1);
    private final Paint Er = new Paint(1);
    private final Paint Es = new Paint();
    private final RectF rect = new RectF();
    private final RectF Et = new RectF();
    private final RectF Eu = new RectF();
    private final RectF Ev = new RectF();
    final Matrix Ex = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> EE = new ArrayList();
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
        this.Ey = layer;
        this.Ew = layer.getName() + "#draw";
        this.Es.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Ep.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Eq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.iN() == Layer.MatteType.Invert) {
            this.Er.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Er.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.Ca = layer.iv().hT();
        this.Ca.a((a.InterfaceC0010a) this);
        if (layer.hu() != null && !layer.hu().isEmpty()) {
            this.Ez = new com.airbnb.lottie.a.b.g(layer.hu());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.Ez.hv()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.Ez.hw()) {
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
        return this.Ey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.EA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iD() {
        return this.EA != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.EB = aVar;
    }

    private void iE() {
        if (!this.Ey.iJ().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.Ey.iJ());
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
        this.EE.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.Ex.set(matrix);
        this.Ex.preConcat(this.Ca.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.Ew);
        if (!this.visible) {
            com.airbnb.lottie.d.aV(this.Ew);
            return;
        }
        iG();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.ED.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.ED.get(size).Ca.getMatrix());
        }
        com.airbnb.lottie.d.aV("Layer#parentMatrix");
        int intValue = (int) (((this.Ca.hy().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!iD() && !iF()) {
            this.matrix.preConcat(this.Ca.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.aV("Layer#drawLayer");
            h(com.airbnb.lottie.d.aV(this.Ew));
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
        a(canvas, this.rect, this.Eo, true);
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
            a(canvas, this.rect, this.Er, false);
            com.airbnb.lottie.d.aV("Layer#saveLayer");
            e(canvas);
            this.EA.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.aV("Layer#restoreLayer");
            com.airbnb.lottie.d.aV("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.aV("Layer#restoreLayer");
        h(com.airbnb.lottie.d.aV(this.Ew));
    }

    private void h(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.Ey.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Es);
        com.airbnb.lottie.d.aV("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.Et.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (iF()) {
            int size = this.Ez.hu().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.Ez.hv().get(i).getValue());
                this.path.transform(matrix);
                switch (this.Ez.hu().get(i).ii()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.Ev, false);
                        if (i == 0) {
                            this.Et.set(this.Ev);
                        } else {
                            this.Et.set(Math.min(this.Et.left, this.Ev.left), Math.min(this.Et.top, this.Ev.top), Math.max(this.Et.right, this.Ev.right), Math.max(this.Et.bottom, this.Ev.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Et.left), Math.max(rectF.top, this.Et.top), Math.min(rectF.right, this.Et.right), Math.min(rectF.bottom, this.Et.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (iD() && this.Ey.iN() != Layer.MatteType.Invert) {
            this.EA.a(this.Eu, matrix);
            rectF.set(Math.max(rectF.left, this.Eu.left), Math.max(rectF.top, this.Eu.top), Math.min(rectF.right, this.Eu.right), Math.min(rectF.bottom, this.Eu.bottom));
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
                paint = this.Eq;
                break;
            default:
                paint = this.Ep;
                break;
        }
        int size = this.Ez.hu().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.Ez.hu().get(i).ii() != maskMode) {
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
                if (this.Ez.hu().get(i2).ii() == maskMode) {
                    this.path.set(this.Ez.hv().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Eo.getAlpha();
                    this.Eo.setAlpha((int) (this.Ez.hw().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.Eo);
                    this.Eo.setAlpha(alpha);
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
        return (this.Ez == null || this.Ez.hv().isEmpty()) ? false : true;
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
        if (this.Ez != null) {
            for (int i = 0; i < this.Ez.hv().size(); i++) {
                this.Ez.hv().get(i).setProgress(f);
            }
        }
        if (this.Ey.iH() != 0.0f) {
            f /= this.Ey.iH();
        }
        if (this.EA != null) {
            this.EA.setProgress(this.EA.Ey.iH() * f);
        }
        for (int i2 = 0; i2 < this.EE.size(); i2++) {
            this.EE.get(i2).setProgress(f);
        }
    }

    private void iG() {
        if (this.ED == null) {
            if (this.EB == null) {
                this.ED = Collections.emptyList();
                return;
            }
            this.ED = new ArrayList();
            for (a aVar = this.EB; aVar != null; aVar = aVar.EB) {
                this.ED.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.Ey.getName();
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
