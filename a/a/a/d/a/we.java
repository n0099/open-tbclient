package a.a.a.d.a;

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
public class we implements bv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public we() {
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

    public Class a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return Class.forName("dalvik.system.DexPathList$Element");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Class) invokeV.objValue;
    }

    public Object a(Class cls, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, file)) == null) ? a.a((Class<?>) cls, (Class<?>[]) new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class}, new Object[]{file, Boolean.TRUE, null, null}) : invokeLL.objValue;
    }

    @Override // a.a.a.d.a.bv
    public void a(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, file) == null) {
            Object b2 = a.b(context.getClassLoader(), "pathList");
            Class a2 = a();
            if (a2 != null) {
                Object[] objArr = (Object[]) a.b(b2, "nativeLibraryPathElements");
                Object a3 = a(a2, file);
                if (objArr == null || a3 == null) {
                    return;
                }
                a.a(b2, "nativeLibraryPathElements", a.a(a2, objArr, a3));
            }
        }
    }

    @Override // a.a.a.d.a.bv
    public boolean b(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, file)) == null) {
            Object b2 = a.b(context.getClassLoader(), "pathList");
            if (a() != null) {
                for (Object obj : (Object[]) a.b(b2, "nativeLibraryPathElements")) {
                    if (obj.toString().contains(file.toString())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
