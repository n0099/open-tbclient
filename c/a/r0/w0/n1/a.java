package c.a.r0.w0.n1;

import c.a.e.l.e.s;
import c.a.r0.w0.n1.d.e0;
import c.a.r0.w0.n1.d.q;
import c.a.r0.w0.o2.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements c.a.r0.w0.n1.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.w0.r2.b f27144a;

    public a() {
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

    @Override // c.a.r0.w0.n1.e.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (frsFragment.isFromMainTab()) {
                return null;
            }
            return new d(frsFragment, noPressedRelativeLayout);
        }
        return (d) invokeLL.objValue;
    }

    @Override // c.a.r0.w0.n1.e.a
    public e0 b(FrsFragment frsFragment, s sVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, sVar, z)) == null) ? new q(frsFragment, sVar, z) : (e0) invokeLLZ.objValue;
    }

    @Override // c.a.r0.w0.n1.e.a
    public c.a.r0.w0.n1.e.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c() : (c.a.r0.w0.n1.e.b) invokeV.objValue;
    }

    @Override // c.a.r0.w0.n1.e.a
    public c.a.r0.w0.n1.e.c d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) ? new c.a.r0.w0.o2.b(frsFragment, noPressedRelativeLayout) : (c.a.r0.w0.n1.e.c) invokeLL.objValue;
    }

    @Override // c.a.r0.w0.n1.e.a
    public c.a.r0.w0.r2.b e(String str, FrsFragment frsFragment, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i2)) == null) {
            if (frsFragment == null) {
                return null;
            }
            b bVar = new b(frsFragment, null, null, i2);
            this.f27144a = bVar;
            bVar.L(frsFragment.getFrsAdapterItemClickListener());
            return this.f27144a;
        }
        return (c.a.r0.w0.r2.b) invokeLLI.objValue;
    }
}
