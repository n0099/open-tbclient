package b.a.p0.a.o.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.y1.a.b.c.c;
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
    public b.a.p0.h.i.k.f.a f7430c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadParams.SwanAppDownloadType f7431d;

    public b(b.a.p0.h.i.k.f.a aVar, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType) {
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
        this.f7430c = aVar;
        this.f7431d = swanAppDownloadType;
    }

    @Override // b.a.p0.a.y1.a.b.c.a
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // b.a.p0.a.y1.a.b.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.y1.a.b.c.c, b.a.p0.a.y1.a.b.c.a
    public void onEvent(@NonNull b.a.p0.a.y1.a.b.a.b bVar) {
        Bundle a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (a2 = bVar.a()) == null || this.f7430c == null) {
            return;
        }
        int i2 = a2.getInt("state", DownloadState.NOT_START.value());
        int i3 = a2.getInt("progress", 0);
        this.f7430c.c(DownloadState.convert(i2), i3);
        this.f7430c.a(i3);
        String string = a2.getString("packageName", "");
        if (!TextUtils.isEmpty(string)) {
            this.f7430c.d(string);
        }
        if (this.f7431d == DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f7430c.f(true);
        }
    }
}
