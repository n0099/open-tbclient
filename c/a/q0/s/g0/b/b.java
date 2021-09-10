package c.a.q0.s.g0.b;

import c.a.e.e.p.q;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (b.class) {
                File file = new File(FileHelper.getCacheDir() + "voice");
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? FileHelper.renameTo(str, FileHelper.getFilePath(str2, 1, true)) : invokeLL.booleanValue;
    }

    public static a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            a aVar = new a();
            if (str == null) {
                aVar.f13958c = 6;
                aVar.f13959d = a.a(6);
                return aVar;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                aVar.f13958c = 7;
                aVar.f13959d = a.a(7);
                return aVar;
            }
            String b2 = q.b(FileHelper.GetStreamFromTmpFile(str));
            if (b2 == null) {
                aVar.f13958c = 5;
                aVar.f13959d = a.a(5);
            } else {
                String filePath = FileHelper.getFilePath(b2, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    aVar.f13957b = filePath;
                    aVar.f13956a = b2;
                } else {
                    aVar.f13958c = 1;
                    aVar.f13959d = a.a(1);
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
