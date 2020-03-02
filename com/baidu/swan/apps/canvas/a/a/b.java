package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    CanvasView bgw;
    ak bgx;
    private Stack<b> bgt = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bgu = new TextPaint();
    Path mPath = new Path();
    boolean bgv = false;
    int bgy = -1;
    int bgz = 0;
    int bgA = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bgw = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bgu = new TextPaint(this.bgu);
        bVar.mPath = new Path(this.mPath);
        bVar.bgz = this.bgz;
        bVar.bgA = this.bgA;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bgt.push(bVar);
    }

    public void Kp() {
        if (!this.bgt.empty()) {
            b pop = this.bgt.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bgu = pop.bgu;
            this.mPath = pop.mPath;
            this.bgv = pop.bgv;
            this.bgt = pop.bgt;
            this.bgx = pop.bgx;
            this.bgy = pop.bgy;
            this.bgz = pop.bgz;
            this.bgA = pop.bgA;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bgw != null && this.bgx != null && this.bgx.bgZ != null && !this.bgx.bgZ.Kr()) {
                paint.setShadowLayer(this.bgx.bhm, this.bgx.mOffsetX, this.bgx.mOffsetY, this.bgx.bgZ.getColor());
            }
            if (this.bgy >= 0 && this.bgy <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bgy) >> 8, 255));
            }
        }
    }

    public void ec(int i) {
        this.bgA = i;
    }

    public int Kq() {
        return this.bgA;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bgu.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.as.af.S(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bgu.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
