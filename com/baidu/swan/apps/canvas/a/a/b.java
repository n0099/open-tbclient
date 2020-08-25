package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes8.dex */
public class b implements Cloneable {
    CanvasView bZg;
    ak bZh;
    private Stack<b> bZd = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bZe = new TextPaint();
    Path mPath = new Path();
    boolean bZf = false;
    int bZi = -1;
    int bZj = 0;
    int bZk = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bZg = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bZe = new TextPaint(this.bZe);
        bVar.mPath = new Path(this.mPath);
        bVar.bZj = this.bZj;
        bVar.bZk = this.bZk;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bZd.push(bVar);
    }

    public void acK() {
        if (!this.bZd.empty()) {
            b pop = this.bZd.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bZe = pop.bZe;
            this.mPath = pop.mPath;
            this.bZf = pop.bZf;
            this.bZd = pop.bZd;
            this.bZh = pop.bZh;
            this.bZi = pop.bZi;
            this.bZj = pop.bZj;
            this.bZk = pop.bZk;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bZg != null && this.bZh != null && this.bZh.bZJ != null && !this.bZh.bZJ.acM()) {
                paint.setShadowLayer(this.bZh.bZW, this.bZh.mOffsetX, this.bZh.mOffsetY, this.bZh.bZJ.getColor());
            }
            if (this.bZi >= 0 && this.bZi <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bZi) >> 8, 255));
            }
        }
    }

    public void gD(int i) {
        this.bZk = i;
    }

    public int acL() {
        return this.bZk;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bZe.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ap.ah.H(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bZe.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
