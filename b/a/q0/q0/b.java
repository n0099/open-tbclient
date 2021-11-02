package b.a.q0.q0;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f12822b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12823c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12824d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.f12822b;
            if (aVar != null) {
                return aVar.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void c() {
        a aVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f12824d || (aVar = this.f12822b) == null || aVar.b() < 0 || (mVar = (m) k.d().e(this.f12836a)) == null) {
            return;
        }
        mVar.e(this);
        this.f12824d = true;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.f12823c && k.d().g()) {
            this.f12823c = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.f12822b == null) {
                    this.f12822b = new a();
                }
                this.f12822b.c();
            }
        }
    }

    public void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 16 || (aVar = this.f12822b) == null) {
            return;
        }
        aVar.d();
    }
}
