package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.baidu.swan.facade.picture.widget.BdImageViewTouch;
import com.baidu.swan.facade.picture.widget.BdImageViewTouchBase;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.u;
import d.a.l0.e.d;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PictureView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public String f11565e;

    /* renamed from: f  reason: collision with root package name */
    public String f11566f;

    /* renamed from: g  reason: collision with root package name */
    public String f11567g;

    /* renamed from: h  reason: collision with root package name */
    public ZoomImageView f11568h;

    /* renamed from: i  reason: collision with root package name */
    public View f11569i;
    public View j;
    public View k;
    public boolean l;
    public c m;

    /* loaded from: classes3.dex */
    public class a implements BdImageViewTouch.c {
        public a() {
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch.c
        public void a() {
            if (!PictureView.this.f()) {
                if (PictureView.this.l) {
                    PictureView.this.h();
                }
            } else if (PictureView.this.getContext() instanceof View.OnClickListener) {
                ((View.OnClickListener) PictureView.this.getContext()).onClick(PictureView.this.f11568h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseBitmapDataSubscriber {
        public b() {
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            super.onCancellation(dataSource);
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            PictureView.this.i();
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Bitmap copy;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    PictureView.this.f11568h.setImageBitmap(copy);
                    PictureView.this.j();
                    if (PictureView.this.m != null) {
                        PictureView.this.m.b();
                        return;
                    }
                    return;
                } catch (OutOfMemoryError unused) {
                    System.gc();
                }
            }
            if (PictureView.this.m != null) {
                PictureView.this.m.a();
            }
            PictureView.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b();
    }

    public PictureView(Context context) {
        this(context, null);
    }

    public boolean f() {
        ZoomImageView zoomImageView = this.f11568h;
        return zoomImageView != null && zoomImageView.M();
    }

    public final void g(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.swan_app_picture_view, this);
        this.f11568h = (ZoomImageView) inflate.findViewById(d.a.l0.e.c.zoom_imageview);
        this.f11569i = inflate.findViewById(d.a.l0.e.c.picture_load_progressbar);
        this.j = inflate.findViewById(d.a.l0.e.c.reload_textview);
        this.k = inflate.findViewById(d.a.l0.e.c.picture_loading_layout);
        this.f11568h.setDisplayType(BdImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
        this.f11568h.setZoomRange(1.0f, 3.0f);
        this.f11568h.setDoubleTapEnabled(true);
        this.f11568h.setSingleTapListener(new a());
    }

    public View getImageView() {
        return this.f11568h;
    }

    public Bitmap getImageViewBitmap() {
        ZoomImageView zoomImageView = this.f11568h;
        if (zoomImageView != null) {
            Drawable drawable = zoomImageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            return u.g(drawable);
        }
        return null;
    }

    public boolean h() {
        String str = this.f11565e;
        String str2 = this.f11566f;
        String str3 = this.f11567g;
        Uri p = o0.p(str);
        boolean z = p == null;
        this.f11569i.setVisibility(z ? 4 : 0);
        this.j.setVisibility(z ? 0 : 4);
        this.k.setVisibility(0);
        if (!z) {
            this.l = false;
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(Config.LAUNCH_REFERER, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("User-Agent", str3);
            }
            ImageRequestBuilder resizeOptions = ImageRequestBuilder.newBuilderWithSource(p).setResizeOptions(new ResizeOptions(n0.o(getContext()), n0.o(getContext())));
            d.a.l0.a.c1.a.y().e(resizeOptions, hashMap);
            Fresco.getImagePipeline().fetchDecodedImage(resizeOptions.build(), getContext()).subscribe(new b(), UiThreadImmediateExecutorService.getInstance());
        }
        return !z;
    }

    public final void i() {
        this.j.setVisibility(0);
        this.f11569i.setVisibility(4);
        this.k.setVisibility(0);
        this.l = true;
    }

    public final void j() {
        this.j.setVisibility(4);
        this.f11569i.setVisibility(4);
        this.k.setVisibility(4);
        this.l = false;
    }

    public void setData(String str) {
        this.f11565e = str;
        this.f11566f = null;
        h();
    }

    public void setUA(String str) {
        this.f11567g = str;
    }

    public PictureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11565e = null;
        this.f11566f = null;
        this.f11567g = null;
        this.f11568h = null;
        this.f11569i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.f11565e = null;
        this.f11566f = null;
        this.f11567g = null;
        this.f11568h = null;
        this.f11569i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        g(context);
    }

    public void setData(String str, String str2, c cVar) {
        this.m = cVar;
        this.f11565e = str;
        this.f11566f = str2;
        h();
    }
}
