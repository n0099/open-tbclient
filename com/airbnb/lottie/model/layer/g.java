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
    private final com.airbnb.lottie.e composition;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> fZ;
    private final char[] jF;
    private final RectF jG;
    private final Paint jH;
    private final Paint jI;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> jJ;
    private final n jK;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> jL;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> jM;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> jN;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.jF = new char[1];
        this.jG = new RectF();
        this.matrix = new Matrix();
        this.jH = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.jI = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.jJ = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.jK = layer.ds().cn();
        this.jK.b(this);
        a(this.jK);
        k dt = layer.dt();
        if (dt != null && dt.hJ != null) {
            this.fZ = dt.hJ.cn();
            this.fZ.b(this);
            a(this.fZ);
        }
        if (dt != null && dt.hK != null) {
            this.jL = dt.hK.cn();
            this.jL.b(this);
            a(this.jL);
        }
        if (dt != null && dt.hL != null) {
            this.jM = dt.hL.cn();
            this.jM.b(this);
            a(this.jM);
        }
        if (dt != null && dt.hM != null) {
            this.jN = dt.hM.cn();
            this.jN.b(this);
            a(this.jN);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.bt()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.jK.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.bm().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.fZ != null) {
            this.jH.setColor(this.fZ.getValue().intValue());
        } else {
            this.jH.setColor(value.color);
        }
        if (this.jL != null) {
            this.jI.setColor(this.jL.getValue().intValue());
        } else {
            this.jI.setColor(value.hw);
        }
        int intValue = (this.gy.cb().getValue().intValue() * 255) / 100;
        this.jH.setAlpha(intValue);
        this.jI.setAlpha(intValue);
        if (this.jM != null) {
            this.jI.setStrokeWidth(this.jM.getValue().floatValue());
        } else {
            this.jI.setStrokeWidth((float) (value.hx * com.airbnb.lottie.d.f.dL() * com.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.bt()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.hr) / 100.0f;
        float b = com.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.composition.bl().get(com.airbnb.lottie.model.d.a(str.charAt(i2), cVar.ch(), cVar.ci()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.dL() * b;
                    float f2 = bVar.ht / 10.0f;
                    canvas.translate(((this.jN != null ? this.jN.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.airbnb.lottie.d.f.b(matrix);
        Typeface j = this.lottieDrawable.j(cVar.ch(), cVar.ci());
        if (j != null) {
            String str = bVar.text;
            r bs = this.lottieDrawable.bs();
            String L = bs != null ? bs.L(str) : str;
            this.jH.setTypeface(j);
            this.jH.setTextSize((float) (bVar.hr * com.airbnb.lottie.d.f.dL()));
            this.jI.setTypeface(this.jH.getTypeface());
            this.jI.setTextSize(this.jH.getTextSize());
            for (int i = 0; i < L.length(); i++) {
                char charAt = L.charAt(i);
                a(charAt, bVar, canvas);
                this.jF[0] = charAt;
                float f = bVar.ht / 10.0f;
                canvas.translate(((this.jN != null ? this.jN.getValue().floatValue() + f : f) * b) + this.jH.measureText(this.jF, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path bG = a.get(i).bG();
            bG.computeBounds(this.jG, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.hv)) * com.airbnb.lottie.d.f.dL());
            this.matrix.preScale(f, f);
            bG.transform(this.matrix);
            if (bVar.hy) {
                a(bG, this.jH, canvas);
                a(bG, this.jI, canvas);
            } else {
                a(bG, this.jI, canvas);
                a(bG, this.jH, canvas);
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
        this.jF[0] = c;
        if (bVar.hy) {
            a(this.jF, this.jH, canvas);
            a(this.jF, this.jI, canvas);
            return;
        }
        a(this.jF, this.jI, canvas);
        a(this.jF, this.jH, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.jJ.containsKey(dVar)) {
            return this.jJ.get(dVar);
        }
        List<j> cj = dVar.cj();
        int size = cj.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, cj.get(i)));
        }
        this.jJ.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.eM && this.fZ != null) {
            this.fZ.a(cVar);
        } else if (t == com.airbnb.lottie.k.eN && this.jL != null) {
            this.jL.a(cVar);
        } else if (t == com.airbnb.lottie.k.eW && this.jM != null) {
            this.jM.a(cVar);
        } else if (t == com.airbnb.lottie.k.eX && this.jN != null) {
            this.jN.a(cVar);
        }
    }
}
