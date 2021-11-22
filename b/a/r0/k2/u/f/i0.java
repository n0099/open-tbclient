package b.a.r0.k2.u.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class i0 extends n<b.a.r0.k2.r.n, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(b.a.r0.k2.y.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b.a.r0.k2.y.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.r0.k2.u.f.n, b.a.e.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (b.a.r0.k2.r.n) obj, (PbNoDataItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public PbNoDataItemViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbNoDataItemViewHolder(LayoutInflater.from(this.f2421e).inflate(b.a.r0.k2.j.pb_no_data_item_layout, viewGroup, false), this.f2421e) : (PbNoDataItemViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, b.a.r0.k2.r.n nVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, nVar, pbNoDataItemViewHolder})) == null) {
            super.Z(i2, view, viewGroup, nVar, pbNoDataItemViewHolder);
            this.p = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.mTextView.setText(nVar.H0);
            int i3 = nVar.G0;
            if (i3 != 0) {
                SkinManager.setImageResource(pbNoDataItemViewHolder.mImageView, i3);
            } else {
                SkinManager.setImageResource(pbNoDataItemViewHolder.mImageView, b.a.r0.k2.h.new_pic_emotion_06);
            }
            SkinManager.setViewTextColor(pbNoDataItemViewHolder.mTextView, b.a.r0.k2.f.CAM_X0109);
            if (nVar.I0 != 0 && view.getLayoutParams() != null) {
                view.getLayoutParams().height = nVar.I0;
            }
            if (nVar.J0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.mImageView.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, nVar.J0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (nVar.K0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.mTextView.getLayoutParams();
                int i4 = marginLayoutParams2.leftMargin;
                marginLayoutParams2.setMargins(i4, i4, marginLayoutParams2.rightMargin, nVar.K0);
            }
            pbNoDataItemViewHolder.mImageView.setVisibility(nVar.L0);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
