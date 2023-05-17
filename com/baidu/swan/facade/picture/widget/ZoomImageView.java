package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class ZoomImageView extends BdImageViewTouch {
    public boolean J;
    public float K;
    public float L;
    public a M;
    public b N;

    /* loaded from: classes4.dex */
    public interface a {
        void a(Drawable drawable);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(ZoomImageView zoomImageView, double d, double d2);

        boolean b(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        boolean c(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);
    }

    public ZoomImageView(Context context) {
        super(context);
        this.J = false;
        this.K = -1.0f;
        this.L = -1.0f;
        this.M = null;
        this.N = null;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        boolean z;
        a aVar = this.M;
        if (aVar != null) {
            aVar.b(bitmap);
        }
        super.setImageBitmap(bitmap, null, this.K, this.L);
        if (bitmap != null) {
            z = true;
        } else {
            z = false;
        }
        this.J = z;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        boolean z;
        a aVar = this.M;
        if (aVar != null) {
            aVar.a(drawable);
        }
        super.setImageDrawable(drawable, null, this.K, this.L);
        if (drawable != null) {
            z = true;
        } else {
            z = false;
        }
        this.J = z;
    }

    public void setOnSetImageBitmapListener(a aVar) {
        this.M = aVar;
    }

    public void setOnUpdateRectListener(b bVar) {
        this.N = bVar;
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = false;
        this.K = -1.0f;
        this.L = -1.0f;
        this.M = null;
        this.N = null;
    }

    public void setZoomRange(float f, float f2) {
        this.L = f2;
        this.K = f;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void t(double d, double d2) {
        boolean z;
        b bVar = this.N;
        if (bVar != null) {
            z = bVar.a(this, d, d2);
        } else {
            z = false;
        }
        if (!z) {
            super.t(d, d2);
        }
    }

    public ZoomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.J = false;
        this.K = -1.0f;
        this.L = -1.0f;
        this.M = null;
        this.N = null;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch
    public boolean H(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z;
        b bVar = this.N;
        if (bVar != null) {
            z = bVar.c(this, motionEvent, motionEvent2, f, f2);
        } else {
            z = false;
        }
        if (!z) {
            return super.H(motionEvent, motionEvent2, f, f2);
        }
        return z;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch
    public boolean I(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z;
        b bVar = this.N;
        if (bVar != null) {
            z = bVar.b(this, motionEvent, motionEvent2, f, f2);
        } else {
            z = false;
        }
        if (!z) {
            return super.I(motionEvent, motionEvent2, f, f2);
        }
        return z;
    }

    public boolean M() {
        return this.J;
    }
}
