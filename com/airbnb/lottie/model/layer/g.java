package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class g extends a {
    private final com.airbnb.lottie.f Df;
    private final com.airbnb.lottie.d Dh;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> Ff;
    private final Paint IB;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.a.a.c>> IC;
    private final n IE;
    @Nullable
    private com.airbnb.lottie.a.b.a<Integer, Integer> IF;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> IG;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> IH;
    private final char[] Iz;
    private final Matrix matrix;
    private final RectF rectF;
    private final Paint strokePaint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.Iz = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.IB = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(1) { // from class: com.airbnb.lottie.model.layer.g.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.IC = new HashMap();
        this.Df = fVar;
        this.Dh = layer.getComposition();
        this.IE = layer.kg().jb();
        this.IE.b(this);
        a(this.IE);
        k kh = layer.kh();
        if (kh != null && kh.GM != null) {
            this.Ff = kh.GM.jb();
            this.Ff.b(this);
            a(this.Ff);
        }
        if (kh != null && kh.GN != null) {
            this.IF = kh.GN.jb();
            this.IF.b(this);
            a(this.IF);
        }
        if (kh != null && kh.GO != null) {
            this.IG = kh.GO.jb();
            this.IG.b(this);
            a(this.IG);
        }
        if (kh != null && kh.GP != null) {
            this.IH = kh.GP.jb();
            this.IH.b(this);
            a(this.IH);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.Df.ig()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b value = this.IE.getValue();
        com.airbnb.lottie.model.c cVar = this.Dh.hX().get(value.fontName);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.Ff != null) {
            this.IB.setColor(this.Ff.getValue().intValue());
        } else {
            this.IB.setColor(value.color);
        }
        if (this.IF != null) {
            this.strokePaint.setColor(this.IF.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int intValue = (this.FD.iP().getValue().intValue() * 255) / 100;
        this.IB.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        if (this.IG != null) {
            this.strokePaint.setStrokeWidth(this.IG.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (value.Gz * com.airbnb.lottie.d.f.kz() * com.airbnb.lottie.d.f.c(matrix)));
        }
        if (this.Df.ig()) {
            a(value, matrix, cVar, canvas);
        } else {
            a(value, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.Gv) / 100.0f;
        float c = com.airbnb.lottie.d.f.c(matrix);
        String str = bVar.text;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < str.length()) {
                com.airbnb.lottie.model.d dVar = this.Dh.hW().get(com.airbnb.lottie.model.d.b(str.charAt(i2), cVar.iV(), cVar.iW()));
                if (dVar != null) {
                    a(dVar, matrix, f, bVar, canvas);
                    float width = ((float) dVar.getWidth()) * f * com.airbnb.lottie.d.f.kz() * c;
                    float f2 = bVar.tracking / 10.0f;
                    canvas.translate(((this.IH != null ? this.IH.getValue().floatValue() + f2 : f2) * c) + width, 0.0f);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void a(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float c = com.airbnb.lottie.d.f.c(matrix);
        Typeface n = this.Df.n(cVar.iV(), cVar.iW());
        if (n != null) {
            String str = bVar.text;
            p m6if = this.Df.m6if();
            String bl = m6if != null ? m6if.bl(str) : str;
            this.IB.setTypeface(n);
            this.IB.setTextSize((float) (bVar.Gv * com.airbnb.lottie.d.f.kz()));
            this.strokePaint.setTypeface(this.IB.getTypeface());
            this.strokePaint.setTextSize(this.IB.getTextSize());
            for (int i = 0; i < bl.length(); i++) {
                char charAt = bl.charAt(i);
                a(charAt, bVar, canvas);
                this.Iz[0] = charAt;
                float f = bVar.tracking / 10.0f;
                canvas.translate(((this.IH != null ? this.IH.getValue().floatValue() + f : f) * c) + this.IB.measureText(this.Iz, 0, 1), 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.model.d dVar, Matrix matrix, float f, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.c> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path iu = a2.get(i).iu();
            iu.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.Gy)) * com.airbnb.lottie.d.f.kz());
            this.matrix.preScale(f, f);
            iu.transform(this.matrix);
            if (bVar.GA) {
                b(iu, this.IB, canvas);
                b(iu, this.strokePaint, canvas);
            } else {
                b(iu, this.strokePaint, canvas);
                b(iu, this.IB, canvas);
            }
        }
    }

    private void b(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void a(char c, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        this.Iz[0] = c;
        if (bVar.GA) {
            b(this.Iz, this.IB, canvas);
            b(this.Iz, this.strokePaint, canvas);
            return;
        }
        b(this.Iz, this.strokePaint, canvas);
        b(this.Iz, this.IB, canvas);
    }

    private void b(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.c> a(com.airbnb.lottie.model.d dVar) {
        if (this.IC.containsKey(dVar)) {
            return this.IC.get(dVar);
        }
        List<j> iX = dVar.iX();
        int size = iX.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.a.a.c(this.Df, this, iX.get(i)));
        }
        this.IC.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((g) t, (com.airbnb.lottie.e.c<g>) cVar);
        if (t == com.airbnb.lottie.j.Ea && this.Ff != null) {
            this.Ff.a(cVar);
        } else if (t == com.airbnb.lottie.j.Eb && this.IF != null) {
            this.IF.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ek && this.IG != null) {
            this.IG.a(cVar);
        } else if (t == com.airbnb.lottie.j.El && this.IH != null) {
            this.IH.a(cVar);
        }
    }
}
