package com.baidu.live.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.a.b.o;
import com.baidu.live.lottie.h;
import com.baidu.live.lottie.model.content.Mask;
import com.baidu.live.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class a implements com.baidu.live.lottie.a.a.d, a.InterfaceC0192a, com.baidu.live.lottie.model.f {
    private final String HS;
    private List<a> Ia;
    final o bup;
    final Layer bvD;
    @Nullable
    private com.baidu.live.lottie.a.b.g bvE;
    @Nullable
    private a bvF;
    @Nullable
    private a bvG;
    final h lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint HK = new Paint(1);
    private final Paint HL = new Paint(1);
    private final Paint HM = new Paint(1);
    private final Paint HN = new Paint(1);
    private final Paint HO = new Paint();
    private final RectF rect = new RectF();
    private final RectF HP = new RectF();
    private final RectF HQ = new RectF();
    private final RectF HR = new RectF();
    final Matrix HU = new Matrix();
    private final List<com.baidu.live.lottie.a.b.a<?, ?>> Ib = new ArrayList();
    private boolean visible = true;

    abstract void d(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, h hVar, com.baidu.live.lottie.e eVar) {
        switch (layer.Og()) {
            case Shape:
                return new e(hVar, layer);
            case PreComp:
                return new b(hVar, layer, eVar.bh(layer.getRefId()), eVar);
            case Solid:
                return new f(hVar, layer);
            case Image:
                return new c(hVar, layer);
            case Null:
                return new d(hVar, layer);
            case Text:
                return new g(hVar, layer);
            default:
                com.baidu.live.lottie.d.warn("Unknown layer type " + layer.Og());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(h hVar, Layer layer) {
        this.lottieDrawable = hVar;
        this.bvD = layer;
        this.HS = layer.getName() + "#draw";
        this.HO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.HL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.HM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.Oh() == Layer.MatteType.Invert) {
            this.HN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.HN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.bup = layer.Oa().NE();
        this.bup.a((a.InterfaceC0192a) this);
        if (layer.iL() != null && !layer.iL().isEmpty()) {
            this.bvE = new com.baidu.live.lottie.a.b.g(layer.iL());
            for (com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.h, Path> aVar : this.bvE.iM()) {
                aVar.b(this);
            }
            for (com.baidu.live.lottie.a.b.a<Integer, Integer> aVar2 : this.bvE.iN()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        jT();
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0192a
    public void ir() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer Of() {
        return this.bvD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.bvF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jS() {
        return this.bvF != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.bvG = aVar;
    }

    private void jT() {
        if (!this.bvD.jY().isEmpty()) {
            final com.baidu.live.lottie.a.b.c cVar = new com.baidu.live.lottie.a.b.c(this.bvD.jY());
            cVar.iF();
            cVar.b(new a.InterfaceC0192a() { // from class: com.baidu.live.lottie.model.layer.a.1
                @Override // com.baidu.live.lottie.a.b.a.InterfaceC0192a
                public void ir() {
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
        this.lottieDrawable.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    private void b(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a(com.baidu.live.lottie.a.b.a<?, ?> aVar) {
        this.Ib.add(aVar);
    }

    @Override // com.baidu.live.lottie.a.a.d
    @CallSuper
    public void d(RectF rectF, Matrix matrix) {
        this.HU.set(matrix);
        this.HU.preConcat(this.bup.getMatrix());
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection(this.HS);
        if (!this.visible) {
            com.baidu.live.lottie.d.bf(this.HS);
            return;
        }
        jV();
        com.baidu.live.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.Ia.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.Ia.get(size).bup.getMatrix());
        }
        com.baidu.live.lottie.d.bf("Layer#parentMatrix");
        int intValue = (int) (((this.bup.Nq().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!jS() && !jU()) {
            this.matrix.preConcat(this.bup.getMatrix());
            com.baidu.live.lottie.d.beginSection("Layer#drawLayer");
            d(canvas, this.matrix, intValue);
            com.baidu.live.lottie.d.bf("Layer#drawLayer");
            m(com.baidu.live.lottie.d.bf(this.HS));
            return;
        }
        com.baidu.live.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        d(this.rect, this.matrix);
        f(this.rect, this.matrix);
        this.matrix.preConcat(this.bup.getMatrix());
        e(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.baidu.live.lottie.d.bf("Layer#computeBounds");
        com.baidu.live.lottie.d.beginSection("Layer#saveLayer");
        b(canvas, this.rect, this.HK, true);
        com.baidu.live.lottie.d.bf("Layer#saveLayer");
        f(canvas);
        com.baidu.live.lottie.d.beginSection("Layer#drawLayer");
        d(canvas, this.matrix, intValue);
        com.baidu.live.lottie.d.bf("Layer#drawLayer");
        if (jU()) {
            b(canvas, this.matrix);
        }
        if (jS()) {
            com.baidu.live.lottie.d.beginSection("Layer#drawMatte");
            com.baidu.live.lottie.d.beginSection("Layer#saveLayer");
            b(canvas, this.rect, this.HN, false);
            com.baidu.live.lottie.d.bf("Layer#saveLayer");
            f(canvas);
            this.bvF.c(canvas, matrix, intValue);
            com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.baidu.live.lottie.d.bf("Layer#restoreLayer");
            com.baidu.live.lottie.d.bf("Layer#drawMatte");
        }
        com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.baidu.live.lottie.d.bf("Layer#restoreLayer");
        m(com.baidu.live.lottie.d.bf(this.HS));
    }

    private void m(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().c(this.bvD.getName(), f);
    }

    private void f(Canvas canvas) {
        com.baidu.live.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.HO);
        com.baidu.live.lottie.d.bf("Layer#clearLayer");
    }

    private void e(RectF rectF, Matrix matrix) {
        this.HP.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (jU()) {
            int size = this.bvE.iL().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.bvE.iM().get(i).getValue());
                this.path.transform(matrix);
                switch (this.bvE.iL().get(i).NO()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.HR, false);
                        if (i == 0) {
                            this.HP.set(this.HR);
                        } else {
                            this.HP.set(Math.min(this.HP.left, this.HR.left), Math.min(this.HP.top, this.HR.top), Math.max(this.HP.right, this.HR.right), Math.max(this.HP.bottom, this.HR.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.HP.left), Math.max(rectF.top, this.HP.top), Math.min(rectF.right, this.HP.right), Math.min(rectF.bottom, this.HP.bottom));
        }
    }

    private void f(RectF rectF, Matrix matrix) {
        if (jS() && this.bvD.Oh() != Layer.MatteType.Invert) {
            this.bvF.d(this.HQ, matrix);
            rectF.set(Math.max(rectF.left, this.HQ.left), Math.max(rectF.top, this.HQ.top), Math.min(rectF.right, this.HQ.right), Math.min(rectF.bottom, this.HQ.bottom));
        }
    }

    private void b(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z;
        switch (maskMode) {
            case MaskModeSubtract:
                paint = this.HM;
                break;
            default:
                paint = this.HL;
                break;
        }
        int size = this.bvE.iL().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.bvE.iL().get(i).NO() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.baidu.live.lottie.d.beginSection("Layer#drawMask");
            com.baidu.live.lottie.d.beginSection("Layer#saveLayer");
            b(canvas, this.rect, paint, false);
            com.baidu.live.lottie.d.bf("Layer#saveLayer");
            f(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bvE.iL().get(i2).NO() == maskMode) {
                    this.path.set(this.bvE.iM().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.HK.getAlpha();
                    this.HK.setAlpha((int) (this.bvE.iN().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.HK);
                    this.HK.setAlpha(alpha);
                }
            }
            com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.baidu.live.lottie.d.bf("Layer#restoreLayer");
            com.baidu.live.lottie.d.bf("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jU() {
        return (this.bvE == null || this.bvE.iM().isEmpty()) ? false : true;
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
        this.bup.setProgress(f);
        if (this.bvE != null) {
            for (int i = 0; i < this.bvE.iM().size(); i++) {
                this.bvE.iM().get(i).setProgress(f);
            }
        }
        if (this.bvD.jW() != 0.0f) {
            f /= this.bvD.jW();
        }
        if (this.bvF != null) {
            this.bvF.setProgress(this.bvF.bvD.jW() * f);
        }
        for (int i2 = 0; i2 < this.Ib.size(); i2++) {
            this.Ib.get(i2).setProgress(f);
        }
    }

    private void jV() {
        if (this.Ia == null) {
            if (this.bvG == null) {
                this.Ia = Collections.emptyList();
                return;
            }
            this.Ia = new ArrayList();
            for (a aVar = this.bvG; aVar != null; aVar = aVar.bvG) {
                this.Ia.add(aVar);
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.bvD.getName();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void b(List<com.baidu.live.lottie.a.a.b> list, List<com.baidu.live.lottie.a.a.b> list2) {
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.ht(getName());
                if (eVar.j(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.k(getName(), i)) {
                b(eVar, eVar.i(getName(), i) + i, list, eVar2);
            }
        }
    }

    void b(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
    }

    @Override // com.baidu.live.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        this.bup.b(t, cVar);
    }
}
