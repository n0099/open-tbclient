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
/* loaded from: classes5.dex */
public class g extends a {
    private final com.airbnb.lottie.e composition;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> fW;
    private final char[] jC;
    private final RectF jD;
    private final Paint jE;
    private final Paint jF;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> jG;
    private final n jH;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> jI;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> jJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> jK;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.jC = new char[1];
        this.jD = new RectF();
        this.matrix = new Matrix();
        this.jE = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.jF = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.jG = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.jH = layer.dr().cm();
        this.jH.b(this);
        a(this.jH);
        k ds = layer.ds();
        if (ds != null && ds.hG != null) {
            this.fW = ds.hG.cm();
            this.fW.b(this);
            a(this.fW);
        }
        if (ds != null && ds.hH != null) {
            this.jI = ds.hH.cm();
            this.jI.b(this);
            a(this.jI);
        }
        if (ds != null && ds.hI != null) {
            this.jJ = ds.hI.cm();
            this.jJ.b(this);
            a(this.jJ);
        }
        if (ds != null && ds.hJ != null) {
            this.jK = ds.hJ.cm();
            this.jK.b(this);
            a(this.jK);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.bs()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.jH.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.bl().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.fW != null) {
            this.jE.setColor(this.fW.getValue().intValue());
        } else {
            this.jE.setColor(value.color);
        }
        if (this.jI != null) {
            this.jF.setColor(this.jI.getValue().intValue());
        } else {
            this.jF.setColor(value.ht);
        }
        int intValue = (this.gv.ca().getValue().intValue() * 255) / 100;
        this.jE.setAlpha(intValue);
        this.jF.setAlpha(intValue);
        if (this.jJ != null) {
            this.jF.setStrokeWidth(this.jJ.getValue().floatValue());
        } else {
            this.jF.setStrokeWidth((float) (value.hu * com.airbnb.lottie.d.f.dK() * com.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.bs()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.ho) / 100.0f;
        float b = com.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.composition.bk().get(com.airbnb.lottie.model.d.a(str.charAt(i2), cVar.cg(), cVar.ch()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.dK() * b;
                    float f2 = bVar.hq / 10.0f;
                    canvas.translate(((this.jK != null ? this.jK.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.airbnb.lottie.d.f.b(matrix);
        Typeface g = this.lottieDrawable.g(cVar.cg(), cVar.ch());
        if (g != null) {
            String str = bVar.text;
            r br = this.lottieDrawable.br();
            String L = br != null ? br.L(str) : str;
            this.jE.setTypeface(g);
            this.jE.setTextSize((float) (bVar.ho * com.airbnb.lottie.d.f.dK()));
            this.jF.setTypeface(this.jE.getTypeface());
            this.jF.setTextSize(this.jE.getTextSize());
            for (int i = 0; i < L.length(); i++) {
                char charAt = L.charAt(i);
                a(charAt, bVar, canvas);
                this.jC[0] = charAt;
                float f = bVar.hq / 10.0f;
                canvas.translate(((this.jK != null ? this.jK.getValue().floatValue() + f : f) * b) + this.jE.measureText(this.jC, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path bF = a.get(i).bF();
            bF.computeBounds(this.jD, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.hs)) * com.airbnb.lottie.d.f.dK());
            this.matrix.preScale(f, f);
            bF.transform(this.matrix);
            if (bVar.hv) {
                a(bF, this.jE, canvas);
                a(bF, this.jF, canvas);
            } else {
                a(bF, this.jF, canvas);
                a(bF, this.jE, canvas);
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
        this.jC[0] = c;
        if (bVar.hv) {
            a(this.jC, this.jE, canvas);
            a(this.jC, this.jF, canvas);
            return;
        }
        a(this.jC, this.jF, canvas);
        a(this.jC, this.jE, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.jG.containsKey(dVar)) {
            return this.jG.get(dVar);
        }
        List<j> ci = dVar.ci();
        int size = ci.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, ci.get(i)));
        }
        this.jG.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.eK && this.fW != null) {
            this.fW.a(cVar);
        } else if (t == com.airbnb.lottie.k.eL && this.jI != null) {
            this.jI.a(cVar);
        } else if (t == com.airbnb.lottie.k.eU && this.jJ != null) {
            this.jJ.a(cVar);
        } else if (t == com.airbnb.lottie.k.eV && this.jK != null) {
            this.jK.a(cVar);
        }
    }
}
