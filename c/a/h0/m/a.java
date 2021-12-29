package c.a.h0.m;

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
    public static a f3604b;

    /* renamed from: c  reason: collision with root package name */
    public static e f3605c;

    /* renamed from: d  reason: collision with root package name */
    public static c.a.h0.m.h.b f3606d;

    /* renamed from: e  reason: collision with root package name */
    public static c.a.h0.m.h.a f3607e;
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
        f3606d = new c.a.h0.m.h.b();
        f3607e = new c.a.h0.m.h.a(context);
        f3605c = new e();
    }

    public static c.a.h0.m.h.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f3607e == null) {
                f3607e = new c.a.h0.m.h.a(context);
            }
            return f3607e;
        }
        return (c.a.h0.m.h.a) invokeL.objValue;
    }

    public static c.a.h0.m.h.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f3606d == null) {
                f3606d = new c.a.h0.m.h.b();
            }
            return f3606d;
        }
        return (c.a.h0.m.h.b) invokeV.objValue;
    }

    public static a d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f3604b == null) {
                synchronized (a.class) {
                    if (f3604b == null) {
                        f3604b = new a(context);
                    }
                }
            }
            return f3604b;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.h0.m.c
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
            Bitmap c2 = f3606d.c(str);
            if (c2 != null) {
                imageView.setImageBitmap(c2);
            } else {
                c.a.h0.q.a.a(new g(this.a, f3605c, str, imageView, i2, i3));
            }
        }
    }
}
