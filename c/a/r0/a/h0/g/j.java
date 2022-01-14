package c.a.r0.a.h0.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.z2.q0;
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

    public static j P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new j() : (j) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            P1(view);
            n2(-1);
            w2(-16777216);
            p2(I(c.a.r0.a.h.swan_app_menu_setting));
            r2(true);
            D2(false);
        }
    }

    public final void O2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(c.a.r0.a.f.message_item);
            this.J0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            if (c.a.r0.a.c1.a.y0().d() || !q0.G()) {
                this.J0.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(c.a.r0.a.f.authority_item);
            this.K0 = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = d.I0;
            g G1 = G1();
            if (G1 == null) {
                c.a.r0.a.c2.b.f.e.f(getContext(), c.a.r0.a.h.aiapps_open_fragment_failed_toast).G();
                return;
            }
            g.b i2 = G1.i("navigateTo");
            i2.n(g.f6399g, g.f6401i);
            i2.k("authority", null).a();
            c.a.r0.a.k1.a.o("permission");
        }
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (view.getId() == c.a.r0.a.f.message_item) {
                c.a.r0.a.c1.a.t0().a();
            } else if (view.getId() == c.a.r0.a.f.authority_item) {
                Q2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View w0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.r0.a.g.swan_app_settings_layout, viewGroup, false);
            O1(inflate);
            O2(inflate);
            if (N1()) {
                inflate = Q1(inflate);
            }
            return x1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
