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
    private final char[] sC;
    private final RectF sD;
    private final Paint sE;
    private final Paint sF;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> sG;
    private final o sH;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> sI;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> sJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> sK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.sC = new char[1];
        this.sD = new RectF();
        this.matrix = new Matrix();
        this.sE = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.sF = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.sG = new HashMap();
        this.nh = fVar;
        this.np = layer.cT();
        this.sH = layer.eU().dG();
        this.sH.b(this);
        a(this.sH);
        k eV = layer.eV();
        if (eV != null && eV.qL != null) {
            this.oP = eV.qL.dG();
            this.oP.b(this);
            a(this.oP);
        }
        if (eV != null && eV.qM != null) {
            this.sI = eV.qM.dG();
            this.sI.b(this);
            a(this.sI);
        }
        if (eV != null && eV.qN != null) {
            this.sJ = eV.qN.dG();
            this.sJ.b(this);
            a(this.sJ);
        }
        if (eV != null && eV.qO != null) {
            this.sK = eV.qO.dG();
            this.sK.b(this);
            a(this.sK);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.nh.cS()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.sH.getValue();
        com.airbnb.lottie.model.f fVar = this.np.cI().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.oP != null) {
            this.sE.setColor(this.oP.getValue().intValue());
        } else {
            this.sE.setColor(value.color);
        }
        if (this.sI != null) {
            this.sF.setColor(this.sI.getValue().intValue());
        } else {
            this.sF.setColor(value.strokeColor);
        }
        int intValue = (this.pv.dy().getValue().intValue() * 255) / 100;
        this.sE.setAlpha(intValue);
        this.sF.setAlpha(intValue);
        if (this.sJ != null) {
            this.sF.setStrokeWidth(this.sJ.getValue().floatValue());
        } else {
            this.sF.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.np.cL());
        }
        if (this.nh.cS()) {
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
                com.airbnb.lottie.model.g gVar = this.np.cH().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.getFamily(), fVar.dE()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.np.cL() * c;
                    float f2 = dVar.tracking / 10.0f;
                    canvas.translate(((this.sK != null ? this.sK.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface n = this.nh.n(fVar.getFamily(), fVar.dE());
        if (n != null) {
            String str = dVar.text;
            l cR = this.nh.cR();
            String aa = cR != null ? cR.aa(str) : str;
            this.sE.setTypeface(n);
            this.sE.setTextSize(dVar.size * this.np.cL());
            this.sF.setTypeface(this.sE.getTypeface());
            this.sF.setTextSize(this.sE.getTextSize());
            for (int i = 0; i < aa.length(); i++) {
                char charAt = aa.charAt(i);
                a(charAt, dVar, canvas);
                this.sC[0] = charAt;
                float f = dVar.tracking / 10.0f;
                canvas.translate(((this.sK != null ? this.sK.getValue().floatValue() + f : f) * c) + this.sE.measureText(this.sC, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.sD, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.qr)) * this.np.cL());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (dVar.qs) {
                a(path, this.sE, canvas);
                a(path, this.sF, canvas);
            } else {
                a(path, this.sF, canvas);
                a(path, this.sE, canvas);
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
        this.sC[0] = c;
        if (dVar.qs) {
            a(this.sC, this.sE, canvas);
            a(this.sC, this.sF, canvas);
            return;
        }
        a(this.sC, this.sF, canvas);
        a(this.sC, this.sE, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.sG.containsKey(gVar)) {
            return this.sG.get(gVar);
        }
        List<j> dF = gVar.dF();
        int size = dF.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.nh, this, dF.get(i)));
        }
        this.sG.put(gVar, arrayList);
        return arrayList;
    }
}
