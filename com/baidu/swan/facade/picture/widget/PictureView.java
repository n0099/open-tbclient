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
import com.baidu.swan.facade.picture.widget.BdImageViewTouch;
import com.baidu.swan.facade.picture.widget.BdImageViewTouchBase;
import com.baidu.tieba.R;
import com.baidu.tieba.cv2;
import com.baidu.tieba.mp3;
import com.baidu.tieba.np3;
import com.baidu.tieba.to3;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class PictureView extends FrameLayout {
    public String a;
    public String b;
    public String c;
    public ZoomImageView d;
    public View e;
    public View f;
    public View g;
    public boolean h;
    public c i;

    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public class a implements BdImageViewTouch.c {
        public a() {
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch.c
        public void onSingleTapConfirmed() {
            if (PictureView.this.f()) {
                if (PictureView.this.getContext() instanceof View.OnClickListener) {
                    ((View.OnClickListener) PictureView.this.getContext()).onClick(PictureView.this.d);
                }
            } else if (PictureView.this.h) {
                PictureView.this.h();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    PictureView.this.d.setImageBitmap(copy);
                    PictureView.this.j();
                    if (PictureView.this.i != null) {
                        PictureView.this.i.b();
                        return;
                    }
                    return;
                } catch (OutOfMemoryError unused) {
                    System.gc();
                }
            }
            if (PictureView.this.i != null) {
                PictureView.this.i.a();
            }
            PictureView.this.i();
        }
    }

    public PictureView(Context context) {
        this(context, null);
    }

    public void setData(String str) {
        this.a = str;
        this.b = null;
        h();
    }

    public void setUA(String str) {
        this.c = str;
    }

    public PictureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        g(context);
    }

    public void setData(String str, String str2, c cVar) {
        this.i = cVar;
        this.a = str;
        this.b = str2;
        h();
    }

    public boolean f() {
        ZoomImageView zoomImageView = this.d;
        if (zoomImageView != null && zoomImageView.M()) {
            return true;
        }
        return false;
    }

    public View getImageView() {
        return this.d;
    }

    public Bitmap getImageViewBitmap() {
        ZoomImageView zoomImageView = this.d;
        if (zoomImageView != null) {
            Drawable drawable = zoomImageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            return to3.g(drawable);
        }
        return null;
    }

    public final void i() {
        this.f.setVisibility(0);
        this.e.setVisibility(4);
        this.g.setVisibility(0);
        this.h = true;
    }

    public final void j() {
        this.f.setVisibility(4);
        this.e.setVisibility(4);
        this.g.setVisibility(4);
        this.h = false;
    }

    public final void g(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d090a, this);
        this.d = (ZoomImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092a74);
        this.e = inflate.findViewById(R.id.obfuscated_res_0x7f091c60);
        this.f = inflate.findViewById(R.id.obfuscated_res_0x7f091e83);
        this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091c61);
        this.d.setDisplayType(BdImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
        this.d.setZoomRange(1.0f, 3.0f);
        this.d.setDoubleTapEnabled(true);
        this.d.setSingleTapListener(new a());
    }

    public boolean h() {
        boolean z;
        int i;
        String str = this.a;
        String str2 = this.b;
        String str3 = this.c;
        Uri p = np3.p(str);
        if (p == null) {
            z = true;
        } else {
            z = false;
        }
        View view2 = this.e;
        int i2 = 4;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        view2.setVisibility(i);
        View view3 = this.f;
        if (z) {
            i2 = 0;
        }
        view3.setVisibility(i2);
        this.g.setVisibility(0);
        if (!z) {
            this.h = false;
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("referer", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("User-Agent", str3);
            }
            ImageRequestBuilder resizeOptions = ImageRequestBuilder.newBuilderWithSource(p).setResizeOptions(new ResizeOptions(mp3.o(getContext()), mp3.o(getContext())));
            cv2.C().e(resizeOptions, hashMap);
            Fresco.getImagePipeline().fetchDecodedImage(resizeOptions.build(), getContext()).subscribe(new b(), UiThreadImmediateExecutorService.getInstance());
        }
        return !z;
    }
}
