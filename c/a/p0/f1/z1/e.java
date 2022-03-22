package c.a.p0.f1.z1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.a.p0.f1.j0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e extends c.a.o0.h0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b().a = frsFragment;
    }

    @Override // c.a.o0.h0.b
    public c.a.o0.h0.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.o0.h0.c cVar = new c.a.o0.h0.c();
            cVar.f10299e = 1;
            cVar.f10296b = R.string.obfuscated_res_0x7f0f03c8;
            cVar.i = c.a.o0.h0.c.l;
            return cVar;
        }
        return (c.a.o0.h0.c) invokeV.objValue;
    }

    @Override // c.a.o0.h0.b
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02f8, (ViewGroup) null);
            this.f10295b = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.f10295b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // c.a.o0.h0.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g(j0 j0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, j0Var) == null) && j0Var != null && j0Var.h(1)) {
            j0Var.a(this);
        }
    }
}
