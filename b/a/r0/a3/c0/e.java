package b.a.r0.a3.c0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.a3.t;
import b.a.r0.m3.j0.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.PbAppEmptyHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e extends b.a.e.m.e.a<p, PbAppEmptyHolder> implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: g0 */
    public PbAppEmptyHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View view = new View(this.m.getPageContext().getPageActivity());
            view.setVisibility(8);
            return new PbAppEmptyHolder(view);
        }
        return (PbAppEmptyHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, p pVar, PbAppEmptyHolder pbAppEmptyHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbAppEmptyHolder})) == null) {
            AdvertAppInfo advertAppInfo = pVar.getAdvertAppInfo();
            if (advertAppInfo != null) {
                b.a.q0.s.q.e.g(advertAppInfo.h4, pVar.getPosition(), advertAppInfo.a4 == -1001);
            }
            return pbAppEmptyHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // b.a.r0.a3.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }
}
