package c.a.r0.a0.k.a;

import android.view.View;
import android.view.ViewGroup;
import c.a.q0.r.r.e2;
import c.a.r0.d1.k;
import c.a.r0.f0.z;
import c.a.r0.y3.g;
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
/* loaded from: classes2.dex */
public class a extends k<g, FrsPageAlaInsertRecLiveHolder> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;
    public c.a.r0.a0.k.e.a y;

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

    @Override // c.a.r0.d1.k, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        n0(i2, view, viewGroup, (g) obj, (FrsPageAlaInsertRecLiveHolder) viewHolder);
        return view;
    }

    @Override // c.a.r0.f0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.x = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: m0 */
    public FrsPageAlaInsertRecLiveHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.o;
            if (tbPageContext == null) {
                return null;
            }
            c.a.r0.a0.k.e.a aVar = new c.a.r0.a0.k.e.a(tbPageContext);
            this.y = aVar;
            aVar.a(this.x);
            return new FrsPageAlaInsertRecLiveHolder(this.y);
        }
        return (FrsPageAlaInsertRecLiveHolder) invokeL.objValue;
    }

    public View n0(int i2, View view, ViewGroup viewGroup, g gVar, FrsPageAlaInsertRecLiveHolder frsPageAlaInsertRecLiveHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, frsPageAlaInsertRecLiveHolder})) == null) {
            super.S(i2, view, viewGroup, gVar, frsPageAlaInsertRecLiveHolder);
            if (gVar != null) {
                FrsViewData frsViewData = this.n;
                int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
                List<e2> list = gVar.f24990e;
                if (list != null && list.get(0) != null) {
                    gVar.f24990e.get(0).T1 = (i2 + 1) - topThreadSize;
                }
                frsPageAlaInsertRecLiveHolder.mView.a(this.x);
                frsPageAlaInsertRecLiveHolder.mView.k(gVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.r0.f0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }
}
