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
    final o CB;
    private final String EY;
    final Layer Fa;
    @Nullable
    private com.airbnb.lottie.a.b.g Fb;
    @Nullable
    private a Fc;
    @Nullable
    private a Fd;
    private List<a> Fe;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint EP = new Paint(1);
    private final Paint ER = new Paint(1);
    private final Paint ES = new Paint(1);
    private final Paint ET = new Paint(1);
    private final Paint EU = new Paint();
    private final RectF rect = new RectF();
    private final RectF EV = new RectF();
    private final RectF EW = new RectF();
    private final RectF EX = new RectF();
    final Matrix EZ = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> Ff = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.g gVar, com.airbnb.lottie.e eVar) {
        switch (layer.jc()) {
            case Shape:
                return new e(gVar, layer);
            case PreComp:
                return new b(gVar, layer, eVar.aY(layer.getRefId()), eVar);
            case Solid:
                return new f(gVar, layer);
            case Image:
                return new c(gVar, layer);
            case Null:
                return new d(gVar, layer);
            case Text:
                return new g(gVar, layer);
            default:
                com.airbnb.lottie.d.warn("Unknown layer type " + layer.jc());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, Layer layer) {
        this.lottieDrawable = gVar;
        this.Fa = layer;
        this.EY = layer.getName() + "#draw";
        this.EU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ER.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.ES.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.jd() == Layer.MatteType.Invert) {
            this.ET.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.ET.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.CB = layer.iL().ik();
        this.CB.a((a.InterfaceC0010a) this);
        if (layer.hK() != null && !layer.hK().isEmpty()) {
            this.Fb = new com.airbnb.lottie.a.b.g(layer.hK());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.Fb.hL()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.Fb.hM()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        iU();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void hq() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer iS() {
        return this.Fa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.Fc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iT() {
        return this.Fc != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.Fd = aVar;
    }

    private void iU() {
        if (!this.Fa.iZ().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.Fa.iZ());
            cVar.hE();
            cVar.b(new a.InterfaceC0010a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
                public void hq() {
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
        this.Ff.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.EZ.set(matrix);
        this.EZ.preConcat(this.CB.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.EY);
        if (!this.visible) {
            com.airbnb.lottie.d.aW(this.EY);
            return;
        }
        iW();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.Fe.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.Fe.get(size).CB.getMatrix());
        }
        com.airbnb.lottie.d.aW("Layer#parentMatrix");
        int intValue = (int) (((this.CB.hO().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!iT() && !iV()) {
            this.matrix.preConcat(this.CB.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.aW("Layer#drawLayer");
            j(com.airbnb.lottie.d.aW(this.EY));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.CB.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.aW("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.EP, true);
        com.airbnb.lottie.d.aW("Layer#saveLayer");
        e(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.aW("Layer#drawLayer");
        if (iV()) {
            a(canvas, this.matrix);
        }
        if (iT()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.ET, false);
            com.airbnb.lottie.d.aW("Layer#saveLayer");
            e(canvas);
            this.Fc.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.aW("Layer#restoreLayer");
            com.airbnb.lottie.d.aW("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.aW("Layer#restoreLayer");
        j(com.airbnb.lottie.d.aW(this.EY));
    }

    private void j(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.Fa.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.EU);
        com.airbnb.lottie.d.aW("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.EV.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (iV()) {
            int size = this.Fb.hK().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.Fb.hL().get(i).getValue());
                this.path.transform(matrix);
                switch (this.Fb.hK().get(i).iz()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.EX, false);
                        if (i == 0) {
                            this.EV.set(this.EX);
                        } else {
                            this.EV.set(Math.min(this.EV.left, this.EX.left), Math.min(this.EV.top, this.EX.top), Math.max(this.EV.right, this.EX.right), Math.max(this.EV.bottom, this.EX.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.EV.left), Math.max(rectF.top, this.EV.top), Math.min(rectF.right, this.EV.right), Math.min(rectF.bottom, this.EV.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (iT() && this.Fa.jd() != Layer.MatteType.Invert) {
            this.Fc.a(this.EW, matrix);
            rectF.set(Math.max(rectF.left, this.EW.left), Math.max(rectF.top, this.EW.top), Math.min(rectF.right, this.EW.right), Math.min(rectF.bottom, this.EW.bottom));
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
                paint = this.ES;
                break;
            default:
                paint = this.ER;
                break;
        }
        int size = this.Fb.hK().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.Fb.hK().get(i).iz() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.airbnb.lottie.d.aW("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.Fb.hK().get(i2).iz() == maskMode) {
                    this.path.set(this.Fb.hL().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.EP.getAlpha();
                    this.EP.setAlpha((int) (this.Fb.hM().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.EP);
                    this.EP.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.aW("Layer#restoreLayer");
            com.airbnb.lottie.d.aW("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iV() {
        return (this.Fb == null || this.Fb.hL().isEmpty()) ? false : true;
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
        this.CB.setProgress(f);
        if (this.Fb != null) {
            for (int i = 0; i < this.Fb.hL().size(); i++) {
                this.Fb.hL().get(i).setProgress(f);
            }
        }
        if (this.Fa.iX() != 0.0f) {
            f /= this.Fa.iX();
        }
        if (this.Fc != null) {
            this.Fc.setProgress(this.Fc.Fa.iX() * f);
        }
        for (int i2 = 0; i2 < this.Ff.size(); i2++) {
            this.Ff.get(i2).setProgress(f);
        }
    }

    private void iW() {
        if (this.Fe == null) {
            if (this.Fd == null) {
                this.Fe = Collections.emptyList();
                return;
            }
            this.Fe = new ArrayList();
            for (a aVar = this.Fd; aVar != null; aVar = aVar.Fd) {
                this.Fe.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.Fa.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.bf(getName());
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
        this.CB.b(t, cVar);
    }
}
