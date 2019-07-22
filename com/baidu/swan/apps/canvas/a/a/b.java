package com.baidu.swan.apps.canvas.a.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    CanvasView ame;
    ak amf;
    private Stack<b> amb = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint Mi = new Paint();
    TextPaint amc = new TextPaint();
    Path mPath = new Path();
    boolean amd = false;
    int amg = -1;
    int amh = 0;
    int ami = 0;
    int mStrokeColor = ViewCompat.MEASURED_STATE_MASK;

    public b(CanvasView canvasView) {
        this.ame = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.mFillPaint = new Paint(this.mFillPaint);
        bVar.mStrokePaint = new Paint(this.mStrokePaint);
        bVar.Mi = new Paint(this.Mi);
        bVar.amc = new TextPaint(this.amc);
        bVar.mPath = new Path(this.mPath);
        bVar.amh = this.amh;
        bVar.ami = this.ami;
        bVar.mStrokeColor = this.mStrokeColor;
        this.amb.push(bVar);
    }

    public void xS() {
        if (!this.amb.empty()) {
            b pop = this.amb.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.Mi = pop.Mi;
            this.amc = pop.amc;
            this.mPath = pop.mPath;
            this.amd = pop.amd;
            this.amb = pop.amb;
            this.amf = pop.amf;
            this.amg = pop.amg;
            this.amh = pop.amh;
            this.ami = pop.ami;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Paint paint) {
        if (paint != null) {
            if (this.ame != null && this.amf != null && this.amf.amN != null && !this.amf.amN.xU()) {
                paint.setShadowLayer(this.amf.and, this.amf.anb, this.amf.anc, this.amf.amN.getColor());
            }
            if (this.amg >= 0 && this.amg <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.amg) >> 8, 255));
            }
        }
    }

    public void bQ(int i) {
        this.ami = i;
    }

    public int xT() {
        return this.ami;
    }

    public void init() {
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Mi.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.amc.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mStrokePaint.setStrokeWidth(com.baidu.swan.apps.an.z.ad(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.amc.setAntiAlias(true);
        this.Mi.setAntiAlias(true);
        this.mPath.reset();
    }
}
