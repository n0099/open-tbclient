package b.a.p0.a.g1.j;

import androidx.annotation.Nullable;
import b.a.p0.a.h0.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.l0.a f5295a;

    public d() {
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

    public final void a() {
        b.a.p0.a.h0.l.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.p0.a.l0.a aVar = this.f5295a;
            if ((aVar == null || aVar.isDestroyed()) && (W = g.U().W()) != null && (W.g() instanceof b.a.p0.a.l0.a)) {
                this.f5295a = (b.a.p0.a.l0.a) W.g();
            }
        }
    }

    @Override // b.a.p0.a.g1.j.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            b.a.p0.a.l0.a aVar = this.f5295a;
            if (aVar != null) {
                aVar.suspendTimer();
            }
        }
    }

    @Override // b.a.p0.a.g1.j.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            b.a.p0.a.l0.a aVar = this.f5295a;
            if (aVar != null) {
                aVar.continueTimer();
            }
        }
    }
}
