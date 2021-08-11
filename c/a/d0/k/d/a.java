package c.a.d0.k.d;

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
    public static a f1773b;

    /* renamed from: c  reason: collision with root package name */
    public static e f1774c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.d0.k.e.b f1775d;

    /* renamed from: e  reason: collision with root package name */
    public static c.a.d0.k.e.a f1776e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f1777a;

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
        this.f1777a = context.getApplicationContext();
        f1775d = new c.a.d0.k.e.b();
        f1776e = new c.a.d0.k.e.a(context);
        f1774c = new e();
    }

    public static c.a.d0.k.e.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f1775d == null) {
                f1775d = new c.a.d0.k.e.b();
            }
            return f1775d;
        }
        return (c.a.d0.k.e.b) invokeV.objValue;
    }

    public static c.a.d0.k.e.a c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f1776e == null) {
                f1776e = new c.a.d0.k.e.a(context);
            }
            return f1776e;
        }
        return (c.a.d0.k.e.a) invokeL.objValue;
    }

    public static a e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f1773b == null) {
                synchronized (a.class) {
                    if (f1773b == null) {
                        f1773b = new a(context);
                    }
                }
            }
            return f1773b;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.d0.k.d.c
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
            Bitmap b2 = f1775d.b(str);
            if (b2 != null) {
                imageView.setImageBitmap(b2);
            } else {
                c.a.d0.m.a.a(new g(this.f1777a, f1774c, str, imageView, i2, i3));
            }
        }
    }
}
