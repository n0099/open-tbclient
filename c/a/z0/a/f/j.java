package c.a.z0.a.f;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // c.a.z0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f.a(com.baidu.ubs.analytics.d.a.f50494b)) {
                    for (File file : j.a(com.baidu.ubs.analytics.d.a.f50494b)) {
                        if (c.a.z0.a.d.b.c(c.a.z0.a.d.b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), null)) {
                            f.b(file.getPath());
                        }
                    }
                }
                if (f.a(com.baidu.ubs.analytics.d.a.f50495c)) {
                    for (File file2 : j.a(com.baidu.ubs.analytics.d.a.f50495c)) {
                        if (!file2.getName().equals(c.a.z0.a.f.a.e()) && c.a.z0.a.d.b.c(c.a.z0.a.d.b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), null)) {
                            f.b(file2.getPath());
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ List a(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                String name = listFiles[i2].getName();
                if (name.endsWith("txt") || name.endsWith(TbConfig.TMP_LOG_DIR_NAME)) {
                    arrayList.add(listFiles[i2]);
                }
            }
        }
        return arrayList;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            b.a(new a());
        }
    }
}
