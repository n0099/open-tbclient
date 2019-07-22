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
    private final com.airbnb.lottie.f kB;
    private final com.airbnb.lottie.e kI;
    private final Matrix matrix;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> mj;
    private final char[] qd;
    private final RectF qe;
    private final Paint qf;
    private final Paint qg;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> qh;
    private final o qi;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> qj;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> ql;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.qd = new char[1];
        this.qe = new RectF();
        this.matrix = new Matrix();
        this.qf = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.qg = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.qh = new HashMap();
        this.kB = fVar;
        this.kI = layer.bQ();
        this.qi = layer.dU().cF();
        this.qi.b(this);
        a(this.qi);
        k dV = layer.dV();
        if (dV != null && dV.oh != null) {
            this.mj = dV.oh.cF();
            this.mj.b(this);
            a(this.mj);
        }
        if (dV != null && dV.oi != null) {
            this.qj = dV.oi.cF();
            this.qj.b(this);
            a(this.qj);
        }
        if (dV != null && dV.oj != null) {
            this.ql = dV.oj.cF();
            this.ql.b(this);
            a(this.ql);
        }
        if (dV != null && dV.ol != null) {
            this.qm = dV.ol.cF();
            this.qm.b(this);
            a(this.qm);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.kB.bP()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.qi.getValue();
        com.airbnb.lottie.model.f fVar = this.kI.bF().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.mj != null) {
            this.qf.setColor(this.mj.getValue().intValue());
        } else {
            this.qf.setColor(value.color);
        }
        if (this.qj != null) {
            this.qg.setColor(this.qj.getValue().intValue());
        } else {
            this.qg.setColor(value.nM);
        }
        int intValue = (this.mM.cw().getValue().intValue() * 255) / 100;
        this.qf.setAlpha(intValue);
        this.qg.setAlpha(intValue);
        if (this.ql != null) {
            this.qg.setStrokeWidth(this.ql.getValue().floatValue());
        } else {
            this.qg.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.kI.bI());
        }
        if (this.kB.bP()) {
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
                com.airbnb.lottie.model.g gVar = this.kI.bE().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.cC(), fVar.cD()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.kI.bI() * c;
                    float f2 = dVar.nJ / 10.0f;
                    canvas.translate(((this.qm != null ? this.qm.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface g = this.kB.g(fVar.cC(), fVar.cD());
        if (g != null) {
            String str = dVar.text;
            l bO = this.kB.bO();
            String J = bO != null ? bO.J(str) : str;
            this.qf.setTypeface(g);
            this.qf.setTextSize(dVar.size * this.kI.bI());
            this.qg.setTypeface(this.qf.getTypeface());
            this.qg.setTextSize(this.qf.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.qd[0] = charAt;
                float f = dVar.nJ / 10.0f;
                canvas.translate(((this.qm != null ? this.qm.getValue().floatValue() + f : f) * c) + this.qf.measureText(this.qd, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path cd = a.get(i).cd();
            cd.computeBounds(this.qe, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.nL)) * this.kI.bI());
            this.matrix.preScale(f, f);
            cd.transform(this.matrix);
            if (dVar.nN) {
                a(cd, this.qf, canvas);
                a(cd, this.qg, canvas);
            } else {
                a(cd, this.qg, canvas);
                a(cd, this.qf, canvas);
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
        this.qd[0] = c;
        if (dVar.nN) {
            a(this.qd, this.qf, canvas);
            a(this.qd, this.qg, canvas);
            return;
        }
        a(this.qd, this.qg, canvas);
        a(this.qd, this.qf, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.qh.containsKey(gVar)) {
            return this.qh.get(gVar);
        }
        List<j> cE = gVar.cE();
        int size = cE.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.kB, this, cE.get(i)));
        }
        this.qh.put(gVar, arrayList);
        return arrayList;
    }
}
