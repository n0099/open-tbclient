package c.a.t0.t2.u.f;

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
/* loaded from: classes8.dex */
public class j0 extends o<c.a.t0.t2.r.n, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(c.a.t0.t2.y.c cVar, BdUniqueId bdUniqueId) {
        super(cVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.t0.t2.y.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.t0.t2.u.f.o, c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        c0(i2, view, viewGroup, (c.a.t0.t2.r.n) obj, (PbNoDataItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public PbNoDataItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbNoDataItemViewHolder(LayoutInflater.from(this.f3360e).inflate(c.a.t0.t2.j.pb_no_data_item_layout, viewGroup, false), this.f3360e) : (PbNoDataItemViewHolder) invokeL.objValue;
    }

    public View c0(int i2, View view, ViewGroup viewGroup, c.a.t0.t2.r.n nVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, nVar, pbNoDataItemViewHolder})) == null) {
            super.S(i2, view, viewGroup, nVar, pbNoDataItemViewHolder);
            this.p = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.mTextView.setText(nVar.J0);
            int i3 = nVar.I0;
            if (i3 != 0) {
                SkinManager.setImageResource(pbNoDataItemViewHolder.mImageView, i3);
            } else {
                SkinManager.setImageResource(pbNoDataItemViewHolder.mImageView, c.a.t0.t2.h.new_pic_emotion_06);
            }
            SkinManager.setViewTextColor(pbNoDataItemViewHolder.mTextView, c.a.t0.t2.f.CAM_X0109);
            if (nVar.K0 != 0 && view.getLayoutParams() != null) {
                view.getLayoutParams().height = nVar.K0;
            }
            if (nVar.L0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.mImageView.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, nVar.L0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (nVar.M0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.mTextView.getLayoutParams();
                int i4 = marginLayoutParams2.leftMargin;
                marginLayoutParams2.setMargins(i4, i4, marginLayoutParams2.rightMargin, nVar.M0);
            }
            pbNoDataItemViewHolder.mImageView.setVisibility(nVar.N0);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
