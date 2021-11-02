package a.a.a.c.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.PathClassLoader;
import java.io.File;
/* loaded from: classes.dex */
public class e implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // a.a.a.c.a.b
    public boolean a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, file)) == null) ? c.f((String[]) c.g((PathClassLoader) context.getClassLoader(), "mLibPaths"), file.getAbsolutePath()) : invokeLL.booleanValue;
    }

    @Override // a.a.a.c.a.b
    public void b(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file) == null) {
            PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
            String[] strArr = (String[]) c.g(pathClassLoader, "mLibPaths");
            if (strArr != null) {
                c.e(pathClassLoader, "mLibPaths", c.c(String.class, strArr, file.getAbsolutePath()));
            }
        }
    }
}
