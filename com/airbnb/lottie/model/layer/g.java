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
    private final com.airbnb.lottie.f nc;
    private final com.airbnb.lottie.e nj;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> oK;
    private final Paint sA;
    private final Paint sB;
    private final Map<com.airbnb.lottie.model.g, List<com.airbnb.lottie.a.a.c>> sC;
    private final o sD;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> sE;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> sF;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> sG;
    private final char[] sy;
    private final RectF sz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.sy = new char[1];
        this.sz = new RectF();
        this.matrix = new Matrix();
        this.sA = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.sB = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.sC = new HashMap();
        this.nc = fVar;
        this.nj = layer.cS();
        this.sD = layer.eT().dF();
        this.sD.b(this);
        a(this.sD);
        k eU = layer.eU();
        if (eU != null && eU.qH != null) {
            this.oK = eU.qH.dF();
            this.oK.b(this);
            a(this.oK);
        }
        if (eU != null && eU.qI != null) {
            this.sE = eU.qI.dF();
            this.sE.b(this);
            a(this.sE);
        }
        if (eU != null && eU.qJ != null) {
            this.sF = eU.qJ.dF();
            this.sF.b(this);
            a(this.sF);
        }
        if (eU != null && eU.qK != null) {
            this.sG = eU.qK.dF();
            this.sG.b(this);
            a(this.sG);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.nc.cR()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.d value = this.sD.getValue();
        com.airbnb.lottie.model.f fVar = this.nj.cH().get(value.fontName);
        if (fVar == null) {
            canvas.restore();
            return;
        }
        if (this.oK != null) {
            this.sA.setColor(this.oK.getValue().intValue());
        } else {
            this.sA.setColor(value.color);
        }
        if (this.sE != null) {
            this.sB.setColor(this.sE.getValue().intValue());
        } else {
            this.sB.setColor(value.strokeColor);
        }
        int intValue = (this.po.dx().getValue().intValue() * 255) / 100;
        this.sA.setAlpha(intValue);
        this.sB.setAlpha(intValue);
        if (this.sF != null) {
            this.sB.setStrokeWidth(this.sF.getValue().floatValue());
        } else {
            this.sB.setStrokeWidth(com.airbnb.lottie.c.f.c(matrix) * value.strokeWidth * this.nj.cK());
        }
        if (this.nc.cR()) {
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
                com.airbnb.lottie.model.g gVar = this.nj.cG().get(com.airbnb.lottie.model.g.a(str.charAt(i2), fVar.getFamily(), fVar.dD()));
                if (gVar != null) {
                    a(gVar, matrix, f, dVar, canvas);
                    float width = ((float) gVar.getWidth()) * f * this.nj.cK() * c;
                    float f2 = dVar.ql / 10.0f;
                    canvas.translate(((this.sG != null ? this.sG.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, com.airbnb.lottie.model.f fVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.c.f.c(matrix);
        Typeface n = this.nc.n(fVar.getFamily(), fVar.dD());
        if (n != null) {
            String str = dVar.text;
            l cQ = this.nc.cQ();
            String aa = cQ != null ? cQ.aa(str) : str;
            this.sA.setTypeface(n);
            this.sA.setTextSize(dVar.size * this.nj.cK());
            this.sB.setTypeface(this.sA.getTypeface());
            this.sB.setTextSize(this.sA.getTextSize());
            for (int i = 0; i < aa.length(); i++) {
                char charAt = aa.charAt(i);
                a(charAt, dVar, canvas);
                this.sy[0] = charAt;
                float f = dVar.ql / 10.0f;
                canvas.translate(((this.sG != null ? this.sG.getValue().floatValue() + f : f) * c) + this.sA.measureText(this.sy, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.g gVar, Matrix matrix, float f, com.airbnb.lottie.model.d dVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a = a(gVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.sz, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-dVar.qn)) * this.nj.cK());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (dVar.qo) {
                a(path, this.sA, canvas);
                a(path, this.sB, canvas);
            } else {
                a(path, this.sB, canvas);
                a(path, this.sA, canvas);
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
        this.sy[0] = c;
        if (dVar.qo) {
            a(this.sy, this.sA, canvas);
            a(this.sy, this.sB, canvas);
            return;
        }
        a(this.sy, this.sB, canvas);
        a(this.sy, this.sA, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.g gVar) {
        if (this.sC.containsKey(gVar)) {
            return this.sC.get(gVar);
        }
        List<j> dE = gVar.dE();
        int size = dE.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.nc, this, dE.get(i)));
        }
        this.sC.put(gVar, arrayList);
        return arrayList;
    }
}
