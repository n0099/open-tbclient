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
    private final com.airbnb.lottie.f jY;
    private final com.airbnb.lottie.e kg;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> lI;
    private final Matrix matrix;
    private final Paint pA;
    private final Paint pB;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> pC;
    private final o pD;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> pE;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> pF;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> pG;
    private final char[] pz;
    private final RectF rectF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.pz = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.pA = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.pB = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.pC = new HashMap();
        this.jY = fVar;
        this.kg = layer.bx();
        this.pD = layer.dy().ck();
        this.pD.b(this);
        a(this.pD);
        k dz = layer.dz();
        if (dz != null && dz.nF != null) {
            this.lI = dz.nF.ck();
            this.lI.b(this);
            a(this.lI);
        }
        if (dz != null && dz.nG != null) {
            this.pE = dz.nG.ck();
            this.pE.b(this);
            a(this.pE);
        }
        if (dz != null && dz.nH != null) {
            this.pF = dz.nH.ck();
            this.pF.b(this);
            a(this.pF);
        }
        if (dz != null && dz.nI != null) {
            this.pG = dz.nI.ck();
            this.pG.b(this);
            a(this.pG);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.jY.bw()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.pD.getValue();
        com.airbnb.lottie.model.f fVar = this.kg.bm().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.lI != null) {
            this.pA.setColor(this.lI.getValue().intValue());
        } else {
            this.pA.setColor(value.color);
        }
        if (this.pE != null) {
            this.pB.setColor(this.pE.getValue().intValue());
        } else {
            this.pB.setColor(value.strokeColor);
        }
        int intValue = (this.mi.cc().getValue().intValue() * 255) / 100;
        this.pA.setAlpha(intValue);
        this.pB.setAlpha(intValue);
        if (this.pF != null) {
            this.pB.setStrokeWidth(this.pF.getValue().floatValue());
        } else {
            this.pB.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.kg.bp());
        }
        if (this.jY.bw()) {
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
                com.airbnb.lottie.model.g gVar = this.kg.bl().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.getFamily(), fVar.ci()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.kg.bp() * c;
                    float f2 = dVar.tracking / 10.0f;
                    canvas.translate(((this.pG != null ? this.pG.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface g = this.jY.g(fVar.getFamily(), fVar.ci());
        if (g != null) {
            String str = dVar.text;
            l bv = this.jY.bv();
            String J = bv != null ? bv.J(str) : str;
            this.pA.setTypeface(g);
            this.pA.setTextSize(dVar.size * this.kg.bp());
            this.pB.setTypeface(this.pA.getTypeface());
            this.pB.setTextSize(this.pA.getTextSize());
            for (int i = 0; i < J.length(); i++) {
                char charAt = J.charAt(i);
                a(charAt, dVar, canvas);
                this.pz[0] = charAt;
                float f = dVar.tracking / 10.0f;
                canvas.translate(((this.pG != null ? this.pG.getValue().floatValue() + f : f) * c) + this.pA.measureText(this.pz, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.nk)) * this.kg.bp());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (dVar.nl) {
                a(path, this.pA, canvas);
                a(path, this.pB, canvas);
            } else {
                a(path, this.pB, canvas);
                a(path, this.pA, canvas);
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
        this.pz[0] = c;
        if (dVar.nl) {
            a(this.pz, this.pA, canvas);
            a(this.pz, this.pB, canvas);
            return;
        }
        a(this.pz, this.pB, canvas);
        a(this.pz, this.pA, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.pC.containsKey(gVar)) {
            return this.pC.get(gVar);
        }
        List<j> cj = gVar.cj();
        int size = cj.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.jY, this, cj.get(i)));
        }
        this.pC.put(gVar, arrayList);
        return arrayList;
    }
}
