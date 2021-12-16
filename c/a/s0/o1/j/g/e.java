package c.a.s0.o1.j.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.HomeLocalCompleteInfoLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e extends c.a.d.m.e.a<c.a.s0.o1.j.h.a, AdapterViewHolder<HomeLocalCompleteInfoLayout>> implements c.a.s0.o1.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public View.OnClickListener n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext tbPageContext, @Nullable View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity(), c.a.s0.o1.j.h.a.f21152e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onClickListener};
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
        this.n = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: g0 */
    public AdapterViewHolder<HomeLocalCompleteInfoLayout> S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new AdapterViewHolder<>(new HomeLocalCompleteInfoLayout(viewGroup.getContext())) : (AdapterViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.s0.o1.j.h.a aVar, AdapterViewHolder<HomeLocalCompleteInfoLayout> adapterViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, adapterViewHolder})) == null) {
            if (aVar == null || adapterViewHolder == null) {
                return null;
            }
            HomeLocalCompleteInfoLayout adapterView = adapterViewHolder.getAdapterView();
            adapterView.onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            adapterView.setCloseClickListener(this.n);
            c.a.s0.o1.j.c.k();
            return adapterViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.s0.o1.j.d
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }
}
