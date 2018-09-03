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
    private final com.airbnb.lottie.f jR;
    private final com.airbnb.lottie.e jY;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> lA;
    private final Matrix matrix;
    private final char[] pp;
    private final RectF pq;
    private final Paint pr;
    private final Paint pt;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> pu;
    private final o pv;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> pw;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> px;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> py;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.pp = new char[1];
        this.pq = new RectF();
        this.matrix = new Matrix();
        this.pr = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.pt = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.pu = new HashMap();
        this.jR = fVar;
        this.jY = layer.bv();
        this.pv = layer.dw().ci();
        this.pv.b(this);
        a(this.pv);
        k dx = layer.dx();
        if (dx != null && dx.nw != null) {
            this.lA = dx.nw.ci();
            this.lA.b(this);
            a(this.lA);
        }
        if (dx != null && dx.nx != null) {
            this.pw = dx.nx.ci();
            this.pw.b(this);
            a(this.pw);
        }
        if (dx != null && dx.ny != null) {
            this.px = dx.ny.ci();
            this.px.b(this);
            a(this.px);
        }
        if (dx != null && dx.nz != null) {
            this.py = dx.nz.ci();
            this.py.b(this);
            a(this.py);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.jR.bu()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.pv.getValue();
        com.airbnb.lottie.model.f fVar = this.jY.bk().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.lA != null) {
            this.pr.setColor(this.lA.getValue().intValue());
        } else {
            this.pr.setColor(value.color);
        }
        if (this.pw != null) {
            this.pt.setColor(this.pw.getValue().intValue());
        } else {
            this.pt.setColor(value.strokeColor);
        }
        int intValue = (this.lZ.ca().getValue().intValue() * 255) / 100;
        this.pr.setAlpha(intValue);
        this.pt.setAlpha(intValue);
        if (this.px != null) {
            this.pt.setStrokeWidth(this.px.getValue().floatValue());
        } else {
            this.pt.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.jY.bn());
        }
        if (this.jR.bu()) {
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
                com.airbnb.lottie.model.g gVar = this.jY.bj().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.getFamily(), fVar.cg()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.jY.bn() * c;
                    float f2 = dVar.tracking / 10.0f;
                    canvas.translate(((this.py != null ? this.py.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface g = this.jR.g(fVar.getFamily(), fVar.cg());
        if (g != null) {
            String str = dVar.text;
            l bt = this.jR.bt();
            String J = bt != null ? bt.J(str) : str;
            this.pr.setTypeface(g);
            this.pr.setTextSize(dVar.size * this.jY.bn());
            this.pt.setTypeface(this.pr.getTypeface());
            this.pt.setTextSize(this.pr.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.pp[0] = charAt;
                float f = dVar.tracking / 10.0f;
                canvas.translate(((this.py != null ? this.py.getValue().floatValue() + f : f) * c) + this.pr.measureText(this.pp, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.pq, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.nb)) * this.jY.bn());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (dVar.nc) {
                a(path, this.pr, canvas);
                a(path, this.pt, canvas);
            } else {
                a(path, this.pt, canvas);
                a(path, this.pr, canvas);
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
        this.pp[0] = c;
        if (dVar.nc) {
            a(this.pp, this.pr, canvas);
            a(this.pp, this.pt, canvas);
            return;
        }
        a(this.pp, this.pt, canvas);
        a(this.pp, this.pr, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.pu.containsKey(gVar)) {
            return this.pu.get(gVar);
        }
        List<j> ch = gVar.ch();
        int size = ch.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.jR, this, ch.get(i)));
        }
        this.pu.put(gVar, arrayList);
        return arrayList;
    }
}
