package a.a.a.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.cloudbase.plugin.DownSoHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.l.b.c.a;
import d.a.l.d.b;
import java.io.File;
/* loaded from: classes.dex */
public class ac extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1461a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1462b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1463c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1464d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1465e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1466f;

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
        this.f1466f = downSoHelper;
        this.f1461a = bVar;
        this.f1462b = str;
        this.f1463c = file;
        this.f1464d = file2;
        this.f1465e = str2;
    }

    @Override // d.a.l.b.c.a
    public void onCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                this.f1463c.renameTo(this.f1464d);
                d.a.l.e.a.e(this.f1464d, this.f1465e);
                this.f1466f.h(this.f1461a, this.f1462b, this.f1465e);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.l.e.a.b(this.f1464d.getAbsolutePath());
                if (d.a.l.e.a.c(this.f1465e)) {
                    d.a.l.e.a.a(new File(this.f1465e));
                }
                this.f1466f.e(this.f1461a, this.f1462b, 108, "unzip exception");
            }
        }
    }

    @Override // d.a.l.b.c.a
    public void onFailed(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            downloadException.printStackTrace();
            d.a.l.e.a.b(this.f1463c.getAbsolutePath());
            this.f1466f.e(this.f1461a, this.f1462b, downloadException.getErrorCode(), downloadException.getErrorMessage());
        }
    }

    @Override // d.a.l.b.c.a
    public void onProgress(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f1466f.f(this.f1461a, this.f1462b, i2);
        }
    }

    @Override // d.a.l.b.c.a
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1466f.g(this.f1461a, this.f1462b);
        }
    }
}
