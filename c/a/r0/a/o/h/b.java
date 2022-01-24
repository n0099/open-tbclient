package c.a.r0.a.o.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.y1.a.b.c.c;
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
    public c.a.r0.h.i.k.f.a f8162c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadParams.SwanAppDownloadType f8163d;

    public b(c.a.r0.h.i.k.f.a aVar, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType) {
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
        this.f8162c = aVar;
        this.f8163d = swanAppDownloadType;
    }

    @Override // c.a.r0.a.y1.a.b.c.a
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.r0.a.y1.a.b.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.y1.a.b.c.c, c.a.r0.a.y1.a.b.c.a
    public void onEvent(@NonNull c.a.r0.a.y1.a.b.a.b bVar) {
        Bundle a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (a = bVar.a()) == null || this.f8162c == null) {
            return;
        }
        int i2 = a.getInt("state", DownloadState.NOT_START.value());
        int i3 = a.getInt("progress", 0);
        this.f8162c.c(DownloadState.convert(i2), i3);
        this.f8162c.a(i3);
        String string = a.getString("packageName", "");
        if (!TextUtils.isEmpty(string)) {
            this.f8162c.d(string);
        }
        if (this.f8163d == DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f8162c.f(true);
        }
    }
}
