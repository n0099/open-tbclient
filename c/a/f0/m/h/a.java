package c.a.f0.m.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import c.a.f0.m.d;
import c.a.f0.m.h.c.a;
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
    public c.a.f0.m.h.c.a a;

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
            this.a = c.a.f0.m.h.c.a.q(b2, 1, 1, 10485760L);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a == null) {
            return;
        }
        try {
            a.c m = this.a.m(c.a.f0.m.i.b.b(str));
            if (m == null) {
                return;
            }
            if (d.b(str, m.f(0))) {
                m.e();
            } else {
                m.a();
            }
            this.a.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
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

    public Bitmap c(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, str, i2, i3)) == null) {
            if (this.a == null) {
                return null;
            }
            a.e o = this.a.o(c.a.f0.m.i.b.b(str));
            if (o != null) {
                FileInputStream fileInputStream = (FileInputStream) o.a(0);
                if (i2 > 0 && i3 > 0) {
                    return c.a.f0.m.i.a.b(fileInputStream.getFD(), i2, i3);
                }
                return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
            }
            return null;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
