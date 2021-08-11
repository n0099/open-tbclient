package c.a.p0.i2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i0 extends o<c.a.p0.i2.h.l, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(c.a.p0.i2.o.b bVar, BdUniqueId bdUniqueId) {
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
                super((c.a.p0.i2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.i2.k.e.o, c.a.e.k.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view, viewGroup, (c.a.p0.i2.h.l) obj, (PbNoDataItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: j0 */
    public PbNoDataItemViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbNoDataItemViewHolder(LayoutInflater.from(this.f2904e).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.f2904e) : (PbNoDataItemViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, c.a.p0.i2.h.l lVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, pbNoDataItemViewHolder})) == null) {
            super.a0(i2, view, viewGroup, lVar, pbNoDataItemViewHolder);
            this.p = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.mTextView.setText(lVar.E0);
            int i3 = lVar.D0;
            if (i3 != 0) {
                SkinManager.setImageResource(pbNoDataItemViewHolder.mImageView, i3);
            } else {
                SkinManager.setImageResource(pbNoDataItemViewHolder.mImageView, R.drawable.new_pic_emotion_06);
            }
            SkinManager.setViewTextColor(pbNoDataItemViewHolder.mTextView, R.color.CAM_X0109);
            if (lVar.F0 != 0 && view.getLayoutParams() != null) {
                view.getLayoutParams().height = lVar.F0;
            }
            if (lVar.G0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.mImageView.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, lVar.G0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (lVar.H0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.mTextView.getLayoutParams();
                int i4 = marginLayoutParams2.leftMargin;
                marginLayoutParams2.setMargins(i4, i4, marginLayoutParams2.rightMargin, lVar.H0);
            }
            pbNoDataItemViewHolder.mImageView.setVisibility(lVar.I0);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
