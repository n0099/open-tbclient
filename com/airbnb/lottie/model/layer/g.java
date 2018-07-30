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
    private final com.airbnb.lottie.f jQ;
    private final com.airbnb.lottie.e jX;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> ly;
    private final Matrix matrix;
    private final char[] po;
    private final RectF pp;
    private final Paint pq;
    private final Paint pr;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> pt;
    private final o pu;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> pv;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> pw;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> px;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.po = new char[1];
        this.pp = new RectF();
        this.matrix = new Matrix();
        this.pq = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.pr = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.pt = new HashMap();
        this.jQ = fVar;
        this.jX = layer.bv();
        this.pu = layer.dw().ci();
        this.pu.b(this);
        a(this.pu);
        k dx = layer.dx();
        if (dx != null && dx.nv != null) {
            this.ly = dx.nv.ci();
            this.ly.b(this);
            a(this.ly);
        }
        if (dx != null && dx.nw != null) {
            this.pv = dx.nw.ci();
            this.pv.b(this);
            a(this.pv);
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
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.jQ.bu()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.pu.getValue();
        com.airbnb.lottie.model.f fVar = this.jX.bk().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.ly != null) {
            this.pq.setColor(this.ly.getValue().intValue());
        } else {
            this.pq.setColor(value.color);
        }
        if (this.pv != null) {
            this.pr.setColor(this.pv.getValue().intValue());
        } else {
            this.pr.setColor(value.strokeColor);
        }
        int intValue = (this.lY.ca().getValue().intValue() * 255) / 100;
        this.pq.setAlpha(intValue);
        this.pr.setAlpha(intValue);
        if (this.pw != null) {
            this.pr.setStrokeWidth(this.pw.getValue().floatValue());
        } else {
            this.pr.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.jX.bn());
        }
        if (this.jQ.bu()) {
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
                com.airbnb.lottie.model.g gVar = this.jX.bj().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.getFamily(), fVar.cg()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.jX.bn() * c;
                    float f2 = dVar.tracking / 10.0f;
                    canvas.translate(((this.px != null ? this.px.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface g = this.jQ.g(fVar.getFamily(), fVar.cg());
        if (g != null) {
            String str = dVar.text;
            l bt = this.jQ.bt();
            String J = bt != null ? bt.J(str) : str;
            this.pq.setTypeface(g);
            this.pq.setTextSize(dVar.size * this.jX.bn());
            this.pr.setTypeface(this.pq.getTypeface());
            this.pr.setTextSize(this.pq.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.po[0] = charAt;
                float f = dVar.tracking / 10.0f;
                canvas.translate(((this.px != null ? this.px.getValue().floatValue() + f : f) * c) + this.pq.measureText(this.po, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.pp, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.na)) * this.jX.bn());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (dVar.nb) {
                a(path, this.pq, canvas);
                a(path, this.pr, canvas);
            } else {
                a(path, this.pr, canvas);
                a(path, this.pq, canvas);
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
        this.po[0] = c;
        if (dVar.nb) {
            a(this.po, this.pq, canvas);
            a(this.po, this.pr, canvas);
            return;
        }
        a(this.po, this.pr, canvas);
        a(this.po, this.pq, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.pt.containsKey(gVar)) {
            return this.pt.get(gVar);
        }
        List<j> ch = gVar.ch();
        int size = ch.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.jQ, this, ch.get(i)));
        }
        this.pt.put(gVar, arrayList);
        return arrayList;
    }
}
