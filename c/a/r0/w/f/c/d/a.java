package c.a.r0.w.f.c.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.e.p.l;
import c.a.r0.x0.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends c.a.e.l.e.a<s, FrsNoListItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), s.f27952f);
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
        this.m = (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, s sVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        i0(i2, view, viewGroup, sVar, frsNoListItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: h0 */
    public FrsNoListItemViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2958e).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
            ViewGroup.LayoutParams u = u(viewGroup);
            u.width = -1;
            u.height = this.m;
            inflate.setLayoutParams(u);
            return new FrsNoListItemViewHolder(inflate, viewGroup);
        }
        return (FrsNoListItemViewHolder) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, s sVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, sVar, frsNoListItemViewHolder})) == null) {
            frsNoListItemViewHolder.mNodataTextView.setText(R.string.no_data_common_txt);
            SkinManager.setViewTextColor(frsNoListItemViewHolder.mNodataTextView, R.color.CAM_X0107, 1);
            SkinManager.setImageResource(frsNoListItemViewHolder.mEmotionView, R.drawable.new_pic_emotion_06);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
