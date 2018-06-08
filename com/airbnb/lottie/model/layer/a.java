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
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0006a {
    final com.airbnb.lottie.f jY;
    final p mk;
    private final String oO;
    final Layer oQ;
    @Nullable
    private com.airbnb.lottie.a.b.g oR;
    @Nullable
    private a oS;
    @Nullable
    private a oT;
    private List<a> oU;
    private final Path lp = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint oG = new Paint(1);
    private final Paint oH = new Paint(1);
    private final Paint oI = new Paint(1);
    private final Paint oJ = new Paint(1);
    private final Paint oK = new Paint();
    private final RectF lr = new RectF();
    private final RectF oL = new RectF();
    private final RectF oM = new RectF();
    private final RectF oN = new RectF();
    final Matrix oP = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> oV = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.dt()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.F(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.bp());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.dt());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.jY = fVar;
        this.oQ = layer;
        this.oO = layer.getName() + "#draw";
        this.oK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.oH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.oI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.du() == Layer.MatteType.Invert) {
            this.oJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.oJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.mk = layer.dd().cC();
        this.mk.a((a.InterfaceC0006a) this);
        if (layer.bY() != null && !layer.bY().isEmpty()) {
            this.oR = new com.airbnb.lottie.a.b.g(layer.bY());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.oR.bZ()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.oR.ca()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        dm();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dk() {
        return this.oQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.oS = aVar;
    }

    boolean dl() {
        return this.oS != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.oT = aVar;
    }

    private void dm() {
        if (!this.oQ.dq().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.oQ.dq());
            cVar.bU();
            cVar.b(new a.InterfaceC0006a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
                public void bH() {
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
        this.jY.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.oV.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.oP.set(matrix);
        this.oP.preConcat(this.mk.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.oO);
        if (!this.visible) {
            com.airbnb.lottie.d.D(this.oO);
            return;
        }
        m6do();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.oU.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.oU.get(size).mk.getMatrix());
        }
        com.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.mk.cc().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dl() && !dn()) {
            this.matrix.preConcat(this.mk.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.airbnb.lottie.d.D(this.oO));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.lr.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.lr, this.matrix);
        c(this.lr, this.matrix);
        this.matrix.preConcat(this.mk.getMatrix());
        b(this.lr, this.matrix);
        this.lr.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.D("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.lr, this.oG, 31);
        com.airbnb.lottie.d.D("Layer#saveLayer");
        f(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.D("Layer#drawLayer");
        if (dn()) {
            a(canvas, this.matrix);
        }
        if (dl()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.lr, this.oJ, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            f(canvas);
            this.oS.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.airbnb.lottie.d.D(this.oO));
    }

    private void i(float f) {
        this.jY.bx().getPerformanceTracker().b(this.oQ.getName(), f);
    }

    private void f(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.lr.left - 1.0f, this.lr.top - 1.0f, this.lr.right + 1.0f, 1.0f + this.lr.bottom, this.oK);
        com.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.oL.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dn()) {
            int size = this.oR.bY().size();
            for (int i = 0; i < size; i++) {
                this.lp.set(this.oR.bZ().get(i).getValue());
                this.lp.transform(matrix);
                switch (this.oR.bY().get(i).cR()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.lp.computeBounds(this.oN, false);
                        if (i == 0) {
                            this.oL.set(this.oN);
                        } else {
                            this.oL.set(Math.min(this.oL.left, this.oN.left), Math.min(this.oL.top, this.oN.top), Math.max(this.oL.right, this.oN.right), Math.max(this.oL.bottom, this.oN.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.oL.left), Math.max(rectF.top, this.oL.top), Math.min(rectF.right, this.oL.right), Math.min(rectF.bottom, this.oL.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dl() && this.oQ.du() != Layer.MatteType.Invert) {
            this.oS.a(this.oM, matrix);
            rectF.set(Math.max(rectF.left, this.oM.left), Math.max(rectF.top, this.oM.top), Math.min(rectF.right, this.oM.right), Math.min(rectF.bottom, this.oM.bottom));
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
            paint = this.oI;
        } else {
            paint = this.oH;
        }
        int size = this.oR.bY().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.oR.bY().get(i).cR() != maskMode) {
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
            canvas.saveLayer(this.lr, paint, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            f(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.oR.bY().get(i2).cR() == maskMode) {
                    this.lp.set(this.oR.bZ().get(i2).getValue());
                    this.lp.transform(matrix);
                    int alpha = this.oG.getAlpha();
                    this.oG.setAlpha((int) (this.oR.ca().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.lp, this.oG);
                    this.oG.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    boolean dn() {
        return (this.oR == null || this.oR.bZ().isEmpty()) ? false : true;
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
        this.mk.setProgress(f);
        if (this.oQ.dp() != 0.0f) {
            f /= this.oQ.dp();
        }
        if (this.oS != null) {
            this.oS.setProgress(this.oS.oQ.dp() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oV.size()) {
                this.oV.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m6do() {
        if (this.oU == null) {
            if (this.oT == null) {
                this.oU = Collections.emptyList();
                return;
            }
            this.oU = new ArrayList();
            for (a aVar = this.oT; aVar != null; aVar = aVar.oT) {
                this.oU.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.oQ.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
