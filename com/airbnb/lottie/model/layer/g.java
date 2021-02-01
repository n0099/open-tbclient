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
/* loaded from: classes4.dex */
public class g extends a {
    private final com.airbnb.lottie.f BH;
    private final com.airbnb.lottie.d BJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> DK;
    private final char[] Hf;
    private final Paint Hg;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> Hh;
    private final n Hi;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> Hj;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Hk;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Hl;
    private final Matrix matrix;
    private final RectF rectF;
    private final Paint strokePaint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.Hf = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.Hg = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Hh = new HashMap();
        this.BH = fVar;
        this.BJ = layer.getComposition();
        this.Hi = layer.kg().jb();
        this.Hi.b(this);
        a(this.Hi);
        k kh = layer.kh();
        if (kh != null && kh.Fr != null) {
            this.DK = kh.Fr.jb();
            this.DK.b(this);
            a(this.DK);
        }
        if (kh != null && kh.Fs != null) {
            this.Hj = kh.Fs.jb();
            this.Hj.b(this);
            a(this.Hj);
        }
        if (kh != null && kh.Ft != null) {
            this.Hk = kh.Ft.jb();
            this.Hk.b(this);
            a(this.Hk);
        }
        if (kh != null && kh.Fu != null) {
            this.Hl = kh.Fu.jb();
            this.Hl.b(this);
            a(this.Hl);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.BH.ig()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.Hi.getValue();
        com.airbnb.lottie.model.c cVar = this.BJ.hX().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.DK != null) {
            this.Hg.setColor(this.DK.getValue().intValue());
        } else {
            this.Hg.setColor(value.color);
        }
        if (this.Hj != null) {
            this.strokePaint.setColor(this.Hj.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int intValue = (this.Ek.iP().getValue().intValue() * 255) / 100;
        this.Hg.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        if (this.Hk != null) {
            this.strokePaint.setStrokeWidth(this.Hk.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (value.Fg * com.airbnb.lottie.d.f.kz() * com.airbnb.lottie.d.f.c(matrix)));
        }
        if (this.BH.ig()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Fc) / 100.0f;
        float c = com.airbnb.lottie.d.f.c(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.BJ.hW().get(com.airbnb.lottie.model.d.b(str.charAt(i2), cVar.iV(), cVar.iW()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.kz() * c;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.Hl != null ? this.Hl.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.d.f.c(matrix);
        Typeface n = this.BH.n(cVar.iV(), cVar.iW());
        if (n != null) {
            String str = bVar.text;
            p m6if = this.BH.m6if();
            String bh = m6if != null ? m6if.bh(str) : str;
            this.Hg.setTypeface(n);
            this.Hg.setTextSize((float) (bVar.Fc * com.airbnb.lottie.d.f.kz()));
            this.strokePaint.setTypeface(this.Hg.getTypeface());
            this.strokePaint.setTextSize(this.Hg.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.Hf[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.Hl != null ? this.Hl.getValue().floatValue() + f : f) * c) + this.Hg.measureText(this.Hf, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iu = a2.get(i).iu();
            iu.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Ff)) * com.airbnb.lottie.d.f.kz());
            this.matrix.preScale(f, f);
            iu.transform(this.matrix);
            if (bVar.Fh) {
                b(iu, this.Hg, canvas);
                b(iu, this.strokePaint, canvas);
            } else {
                b(iu, this.strokePaint, canvas);
                b(iu, this.Hg, canvas);
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
        this.Hf[0] = c;
        if (bVar.Fh) {
            b(this.Hf, this.Hg, canvas);
            b(this.Hf, this.strokePaint, canvas);
            return;
        }
        b(this.Hf, this.strokePaint, canvas);
        b(this.Hf, this.Hg, canvas);
    }

    private void b(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.Hh.containsKey(dVar)) {
            return this.Hh.get(dVar);
        }
        List<j> iX = dVar.iX();
        int size = iX.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.BH, this, iX.get(i)));
        }
        this.Hh.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.j.Cy && this.DK != null) {
            this.DK.a(cVar);
        } else if (t == com.airbnb.lottie.j.Cz && this.Hj != null) {
            this.Hj.a(cVar);
        } else if (t == com.airbnb.lottie.j.CJ && this.Hk != null) {
            this.Hk.a(cVar);
        } else if (t == com.airbnb.lottie.j.CK && this.Hl != null) {
            this.Hl.a(cVar);
        }
    }
}
