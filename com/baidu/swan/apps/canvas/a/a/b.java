package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes25.dex */
public class b implements Cloneable {
    CanvasView cHf;
    ak cHg;
    private Stack<b> cHc = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cHd = new TextPaint();
    Path mPath = new Path();
    boolean cHe = false;
    int cHh = -1;
    int cHi = 0;
    int cHj = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cHf = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cHd = new TextPaint(this.cHd);
        bVar.mPath = new Path(this.mPath);
        bVar.cHi = this.cHi;
        bVar.cHj = this.cHj;
        bVar.mStrokeColor = this.mStrokeColor;
        this.cHc.push(bVar);
    }

    public void amY() {
        if (!this.cHc.empty()) {
            b pop = this.cHc.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cHd = pop.cHd;
            this.mPath = pop.mPath;
            this.cHe = pop.cHe;
            this.cHc = pop.cHc;
            this.cHg = pop.cHg;
            this.cHh = pop.cHh;
            this.cHi = pop.cHi;
            this.cHj = pop.cHj;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.cHf != null && this.cHg != null && this.cHg.cHM != null && !this.cHg.cHM.ana()) {
                paint.setShadowLayer(this.cHg.cHZ, this.cHg.cHY, this.cHg.mOffsetY, this.cHg.cHM.getColor());
            }
            if (this.cHh >= 0 && this.cHh <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cHh) >> 8, 255));
            }
        }
    }

    public void hY(int i) {
        this.cHj = i;
    }

    public int amZ() {
        return this.cHj;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cHd.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ap.ah.M(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cHd.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
