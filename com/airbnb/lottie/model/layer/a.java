package com.airbnb.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a implements com.airbnb.lottie.a.a.d, a.InterfaceC0010a, com.airbnb.lottie.model.f {
    final o Dm;
    private final String FC;
    final Layer FE;
    @Nullable
    private com.airbnb.lottie.a.b.g FF;
    @Nullable
    private a FG;
    @Nullable
    private a FH;
    private List<a> FI;
    final com.airbnb.lottie.g lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint Fu = new Paint(1);
    private final Paint Fv = new Paint(1);
    private final Paint Fw = new Paint(1);
    private final Paint Fx = new Paint(1);
    private final Paint Fy = new Paint();
    private final RectF rect = new RectF();
    private final RectF Fz = new RectF();
    private final RectF FA = new RectF();
    private final RectF FB = new RectF();
    final Matrix FD = new Matrix();
    private final List<com.airbnb.lottie.a.b.a<?, ?>> FJ = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.airbnb.lottie.g gVar, com.airbnb.lottie.e eVar) {
        switch (layer.kC()) {
            case Shape:
                return new e(gVar, layer);
            case PreComp:
                return new b(gVar, layer, eVar.bd(layer.getRefId()), eVar);
            case Solid:
                return new f(gVar, layer);
            case Image:
                return new c(gVar, layer);
            case Null:
                return new d(gVar, layer);
            case Text:
                return new g(gVar, layer);
            default:
                com.airbnb.lottie.d.warn("Unknown layer type " + layer.kC());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, Layer layer) {
        this.lottieDrawable = gVar;
        this.FE = layer;
        this.FC = layer.getName() + "#draw";
        this.Fy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Fv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Fw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.kD() == Layer.MatteType.Invert) {
            this.Fx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Fx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.Dm = layer.kl().jL();
        this.Dm.a((a.InterfaceC0010a) this);
        if (layer.jm() != null && !layer.jm().isEmpty()) {
            this.FF = new com.airbnb.lottie.a.b.g(layer.jm());
            for (com.airbnb.lottie.a.b.a<h, Path> aVar : this.FF.jn()) {
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.FF.jo()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        ku();
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void iS() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer ks() {
        return this.FE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.FG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kt() {
        return this.FG != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.FH = aVar;
    }

    private void ku() {
        if (!this.FE.kz().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.FE.kz());
            cVar.jg();
            cVar.b(new a.InterfaceC0010a() { // from class: com.airbnb.lottie.model.layer.a.1
                @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
                public void iS() {
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
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.FJ.add(aVar);
    }

    @Override // com.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.FD.set(matrix);
        this.FD.preConcat(this.Dm.getMatrix());
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.FC);
        if (!this.visible) {
            com.airbnb.lottie.d.bb(this.FC);
            return;
        }
        kw();
        com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.FI.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.FI.get(size).Dm.getMatrix());
        }
        com.airbnb.lottie.d.bb("Layer#parentMatrix");
        int intValue = (int) (((this.Dm.jq().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!kt() && !kv()) {
            this.matrix.preConcat(this.Dm.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.airbnb.lottie.d.bb("Layer#drawLayer");
            j(com.airbnb.lottie.d.bb(this.FC));
            return;
        }
        com.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.Dm.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.d.bb("Layer#computeBounds");
        com.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.Fu, true);
        com.airbnb.lottie.d.bb("Layer#saveLayer");
        e(canvas);
        com.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.airbnb.lottie.d.bb("Layer#drawLayer");
        if (kv()) {
            a(canvas, this.matrix);
        }
        if (kt()) {
            com.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.Fx, false);
            com.airbnb.lottie.d.bb("Layer#saveLayer");
            e(canvas);
            this.FG.a(canvas, matrix, intValue);
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.bb("Layer#restoreLayer");
            com.airbnb.lottie.d.bb("Layer#drawMatte");
        }
        com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.d.bb("Layer#restoreLayer");
        j(com.airbnb.lottie.d.bb(this.FC));
    }

    private void j(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.FE.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Fy);
        com.airbnb.lottie.d.bb("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.Fz.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (kv()) {
            int size = this.FF.jm().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.FF.jn().get(i).getValue());
                this.path.transform(matrix);
                switch (this.FF.jm().get(i).jZ()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.FB, false);
                        if (i == 0) {
                            this.Fz.set(this.FB);
                        } else {
                            this.Fz.set(Math.min(this.Fz.left, this.FB.left), Math.min(this.Fz.top, this.FB.top), Math.max(this.Fz.right, this.FB.right), Math.max(this.Fz.bottom, this.FB.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Fz.left), Math.max(rectF.top, this.Fz.top), Math.min(rectF.right, this.Fz.right), Math.min(rectF.bottom, this.Fz.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (kt() && this.FE.kD() != Layer.MatteType.Invert) {
            this.FG.a(this.FA, matrix);
            rectF.set(Math.max(rectF.left, this.FA.left), Math.max(rectF.top, this.FA.top), Math.min(rectF.right, this.FA.right), Math.min(rectF.bottom, this.FA.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z;
        switch (maskMode) {
            case MaskModeSubtract:
                paint = this.Fw;
                break;
            default:
                paint = this.Fv;
                break;
        }
        int size = this.FF.jm().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.FF.jm().get(i).jZ() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.airbnb.lottie.d.bb("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.FF.jm().get(i2).jZ() == maskMode) {
                    this.path.set(this.FF.jn().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Fu.getAlpha();
                    this.Fu.setAlpha((int) (this.FF.jo().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.Fu);
                    this.Fu.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.d.bb("Layer#restoreLayer");
            com.airbnb.lottie.d.bb("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kv() {
        return (this.FF == null || this.FF.jn().isEmpty()) ? false : true;
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
        this.Dm.setProgress(f);
        if (this.FF != null) {
            for (int i = 0; i < this.FF.jn().size(); i++) {
                this.FF.jn().get(i).setProgress(f);
            }
        }
        if (this.FE.kx() != 0.0f) {
            f /= this.FE.kx();
        }
        if (this.FG != null) {
            this.FG.setProgress(this.FG.FE.kx() * f);
        }
        for (int i2 = 0; i2 < this.FJ.size(); i2++) {
            this.FJ.get(i2).setProgress(f);
        }
    }

    private void kw() {
        if (this.FI == null) {
            if (this.FH == null) {
                this.FI = Collections.emptyList();
                return;
            }
            this.FI = new ArrayList();
            for (a aVar = this.FH; aVar != null; aVar = aVar.FH) {
                this.FI.add(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.FE.getName();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<com.airbnb.lottie.a.a.b> list, List<com.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.bk(getName());
                if (eVar.j(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.k(getName(), i)) {
                b(eVar, eVar.i(getName(), i) + i, list, eVar2);
            }
        }
    }

    void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        this.Dm.b(t, cVar);
    }
}
