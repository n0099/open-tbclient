package c.a.p0.a.g1.j;

import androidx.annotation.Nullable;
import c.a.p0.a.h0.u.g;
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
    public c.a.p0.a.l0.a a;

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
        c.a.p0.a.h0.l.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.a.l0.a aVar = this.a;
            if ((aVar == null || aVar.isDestroyed()) && (W = g.U().W()) != null && (W.g() instanceof c.a.p0.a.l0.a)) {
                this.a = (c.a.p0.a.l0.a) W.g();
            }
        }
    }

    @Override // c.a.p0.a.g1.j.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            c.a.p0.a.l0.a aVar = this.a;
            if (aVar != null) {
                aVar.suspendTimer();
            }
        }
    }

    @Override // c.a.p0.a.g1.j.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            c.a.p0.a.l0.a aVar = this.a;
            if (aVar != null) {
                aVar.continueTimer();
            }
        }
    }
}
