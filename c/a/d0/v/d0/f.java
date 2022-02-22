package c.a.d0.v.d0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d0.h0.o;
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
    public c.a.d0.v.f f3265b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f3266c;

    public f(@NonNull c.a.d0.v.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f3265b = fVar;
    }

    public void a(boolean z, @Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) {
            if (z) {
                int i2 = this.a;
                if (i2 != -1) {
                    o.d(activity, i2);
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
        c.a.d0.v.v0.h.b("NormalSwitchHelper", "SCREEN_ORIENTATION_PORTRAIT ");
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        c.a.d0.v.v0.j.l(activity);
    }

    @Override // c.a.d0.v.d0.d
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f3266c = this.f3265b.n();
            this.f3265b.Y0(true);
            Activity activity = this.f3265b.getActivity();
            a(true, activity);
            c.a.d0.v.v0.i.b(activity, this.f3265b.X0());
            c.a.d0.v.v0.i.c(activity, true);
            c.a.d0.v.v0.j.b(activity, this.f3265b.v());
        }
    }

    @Override // c.a.d0.v.d0.d
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f3266c == null) {
            return;
        }
        this.f3266c = this.f3265b.n();
        this.f3265b.Y0(false);
        Activity activity = this.f3265b.getActivity();
        a(false, activity);
        b(activity);
        c.a.d0.v.v0.j.k(this.f3265b.v());
        c.a.d0.v.v0.j.j(this.f3265b.n());
        c.a.d0.v.v0.j.c(this.f3265b.v(), this.f3266c);
    }
}
