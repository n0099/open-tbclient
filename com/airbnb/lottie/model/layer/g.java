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
    private final char[] Fc;
    private final RectF Fd;
    private final Paint Fe;
    private final Paint Ff;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> Fg;
    private final n Fh;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> Fi;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Fj;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Fk;
    private final com.airbnb.lottie.e composition;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.Fc = new char[1];
        this.Fd = new RectF();
        this.matrix = new Matrix();
        this.Fe = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Ff = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Fg = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.Fh = layer.iR().hK();
        this.Fh.b(this);
        a(this.Fh);
        k iS = layer.iS();
        if (iS != null && iS.Dm != null) {
            this.BC = iS.Dm.hK();
            this.BC.b(this);
            a(this.BC);
        }
        if (iS != null && iS.Dn != null) {
            this.Fi = iS.Dn.hK();
            this.Fi.b(this);
            a(this.Fi);
        }
        if (iS != null && iS.Do != null) {
            this.Fj = iS.Do.hK();
            this.Fj.b(this);
            a(this.Fj);
        }
        if (iS != null && iS.Dp != null) {
            this.Fk = iS.Dp.hK();
            this.Fk.b(this);
            a(this.Fk);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.gQ()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.Fh.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.gJ().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.BC != null) {
            this.Fe.setColor(this.BC.getValue().intValue());
        } else {
            this.Fe.setColor(value.color);
        }
        if (this.Fi != null) {
            this.Ff.setColor(this.Fi.getValue().intValue());
        } else {
            this.Ff.setColor(value.CZ);
        }
        int intValue = (this.Ca.hy().getValue().intValue() * 255) / 100;
        this.Fe.setAlpha(intValue);
        this.Ff.setAlpha(intValue);
        if (this.Fj != null) {
            this.Ff.setStrokeWidth(this.Fj.getValue().floatValue());
        } else {
            this.Ff.setStrokeWidth((float) (value.Da * com.airbnb.lottie.d.f.jk() * com.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.gQ()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.CU) / 100.0f;
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
                    float f2 = bVar.CW / 10.0f;
                    canvas.translate(((this.Fk != null ? this.Fk.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
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
            this.Fe.setTypeface(n);
            this.Fe.setTextSize((float) (bVar.CU * com.airbnb.lottie.d.f.jk()));
            this.Ff.setTypeface(this.Fe.getTypeface());
            this.Ff.setTextSize(this.Fe.getTextSize());
            for (int i = 0; i < bb.length(); i++) {
                char charAt = bb.charAt(i);
                a(charAt, bVar, canvas);
                this.Fc[0] = charAt;
                float f = bVar.CW / 10.0f;
                canvas.translate(((this.Fk != null ? this.Fk.getValue().floatValue() + f : f) * b) + this.Fe.measureText(this.Fc, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path hd = a.get(i).hd();
            hd.computeBounds(this.Fd, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.CY)) * com.airbnb.lottie.d.f.jk());
            this.matrix.preScale(f, f);
            hd.transform(this.matrix);
            if (bVar.Db) {
                a(hd, this.Fe, canvas);
                a(hd, this.Ff, canvas);
            } else {
                a(hd, this.Ff, canvas);
                a(hd, this.Fe, canvas);
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
        this.Fc[0] = c;
        if (bVar.Db) {
            a(this.Fc, this.Fe, canvas);
            a(this.Fc, this.Ff, canvas);
            return;
        }
        a(this.Fc, this.Ff, canvas);
        a(this.Fc, this.Fe, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.Fg.containsKey(dVar)) {
            return this.Fg.get(dVar);
        }
        List<j> hG = dVar.hG();
        int size = hG.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, hG.get(i)));
        }
        this.Fg.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.Av && this.BC != null) {
            this.BC.a(cVar);
        } else if (t == com.airbnb.lottie.k.Aw && this.Fi != null) {
            this.Fi.a(cVar);
        } else if (t == com.airbnb.lottie.k.AF && this.Fj != null) {
            this.Fj.a(cVar);
        } else if (t == com.airbnb.lottie.k.AG && this.Fk != null) {
            this.Fk.a(cVar);
        }
    }
}
