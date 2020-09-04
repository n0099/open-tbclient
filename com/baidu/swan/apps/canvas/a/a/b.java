package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes8.dex */
public class b implements Cloneable {
    CanvasView bZk;
    ak bZl;
    private Stack<b> bZh = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bZi = new TextPaint();
    Path mPath = new Path();
    boolean bZj = false;
    int bZm = -1;
    int bZn = 0;
    int bZo = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bZk = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bZi = new TextPaint(this.bZi);
        bVar.mPath = new Path(this.mPath);
        bVar.bZn = this.bZn;
        bVar.bZo = this.bZo;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bZh.push(bVar);
    }

    public void acK() {
        if (!this.bZh.empty()) {
            b pop = this.bZh.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bZi = pop.bZi;
            this.mPath = pop.mPath;
            this.bZj = pop.bZj;
            this.bZh = pop.bZh;
            this.bZl = pop.bZl;
            this.bZm = pop.bZm;
            this.bZn = pop.bZn;
            this.bZo = pop.bZo;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bZk != null && this.bZl != null && this.bZl.bZN != null && !this.bZl.bZN.acM()) {
                paint.setShadowLayer(this.bZl.caa, this.bZl.mOffsetX, this.bZl.mOffsetY, this.bZl.bZN.getColor());
            }
            if (this.bZm >= 0 && this.bZm <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bZm) >> 8, 255));
            }
        }
    }

    public void gD(int i) {
        this.bZo = i;
    }

    public int acL() {
        return this.bZo;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bZi.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ap.ah.H(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bZi.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
