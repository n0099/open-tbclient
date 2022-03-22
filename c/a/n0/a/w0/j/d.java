package c.a.n0.a.w0.j;

import androidx.annotation.Nullable;
import c.a.n0.a.x.u.g;
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
    public c.a.n0.a.b0.a a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a() {
        c.a.n0.a.x.l.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.n0.a.b0.a aVar = this.a;
            if ((aVar == null || aVar.isDestroyed()) && (W = g.U().W()) != null && (W.h() instanceof c.a.n0.a.b0.a)) {
                this.a = (c.a.n0.a.b0.a) W.h();
            }
        }
    }

    @Override // c.a.n0.a.w0.j.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            c.a.n0.a.b0.a aVar = this.a;
            if (aVar != null) {
                aVar.suspendTimer();
            }
        }
    }

    @Override // c.a.n0.a.w0.j.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            c.a.n0.a.b0.a aVar = this.a;
            if (aVar != null) {
                aVar.continueTimer();
            }
        }
    }
}
