package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView alB;
    ak alC;
    private Stack<b> aly = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint alz = new TextPaint();
    Path mPath = new Path();
    boolean alA = false;
    int alD = -1;
    int alE = 0;
    int alF = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.alB = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.alz = new TextPaint(this.alz);
        bVar.mPath = new Path(this.mPath);
        bVar.alE = this.alE;
        bVar.alF = this.alF;
        bVar.mStrokeColor = this.mStrokeColor;
        this.aly.push(bVar);
    }

    public void restore() {
        if (!this.aly.empty()) {
            b pop = this.aly.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.alz = pop.alz;
            this.mPath = pop.mPath;
            this.alA = pop.alA;
            this.aly = pop.aly;
            this.alC = pop.alC;
            this.alD = pop.alD;
            this.alE = pop.alE;
            this.alF = pop.alF;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.alB != null && this.alC != null && this.alC.amk != null && !this.alC.amk.xr()) {
                paint.setShadowLayer(this.alC.amA, this.alC.amy, this.alC.amz, this.alC.amk.getColor());
            }
            if (this.alD >= 0 && this.alD <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.alD) >> 8, 255));
            }
        }
    }

    public void bQ(int i) {
        this.alF = i;
    }

    public int xq() {
        return this.alF;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.alz.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.z.ad(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.alz.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
