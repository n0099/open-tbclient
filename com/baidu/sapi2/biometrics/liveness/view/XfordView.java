package com.baidu.sapi2.biometrics.liveness.view;

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
    private Bitmap a;
    private Paint b;
    private Rect c;
    private Rect d;
    private Xfermode e;

    public XfordView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
    }

    public XfordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == null) {
            this.b = new Paint();
            this.b.setColor(1711276032);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_height);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_width);
        if (this.a == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.sapi_liveness_recog_face_mask, options);
            options.inSampleSize = 2;
            options.inJustDecodeBounds = false;
            this.a = BitmapFactory.decodeResource(getResources(), R.drawable.sapi_liveness_recog_face_mask, options);
        }
        int width = (getWidth() - dimensionPixelSize2) / 2;
        int height = (getHeight() - dimensionPixelSize) / 2;
        if (this.c == null) {
            this.c = new Rect(0, 0, this.a.getWidth(), this.a.getHeight());
        }
        if (this.d == null) {
            this.d = new Rect(width, height, dimensionPixelSize2 + width, dimensionPixelSize + height);
        }
        canvas.drawBitmap(this.a, this.c, this.d, this.b);
        if (this.e == null) {
            this.e = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        }
        this.b.setXfermode(this.e);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.b);
        this.b.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null && !this.a.isRecycled()) {
            this.a.recycle();
            this.a = null;
        }
        System.gc();
        this.e = null;
        this.c = null;
        this.d = null;
    }
}
