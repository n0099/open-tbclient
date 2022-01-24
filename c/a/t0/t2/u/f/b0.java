package c.a.t0.t2.u.f;

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
/* loaded from: classes8.dex */
public class b0 extends o<c.a.t0.t2.r.k, PbLoadMoreItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId s;
    public View.OnClickListener t;
    public int u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(c.a.t0.t2.y.c cVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(cVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId, bdUniqueId2};
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
        this.s = bdUniqueId2;
        this.u = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.t2.g.tbds104);
    }

    @Override // c.a.t0.t2.u.f.o, c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        c0(i2, view, viewGroup, (c.a.t0.t2.r.k) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public PbLoadMoreItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbLoadMoreItemViewHolder(LayoutInflater.from(this.f3360e).inflate(c.a.t0.t2.j.new_pb_list_more, viewGroup, false), this.s) : (PbLoadMoreItemViewHolder) invokeL.objValue;
    }

    public View c0(int i2, View view, ViewGroup viewGroup, c.a.t0.t2.r.k kVar, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, pbLoadMoreItemViewHolder})) == null) {
            super.S(i2, view, viewGroup, kVar, pbLoadMoreItemViewHolder);
            if (kVar.f22701f) {
                pbLoadMoreItemViewHolder.setTextWithNoDataImg(kVar.f22700e);
            } else {
                pbLoadMoreItemViewHolder.setText(kVar.f22700e, this.u);
            }
            pbLoadMoreItemViewHolder.setOnClickListener(this.t);
            pbLoadMoreItemViewHolder.onChangeSkinType();
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }
}
