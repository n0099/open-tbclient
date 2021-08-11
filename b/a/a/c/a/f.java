package b.a.a.c.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexFile;
import java.io.File;
/* loaded from: classes.dex */
public class f implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    @Override // b.a.a.c.a.b
    public boolean a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, file)) == null) {
            Object g2 = c.g(context.getClassLoader(), "pathList");
            if (c() != null) {
                for (Object obj : (Object[]) c.g(g2, "nativeLibraryPathElements")) {
                    if (obj.toString().contains(file.toString())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.a.c.a.b
    public void b(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file) == null) {
            Object g2 = c.g(context.getClassLoader(), "pathList");
            Class c2 = c();
            if (c2 != null) {
                Object[] objArr = (Object[]) c.g(g2, "nativeLibraryPathElements");
                Object d2 = d(c2, file);
                if (objArr == null || d2 == null) {
                    return;
                }
                c.e(g2, "nativeLibraryPathElements", c.c(c2, objArr, d2));
            }
        }
    }

    public Class c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return Class.forName("dalvik.system.DexPathList$Element");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Class) invokeV.objValue;
    }

    public Object d(Class cls, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, file)) == null) ? c.b(cls, new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class}, new Object[]{file, Boolean.TRUE, null, null}) : invokeLL.objValue;
    }
}
