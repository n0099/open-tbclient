package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView aFD;
    ak aFE;
    private Stack<b> aFA = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint aFB = new TextPaint();
    Path mPath = new Path();
    boolean aFC = false;
    int aFF = -1;
    int aFG = 0;
    int aFH = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.aFD = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.aFB = new TextPaint(this.aFB);
        bVar.mPath = new Path(this.mPath);
        bVar.aFG = this.aFG;
        bVar.aFH = this.aFH;
        bVar.mStrokeColor = this.mStrokeColor;
        this.aFA.push(bVar);
    }

    public void CS() {
        if (!this.aFA.empty()) {
            b pop = this.aFA.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.aFB = pop.aFB;
            this.mPath = pop.mPath;
            this.aFC = pop.aFC;
            this.aFA = pop.aFA;
            this.aFE = pop.aFE;
            this.aFF = pop.aFF;
            this.aFG = pop.aFG;
            this.aFH = pop.aFH;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.aFD != null && this.aFE != null && this.aFE.aGl != null && !this.aFE.aGl.CU()) {
                paint.setShadowLayer(this.aFE.aGA, this.aFE.aGy, this.aFE.aGz, this.aFE.aGl.getColor());
            }
            if (this.aFF >= 0 && this.aFF <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.aFF) >> 8, 255));
            }
        }
    }

    public void cN(int i) {
        this.aFH = i;
    }

    public int CT() {
        return this.aFH;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aFB.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.z.S(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.aFB.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
