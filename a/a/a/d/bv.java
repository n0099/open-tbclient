package a.a.a.d;

import android.util.Log;
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
public class bv extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1500a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1501b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f1502c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f1503d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1504e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ DownSoHelper f1505f;

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
        this.f1505f = downSoHelper;
        this.f1500a = bVar;
        this.f1501b = str;
        this.f1502c = file;
        this.f1503d = file2;
        this.f1504e = str2;
    }

    @Override // d.a.m.b.c.a
    public void onCompleted(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                this.f1502c.renameTo(this.f1503d);
                Log.e("RtcDownSo", "unzip:" + this.f1503d + "---" + this.f1504e);
                d.a.m.e.a.e(this.f1503d, this.f1504e);
                d.a.m.e.a.b(this.f1503d.getAbsolutePath());
                this.f1505f.h(this.f1500a, this.f1501b, this.f1504e);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.m.e.a.b(this.f1503d.getAbsolutePath());
                if (d.a.m.e.a.c(this.f1504e)) {
                    d.a.m.e.a.a(new File(this.f1504e));
                }
                this.f1505f.e(this.f1500a, this.f1501b, 108, "unzip exception");
            }
        }
    }

    @Override // d.a.m.b.c.a
    public void onFailed(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            downloadException.printStackTrace();
            d.a.m.e.a.b(this.f1502c.getAbsolutePath());
            this.f1505f.e(this.f1500a, this.f1501b, downloadException.getErrorCode(), downloadException.getErrorMessage());
        }
    }

    @Override // d.a.m.b.c.a
    public void onProgress(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f1505f.f(this.f1500a, this.f1501b, i2);
        }
    }

    @Override // d.a.m.b.c.a
    public void onStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1505f.g(this.f1500a, this.f1501b);
        }
    }
}
