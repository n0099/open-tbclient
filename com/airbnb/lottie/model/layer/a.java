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
    final p pu;
    private final String rQ;
    final Layer rS;
    @Nullable
    private com.airbnb.lottie.a.b.g rT;
    @Nullable
    private a rU;
    @Nullable
    private a rV;
    private List<a> rW;
    private final Path oy = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint rI = new Paint(1);
    private final Paint rJ = new Paint(1);
    private final Paint rK = new Paint(1);
    private final Paint rL = new Paint(1);
    private final Paint rM = new Paint();
    private final RectF rect = new RectF();
    private final RectF rN = new RectF();
    private final RectF rO = new RectF();
    private final RectF rP = new RectF();
    final Matrix rR = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> rX = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.eQ()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.W(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.cM());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.eQ());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.nh = fVar;
        this.rS = layer;
        this.rQ = layer.getName() + "#draw";
        this.rM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.rJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.rK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.eR() == Layer.MatteType.Invert) {
            this.rL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.rL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.pu = layer.eA().dZ();
        this.pu.a((a.InterfaceC0009a) this);
        if (layer.dv() != null && !layer.dv().isEmpty()) {
            this.rT = new com.airbnb.lottie.a.b.g(layer.dv());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.rT.dw()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.rT.dx()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        eJ();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void de() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer eH() {
        return this.rS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.rU = aVar;
    }

    boolean eI() {
        return this.rU != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.rV = aVar;
    }

    private void eJ() {
        if (!this.rS.eN().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.rS.eN());
            cVar.dr();
            cVar.b(new a.InterfaceC0009a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
                public void de() {
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
            this.rX.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.rR.set(matrix);
        this.rR.preConcat(this.pu.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.rQ);
        if (!this.visible) {
            com.airbnb.lottie.d.U(this.rQ);
            return;
        }
        eL();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.rW.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.rW.get(size).pu.getMatrix());
        }
        com.airbnb.lottie.d.U("Layer#parentMatrix");
        int intValue = (int) (((this.pu.dz().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!eI() && !eK()) {
            this.matrix.preConcat(this.pu.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.U("Layer#drawLayer");
            i(com.airbnb.lottie.d.U(this.rQ));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.pu.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.U("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.rI, 31);
        com.airbnb.lottie.d.U("Layer#saveLayer");
        d(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.U("Layer#drawLayer");
        if (eK()) {
            a(canvas, this.matrix);
        }
        if (eI()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.rL, 19);
            com.airbnb.lottie.d.U("Layer#saveLayer");
            d(canvas);
            this.rU.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.U("Layer#restoreLayer");
            com.airbnb.lottie.d.U("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.U("Layer#restoreLayer");
        i(com.airbnb.lottie.d.U(this.rQ));
    }

    private void i(float f) {
        this.nh.cU().getPerformanceTracker().b(this.rS.getName(), f);
    }

    private void d(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.rM);
        com.airbnb.lottie.d.U("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.rN.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (eK()) {
            int size = this.rT.dv().size();
            for (int i = 0; i < size; i++) {
                this.oy.set(this.rT.dw().get(i).getValue());
                this.oy.transform(matrix);
                switch (this.rT.dv().get(i).eo()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.oy.computeBounds(this.rP, false);
                        if (i == 0) {
                            this.rN.set(this.rP);
                        } else {
                            this.rN.set(Math.min(this.rN.left, this.rP.left), Math.min(this.rN.top, this.rP.top), Math.max(this.rN.right, this.rP.right), Math.max(this.rN.bottom, this.rP.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.rN.left), Math.max(rectF.top, this.rN.top), Math.min(rectF.right, this.rN.right), Math.min(rectF.bottom, this.rN.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (eI() && this.rS.eR() != Layer.MatteType.Invert) {
            this.rU.a(this.rO, matrix);
            rectF.set(Math.max(rectF.left, this.rO.left), Math.max(rectF.top, this.rO.top), Math.min(rectF.right, this.rO.right), Math.min(rectF.bottom, this.rO.bottom));
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
            paint = this.rK;
        } else {
            paint = this.rJ;
        }
        int size = this.rT.dv().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.rT.dv().get(i).eo() != maskMode) {
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
                if (this.rT.dv().get(i2).eo() == maskMode) {
                    this.oy.set(this.rT.dw().get(i2).getValue());
                    this.oy.transform(matrix);
                    int alpha = this.rI.getAlpha();
                    this.rI.setAlpha((int) (this.rT.dx().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.oy, this.rI);
                    this.rI.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.U("Layer#restoreLayer");
            com.airbnb.lottie.d.U("Layer#drawMask");
        }
    }

    boolean eK() {
        return (this.rT == null || this.rT.dw().isEmpty()) ? false : true;
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
        this.pu.setProgress(f);
        if (this.rS.eM() != 0.0f) {
            f /= this.rS.eM();
        }
        if (this.rU != null) {
            this.rU.setProgress(this.rU.rS.eM() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.rX.size()) {
                this.rX.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void eL() {
        if (this.rW == null) {
            if (this.rV == null) {
                this.rW = Collections.emptyList();
                return;
            }
            this.rW = new ArrayList();
            for (a aVar = this.rV; aVar != null; aVar = aVar.rV) {
                this.rW.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.rS.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
