package com.baidu.pass.biometrics.face.liveness.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.pass.biometrics.face.R;
/* loaded from: classes7.dex */
public class XfordView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f4086a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f4087b;
    private Rect c;
    private Rect d;
    private Xfermode e;

    public XfordView(Context context) {
        super(context);
        this.f4086a = null;
        this.f4087b = null;
        a();
    }

    private void a() {
        if (this.f4087b == null) {
            this.f4087b = new Paint();
            this.f4087b.setColor(1711276032);
        }
        if (this.f4086a == null) {
            this.f4086a = BitmapFactory.decodeResource(getResources(), R.drawable.pass_liveness_recog_face_mask);
        }
        if (this.e == null) {
            this.e = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f4086a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f4086a.recycle();
            this.f4086a = null;
        }
        System.gc();
        this.e = null;
        this.c = null;
        this.d = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_height);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_width);
        int width = (getWidth() - dimensionPixelSize2) / 2;
        int height = (getHeight() - dimensionPixelSize) / 2;
        if (this.d == null) {
            this.d = new Rect(width, height, dimensionPixelSize2 + width, dimensionPixelSize + height);
        }
        if (this.c == null) {
            this.c = new Rect(0, 0, this.f4086a.getWidth(), this.f4086a.getHeight());
        }
        canvas.drawBitmap(this.f4086a, this.c, this.d, this.f4087b);
        this.f4087b.setXfermode(this.e);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f4087b);
        this.f4087b.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void setBgPaintColor(int i) {
        if (this.f4087b == null) {
            this.f4087b = new Paint();
        }
        this.f4087b.setColor(i);
    }

    public XfordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4086a = null;
        this.f4087b = null;
        a();
    }
}
