package c.a.c0.s.d0;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.s.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class j implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final v a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f2382b;

    public j(@NonNull v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vVar;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int M = this.a.M();
            int J = this.a.J();
            return M <= 0 || J <= 0 || M > J;
        }
        return invokeV.booleanValue;
    }

    public final void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        activity.getWindow().addFlags(128);
    }

    @Override // c.a.c0.s.d0.d
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2382b = this.a.n();
            this.a.Y0(true);
            Activity activity = this.a.getActivity();
            if (a()) {
                c.a.c0.s.v0.a.a(activity, this.a.X0());
            }
            b(activity);
            c.a.c0.s.v0.j.b(activity, this.a.v());
        }
    }

    @Override // c.a.c0.s.d0.d
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f2382b == null) {
            return;
        }
        this.f2382b = this.a.n();
        this.a.Y0(false);
        c.a.c0.s.v0.a.b(this.a.getActivity());
        c.a.c0.s.v0.j.k(this.a.v());
        c.a.c0.s.v0.j.j(this.a.n());
        c.a.c0.s.v0.j.c(this.a.v(), this.f2382b);
    }
}
