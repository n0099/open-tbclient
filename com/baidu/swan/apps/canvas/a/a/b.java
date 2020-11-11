package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes10.dex */
public class b implements Cloneable {
    CanvasView cBX;
    ak cBY;
    private Stack<b> cBU = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cBV = new TextPaint();
    Path mPath = new Path();
    boolean cBW = false;
    int cBZ = -1;
    int cCa = 0;
    int cCb = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cBX = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cBV = new TextPaint(this.cBV);
        bVar.mPath = new Path(this.mPath);
        bVar.cCa = this.cCa;
        bVar.cCb = this.cCb;
        bVar.mStrokeColor = this.mStrokeColor;
        this.cBU.push(bVar);
    }

    public void aky() {
        if (!this.cBU.empty()) {
            b pop = this.cBU.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cBV = pop.cBV;
            this.mPath = pop.mPath;
            this.cBW = pop.cBW;
            this.cBU = pop.cBU;
            this.cBY = pop.cBY;
            this.cBZ = pop.cBZ;
            this.cCa = pop.cCa;
            this.cCb = pop.cCb;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.cBX != null && this.cBY != null && this.cBY.cCA != null && !this.cBY.cCA.akA()) {
                paint.setShadowLayer(this.cBY.cCN, this.cBY.mOffsetX, this.cBY.mOffsetY, this.cBY.cCA.getColor());
            }
            if (this.cBZ >= 0 && this.cBZ <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cBZ) >> 8, 255));
            }
        }
    }

    public void hE(int i) {
        this.cCb = i;
    }

    public int akz() {
        return this.cCb;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cBV.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ap.ah.N(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cBV.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
