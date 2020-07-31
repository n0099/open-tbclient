package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes7.dex */
public class b implements Cloneable {
    CanvasView bTy;
    ak bTz;
    private Stack<b> bTv = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bTw = new TextPaint();
    Path mPath = new Path();
    boolean bTx = false;
    int bTA = -1;
    int bTB = 0;
    int bTC = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bTy = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bTw = new TextPaint(this.bTw);
        bVar.mPath = new Path(this.mPath);
        bVar.bTB = this.bTB;
        bVar.bTC = this.bTC;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bTv.push(bVar);
    }

    public void WE() {
        if (!this.bTv.empty()) {
            b pop = this.bTv.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bTw = pop.bTw;
            this.mPath = pop.mPath;
            this.bTx = pop.bTx;
            this.bTv = pop.bTv;
            this.bTz = pop.bTz;
            this.bTA = pop.bTA;
            this.bTB = pop.bTB;
            this.bTC = pop.bTC;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bTy != null && this.bTz != null && this.bTz.bUb != null && !this.bTz.bUb.WG()) {
                paint.setShadowLayer(this.bTz.bUo, this.bTz.mOffsetX, this.bTz.mOffsetY, this.bTz.bUb.getColor());
            }
            if (this.bTA >= 0 && this.bTA <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bTA) >> 8, 255));
            }
        }
    }

    public void eF(int i) {
        this.bTC = i;
    }

    public int WF() {
        return this.bTC;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bTw.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.aq.ai.D(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bTw.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
