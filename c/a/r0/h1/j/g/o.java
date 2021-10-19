package c.a.r0.h1.j.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.l.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class o extends c.a.e.l.e.a<SpecialColumnListData, AdapterViewHolder<SpecialTopicLayout>> implements c.a.r0.h1.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public String n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), SpecialColumnListData.TYPE);
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
    public AdapterViewHolder<SpecialTopicLayout> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            SpecialTopicLayout specialTopicLayout = new SpecialTopicLayout(this.m);
            specialTopicLayout.setShowMore(true);
            return new AdapterViewHolder<>(specialTopicLayout);
        }
        return (AdapterViewHolder) invokeL.objValue;
    }

    @Override // c.a.r0.h1.j.d
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.n = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public View a0(int i2, View view, ViewGroup viewGroup, SpecialColumnListData specialColumnListData, AdapterViewHolder<SpecialTopicLayout> adapterViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, specialColumnListData, adapterViewHolder})) == null) {
            SpecialTopicLayout adapterView = adapterViewHolder.getAdapterView();
            adapterView.setTabCode(this.n);
            adapterView.onBindDataToView(specialColumnListData);
            return adapterViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
        }
    }
}
