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
    private final char[] Hf;
    private final Paint Hg;
    private final Map<com.baidu.live.lottie.model.d, List<com.baidu.live.lottie.a.a.c>> Hh;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Integer, Integer> bsy;
    private final n bur;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Integer, Integer> bus;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> but;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> buu;
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
        this.bur = layer.Of().Ns();
        this.bur.b(this);
        a(this.bur);
        k Og = layer.Og();
        if (Og != null && Og.btr != null) {
            this.bsy = Og.btr.Ns();
            this.bsy.b(this);
            a(this.bsy);
        }
        if (Og != null && Og.bts != null) {
            this.bus = Og.bts.Ns();
            this.bus.b(this);
            a(this.bus);
        }
        if (Og != null && Og.btt != null) {
            this.but = Og.btt.Ns();
            this.but.b(this);
            a(this.but);
        }
        if (Og != null && Og.btu != null) {
            this.buu = Og.btu.Ns();
            this.buu.b(this);
            a(this.buu);
        }
    }

    @Override // com.baidu.live.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.ig()) {
            canvas.setMatrix(matrix);
        }
        com.baidu.live.lottie.model.b value = this.bur.getValue();
        com.baidu.live.lottie.model.c cVar = this.composition.hX().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.bsy != null) {
            this.Hg.setColor(this.bsy.getValue().intValue());
        } else {
            this.Hg.setColor(value.color);
        }
        if (this.bus != null) {
            this.strokePaint.setColor(this.bus.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int intValue = (this.bsN.Nn().getValue().intValue() * 255) / 100;
        this.Hg.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        if (this.but != null) {
            this.strokePaint.setStrokeWidth(this.but.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (value.Fg * com.baidu.live.lottie.d.f.kz() * com.baidu.live.lottie.d.f.c(matrix)));
        }
        if (this.lottieDrawable.ig()) {
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
                com.baidu.live.lottie.model.d dVar = this.composition.hW().get(com.baidu.live.lottie.model.d.b(str.charAt(i2), cVar.iV(), cVar.iW()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.baidu.live.lottie.d.f.kz() * c;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.buu != null ? this.buu.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
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
            s Nf = this.lottieDrawable.Nf();
            String bh = Nf != null ? Nf.bh(str) : str;
            this.Hg.setTypeface(n);
            this.Hg.setTextSize((float) (bVar.Fc * com.baidu.live.lottie.d.f.kz()));
            this.strokePaint.setTypeface(this.Hg.getTypeface());
            this.strokePaint.setTextSize(this.Hg.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.Hf[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.buu != null ? this.buu.getValue().floatValue() + f : f) * c) + this.Hg.measureText(this.Hf, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.baidu.live.lottie.model.d dVar, Matrix matrix, float f, com.baidu.live.lottie.model.b bVar, Canvas canvas) {
        List<com.baidu.live.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iu = a2.get(i).iu();
            iu.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Ff)) * com.baidu.live.lottie.d.f.kz());
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
        List<j> iX = dVar.iX();
        int size = iX.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.baidu.live.lottie.a.a.c(this.lottieDrawable, this, iX.get(i)));
        }
        this.Hh.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        super.a((g) t, (com.baidu.live.lottie.e.c<g>) cVar);
        if (t == l.Cy && this.bsy != null) {
            this.bsy.a(cVar);
        } else if (t == l.Cz && this.bus != null) {
            this.bus.a(cVar);
        } else if (t == l.CJ && this.but != null) {
            this.but.a(cVar);
        } else if (t == l.CK && this.buu != null) {
            this.buu.a(cVar);
        }
    }
}
