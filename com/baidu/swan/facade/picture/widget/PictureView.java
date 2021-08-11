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
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.o0;
import c.a.n0.a.v2.u;
import c.a.n0.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.facade.picture.widget.BdImageViewTouch;
import com.baidu.swan.facade.picture.widget.BdImageViewTouchBase;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class PictureView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float MAX_ZOOM = 3.0f;
    public static final float MIN_ZOOM = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f46619e;

    /* renamed from: f  reason: collision with root package name */
    public String f46620f;

    /* renamed from: g  reason: collision with root package name */
    public String f46621g;

    /* renamed from: h  reason: collision with root package name */
    public ZoomImageView f46622h;

    /* renamed from: i  reason: collision with root package name */
    public View f46623i;

    /* renamed from: j  reason: collision with root package name */
    public View f46624j;
    public View k;
    public boolean l;
    public c m;

    /* loaded from: classes6.dex */
    public class a implements BdImageViewTouch.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PictureView f46625a;

        public a(PictureView pictureView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46625a = pictureView;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f46625a.hasSetBitmap()) {
                    if (this.f46625a.l) {
                        this.f46625a.loadImageByUrl();
                    }
                } else if (this.f46625a.getContext() instanceof View.OnClickListener) {
                    ((View.OnClickListener) this.f46625a.getContext()).onClick(this.f46625a.f46622h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PictureView f46626a;

        public b(PictureView pictureView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46626a = pictureView;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                this.f46626a.g();
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Bitmap copy;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        this.f46626a.f46622h.setImageBitmap(copy);
                        this.f46626a.h();
                        if (this.f46626a.m != null) {
                            this.f46626a.m.b();
                            return;
                        }
                        return;
                    } catch (OutOfMemoryError unused) {
                        System.gc();
                    }
                }
                if (this.f46626a.m != null) {
                    this.f46626a.m.a();
                }
                this.f46626a.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PictureView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(d.swan_app_picture_view, this);
            this.f46622h = (ZoomImageView) inflate.findViewById(c.a.n0.e.c.zoom_imageview);
            this.f46623i = inflate.findViewById(c.a.n0.e.c.picture_load_progressbar);
            this.f46624j = inflate.findViewById(c.a.n0.e.c.reload_textview);
            this.k = inflate.findViewById(c.a.n0.e.c.picture_loading_layout);
            this.f46622h.setDisplayType(BdImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
            this.f46622h.setZoomRange(1.0f, 3.0f);
            this.f46622h.setDoubleTapEnabled(true);
            this.f46622h.setSingleTapListener(new a(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f46624j.setVisibility(0);
            this.f46623i.setVisibility(4);
            this.k.setVisibility(0);
            this.l = true;
        }
    }

    public View getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46622h : (View) invokeV.objValue;
    }

    public Bitmap getImageViewBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ZoomImageView zoomImageView = this.f46622h;
            if (zoomImageView != null) {
                Drawable drawable = zoomImageView.getDrawable();
                if (drawable instanceof BitmapDrawable) {
                    return ((BitmapDrawable) drawable).getBitmap();
                }
                return u.g(drawable);
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f46624j.setVisibility(4);
            this.f46623i.setVisibility(4);
            this.k.setVisibility(4);
            this.l = false;
        }
    }

    public boolean hasSetBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ZoomImageView zoomImageView = this.f46622h;
            return zoomImageView != null && zoomImageView.hasSetBitmap();
        }
        return invokeV.booleanValue;
    }

    public boolean loadImageByUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.f46619e;
            String str2 = this.f46620f;
            String str3 = this.f46621g;
            Uri p = o0.p(str);
            boolean z = p == null;
            this.f46623i.setVisibility(z ? 4 : 0);
            this.f46624j.setVisibility(z ? 0 : 4);
            this.k.setVisibility(0);
            if (!z) {
                this.l = false;
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("referer", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("User-Agent", str3);
                }
                ImageRequestBuilder resizeOptions = ImageRequestBuilder.newBuilderWithSource(p).setResizeOptions(new ResizeOptions(n0.o(getContext()), n0.o(getContext())));
                c.a.n0.a.c1.a.y().e(resizeOptions, hashMap);
                Fresco.getImagePipeline().fetchDecodedImage(resizeOptions.build(), getContext()).subscribe(new b(this), UiThreadImmediateExecutorService.getInstance());
            }
            return !z;
        }
        return invokeV.booleanValue;
    }

    public void setData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f46619e = str;
            this.f46620f = null;
            loadImageByUrl();
        }
    }

    public void setUA(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f46621g = str;
        }
    }

    public void zoomTo(float f2, float f3) {
        ZoomImageView zoomImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (zoomImageView = this.f46622h) == null) {
            return;
        }
        zoomImageView.zoomTo(f2, f3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PictureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f46619e = null;
        this.f46620f = null;
        this.f46621g = null;
        this.f46622h = null;
        this.f46623i = null;
        this.f46624j = null;
        this.k = null;
        this.l = false;
        this.f46619e = null;
        this.f46620f = null;
        this.f46621g = null;
        this.f46622h = null;
        this.f46623i = null;
        this.f46624j = null;
        this.k = null;
        this.l = false;
        f(context);
    }

    public void setData(String str, String str2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, cVar) == null) {
            this.m = cVar;
            this.f46619e = str;
            this.f46620f = str2;
            loadImageByUrl();
        }
    }
}
