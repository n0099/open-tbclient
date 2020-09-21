package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes3.dex */
public class b implements Cloneable {
    CanvasView cbl;
    ak cbm;
    private Stack<b> cbi = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint cbj = new TextPaint();
    Path mPath = new Path();
    boolean cbk = false;
    int cbn = -1;
    int cbo = 0;
    int cbp = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.cbl = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.cbj = new TextPaint(this.cbj);
        bVar.mPath = new Path(this.mPath);
        bVar.cbo = this.cbo;
        bVar.cbp = this.cbp;
        bVar.mStrokeColor = this.mStrokeColor;
        this.cbi.push(bVar);
    }

    public void adt() {
        if (!this.cbi.empty()) {
            b pop = this.cbi.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.cbj = pop.cbj;
            this.mPath = pop.mPath;
            this.cbk = pop.cbk;
            this.cbi = pop.cbi;
            this.cbm = pop.cbm;
            this.cbn = pop.cbn;
            this.cbo = pop.cbo;
            this.cbp = pop.cbp;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.cbl != null && this.cbm != null && this.cbm.cbO != null && !this.cbm.cbO.adv()) {
                paint.setShadowLayer(this.cbm.ccb, this.cbm.mOffsetX, this.cbm.mOffsetY, this.cbm.cbO.getColor());
            }
            if (this.cbn >= 0 && this.cbn <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.cbn) >> 8, 255));
            }
        }
    }

    public void gM(int i) {
        this.cbp = i;
    }

    public int adu() {
        return this.cbp;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cbj.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.ap.ah.H(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.cbj.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
