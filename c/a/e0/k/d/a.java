package c.a.e0.k.d;

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
    public static a f3137b;

    /* renamed from: c  reason: collision with root package name */
    public static e f3138c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.e0.k.e.b f3139d;

    /* renamed from: e  reason: collision with root package name */
    public static c.a.e0.k.e.a f3140e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3141a;

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
        this.f3141a = context.getApplicationContext();
        f3139d = new c.a.e0.k.e.b();
        f3140e = new c.a.e0.k.e.a(context);
        f3138c = new e();
    }

    public static c.a.e0.k.e.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f3139d == null) {
                f3139d = new c.a.e0.k.e.b();
            }
            return f3139d;
        }
        return (c.a.e0.k.e.b) invokeV.objValue;
    }

    public static c.a.e0.k.e.a c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f3140e == null) {
                f3140e = new c.a.e0.k.e.a(context);
            }
            return f3140e;
        }
        return (c.a.e0.k.e.a) invokeL.objValue;
    }

    public static a e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f3137b == null) {
                synchronized (a.class) {
                    if (f3137b == null) {
                        f3137b = new a(context);
                    }
                }
            }
            return f3137b;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.e0.k.d.c
    public void a(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) {
            d(imageView, str, 0, 0);
        }
    }

    public void d(ImageView imageView, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str, i2, i3) == null) {
            imageView.setTag(str);
            Bitmap b2 = f3139d.b(str);
            if (b2 != null) {
                imageView.setImageBitmap(b2);
            } else {
                c.a.e0.m.a.a(new g(this.f3141a, f3138c, str, imageView, i2, i3));
            }
        }
    }
}
