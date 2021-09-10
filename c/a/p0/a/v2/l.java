package c.a.p0.a.v2;

import androidx.annotation.Nullable;
import c.a.p0.a.v2.k0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            List<k0.a> d2 = c.a.p0.a.f1.c.a.d();
            if (d2 == null || d2.size() <= 0) {
                return null;
            }
            File file = new File(d2.get(0).f9358a, "/debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new File(c.a.p0.a.f1.c.a.d().get(0).f9358a, "/debug/").getAbsolutePath() : (String) invokeV.objValue;
    }
}
