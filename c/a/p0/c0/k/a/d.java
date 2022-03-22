package c.a.p0.c0.k.a;

import android.view.View;
import android.view.ViewGroup;
import c.a.p0.a4.h;
import c.a.p0.f1.k;
import c.a.p0.h0.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaStageViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends k<h, FrsPageAlaStageViewHolder> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public c.a.p0.c0.k.e.d u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        m0(i, view, viewGroup, (h) obj, (FrsPageAlaStageViewHolder) viewHolder);
        return view;
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.t = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: l0 */
    public FrsPageAlaStageViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.k;
            if (tbPageContext == null) {
                return null;
            }
            c.a.p0.c0.k.e.d dVar = new c.a.p0.c0.k.e.d(tbPageContext);
            this.u = dVar;
            dVar.a(this.t);
            return new FrsPageAlaStageViewHolder(this.u);
        }
        return (FrsPageAlaStageViewHolder) invokeL.objValue;
    }

    public View m0(int i, View view, ViewGroup viewGroup, h hVar, FrsPageAlaStageViewHolder frsPageAlaStageViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, hVar, frsPageAlaStageViewHolder})) == null) {
            super.S(i, view, viewGroup, hVar, frsPageAlaStageViewHolder);
            if (hVar != null) {
                FrsViewData frsViewData = this.j;
                int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
                c.a.p0.c0.k.e.d dVar = frsPageAlaStageViewHolder.a;
                dVar.x = (i + 1) - topThreadSize;
                dVar.a(this.t);
                frsPageAlaStageViewHolder.a.l(hVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }
}
