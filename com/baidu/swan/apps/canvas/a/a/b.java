package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes8.dex */
public class b implements Cloneable {
    CanvasView cHk;
    ak cHl;
    private Stack<b> cHh = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cHi = new TextPaint();
    Path mPath = new Path();
    boolean cHj = false;
    int cHm = -1;
    int cHn = 0;
    int cHo = 0;
    int aDE = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cHk = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cHi = new TextPaint(this.cHi);
        bVar.mPath = new Path(this.mPath);
        bVar.cHn = this.cHn;
        bVar.cHo = this.cHo;
        bVar.aDE = this.aDE;
        this.cHh.push(bVar);
    }

    public void akp() {
        if (!this.cHh.empty()) {
            b pop = this.cHh.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cHi = pop.cHi;
            this.mPath = pop.mPath;
            this.cHj = pop.cHj;
            this.cHh = pop.cHh;
            this.cHl = pop.cHl;
            this.cHm = pop.cHm;
            this.cHn = pop.cHn;
            this.cHo = pop.cHo;
            this.aDE = pop.aDE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Paint paint) {
        if (paint != null) {
            if (this.cHk != null && this.cHl != null && this.cHl.cHQ != null && !this.cHl.cHQ.akr()) {
                paint.setShadowLayer(this.cHl.cIe, this.cHl.cIc, this.cHl.cId, this.cHl.cHQ.getColor());
            }
            if (this.cHm >= 0 && this.cHm <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cHm) >> 8, 255));
            }
        }
    }

    public void gl(int i) {
        this.cHo = i;
    }

    public int akq() {
        return this.cHo;
    }

    public void init() {
        this.aDE = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cHi.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ao.ah.O(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cHi.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
