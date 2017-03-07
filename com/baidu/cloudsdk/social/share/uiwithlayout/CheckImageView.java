package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.p;
/* loaded from: classes.dex */
public class CheckImageView extends ImageView {
    private boolean a;
    private Bitmap b;
    private Rect c;

    public CheckImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.b = BitmapFactory.decodeResource(context.getApplicationContext().getResources(), p.c(context, "bdsocialshare_selected"));
    }

    private Rect a(Canvas canvas) {
        Rect clipBounds = canvas.getClipBounds();
        clipBounds.bottom -= getPaddingBottom();
        clipBounds.right -= getPaddingRight();
        clipBounds.left += getPaddingLeft();
        clipBounds.top += getPaddingTop();
        return clipBounds;
    }

    public boolean isChecked() {
        return this.a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
        }
        if (this.c == null) {
            this.c = a(canvas);
        }
        if (this.a) {
            if (this.b == null || this.b.isRecycled()) {
                this.b = BitmapFactory.decodeResource(getContext().getApplicationContext().getResources(), p.c(getContext(), "bdsocialshare_selected"));
            }
            canvas.drawBitmap(this.b, this.c.right - this.b.getWidth(), this.c.bottom - this.b.getHeight(), (Paint) null);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        setChecked(!this.a);
        return true;
    }

    public void setChecked(boolean z) {
        if (this.a != z) {
            this.a = z;
            invalidate();
        }
    }
}
