package c.a.e0.d;

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
    public static a f2741b;

    /* renamed from: c  reason: collision with root package name */
    public static e f2742c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.e0.d.h.b f2743d;

    /* renamed from: e  reason: collision with root package name */
    public static c.a.e0.d.h.a f2744e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        f2743d = new c.a.e0.d.h.b();
        f2744e = new c.a.e0.d.h.a(context);
        f2742c = new e();
    }

    public static c.a.e0.d.h.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f2744e == null) {
                f2744e = new c.a.e0.d.h.a(context);
            }
            return f2744e;
        }
        return (c.a.e0.d.h.a) invokeL.objValue;
    }

    public static c.a.e0.d.h.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f2743d == null) {
                f2743d = new c.a.e0.d.h.b();
            }
            return f2743d;
        }
        return (c.a.e0.d.h.b) invokeV.objValue;
    }

    public static a d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f2741b == null) {
                synchronized (a.class) {
                    if (f2741b == null) {
                        f2741b = new a(context);
                    }
                }
            }
            return f2741b;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.e0.d.c
    public void a(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) {
            e(imageView, str, 0, 0);
        }
    }

    public void e(ImageView imageView, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, str, i, i2) == null) {
            imageView.setTag(str);
            Bitmap c2 = f2743d.c(str);
            if (c2 != null) {
                imageView.setImageBitmap(c2);
            } else {
                c.a.e0.h.a.a(new g(this.a, f2742c, str, imageView, i, i2));
            }
        }
    }
}
