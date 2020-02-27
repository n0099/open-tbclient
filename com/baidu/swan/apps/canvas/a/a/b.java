package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    CanvasView bgv;
    ak bgw;
    private Stack<b> bgr = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bgt = new TextPaint();
    Path mPath = new Path();
    boolean bgu = false;
    int bgx = -1;
    int bgy = 0;
    int bgz = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bgv = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bgt = new TextPaint(this.bgt);
        bVar.mPath = new Path(this.mPath);
        bVar.bgy = this.bgy;
        bVar.bgz = this.bgz;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bgr.push(bVar);
    }

    public void Kn() {
        if (!this.bgr.empty()) {
            b pop = this.bgr.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bgt = pop.bgt;
            this.mPath = pop.mPath;
            this.bgu = pop.bgu;
            this.bgr = pop.bgr;
            this.bgw = pop.bgw;
            this.bgx = pop.bgx;
            this.bgy = pop.bgy;
            this.bgz = pop.bgz;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bgv != null && this.bgw != null && this.bgw.bgY != null && !this.bgw.bgY.Kp()) {
                paint.setShadowLayer(this.bgw.bhl, this.bgw.mOffsetX, this.bgw.mOffsetY, this.bgw.bgY.getColor());
            }
            if (this.bgx >= 0 && this.bgx <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bgx) >> 8, 255));
            }
        }
    }

    public void ec(int i) {
        this.bgz = i;
    }

    public int Ko() {
        return this.bgz;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bgt.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.as.af.S(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bgt.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
