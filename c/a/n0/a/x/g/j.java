package c.a.n0.a.x.g;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q0;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class j extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout F0;
    public RelativeLayout G0;

    public j() {
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

    public static j T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new j() : (j) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void S1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            T1(view);
            r2(-1);
            A2(-16777216);
            t2(G(R.string.obfuscated_res_0x7f0f121c));
            v2(true);
            H2(false);
        }
    }

    public final void S2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f091403);
            this.F0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            if (c.a.n0.a.s0.a.y0().d() || !q0.G()) {
                this.F0.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0902da);
            this.G0 = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (d.E0) {
                Log.d("SwanAppBaseFragment", "startSettingFragment");
            }
            g K1 = K1();
            if (K1 == null) {
                c.a.n0.a.s1.b.f.e.f(getContext(), R.string.obfuscated_res_0x7f0f019b).G();
                return;
            }
            g.b i = K1.i("navigateTo");
            i.n(g.f7048g, g.i);
            i.k("authority", null).a();
            c.a.n0.a.a1.a.o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f091403) {
                c.a.n0.a.s0.a.t0().a();
            } else if (view.getId() == R.id.obfuscated_res_0x7f0902da) {
                U2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View x0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07cc, viewGroup, false);
            S1(inflate);
            S2(inflate);
            if (R1()) {
                inflate = U1(inflate);
            }
            return B1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
