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
    private final Matrix matrix;
    private final com.airbnb.lottie.f mp;
    private final com.airbnb.lottie.e my;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> oa;
    private final char[] rK;
    private final RectF rL;
    private final Paint rM;
    private final Paint rN;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> rO;
    private final o rP;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> rQ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> rR;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> rS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.rK = new char[1];
        this.rL = new RectF();
        this.matrix = new Matrix();
        this.rM = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.rN = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.rO = new HashMap();
        this.mp = fVar;
        this.my = layer.cC();
        this.rP = layer.eD().dp();
        this.rP.b(this);
        a(this.rP);
        k eE = layer.eE();
        if (eE != null && eE.pX != null) {
            this.oa = eE.pX.dp();
            this.oa.b(this);
            a(this.oa);
        }
        if (eE != null && eE.pY != null) {
            this.rQ = eE.pY.dp();
            this.rQ.b(this);
            a(this.rQ);
        }
        if (eE != null && eE.pZ != null) {
            this.rR = eE.pZ.dp();
            this.rR.b(this);
            a(this.rR);
        }
        if (eE != null && eE.qa != null) {
            this.rS = eE.qa.dp();
            this.rS.b(this);
            a(this.rS);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.mp.cB()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.rP.getValue();
        com.airbnb.lottie.model.f fVar = this.my.cr().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.oa != null) {
            this.rM.setColor(this.oa.getValue().intValue());
        } else {
            this.rM.setColor(value.color);
        }
        if (this.rQ != null) {
            this.rN.setColor(this.rQ.getValue().intValue());
        } else {
            this.rN.setColor(value.strokeColor);
        }
        int intValue = (this.oC.dh().getValue().intValue() * 255) / 100;
        this.rM.setAlpha(intValue);
        this.rN.setAlpha(intValue);
        if (this.rR != null) {
            this.rN.setStrokeWidth(this.rR.getValue().floatValue());
        } else {
            this.rN.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.my.cu());
        }
        if (this.mp.cB()) {
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
                com.airbnb.lottie.model.g gVar = this.my.cq().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.getFamily(), fVar.dn()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.my.cu() * c;
                    float f2 = dVar.tracking / 10.0f;
                    canvas.translate(((this.rS != null ? this.rS.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface n = this.mp.n(fVar.getFamily(), fVar.dn());
        if (n != null) {
            String str = dVar.text;
            l cA = this.mp.cA();
            String aa = cA != null ? cA.aa(str) : str;
            this.rM.setTypeface(n);
            this.rM.setTextSize(dVar.size * this.my.cu());
            this.rN.setTypeface(this.rM.getTypeface());
            this.rN.setTextSize(this.rM.getTextSize());
            for (int i = 0; i < aa.length(); i++) {
                char charAt = aa.charAt(i);
                a(charAt, dVar, canvas);
                this.rK[0] = charAt;
                float f = dVar.tracking / 10.0f;
                canvas.translate(((this.rS != null ? this.rS.getValue().floatValue() + f : f) * c) + this.rM.measureText(this.rK, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.rL, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.pD)) * this.my.cu());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (dVar.pE) {
                a(path, this.rM, canvas);
                a(path, this.rN, canvas);
            } else {
                a(path, this.rN, canvas);
                a(path, this.rM, canvas);
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
        this.rK[0] = c;
        if (dVar.pE) {
            a(this.rK, this.rM, canvas);
            a(this.rK, this.rN, canvas);
            return;
        }
        a(this.rK, this.rN, canvas);
        a(this.rK, this.rM, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.rO.containsKey(gVar)) {
            return this.rO.get(gVar);
        }
        List<j> m6do = gVar.m6do();
        int size = m6do.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.mp, this, m6do.get(i)));
        }
        this.rO.put(gVar, arrayList);
        return arrayList;
    }
}
