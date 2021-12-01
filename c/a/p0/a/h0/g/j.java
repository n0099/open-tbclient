package c.a.p0.a.h0.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class j extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout J0;
    public RelativeLayout K0;

    public j() {
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

    public static j W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new j() : (j) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View D0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.p0.a.g.swan_app_settings_layout, viewGroup, false);
            V1(inflate);
            V2(inflate);
            if (U1()) {
                inflate = X1(inflate);
            }
            return E1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public void V1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            W1(view);
            u2(-1);
            D2(-16777216);
            w2(X(c.a.p0.a.h.swan_app_menu_setting));
            y2(true);
            K2(false);
        }
    }

    public final void V2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(c.a.p0.a.f.message_item);
            this.J0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            if (c.a.p0.a.c1.a.y0().d() || !q0.G()) {
                this.J0.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(c.a.p0.a.f.authority_item);
            this.K0 = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = d.I0;
            g N1 = N1();
            if (N1 == null) {
                c.a.p0.a.c2.b.f.e.f(getContext(), c.a.p0.a.h.aiapps_open_fragment_failed_toast).G();
                return;
            }
            g.b i2 = N1.i("navigateTo");
            i2.n(g.f5496g, g.f5498i);
            i2.k("authority", null).a();
            c.a.p0.a.k1.a.o("permission");
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (view.getId() == c.a.p0.a.f.message_item) {
                c.a.p0.a.c1.a.t0().a();
            } else if (view.getId() == c.a.p0.a.f.authority_item) {
                X2();
            }
        }
    }
}
