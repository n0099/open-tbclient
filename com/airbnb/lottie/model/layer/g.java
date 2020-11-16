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
/* loaded from: classes16.dex */
public class g extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> Df;
    private final char[] GC;
    private final RectF GD;
    private final Paint GF;
    private final Paint GG;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> GH;
    private final n GI;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> GJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> GK;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> GL;
    private final com.airbnb.lottie.e composition;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.GC = new char[1];
        this.GD = new RectF();
        this.matrix = new Matrix();
        this.GF = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.GG = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.GH = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.GI = layer.kI().jD();
        this.GI.b(this);
        a(this.GI);
        k kJ = layer.kJ();
        if (kJ != null && kJ.EP != null) {
            this.Df = kJ.EP.jD();
            this.Df.b(this);
            a(this.Df);
        }
        if (kJ != null && kJ.ER != null) {
            this.GJ = kJ.ER.jD();
            this.GJ.b(this);
            a(this.GJ);
        }
        if (kJ != null && kJ.ES != null) {
            this.GK = kJ.ES.jD();
            this.GK.b(this);
            a(this.GK);
        }
        if (kJ != null && kJ.ET != null) {
            this.GL = kJ.ET.jD();
            this.GL.b(this);
            a(this.GL);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.iJ()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.GI.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.iB().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.Df != null) {
            this.GF.setColor(this.Df.getValue().intValue());
        } else {
            this.GF.setColor(value.color);
        }
        if (this.GJ != null) {
            this.GG.setColor(this.GJ.getValue().intValue());
        } else {
            this.GG.setColor(value.strokeColor);
        }
        int intValue = (this.DE.jr().getValue().intValue() * 255) / 100;
        this.GF.setAlpha(intValue);
        this.GG.setAlpha(intValue);
        if (this.GK != null) {
            this.GG.setStrokeWidth(this.GK.getValue().floatValue());
        } else {
            this.GG.setStrokeWidth((float) (value.ED * com.airbnb.lottie.d.f.lb() * com.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.iJ()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Ey) / 100.0f;
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
                    canvas.translate(((this.GL != null ? this.GL.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
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
            String bh = iI != null ? iI.bh(str) : str;
            this.GF.setTypeface(q);
            this.GF.setTextSize((float) (bVar.Ey * com.airbnb.lottie.d.f.lb()));
            this.GG.setTypeface(this.GF.getTypeface());
            this.GG.setTextSize(this.GF.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.GC[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.GL != null ? this.GL.getValue().floatValue() + f : f) * b) + this.GF.measureText(this.GC, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iW = a2.get(i).iW();
            iW.computeBounds(this.GD, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.EB)) * com.airbnb.lottie.d.f.lb());
            this.matrix.preScale(f, f);
            iW.transform(this.matrix);
            if (bVar.EE) {
                a(iW, this.GF, canvas);
                a(iW, this.GG, canvas);
            } else {
                a(iW, this.GG, canvas);
                a(iW, this.GF, canvas);
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
        this.GC[0] = c;
        if (bVar.EE) {
            a(this.GC, this.GF, canvas);
            a(this.GC, this.GG, canvas);
            return;
        }
        a(this.GC, this.GG, canvas);
        a(this.GC, this.GF, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.GH.containsKey(dVar)) {
            return this.GH.get(dVar);
        }
        List<j> jz = dVar.jz();
        int size = jz.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, jz.get(i)));
        }
        this.GH.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.BV && this.Df != null) {
            this.Df.a(cVar);
        } else if (t == com.airbnb.lottie.k.BW && this.GJ != null) {
            this.GJ.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cf && this.GK != null) {
            this.GK.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cg && this.GL != null) {
            this.GL.a(cVar);
        }
    }
}
