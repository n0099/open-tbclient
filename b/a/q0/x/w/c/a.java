package b.a.q0.x.w.c;

import android.view.View;
import android.view.Window;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View f14997a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14998b;

    /* renamed from: c  reason: collision with root package name */
    public View f14999c;

    public a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14997a = view;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f14998b = z;
            if (!z && this.f14997a.getVisibility() == 4) {
                this.f14997a.setVisibility(8);
            }
            if (z || this.f14999c == null) {
                return;
            }
            c();
            this.f14999c = null;
        }
    }

    public void b(Window window) {
        View currentFocus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, window) == null) || (currentFocus = window.getCurrentFocus()) == null) {
            return;
        }
        if (this.f14998b) {
            d(currentFocus);
        } else {
            currentFocus.clearFocus();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14997a.setVisibility(4);
            b.a.q0.x.w.d.b.j(this.f14999c);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f14999c = view;
            view.clearFocus();
            this.f14997a.setVisibility(8);
        }
    }
}
