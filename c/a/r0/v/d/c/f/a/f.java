package c.a.r0.v.d.c.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.v.d.c.f.d.h;
import c.a.r0.v.d.c.f.d.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f extends c.a.e.l.e.a<c.a.r0.v.d.c.f.b.c, LiveTabConcernRecommendLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public h n;
    public i o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.r0.v.d.c.f.b.c.f25597h);
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
    public LiveTabConcernRecommendLineHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            h hVar = new h(this.m, viewGroup);
            this.n = hVar;
            i iVar = this.o;
            if (iVar != null) {
                hVar.q(iVar);
            }
            return new LiveTabConcernRecommendLineHolder(this.n);
        }
        return (LiveTabConcernRecommendLineHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.v.d.c.f.b.c cVar, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        InterceptResult invokeCommon;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, liveTabConcernRecommendLineHolder})) == null) {
            if (liveTabConcernRecommendLineHolder == null || (hVar = liveTabConcernRecommendLineHolder.mView) == null) {
                return null;
            }
            hVar.k(cVar);
            return liveTabConcernRecommendLineHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.o = iVar;
            h hVar = this.n;
            if (hVar != null) {
                hVar.q(iVar);
            }
        }
    }
}
