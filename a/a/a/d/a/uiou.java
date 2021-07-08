package a.a.a.d.a;

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
public class uiou implements bv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uiou() {
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

    @Override // a.a.a.d.a.bv
    public void a(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, file) == null) {
            PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
            String[] strArr = (String[]) shuoy.b(pathClassLoader, "mLibPaths");
            if (strArr != null) {
                shuoy.a(pathClassLoader, "mLibPaths", shuoy.a(String.class, strArr, file.getAbsolutePath()));
            }
        }
    }

    @Override // a.a.a.d.a.bv
    public boolean b(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file)) == null) ? shuoy.a((String[]) shuoy.b((PathClassLoader) context.getClassLoader(), "mLibPaths"), file.getAbsolutePath()) : invokeLL.booleanValue;
    }
}
