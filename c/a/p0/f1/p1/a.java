package c.a.p0.f1.p1;

import c.a.d.o.e.s;
import c.a.p0.f1.p1.d.e0;
import c.a.p0.f1.p1.d.q;
import c.a.p0.f1.v2.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements c.a.p0.f1.p1.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    public a() {
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

    @Override // c.a.p0.f1.p1.e.a
    public c.a.p0.f1.s2.d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (frsFragment.V2()) {
                return null;
            }
            return new c.a.p0.f1.s2.d(frsFragment, noPressedRelativeLayout);
        }
        return (c.a.p0.f1.s2.d) invokeLL.objValue;
    }

    @Override // c.a.p0.f1.p1.e.a
    public e0 b(FrsFragment frsFragment, s sVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, sVar, z)) == null) ? new q(frsFragment, sVar, z) : (e0) invokeLLZ.objValue;
    }

    @Override // c.a.p0.f1.p1.e.a
    public c.a.p0.f1.p1.e.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c() : (c.a.p0.f1.p1.e.b) invokeV.objValue;
    }

    @Override // c.a.p0.f1.p1.e.a
    public c.a.p0.f1.p1.e.c d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) ? new c.a.p0.f1.s2.b(frsFragment, noPressedRelativeLayout) : (c.a.p0.f1.p1.e.c) invokeLL.objValue;
    }

    @Override // c.a.p0.f1.p1.e.a
    public d e(String str, FrsFragment frsFragment, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i)) == null) {
            if (frsFragment == null) {
                return null;
            }
            b bVar = new b(frsFragment, null, null, i);
            this.a = bVar;
            bVar.S(frsFragment.z2());
            return this.a;
        }
        return (d) invokeLLI.objValue;
    }

    public b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d dVar = this.a;
            if (dVar instanceof b) {
                return (b) dVar;
            }
            return null;
        }
        return (b) invokeV.objValue;
    }
}
