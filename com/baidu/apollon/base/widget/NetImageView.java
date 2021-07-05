package com.baidu.apollon.base.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class NetImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3627a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3628b = "NetImageView";

    /* renamed from: c  reason: collision with root package name */
    public static String f3629c;

    /* renamed from: d  reason: collision with root package name */
    public static String f3630d;

    /* renamed from: e  reason: collision with root package name */
    public static String f3631e;

    /* renamed from: f  reason: collision with root package name */
    public static String f3632f;

    /* renamed from: g  reason: collision with root package name */
    public static String f3633g;

    /* renamed from: h  reason: collision with root package name */
    public static String f3634h;

    /* renamed from: i  reason: collision with root package name */
    public static String f3635i;
    public static String j;
    public static Handler k;
    public static HashMap<String, Integer> l;
    public transient /* synthetic */ FieldHolder $fh;
    public String m;
    public Drawable n;
    public Drawable o;
    public boolean p;
    public int q;
    public int r;
    public ImageView.ScaleType s;
    public boolean t;
    public int u;
    public ImageLoader.OnGetBitmapListener v;

    /* loaded from: classes.dex */
    public static class a implements ImageLoader.OnGetBitmapListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<NetImageView> f3636a;

        public a(NetImageView netImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3636a = new WeakReference<>(netImageView);
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public boolean needCancel(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
                WeakReference<NetImageView> weakReference = this.f3636a;
                boolean z = false;
                if (weakReference != null) {
                    NetImageView netImageView = weakReference.get();
                    if (netImageView == null) {
                        return false;
                    }
                    z = (netImageView.o == null && TextUtils.equals(str, netImageView.m)) ? true : true;
                    if (NetImageView.f3627a && z) {
                        Log.i(NetImageView.f3628b, "Canceled   url: " + str);
                    }
                }
                return z;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onError(String str, Object obj) {
            NetImageView netImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) && NetImageView.f3627a) {
                Log.d(NetImageView.f3628b, "getImage error: " + str);
                WeakReference<NetImageView> weakReference = this.f3636a;
                if (weakReference == null || (netImageView = weakReference.get()) == null) {
                    return;
                }
                netImageView.post(new Runnable(this, netImageView, str) { // from class: com.baidu.apollon.base.widget.NetImageView.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NetImageView f3641a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f3642b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f3643c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, netImageView, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f3643c = this;
                        this.f3641a = netImageView;
                        this.f3642b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && TextUtils.equals(this.f3641a.m, this.f3642b)) {
                            this.f3641a.onLoadUrlError(true);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
            WeakReference<NetImageView> weakReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, bitmap) == null) || (weakReference = this.f3636a) == null) {
                return;
            }
            NetImageView netImageView = weakReference.get();
            if (NetImageView.k == null || netImageView == null) {
                return;
            }
            NetImageView.k.post(new Runnable(this, netImageView, str, bitmap) { // from class: com.baidu.apollon.base.widget.NetImageView.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NetImageView f3637a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f3638b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Bitmap f3639c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f3640d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, netImageView, str, bitmap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f3640d = this;
                    this.f3637a = netImageView;
                    this.f3638b = str;
                    this.f3639c = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f3637a.setRemoteDrawable(this.f3638b, this.f3639c);
                    }
                }
            });
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438633741, "Lcom/baidu/apollon/base/widget/NetImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438633741, "Lcom/baidu/apollon/base/widget/NetImageView;");
                return;
            }
        }
        f3627a = ApollonConstants.DEBUG & true;
        f3629c = "ldpi";
        f3630d = "mdpi";
        f3631e = "hdpi";
        f3632f = "xhdpi";
        f3633g = "xxhdpi";
        f3634h = "xxxhdpi";
        f3635i = "tvdpi";
        j = "density";
        HashMap<String, Integer> hashMap = new HashMap<>();
        l = hashMap;
        hashMap.put(f3629c, 120);
        l.put(f3630d, 160);
        l.put(f3635i, 213);
        l.put(f3631e, 240);
        l.put(f3632f, Integer.valueOf((int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP));
        l.put(f3633g, 480);
        l.put(f3634h, 640);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.t = false;
        this.v = new a(this);
        setDensity(attributeSet);
        a(context);
    }

    private void c() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        int i2 = this.q;
        if (i2 != Integer.MIN_VALUE) {
            layoutParams.width = i2;
        }
        int i3 = this.r;
        if (i3 != Integer.MIN_VALUE) {
            layoutParams.height = i3;
        }
    }

    private void setDensity(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(null, j);
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        Integer num = l.get(attributeValue.trim().toLowerCase());
        if (num != null) {
            this.u = num.intValue();
        }
    }

    public void callRealSetImageDrawable(Drawable drawable, boolean z) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, drawable, z) == null) {
            if (hasRemoteDrawableDone() && (drawable2 = this.o) != null) {
                super.setImageDrawable(drawable2);
                return;
            }
            c();
            if (drawable != null) {
                super.setImageDrawable(drawable);
            }
            if (z) {
                requestLoadingRemoteImage();
            }
        }
    }

    public boolean hasRemoteDrawableDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o != null : invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.t) {
                releaseRemoteDrawable();
            }
            this.v = null;
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (!this.p && !hasRemoteDrawableDone()) {
                requestLoadingRemoteImage();
            }
            super.onDraw(canvas);
        }
    }

    public void onLoadUrlError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    public void releaseRemoteDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m = null;
            this.o = null;
            callRealSetImageDrawable(this.n, false);
        }
    }

    public void requestLoadingRemoteImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (hasRemoteDrawableDone()) {
                callRealSetImageDrawable(this.o, false);
            } else if (this.p || TextUtils.isEmpty(this.m)) {
            } else {
                ImageLoader.getInstance(getContext()).getBitmapFromDiskOrNet(this.m, this.v, null, this.u);
                this.p = true;
            }
        }
    }

    public void setDefaultSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.q = i2;
            this.r = i3;
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            super.setImageDrawable(drawable);
            this.m = null;
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.m = null;
            try {
                this.n = getResources().getDrawable(i2);
            } catch (Exception unused) {
                this.n = null;
            }
            Drawable drawable = this.n;
            setImageDrawable(drawable != null ? drawable : null);
        }
    }

    public void setImageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            setImageUrl(str, true);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            c();
        }
    }

    public void setReleaseWhenDetachFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.t = z;
        }
    }

    public void setRemoteDrawable(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, bitmap) == null) && this.o == null && TextUtils.equals(str, this.m)) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            this.o = bitmapDrawable;
            callRealSetImageDrawable(bitmapDrawable, false);
            if (f3627a) {
                Log.d(f3628b, "getImage ok: " + this.o.getIntrinsicWidth() + "x" + this.o.getIntrinsicHeight() + " url: " + str);
            }
        }
    }

    public void setImageUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) {
            if (TextUtils.isEmpty(str)) {
                this.m = null;
            } else if (TextUtils.equals(this.m, str)) {
            } else {
                if (f3627a) {
                    Log.d(f3628b, "req: " + z + " img url: " + str);
                }
                this.m = str;
                this.o = null;
                this.p = false;
                Bitmap bitmapFromMemCache = ImageLoader.getInstance(getContext()).getBitmapFromMemCache(this.m);
                if (bitmapFromMemCache != null) {
                    setRemoteDrawable(this.m, bitmapFromMemCache);
                } else {
                    callRealSetImageDrawable(this.n, z);
                }
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            if (k == null) {
                synchronized (NetImageView.class) {
                    if (k == null) {
                        k = new Handler(context.getMainLooper());
                    }
                }
            }
            if (this.s == null) {
                this.s = ImageView.ScaleType.FIT_CENTER;
            }
            this.q = Integer.MIN_VALUE;
            this.r = Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.t = false;
        this.v = new a(this);
        setDensity(attributeSet);
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = false;
        this.v = new a(this);
        a(context);
    }
}
