package c.a.p0.w2.m.f;

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
public class p0 extends r<c.a.p0.w2.i.o, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(c.a.p0.w2.q.c cVar, BdUniqueId bdUniqueId) {
        super(cVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.w2.q.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.w2.m.f.r, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        c0(i, view, viewGroup, (c.a.p0.w2.i.o) obj, (PbNoDataItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public PbNoDataItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbNoDataItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0695, viewGroup, false), this.a) : (PbNoDataItemViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view, ViewGroup viewGroup, c.a.p0.w2.i.o oVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, oVar, pbNoDataItemViewHolder})) == null) {
            super.S(i, view, viewGroup, oVar, pbNoDataItemViewHolder);
            this.l = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.a.setText(oVar.F0);
            int i2 = oVar.E0;
            if (i2 != 0) {
                SkinManager.setImageResource(pbNoDataItemViewHolder.f34834b, i2);
            } else {
                SkinManager.setImageResource(pbNoDataItemViewHolder.f34834b, R.drawable.new_pic_emotion_06);
            }
            SkinManager.setViewTextColor(pbNoDataItemViewHolder.a, (int) R.color.CAM_X0109);
            if (oVar.G0 != 0 && view.getLayoutParams() != null) {
                view.getLayoutParams().height = oVar.G0;
            }
            if (oVar.H0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f34834b.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, oVar.H0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (oVar.I0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.a.getLayoutParams();
                int i3 = marginLayoutParams2.leftMargin;
                marginLayoutParams2.setMargins(i3, i3, marginLayoutParams2.rightMargin, oVar.I0);
            }
            pbNoDataItemViewHolder.f34834b.setVisibility(oVar.J0);
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
