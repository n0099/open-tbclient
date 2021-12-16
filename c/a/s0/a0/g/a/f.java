package c.a.s0.a0.g.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.s.r.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveDoubleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f extends c.a.d.m.e.a<c.a.s0.a0.j.b.a, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public c.a.s0.a0.e n;
    public String o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
    @Override // c.a.d.m.e.a
    /* renamed from: g0 */
    public AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView = new AlaGameFrsLiveDoubleView(this.m);
            alaGameFrsLiveDoubleView.s(this.o);
            return new AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder(alaGameFrsLiveDoubleView);
        }
        return (AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.s0.a0.j.b.a aVar, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder alaGameFrsLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, alaGameFrsLiveDoubleViewHolder})) == null) {
            alaGameFrsLiveDoubleViewHolder.mView.k(aVar);
            alaGameFrsLiveDoubleViewHolder.mView.t(this.n);
            c.a.s0.a0.d.b().a(new StatisticItem("c12115").param("obj_id", aVar.f14726e.o1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f14726e.o1().appId) ? aVar.f14726e.o1().appId : ""));
            d2 d2Var = aVar.f14727f;
            if (d2Var != null) {
                c.a.s0.a0.d.b().a(new StatisticItem("c12115").param("obj_id", aVar.f14727f.o1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(d2Var.o1().appId) ? "" : aVar.f14727f.o1().appId));
            }
            return alaGameFrsLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(c.a.s0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.n = eVar;
        }
    }
}
