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
/* loaded from: classes10.dex */
public class g extends a {
    private final char[] Hh;
    private final Paint Hi;
    private final Map<com.baidu.live.lottie.model.d, List<com.baidu.live.lottie.a.a.c>> Hj;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Integer, Integer> btK;
    private final n bvC;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Integer, Integer> bvD;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> bvE;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> bvF;
    private final com.baidu.live.lottie.e composition;
    private final h lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final Paint strokePaint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, Layer layer) {
        super(hVar, layer);
        this.Hh = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.Hi = new Paint(1) { // from class: com.baidu.live.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(1) { // from class: com.baidu.live.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Hj = new HashMap();
        this.lottieDrawable = hVar;
        this.composition = layer.getComposition();
        this.bvC = layer.QC().PP();
        this.bvC.b(this);
        a(this.bvC);
        k QD = layer.QD();
        if (QD != null && QD.buD != null) {
            this.btK = QD.buD.PP();
            this.btK.b(this);
            a(this.btK);
        }
        if (QD != null && QD.buE != null) {
            this.bvD = QD.buE.PP();
            this.bvD.b(this);
            a(this.bvD);
        }
        if (QD != null && QD.buF != null) {
            this.bvE = QD.buF.PP();
            this.bvE.b(this);
            a(this.bvE);
        }
        if (QD != null && QD.buG != null) {
            this.bvF = QD.buG.PP();
            this.bvF.b(this);
            a(this.bvF);
        }
    }

    @Override // com.baidu.live.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.ih()) {
            canvas.setMatrix(matrix);
        }
        com.baidu.live.lottie.model.b value = this.bvC.getValue();
        com.baidu.live.lottie.model.c cVar = this.composition.hY().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.btK != null) {
            this.Hi.setColor(this.btK.getValue().intValue());
        } else {
            this.Hi.setColor(value.color);
        }
        if (this.bvD != null) {
            this.strokePaint.setColor(this.bvD.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int intValue = (this.btZ.PK().getValue().intValue() * 255) / 100;
        this.Hi.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        if (this.bvE != null) {
            this.strokePaint.setStrokeWidth(this.bvE.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (value.Fi * com.baidu.live.lottie.d.f.kA() * com.baidu.live.lottie.d.f.c(matrix)));
        }
        if (this.lottieDrawable.ih()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.baidu.live.lottie.model.b bVar, Matrix matrix, com.baidu.live.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Fe) / 100.0f;
        float c = com.baidu.live.lottie.d.f.c(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.baidu.live.lottie.model.d dVar = this.composition.hX().get(com.baidu.live.lottie.model.d.b(str.charAt(i2), cVar.iW(), cVar.iX()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.baidu.live.lottie.d.f.kA() * c;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.bvF != null ? this.bvF.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.baidu.live.lottie.model.b bVar, com.baidu.live.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float c = com.baidu.live.lottie.d.f.c(matrix);
        Typeface q = this.lottieDrawable.q(cVar.iW(), cVar.iX());
        if (q != null) {
            String str = bVar.text;
            s PC = this.lottieDrawable.PC();
            String bh = PC != null ? PC.bh(str) : str;
            this.Hi.setTypeface(q);
            this.Hi.setTextSize((float) (bVar.Fe * com.baidu.live.lottie.d.f.kA()));
            this.strokePaint.setTypeface(this.Hi.getTypeface());
            this.strokePaint.setTextSize(this.Hi.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.Hh[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.bvF != null ? this.bvF.getValue().floatValue() + f : f) * c) + this.Hi.measureText(this.Hh, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.baidu.live.lottie.model.d dVar, Matrix matrix, float f, com.baidu.live.lottie.model.b bVar, Canvas canvas) {
        List<com.baidu.live.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iv = a2.get(i).iv();
            iv.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Fh)) * com.baidu.live.lottie.d.f.kA());
            this.matrix.preScale(f, f);
            iv.transform(this.matrix);
            if (bVar.Fj) {
                b(iv, this.Hi, canvas);
                b(iv, this.strokePaint, canvas);
            } else {
                b(iv, this.strokePaint, canvas);
                b(iv, this.Hi, canvas);
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
        this.Hh[0] = c;
        if (bVar.Fj) {
            b(this.Hh, this.Hi, canvas);
            b(this.Hh, this.strokePaint, canvas);
            return;
        }
        b(this.Hh, this.strokePaint, canvas);
        b(this.Hh, this.Hi, canvas);
    }

    private void b(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.baidu.live.lottie.a.a.c> a(com.baidu.live.lottie.model.d dVar) {
        if (this.Hj.containsKey(dVar)) {
            return this.Hj.get(dVar);
        }
        List<j> iY = dVar.iY();
        int size = iY.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.baidu.live.lottie.a.a.c(this.lottieDrawable, this, iY.get(i)));
        }
        this.Hj.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        super.a((g) t, (com.baidu.live.lottie.e.c<g>) cVar);
        if (t == l.CB && this.btK != null) {
            this.btK.a(cVar);
        } else if (t == l.CC && this.bvD != null) {
            this.bvD.a(cVar);
        } else if (t == l.CL && this.bvE != null) {
            this.bvE.a(cVar);
        } else if (t == l.CN && this.bvF != null) {
            this.bvF.a(cVar);
        }
    }
}
