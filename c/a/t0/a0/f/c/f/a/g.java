package c.a.t0.a0.f.c.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernTitleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g extends c.a.d.n.e.a<c.a.t0.a0.f.g.c.g, LiveTabConcernTitleView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.t0.a0.f.g.c.g.f14977g);
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
    @Override // c.a.d.n.e.a
    /* renamed from: Z */
    public LiveTabConcernTitleView.ViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new LiveTabConcernTitleView.ViewHolder(new LiveTabConcernTitleView(this.m, viewGroup)) : (LiveTabConcernTitleView.ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.a0.f.g.c.g gVar, LiveTabConcernTitleView.ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        LiveTabConcernTitleView liveTabConcernTitleView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, viewHolder})) == null) {
            if (viewHolder == null || (liveTabConcernTitleView = viewHolder.liveTabConcernTitleView) == null) {
                return null;
            }
            liveTabConcernTitleView.k(gVar);
            viewHolder.liveTabConcernTitleView.l(this.m, TbadkCoreApplication.getInst().getSkinType());
            return viewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
