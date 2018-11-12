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
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0009a {
    final com.airbnb.lottie.f nh;
    final p pv;
    private final String rR;
    final Layer rT;
    @Nullable
    private com.airbnb.lottie.a.b.g rU;
    @Nullable
    private a rV;
    @Nullable
    private a rW;
    private List<a> rX;
    private final Path oy = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint rJ = new Paint(1);
    private final Paint rK = new Paint(1);
    private final Paint rL = new Paint(1);
    private final Paint rM = new Paint(1);
    private final Paint rN = new Paint();
    private final RectF rect = new RectF();
    private final RectF rO = new RectF();
    private final RectF rP = new RectF();
    private final RectF rQ = new RectF();
    final Matrix rS = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> rY = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.eP()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.W(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.cL());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.eP());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.nh = fVar;
        this.rT = layer;
        this.rR = layer.getName() + "#draw";
        this.rN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.rK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.rL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.eQ() == Layer.MatteType.Invert) {
            this.rM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.rM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.pv = layer.ez().dY();
        this.pv.a((a.InterfaceC0009a) this);
        if (layer.du() != null && !layer.du().isEmpty()) {
            this.rU = new com.airbnb.lottie.a.b.g(layer.du());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.rU.dv()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.rU.dw()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        eI();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void dd() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer eG() {
        return this.rT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.rV = aVar;
    }

    boolean eH() {
        return this.rV != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.rW = aVar;
    }

    private void eI() {
        if (!this.rT.eM().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.rT.eM());
            cVar.dq();
            cVar.b(new a.InterfaceC0009a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
                public void dd() {
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
        this.nh.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.rY.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.rS.set(matrix);
        this.rS.preConcat(this.pv.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.rR);
        if (!this.visible) {
            com.airbnb.lottie.d.U(this.rR);
            return;
        }
        eK();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.rX.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.rX.get(size).pv.getMatrix());
        }
        com.airbnb.lottie.d.U("Layer#parentMatrix");
        int intValue = (int) (((this.pv.dy().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!eH() && !eJ()) {
            this.matrix.preConcat(this.pv.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.U("Layer#drawLayer");
            i(com.airbnb.lottie.d.U(this.rR));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.pv.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.U("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.rJ, 31);
        com.airbnb.lottie.d.U("Layer#saveLayer");
        d(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.U("Layer#drawLayer");
        if (eJ()) {
            a(canvas, this.matrix);
        }
        if (eH()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.rM, 19);
            com.airbnb.lottie.d.U("Layer#saveLayer");
            d(canvas);
            this.rV.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.U("Layer#restoreLayer");
            com.airbnb.lottie.d.U("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.U("Layer#restoreLayer");
        i(com.airbnb.lottie.d.U(this.rR));
    }

    private void i(float f) {
        this.nh.cT().getPerformanceTracker().b(this.rT.getName(), f);
    }

    private void d(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.rN);
        com.airbnb.lottie.d.U("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.rO.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (eJ()) {
            int size = this.rU.du().size();
            for (int i = 0; i < size; i++) {
                this.oy.set(this.rU.dv().get(i).getValue());
                this.oy.transform(matrix);
                switch (this.rU.du().get(i).en()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.oy.computeBounds(this.rQ, false);
                        if (i == 0) {
                            this.rO.set(this.rQ);
                        } else {
                            this.rO.set(Math.min(this.rO.left, this.rQ.left), Math.min(this.rO.top, this.rQ.top), Math.max(this.rO.right, this.rQ.right), Math.max(this.rO.bottom, this.rQ.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.rO.left), Math.max(rectF.top, this.rO.top), Math.min(rectF.right, this.rO.right), Math.min(rectF.bottom, this.rO.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (eH() && this.rT.eQ() != Layer.MatteType.Invert) {
            this.rV.a(this.rP, matrix);
            rectF.set(Math.max(rectF.left, this.rP.left), Math.max(rectF.top, this.rP.top), Math.min(rectF.right, this.rP.right), Math.min(rectF.bottom, this.rP.bottom));
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
            paint = this.rL;
        } else {
            paint = this.rK;
        }
        int size = this.rU.du().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.rU.du().get(i).en() != maskMode) {
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
            com.airbnb.lottie.d.U("Layer#saveLayer");
            d(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.rU.du().get(i2).en() == maskMode) {
                    this.oy.set(this.rU.dv().get(i2).getValue());
                    this.oy.transform(matrix);
                    int alpha = this.rJ.getAlpha();
                    this.rJ.setAlpha((int) (this.rU.dw().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.oy, this.rJ);
                    this.rJ.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.U("Layer#restoreLayer");
            com.airbnb.lottie.d.U("Layer#drawMask");
        }
    }

    boolean eJ() {
        return (this.rU == null || this.rU.dv().isEmpty()) ? false : true;
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
        this.pv.setProgress(f);
        if (this.rT.eL() != 0.0f) {
            f /= this.rT.eL();
        }
        if (this.rV != null) {
            this.rV.setProgress(this.rV.rT.eL() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.rY.size()) {
                this.rY.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void eK() {
        if (this.rX == null) {
            if (this.rW == null) {
                this.rX = Collections.emptyList();
                return;
            }
            this.rX = new ArrayList();
            for (a aVar = this.rW; aVar != null; aVar = aVar.rW) {
                this.rX.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.rT.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
