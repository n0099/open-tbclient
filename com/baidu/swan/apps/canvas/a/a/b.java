package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes7.dex */
public class b implements Cloneable {
    CanvasView cAn;
    ak cAo;
    private Stack<b> cAk = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cAl = new TextPaint();
    Path mPath = new Path();
    boolean cAm = false;
    int cAp = -1;
    int cAq = 0;
    int cAr = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cAn = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cAl = new TextPaint(this.cAl);
        bVar.mPath = new Path(this.mPath);
        bVar.cAq = this.cAq;
        bVar.cAr = this.cAr;
        bVar.mStrokeColor = this.mStrokeColor;
        this.cAk.push(bVar);
    }

    public void ajQ() {
        if (!this.cAk.empty()) {
            b pop = this.cAk.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cAl = pop.cAl;
            this.mPath = pop.mPath;
            this.cAm = pop.cAm;
            this.cAk = pop.cAk;
            this.cAo = pop.cAo;
            this.cAp = pop.cAp;
            this.cAq = pop.cAq;
            this.cAr = pop.cAr;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.cAn != null && this.cAo != null && this.cAo.cAQ != null && !this.cAo.cAQ.ajS()) {
                paint.setShadowLayer(this.cAo.cBd, this.cAo.mOffsetX, this.cAo.mOffsetY, this.cAo.cAQ.getColor());
            }
            if (this.cAp >= 0 && this.cAp <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cAp) >> 8, 255));
            }
        }
    }

    public void hA(int i) {
        this.cAr = i;
    }

    public int ajR() {
        return this.cAr;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cAl.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ap.ah.M(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cAl.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
