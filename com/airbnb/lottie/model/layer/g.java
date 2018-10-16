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
    private final com.airbnb.lottie.f nh;
    private final com.airbnb.lottie.e np;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> oP;
    private final char[] sA;
    private final RectF sB;
    private final Paint sC;
    private final Paint sD;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> sE;
    private final o sF;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> sG;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> sH;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> sI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.sA = new char[1];
        this.sB = new RectF();
        this.matrix = new Matrix();
        this.sC = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.sD = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.sE = new HashMap();
        this.nh = fVar;
        this.np = layer.cU();
        this.sF = layer.eV().dH();
        this.sF.b(this);
        a(this.sF);
        k eW = layer.eW();
        if (eW != null && eW.qK != null) {
            this.oP = eW.qK.dH();
            this.oP.b(this);
            a(this.oP);
        }
        if (eW != null && eW.qL != null) {
            this.sG = eW.qL.dH();
            this.sG.b(this);
            a(this.sG);
        }
        if (eW != null && eW.qM != null) {
            this.sH = eW.qM.dH();
            this.sH.b(this);
            a(this.sH);
        }
        if (eW != null && eW.qN != null) {
            this.sI = eW.qN.dH();
            this.sI.b(this);
            a(this.sI);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.nh.cT()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.sF.getValue();
        com.airbnb.lottie.model.f fVar = this.np.cJ().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.oP != null) {
            this.sC.setColor(this.oP.getValue().intValue());
        } else {
            this.sC.setColor(value.color);
        }
        if (this.sG != null) {
            this.sD.setColor(this.sG.getValue().intValue());
        } else {
            this.sD.setColor(value.strokeColor);
        }
        int intValue = (this.pu.dz().getValue().intValue() * 255) / 100;
        this.sC.setAlpha(intValue);
        this.sD.setAlpha(intValue);
        if (this.sH != null) {
            this.sD.setStrokeWidth(this.sH.getValue().floatValue());
        } else {
            this.sD.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.np.cM());
        }
        if (this.nh.cT()) {
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
                com.airbnb.lottie.model.g gVar = this.np.cI().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.getFamily(), fVar.dF()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.np.cM() * c;
                    float f2 = dVar.tracking / 10.0f;
                    canvas.translate(((this.sI != null ? this.sI.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface n = this.nh.n(fVar.getFamily(), fVar.dF());
        if (n != null) {
            String str = dVar.text;
            l cS = this.nh.cS();
            String aa = cS != null ? cS.aa(str) : str;
            this.sC.setTypeface(n);
            this.sC.setTextSize(dVar.size * this.np.cM());
            this.sD.setTypeface(this.sC.getTypeface());
            this.sD.setTextSize(this.sC.getTextSize());
            for (int i = 0; i < aa.length(); i++) {
                char charAt = aa.charAt(i);
                a(charAt, dVar, canvas);
                this.sA[0] = charAt;
                float f = dVar.tracking / 10.0f;
                canvas.translate(((this.sI != null ? this.sI.getValue().floatValue() + f : f) * c) + this.sC.measureText(this.sA, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.sB, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.qq)) * this.np.cM());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (dVar.qr) {
                a(path, this.sC, canvas);
                a(path, this.sD, canvas);
            } else {
                a(path, this.sD, canvas);
                a(path, this.sC, canvas);
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
        this.sA[0] = c;
        if (dVar.qr) {
            a(this.sA, this.sC, canvas);
            a(this.sA, this.sD, canvas);
            return;
        }
        a(this.sA, this.sD, canvas);
        a(this.sA, this.sC, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.sE.containsKey(gVar)) {
            return this.sE.get(gVar);
        }
        List<j> dG = gVar.dG();
        int size = dG.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.nh, this, dG.get(i)));
        }
        this.sE.put(gVar, arrayList);
        return arrayList;
    }
}
