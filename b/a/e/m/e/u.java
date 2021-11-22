package b.a.e.m.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.NoDataItemViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class u extends a<v, NoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), v.f2517g);
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
        this.m = 3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // b.a.e.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        h0(i2, view, viewGroup, vVar, noDataItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: g0 */
    public NoDataItemViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new NoDataItemViewHolder(LayoutInflater.from(this.f2421e).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false)) : (NoDataItemViewHolder) invokeL.objValue;
    }

    public View h0(int i2, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, vVar, noDataItemViewHolder})) == null) {
            noDataItemViewHolder.mTextView.setText(vVar.f2518e);
            if (this.m != TbadkCoreApplication.getInst().getSkinType()) {
                SkinManager.setImageResource(noDataItemViewHolder.mImageView, vVar.f2519f);
                SkinManager.setViewTextColor(noDataItemViewHolder.mTextView, R.color.CAM_X0109);
                this.m = TbadkCoreApplication.getInst().getSkinType();
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
