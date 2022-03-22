package c.a.o0.r.m0.b;

import c.a.d.f.p.t;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes2.dex */
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
                aVar.f10732c = 6;
                aVar.f10733d = a.a(6);
                return aVar;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                aVar.f10732c = 7;
                aVar.f10733d = a.a(7);
                return aVar;
            }
            String b2 = t.b(FileHelper.GetStreamFromTmpFile(str));
            if (b2 == null) {
                aVar.f10732c = 5;
                aVar.f10733d = a.a(5);
            } else {
                String filePath = FileHelper.getFilePath(b2, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    aVar.f10731b = filePath;
                    aVar.a = b2;
                } else {
                    aVar.f10732c = 1;
                    aVar.f10733d = a.a(1);
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
