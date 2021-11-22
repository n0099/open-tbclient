package b.a.r0.a3.c0;

import android.view.View;
import android.view.ViewGroup;
import b.a.q0.s.q.d2;
import b.a.r0.a3.t;
import b.a.r0.a3.u;
import b.a.r0.x0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.FrsAppEmptyHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c extends k<d2, FrsAppEmptyHolder> implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.getTbPageContext(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.r0.a3.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: t0 */
    public FrsAppEmptyHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            View view = new View(this.o.getPageActivity());
            view.setVisibility(8);
            return new FrsAppEmptyHolder(view);
        }
        return (FrsAppEmptyHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.m.e.a
    /* renamed from: u0 */
    public View Z(int i2, View view, ViewGroup viewGroup, d2 d2Var, FrsAppEmptyHolder frsAppEmptyHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, frsAppEmptyHolder})) == null) {
            if (d2Var instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) d2Var;
                b.a.q0.s.q.e.c(advertAppInfo.h4, d2Var.position, advertAppInfo.a4 == -1001);
            }
            return frsAppEmptyHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
