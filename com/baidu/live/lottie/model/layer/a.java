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
public abstract class a implements com.baidu.live.lottie.a.a.d, a.InterfaceC0186a, com.baidu.live.lottie.model.f {
    private List<a> GD;
    private final String Gw;
    final o bsN;
    final Layer buc;
    @Nullable
    private com.baidu.live.lottie.a.b.g bud;
    @Nullable
    private a bue;
    @Nullable
    private a bug;
    final h lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint Go = new Paint(1);
    private final Paint Gp = new Paint(1);
    private final Paint Gq = new Paint(1);
    private final Paint Gr = new Paint(1);
    private final Paint Gs = new Paint();
    private final RectF rect = new RectF();
    private final RectF Gt = new RectF();
    private final RectF Gu = new RectF();
    private final RectF Gv = new RectF();
    final Matrix Gx = new Matrix();
    private final List<com.baidu.live.lottie.a.b.a<?, ?>> GF = new ArrayList();
    private boolean visible = true;

    abstract void d(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, h hVar, com.baidu.live.lottie.e eVar) {
        switch (layer.Od()) {
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
                com.baidu.live.lottie.d.warn("Unknown layer type " + layer.Od());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(h hVar, Layer layer) {
        this.lottieDrawable = hVar;
        this.buc = layer;
        this.Gw = layer.getName() + "#draw";
        this.Gs.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Gp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Gq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.Oe() == Layer.MatteType.Invert) {
            this.Gr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Gr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.bsN = layer.NX().NB();
        this.bsN.a((a.InterfaceC0186a) this);
        if (layer.iL() != null && !layer.iL().isEmpty()) {
            this.bud = new com.baidu.live.lottie.a.b.g(layer.iL());
            for (com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.h, Path> aVar : this.bud.iM()) {
                aVar.b(this);
            }
            for (com.baidu.live.lottie.a.b.a<Integer, Integer> aVar2 : this.bud.iN()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        jT();
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0186a
    public void ir() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer Oc() {
        return this.buc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.bue = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jS() {
        return this.bue != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.bug = aVar;
    }

    private void jT() {
        if (!this.buc.jY().isEmpty()) {
            final com.baidu.live.lottie.a.b.c cVar = new com.baidu.live.lottie.a.b.c(this.buc.jY());
            cVar.iF();
            cVar.b(new a.InterfaceC0186a() { // from class: com.baidu.live.lottie.model.layer.a.1
                @Override // com.baidu.live.lottie.a.b.a.InterfaceC0186a
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
        this.GF.add(aVar);
    }

    @Override // com.baidu.live.lottie.a.a.d
    @CallSuper
    public void d(RectF rectF, Matrix matrix) {
        this.Gx.set(matrix);
        this.Gx.preConcat(this.bsN.getMatrix());
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection(this.Gw);
        if (!this.visible) {
            com.baidu.live.lottie.d.bb(this.Gw);
            return;
        }
        jV();
        com.baidu.live.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.GD.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.GD.get(size).bsN.getMatrix());
        }
        com.baidu.live.lottie.d.bb("Layer#parentMatrix");
        int intValue = (int) (((this.bsN.Nn().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!jS() && !jU()) {
            this.matrix.preConcat(this.bsN.getMatrix());
            com.baidu.live.lottie.d.beginSection("Layer#drawLayer");
            d(canvas, this.matrix, intValue);
            com.baidu.live.lottie.d.bb("Layer#drawLayer");
            i(com.baidu.live.lottie.d.bb(this.Gw));
            return;
        }
        com.baidu.live.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        d(this.rect, this.matrix);
        f(this.rect, this.matrix);
        this.matrix.preConcat(this.bsN.getMatrix());
        e(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.baidu.live.lottie.d.bb("Layer#computeBounds");
        com.baidu.live.lottie.d.beginSection("Layer#saveLayer");
        b(canvas, this.rect, this.Go, true);
        com.baidu.live.lottie.d.bb("Layer#saveLayer");
        f(canvas);
        com.baidu.live.lottie.d.beginSection("Layer#drawLayer");
        d(canvas, this.matrix, intValue);
        com.baidu.live.lottie.d.bb("Layer#drawLayer");
        if (jU()) {
            b(canvas, this.matrix);
        }
        if (jS()) {
            com.baidu.live.lottie.d.beginSection("Layer#drawMatte");
            com.baidu.live.lottie.d.beginSection("Layer#saveLayer");
            b(canvas, this.rect, this.Gr, false);
            com.baidu.live.lottie.d.bb("Layer#saveLayer");
            f(canvas);
            this.bue.c(canvas, matrix, intValue);
            com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.baidu.live.lottie.d.bb("Layer#restoreLayer");
            com.baidu.live.lottie.d.bb("Layer#drawMatte");
        }
        com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.baidu.live.lottie.d.bb("Layer#restoreLayer");
        i(com.baidu.live.lottie.d.bb(this.Gw));
    }

    private void i(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().c(this.buc.getName(), f);
    }

    private void f(Canvas canvas) {
        com.baidu.live.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Gs);
        com.baidu.live.lottie.d.bb("Layer#clearLayer");
    }

    private void e(RectF rectF, Matrix matrix) {
        this.Gt.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (jU()) {
            int size = this.bud.iL().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.bud.iM().get(i).getValue());
                this.path.transform(matrix);
                switch (this.bud.iL().get(i).NL()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.Gv, false);
                        if (i == 0) {
                            this.Gt.set(this.Gv);
                        } else {
                            this.Gt.set(Math.min(this.Gt.left, this.Gv.left), Math.min(this.Gt.top, this.Gv.top), Math.max(this.Gt.right, this.Gv.right), Math.max(this.Gt.bottom, this.Gv.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Gt.left), Math.max(rectF.top, this.Gt.top), Math.min(rectF.right, this.Gt.right), Math.min(rectF.bottom, this.Gt.bottom));
        }
    }

    private void f(RectF rectF, Matrix matrix) {
        if (jS() && this.buc.Oe() != Layer.MatteType.Invert) {
            this.bue.d(this.Gu, matrix);
            rectF.set(Math.max(rectF.left, this.Gu.left), Math.max(rectF.top, this.Gu.top), Math.min(rectF.right, this.Gu.right), Math.min(rectF.bottom, this.Gu.bottom));
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
                paint = this.Gq;
                break;
            default:
                paint = this.Gp;
                break;
        }
        int size = this.bud.iL().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.bud.iL().get(i).NL() != maskMode) {
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
                if (this.bud.iL().get(i2).NL() == maskMode) {
                    this.path.set(this.bud.iM().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Go.getAlpha();
                    this.Go.setAlpha((int) (this.bud.iN().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.Go);
                    this.Go.setAlpha(alpha);
                }
            }
            com.baidu.live.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.baidu.live.lottie.d.bb("Layer#restoreLayer");
            com.baidu.live.lottie.d.bb("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jU() {
        return (this.bud == null || this.bud.iM().isEmpty()) ? false : true;
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
        this.bsN.setProgress(f);
        if (this.bud != null) {
            for (int i = 0; i < this.bud.iM().size(); i++) {
                this.bud.iM().get(i).setProgress(f);
            }
        }
        if (this.buc.jW() != 0.0f) {
            f /= this.buc.jW();
        }
        if (this.bue != null) {
            this.bue.setProgress(this.bue.buc.jW() * f);
        }
        for (int i2 = 0; i2 < this.GF.size(); i2++) {
            this.GF.get(i2).setProgress(f);
        }
    }

    private void jV() {
        if (this.GD == null) {
            if (this.bug == null) {
                this.GD = Collections.emptyList();
                return;
            }
            this.GD = new ArrayList();
            for (a aVar = this.bug; aVar != null; aVar = aVar.bug) {
                this.GD.add(aVar);
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.buc.getName();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<com.baidu.live.lottie.a.a.b> list, List<com.baidu.live.lottie.a.a.b> list2) {
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.hn(getName());
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
        this.bsN.b(t, cVar);
    }
}
