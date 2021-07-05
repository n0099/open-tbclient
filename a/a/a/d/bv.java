package a.a.a.d;

import android.util.Log;
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
public class bv extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1467a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1468b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1469c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1470d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1471e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1472f;

    public bv(DownSoHelper downSoHelper, b bVar, String str, File file, File file2, String str2) {
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
        this.f1472f = downSoHelper;
        this.f1467a = bVar;
        this.f1468b = str;
        this.f1469c = file;
        this.f1470d = file2;
        this.f1471e = str2;
    }

    @Override // d.a.l.b.c.a
    public void onCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                this.f1469c.renameTo(this.f1470d);
                Log.e("RtcDownSo", "unzip:" + this.f1470d + "---" + this.f1471e);
                d.a.l.e.a.e(this.f1470d, this.f1471e);
                d.a.l.e.a.b(this.f1470d.getAbsolutePath());
                this.f1472f.h(this.f1467a, this.f1468b, this.f1471e);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.l.e.a.b(this.f1470d.getAbsolutePath());
                if (d.a.l.e.a.c(this.f1471e)) {
                    d.a.l.e.a.a(new File(this.f1471e));
                }
                this.f1472f.e(this.f1467a, this.f1468b, 108, "unzip exception");
            }
        }
    }

    @Override // d.a.l.b.c.a
    public void onFailed(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            downloadException.printStackTrace();
            d.a.l.e.a.b(this.f1469c.getAbsolutePath());
            this.f1472f.e(this.f1467a, this.f1468b, downloadException.getErrorCode(), downloadException.getErrorMessage());
        }
    }

    @Override // d.a.l.b.c.a
    public void onProgress(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f1472f.f(this.f1467a, this.f1468b, i2);
        }
    }

    @Override // d.a.l.b.c.a
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1472f.g(this.f1467a, this.f1468b);
        }
    }
}
