package b.a.r0.w.g.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaFrsLiveListGatherNoDataTitleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a extends b.a.e.l.e.a<b.a.r0.w.g.b.a, AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // b.a.e.l.e.a
    /* renamed from: g0 */
    public AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder(new AlaFrsLiveListGatherNoDataTitleView(this.m)) : (AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.w.g.b.a aVar, AlaFrsLiveListGatherNoDataTitleView.AlaFrsLiveListNoDataViewHolder alaFrsLiveListNoDataViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, alaFrsLiveListNoDataViewHolder})) == null) ? alaFrsLiveListNoDataViewHolder.getView() : (View) invokeCommon.objValue;
    }
}
