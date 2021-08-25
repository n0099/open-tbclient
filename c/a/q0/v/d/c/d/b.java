package c.a.q0.v.d.c.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.OfficialRecommendLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends c.a.e.l.e.a<c.a.q0.v.d.c.e.c, OfficialRecommendLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public c.a.q0.v.d.c.h.b n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.q0.v.d.c.e.c.f25079f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: h0 */
    public OfficialRecommendLiveViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.n = new c.a.q0.v.d.c.h.b(this.m, viewGroup);
            return new OfficialRecommendLiveViewHolder(this.n);
        }
        return (OfficialRecommendLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.v.d.c.e.c cVar, OfficialRecommendLiveViewHolder officialRecommendLiveViewHolder) {
        InterceptResult invokeCommon;
        c.a.q0.v.d.c.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, officialRecommendLiveViewHolder})) == null) {
            if (officialRecommendLiveViewHolder == null || (bVar = officialRecommendLiveViewHolder.mView) == null) {
                return null;
            }
            bVar.k(cVar);
            officialRecommendLiveViewHolder.mView.l(this.m, TbadkCoreApplication.getInst().getSkinType());
            return officialRecommendLiveViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
