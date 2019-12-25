package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes9.dex */
public class b implements Cloneable {
    CanvasView bbo;
    ak bbp;
    private Stack<b> bbl = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bbm = new TextPaint();
    Path mPath = new Path();
    boolean bbn = false;
    int bbq = -1;
    int bbr = 0;
    int bbs = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bbo = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bbm = new TextPaint(this.bbm);
        bVar.mPath = new Path(this.mPath);
        bVar.bbr = this.bbr;
        bVar.bbs = this.bbs;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bbl.push(bVar);
    }

    public void HC() {
        if (!this.bbl.empty()) {
            b pop = this.bbl.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bbm = pop.bbm;
            this.mPath = pop.mPath;
            this.bbn = pop.bbn;
            this.bbl = pop.bbl;
            this.bbp = pop.bbp;
            this.bbq = pop.bbq;
            this.bbr = pop.bbr;
            this.bbs = pop.bbs;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bbo != null && this.bbp != null && this.bbp.bbT != null && !this.bbp.bbT.HE()) {
                paint.setShadowLayer(this.bbp.bch, this.bbp.bcg, this.bbp.mOffsetY, this.bbp.bbT.getColor());
            }
            if (this.bbq >= 0 && this.bbq <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bbq) >> 8, 255));
            }
        }
    }

    public void dL(int i) {
        this.bbs = i;
    }

    public int HD() {
        return this.bbs;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bbm.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.as.af.T(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bbm.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
