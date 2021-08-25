package c.a.e0.k.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import c.a.e0.k.d.d;
import c.a.e0.k.f.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e0.k.f.a f3153a;

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
        File b2 = b(context, "bitmap");
        if (!b2.exists()) {
            b2.mkdirs();
        }
        try {
            this.f3153a = c.a.e0.k.f.a.j(b2, 1, 1, 10485760L);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public Bitmap a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, str, i2, i3)) == null) {
            if (this.f3153a == null) {
                return null;
            }
            a.e w = this.f3153a.w(c.a.e0.k.g.b.b(str));
            if (w != null) {
                FileInputStream fileInputStream = (FileInputStream) w.a(0);
                if (i2 > 0 && i3 > 0) {
                    return c.a.e0.k.g.a.b(fileInputStream.getFD(), i2, i3);
                }
                return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
            }
            return null;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public File b(Context context, String str) {
        InterceptResult invokeLL;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
                path = context.getExternalCacheDir().getPath();
            } else {
                path = context.getCacheDir().getPath();
            }
            return new File(path + File.separator + str);
        }
        return (File) invokeLL.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f3153a == null) {
            return;
        }
        try {
            a.c u = this.f3153a.u(c.a.e0.k.g.b.b(str));
            if (u == null) {
                return;
            }
            if (d.a(str, u.e(0))) {
                u.f();
            } else {
                u.c();
            }
            this.f3153a.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
