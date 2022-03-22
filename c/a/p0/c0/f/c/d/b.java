package c.a.p0.c0.f.c.d;

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
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<c.a.p0.c0.f.c.e.c, OfficialRecommendLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public c.a.p0.c0.f.c.h.b j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.p0.c0.f.c.e.c.f12925b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: Z */
    public OfficialRecommendLiveViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.j = new c.a.p0.c0.f.c.h.b(this.i, viewGroup);
            return new OfficialRecommendLiveViewHolder(this.j);
        }
        return (OfficialRecommendLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.c0.f.c.e.c cVar, OfficialRecommendLiveViewHolder officialRecommendLiveViewHolder) {
        InterceptResult invokeCommon;
        c.a.p0.c0.f.c.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, cVar, officialRecommendLiveViewHolder})) == null) {
            if (officialRecommendLiveViewHolder == null || (bVar = officialRecommendLiveViewHolder.a) == null) {
                return null;
            }
            bVar.l(cVar);
            officialRecommendLiveViewHolder.a.m(this.i, TbadkCoreApplication.getInst().getSkinType());
            return officialRecommendLiveViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
