package c.a.p0.a.o.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.v1.a.b.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f.i.k.f.a f7788c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadParams.SwanAppDownloadType f7789d;

    public b(c.a.p0.f.i.k.f.a aVar, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, swanAppDownloadType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7788c = aVar;
        this.f7789d = swanAppDownloadType;
    }

    @Override // c.a.p0.a.v1.a.b.c.a
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.p0.a.v1.a.b.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.v1.a.b.c.c, c.a.p0.a.v1.a.b.c.a
    public void onEvent(@NonNull c.a.p0.a.v1.a.b.a.b bVar) {
        Bundle a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (a2 = bVar.a()) == null || this.f7788c == null) {
            return;
        }
        int i2 = a2.getInt("state", DownloadState.NOT_START.value());
        int i3 = a2.getInt("progress", 0);
        this.f7788c.c(DownloadState.convert(i2), i3);
        this.f7788c.a(i3);
        String string = a2.getString("packageName", "");
        if (!TextUtils.isEmpty(string)) {
            this.f7788c.d(string);
        }
        if (this.f7789d == DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f7788c.f(true);
        }
    }
}
