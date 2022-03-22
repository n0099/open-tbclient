package c.a.a0.v.d0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.h0.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public c.a.a0.v.f f1708b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f1709c;

    public f(@NonNull c.a.a0.v.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f1708b = fVar;
    }

    public void a(boolean z, @Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) {
            if (z) {
                int i = this.a;
                if (i != -1) {
                    o.d(activity, i);
                    return;
                }
                return;
            }
            o.f(activity);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        c.a.a0.v.v0.h.b("NormalSwitchHelper", "SCREEN_ORIENTATION_PORTRAIT ");
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        c.a.a0.v.v0.j.l(activity);
    }

    @Override // c.a.a0.v.d0.d
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1709c = this.f1708b.n();
            this.f1708b.Y0(true);
            Activity activity = this.f1708b.getActivity();
            a(true, activity);
            c.a.a0.v.v0.i.b(activity, this.f1708b.X0());
            c.a.a0.v.v0.i.c(activity, true);
            c.a.a0.v.v0.j.b(activity, this.f1708b.v());
        }
    }

    @Override // c.a.a0.v.d0.d
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f1709c == null) {
            return;
        }
        this.f1709c = this.f1708b.n();
        this.f1708b.Y0(false);
        Activity activity = this.f1708b.getActivity();
        a(false, activity);
        b(activity);
        c.a.a0.v.v0.j.k(this.f1708b.v());
        c.a.a0.v.v0.j.j(this.f1708b.n());
        c.a.a0.v.v0.j.c(this.f1708b.v(), this.f1709c);
    }
}
