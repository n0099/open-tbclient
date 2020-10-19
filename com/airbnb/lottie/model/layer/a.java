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
/* loaded from: classes10.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0011a, com.airbnb.lottie.model.f {
    final o DE;
    private final String FU;
    final Layer FW;
    @Nullable
    private com.airbnb.lottie.a.b.g FX;
    @Nullable
    private a FY;
    @Nullable
    private a FZ;
    private List<a> Ga;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint FL = new Paint(1);
    private final Paint FM = new Paint(1);
    private final Paint FN = new Paint(1);
    private final Paint FO = new Paint(1);
    private final Paint FP = new Paint();
    private final RectF rect = new RectF();
    private final RectF FQ = new RectF();
    private final RectF FR = new RectF();
    private final RectF FT = new RectF();
    final Matrix FV = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> Gb = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.g gVar, com.airbnb.lottie.e eVar) {
        switch (layer.kD()) {
            case Shape:
                return new e(gVar, layer);
            case PreComp:
                return new b(gVar, layer, eVar.bd(layer.getRefId()), eVar);
            case Solid:
                return new f(gVar, layer);
            case Image:
                return new c(gVar, layer);
            case Null:
                return new d(gVar, layer);
            case Text:
                return new g(gVar, layer);
            default:
                com.airbnb.lottie.d.warn("Unknown layer type " + layer.kD());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, Layer layer) {
        this.lottieDrawable = gVar;
        this.FW = layer;
        this.FU = layer.getName() + "#draw";
        this.FP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.FM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.FN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.kE() == Layer.MatteType.Invert) {
            this.FO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.FO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.DE = layer.km().jM();
        this.DE.a((a.InterfaceC0011a) this);
        if (layer.jn() != null && !layer.jn().isEmpty()) {
            this.FX = new com.airbnb.lottie.a.b.g(layer.jn());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.FX.jo()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.FX.jp()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        kv();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0011a
    public void iT() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer kt() {
        return this.FW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.FY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ku() {
        return this.FY != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.FZ = aVar;
    }

    private void kv() {
        if (!this.FW.kA().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.FW.kA());
            cVar.jh();
            cVar.b(new a.InterfaceC0011a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0011a
                public void iT() {
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
        this.Gb.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.FV.set(matrix);
        this.FV.preConcat(this.DE.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.FU);
        if (!this.visible) {
            com.airbnb.lottie.d.bb(this.FU);
            return;
        }
        kx();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.Ga.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.Ga.get(size).DE.getMatrix());
        }
        com.airbnb.lottie.d.bb("Layer#parentMatrix");
        int intValue = (int) (((this.DE.jr().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!ku() && !kw()) {
            this.matrix.preConcat(this.DE.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.bb("Layer#drawLayer");
            j(com.airbnb.lottie.d.bb(this.FU));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.DE.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.bb("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.FL, true);
        com.airbnb.lottie.d.bb("Layer#saveLayer");
        e(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.bb("Layer#drawLayer");
        if (kw()) {
            a(canvas, this.matrix);
        }
        if (ku()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.FO, false);
            com.airbnb.lottie.d.bb("Layer#saveLayer");
            e(canvas);
            this.FY.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.bb("Layer#restoreLayer");
            com.airbnb.lottie.d.bb("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.bb("Layer#restoreLayer");
        j(com.airbnb.lottie.d.bb(this.FU));
    }

    private void j(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.FW.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.FP);
        com.airbnb.lottie.d.bb("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.FQ.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (kw()) {
            int size = this.FX.jn().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.FX.jo().get(i).getValue());
                this.path.transform(matrix);
                switch (this.FX.jn().get(i).ka()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.FT, false);
                        if (i == 0) {
                            this.FQ.set(this.FT);
                        } else {
                            this.FQ.set(Math.min(this.FQ.left, this.FT.left), Math.min(this.FQ.top, this.FT.top), Math.max(this.FQ.right, this.FT.right), Math.max(this.FQ.bottom, this.FT.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.FQ.left), Math.max(rectF.top, this.FQ.top), Math.min(rectF.right, this.FQ.right), Math.min(rectF.bottom, this.FQ.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (ku() && this.FW.kE() != Layer.MatteType.Invert) {
            this.FY.a(this.FR, matrix);
            rectF.set(Math.max(rectF.left, this.FR.left), Math.max(rectF.top, this.FR.top), Math.min(rectF.right, this.FR.right), Math.min(rectF.bottom, this.FR.bottom));
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
                paint = this.FN;
                break;
            default:
                paint = this.FM;
                break;
        }
        int size = this.FX.jn().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.FX.jn().get(i).ka() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.airbnb.lottie.d.bb("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.FX.jn().get(i2).ka() == maskMode) {
                    this.path.set(this.FX.jo().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.FL.getAlpha();
                    this.FL.setAlpha((int) (this.FX.jp().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.FL);
                    this.FL.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.bb("Layer#restoreLayer");
            com.airbnb.lottie.d.bb("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kw() {
        return (this.FX == null || this.FX.jo().isEmpty()) ? false : true;
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
        this.DE.setProgress(f);
        if (this.FX != null) {
            for (int i = 0; i < this.FX.jo().size(); i++) {
                this.FX.jo().get(i).setProgress(f);
            }
        }
        if (this.FW.ky() != 0.0f) {
            f /= this.FW.ky();
        }
        if (this.FY != null) {
            this.FY.setProgress(this.FY.FW.ky() * f);
        }
        for (int i2 = 0; i2 < this.Gb.size(); i2++) {
            this.Gb.get(i2).setProgress(f);
        }
    }

    private void kx() {
        if (this.Ga == null) {
            if (this.FZ == null) {
                this.Ga = Collections.emptyList();
                return;
            }
            this.Ga = new ArrayList();
            for (a aVar = this.FZ; aVar != null; aVar = aVar.FZ) {
                this.Ga.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.FW.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
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
        this.DE.b(t, cVar);
    }
}
