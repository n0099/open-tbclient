package com.baidu.swan.facade.picture.widget;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.swan.facade.picture.widget.BdImageViewTouchBase;
import com.baidu.swan.facade.picture.widget.ZoomImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ho1;
/* loaded from: classes3.dex */
public class PictureCropView extends PictureView {
    public static final boolean o = ho1.a;
    public Drawable j;
    public final Rect k;
    public int l;
    public Paint m;
    public boolean n;

    /* loaded from: classes3.dex */
    public class a implements ZoomImageView.a {
        public final /* synthetic */ ZoomImageView a;

        public a(ZoomImageView zoomImageView) {
            this.a = zoomImageView;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.a
        public void a(Drawable drawable) {
            boolean z;
            PictureCropView pictureCropView = PictureCropView.this;
            if (drawable != null) {
                z = true;
            } else {
                z = false;
            }
            pictureCropView.n = z;
            if (drawable == null) {
                return;
            }
            PictureCropView.this.q(this.a, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.a
        public void b(Bitmap bitmap) {
            boolean z;
            PictureCropView pictureCropView = PictureCropView.this;
            if (bitmap != null) {
                z = true;
            } else {
                z = false;
            }
            pictureCropView.n = z;
            if (bitmap == null) {
                return;
            }
            PictureCropView.this.q(this.a, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdImageViewTouchBase.f {
        public final /* synthetic */ ZoomImageView a;

        public b(ZoomImageView zoomImageView) {
            this.a = zoomImageView;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.f
        public void a(Drawable drawable) {
            PictureCropView.this.o(this.a, drawable);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ZoomImageView.b {
        public RectF a = new RectF();

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean c(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        public c() {
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean a(ZoomImageView zoomImageView, double d, double d2) {
            RectF bitmapRect = zoomImageView.getBitmapRect();
            this.a.set((float) d, (float) d2, 0.0f, 0.0f);
            PictureCropView.this.t(bitmapRect, this.a);
            RectF rectF = this.a;
            zoomImageView.v(rectF.left, rectF.top);
            return true;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean b(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            zoomImageView.w(-f, -f2);
            zoomImageView.invalidate();
            return true;
        }
    }

    public PictureCropView(Context context) {
        super(context);
        this.j = null;
        this.k = new Rect();
        this.l = Color.argb(128, 0, 0, 0);
        this.m = new Paint();
        this.n = false;
        g(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        r(canvas);
    }

    public void r(Canvas canvas) {
        if (!this.n) {
            return;
        }
        s(canvas, this.k);
        if (this.j != null && !this.k.isEmpty()) {
            this.j.setBounds(this.k);
            this.j.draw(canvas);
        }
    }

    public PictureCropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = null;
        this.k = new Rect();
        this.l = Color.argb(128, 0, 0, 0);
        this.m = new Paint();
        this.n = false;
        g(context);
    }

    public PictureCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = null;
        this.k = new Rect();
        this.l = Color.argb(128, 0, 0, 0);
        this.m = new Paint();
        this.n = false;
        g(context);
    }

    private void g(Context context) {
        this.m.setColor(this.l);
        this.m.setStyle(Paint.Style.FILL);
        this.j = context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081221);
        ZoomImageView zoomImageView = (ZoomImageView) getImageView();
        zoomImageView.setDoubleTapEnabled(true);
        zoomImageView.setCalcBaseMatrix(false);
        zoomImageView.setOnSetImageBitmapListener(new a(zoomImageView));
        zoomImageView.setOnDrawableChangedListener(new b(zoomImageView));
        zoomImageView.setOnUpdateRectListener(new c());
    }

    public Bitmap getCroppedImage() {
        Bitmap imageViewBitmap = getImageViewBitmap();
        if (imageViewBitmap == null) {
            return null;
        }
        try {
            ZoomImageView zoomImageView = (ZoomImageView) getImageView();
            RectF rectF = new RectF(this.k);
            if (rectF.isEmpty()) {
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
            }
            Matrix imageViewMatrix = zoomImageView.getImageViewMatrix();
            Matrix matrix = new Matrix();
            if (!imageViewMatrix.invert(matrix)) {
                return null;
            }
            RectF rectF2 = new RectF(rectF);
            matrix.mapRect(rectF2);
            Rect rect = new Rect();
            rectF2.round(rect);
            rect.right = Math.min(rect.right, imageViewBitmap.getWidth());
            rect.bottom = Math.min(rect.bottom, imageViewBitmap.getHeight());
            return Bitmap.createBitmap(imageViewBitmap, rect.left, rect.top, rect.width(), rect.height());
        } catch (Exception e) {
            if (!o) {
                return null;
            }
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            if (!o) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public final void o(ZoomImageView zoomImageView, Drawable drawable) {
        float f;
        if (zoomImageView != null && drawable != null) {
            Matrix imageViewMatrix = zoomImageView.getImageViewMatrix();
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            imageViewMatrix.mapRect(rectF);
            float width = rectF.width();
            float width2 = zoomImageView.getWidth();
            if (width > width2) {
                f = ((width2 - width) / 2.0f) - rectF.left;
            } else {
                f = 0.0f;
            }
            zoomImageView.v(f, 0.0f);
        }
    }

    public void s(Canvas canvas, Rect rect) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Paint paint = this.m;
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, rect.top, paint);
        float f2 = height;
        canvas.drawRect(0.0f, rect.top, rect.left, f2, paint);
        canvas.drawRect(rect.left, rect.bottom, f, f2, paint);
        canvas.drawRect(rect.right, rect.top, f, rect.bottom, paint);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            p();
        }
    }

    public final void p() {
        float f;
        float f2;
        float f3;
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext());
        int desiredMinimumWidth = wallpaperManager.getDesiredMinimumWidth();
        int desiredMinimumHeight = wallpaperManager.getDesiredMinimumHeight();
        if (o) {
            Log.d("PictureCropView", "PictureCropView#configureBounds, desiredMinWidth = " + desiredMinimumWidth + ", desiredMinHeight = " + desiredMinimumHeight);
        }
        float f4 = desiredMinimumWidth;
        float f5 = desiredMinimumHeight;
        int width = getWidth();
        float height = getHeight();
        float f6 = width;
        if (f4 * height > f6 * f5) {
            f3 = f6 / f4;
            f = (height - (f5 * f3)) * 0.5f;
            f2 = 0.0f;
        } else {
            float f7 = height / f5;
            f = 0.0f;
            f2 = (f6 - (f4 * f7)) * 0.5f;
            f3 = f7;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f3, f3);
        matrix.postTranslate((int) (f2 + 0.5f), (int) (f + 0.5f));
        RectF rectF = new RectF(0.0f, 0.0f, f4, f5);
        boolean mapRect = matrix.mapRect(rectF);
        rectF.round(this.k);
        if (o) {
            Log.d("PictureCropView", "PictureCropView#configureBounds: calculate the crop size ======  , mCropBoundRect = " + this.k + ", mapRectVal = " + mapRect);
        }
    }

    public final void q(ZoomImageView zoomImageView, int i, int i2) {
        float f;
        if (zoomImageView != null && i > 0 && i2 > 0) {
            int width = (zoomImageView.getWidth() - zoomImageView.getPaddingLeft()) - zoomImageView.getPaddingRight();
            int height = (zoomImageView.getHeight() - zoomImageView.getPaddingTop()) - zoomImageView.getPaddingBottom();
            if (!this.k.isEmpty()) {
                width = this.k.width();
                height = this.k.height();
            }
            if (i * height > width * i2) {
                f = height / i2;
            } else {
                f = width / i;
            }
            if (o) {
                Log.d("PictureCropView", "PictureCropView#configureZoomRange() scale = " + f);
            }
            if (f > 0.0f) {
                zoomImageView.setZoomRange(f, 3.0f + f);
            }
        }
    }

    public final boolean t(RectF rectF, RectF rectF2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        if (rectF == null) {
            return false;
        }
        Rect rect = this.k;
        int i = rect.top;
        int i2 = rect.left;
        int i3 = rect.right;
        int i4 = rect.bottom;
        float f7 = rectF2.left;
        float f8 = rectF2.top;
        float f9 = i;
        if (rectF.top >= f9 && rectF.bottom <= i4) {
            rectF2.top = f9;
        }
        float f10 = i2;
        if (rectF.left >= f10 && rectF.right <= i3) {
            rectF2.left = f10;
        }
        if (rectF.top + f8 >= f9) {
            rectF2.top = (int) (f9 - f);
        }
        if (f8 + rectF.bottom <= i4) {
            rectF2.top = (int) (f3 - f2);
        }
        if (rectF.left + f7 >= f10) {
            rectF2.left = (int) (f10 - f4);
        }
        if (f7 + rectF.right <= i3) {
            rectF2.left = (int) (f6 - f5);
            return true;
        }
        return true;
    }
}
