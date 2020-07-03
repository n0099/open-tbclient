package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    CanvasView bSG;
    ak bSH;
    private Stack<b> bSD = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bSE = new TextPaint();
    Path mPath = new Path();
    boolean bSF = false;
    int bSI = -1;
    int bSJ = 0;
    int bSK = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bSG = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bSE = new TextPaint(this.bSE);
        bVar.mPath = new Path(this.mPath);
        bVar.bSJ = this.bSJ;
        bVar.bSK = this.bSK;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bSD.push(bVar);
    }

    public void VX() {
        if (!this.bSD.empty()) {
            b pop = this.bSD.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bSE = pop.bSE;
            this.mPath = pop.mPath;
            this.bSF = pop.bSF;
            this.bSD = pop.bSD;
            this.bSH = pop.bSH;
            this.bSI = pop.bSI;
            this.bSJ = pop.bSJ;
            this.bSK = pop.bSK;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bSG != null && this.bSH != null && this.bSH.bTj != null && !this.bSH.bTj.VZ()) {
                paint.setShadowLayer(this.bSH.bTw, this.bSH.mOffsetX, this.bSH.mOffsetY, this.bSH.bTj.getColor());
            }
            if (this.bSI >= 0 && this.bSI <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bSI) >> 8, 255));
            }
        }
    }

    public void eD(int i) {
        this.bSK = i;
    }

    public int VY() {
        return this.bSK;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bSE.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.aq.ag.D(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bSE.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
