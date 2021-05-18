package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class ZoomImageView extends BdImageViewTouch {
    public boolean N;
    public float O;
    public float P;
    public a Q;
    public b R;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Drawable drawable);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(ZoomImageView zoomImageView, double d2, double d3);

        boolean b(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        boolean c(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);
    }

    public ZoomImageView(Context context) {
        super(context);
        this.N = false;
        this.O = -1.0f;
        this.P = -1.0f;
        this.Q = null;
        this.R = null;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch
    public boolean H(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        b bVar = this.R;
        boolean c2 = bVar != null ? bVar.c(this, motionEvent, motionEvent2, f2, f3) : false;
        return !c2 ? super.H(motionEvent, motionEvent2, f2, f3) : c2;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch
    public boolean I(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        b bVar = this.R;
        boolean b2 = bVar != null ? bVar.b(this, motionEvent, motionEvent2, f2, f3) : false;
        return !b2 ? super.I(motionEvent, motionEvent2, f2, f3) : b2;
    }

    public boolean M() {
        return this.N;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        a aVar = this.Q;
        if (aVar != null) {
            aVar.b(bitmap);
        }
        super.setImageBitmap(bitmap, null, this.O, this.P);
        this.N = bitmap != null;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        a aVar = this.Q;
        if (aVar != null) {
            aVar.a(drawable);
        }
        super.setImageDrawable(drawable, null, this.O, this.P);
        this.N = drawable != null;
    }

    public void setOnSetImageBitmapListener(a aVar) {
        this.Q = aVar;
    }

    public void setOnUpdateRectListener(b bVar) {
        this.R = bVar;
    }

    public void setZoomRange(float f2, float f3) {
        this.P = f3;
        this.O = f2;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void t(double d2, double d3) {
        b bVar = this.R;
        if (bVar != null ? bVar.a(this, d2, d3) : false) {
            return;
        }
        super.t(d2, d3);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.N = false;
        this.O = -1.0f;
        this.P = -1.0f;
        this.Q = null;
        this.R = null;
    }

    public ZoomImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.N = false;
        this.O = -1.0f;
        this.P = -1.0f;
        this.Q = null;
        this.R = null;
    }
}
