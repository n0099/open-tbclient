package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    CanvasView bFa;
    ak bFb;
    private Stack<b> bEX = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bEY = new TextPaint();
    Path mPath = new Path();
    boolean bEZ = false;
    int bFc = -1;
    int bFd = 0;
    int bFe = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bFa = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bEY = new TextPaint(this.bEY);
        bVar.mPath = new Path(this.mPath);
        bVar.bFd = this.bFd;
        bVar.bFe = this.bFe;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bEX.push(bVar);
    }

    public void Sf() {
        if (!this.bEX.empty()) {
            b pop = this.bEX.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bEY = pop.bEY;
            this.mPath = pop.mPath;
            this.bEZ = pop.bEZ;
            this.bEX = pop.bEX;
            this.bFb = pop.bFb;
            this.bFc = pop.bFc;
            this.bFd = pop.bFd;
            this.bFe = pop.bFe;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bFa != null && this.bFb != null && this.bFb.bFD != null && !this.bFb.bFD.Sh()) {
                paint.setShadowLayer(this.bFb.bFQ, this.bFb.mOffsetX, this.bFb.mOffsetY, this.bFb.bFD.getColor());
            }
            if (this.bFc >= 0 && this.bFc <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bFc) >> 8, 255));
            }
        }
    }

    public void eh(int i) {
        this.bFe = i;
    }

    public int Sg() {
        return this.bFe;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bEY.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.as.af.C(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bEY.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
