package c.a.s0.o1.j.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.NearbyForumFriendCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t extends c.a.d.m.e.a<c.a.s0.l2.b.a, AdapterViewHolder<NearbyForumFriendCardView>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public AdapterViewHolder<NearbyForumFriendCardView> n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.s0.l2.b.a.f19131h);
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
    @Override // c.a.d.m.e.a
    /* renamed from: g0 */
    public AdapterViewHolder<NearbyForumFriendCardView> S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder = new AdapterViewHolder<>(new NearbyForumFriendCardView(this.m.getPageActivity()));
            this.n = adapterViewHolder;
            return adapterViewHolder;
        }
        return (AdapterViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.s0.l2.b.a aVar, AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, adapterViewHolder})) == null) {
            NearbyForumFriendCardView adapterView = adapterViewHolder.getAdapterView();
            adapterView.onBindDataToView(aVar);
            adapterView.onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            return adapterViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(boolean z) {
        AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (adapterViewHolder = this.n) == null) {
            return;
        }
        adapterViewHolder.getAdapterView().setNeedCompleteProfile(z);
    }
}
