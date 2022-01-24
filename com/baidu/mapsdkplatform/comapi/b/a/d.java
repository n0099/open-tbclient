package com.baidu.mapsdkplatform.comapi.b.a;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class d implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ c a;

    public d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        File[] listFiles;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || h.a().b() == null) {
            return;
        }
        str = c.a;
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        try {
            Arrays.sort(listFiles, new e());
        } catch (Exception unused) {
        }
        int length = listFiles.length;
        if (length > 10) {
            length = 10;
        }
        for (int i2 = 0; i2 < length; i2++) {
            File file2 = listFiles[i2];
            if (!file2.isDirectory() && file2.exists() && file2.isFile()) {
                String name = file2.getName();
                str2 = c.f35808b;
                if (name.contains(str2) && (file2.getName().endsWith(DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION) || (file2.getName().endsWith(".zip") && file2.exists()))) {
                    this.a.a(file2);
                }
            }
        }
        if (listFiles.length > 10) {
            this.a.a(listFiles);
        }
    }
}
