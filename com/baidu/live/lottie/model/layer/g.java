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
    private final char[] Hf;
    private final Paint Hg;
    private final Map<com.baidu.live.lottie.model.d, List<com.baidu.live.lottie.a.a.c>> Hh;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Integer, Integer> boX;
    private final n bqO;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Integer, Integer> bqP;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> bqQ;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> bqR;
    private final com.baidu.live.lottie.e composition;
    private final h lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final Paint strokePaint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, Layer layer) {
        super(hVar, layer);
        this.Hf = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.Hg = new Paint(1) { // from class: com.baidu.live.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(1) { // from class: com.baidu.live.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Hh = new HashMap();
        this.lottieDrawable = hVar;
        this.composition = layer.getComposition();
        this.bqO = layer.MH().LU();
        this.bqO.b(this);
        a(this.bqO);
        k MI = layer.MI();
        if (MI != null && MI.bpP != null) {
            this.boX = MI.bpP.LU();
            this.boX.b(this);
            a(this.boX);
        }
        if (MI != null && MI.bpQ != null) {
            this.bqP = MI.bpQ.LU();
            this.bqP.b(this);
            a(this.bqP);
        }
        if (MI != null && MI.bpR != null) {
            this.bqQ = MI.bpR.LU();
            this.bqQ.b(this);
            a(this.bqQ);
        }
        if (MI != null && MI.bpS != null) {
            this.bqR = MI.bpS.LU();
            this.bqR.b(this);
            a(this.bqR);
        }
    }

    @Override // com.baidu.live.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.ih()) {
            canvas.setMatrix(matrix);
        }
        com.baidu.live.lottie.model.b value = this.bqO.getValue();
        com.baidu.live.lottie.model.c cVar = this.composition.hY().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.boX != null) {
            this.Hg.setColor(this.boX.getValue().intValue());
        } else {
            this.Hg.setColor(value.color);
        }
        if (this.bqP != null) {
            this.strokePaint.setColor(this.bqP.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int intValue = (this.bpm.LP().getValue().intValue() * 255) / 100;
        this.Hg.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        if (this.bqQ != null) {
            this.strokePaint.setStrokeWidth(this.bqQ.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (value.Fg * com.baidu.live.lottie.d.f.kA() * com.baidu.live.lottie.d.f.c(matrix)));
        }
        if (this.lottieDrawable.ih()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.baidu.live.lottie.model.b bVar, Matrix matrix, com.baidu.live.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Fc) / 100.0f;
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
                    canvas.translate(((this.bqR != null ? this.bqR.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
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
            s LH = this.lottieDrawable.LH();
            String bh = LH != null ? LH.bh(str) : str;
            this.Hg.setTypeface(q);
            this.Hg.setTextSize((float) (bVar.Fc * com.baidu.live.lottie.d.f.kA()));
            this.strokePaint.setTypeface(this.Hg.getTypeface());
            this.strokePaint.setTextSize(this.Hg.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.Hf[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.bqR != null ? this.bqR.getValue().floatValue() + f : f) * c) + this.Hg.measureText(this.Hf, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.baidu.live.lottie.model.d dVar, Matrix matrix, float f, com.baidu.live.lottie.model.b bVar, Canvas canvas) {
        List<com.baidu.live.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iv = a2.get(i).iv();
            iv.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Ff)) * com.baidu.live.lottie.d.f.kA());
            this.matrix.preScale(f, f);
            iv.transform(this.matrix);
            if (bVar.Fh) {
                b(iv, this.Hg, canvas);
                b(iv, this.strokePaint, canvas);
            } else {
                b(iv, this.strokePaint, canvas);
                b(iv, this.Hg, canvas);
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

    private List<com.baidu.live.lottie.a.a.c> a(com.baidu.live.lottie.model.d dVar) {
        if (this.Hh.containsKey(dVar)) {
            return this.Hh.get(dVar);
        }
        List<j> iY = dVar.iY();
        int size = iY.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.baidu.live.lottie.a.a.c(this.lottieDrawable, this, iY.get(i)));
        }
        this.Hh.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        super.a((g) t, (com.baidu.live.lottie.e.c<g>) cVar);
        if (t == l.Cy && this.boX != null) {
            this.boX.a(cVar);
        } else if (t == l.Cz && this.bqP != null) {
            this.bqP.a(cVar);
        } else if (t == l.CJ && this.bqQ != null) {
            this.bqQ.a(cVar);
        } else if (t == l.CK && this.bqR != null) {
            this.bqR.a(cVar);
        }
    }
}
