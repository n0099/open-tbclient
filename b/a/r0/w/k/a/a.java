package b.a.r0.w.k.a;

import android.view.View;
import android.view.ViewGroup;
import b.a.q0.s.q.d2;
import b.a.r0.b0.a0;
import b.a.r0.l3.g;
import b.a.r0.x0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaInsertRecLiveHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends k<g, FrsPageAlaInsertRecLiveHolder> implements a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;
    public b.a.r0.w.k.e.a y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = "";
    }

    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i2, view, viewGroup, (g) obj, (FrsPageAlaInsertRecLiveHolder) viewHolder);
        return view;
    }

    @Override // b.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.x = str;
        }
    }

    @Override // b.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: t0 */
    public FrsPageAlaInsertRecLiveHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.o;
            if (tbPageContext == null) {
                return null;
            }
            b.a.r0.w.k.e.a aVar = new b.a.r0.w.k.e.a(tbPageContext);
            this.y = aVar;
            aVar.a(this.x);
            return new FrsPageAlaInsertRecLiveHolder(this.y);
        }
        return (FrsPageAlaInsertRecLiveHolder) invokeL.objValue;
    }

    public View u0(int i2, View view, ViewGroup viewGroup, g gVar, FrsPageAlaInsertRecLiveHolder frsPageAlaInsertRecLiveHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, frsPageAlaInsertRecLiveHolder})) == null) {
            super.Z(i2, view, viewGroup, gVar, frsPageAlaInsertRecLiveHolder);
            if (gVar != null) {
                FrsViewData frsViewData = this.n;
                int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
                List<d2> list = gVar.f20557e;
                if (list != null && list.get(0) != null) {
                    gVar.f20557e.get(0).T1 = (i2 + 1) - topThreadSize;
                }
                frsPageAlaInsertRecLiveHolder.mView.a(this.x);
                frsPageAlaInsertRecLiveHolder.mView.j(gVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
