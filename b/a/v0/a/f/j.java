package b.a.v0.a.f;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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

        @Override // b.a.v0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f.a(com.baidu.ubs.analytics.d.a.f56625b)) {
                    for (File file : j.a(com.baidu.ubs.analytics.d.a.f56625b)) {
                        if (b.a.v0.a.d.b.c(b.a.v0.a.d.b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), null)) {
                            f.b(file.getPath());
                        }
                    }
                }
                if (f.a(com.baidu.ubs.analytics.d.a.f56626c)) {
                    for (File file2 : j.a(com.baidu.ubs.analytics.d.a.f56626c)) {
                        if (!file2.getName().equals(b.a.v0.a.f.a.e()) && b.a.v0.a.d.b.c(b.a.v0.a.d.b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), null)) {
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
                if (name.endsWith(DocumentOpenUtil.TXT) || name.endsWith(TbConfig.TMP_LOG_DIR_NAME)) {
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
