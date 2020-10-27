package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes10.dex */
public class b implements Cloneable {
    CanvasView cwe;
    ak cwf;
    private Stack<b> cwb = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cwc = new TextPaint();
    Path mPath = new Path();
    boolean cwd = false;
    int cwg = -1;
    int cwh = 0;
    int cwi = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cwe = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cwc = new TextPaint(this.cwc);
        bVar.mPath = new Path(this.mPath);
        bVar.cwh = this.cwh;
        bVar.cwi = this.cwi;
        bVar.mStrokeColor = this.mStrokeColor;
        this.cwb.push(bVar);
    }

    public void ahY() {
        if (!this.cwb.empty()) {
            b pop = this.cwb.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cwc = pop.cwc;
            this.mPath = pop.mPath;
            this.cwd = pop.cwd;
            this.cwb = pop.cwb;
            this.cwf = pop.cwf;
            this.cwg = pop.cwg;
            this.cwh = pop.cwh;
            this.cwi = pop.cwi;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.cwe != null && this.cwf != null && this.cwf.cwH != null && !this.cwf.cwH.aia()) {
                paint.setShadowLayer(this.cwf.cwU, this.cwf.mOffsetX, this.cwf.mOffsetY, this.cwf.cwH.getColor());
            }
            if (this.cwg >= 0 && this.cwg <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cwg) >> 8, 255));
            }
        }
    }

    public void hu(int i) {
        this.cwi = i;
    }

    public int ahZ() {
        return this.cwi;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cwc.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ap.ah.L(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cwc.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
