package com.baidu.live.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.n;
import com.baidu.live.lottie.h;
import com.baidu.live.lottie.l;
import com.baidu.live.lottie.model.a.k;
import com.baidu.live.lottie.model.content.j;
import com.baidu.live.lottie.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class g extends a {
    private final Paint IB;
    private final Map<com.baidu.live.lottie.model.d, List<com.baidu.live.lottie.a.a.c>> IC;
    private final char[] Iz;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Integer, Integer> btZ;
    private final n bvR;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Integer, Integer> bvS;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> bvT;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> bvU;
    private final com.baidu.live.lottie.e composition;
    private final h lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final Paint strokePaint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, Layer layer) {
        super(hVar, layer);
        this.Iz = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.IB = new Paint(1) { // from class: com.baidu.live.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(1) { // from class: com.baidu.live.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.IC = new HashMap();
        this.lottieDrawable = hVar;
        this.composition = layer.getComposition();
        this.bvR = layer.Oi().Nv();
        this.bvR.b(this);
        a(this.bvR);
        k Oj = layer.Oj();
        if (Oj != null && Oj.buS != null) {
            this.btZ = Oj.buS.Nv();
            this.btZ.b(this);
            a(this.btZ);
        }
        if (Oj != null && Oj.buT != null) {
            this.bvS = Oj.buT.Nv();
            this.bvS.b(this);
            a(this.bvS);
        }
        if (Oj != null && Oj.buU != null) {
            this.bvT = Oj.buU.Nv();
            this.bvT.b(this);
            a(this.bvT);
        }
        if (Oj != null && Oj.buV != null) {
            this.bvU = Oj.buV.Nv();
            this.bvU.b(this);
            a(this.bvU);
        }
    }

    @Override // com.baidu.live.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.ig()) {
            canvas.setMatrix(matrix);
        }
        com.baidu.live.lottie.model.b value = this.bvR.getValue();
        com.baidu.live.lottie.model.c cVar = this.composition.hX().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.btZ != null) {
            this.IB.setColor(this.btZ.getValue().intValue());
        } else {
            this.IB.setColor(value.color);
        }
        if (this.bvS != null) {
            this.strokePaint.setColor(this.bvS.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int intValue = (this.bup.Nq().getValue().intValue() * 255) / 100;
        this.IB.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        if (this.bvT != null) {
            this.strokePaint.setStrokeWidth(this.bvT.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (value.Gz * com.baidu.live.lottie.d.f.kz() * com.baidu.live.lottie.d.f.c(matrix)));
        }
        if (this.lottieDrawable.ig()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.baidu.live.lottie.model.b bVar, Matrix matrix, com.baidu.live.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Gv) / 100.0f;
        float c = com.baidu.live.lottie.d.f.c(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.baidu.live.lottie.model.d dVar = this.composition.hW().get(com.baidu.live.lottie.model.d.b(str.charAt(i2), cVar.iV(), cVar.iW()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.baidu.live.lottie.d.f.kz() * c;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.bvU != null ? this.bvU.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.baidu.live.lottie.model.b bVar, com.baidu.live.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float c = com.baidu.live.lottie.d.f.c(matrix);
        Typeface n = this.lottieDrawable.n(cVar.iV(), cVar.iW());
        if (n != null) {
            String str = bVar.text;
            s Ni = this.lottieDrawable.Ni();
            String bl = Ni != null ? Ni.bl(str) : str;
            this.IB.setTypeface(n);
            this.IB.setTextSize((float) (bVar.Gv * com.baidu.live.lottie.d.f.kz()));
            this.strokePaint.setTypeface(this.IB.getTypeface());
            this.strokePaint.setTextSize(this.IB.getTextSize());
            for (int i = 0; i < bl.length(); i++) {
                char charAt = bl.charAt(i);
                a(charAt, bVar, canvas);
                this.Iz[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.bvU != null ? this.bvU.getValue().floatValue() + f : f) * c) + this.IB.measureText(this.Iz, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.baidu.live.lottie.model.d dVar, Matrix matrix, float f, com.baidu.live.lottie.model.b bVar, Canvas canvas) {
        List<com.baidu.live.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iu = a2.get(i).iu();
            iu.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Gy)) * com.baidu.live.lottie.d.f.kz());
            this.matrix.preScale(f, f);
            iu.transform(this.matrix);
            if (bVar.GA) {
                b(iu, this.IB, canvas);
                b(iu, this.strokePaint, canvas);
            } else {
                b(iu, this.strokePaint, canvas);
                b(iu, this.IB, canvas);
            }
        }
    }

    private void b(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void a(char c, com.baidu.live.lottie.model.b bVar, Canvas canvas) {
        this.Iz[0] = c;
        if (bVar.GA) {
            b(this.Iz, this.IB, canvas);
            b(this.Iz, this.strokePaint, canvas);
            return;
        }
        b(this.Iz, this.strokePaint, canvas);
        b(this.Iz, this.IB, canvas);
    }

    private void b(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.baidu.live.lottie.a.a.c> a(com.baidu.live.lottie.model.d dVar) {
        if (this.IC.containsKey(dVar)) {
            return this.IC.get(dVar);
        }
        List<j> iX = dVar.iX();
        int size = iX.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.baidu.live.lottie.a.a.c(this.lottieDrawable, this, iX.get(i)));
        }
        this.IC.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        super.a((g) t, (com.baidu.live.lottie.e.c<g>) cVar);
        if (t == l.Ea && this.btZ != null) {
            this.btZ.a(cVar);
        } else if (t == l.Eb && this.bvS != null) {
            this.bvS.a(cVar);
        } else if (t == l.Ek && this.bvT != null) {
            this.bvT.a(cVar);
        } else if (t == l.El && this.bvU != null) {
            this.bvU.a(cVar);
        }
    }
}
