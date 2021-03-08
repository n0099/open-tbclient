package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
/* loaded from: classes5.dex */
public class h extends a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> Ff;
    private final LongSparseArray<LinearGradient> Fg;
    private final LongSparseArray<RadialGradient> Fh;
    private final RectF Fj;
    private final GradientType Fk;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Fl;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Fm;
    private final int Fn;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.jt().toPaintCap(), eVar.ju().toPaintJoin(), eVar.jx(), eVar.jh(), eVar.js(), eVar.jv(), eVar.jw());
        this.Fg = new LongSparseArray<>();
        this.Fh = new LongSparseArray<>();
        this.Fj = new RectF();
        this.name = eVar.getName();
        this.Fk = eVar.jn();
        this.Fn = (int) (fVar.getComposition().hR() / 32.0f);
        this.Ff = eVar.jp().jb();
        this.Ff.b(this);
        aVar.a(this.Ff);
        this.Fl = eVar.jq().jb();
        this.Fl.b(this);
        aVar.a(this.Fl);
        this.Fm = eVar.jr().jb();
        this.Fm.b(this);
        aVar.a(this.Fm);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        d(this.Fj, matrix);
        if (this.Fk == GradientType.Linear) {
            this.paint.setShader(iv());
        } else {
            this.paint.setShader(iw());
        }
        super.c(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iv() {
        int ix = ix();
        LinearGradient linearGradient = this.Fg.get(ix);
        if (linearGradient == null) {
            PointF value = this.Fl.getValue();
            PointF value2 = this.Fm.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Ff.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Fj.left + (this.Fj.width() / 2.0f) + value.x), (int) (value.y + this.Fj.top + (this.Fj.height() / 2.0f)), (int) (this.Fj.left + (this.Fj.width() / 2.0f) + value2.x), (int) (this.Fj.top + (this.Fj.height() / 2.0f) + value2.y), value3.getColors(), value3.jm(), Shader.TileMode.CLAMP);
            this.Fg.put(ix, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iw() {
        int ix = ix();
        RadialGradient radialGradient = this.Fh.get(ix);
        if (radialGradient == null) {
            PointF value = this.Fl.getValue();
            PointF value2 = this.Fm.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Ff.getValue();
            int[] colors = value3.getColors();
            float[] jm = value3.jm();
            int width = (int) (this.Fj.left + (this.Fj.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Fj.top + (this.Fj.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Fj.left + (this.Fj.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Fj.top + (this.Fj.height() / 2.0f)))) - height), colors, jm, Shader.TileMode.CLAMP);
            this.Fh.put(ix, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int ix() {
        int round = Math.round(this.Fl.getProgress() * this.Fn);
        int round2 = Math.round(this.Fm.getProgress() * this.Fn);
        int round3 = Math.round(this.Ff.getProgress() * this.Fn);
        int i = 17;
        if (round != 0) {
            i = round * 527;
        }
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        if (round3 != 0) {
            return i * 31 * round3;
        }
        return i;
    }
}
