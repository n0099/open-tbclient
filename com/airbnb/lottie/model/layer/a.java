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
    final com.airbnb.lottie.f mp;
    final p oC;
    private final String rd;
    final Layer rf;
    @Nullable
    private com.airbnb.lottie.a.b.g rg;
    @Nullable
    private a rh;
    @Nullable
    private a ri;
    private List<a> rj;
    private final Path nJ = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint qV = new Paint(1);
    private final Paint qW = new Paint(1);
    private final Paint qX = new Paint(1);
    private final Paint qY = new Paint(1);
    private final Paint qZ = new Paint();
    private final RectF rect = new RectF();
    private final RectF ra = new RectF();
    private final RectF rb = new RectF();
    private final RectF rc = new RectF();
    final Matrix re = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> rk = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.f fVar, com.airbnb.lottie.e eVar) {
        switch (layer.ey()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.W(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.cu());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.ey());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, Layer layer) {
        this.mp = fVar;
        this.rf = layer;
        this.rd = layer.getName() + "#draw";
        this.qZ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.qW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.qX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.ez() == Layer.MatteType.Invert) {
            this.qY.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.qY.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.oC = layer.ei().dH();
        this.oC.a((a.InterfaceC0006a) this);
        if (layer.dd() != null && !layer.dd().isEmpty()) {
            this.rg = new com.airbnb.lottie.a.b.g(layer.dd());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.rg.de()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.rg.df()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        er();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer ep() {
        return this.rf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.rh = aVar;
    }

    boolean eq() {
        return this.rh != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.ri = aVar;
    }

    private void er() {
        if (!this.rf.ev().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.rf.ev());
            cVar.cZ();
            cVar.b(new a.InterfaceC0006a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
                public void cM() {
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
        this.mp.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.rk.add(aVar);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.re.set(matrix);
        this.re.preConcat(this.oC.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.rd);
        if (!this.visible) {
            com.airbnb.lottie.d.U(this.rd);
            return;
        }
        et();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.rj.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.rj.get(size).oC.getMatrix());
        }
        com.airbnb.lottie.d.U("Layer#parentMatrix");
        int intValue = (int) (((this.oC.dh().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!eq() && !es()) {
            this.matrix.preConcat(this.oC.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.U("Layer#drawLayer");
            i(com.airbnb.lottie.d.U(this.rd));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.oC.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.U("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.qV, 31);
        com.airbnb.lottie.d.U("Layer#saveLayer");
        d(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.U("Layer#drawLayer");
        if (es()) {
            a(canvas, this.matrix);
        }
        if (eq()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.qY, 19);
            com.airbnb.lottie.d.U("Layer#saveLayer");
            d(canvas);
            this.rh.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.U("Layer#restoreLayer");
            com.airbnb.lottie.d.U("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.U("Layer#restoreLayer");
        i(com.airbnb.lottie.d.U(this.rd));
    }

    private void i(float f) {
        this.mp.cC().getPerformanceTracker().b(this.rf.getName(), f);
    }

    private void d(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.qZ);
        com.airbnb.lottie.d.U("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.ra.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (es()) {
            int size = this.rg.dd().size();
            for (int i = 0; i < size; i++) {
                this.nJ.set(this.rg.de().get(i).getValue());
                this.nJ.transform(matrix);
                switch (this.rg.dd().get(i).dW()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.nJ.computeBounds(this.rc, false);
                        if (i == 0) {
                            this.ra.set(this.rc);
                        } else {
                            this.ra.set(Math.min(this.ra.left, this.rc.left), Math.min(this.ra.top, this.rc.top), Math.max(this.ra.right, this.rc.right), Math.max(this.ra.bottom, this.rc.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.ra.left), Math.max(rectF.top, this.ra.top), Math.min(rectF.right, this.ra.right), Math.min(rectF.bottom, this.ra.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (eq() && this.rf.ez() != Layer.MatteType.Invert) {
            this.rh.a(this.rb, matrix);
            rectF.set(Math.max(rectF.left, this.rb.left), Math.max(rectF.top, this.rb.top), Math.min(rectF.right, this.rb.right), Math.min(rectF.bottom, this.rb.bottom));
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
            paint = this.qX;
        } else {
            paint = this.qW;
        }
        int size = this.rg.dd().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.rg.dd().get(i).dW() != maskMode) {
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
                if (this.rg.dd().get(i2).dW() == maskMode) {
                    this.nJ.set(this.rg.de().get(i2).getValue());
                    this.nJ.transform(matrix);
                    int alpha = this.qV.getAlpha();
                    this.qV.setAlpha((int) (this.rg.df().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.nJ, this.qV);
                    this.qV.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.U("Layer#restoreLayer");
            com.airbnb.lottie.d.U("Layer#drawMask");
        }
    }

    boolean es() {
        return (this.rg == null || this.rg.de().isEmpty()) ? false : true;
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
        this.oC.setProgress(f);
        if (this.rf.eu() != 0.0f) {
            f /= this.rf.eu();
        }
        if (this.rh != null) {
            this.rh.setProgress(this.rh.rf.eu() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.rk.size()) {
                this.rk.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void et() {
        if (this.rj == null) {
            if (this.ri == null) {
                this.rj = Collections.emptyList();
                return;
            }
            this.rj = new ArrayList();
            for (a aVar = this.ri; aVar != null; aVar = aVar.ri) {
                this.rj.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.rf.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
