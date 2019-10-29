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
    final com.airbnb.lottie.f dh;
    final p fj;
    private final String hJ;
    final Layer hL;
    @Nullable
    private com.airbnb.lottie.a.b.g hM;
    @Nullable
    private a hN;
    @Nullable
    private a hO;
    private List<a> hP;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint hB = new Paint(1);
    private final Paint hC = new Paint(1);
    private final Paint hD = new Paint(1);
    private final Paint hE = new Paint(1);
    private final Paint hF = new Paint();
    private final RectF rect = new RectF();
    private final RectF hG = new RectF();
    private final RectF hH = new RectF();
    private final RectF hI = new RectF();
    final Matrix hK = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> hQ = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.di()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.F(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.bb());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.di());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.dh = fVar;
        this.hL = layer;
        this.hJ = layer.getName() + "#draw";
        this.hF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.hD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dj() == Layer.MatteType.Invert) {
            this.hE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.hE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.fj = layer.cS().cq();
        this.fj.a((a.InterfaceC0007a) this);
        if (layer.bL() != null && !layer.bL().isEmpty()) {
            this.hM = new com.airbnb.lottie.a.b.g(layer.bL());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.hM.bM()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.hM.bN()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        db();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer cZ() {
        return this.hL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.hN = aVar;
    }

    boolean da() {
        return this.hN != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.hO = aVar;
    }

    private void db() {
        if (!this.hL.df().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.hL.df());
            cVar.bH();
            cVar.b(new a.InterfaceC0007a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
                public void bt() {
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
        this.dh.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.hQ.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.hK.set(matrix);
        this.hK.preConcat(this.fj.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.hJ);
        if (!this.visible) {
            com.airbnb.lottie.d.D(this.hJ);
            return;
        }
        dd();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.hP.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.hP.get(size).fj.getMatrix());
        }
        com.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.fj.bP().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!da() && !dc()) {
            this.matrix.preConcat(this.fj.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.airbnb.lottie.d.D(this.hJ));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.fj.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.D("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.hB, 31);
        com.airbnb.lottie.d.D("Layer#saveLayer");
        d(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.D("Layer#drawLayer");
        if (dc()) {
            a(canvas, this.matrix);
        }
        if (da()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.hE, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            this.hN.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.airbnb.lottie.d.D(this.hJ));
    }

    private void i(float f) {
        this.dh.bj().getPerformanceTracker().b(this.hL.getName(), f);
    }

    private void d(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.hF);
        com.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.hG.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dc()) {
            int size = this.hM.bL().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.hM.bM().get(i).getValue());
                this.path.transform(matrix);
                switch (this.hM.bL().get(i).cG()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.path.computeBounds(this.hI, false);
                        if (i == 0) {
                            this.hG.set(this.hI);
                        } else {
                            this.hG.set(Math.min(this.hG.left, this.hI.left), Math.min(this.hG.top, this.hI.top), Math.max(this.hG.right, this.hI.right), Math.max(this.hG.bottom, this.hI.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.hG.left), Math.max(rectF.top, this.hG.top), Math.min(rectF.right, this.hG.right), Math.min(rectF.bottom, this.hG.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (da() && this.hL.dj() != Layer.MatteType.Invert) {
            this.hN.a(this.hH, matrix);
            rectF.set(Math.max(rectF.left, this.hH.left), Math.max(rectF.top, this.hH.top), Math.min(rectF.right, this.hH.right), Math.min(rectF.bottom, this.hH.bottom));
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
            paint = this.hD;
        } else {
            paint = this.hC;
        }
        int size = this.hM.bL().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.hM.bL().get(i).cG() != maskMode) {
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
                if (this.hM.bL().get(i2).cG() == maskMode) {
                    this.path.set(this.hM.bM().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.hB.getAlpha();
                    this.hB.setAlpha((int) (this.hM.bN().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.hB);
                    this.hB.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    boolean dc() {
        return (this.hM == null || this.hM.bM().isEmpty()) ? false : true;
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
        this.fj.setProgress(f);
        if (this.hL.de() != 0.0f) {
            f /= this.hL.de();
        }
        if (this.hN != null) {
            this.hN.setProgress(this.hN.hL.de() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hQ.size()) {
                this.hQ.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void dd() {
        if (this.hP == null) {
            if (this.hO == null) {
                this.hP = Collections.emptyList();
                return;
            }
            this.hP = new ArrayList();
            for (a aVar = this.hO; aVar != null; aVar = aVar.hO) {
                this.hP.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.hL.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
