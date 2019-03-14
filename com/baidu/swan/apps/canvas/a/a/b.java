package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView alj;
    ak alk;
    private Stack<b> alg = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint alh = new TextPaint();
    Path mPath = new Path();
    boolean ali = false;
    int alm = -1;
    int aln = 0;
    int alo = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.alj = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.alh = new TextPaint(this.alh);
        bVar.mPath = new Path(this.mPath);
        bVar.aln = this.aln;
        bVar.alo = this.alo;
        bVar.mStrokeColor = this.mStrokeColor;
        this.alg.push(bVar);
    }

    public void restore() {
        if (!this.alg.empty()) {
            b pop = this.alg.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.alh = pop.alh;
            this.mPath = pop.mPath;
            this.ali = pop.ali;
            this.alg = pop.alg;
            this.alk = pop.alk;
            this.alm = pop.alm;
            this.aln = pop.aln;
            this.alo = pop.alo;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.alj != null && this.alk != null && this.alk.alT != null && !this.alk.alT.wA()) {
                paint.setShadowLayer(this.alk.amj, this.alk.amh, this.alk.ami, this.alk.alT.getColor());
            }
            if (this.alm >= 0 && this.alm <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.alm) >> 8, 255));
            }
        }
    }

    public void bR(int i) {
        this.alo = i;
    }

    public int wz() {
        return this.alo;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.alh.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.x.ad(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.alh.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
