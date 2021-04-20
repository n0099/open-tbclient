package com.baidu.fsg.face.liveness.view;

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
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class XfordView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f6219a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6220b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f6221c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f6222d;

    /* renamed from: e  reason: collision with root package name */
    public Xfermode f6223e;

    public XfordView(Context context) {
        super(context);
        this.f6219a = null;
        this.f6220b = null;
        a();
    }

    private void a() {
        if (this.f6220b == null) {
            Paint paint = new Paint();
            this.f6220b = paint;
            paint.setColor(1711276032);
        }
        if (this.f6219a == null) {
            this.f6219a = BitmapFactory.decodeResource(getResources(), R.drawable.sapi_liveness_recog_face_mask);
        }
        if (this.f6223e == null) {
            this.f6223e = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f6219a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f6219a.recycle();
            this.f6219a = null;
        }
        System.gc();
        this.f6223e = null;
        this.f6221c = null;
        this.f6222d = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_height);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_width);
        int width = (getWidth() - dimensionPixelSize2) / 2;
        int height = (getHeight() - dimensionPixelSize) / 2;
        if (this.f6222d == null) {
            this.f6222d = new Rect(width, height, dimensionPixelSize2 + width, dimensionPixelSize + height);
        }
        if (this.f6221c == null) {
            this.f6221c = new Rect(0, 0, this.f6219a.getWidth(), this.f6219a.getHeight());
        }
        canvas.drawBitmap(this.f6219a, this.f6221c, this.f6222d, this.f6220b);
        this.f6220b.setXfermode(this.f6223e);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f6220b);
        this.f6220b.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void setBgPaintColor(int i) {
        if (this.f6220b == null) {
            this.f6220b = new Paint();
        }
        this.f6220b.setColor(i);
    }

    public XfordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6219a = null;
        this.f6220b = null;
        a();
    }
}
