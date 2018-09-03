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
    final com.airbnb.lottie.f jR;
    final p lZ;
    private final String oE;
    final Layer oG;
    @Nullable
    private com.airbnb.lottie.a.b.g oH;
    @Nullable
    private a oI;
    @Nullable
    private a oJ;
    private List<a> oK;
    private final Path lh = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint ow = new Paint(1);
    private final Paint ox = new Paint(1);
    private final Paint oy = new Paint(1);
    private final Paint oz = new Paint(1);
    private final Paint oA = new Paint();
    private final RectF rect = new RectF();
    private final RectF oB = new RectF();
    private final RectF oC = new RectF();
    private final RectF oD = new RectF();
    final Matrix oF = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> oL = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.dr()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.F(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.bn());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.dr());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.jR = fVar;
        this.oG = layer;
        this.oE = layer.getName() + "#draw";
        this.oA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ox.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.oy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.ds() == Layer.MatteType.Invert) {
            this.oz.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.oz.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.lZ = layer.db().cA();
        this.lZ.a((a.InterfaceC0006a) this);
        if (layer.bW() != null && !layer.bW().isEmpty()) {
            this.oH = new com.airbnb.lottie.a.b.g(layer.bW());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.oH.bX()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.oH.bY()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        dk();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer di() {
        return this.oG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.oI = aVar;
    }

    boolean dj() {
        return this.oI != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.oJ = aVar;
    }

    private void dk() {
        if (!this.oG.m6do().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.oG.m6do());
            cVar.bS();
            cVar.b(new a.InterfaceC0006a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
                public void bF() {
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
        this.jR.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.oL.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.oF.set(matrix);
        this.oF.preConcat(this.lZ.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.oE);
        if (!this.visible) {
            com.airbnb.lottie.d.D(this.oE);
            return;
        }
        dm();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.oK.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.oK.get(size).lZ.getMatrix());
        }
        com.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.lZ.ca().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dj() && !dl()) {
            this.matrix.preConcat(this.lZ.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.airbnb.lottie.d.D(this.oE));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.lZ.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.D("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.ow, 31);
        com.airbnb.lottie.d.D("Layer#saveLayer");
        d(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.D("Layer#drawLayer");
        if (dl()) {
            a(canvas, this.matrix);
        }
        if (dj()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.oz, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            this.oI.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.airbnb.lottie.d.D(this.oE));
    }

    private void i(float f) {
        this.jR.bv().getPerformanceTracker().b(this.oG.getName(), f);
    }

    private void d(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.oA);
        com.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.oB.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dl()) {
            int size = this.oH.bW().size();
            for (int i = 0; i < size; i++) {
                this.lh.set(this.oH.bX().get(i).getValue());
                this.lh.transform(matrix);
                switch (this.oH.bW().get(i).cP()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.lh.computeBounds(this.oD, false);
                        if (i == 0) {
                            this.oB.set(this.oD);
                        } else {
                            this.oB.set(Math.min(this.oB.left, this.oD.left), Math.min(this.oB.top, this.oD.top), Math.max(this.oB.right, this.oD.right), Math.max(this.oB.bottom, this.oD.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.oB.left), Math.max(rectF.top, this.oB.top), Math.min(rectF.right, this.oB.right), Math.min(rectF.bottom, this.oB.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dj() && this.oG.ds() != Layer.MatteType.Invert) {
            this.oI.a(this.oC, matrix);
            rectF.set(Math.max(rectF.left, this.oC.left), Math.max(rectF.top, this.oC.top), Math.min(rectF.right, this.oC.right), Math.min(rectF.bottom, this.oC.bottom));
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
            paint = this.oy;
        } else {
            paint = this.ox;
        }
        int size = this.oH.bW().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.oH.bW().get(i).cP() != maskMode) {
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
                if (this.oH.bW().get(i2).cP() == maskMode) {
                    this.lh.set(this.oH.bX().get(i2).getValue());
                    this.lh.transform(matrix);
                    int alpha = this.ow.getAlpha();
                    this.ow.setAlpha((int) (this.oH.bY().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.lh, this.ow);
                    this.ow.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    boolean dl() {
        return (this.oH == null || this.oH.bX().isEmpty()) ? false : true;
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
        this.lZ.setProgress(f);
        if (this.oG.dn() != 0.0f) {
            f /= this.oG.dn();
        }
        if (this.oI != null) {
            this.oI.setProgress(this.oI.oG.dn() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oL.size()) {
                this.oL.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void dm() {
        if (this.oK == null) {
            if (this.oJ == null) {
                this.oK = Collections.emptyList();
                return;
            }
            this.oK = new ArrayList();
            for (a aVar = this.oJ; aVar != null; aVar = aVar.oJ) {
                this.oK.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.oG.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
