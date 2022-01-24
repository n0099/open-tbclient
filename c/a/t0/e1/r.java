package c.a.t0.e1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r extends k<s, FrsNoListItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = (c.a.d.f.p.n.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.ds90);
    }

    @Override // c.a.t0.e1.k, c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        n0(i2, view, viewGroup, (s) obj, (FrsNoListItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: m0 */
    public FrsNoListItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f3360e).inflate(g1.frs_no_list_item_view, viewGroup, false);
            ViewGroup.LayoutParams u = u(viewGroup);
            u.width = -1;
            u.height = this.x;
            inflate.setLayoutParams(u);
            return new FrsNoListItemViewHolder(inflate, viewGroup);
        }
        return (FrsNoListItemViewHolder) invokeL.objValue;
    }

    public View n0(int i2, View view, ViewGroup viewGroup, s sVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, sVar, frsNoListItemViewHolder})) == null) {
            super.S(i2, view, viewGroup, sVar, frsNoListItemViewHolder);
            if (sVar.a() == 6) {
                frsNoListItemViewHolder.mNodataTextView.setText(i1.attention_no_post_tip);
            } else {
                frsNoListItemViewHolder.mNodataTextView.setText(i1.no_data_common_txt);
            }
            SkinManager.setViewTextColor(frsNoListItemViewHolder.mNodataTextView, c1.CAM_X0107, 1);
            SkinManager.setImageResource(frsNoListItemViewHolder.mEmotionView, e1.new_pic_emotion_06);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
