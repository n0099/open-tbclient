package a.a.a.d.a;

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
public class ac implements bv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ac() {
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
            Object b2 = shuoy.b(context.getClassLoader(), "pathList");
            Object b3 = shuoy.b(b2, "nativeLibraryDirectories");
            if (b3 instanceof File[]) {
                shuoy.a(b2, "nativeLibraryDirectories", shuoy.a(File.class, (File[]) b3, file));
            } else {
                ((ArrayList) b3).add(file);
            }
        }
    }

    @Override // a.a.a.d.a.bv
    public boolean b(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file)) == null) {
            Object b2 = shuoy.b(shuoy.b(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
            return b2 instanceof File[] ? shuoy.a((File[]) b2, file) : ((ArrayList) b2).contains(file);
        }
        return invokeLL.booleanValue;
    }
}
