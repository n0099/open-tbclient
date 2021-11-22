package b.a.j0.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import b.a.f0.b.g.i;
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

    /* renamed from: a  reason: collision with root package name */
    public Context f3109a;

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
        this.f3109a = context;
    }

    public Bitmap a(String str, b.a.j0.a.e.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, aVar)) == null) {
            File a2 = i.a(str);
            if (a2 != null && a2.exists() && a2.isFile()) {
                return BitmapFactory.decodeFile(a2.getAbsolutePath());
            }
            return MaterialLoader.k(this.f3109a).i(str, aVar);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public String b(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, materialCacheType)) == null) {
            try {
                File a2 = i.a(str);
                if (a2 != null && a2.exists() && a2.isFile()) {
                    return a2.getAbsolutePath();
                }
                return MaterialLoader.k(this.f3109a).m(str, materialCacheType);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public boolean c(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, materialCacheType)) == null) ? MaterialLoader.k(this.f3109a).o(str, materialCacheType) || d(str) : invokeLL.booleanValue;
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            File a2 = i.a(str);
            return a2 != null && a2.exists() && a2.isFile();
        }
        return invokeL.booleanValue;
    }
}
