package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends a {
    private final com.airbnb.lottie.f BJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> DN;
    private final char[] Hh;
    private final Paint Hi;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> Hj;
    private final n Hk;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> Hl;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Hm;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Hn;
    private final com.airbnb.lottie.d composition;
    private final Matrix matrix;
    private final RectF rectF;
    private final Paint strokePaint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.Hh = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.Hi = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Hj = new HashMap();
        this.BJ = fVar;
        this.composition = layer.getComposition();
        this.Hk = layer.kh().jc();
        this.Hk.b(this);
        a(this.Hk);
        k ki = layer.ki();
        if (ki != null && ki.Ft != null) {
            this.DN = ki.Ft.jc();
            this.DN.b(this);
            a(this.DN);
        }
        if (ki != null && ki.Fu != null) {
            this.Hl = ki.Fu.jc();
            this.Hl.b(this);
            a(this.Hl);
        }
        if (ki != null && ki.Fv != null) {
            this.Hm = ki.Fv.jc();
            this.Hm.b(this);
            a(this.Hm);
        }
        if (ki != null && ki.Fw != null) {
            this.Hn = ki.Fw.jc();
            this.Hn.b(this);
            a(this.Hn);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.BJ.ih()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.Hk.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.hY().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.DN != null) {
            this.Hi.setColor(this.DN.getValue().intValue());
        } else {
            this.Hi.setColor(value.color);
        }
        if (this.Hl != null) {
            this.strokePaint.setColor(this.Hl.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int intValue = (this.Em.iQ().getValue().intValue() * 255) / 100;
        this.Hi.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        if (this.Hm != null) {
            this.strokePaint.setStrokeWidth(this.Hm.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (value.Fi * com.airbnb.lottie.d.f.kA() * com.airbnb.lottie.d.f.c(matrix)));
        }
        if (this.BJ.ih()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Fe) / 100.0f;
        float c = com.airbnb.lottie.d.f.c(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.composition.hX().get(com.airbnb.lottie.model.d.b(str.charAt(i2), cVar.iW(), cVar.iX()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.kA() * c;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.Hn != null ? this.Hn.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.d.f.c(matrix);
        Typeface q = this.BJ.q(cVar.iW(), cVar.iX());
        if (q != null) {
            String str = bVar.text;
            p ig = this.BJ.ig();
            String bh = ig != null ? ig.bh(str) : str;
            this.Hi.setTypeface(q);
            this.Hi.setTextSize((float) (bVar.Fe * com.airbnb.lottie.d.f.kA()));
            this.strokePaint.setTypeface(this.Hi.getTypeface());
            this.strokePaint.setTextSize(this.Hi.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.Hh[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.Hn != null ? this.Hn.getValue().floatValue() + f : f) * c) + this.Hi.measureText(this.Hh, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iv = a2.get(i).iv();
            iv.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Fh)) * com.airbnb.lottie.d.f.kA());
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

    private void a(char c, com.airbnb.lottie.model.b bVar, Canvas canvas) {
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

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.Hj.containsKey(dVar)) {
            return this.Hj.get(dVar);
        }
        List<j> iY = dVar.iY();
        int size = iY.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.BJ, this, iY.get(i)));
        }
        this.Hj.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.j.CB && this.DN != null) {
            this.DN.a(cVar);
        } else if (t == com.airbnb.lottie.j.CC && this.Hl != null) {
            this.Hl.a(cVar);
        } else if (t == com.airbnb.lottie.j.CL && this.Hm != null) {
            this.Hm.a(cVar);
        } else if (t == com.airbnb.lottie.j.CN && this.Hn != null) {
            this.Hn.a(cVar);
        }
    }
}
