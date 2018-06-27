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
    final p mi;
    private final String oN;
    final Layer oP;
    @Nullable
    private com.airbnb.lottie.a.b.g oQ;
    @Nullable
    private a oR;
    @Nullable
    private a oS;
    private List<a> oT;
    private final Path lo = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint oF = new Paint(1);
    private final Paint oG = new Paint(1);
    private final Paint oH = new Paint(1);
    private final Paint oI = new Paint(1);
    private final Paint oJ = new Paint();
    private final RectF rect = new RectF();
    private final RectF oK = new RectF();
    private final RectF oL = new RectF();
    private final RectF oM = new RectF();
    final Matrix oO = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> oU = new ArrayList();
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
        this.oP = layer;
        this.oN = layer.getName() + "#draw";
        this.oJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.oG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.oH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.du() == Layer.MatteType.Invert) {
            this.oI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.oI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.mi = layer.dd().cC();
        this.mi.a((a.InterfaceC0006a) this);
        if (layer.bY() != null && !layer.bY().isEmpty()) {
            this.oQ = new com.airbnb.lottie.a.b.g(layer.bY());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.oQ.bZ()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.oQ.ca()) {
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
        return this.oP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.oR = aVar;
    }

    boolean dl() {
        return this.oR != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.oS = aVar;
    }

    private void dm() {
        if (!this.oP.dq().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.oP.dq());
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
            this.oU.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.oO.set(matrix);
        this.oO.preConcat(this.mi.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.oN);
        if (!this.visible) {
            com.airbnb.lottie.d.D(this.oN);
            return;
        }
        m6do();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.oT.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.oT.get(size).mi.getMatrix());
        }
        com.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.mi.cc().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dl() && !dn()) {
            this.matrix.preConcat(this.mi.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.airbnb.lottie.d.D(this.oN));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.mi.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.D("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.oF, 31);
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
            canvas.saveLayer(this.rect, this.oI, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            f(canvas);
            this.oR.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.airbnb.lottie.d.D(this.oN));
    }

    private void i(float f) {
        this.jY.bx().getPerformanceTracker().b(this.oP.getName(), f);
    }

    private void f(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.oJ);
        com.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.oK.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dn()) {
            int size = this.oQ.bY().size();
            for (int i = 0; i < size; i++) {
                this.lo.set(this.oQ.bZ().get(i).getValue());
                this.lo.transform(matrix);
                switch (this.oQ.bY().get(i).cR()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.lo.computeBounds(this.oM, false);
                        if (i == 0) {
                            this.oK.set(this.oM);
                        } else {
                            this.oK.set(Math.min(this.oK.left, this.oM.left), Math.min(this.oK.top, this.oM.top), Math.max(this.oK.right, this.oM.right), Math.max(this.oK.bottom, this.oM.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.oK.left), Math.max(rectF.top, this.oK.top), Math.min(rectF.right, this.oK.right), Math.min(rectF.bottom, this.oK.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dl() && this.oP.du() != Layer.MatteType.Invert) {
            this.oR.a(this.oL, matrix);
            rectF.set(Math.max(rectF.left, this.oL.left), Math.max(rectF.top, this.oL.top), Math.min(rectF.right, this.oL.right), Math.min(rectF.bottom, this.oL.bottom));
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
            paint = this.oH;
        } else {
            paint = this.oG;
        }
        int size = this.oQ.bY().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.oQ.bY().get(i).cR() != maskMode) {
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
            f(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.oQ.bY().get(i2).cR() == maskMode) {
                    this.lo.set(this.oQ.bZ().get(i2).getValue());
                    this.lo.transform(matrix);
                    int alpha = this.oF.getAlpha();
                    this.oF.setAlpha((int) (this.oQ.ca().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.lo, this.oF);
                    this.oF.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    boolean dn() {
        return (this.oQ == null || this.oQ.bZ().isEmpty()) ? false : true;
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
        this.mi.setProgress(f);
        if (this.oP.dp() != 0.0f) {
            f /= this.oP.dp();
        }
        if (this.oR != null) {
            this.oR.setProgress(this.oR.oP.dp() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oU.size()) {
                this.oU.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m6do() {
        if (this.oT == null) {
            if (this.oS == null) {
                this.oT = Collections.emptyList();
                return;
            }
            this.oT = new ArrayList();
            for (a aVar = this.oS; aVar != null; aVar = aVar.oS) {
                this.oT.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.oP.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
