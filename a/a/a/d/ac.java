package a.a.a.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.cloudbase.plugin.DownSoHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m.b.c.a;
import d.a.m.d.b;
import java.io.File;
/* loaded from: classes.dex */
public class ac extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1494a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1495b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1496c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1497d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1498e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1499f;

    public ac(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downSoHelper, bVar, str, file, file2, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1499f = downSoHelper;
        this.f1494a = bVar;
        this.f1495b = str;
        this.f1496c = file;
        this.f1497d = file2;
        this.f1498e = str2;
    }

    @Override // d.a.m.b.c.a
    public void onCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                this.f1496c.renameTo(this.f1497d);
                d.a.m.e.a.e(this.f1497d, this.f1498e);
                this.f1499f.h(this.f1494a, this.f1495b, this.f1498e);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.m.e.a.b(this.f1497d.getAbsolutePath());
                if (d.a.m.e.a.c(this.f1498e)) {
                    d.a.m.e.a.a(new File(this.f1498e));
                }
                this.f1499f.e(this.f1494a, this.f1495b, 108, "unzip exception");
            }
        }
    }

    @Override // d.a.m.b.c.a
    public void onFailed(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            downloadException.printStackTrace();
            d.a.m.e.a.b(this.f1496c.getAbsolutePath());
            this.f1499f.e(this.f1494a, this.f1495b, downloadException.getErrorCode(), downloadException.getErrorMessage());
        }
    }

    @Override // d.a.m.b.c.a
    public void onProgress(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f1499f.f(this.f1494a, this.f1495b, i2);
        }
    }

    @Override // d.a.m.b.c.a
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1499f.g(this.f1494a, this.f1495b);
        }
    }
}
