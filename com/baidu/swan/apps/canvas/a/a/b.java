package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes9.dex */
public class b implements Cloneable {
    CanvasView cJE;
    ak cJF;
    private Stack<b> cJB = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cJC = new TextPaint();
    Path mPath = new Path();
    boolean cJD = false;
    int cJG = -1;
    int cJH = 0;
    int cJI = 0;
    int aFr = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cJE = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cJC = new TextPaint(this.cJC);
        bVar.mPath = new Path(this.mPath);
        bVar.cJH = this.cJH;
        bVar.cJI = this.cJI;
        bVar.aFr = this.aFr;
        this.cJB.push(bVar);
    }

    public void akN() {
        if (!this.cJB.empty()) {
            b pop = this.cJB.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cJC = pop.cJC;
            this.mPath = pop.mPath;
            this.cJD = pop.cJD;
            this.cJB = pop.cJB;
            this.cJF = pop.cJF;
            this.cJG = pop.cJG;
            this.cJH = pop.cJH;
            this.cJI = pop.cJI;
            this.aFr = pop.aFr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Paint paint) {
        if (paint != null) {
            if (this.cJE != null && this.cJF != null && this.cJF.cKi != null && !this.cJF.cKi.akP()) {
                paint.setShadowLayer(this.cJF.cKu, this.cJF.mOffsetX, this.cJF.mOffsetY, this.cJF.cKi.getColor());
            }
            if (this.cJG >= 0 && this.cJG <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cJG) >> 8, 255));
            }
        }
    }

    public void gp(int i) {
        this.cJI = i;
    }

    public int akO() {
        return this.cJI;
    }

    public void init() {
        this.aFr = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cJC.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ao.ah.P(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cJC.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
