package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView alp;
    ak alq;
    private Stack<b> alm = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint aln = new TextPaint();
    Path mPath = new Path();
    boolean alo = false;
    int alr = -1;
    int als = 0;
    int alt = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.alp = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.aln = new TextPaint(this.aln);
        bVar.mPath = new Path(this.mPath);
        bVar.als = this.als;
        bVar.alt = this.alt;
        bVar.mStrokeColor = this.mStrokeColor;
        this.alm.push(bVar);
    }

    public void restore() {
        if (!this.alm.empty()) {
            b pop = this.alm.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.aln = pop.aln;
            this.mPath = pop.mPath;
            this.alo = pop.alo;
            this.alm = pop.alm;
            this.alq = pop.alq;
            this.alr = pop.alr;
            this.als = pop.als;
            this.alt = pop.alt;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.alp != null && this.alq != null && this.alq.alY != null && !this.alq.alY.wz()) {
                paint.setShadowLayer(this.alq.amo, this.alq.amm, this.alq.amn, this.alq.alY.getColor());
            }
            if (this.alr >= 0 && this.alr <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.alr) >> 8, 255));
            }
        }
    }

    public void bQ(int i) {
        this.alt = i;
    }

    public int wy() {
        return this.alt;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aln.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.x.ad(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.aln.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
