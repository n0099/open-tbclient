package c.a.n0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import c.a.j0.b.f.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public b(Context context) {
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
        this.a = context;
    }

    public Bitmap a(String str, c.a.n0.a.f.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, aVar)) == null) {
            try {
                File a = h.a(str);
                if (a != null && a.exists() && a.isFile()) {
                    return BitmapFactory.decodeFile(a.getAbsolutePath());
                }
            } catch (OutOfMemoryError unused) {
            }
            return MaterialLoader.k(this.a).i(str, aVar);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public String b(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, materialCacheType)) == null) {
            try {
                File a = h.a(str);
                if (a != null && a.exists() && a.isFile()) {
                    return a.getAbsolutePath();
                }
                return MaterialLoader.k(this.a).m(str, materialCacheType);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public boolean c(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, materialCacheType)) == null) ? MaterialLoader.k(this.a).o(str, materialCacheType) || d(str) : invokeLL.booleanValue;
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            File a = h.a(str);
            return a != null && a.exists() && a.isFile();
        }
        return invokeL.booleanValue;
    }
}
