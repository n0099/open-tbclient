package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes10.dex */
public class b implements Cloneable {
    CanvasView bcg;
    ak bch;
    private Stack<b> bcd = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bce = new TextPaint();
    Path mPath = new Path();
    boolean bcf = false;
    int bci = -1;
    int bcj = 0;
    int bck = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bcg = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bce = new TextPaint(this.bce);
        bVar.mPath = new Path(this.mPath);
        bVar.bcj = this.bcj;
        bVar.bck = this.bck;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bcd.push(bVar);
    }

    public void HY() {
        if (!this.bcd.empty()) {
            b pop = this.bcd.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bce = pop.bce;
            this.mPath = pop.mPath;
            this.bcf = pop.bcf;
            this.bcd = pop.bcd;
            this.bch = pop.bch;
            this.bci = pop.bci;
            this.bcj = pop.bcj;
            this.bck = pop.bck;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bcg != null && this.bch != null && this.bch.bcJ != null && !this.bch.bcJ.Ia()) {
                paint.setShadowLayer(this.bch.bcW, this.bch.mOffsetX, this.bch.mOffsetY, this.bch.bcJ.getColor());
            }
            if (this.bci >= 0 && this.bci <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bci) >> 8, 255));
            }
        }
    }

    public void dM(int i) {
        this.bck = i;
    }

    public int HZ() {
        return this.bck;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bce.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.as.af.S(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bce.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
