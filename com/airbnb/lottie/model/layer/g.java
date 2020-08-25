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
/* loaded from: classes18.dex */
public class g extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> CJ;
    private final char[] Gk;
    private final RectF Gl;
    private final Paint Gm;
    private final Paint Gn;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> Go;
    private final n Gp;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> Gq;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Gr;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Gs;
    private final com.airbnb.lottie.e composition;
    private final com.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.Gk = new char[1];
        this.Gl = new RectF();
        this.matrix = new Matrix();
        this.Gm = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Gn = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.Go = new HashMap();
        this.lottieDrawable = gVar;
        this.composition = layer.getComposition();
        this.Gp = layer.kG().jB();
        this.Gp.b(this);
        a(this.Gp);
        k kH = layer.kH();
        if (kH != null && kH.Ex != null) {
            this.CJ = kH.Ex.jB();
            this.CJ.b(this);
            a(this.CJ);
        }
        if (kH != null && kH.Ey != null) {
            this.Gq = kH.Ey.jB();
            this.Gq.b(this);
            a(this.Gq);
        }
        if (kH != null && kH.Ez != null) {
            this.Gr = kH.Ez.jB();
            this.Gr.b(this);
            a(this.Gr);
        }
        if (kH != null && kH.EA != null) {
            this.Gs = kH.EA.jB();
            this.Gs.b(this);
            a(this.Gs);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.iH()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.Gp.getValue();
        com.airbnb.lottie.model.c cVar = this.composition.iA().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.CJ != null) {
            this.Gm.setColor(this.CJ.getValue().intValue());
        } else {
            this.Gm.setColor(value.color);
        }
        if (this.Gq != null) {
            this.Gn.setColor(this.Gq.getValue().intValue());
        } else {
            this.Gn.setColor(value.strokeColor);
        }
        int intValue = (this.Dm.jp().getValue().intValue() * 255) / 100;
        this.Gm.setAlpha(intValue);
        this.Gn.setAlpha(intValue);
        if (this.Gr != null) {
            this.Gn.setStrokeWidth(this.Gr.getValue().floatValue());
        } else {
            this.Gn.setStrokeWidth((float) (value.El * com.airbnb.lottie.d.f.kZ() * com.airbnb.lottie.d.f.b(matrix)));
        }
        if (this.lottieDrawable.iH()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Eh) / 100.0f;
        float b = com.airbnb.lottie.d.f.b(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.composition.iz().get(com.airbnb.lottie.model.d.a(str.charAt(i2), cVar.jv(), cVar.jw()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.kZ() * b;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.Gs != null ? this.Gs.getValue().floatValue() + f2 : f2) * b) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = com.airbnb.lottie.d.f.b(matrix);
        Typeface q = this.lottieDrawable.q(cVar.jv(), cVar.jw());
        if (q != null) {
            String str = bVar.text;
            r iG = this.lottieDrawable.iG();
            String bh = iG != null ? iG.bh(str) : str;
            this.Gm.setTypeface(q);
            this.Gm.setTextSize((float) (bVar.Eh * com.airbnb.lottie.d.f.kZ()));
            this.Gn.setTypeface(this.Gm.getTypeface());
            this.Gn.setTextSize(this.Gm.getTextSize());
            for (int i = 0; i < bh.length(); i++) {
                char charAt = bh.charAt(i);
                a(charAt, bVar, canvas);
                this.Gk[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.Gs != null ? this.Gs.getValue().floatValue() + f : f) * b) + this.Gm.measureText(this.Gk, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path iU = a.get(i).iU();
            iU.computeBounds(this.Gl, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Ek)) * com.airbnb.lottie.d.f.kZ());
            this.matrix.preScale(f, f);
            iU.transform(this.matrix);
            if (bVar.Em) {
                a(iU, this.Gm, canvas);
                a(iU, this.Gn, canvas);
            } else {
                a(iU, this.Gn, canvas);
                a(iU, this.Gm, canvas);
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
        this.Gk[0] = c;
        if (bVar.Em) {
            a(this.Gk, this.Gm, canvas);
            a(this.Gk, this.Gn, canvas);
            return;
        }
        a(this.Gk, this.Gn, canvas);
        a(this.Gk, this.Gm, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.Go.containsKey(dVar)) {
            return this.Go.get(dVar);
        }
        List<j> jx = dVar.jx();
        int size = jx.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.lottieDrawable, this, jx.get(i)));
        }
        this.Go.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.k.BE && this.CJ != null) {
            this.CJ.a(cVar);
        } else if (t == com.airbnb.lottie.k.BF && this.Gq != null) {
            this.Gq.a(cVar);
        } else if (t == com.airbnb.lottie.k.BO && this.Gr != null) {
            this.Gr.a(cVar);
        } else if (t == com.airbnb.lottie.k.BP && this.Gs != null) {
            this.Gs.a(cVar);
        }
    }
}
