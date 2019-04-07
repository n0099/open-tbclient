package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView alo;
    ak alp;
    private Stack<b> alk = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint alm = new TextPaint();
    Path mPath = new Path();
    boolean aln = false;
    int alq = -1;
    int alr = 0;
    int als = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.alo = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.alm = new TextPaint(this.alm);
        bVar.mPath = new Path(this.mPath);
        bVar.alr = this.alr;
        bVar.als = this.als;
        bVar.mStrokeColor = this.mStrokeColor;
        this.alk.push(bVar);
    }

    public void restore() {
        if (!this.alk.empty()) {
            b pop = this.alk.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.alm = pop.alm;
            this.mPath = pop.mPath;
            this.aln = pop.aln;
            this.alk = pop.alk;
            this.alp = pop.alp;
            this.alq = pop.alq;
            this.alr = pop.alr;
            this.als = pop.als;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.alo != null && this.alp != null && this.alp.alX != null && !this.alp.alX.wz()) {
                paint.setShadowLayer(this.alp.amn, this.alp.aml, this.alp.amm, this.alp.alX.getColor());
            }
            if (this.alq >= 0 && this.alq <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.alq) >> 8, 255));
            }
        }
    }

    public void bQ(int i) {
        this.als = i;
    }

    public int wy() {
        return this.als;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.alm.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.x.ad(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.alm.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
