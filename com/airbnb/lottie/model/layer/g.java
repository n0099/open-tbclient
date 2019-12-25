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
/* loaded from: classes4.dex */
public class g extends a {
    private final com.airbnb.lottie.e composition;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> fW;
    private final char[] jD;
    private final RectF jE;
    private final Paint jF;
    private final Paint jG;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> jH;
    private final n jI;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> jJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> jK;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> jL;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.jD = new char[1];
        this.jE = new RectF();
        this.matrix = new Matrix();
        this.jF = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.jG = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.jH = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.jI = layer.dr().cm();
        this.jI.b(this);
        a(this.jI);
        k ds = layer.ds();
        if (ds != null && ds.hG != null) {
            this.fW = ds.hG.cm();
            this.fW.b(this);
            a(this.fW);
        }
        if (ds != null && ds.hH != null) {
            this.jJ = ds.hH.cm();
            this.jJ.b(this);
            a(this.jJ);
        }
        if (ds != null && ds.hI != null) {
            this.jK = ds.hI.cm();
            this.jK.b(this);
            a(this.jK);
        }
        if (ds != null && ds.hJ != null) {
            this.jL = ds.hJ.cm();
            this.jL.b(this);
            a(this.jL);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.bs()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.jI.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.bl().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.fW != null) {
            this.jF.setColor(this.fW.getValue().intValue());
        } else {
            this.jF.setColor(value.color);
        }
        if (this.jJ != null) {
            this.jG.setColor(this.jJ.getValue().intValue());
        } else {
            this.jG.setColor(value.ht);
        }
        int intValue = (this.gv.ca().getValue().intValue() * 255) / 100;
        this.jF.setAlpha(intValue);
        this.jG.setAlpha(intValue);
        if (this.jK != null) {
            this.jG.setStrokeWidth(this.jK.getValue().floatValue());
        } else {
            this.jG.setStrokeWidth((float) (value.hu * com.airbnb.lottie.d.f.dK() * com.airbnb.lottie.d.f.b(matrix)));
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
                    canvas.translate(((this.jL != null ? this.jL.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
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
            this.jF.setTypeface(g);
            this.jF.setTextSize((float) (bVar.ho * com.airbnb.lottie.d.f.dK()));
            this.jG.setTypeface(this.jF.getTypeface());
            this.jG.setTextSize(this.jF.getTextSize());
            for (int i = 0; i < L.length(); i++) {
                char charAt = L.charAt(i);
                a(charAt, bVar, canvas);
                this.jD[0] = charAt;
                float f = bVar.hq / 10.0f;
                canvas.translate(((this.jL != null ? this.jL.getValue().floatValue() + f : f) * b) + this.jF.measureText(this.jD, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path bF = a.get(i).bF();
            bF.computeBounds(this.jE, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.hs)) * com.airbnb.lottie.d.f.dK());
            this.matrix.preScale(f, f);
            bF.transform(this.matrix);
            if (bVar.hv) {
                a(bF, this.jF, canvas);
                a(bF, this.jG, canvas);
            } else {
                a(bF, this.jG, canvas);
                a(bF, this.jF, canvas);
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
        this.jD[0] = c;
        if (bVar.hv) {
            a(this.jD, this.jF, canvas);
            a(this.jD, this.jG, canvas);
            return;
        }
        a(this.jD, this.jG, canvas);
        a(this.jD, this.jF, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.jH.containsKey(dVar)) {
            return this.jH.get(dVar);
        }
        List<j> ci = dVar.ci();
        int size = ci.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, ci.get(i)));
        }
        this.jH.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.eL && this.fW != null) {
            this.fW.a(cVar);
        } else if (t == com.airbnb.lottie.k.eM && this.jJ != null) {
            this.jJ.a(cVar);
        } else if (t == com.airbnb.lottie.k.eV && this.jK != null) {
            this.jK.a(cVar);
        } else if (t == com.airbnb.lottie.k.eW && this.jL != null) {
            this.jL.a(cVar);
        }
    }
}
