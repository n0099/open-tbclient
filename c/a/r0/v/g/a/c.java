package c.a.r0.v.g.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsGameLiveDoubleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c extends c.a.e.l.e.a<c.a.r0.v.j.b.a, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public c.a.r0.v.e n;
    public String o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // c.a.e.l.e.a
    /* renamed from: h0 */
    public AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView = new AlaGameFrsGameLiveDoubleView(this.m);
            alaGameFrsGameLiveDoubleView.s(this.o);
            return new AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder(alaGameFrsGameLiveDoubleView);
        }
        return (AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.v.j.b.a aVar, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder alaGameFrsGameLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, alaGameFrsGameLiveDoubleViewHolder})) == null) {
            alaGameFrsGameLiveDoubleViewHolder.mView.k(aVar);
            alaGameFrsGameLiveDoubleViewHolder.mView.t(this.n);
            c.a.r0.v.d.b().a(new StatisticItem("c12115").param("obj_id", aVar.f26075e.l1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f26075e.l1().appId) ? aVar.f26075e.l1().appId : ""));
            d2 d2Var = aVar.f26076f;
            if (d2Var != null) {
                c.a.r0.v.d.b().a(new StatisticItem("c12115").param("obj_id", aVar.f26076f.l1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(d2Var.l1().appId) ? "" : aVar.f26076f.l1().appId));
            }
            return alaGameFrsGameLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(c.a.r0.v.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.n = eVar;
        }
    }
}
