package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes9.dex */
public class b implements Cloneable {
    CanvasView cLW;
    ak cLX;
    private Stack<b> cLT = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cLU = new TextPaint();
    Path mPath = new Path();
    boolean cLV = false;
    int cLY = -1;
    int cLZ = 0;
    int cMa = 0;
    int aIr = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cLW = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cLU = new TextPaint(this.cLU);
        bVar.mPath = new Path(this.mPath);
        bVar.cLZ = this.cLZ;
        bVar.cMa = this.cMa;
        bVar.aIr = this.aIr;
        this.cLT.push(bVar);
    }

    public void aoj() {
        if (!this.cLT.empty()) {
            b pop = this.cLT.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cLU = pop.cLU;
            this.mPath = pop.mPath;
            this.cLV = pop.cLV;
            this.cLT = pop.cLT;
            this.cLX = pop.cLX;
            this.cLY = pop.cLY;
            this.cLZ = pop.cLZ;
            this.cMa = pop.cMa;
            this.aIr = pop.aIr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Paint paint) {
        if (paint != null) {
            if (this.cLW != null && this.cLX != null && this.cLX.cMC != null && !this.cLX.cMC.aol()) {
                paint.setShadowLayer(this.cLX.cMQ, this.cLX.cMO, this.cLX.cMP, this.cLX.cMC.getColor());
            }
            if (this.cLY >= 0 && this.cLY <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cLY) >> 8, 255));
            }
        }
    }

    public void hS(int i) {
        this.cMa = i;
    }

    public int aok() {
        return this.cMa;
    }

    public void init() {
        this.aIr = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cLU.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ao.ah.O(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cLU.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
