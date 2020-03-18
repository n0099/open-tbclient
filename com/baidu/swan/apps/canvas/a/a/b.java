package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    CanvasView bgK;
    ak bgL;
    private Stack<b> bgH = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bgI = new TextPaint();
    Path mPath = new Path();
    boolean bgJ = false;
    int bgM = -1;
    int bgN = 0;
    int bgO = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bgK = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bgI = new TextPaint(this.bgI);
        bVar.mPath = new Path(this.mPath);
        bVar.bgN = this.bgN;
        bVar.bgO = this.bgO;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bgH.push(bVar);
    }

    public void Ks() {
        if (!this.bgH.empty()) {
            b pop = this.bgH.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bgI = pop.bgI;
            this.mPath = pop.mPath;
            this.bgJ = pop.bgJ;
            this.bgH = pop.bgH;
            this.bgL = pop.bgL;
            this.bgM = pop.bgM;
            this.bgN = pop.bgN;
            this.bgO = pop.bgO;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bgK != null && this.bgL != null && this.bgL.bhn != null && !this.bgL.bhn.Ku()) {
                paint.setShadowLayer(this.bgL.bhA, this.bgL.mOffsetX, this.bgL.mOffsetY, this.bgL.bhn.getColor());
            }
            if (this.bgM >= 0 && this.bgM <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bgM) >> 8, 255));
            }
        }
    }

    public void ec(int i) {
        this.bgO = i;
    }

    public int Kt() {
        return this.bgO;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bgI.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.as.af.S(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bgI.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
