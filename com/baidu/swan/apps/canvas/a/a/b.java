package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView aFV;
    ak aFW;
    private Stack<b> aFS = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint aFT = new TextPaint();
    Path mPath = new Path();
    boolean aFU = false;
    int aFX = -1;
    int aFY = 0;
    int aFZ = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.aFV = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.aFT = new TextPaint(this.aFT);
        bVar.mPath = new Path(this.mPath);
        bVar.aFY = this.aFY;
        bVar.aFZ = this.aFZ;
        bVar.mStrokeColor = this.mStrokeColor;
        this.aFS.push(bVar);
    }

    public void CR() {
        if (!this.aFS.empty()) {
            b pop = this.aFS.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.aFT = pop.aFT;
            this.mPath = pop.mPath;
            this.aFU = pop.aFU;
            this.aFS = pop.aFS;
            this.aFW = pop.aFW;
            this.aFX = pop.aFX;
            this.aFY = pop.aFY;
            this.aFZ = pop.aFZ;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.aFV != null && this.aFW != null && this.aFW.aGD != null && !this.aFW.aGD.CT()) {
                paint.setShadowLayer(this.aFW.aGS, this.aFW.aGQ, this.aFW.aGR, this.aFW.aGD.getColor());
            }
            if (this.aFX >= 0 && this.aFX <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.aFX) >> 8, 255));
            }
        }
    }

    public void cN(int i) {
        this.aFZ = i;
    }

    public int CS() {
        return this.aFZ;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aFT.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.z.S(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.aFT.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
