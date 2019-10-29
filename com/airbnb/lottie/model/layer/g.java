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
    private final com.airbnb.lottie.f dh;
    private final com.airbnb.lottie.e dk;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> eJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> iA;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> iB;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> iC;
    private final char[] ir;
    private final RectF iu;
    private final Paint iw;
    private final Paint ix;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> iy;
    private final o iz;
    private final Matrix matrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.ir = new char[1];
        this.iu = new RectF();
        this.matrix = new Matrix();
        this.iw = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.ix = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.iy = new HashMap();
        this.dh = fVar;
        this.dk = layer.bj();
        this.iz = layer.dn().bY();
        this.iz.b(this);
        a(this.iz);
        k m6do = layer.m6do();
        if (m6do != null && m6do.gD != null) {
            this.eJ = m6do.gD.bY();
            this.eJ.b(this);
            a(this.eJ);
        }
        if (m6do != null && m6do.gE != null) {
            this.iA = m6do.gE.bY();
            this.iA.b(this);
            a(this.iA);
        }
        if (m6do != null && m6do.gF != null) {
            this.iB = m6do.gF.bY();
            this.iB.b(this);
            a(this.iB);
        }
        if (m6do != null && m6do.gG != null) {
            this.iC = m6do.gG.bY();
            this.iC.b(this);
            a(this.iC);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.dh.bi()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.iz.getValue();
        com.airbnb.lottie.model.f fVar = this.dk.aY().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.eJ != null) {
            this.iw.setColor(this.eJ.getValue().intValue());
        } else {
            this.iw.setColor(value.color);
        }
        if (this.iA != null) {
            this.ix.setColor(this.iA.getValue().intValue());
        } else {
            this.ix.setColor(value.gi);
        }
        int intValue = (this.fj.bP().getValue().intValue() * 255) / 100;
        this.iw.setAlpha(intValue);
        this.ix.setAlpha(intValue);
        if (this.iB != null) {
            this.ix.setStrokeWidth(this.iB.getValue().floatValue());
        } else {
            this.ix.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.dk.bb());
        }
        if (this.dh.bi()) {
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
                com.airbnb.lottie.model.g gVar = this.dk.aX().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.bV(), fVar.bW()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.dk.bb() * c;
                    float f2 = dVar.gf / 10.0f;
                    canvas.translate(((this.iC != null ? this.iC.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface g = this.dh.g(fVar.bV(), fVar.bW());
        if (g != null) {
            String str = dVar.text;
            l bh = this.dh.bh();
            String J = bh != null ? bh.J(str) : str;
            this.iw.setTypeface(g);
            this.iw.setTextSize(dVar.size * this.dk.bb());
            this.ix.setTypeface(this.iw.getTypeface());
            this.ix.setTextSize(this.iw.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.ir[0] = charAt;
                float f = dVar.gf / 10.0f;
                canvas.translate(((this.iC != null ? this.iC.getValue().floatValue() + f : f) * c) + this.iw.measureText(this.ir, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path bw = a.get(i).bw();
            bw.computeBounds(this.iu, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.gh)) * this.dk.bb());
            this.matrix.preScale(f, f);
            bw.transform(this.matrix);
            if (dVar.gj) {
                a(bw, this.iw, canvas);
                a(bw, this.ix, canvas);
            } else {
                a(bw, this.ix, canvas);
                a(bw, this.iw, canvas);
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
        this.ir[0] = c;
        if (dVar.gj) {
            a(this.ir, this.iw, canvas);
            a(this.ir, this.ix, canvas);
            return;
        }
        a(this.ir, this.ix, canvas);
        a(this.ir, this.iw, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.iy.containsKey(gVar)) {
            return this.iy.get(gVar);
        }
        List<j> bX = gVar.bX();
        int size = bX.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.dh, this, bX.get(i)));
        }
        this.iy.put(gVar, arrayList);
        return arrayList;
    }
}
