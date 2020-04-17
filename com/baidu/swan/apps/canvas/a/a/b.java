package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    CanvasView bEV;
    ak bEW;
    private Stack<b> bES = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint bET = new TextPaint();
    Path mPath = new Path();
    boolean bEU = false;
    int bEX = -1;
    int bEY = 0;
    int bEZ = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.bEV = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.mBitmapPaint = new Paint(this.mBitmapPaint);
        bVar.bET = new TextPaint(this.bET);
        bVar.mPath = new Path(this.mPath);
        bVar.bEY = this.bEY;
        bVar.bEZ = this.bEZ;
        bVar.mStrokeColor = this.mStrokeColor;
        this.bES.push(bVar);
    }

    public void Sg() {
        if (!this.bES.empty()) {
            b pop = this.bES.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.bET = pop.bET;
            this.mPath = pop.mPath;
            this.bEU = pop.bEU;
            this.bES = pop.bES;
            this.bEW = pop.bEW;
            this.bEX = pop.bEX;
            this.bEY = pop.bEY;
            this.bEZ = pop.bEZ;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.bEV != null && this.bEW != null && this.bEW.bFy != null && !this.bEW.bFy.Si()) {
                paint.setShadowLayer(this.bEW.bFL, this.bEW.mOffsetX, this.bEW.mOffsetY, this.bEW.bFy.getColor());
            }
            if (this.bEX >= 0 && this.bEX <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.bEX) >> 8, 255));
            }
        }
    }

    public void eh(int i) {
        this.bEZ = i;
    }

    public int Sh() {
        return this.bEZ;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mBitmapPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bET.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.as.af.C(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.bET.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
