package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> BC;
    private final char[] Ff;
    private final RectF Fg;
    private final Paint Fh;
    private final Paint Fi;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> Fj;
    private final n Fk;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> Fl;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Fm;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Fn;
    private final com.airbnb.lottie.e composition;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.Ff = new char[1];
        this.Fg = new RectF();
        this.matrix = new Matrix();
        this.Fh = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Fi = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Fj = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.Fk = layer.iR().hK();
        this.Fk.b(this);
        a(this.Fk);
        k iS = layer.iS();
        if (iS != null && iS.Dp != null) {
            this.BC = iS.Dp.hK();
            this.BC.b(this);
            a(this.BC);
        }
        if (iS != null && iS.Dq != null) {
            this.Fl = iS.Dq.hK();
            this.Fl.b(this);
            a(this.Fl);
        }
        if (iS != null && iS.Dr != null) {
            this.Fm = iS.Dr.hK();
            this.Fm.b(this);
            a(this.Fm);
        }
        if (iS != null && iS.Ds != null) {
            this.Fn = iS.Ds.hK();
            this.Fn.b(this);
            a(this.Fn);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.gQ()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.Fk.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.gJ().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.BC != null) {
            this.Fh.setColor(this.BC.getValue().intValue());
        } else {
            this.Fh.setColor(value.color);
        }
        if (this.Fl != null) {
            this.Fi.setColor(this.Fl.getValue().intValue());
        } else {
            this.Fi.setColor(value.Dc);
        }
        int intValue = (this.Ca.hy().getValue().intValue() * 255) / 100;
        this.Fh.setAlpha(intValue);
        this.Fi.setAlpha(intValue);
        if (this.Fm != null) {
            this.Fi.setStrokeWidth(this.Fm.getValue().floatValue());
        } else {
            this.Fi.setStrokeWidth((float) (value.Dd * com.airbnb.lottie.d.f.jk() * com.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.gQ()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.CX) / 100.0f;
        float b = com.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.composition.gI().get(com.airbnb.lottie.model.d.a(str.charAt(i2), cVar.hE(), cVar.hF()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.jk() * b;
                    float f2 = bVar.CZ / 10.0f;
                    canvas.translate(((this.Fn != null ? this.Fn.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.airbnb.lottie.d.f.b(matrix);
        Typeface n = this.lottieDrawable.n(cVar.hE(), cVar.hF());
        if (n != null) {
            String str = bVar.text;
            r gP = this.lottieDrawable.gP();
            String bb = gP != null ? gP.bb(str) : str;
            this.Fh.setTypeface(n);
            this.Fh.setTextSize((float) (bVar.CX * com.airbnb.lottie.d.f.jk()));
            this.Fi.setTypeface(this.Fh.getTypeface());
            this.Fi.setTextSize(this.Fh.getTextSize());
            for (int i = 0; i < bb.length(); i++) {
                char charAt = bb.charAt(i);
                a(charAt, bVar, canvas);
                this.Ff[0] = charAt;
                float f = bVar.CZ / 10.0f;
                canvas.translate(((this.Fn != null ? this.Fn.getValue().floatValue() + f : f) * b) + this.Fh.measureText(this.Ff, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path hd = a.get(i).hd();
            hd.computeBounds(this.Fg, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Db)) * com.airbnb.lottie.d.f.jk());
            this.matrix.preScale(f, f);
            hd.transform(this.matrix);
            if (bVar.De) {
                a(hd, this.Fh, canvas);
                a(hd, this.Fi, canvas);
            } else {
                a(hd, this.Fi, canvas);
                a(hd, this.Fh, canvas);
            }
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void a(char c, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        this.Ff[0] = c;
        if (bVar.De) {
            a(this.Ff, this.Fh, canvas);
            a(this.Ff, this.Fi, canvas);
            return;
        }
        a(this.Ff, this.Fi, canvas);
        a(this.Ff, this.Fh, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.Fj.containsKey(dVar)) {
            return this.Fj.get(dVar);
        }
        List<j> hG = dVar.hG();
        int size = hG.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, hG.get(i)));
        }
        this.Fj.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.Av && this.BC != null) {
            this.BC.a(cVar);
        } else if (t == com.airbnb.lottie.k.Aw && this.Fl != null) {
            this.Fl.a(cVar);
        } else if (t == com.airbnb.lottie.k.AF && this.Fm != null) {
            this.Fm.a(cVar);
        } else if (t == com.airbnb.lottie.k.AG && this.Fn != null) {
            this.Fn.a(cVar);
        }
    }
}
