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
/* loaded from: classes20.dex */
public class g extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> Ce;
    private final char[] FF;
    private final RectF FG;
    private final Paint FH;
    private final Paint FI;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> FJ;
    private final n FK;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> FL;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> FM;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> FN;
    private final com.airbnb.lottie.e composition;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.FF = new char[1];
        this.FG = new RectF();
        this.matrix = new Matrix();
        this.FH = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.FI = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.FJ = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.FK = layer.jh().ia();
        this.FK.b(this);
        a(this.FK);
        k ji = layer.ji();
        if (ji != null && ji.DT != null) {
            this.Ce = ji.DT.ia();
            this.Ce.b(this);
            a(this.Ce);
        }
        if (ji != null && ji.DU != null) {
            this.FL = ji.DU.ia();
            this.FL.b(this);
            a(this.FL);
        }
        if (ji != null && ji.DV != null) {
            this.FM = ji.DV.ia();
            this.FM.b(this);
            a(this.FM);
        }
        if (ji != null && ji.DW != null) {
            this.FN = ji.DW.ia();
            this.FN.b(this);
            a(this.FN);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.hg()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.FK.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.gZ().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.Ce != null) {
            this.FH.setColor(this.Ce.getValue().intValue());
        } else {
            this.FH.setColor(value.color);
        }
        if (this.FL != null) {
            this.FI.setColor(this.FL.getValue().intValue());
        } else {
            this.FI.setColor(value.strokeColor);
        }
        int intValue = (this.CD.hO().getValue().intValue() * 255) / 100;
        this.FH.setAlpha(intValue);
        this.FI.setAlpha(intValue);
        if (this.FM != null) {
            this.FI.setStrokeWidth(this.FM.getValue().floatValue());
        } else {
            this.FI.setStrokeWidth((float) (value.DE * com.airbnb.lottie.d.f.jA() * com.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.hg()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Dz) / 100.0f;
        float b = com.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.composition.gY().get(com.airbnb.lottie.model.d.a(str.charAt(i2), cVar.hU(), cVar.hV()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.jA() * b;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.FN != null ? this.FN.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.airbnb.lottie.d.f.b(matrix);
        Typeface n = this.lottieDrawable.n(cVar.hU(), cVar.hV());
        if (n != null) {
            String str = bVar.text;
            r hf = this.lottieDrawable.hf();
            String bc = hf != null ? hf.bc(str) : str;
            this.FH.setTypeface(n);
            this.FH.setTextSize((float) (bVar.Dz * com.airbnb.lottie.d.f.jA()));
            this.FI.setTypeface(this.FH.getTypeface());
            this.FI.setTextSize(this.FH.getTextSize());
            for (int i = 0; i < bc.length(); i++) {
                char charAt = bc.charAt(i);
                a(charAt, bVar, canvas);
                this.FF[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.FN != null ? this.FN.getValue().floatValue() + f : f) * b) + this.FH.measureText(this.FF, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path ht = a.get(i).ht();
            ht.computeBounds(this.FG, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.DD)) * com.airbnb.lottie.d.f.jA());
            this.matrix.preScale(f, f);
            ht.transform(this.matrix);
            if (bVar.DG) {
                a(ht, this.FH, canvas);
                a(ht, this.FI, canvas);
            } else {
                a(ht, this.FI, canvas);
                a(ht, this.FH, canvas);
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
        this.FF[0] = c;
        if (bVar.DG) {
            a(this.FF, this.FH, canvas);
            a(this.FF, this.FI, canvas);
            return;
        }
        a(this.FF, this.FI, canvas);
        a(this.FF, this.FH, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.FJ.containsKey(dVar)) {
            return this.FJ.get(dVar);
        }
        List<j> hW = dVar.hW();
        int size = hW.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, hW.get(i)));
        }
        this.FJ.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.Ba && this.Ce != null) {
            this.Ce.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bb && this.FL != null) {
            this.FL.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bk && this.FM != null) {
            this.FM.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bl && this.FN != null) {
            this.FN.a(cVar);
        }
    }
}
