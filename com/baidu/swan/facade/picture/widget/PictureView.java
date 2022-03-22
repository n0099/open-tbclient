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
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.swan.facade.picture.widget.BdImageViewTouch;
import com.baidu.swan.facade.picture.widget.BdImageViewTouchBase;
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class PictureView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f29440b;

    /* renamed from: c  reason: collision with root package name */
    public String f29441c;

    /* renamed from: d  reason: collision with root package name */
    public ZoomImageView f29442d;

    /* renamed from: e  reason: collision with root package name */
    public View f29443e;

    /* renamed from: f  reason: collision with root package name */
    public View f29444f;

    /* renamed from: g  reason: collision with root package name */
    public View f29445g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29446h;
    public c i;

    /* loaded from: classes4.dex */
    public class a implements BdImageViewTouch.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PictureView a;

        public a(PictureView pictureView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pictureView;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a.f()) {
                    if (this.a.f29446h) {
                        this.a.h();
                    }
                } else if (this.a.getContext() instanceof View.OnClickListener) {
                    ((View.OnClickListener) this.a.getContext()).onClick(this.a.f29442d);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PictureView a;

        public b(PictureView pictureView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pictureView;
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
                this.a.i();
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
                        this.a.f29442d.setImageBitmap(copy);
                        this.a.j();
                        if (this.a.i != null) {
                            this.a.i.b();
                            return;
                        }
                        return;
                    } catch (OutOfMemoryError unused) {
                        System.gc();
                    }
                }
                if (this.a.i != null) {
                    this.a.i.a();
                }
                this.a.i();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ZoomImageView zoomImageView = this.f29442d;
            return zoomImageView != null && zoomImageView.M();
        }
        return invokeV.booleanValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07c7, this);
            this.f29442d = (ZoomImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0924de);
            this.f29443e = inflate.findViewById(R.id.obfuscated_res_0x7f09183a);
            this.f29444f = inflate.findViewById(R.id.obfuscated_res_0x7f091a38);
            this.f29445g = inflate.findViewById(R.id.obfuscated_res_0x7f09183b);
            this.f29442d.setDisplayType(BdImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
            this.f29442d.setZoomRange(1.0f, 3.0f);
            this.f29442d.setDoubleTapEnabled(true);
            this.f29442d.setSingleTapListener(new a(this));
        }
    }

    public View getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29442d : (View) invokeV.objValue;
    }

    public Bitmap getImageViewBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ZoomImageView zoomImageView = this.f29442d;
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

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = this.a;
            String str2 = this.f29440b;
            String str3 = this.f29441c;
            Uri p = o0.p(str);
            boolean z = p == null;
            this.f29443e.setVisibility(z ? 4 : 0);
            this.f29444f.setVisibility(z ? 0 : 4);
            this.f29445g.setVisibility(0);
            if (!z) {
                this.f29446h = false;
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put(Config.LAUNCH_REFERER, str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("User-Agent", str3);
                }
                ImageRequestBuilder resizeOptions = ImageRequestBuilder.newBuilderWithSource(p).setResizeOptions(new ResizeOptions(n0.o(getContext()), n0.o(getContext())));
                c.a.n0.a.s0.a.C().e(resizeOptions, hashMap);
                Fresco.getImagePipeline().fetchDecodedImage(resizeOptions.build(), getContext()).subscribe(new b(this), UiThreadImmediateExecutorService.getInstance());
            }
            return !z;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29444f.setVisibility(0);
            this.f29443e.setVisibility(4);
            this.f29445g.setVisibility(0);
            this.f29446h = true;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29444f.setVisibility(4);
            this.f29443e.setVisibility(4);
            this.f29445g.setVisibility(4);
            this.f29446h = false;
        }
    }

    public void setData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.a = str;
            this.f29440b = null;
            h();
        }
    }

    public void setUA(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f29441c = str;
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f29440b = null;
        this.f29441c = null;
        this.f29442d = null;
        this.f29443e = null;
        this.f29444f = null;
        this.f29445g = null;
        this.f29446h = false;
        this.a = null;
        this.f29440b = null;
        this.f29441c = null;
        this.f29442d = null;
        this.f29443e = null;
        this.f29444f = null;
        this.f29445g = null;
        this.f29446h = false;
        g(context);
    }

    public void setData(String str, String str2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, cVar) == null) {
            this.i = cVar;
            this.a = str;
            this.f29440b = str2;
            h();
        }
    }
}
