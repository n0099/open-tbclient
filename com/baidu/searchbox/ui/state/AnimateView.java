package com.baidu.searchbox.ui.state;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes4.dex */
public class AnimateView extends View {
    public Bitmap mDrawingBitmap;
    public View mDrawingView;

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public AnimateView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.mDrawingBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return;
        }
        View view2 = this.mDrawingView;
        if (view2 != null) {
            view2.draw(canvas);
            this.mDrawingView = null;
        }
    }

    public void setDrawingView(View view2) {
        this.mDrawingView = view2;
        if (view2 != null) {
            captureViewSnapshot();
        }
    }

    public AnimateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void captureViewSnapshot() {
        int width = this.mDrawingView.getWidth();
        int height = this.mDrawingView.getHeight();
        if (width != 0 && height != 0) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.mDrawingBitmap = createBitmap;
                if (createBitmap == null) {
                    return;
                }
                try {
                    this.mDrawingView.draw(new Canvas(this.mDrawingBitmap));
                    return;
                } catch (Exception unused) {
                    this.mDrawingBitmap = null;
                    return;
                }
            } catch (OutOfMemoryError unused2) {
                this.mDrawingBitmap = null;
                return;
            }
        }
        this.mDrawingBitmap = null;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        this.mDrawingView = null;
        this.mDrawingBitmap = null;
    }
}
