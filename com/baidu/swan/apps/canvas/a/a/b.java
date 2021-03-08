package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes8.dex */
public class b implements Cloneable {
    CanvasView cLe;
    ak cLf;
    private Stack<b> cLb = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cLc = new TextPaint();
    Path mPath = new Path();
    boolean cLd = false;
    int cLg = -1;
    int cLh = 0;
    int cLi = 0;
    int aGR = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cLe = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cLc = new TextPaint(this.cLc);
        bVar.mPath = new Path(this.mPath);
        bVar.cLh = this.cLh;
        bVar.cLi = this.cLi;
        bVar.aGR = this.aGR;
        this.cLb.push(bVar);
    }

    public void akQ() {
        if (!this.cLb.empty()) {
            b pop = this.cLb.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cLc = pop.cLc;
            this.mPath = pop.mPath;
            this.cLd = pop.cLd;
            this.cLb = pop.cLb;
            this.cLf = pop.cLf;
            this.cLg = pop.cLg;
            this.cLh = pop.cLh;
            this.cLi = pop.cLi;
            this.aGR = pop.aGR;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Paint paint) {
        if (paint != null) {
            if (this.cLe != null && this.cLf != null && this.cLf.cLI != null && !this.cLf.cLI.akS()) {
                paint.setShadowLayer(this.cLf.cLU, this.cLf.mOffsetX, this.cLf.mOffsetY, this.cLf.cLI.getColor());
            }
            if (this.cLg >= 0 && this.cLg <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cLg) >> 8, 255));
            }
        }
    }

    public void gq(int i) {
        this.cLi = i;
    }

    public int akR() {
        return this.cLi;
    }

    public void init() {
        this.aGR = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cLc.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ao.ah.T(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cLc.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
