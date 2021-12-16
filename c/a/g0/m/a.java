package c.a.g0.m;

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
    public static a f3143b;

    /* renamed from: c  reason: collision with root package name */
    public static e f3144c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.g0.m.h.b f3145d;

    /* renamed from: e  reason: collision with root package name */
    public static c.a.g0.m.h.a f3146e;
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
        f3145d = new c.a.g0.m.h.b();
        f3146e = new c.a.g0.m.h.a(context);
        f3144c = new e();
    }

    public static c.a.g0.m.h.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f3146e == null) {
                f3146e = new c.a.g0.m.h.a(context);
            }
            return f3146e;
        }
        return (c.a.g0.m.h.a) invokeL.objValue;
    }

    public static c.a.g0.m.h.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f3145d == null) {
                f3145d = new c.a.g0.m.h.b();
            }
            return f3145d;
        }
        return (c.a.g0.m.h.b) invokeV.objValue;
    }

    public static a d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f3143b == null) {
                synchronized (a.class) {
                    if (f3143b == null) {
                        f3143b = new a(context);
                    }
                }
            }
            return f3143b;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.g0.m.c
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
            Bitmap c2 = f3145d.c(str);
            if (c2 != null) {
                imageView.setImageBitmap(c2);
            } else {
                c.a.g0.q.a.a(new g(this.a, f3144c, str, imageView, i2, i3));
            }
        }
    }
}
