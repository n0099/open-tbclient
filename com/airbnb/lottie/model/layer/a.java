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
    final com.airbnb.lottie.f nc;
    final p po;
    private final String rN;
    final Layer rP;
    @Nullable
    private com.airbnb.lottie.a.b.g rQ;
    @Nullable
    private a rR;
    @Nullable
    private a rS;
    private List<a> rT;
    private final Path ot = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint rF = new Paint(1);
    private final Paint rG = new Paint(1);
    private final Paint rH = new Paint(1);
    private final Paint rI = new Paint(1);
    private final Paint rJ = new Paint();
    private final RectF rect = new RectF();
    private final RectF rK = new RectF();
    private final RectF rL = new RectF();
    private final RectF rM = new RectF();
    final Matrix rO = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> rU = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.eO()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.W(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.cK());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.eO());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.nc = fVar;
        this.rP = layer;
        this.rN = layer.getName() + "#draw";
        this.rJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.rG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.rH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.eP() == Layer.MatteType.Invert) {
            this.rI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.rI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.po = layer.ey().dX();
        this.po.a((a.InterfaceC0007a) this);
        if (layer.dt() != null && !layer.dt().isEmpty()) {
            this.rQ = new com.airbnb.lottie.a.b.g(layer.dt());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.rQ.du()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.rQ.dv()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        eH();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void dc() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer eF() {
        return this.rP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.rR = aVar;
    }

    boolean eG() {
        return this.rR != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.rS = aVar;
    }

    private void eH() {
        if (!this.rP.eL().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.rP.eL());
            cVar.dp();
            cVar.b(new a.InterfaceC0007a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
                public void dc() {
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
        this.nc.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.rU.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.rO.set(matrix);
        this.rO.preConcat(this.po.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.rN);
        if (!this.visible) {
            com.airbnb.lottie.d.U(this.rN);
            return;
        }
        eJ();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.rT.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.rT.get(size).po.getMatrix());
        }
        com.airbnb.lottie.d.U("Layer#parentMatrix");
        int intValue = (int) (((this.po.dx().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!eG() && !eI()) {
            this.matrix.preConcat(this.po.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.U("Layer#drawLayer");
            i(com.airbnb.lottie.d.U(this.rN));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.po.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.U("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.rF, 31);
        com.airbnb.lottie.d.U("Layer#saveLayer");
        d(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.U("Layer#drawLayer");
        if (eI()) {
            a(canvas, this.matrix);
        }
        if (eG()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.rI, 19);
            com.airbnb.lottie.d.U("Layer#saveLayer");
            d(canvas);
            this.rR.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.U("Layer#restoreLayer");
            com.airbnb.lottie.d.U("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.U("Layer#restoreLayer");
        i(com.airbnb.lottie.d.U(this.rN));
    }

    private void i(float f) {
        this.nc.cS().getPerformanceTracker().b(this.rP.getName(), f);
    }

    private void d(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.rJ);
        com.airbnb.lottie.d.U("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.rK.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (eI()) {
            int size = this.rQ.dt().size();
            for (int i = 0; i < size; i++) {
                this.ot.set(this.rQ.du().get(i).getValue());
                this.ot.transform(matrix);
                switch (this.rQ.dt().get(i).em()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.ot.computeBounds(this.rM, false);
                        if (i == 0) {
                            this.rK.set(this.rM);
                        } else {
                            this.rK.set(Math.min(this.rK.left, this.rM.left), Math.min(this.rK.top, this.rM.top), Math.max(this.rK.right, this.rM.right), Math.max(this.rK.bottom, this.rM.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.rK.left), Math.max(rectF.top, this.rK.top), Math.min(rectF.right, this.rK.right), Math.min(rectF.bottom, this.rK.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (eG() && this.rP.eP() != Layer.MatteType.Invert) {
            this.rR.a(this.rL, matrix);
            rectF.set(Math.max(rectF.left, this.rL.left), Math.max(rectF.top, this.rL.top), Math.min(rectF.right, this.rL.right), Math.min(rectF.bottom, this.rL.bottom));
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
            paint = this.rH;
        } else {
            paint = this.rG;
        }
        int size = this.rQ.dt().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.rQ.dt().get(i).em() != maskMode) {
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
                if (this.rQ.dt().get(i2).em() == maskMode) {
                    this.ot.set(this.rQ.du().get(i2).getValue());
                    this.ot.transform(matrix);
                    int alpha = this.rF.getAlpha();
                    this.rF.setAlpha((int) (this.rQ.dv().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.ot, this.rF);
                    this.rF.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.U("Layer#restoreLayer");
            com.airbnb.lottie.d.U("Layer#drawMask");
        }
    }

    boolean eI() {
        return (this.rQ == null || this.rQ.du().isEmpty()) ? false : true;
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
        this.po.setProgress(f);
        if (this.rP.eK() != 0.0f) {
            f /= this.rP.eK();
        }
        if (this.rR != null) {
            this.rR.setProgress(this.rR.rP.eK() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.rU.size()) {
                this.rU.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void eJ() {
        if (this.rT == null) {
            if (this.rS == null) {
                this.rT = Collections.emptyList();
                return;
            }
            this.rT = new ArrayList();
            for (a aVar = this.rS; aVar != null; aVar = aVar.rS) {
                this.rT.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.rP.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
