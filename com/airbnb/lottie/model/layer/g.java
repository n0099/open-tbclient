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
    private final com.airbnb.lottie.f kC;
    private final com.airbnb.lottie.e kJ;
    private final Matrix matrix;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> mk;
    private final char[] qb;
    private final RectF qc;
    private final Paint qd;
    private final Paint qe;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> qf;
    private final o qg;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> qh;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> qi;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> qj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.qb = new char[1];
        this.qc = new RectF();
        this.matrix = new Matrix();
        this.qd = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.qe = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.qf = new HashMap();
        this.kC = fVar;
        this.kJ = layer.bM();
        this.qg = layer.dN().cz();
        this.qg.b(this);
        a(this.qg);
        k dO = layer.dO();
        if (dO != null && dO.og != null) {
            this.mk = dO.og.cz();
            this.mk.b(this);
            a(this.mk);
        }
        if (dO != null && dO.oh != null) {
            this.qh = dO.oh.cz();
            this.qh.b(this);
            a(this.qh);
        }
        if (dO != null && dO.oi != null) {
            this.qi = dO.oi.cz();
            this.qi.b(this);
            a(this.qi);
        }
        if (dO != null && dO.oj != null) {
            this.qj = dO.oj.cz();
            this.qj.b(this);
            a(this.qj);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.kC.bL()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.qg.getValue();
        com.airbnb.lottie.model.f fVar = this.kJ.bB().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.mk != null) {
            this.qd.setColor(this.mk.getValue().intValue());
        } else {
            this.qd.setColor(value.color);
        }
        if (this.qh != null) {
            this.qe.setColor(this.qh.getValue().intValue());
        } else {
            this.qe.setColor(value.strokeColor);
        }
        int intValue = (this.mN.cr().getValue().intValue() * 255) / 100;
        this.qd.setAlpha(intValue);
        this.qe.setAlpha(intValue);
        if (this.qi != null) {
            this.qe.setStrokeWidth(this.qi.getValue().floatValue());
        } else {
            this.qe.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.kJ.bE());
        }
        if (this.kC.bL()) {
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
                com.airbnb.lottie.model.g gVar = this.kJ.bA().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.getFamily(), fVar.cx()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.kJ.bE() * c;
                    float f2 = dVar.nK / 10.0f;
                    canvas.translate(((this.qj != null ? this.qj.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface g = this.kC.g(fVar.getFamily(), fVar.cx());
        if (g != null) {
            String str = dVar.text;
            l bK = this.kC.bK();
            String J = bK != null ? bK.J(str) : str;
            this.qd.setTypeface(g);
            this.qd.setTextSize(dVar.size * this.kJ.bE());
            this.qe.setTypeface(this.qd.getTypeface());
            this.qe.setTextSize(this.qd.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.qb[0] = charAt;
                float f = dVar.nK / 10.0f;
                canvas.translate(((this.qj != null ? this.qj.getValue().floatValue() + f : f) * c) + this.qd.measureText(this.qb, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.qc, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.nM)) * this.kJ.bE());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (dVar.nN) {
                a(path, this.qd, canvas);
                a(path, this.qe, canvas);
            } else {
                a(path, this.qe, canvas);
                a(path, this.qd, canvas);
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
        this.qb[0] = c;
        if (dVar.nN) {
            a(this.qb, this.qd, canvas);
            a(this.qb, this.qe, canvas);
            return;
        }
        a(this.qb, this.qe, canvas);
        a(this.qb, this.qd, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.qf.containsKey(gVar)) {
            return this.qf.get(gVar);
        }
        List<j> cy = gVar.cy();
        int size = cy.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.kC, this, cy.get(i)));
        }
        this.qf.put(gVar, arrayList);
        return arrayList;
    }
}
