package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    CanvasView bNS;
    ak bNT;
    private Stack<b> bNP = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bNQ = new TextPaint();
    Path mPath = new Path();
    boolean bNR = false;
    int bNU = -1;
    int bNV = 0;
    int bNW = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bNS = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bNQ = new TextPaint(this.bNQ);
        bVar.mPath = new Path(this.mPath);
        bVar.bNV = this.bNV;
        bVar.bNW = this.bNW;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bNP.push(bVar);
    }

    public void UR() {
        if (!this.bNP.empty()) {
            b pop = this.bNP.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bNQ = pop.bNQ;
            this.mPath = pop.mPath;
            this.bNR = pop.bNR;
            this.bNP = pop.bNP;
            this.bNT = pop.bNT;
            this.bNU = pop.bNU;
            this.bNV = pop.bNV;
            this.bNW = pop.bNW;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bNS != null && this.bNT != null && this.bNT.bOv != null && !this.bNT.bOv.UT()) {
                paint.setShadowLayer(this.bNT.bOI, this.bNT.mOffsetX, this.bNT.mOffsetY, this.bNT.bOv.getColor());
            }
            if (this.bNU >= 0 && this.bNU <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bNU) >> 8, 255));
            }
        }
    }

    public void eq(int i) {
        this.bNW = i;
    }

    public int US() {
        return this.bNW;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bNQ.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.aq.ag.B(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bNQ.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
