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
/* loaded from: classes7.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0011a, com.airbnb.lottie.model.f {
    final o Ex;
    private final String GN;
    final Layer GP;
    @Nullable
    private com.airbnb.lottie.a.b.g GQ;
    @Nullable
    private a GR;
    @Nullable
    private a GU;
    private List<a> GV;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint GF = new Paint(1);
    private final Paint GG = new Paint(1);
    private final Paint GH = new Paint(1);
    private final Paint GI = new Paint(1);
    private final Paint GJ = new Paint();
    private final RectF rect = new RectF();
    private final RectF GK = new RectF();
    private final RectF GL = new RectF();
    private final RectF GM = new RectF();
    final Matrix GO = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> GW = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.g gVar, com.airbnb.lottie.e eVar) {
        switch (layer.kD()) {
            case Shape:
                return new e(gVar, layer);
            case PreComp:
                return new b(gVar, layer, eVar.bg(layer.getRefId()), eVar);
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
        this.GP = layer;
        this.GN = layer.getName() + "#draw";
        this.GJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.GG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.GH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.kE() == Layer.MatteType.Invert) {
            this.GI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.GI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.Ex = layer.km().jM();
        this.Ex.a((a.InterfaceC0011a) this);
        if (layer.jn() != null && !layer.jn().isEmpty()) {
            this.GQ = new com.airbnb.lottie.a.b.g(layer.jn());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.GQ.jo()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.GQ.jp()) {
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
        return this.GP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.GR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ku() {
        return this.GR != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.GU = aVar;
    }

    private void kv() {
        if (!this.GP.kA().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.GP.kA());
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
        this.GW.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.GO.set(matrix);
        this.GO.preConcat(this.Ex.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.GN);
        if (!this.visible) {
            com.airbnb.lottie.d.be(this.GN);
            return;
        }
        kx();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.GV.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.GV.get(size).Ex.getMatrix());
        }
        com.airbnb.lottie.d.be("Layer#parentMatrix");
        int intValue = (int) (((this.Ex.jr().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!ku() && !kw()) {
            this.matrix.preConcat(this.Ex.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.be("Layer#drawLayer");
            i(com.airbnb.lottie.d.be(this.GN));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.Ex.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.be("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.GF, true);
        com.airbnb.lottie.d.be("Layer#saveLayer");
        e(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.be("Layer#drawLayer");
        if (kw()) {
            a(canvas, this.matrix);
        }
        if (ku()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.GI, false);
            com.airbnb.lottie.d.be("Layer#saveLayer");
            e(canvas);
            this.GR.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.be("Layer#restoreLayer");
            com.airbnb.lottie.d.be("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.be("Layer#restoreLayer");
        i(com.airbnb.lottie.d.be(this.GN));
    }

    private void i(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.GP.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.GJ);
        com.airbnb.lottie.d.be("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.GK.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (kw()) {
            int size = this.GQ.jn().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.GQ.jo().get(i).getValue());
                this.path.transform(matrix);
                switch (this.GQ.jn().get(i).ka()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.GM, false);
                        if (i == 0) {
                            this.GK.set(this.GM);
                        } else {
                            this.GK.set(Math.min(this.GK.left, this.GM.left), Math.min(this.GK.top, this.GM.top), Math.max(this.GK.right, this.GM.right), Math.max(this.GK.bottom, this.GM.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.GK.left), Math.max(rectF.top, this.GK.top), Math.min(rectF.right, this.GK.right), Math.min(rectF.bottom, this.GK.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (ku() && this.GP.kE() != Layer.MatteType.Invert) {
            this.GR.a(this.GL, matrix);
            rectF.set(Math.max(rectF.left, this.GL.left), Math.max(rectF.top, this.GL.top), Math.min(rectF.right, this.GL.right), Math.min(rectF.bottom, this.GL.bottom));
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
                paint = this.GH;
                break;
            default:
                paint = this.GG;
                break;
        }
        int size = this.GQ.jn().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.GQ.jn().get(i).ka() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.airbnb.lottie.d.be("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.GQ.jn().get(i2).ka() == maskMode) {
                    this.path.set(this.GQ.jo().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.GF.getAlpha();
                    this.GF.setAlpha((int) (this.GQ.jp().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.GF);
                    this.GF.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.be("Layer#restoreLayer");
            com.airbnb.lottie.d.be("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kw() {
        return (this.GQ == null || this.GQ.jo().isEmpty()) ? false : true;
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
        this.Ex.setProgress(f);
        if (this.GQ != null) {
            for (int i = 0; i < this.GQ.jo().size(); i++) {
                this.GQ.jo().get(i).setProgress(f);
            }
        }
        if (this.GP.ky() != 0.0f) {
            f /= this.GP.ky();
        }
        if (this.GR != null) {
            this.GR.setProgress(this.GR.GP.ky() * f);
        }
        for (int i2 = 0; i2 < this.GW.size(); i2++) {
            this.GW.get(i2).setProgress(f);
        }
    }

    private void kx() {
        if (this.GV == null) {
            if (this.GU == null) {
                this.GV = Collections.emptyList();
                return;
            }
            this.GV = new ArrayList();
            for (a aVar = this.GU; aVar != null; aVar = aVar.GU) {
                this.GV.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.GP.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.bn(getName());
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
        this.Ex.b(t, cVar);
    }
}
