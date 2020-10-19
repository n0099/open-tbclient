package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes10.dex */
public class b implements Cloneable {
    CanvasView cnB;
    ak cnC;
    private Stack<b> cny = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cnz = new TextPaint();
    Path mPath = new Path();
    boolean cnA = false;
    int cnD = -1;
    int cnE = 0;
    int cnF = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cnB = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cnz = new TextPaint(this.cnz);
        bVar.mPath = new Path(this.mPath);
        bVar.cnE = this.cnE;
        bVar.cnF = this.cnF;
        bVar.mStrokeColor = this.mStrokeColor;
        this.cny.push(bVar);
    }

    public void age() {
        if (!this.cny.empty()) {
            b pop = this.cny.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cnz = pop.cnz;
            this.mPath = pop.mPath;
            this.cnA = pop.cnA;
            this.cny = pop.cny;
            this.cnC = pop.cnC;
            this.cnD = pop.cnD;
            this.cnE = pop.cnE;
            this.cnF = pop.cnF;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.cnB != null && this.cnC != null && this.cnC.coe != null && !this.cnC.coe.agg()) {
                paint.setShadowLayer(this.cnC.cos, this.cnC.mOffsetX, this.cnC.mOffsetY, this.cnC.coe.getColor());
            }
            if (this.cnD >= 0 && this.cnD <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cnD) >> 8, 255));
            }
        }
    }

    public void hj(int i) {
        this.cnF = i;
    }

    public int agf() {
        return this.cnF;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cnz.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ap.ah.J(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cnz.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
