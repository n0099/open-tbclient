package a.a.a.a.u.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.express2.MediaEventListener;
/* loaded from: classes.dex */
public class d implements MediaEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1184a;

    public d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1184a = bVar;
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a.a.a.y.d.a();
            this.f1184a.f1017h.c();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.y.d.a();
            this.f1184a.f1017h.j();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a.a.a.y.d.a();
            this.f1184a.f1017h.k();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a.a.a.y.d.a();
            this.f1184a.f1017h.m();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a.a.a.a.y.d.a();
            this.f1184a.f1017h.l();
        }
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a.a.a.a.y.d.a();
            this.f1184a.f1017h.o();
        }
    }
}
