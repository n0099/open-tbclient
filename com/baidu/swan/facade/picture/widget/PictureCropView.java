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
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class PictureCropView extends PictureView {
    public static final boolean s = k.f46875a;
    public Drawable n;
    public final Rect o;
    public int p;
    public Paint q;
    public boolean r;

    /* loaded from: classes3.dex */
    public class a implements ZoomImageView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ZoomImageView f11559a;

        public a(ZoomImageView zoomImageView) {
            this.f11559a = zoomImageView;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.a
        public void a(Drawable drawable) {
            PictureCropView.this.r = drawable != null;
            if (drawable != null) {
                PictureCropView.this.q(this.f11559a, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.a
        public void b(Bitmap bitmap) {
            PictureCropView.this.r = bitmap != null;
            if (bitmap != null) {
                PictureCropView.this.q(this.f11559a, bitmap.getWidth(), bitmap.getHeight());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdImageViewTouchBase.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ZoomImageView f11561a;

        public b(ZoomImageView zoomImageView) {
            this.f11561a = zoomImageView;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.f
        public void a(Drawable drawable) {
            PictureCropView.this.o(this.f11561a, drawable);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ZoomImageView.b {

        /* renamed from: a  reason: collision with root package name */
        public RectF f11563a = new RectF();

        public c() {
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean a(ZoomImageView zoomImageView, double d2, double d3) {
            RectF bitmapRect = zoomImageView.getBitmapRect();
            this.f11563a.set((float) d2, (float) d3, 0.0f, 0.0f);
            PictureCropView.this.t(bitmapRect, this.f11563a);
            RectF rectF = this.f11563a;
            zoomImageView.v(rectF.left, rectF.top);
            return true;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean b(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            zoomImageView.w(-f2, -f3);
            zoomImageView.invalidate();
            return true;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean c(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }
    }

    public PictureCropView(Context context) {
        super(context);
        this.n = null;
        this.o = new Rect();
        this.p = Color.argb(128, 0, 0, 0);
        this.q = new Paint();
        this.r = false;
        g(context);
    }

    private void g(Context context) {
        this.q.setColor(this.p);
        this.q.setStyle(Paint.Style.FILL);
        this.n = context.getResources().getDrawable(d.a.l0.e.b.swan_app_picture_crop_bounds);
        ZoomImageView zoomImageView = (ZoomImageView) getImageView();
        zoomImageView.setDoubleTapEnabled(true);
        zoomImageView.setCalcBaseMatrix(false);
        zoomImageView.setOnSetImageBitmapListener(new a(zoomImageView));
        zoomImageView.setOnDrawableChangedListener(new b(zoomImageView));
        zoomImageView.setOnUpdateRectListener(new c());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        r(canvas);
    }

    public Bitmap getCroppedImage() {
        Bitmap imageViewBitmap = getImageViewBitmap();
        if (imageViewBitmap == null) {
            return null;
        }
        try {
            ZoomImageView zoomImageView = (ZoomImageView) getImageView();
            RectF rectF = new RectF(this.o);
            if (rectF.isEmpty()) {
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
            }
            Matrix imageViewMatrix = zoomImageView.getImageViewMatrix();
            Matrix matrix = new Matrix();
            if (imageViewMatrix.invert(matrix)) {
                RectF rectF2 = new RectF(rectF);
                matrix.mapRect(rectF2);
                Rect rect = new Rect();
                rectF2.round(rect);
                rect.right = Math.min(rect.right, imageViewBitmap.getWidth());
                rect.bottom = Math.min(rect.bottom, imageViewBitmap.getHeight());
                return Bitmap.createBitmap(imageViewBitmap, rect.left, rect.top, rect.width(), rect.height());
            }
            return null;
        } catch (Exception e2) {
            if (s) {
                e2.printStackTrace();
                return null;
            }
            return null;
        } catch (OutOfMemoryError e3) {
            if (s) {
                e3.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public final void o(ZoomImageView zoomImageView, Drawable drawable) {
        if (zoomImageView == null || drawable == null) {
            return;
        }
        Matrix imageViewMatrix = zoomImageView.getImageViewMatrix();
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        imageViewMatrix.mapRect(rectF);
        float width = rectF.width();
        float width2 = zoomImageView.getWidth();
        zoomImageView.v(width > width2 ? ((width2 - width) / 2.0f) - rectF.left : 0.0f, 0.0f);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            p();
        }
    }

    public final void p() {
        float f2;
        float f3;
        float f4;
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext());
        int desiredMinimumWidth = wallpaperManager.getDesiredMinimumWidth();
        int desiredMinimumHeight = wallpaperManager.getDesiredMinimumHeight();
        if (s) {
            Log.d("PictureCropView", "PictureCropView#configureBounds, desiredMinWidth = " + desiredMinimumWidth + ", desiredMinHeight = " + desiredMinimumHeight);
        }
        float f5 = desiredMinimumWidth;
        float f6 = desiredMinimumHeight;
        int width = getWidth();
        float height = getHeight();
        float f7 = width;
        if (f5 * height > f7 * f6) {
            f4 = f7 / f5;
            f2 = (height - (f6 * f4)) * 0.5f;
            f3 = 0.0f;
        } else {
            float f8 = height / f6;
            f2 = 0.0f;
            f3 = (f7 - (f5 * f8)) * 0.5f;
            f4 = f8;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f4);
        matrix.postTranslate((int) (f3 + 0.5f), (int) (f2 + 0.5f));
        RectF rectF = new RectF(0.0f, 0.0f, f5, f6);
        boolean mapRect = matrix.mapRect(rectF);
        rectF.round(this.o);
        if (s) {
            Log.d("PictureCropView", "PictureCropView#configureBounds: calculate the crop size ======  , mCropBoundRect = " + this.o + ", mapRectVal = " + mapRect);
        }
    }

    public final void q(ZoomImageView zoomImageView, int i2, int i3) {
        if (zoomImageView == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        int width = (zoomImageView.getWidth() - zoomImageView.getPaddingLeft()) - zoomImageView.getPaddingRight();
        int height = (zoomImageView.getHeight() - zoomImageView.getPaddingTop()) - zoomImageView.getPaddingBottom();
        if (!this.o.isEmpty()) {
            width = this.o.width();
            height = this.o.height();
        }
        float f2 = i2 * height > width * i3 ? height / i3 : width / i2;
        if (s) {
            Log.d("PictureCropView", "PictureCropView#configureZoomRange() scale = " + f2);
        }
        if (f2 > 0.0f) {
            zoomImageView.setZoomRange(f2, 3.0f + f2);
        }
    }

    public void r(Canvas canvas) {
        if (this.r) {
            s(canvas, this.o);
            if (this.n == null || this.o.isEmpty()) {
                return;
            }
            this.n.setBounds(this.o);
            this.n.draw(canvas);
        }
    }

    public void s(Canvas canvas, Rect rect) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Paint paint = this.q;
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, rect.top, paint);
        float f3 = height;
        canvas.drawRect(0.0f, rect.top, rect.left, f3, paint);
        canvas.drawRect(rect.left, rect.bottom, f2, f3, paint);
        canvas.drawRect(rect.right, rect.top, f2, rect.bottom, paint);
    }

    public final boolean t(RectF rectF, RectF rectF2) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if (rectF == null) {
            return false;
        }
        Rect rect = this.o;
        int i2 = rect.top;
        int i3 = rect.left;
        int i4 = rect.right;
        int i5 = rect.bottom;
        float f8 = rectF2.left;
        float f9 = rectF2.top;
        float f10 = i2;
        if (rectF.top >= f10 && rectF.bottom <= i5) {
            rectF2.top = f10;
        }
        float f11 = i3;
        if (rectF.left >= f11 && rectF.right <= i4) {
            rectF2.left = f11;
        }
        if (rectF.top + f9 >= f10) {
            rectF2.top = (int) (f10 - f2);
        }
        if (f9 + rectF.bottom <= i5) {
            rectF2.top = (int) (f4 - f3);
        }
        if (rectF.left + f8 >= f11) {
            rectF2.left = (int) (f11 - f5);
        }
        if (f8 + rectF.right <= i4) {
            rectF2.left = (int) (f7 - f6);
            return true;
        }
        return true;
    }

    public PictureCropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = null;
        this.o = new Rect();
        this.p = Color.argb(128, 0, 0, 0);
        this.q = new Paint();
        this.r = false;
        g(context);
    }

    public PictureCropView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = null;
        this.o = new Rect();
        this.p = Color.argb(128, 0, 0, 0);
        this.q = new Paint();
        this.r = false;
        g(context);
    }
}
