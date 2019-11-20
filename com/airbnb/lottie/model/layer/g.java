package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.l;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.content.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class g extends a {
    private final com.airbnb.lottie.f cG;
    private final com.airbnb.lottie.e cJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> ej;
    private final char[] hP;
    private final RectF hQ;
    private final Paint hR;
    private final Paint hS;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> hT;
    private final o hU;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> hV;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> hW;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> hX;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.hP = new char[1];
        this.hQ = new RectF();
        this.matrix = new Matrix();
        this.hR = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.hS = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.hT = new HashMap();
        this.cG = fVar;
        this.cJ = layer.bj();
        this.hU = layer.dn().bY();
        this.hU.b(this);
        a(this.hU);
        k m6do = layer.m6do();
        if (m6do != null && m6do.ge != null) {
            this.ej = m6do.ge.bY();
            this.ej.b(this);
            a(this.ej);
        }
        if (m6do != null && m6do.gf != null) {
            this.hV = m6do.gf.bY();
            this.hV.b(this);
            a(this.hV);
        }
        if (m6do != null && m6do.gg != null) {
            this.hW = m6do.gg.bY();
            this.hW.b(this);
            a(this.hW);
        }
        if (m6do != null && m6do.gh != null) {
            this.hX = m6do.gh.bY();
            this.hX.b(this);
            a(this.hX);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.cG.bi()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.hU.getValue();
        com.airbnb.lottie.model.f fVar = this.cJ.aY().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.ej != null) {
            this.hR.setColor(this.ej.getValue().intValue());
        } else {
            this.hR.setColor(value.color);
        }
        if (this.hV != null) {
            this.hS.setColor(this.hV.getValue().intValue());
        } else {
            this.hS.setColor(value.fJ);
        }
        int intValue = (this.eJ.bP().getValue().intValue() * 255) / 100;
        this.hR.setAlpha(intValue);
        this.hS.setAlpha(intValue);
        if (this.hW != null) {
            this.hS.setStrokeWidth(this.hW.getValue().floatValue());
        } else {
            this.hS.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.cJ.bb());
        }
        if (this.cG.bi()) {
            a(value, matrix, fVar, canvas);
        } else {
            a(value, fVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, com.airbnb.lottie.model.f fVar, Canvas canvas) {
        float f = dVar.size / 100.0f;
        float c = com.airbnb.lottie.c.f.c(matrix);
        String str = dVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.g gVar = this.cJ.aX().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.bV(), fVar.bW()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.cJ.bb() * c;
                    float f2 = dVar.fG / 10.0f;
                    canvas.translate(((this.hX != null ? this.hX.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface g = this.cG.g(fVar.bV(), fVar.bW());
        if (g != null) {
            String str = dVar.text;
            l bh = this.cG.bh();
            String J = bh != null ? bh.J(str) : str;
            this.hR.setTypeface(g);
            this.hR.setTextSize(dVar.size * this.cJ.bb());
            this.hS.setTypeface(this.hR.getTypeface());
            this.hS.setTextSize(this.hR.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.hP[0] = charAt;
                float f = dVar.fG / 10.0f;
                canvas.translate(((this.hX != null ? this.hX.getValue().floatValue() + f : f) * c) + this.hR.measureText(this.hP, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path bw = a.get(i).bw();
            bw.computeBounds(this.hQ, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.fI)) * this.cJ.bb());
            this.matrix.preScale(f, f);
            bw.transform(this.matrix);
            if (dVar.fK) {
                a(bw, this.hR, canvas);
                a(bw, this.hS, canvas);
            } else {
                a(bw, this.hS, canvas);
                a(bw, this.hR, canvas);
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

    private void a(char c, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        this.hP[0] = c;
        if (dVar.fK) {
            a(this.hP, this.hR, canvas);
            a(this.hP, this.hS, canvas);
            return;
        }
        a(this.hP, this.hS, canvas);
        a(this.hP, this.hR, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.hT.containsKey(gVar)) {
            return this.hT.get(gVar);
        }
        List<j> bX = gVar.bX();
        int size = bX.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.cG, this, bX.get(i)));
        }
        this.hT.put(gVar, arrayList);
        return arrayList;
    }
}
