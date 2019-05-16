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
    final com.airbnb.lottie.f kC;
    final p mN;
    @Nullable
    private a pA;
    private List<a> pB;
    private final String pv;
    final Layer px;
    @Nullable
    private com.airbnb.lottie.a.b.g py;
    @Nullable
    private a pz;
    private final Path lS = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint pi = new Paint(1);
    private final Paint pj = new Paint(1);
    private final Paint pl = new Paint(1);
    private final Paint po = new Paint(1);
    private final Paint pp = new Paint();
    private final RectF rect = new RectF();
    private final RectF pq = new RectF();
    private final RectF pr = new RectF();
    private final RectF pu = new RectF();
    final Matrix pw = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> pC = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.dI()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.F(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.bE());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.dI());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.kC = fVar;
        this.px = layer;
        this.pv = layer.getName() + "#draw";
        this.pp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.pj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.pl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dJ() == Layer.MatteType.Invert) {
            this.po.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.po.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.mN = layer.ds().cR();
        this.mN.a((a.InterfaceC0007a) this);
        if (layer.cn() != null && !layer.cn().isEmpty()) {
            this.py = new com.airbnb.lottie.a.b.g(layer.cn());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.py.co()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.py.cp()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        dB();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bW() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dz() {
        return this.px;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.pz = aVar;
    }

    boolean dA() {
        return this.pz != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.pA = aVar;
    }

    private void dB() {
        if (!this.px.dF().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.px.dF());
            cVar.cj();
            cVar.b(new a.InterfaceC0007a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
                public void bW() {
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
        this.kC.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.pC.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.pw.set(matrix);
        this.pw.preConcat(this.mN.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.pv);
        if (!this.visible) {
            com.airbnb.lottie.d.D(this.pv);
            return;
        }
        dD();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.pB.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.pB.get(size).mN.getMatrix());
        }
        com.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.mN.cr().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dA() && !dC()) {
            this.matrix.preConcat(this.mN.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.airbnb.lottie.d.D(this.pv));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.mN.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.D("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.pi, 31);
        com.airbnb.lottie.d.D("Layer#saveLayer");
        d(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.D("Layer#drawLayer");
        if (dC()) {
            a(canvas, this.matrix);
        }
        if (dA()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.po, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            this.pz.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.airbnb.lottie.d.D(this.pv));
    }

    private void i(float f) {
        this.kC.bM().getPerformanceTracker().b(this.px.getName(), f);
    }

    private void d(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.pp);
        com.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.pq.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dC()) {
            int size = this.py.cn().size();
            for (int i = 0; i < size; i++) {
                this.lS.set(this.py.co().get(i).getValue());
                this.lS.transform(matrix);
                switch (this.py.cn().get(i).dg()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.lS.computeBounds(this.pu, false);
                        if (i == 0) {
                            this.pq.set(this.pu);
                        } else {
                            this.pq.set(Math.min(this.pq.left, this.pu.left), Math.min(this.pq.top, this.pu.top), Math.max(this.pq.right, this.pu.right), Math.max(this.pq.bottom, this.pu.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.pq.left), Math.max(rectF.top, this.pq.top), Math.min(rectF.right, this.pq.right), Math.min(rectF.bottom, this.pq.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dA() && this.px.dJ() != Layer.MatteType.Invert) {
            this.pz.a(this.pr, matrix);
            rectF.set(Math.max(rectF.left, this.pr.left), Math.max(rectF.top, this.pr.top), Math.min(rectF.right, this.pr.right), Math.min(rectF.bottom, this.pr.bottom));
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
            paint = this.pl;
        } else {
            paint = this.pj;
        }
        int size = this.py.cn().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.py.cn().get(i).dg() != maskMode) {
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
                if (this.py.cn().get(i2).dg() == maskMode) {
                    this.lS.set(this.py.co().get(i2).getValue());
                    this.lS.transform(matrix);
                    int alpha = this.pi.getAlpha();
                    this.pi.setAlpha((int) (this.py.cp().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.lS, this.pi);
                    this.pi.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    boolean dC() {
        return (this.py == null || this.py.co().isEmpty()) ? false : true;
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
        this.mN.setProgress(f);
        if (this.px.dE() != 0.0f) {
            f /= this.px.dE();
        }
        if (this.pz != null) {
            this.pz.setProgress(this.pz.px.dE() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pC.size()) {
                this.pC.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void dD() {
        if (this.pB == null) {
            if (this.pA == null) {
                this.pB = Collections.emptyList();
                return;
            }
            this.pB = new ArrayList();
            for (a aVar = this.pA; aVar != null; aVar = aVar.pA) {
                this.pB.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.px.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
