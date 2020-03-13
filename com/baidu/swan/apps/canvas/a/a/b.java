package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    CanvasView bgx;
    ak bgy;
    private Stack<b> bgu = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bgv = new TextPaint();
    Path mPath = new Path();
    boolean bgw = false;
    int bgz = -1;
    int bgA = 0;
    int bgB = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bgx = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bgv = new TextPaint(this.bgv);
        bVar.mPath = new Path(this.mPath);
        bVar.bgA = this.bgA;
        bVar.bgB = this.bgB;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bgu.push(bVar);
    }

    public void Kp() {
        if (!this.bgu.empty()) {
            b pop = this.bgu.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bgv = pop.bgv;
            this.mPath = pop.mPath;
            this.bgw = pop.bgw;
            this.bgu = pop.bgu;
            this.bgy = pop.bgy;
            this.bgz = pop.bgz;
            this.bgA = pop.bgA;
            this.bgB = pop.bgB;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bgx != null && this.bgy != null && this.bgy.bha != null && !this.bgy.bha.Kr()) {
                paint.setShadowLayer(this.bgy.bhn, this.bgy.mOffsetX, this.bgy.mOffsetY, this.bgy.bha.getColor());
            }
            if (this.bgz >= 0 && this.bgz <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bgz) >> 8, 255));
            }
        }
    }

    public void ec(int i) {
        this.bgB = i;
    }

    public int Kq() {
        return this.bgB;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bgv.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.as.af.S(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bgv.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
