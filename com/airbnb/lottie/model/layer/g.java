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
/* loaded from: classes7.dex */
public class g extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> DZ;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> HA;
    private final n HB;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> HC;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> HD;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> HE;
    private final char[] Hw;
    private final RectF Hx;
    private final Paint Hy;
    private final Paint Hz;
    private final com.airbnb.lottie.e composition;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.Hw = new char[1];
        this.Hx = new RectF();
        this.matrix = new Matrix();
        this.Hy = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Hz = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.HA = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.HB = layer.kI().jD();
        this.HB.b(this);
        a(this.HB);
        k kJ = layer.kJ();
        if (kJ != null && kJ.FG != null) {
            this.DZ = kJ.FG.jD();
            this.DZ.b(this);
            a(this.DZ);
        }
        if (kJ != null && kJ.FH != null) {
            this.HC = kJ.FH.jD();
            this.HC.b(this);
            a(this.HC);
        }
        if (kJ != null && kJ.FI != null) {
            this.HD = kJ.FI.jD();
            this.HD.b(this);
            a(this.HD);
        }
        if (kJ != null && kJ.FJ != null) {
            this.HE = kJ.FJ.jD();
            this.HE.b(this);
            a(this.HE);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.iJ()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.HB.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.iB().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.DZ != null) {
            this.Hy.setColor(this.DZ.getValue().intValue());
        } else {
            this.Hy.setColor(value.color);
        }
        if (this.HC != null) {
            this.Hz.setColor(this.HC.getValue().intValue());
        } else {
            this.Hz.setColor(value.Ft);
        }
        int intValue = (this.Ex.jr().getValue().intValue() * 255) / 100;
        this.Hy.setAlpha(intValue);
        this.Hz.setAlpha(intValue);
        if (this.HD != null) {
            this.Hz.setStrokeWidth(this.HD.getValue().floatValue());
        } else {
            this.Hz.setStrokeWidth((float) (value.Fu * com.airbnb.lottie.d.f.lb() * com.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.iJ()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Fp) / 100.0f;
        float b = com.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.composition.iA().get(com.airbnb.lottie.model.d.a(str.charAt(i2), cVar.jx(), cVar.jy()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.lb() * b;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.HE != null ? this.HE.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.airbnb.lottie.d.f.b(matrix);
        Typeface q = this.lottieDrawable.q(cVar.jx(), cVar.jy());
        if (q != null) {
            String str = bVar.text;
            r iI = this.lottieDrawable.iI();
            String bk = iI != null ? iI.bk(str) : str;
            this.Hy.setTypeface(q);
            this.Hy.setTextSize((float) (bVar.Fp * com.airbnb.lottie.d.f.lb()));
            this.Hz.setTypeface(this.Hy.getTypeface());
            this.Hz.setTextSize(this.Hy.getTextSize());
            for (int i = 0; i < bk.length(); i++) {
                char charAt = bk.charAt(i);
                a(charAt, bVar, canvas);
                this.Hw[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.HE != null ? this.HE.getValue().floatValue() + f : f) * b) + this.Hy.measureText(this.Hw, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iW = a2.get(i).iW();
            iW.computeBounds(this.Hx, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Fs)) * com.airbnb.lottie.d.f.lb());
            this.matrix.preScale(f, f);
            iW.transform(this.matrix);
            if (bVar.Fv) {
                a(iW, this.Hy, canvas);
                a(iW, this.Hz, canvas);
            } else {
                a(iW, this.Hz, canvas);
                a(iW, this.Hy, canvas);
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
        this.Hw[0] = c;
        if (bVar.Fv) {
            a(this.Hw, this.Hy, canvas);
            a(this.Hw, this.Hz, canvas);
            return;
        }
        a(this.Hw, this.Hz, canvas);
        a(this.Hw, this.Hy, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.HA.containsKey(dVar)) {
            return this.HA.get(dVar);
        }
        List<j> jz = dVar.jz();
        int size = jz.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, jz.get(i)));
        }
        this.HA.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.CN && this.DZ != null) {
            this.DZ.a(cVar);
        } else if (t == com.airbnb.lottie.k.CO && this.HC != null) {
            this.HC.a(cVar);
        } else if (t == com.airbnb.lottie.k.Db && this.HD != null) {
            this.HD.a(cVar);
        } else if (t == com.airbnb.lottie.k.Dc && this.HE != null) {
            this.HE.a(cVar);
        }
    }
}
