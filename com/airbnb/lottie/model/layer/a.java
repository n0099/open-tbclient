package com.airbnb.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0007a {
    final com.airbnb.lottie.f kB;
    final p mM;
    @Nullable
    private a pA;
    @Nullable
    private a pB;
    private List<a> pC;
    private final String pw;
    final Layer py;
    @Nullable
    private com.airbnb.lottie.a.b.g pz;
    private final Path lR = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint pj = new Paint(1);
    private final Paint pl = new Paint(1);
    private final Paint po = new Paint(1);
    private final Paint pp = new Paint(1);
    private final Paint pq = new Paint();
    private final RectF rect = new RectF();
    private final RectF pr = new RectF();
    private final RectF pu = new RectF();
    private final RectF pv = new RectF();
    final Matrix px = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> pD = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.dP()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.F(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.bI());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.dP());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.kB = fVar;
        this.py = layer;
        this.pw = layer.getName() + "#draw";
        this.pq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.pl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.po.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dQ() == Layer.MatteType.Invert) {
            this.pp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.pp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.mM = layer.dz().cX();
        this.mM.a((a.InterfaceC0007a) this);
        if (layer.cs() != null && !layer.cs().isEmpty()) {
            this.pz = new com.airbnb.lottie.a.b.g(layer.cs());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.pz.ct()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.pz.cu()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        dI();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ca() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dG() {
        return this.py;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.pA = aVar;
    }

    boolean dH() {
        return this.pA != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.pB = aVar;
    }

    private void dI() {
        if (!this.py.dM().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.py.dM());
            cVar.co();
            cVar.b(new a.InterfaceC0007a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
                public void ca() {
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
        this.kB.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.pD.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.px.set(matrix);
        this.px.preConcat(this.mM.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.pw);
        if (!this.visible) {
            com.airbnb.lottie.d.D(this.pw);
            return;
        }
        dK();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.pC.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.pC.get(size).mM.getMatrix());
        }
        com.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.mM.cw().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dH() && !dJ()) {
            this.matrix.preConcat(this.mM.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.airbnb.lottie.d.D(this.pw));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.mM.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.D("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.pj, 31);
        com.airbnb.lottie.d.D("Layer#saveLayer");
        d(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.D("Layer#drawLayer");
        if (dJ()) {
            a(canvas, this.matrix);
        }
        if (dH()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.pp, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            this.pA.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.airbnb.lottie.d.D(this.pw));
    }

    private void i(float f) {
        this.kB.bQ().getPerformanceTracker().b(this.py.getName(), f);
    }

    private void d(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.pq);
        com.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.pr.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dJ()) {
            int size = this.pz.cs().size();
            for (int i = 0; i < size; i++) {
                this.lR.set(this.pz.ct().get(i).getValue());
                this.lR.transform(matrix);
                switch (this.pz.cs().get(i).dn()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.lR.computeBounds(this.pv, false);
                        if (i == 0) {
                            this.pr.set(this.pv);
                        } else {
                            this.pr.set(Math.min(this.pr.left, this.pv.left), Math.min(this.pr.top, this.pv.top), Math.max(this.pr.right, this.pv.right), Math.max(this.pr.bottom, this.pv.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.pr.left), Math.max(rectF.top, this.pr.top), Math.min(rectF.right, this.pr.right), Math.min(rectF.bottom, this.pr.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dH() && this.py.dQ() != Layer.MatteType.Invert) {
            this.pA.a(this.pu, matrix);
            rectF.set(Math.max(rectF.left, this.pu.left), Math.max(rectF.top, this.pu.top), Math.min(rectF.right, this.pu.right), Math.min(rectF.bottom, this.pu.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z;
        if (maskMode == Mask.MaskMode.MaskModeSubtract) {
            paint = this.po;
        } else {
            paint = this.pl;
        }
        int size = this.pz.cs().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.pz.cs().get(i).dn() != maskMode) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            com.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, paint, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.pz.cs().get(i2).dn() == maskMode) {
                    this.lR.set(this.pz.ct().get(i2).getValue());
                    this.lR.transform(matrix);
                    int alpha = this.pj.getAlpha();
                    this.pj.setAlpha((int) (this.pz.cu().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.lR, this.pj);
                    this.pj.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    boolean dJ() {
        return (this.pz == null || this.pz.ct().isEmpty()) ? false : true;
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
        this.mM.setProgress(f);
        if (this.py.dL() != 0.0f) {
            f /= this.py.dL();
        }
        if (this.pA != null) {
            this.pA.setProgress(this.pA.py.dL() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pD.size()) {
                this.pD.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void dK() {
        if (this.pC == null) {
            if (this.pB == null) {
                this.pC = Collections.emptyList();
                return;
            }
            this.pC = new ArrayList();
            for (a aVar = this.pB; aVar != null; aVar = aVar.pB) {
                this.pC.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.py.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
