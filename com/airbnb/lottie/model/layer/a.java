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
    final com.airbnb.lottie.f jQ;
    final p lY;
    private final String oD;
    final Layer oF;
    @Nullable
    private com.airbnb.lottie.a.b.g oG;
    @Nullable
    private a oH;
    @Nullable
    private a oI;
    private List<a> oJ;
    private final Path lg = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint ov = new Paint(1);
    private final Paint ow = new Paint(1);
    private final Paint ox = new Paint(1);
    private final Paint oy = new Paint(1);
    private final Paint oz = new Paint();
    private final RectF rect = new RectF();
    private final RectF oA = new RectF();
    private final RectF oB = new RectF();
    private final RectF oC = new RectF();
    final Matrix oE = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> oK = new ArrayList();
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
        this.jQ = fVar;
        this.oF = layer;
        this.oD = layer.getName() + "#draw";
        this.oz.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ow.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.ox.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.ds() == Layer.MatteType.Invert) {
            this.oy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.oy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.lY = layer.db().cA();
        this.lY.a((a.InterfaceC0006a) this);
        if (layer.bW() != null && !layer.bW().isEmpty()) {
            this.oG = new com.airbnb.lottie.a.b.g(layer.bW());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.oG.bX()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.oG.bY()) {
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
        return this.oF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.oH = aVar;
    }

    boolean dj() {
        return this.oH != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.oI = aVar;
    }

    private void dk() {
        if (!this.oF.m6do().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.oF.m6do());
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
        this.jQ.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.oK.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.oE.set(matrix);
        this.oE.preConcat(this.lY.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.oD);
        if (!this.visible) {
            com.airbnb.lottie.d.D(this.oD);
            return;
        }
        dm();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.oJ.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.oJ.get(size).lY.getMatrix());
        }
        com.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.lY.ca().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dj() && !dl()) {
            this.matrix.preConcat(this.lY.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.airbnb.lottie.d.D(this.oD));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.lY.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.D("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.ov, 31);
        com.airbnb.lottie.d.D("Layer#saveLayer");
        e(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.D("Layer#drawLayer");
        if (dl()) {
            a(canvas, this.matrix);
        }
        if (dj()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.oy, 19);
            com.airbnb.lottie.d.D("Layer#saveLayer");
            e(canvas);
            this.oH.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.airbnb.lottie.d.D(this.oD));
    }

    private void i(float f) {
        this.jQ.bv().getPerformanceTracker().b(this.oF.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.oz);
        com.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.oA.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dl()) {
            int size = this.oG.bW().size();
            for (int i = 0; i < size; i++) {
                this.lg.set(this.oG.bX().get(i).getValue());
                this.lg.transform(matrix);
                switch (this.oG.bW().get(i).cP()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.lg.computeBounds(this.oC, false);
                        if (i == 0) {
                            this.oA.set(this.oC);
                        } else {
                            this.oA.set(Math.min(this.oA.left, this.oC.left), Math.min(this.oA.top, this.oC.top), Math.max(this.oA.right, this.oC.right), Math.max(this.oA.bottom, this.oC.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.oA.left), Math.max(rectF.top, this.oA.top), Math.min(rectF.right, this.oA.right), Math.min(rectF.bottom, this.oA.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dj() && this.oF.ds() != Layer.MatteType.Invert) {
            this.oH.a(this.oB, matrix);
            rectF.set(Math.max(rectF.left, this.oB.left), Math.max(rectF.top, this.oB.top), Math.min(rectF.right, this.oB.right), Math.min(rectF.bottom, this.oB.bottom));
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
            paint = this.ox;
        } else {
            paint = this.ow;
        }
        int size = this.oG.bW().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.oG.bW().get(i).cP() != maskMode) {
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
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.oG.bW().get(i2).cP() == maskMode) {
                    this.lg.set(this.oG.bX().get(i2).getValue());
                    this.lg.transform(matrix);
                    int alpha = this.ov.getAlpha();
                    this.ov.setAlpha((int) (this.oG.bY().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.lg, this.ov);
                    this.ov.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.D("Layer#restoreLayer");
            com.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    boolean dl() {
        return (this.oG == null || this.oG.bX().isEmpty()) ? false : true;
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
        this.lY.setProgress(f);
        if (this.oF.dn() != 0.0f) {
            f /= this.oF.dn();
        }
        if (this.oH != null) {
            this.oH.setProgress(this.oH.oF.dn() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oK.size()) {
                this.oK.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void dm() {
        if (this.oJ == null) {
            if (this.oI == null) {
                this.oJ = Collections.emptyList();
                return;
            }
            this.oJ = new ArrayList();
            for (a aVar = this.oI; aVar != null; aVar = aVar.oI) {
                this.oJ.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.oF.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
