package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView ali;
    ak alj;
    private Stack<b> alf = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint alg = new TextPaint();
    Path mPath = new Path();
    boolean alh = false;
    int alk = -1;
    int alm = 0;
    int aln = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.ali = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.alg = new TextPaint(this.alg);
        bVar.mPath = new Path(this.mPath);
        bVar.alm = this.alm;
        bVar.aln = this.aln;
        bVar.mStrokeColor = this.mStrokeColor;
        this.alf.push(bVar);
    }

    public void restore() {
        if (!this.alf.empty()) {
            b pop = this.alf.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.alg = pop.alg;
            this.mPath = pop.mPath;
            this.alh = pop.alh;
            this.alf = pop.alf;
            this.alj = pop.alj;
            this.alk = pop.alk;
            this.alm = pop.alm;
            this.aln = pop.aln;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.ali != null && this.alj != null && this.alj.alS != null && !this.alj.alS.wA()) {
                paint.setShadowLayer(this.alj.ami, this.alj.amg, this.alj.amh, this.alj.alS.getColor());
            }
            if (this.alk >= 0 && this.alk <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.alk) >> 8, 255));
            }
        }
    }

    public void bR(int i) {
        this.aln = i;
    }

    public int wz() {
        return this.aln;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.alg.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.x.ad(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.alg.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
