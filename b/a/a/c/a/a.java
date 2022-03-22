package b.a.a.c.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.a.c.a.b
    public boolean a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, file)) == null) {
            Object g2 = c.g(c.g(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
            if (g2 instanceof File[]) {
                return c.f((File[]) g2, file);
            }
            return ((ArrayList) g2).contains(file);
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.a.c.a.b
    public void b(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file) == null) {
            Object g2 = c.g(context.getClassLoader(), "pathList");
            Object g3 = c.g(g2, "nativeLibraryDirectories");
            if (g3 instanceof File[]) {
                c.e(g2, "nativeLibraryDirectories", c.c(File.class, (File[]) g3, file));
            } else {
                ((ArrayList) g3).add(file);
            }
        }
    }
}
