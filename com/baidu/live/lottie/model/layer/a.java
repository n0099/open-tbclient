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
/* loaded from: classes10.dex */
public abstract class a implements com.baidu.live.lottie.a.a.d, a.InterfaceC0194a, com.baidu.live.lottie.model.f {
    private List<a> GG;
    private final String Gy;
    final o btZ;
    final Layer bvo;
    @Nullable
    private com.baidu.live.lottie.a.b.g bvp;
    @Nullable
    private a bvq;
    @Nullable
    private a bvr;
    final h lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint Gq = new Paint(1);
    private final Paint Gr = new Paint(1);
    private final Paint Gs = new Paint(1);
    private final Paint Gt = new Paint(1);
    private final Paint Gu = new Paint();
    private final RectF rect = new RectF();
    private final RectF Gv = new RectF();
    private final RectF Gw = new RectF();
    private final RectF Gx = new RectF();
    final Matrix Gz = new Matrix();
    private final List<com.baidu.live.lottie.a.b.a<?, ?>> GH = new ArrayList();
    private boolean visible = true;

    abstract void d(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, h hVar, com.baidu.live.lottie.e eVar) {
        switch (layer.QA()) {
            case Shape:
                return new e(hVar, layer);
            case PreComp:
                return new b(hVar, layer, eVar.bd(layer.getRefId()), eVar);
            case Solid:
                return new f(hVar, layer);
            case Image:
                return new c(hVar, layer);
            case Null:
                return new d(hVar, layer);
            case Text:
                return new g(hVar, layer);
            default:
                com.baidu.live.lottie.d.warn("Unknown layer type " + layer.QA());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(h hVar, Layer layer) {
        this.lottieDrawable = hVar;
        this.bvo = layer;
        this.Gy = layer.getName() + "#draw";
        this.Gu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Gr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Gs.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.QB() == Layer.MatteType.Invert) {
            this.Gt.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Gt.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.btZ = layer.Qu().PY();
        this.btZ.a((a.InterfaceC0194a) this);
        if (layer.iM() != null && !layer.iM().isEmpty()) {
            this.bvp = new com.baidu.live.lottie.a.b.g(layer.iM());
            for (com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.h, Path> aVar : this.bvp.iN()) {
                aVar.b(this);
            }
            for (com.baidu.live.lottie.a.b.a<Integer, Integer> aVar2 : this.bvp.iO()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        jU();
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
    public void is() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer Qz() {
        return this.bvo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.bvq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jT() {
        return this.bvq != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.bvr = aVar;
    }

    private void jU() {
        if (!this.bvo.jZ().isEmpty()) {
            final com.baidu.live.lottie.a.b.c cVar = new com.baidu.live.lottie.a.b.c(this.bvo.jZ());
            cVar.iG();
            cVar.b(new a.InterfaceC0194a() { // from class: com.baidu.live.lottie.model.layer.a.1
                @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
                public void is() {
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
        this.GH.add(aVar);
    }

    @Override // com.baidu.live.lottie.a.a.d
    @CallSuper
    public void d(RectF rectF, Matrix matrix) {
        this.Gz.set(matrix);
        this.Gz.preConcat(this.btZ.getMatrix());
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection(this.Gy);
        if (!this.visible) {
            com.baidu.live.lottie.d.bb(this.Gy);
            return;
        }
        jW();
        com.baidu.live.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.GG.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.GG.get(size).btZ.getMatrix());
        }
        com.baidu.live.lottie.d.bb("Layer#parentMatrix");
        int intValue = (int) (((this.btZ.PK().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!jT() && !jV()) {
            this.matrix.preConcat(this.btZ.getMatrix());
            com.baidu.live.lottie.d.beginSection("Layer#drawLayer");
            d(canvas, this.matrix, intValue);
            com.baidu.live.lottie.d.bb("Layer#drawLayer");
            i(com.baidu.live.lottie.d.bb(this.Gy));
            return;
        }
        com.baidu.live.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        d(this.rect, this.matrix);
        f(this.rect, this.matrix);
        this.matrix.preConcat(this.btZ.getMatrix());
        e(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.baidu.live.lottie.d.bb("Layer#computeBounds");
        com.baidu.live.lottie.d.beginSection("Layer#saveLayer");
        b(canvas, this.rect, this.Gq, true);
        com.baidu.live.lottie.d.bb("Layer#saveLayer");
        f(canvas);
        com.baidu.live.lottie.d.beginSection("Layer#drawLayer");
        d(canvas, this.matrix, intValue);
        com.baidu.live.lottie.d.bb("Layer#drawLayer");
        if (jV()) {
            b(canvas, this.matrix);
        }
        if (jT()) {
            com.baidu.live.lottie.d.beginSection("Layer#drawMatte");
            com.baidu.live.lottie.d.beginSection("Layer#saveLayer");
            b(canvas, this.rect, this.Gt, false);
            com.baidu.live.lottie.d.bb("Layer#saveLayer");
            f(canvas);
            this.bvq.c(canvas, matrix, intValue);
            com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.baidu.live.lottie.d.bb("Layer#restoreLayer");
            com.baidu.live.lottie.d.bb("Layer#drawMatte");
        }
        com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.baidu.live.lottie.d.bb("Layer#restoreLayer");
        i(com.baidu.live.lottie.d.bb(this.Gy));
    }

    private void i(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().c(this.bvo.getName(), f);
    }

    private void f(Canvas canvas) {
        com.baidu.live.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Gu);
        com.baidu.live.lottie.d.bb("Layer#clearLayer");
    }

    private void e(RectF rectF, Matrix matrix) {
        this.Gv.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (jV()) {
            int size = this.bvp.iM().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.bvp.iN().get(i).getValue());
                this.path.transform(matrix);
                switch (this.bvp.iM().get(i).Qi()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.Gx, false);
                        if (i == 0) {
                            this.Gv.set(this.Gx);
                        } else {
                            this.Gv.set(Math.min(this.Gv.left, this.Gx.left), Math.min(this.Gv.top, this.Gx.top), Math.max(this.Gv.right, this.Gx.right), Math.max(this.Gv.bottom, this.Gx.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Gv.left), Math.max(rectF.top, this.Gv.top), Math.min(rectF.right, this.Gv.right), Math.min(rectF.bottom, this.Gv.bottom));
        }
    }

    private void f(RectF rectF, Matrix matrix) {
        if (jT() && this.bvo.QB() != Layer.MatteType.Invert) {
            this.bvq.d(this.Gw, matrix);
            rectF.set(Math.max(rectF.left, this.Gw.left), Math.max(rectF.top, this.Gw.top), Math.min(rectF.right, this.Gw.right), Math.min(rectF.bottom, this.Gw.bottom));
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
                paint = this.Gs;
                break;
            default:
                paint = this.Gr;
                break;
        }
        int size = this.bvp.iM().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.bvp.iM().get(i).Qi() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.baidu.live.lottie.d.beginSection("Layer#drawMask");
            com.baidu.live.lottie.d.beginSection("Layer#saveLayer");
            b(canvas, this.rect, paint, false);
            com.baidu.live.lottie.d.bb("Layer#saveLayer");
            f(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bvp.iM().get(i2).Qi() == maskMode) {
                    this.path.set(this.bvp.iN().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Gq.getAlpha();
                    this.Gq.setAlpha((int) (this.bvp.iO().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.Gq);
                    this.Gq.setAlpha(alpha);
                }
            }
            com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.baidu.live.lottie.d.bb("Layer#restoreLayer");
            com.baidu.live.lottie.d.bb("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jV() {
        return (this.bvp == null || this.bvp.iN().isEmpty()) ? false : true;
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
        this.btZ.setProgress(f);
        if (this.bvp != null) {
            for (int i = 0; i < this.bvp.iN().size(); i++) {
                this.bvp.iN().get(i).setProgress(f);
            }
        }
        if (this.bvo.jX() != 0.0f) {
            f /= this.bvo.jX();
        }
        if (this.bvq != null) {
            this.bvq.setProgress(this.bvq.bvo.jX() * f);
        }
        for (int i2 = 0; i2 < this.GH.size(); i2++) {
            this.GH.get(i2).setProgress(f);
        }
    }

    private void jW() {
        if (this.GG == null) {
            if (this.bvr == null) {
                this.GG = Collections.emptyList();
                return;
            }
            this.GG = new ArrayList();
            for (a aVar = this.bvr; aVar != null; aVar = aVar.bvr) {
                this.GG.add(aVar);
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.bvo.getName();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<com.baidu.live.lottie.a.a.b> list, List<com.baidu.live.lottie.a.a.b> list2) {
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.hZ(getName());
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
        this.btZ.b(t, cVar);
    }
}
