package c.p.a.e.a.f;

import android.content.Context;
import c.p.a.e.b.f.p;
import c.p.a.e.b.g.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes4.dex */
public class b extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f35003b;

    /* renamed from: c  reason: collision with root package name */
    public int f35004c;

    /* renamed from: d  reason: collision with root package name */
    public String f35005d;

    /* renamed from: e  reason: collision with root package name */
    public String f35006e;

    /* renamed from: f  reason: collision with root package name */
    public String f35007f;

    /* renamed from: g  reason: collision with root package name */
    public String f35008g;

    /* renamed from: h  reason: collision with root package name */
    public c.p.a.e.b.p.a f35009h;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context != null) {
            this.f35003b = context.getApplicationContext();
        } else {
            this.f35003b = e.n();
        }
        this.f35004c = i2;
        this.f35005d = str;
        this.f35006e = str2;
        this.f35007f = str3;
        this.f35008g = str4;
    }

    @Override // c.p.a.e.b.f.p, c.p.a.e.b.f.a, c.p.a.e.b.f.c
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.b(downloadInfo);
    }

    @Override // c.p.a.e.b.f.p, c.p.a.e.b.f.a, c.p.a.e.b.f.c
    public void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.c(downloadInfo);
    }

    @Override // c.p.a.e.b.f.p, c.p.a.e.b.f.a, c.p.a.e.b.f.c
    public void f(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) || downloadInfo == null || this.f35003b == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.f(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            c.p.a.e.a.h.c.a(downloadInfo);
        }
    }

    @Override // c.p.a.e.b.f.p, c.p.a.e.b.f.a, c.p.a.e.b.f.c
    public void g(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.g(downloadInfo);
    }

    @Override // c.p.a.e.b.f.p, c.p.a.e.b.f.a, c.p.a.e.b.f.c
    public void h(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, downloadInfo, baseException) == null) || downloadInfo == null || this.f35003b == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.h(downloadInfo, baseException);
    }

    @Override // c.p.a.e.b.f.p, c.p.a.e.b.f.a, c.p.a.e.b.f.c
    public void l(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.l(downloadInfo);
    }

    @Override // c.p.a.e.b.f.p
    public c.p.a.e.b.p.a n() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f35009h == null && (context = this.f35003b) != null) {
                return new a(context, this.f35004c, this.f35005d, this.f35006e, this.f35007f, this.f35008g);
            }
            return this.f35009h;
        }
        return (c.p.a.e.b.p.a) invokeV.objValue;
    }

    public b(c.p.a.e.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35003b = e.n();
        this.f35009h = aVar;
    }
}
