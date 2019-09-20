package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView amC;
    ak amD;
    private Stack<b> amz = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint Mi = new Paint();
    TextPaint amA = new TextPaint();
    Path mPath = new Path();
    boolean amB = false;
    int amE = -1;
    int amF = 0;
    int amG = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.amC = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.Mi = new Paint(this.Mi);
        bVar.amA = new TextPaint(this.amA);
        bVar.mPath = new Path(this.mPath);
        bVar.amF = this.amF;
        bVar.amG = this.amG;
        bVar.mStrokeColor = this.mStrokeColor;
        this.amz.push(bVar);
    }

    public void xW() {
        if (!this.amz.empty()) {
            b pop = this.amz.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.Mi = pop.Mi;
            this.amA = pop.amA;
            this.mPath = pop.mPath;
            this.amB = pop.amB;
            this.amz = pop.amz;
            this.amD = pop.amD;
            this.amE = pop.amE;
            this.amF = pop.amF;
            this.amG = pop.amG;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.amC != null && this.amD != null && this.amD.anl != null && !this.amD.anl.xY()) {
                paint.setShadowLayer(this.amD.anB, this.amD.anz, this.amD.anA, this.amD.anl.getColor());
            }
            if (this.amE >= 0 && this.amE <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.amE) >> 8, 255));
            }
        }
    }

    public void bR(int i) {
        this.amG = i;
    }

    public int xX() {
        return this.amG;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Mi.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.amA.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.z.ad(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.amA.setAntiAlias(true);
        this.Mi.setAntiAlias(true);
        this.mPath.reset();
    }
}
