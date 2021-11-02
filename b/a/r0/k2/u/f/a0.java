package b.a.r0.k2.u.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a0 extends n<b.a.r0.k2.r.k, PbLoadMoreItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId s;
    public View.OnClickListener t;
    public int u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(b.a.r0.k2.y.b bVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId, bdUniqueId2};
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
        this.s = bdUniqueId2;
        this.u = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds104);
    }

    @Override // b.a.r0.k2.u.f.n, b.a.e.l.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (b.a.r0.k2.r.k) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: i0 */
    public PbLoadMoreItemViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbLoadMoreItemViewHolder(LayoutInflater.from(this.f2419e).inflate(b.a.r0.k2.j.new_pb_list_more, viewGroup, false), this.s) : (PbLoadMoreItemViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, b.a.r0.k2.r.k kVar, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, pbLoadMoreItemViewHolder})) == null) {
            super.Z(i2, view, viewGroup, kVar, pbLoadMoreItemViewHolder);
            if (kVar.f18778f) {
                pbLoadMoreItemViewHolder.setTextWithNoDataImg(kVar.f18777e);
            } else {
                pbLoadMoreItemViewHolder.setText(kVar.f18777e, this.u);
            }
            pbLoadMoreItemViewHolder.setOnClickListener(this.t);
            pbLoadMoreItemViewHolder.onChangeSkinType();
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }
}
