package c.a.f0.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f3286b;

    /* renamed from: c  reason: collision with root package name */
    public static e f3287c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.f0.d.h.b f3288d;

    /* renamed from: e  reason: collision with root package name */
    public static c.a.f0.d.h.a f3289e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        f3288d = new c.a.f0.d.h.b();
        f3289e = new c.a.f0.d.h.a(context);
        f3287c = new e();
    }

    public static c.a.f0.d.h.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f3289e == null) {
                f3289e = new c.a.f0.d.h.a(context);
            }
            return f3289e;
        }
        return (c.a.f0.d.h.a) invokeL.objValue;
    }

    public static c.a.f0.d.h.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f3288d == null) {
                f3288d = new c.a.f0.d.h.b();
            }
            return f3288d;
        }
        return (c.a.f0.d.h.b) invokeV.objValue;
    }

    public static a d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f3286b == null) {
                synchronized (a.class) {
                    if (f3286b == null) {
                        f3286b = new a(context);
                    }
                }
            }
            return f3286b;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.f0.d.c
    public void a(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) {
            e(imageView, str, 0, 0);
        }
    }

    public void e(ImageView imageView, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str, i2, i3) == null) {
            imageView.setTag(str);
            Bitmap c2 = f3288d.c(str);
            if (c2 != null) {
                imageView.setImageBitmap(c2);
            } else {
                c.a.f0.h.a.a(new g(this.a, f3287c, str, imageView, i2, i3));
            }
        }
    }
}
