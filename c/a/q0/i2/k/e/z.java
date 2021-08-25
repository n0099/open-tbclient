package c.a.q0.i2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class z extends m<c.a.q0.i2.h.j, PbLoadMoreItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId s;
    public View.OnClickListener t;
    public int u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(c.a.q0.i2.o.b bVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
                super((c.a.q0.i2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = bdUniqueId2;
        this.u = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    }

    @Override // c.a.q0.i2.k.e.m, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view, viewGroup, (c.a.q0.i2.h.j) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public PbLoadMoreItemViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbLoadMoreItemViewHolder(LayoutInflater.from(this.f2966e).inflate(R.layout.new_pb_list_more, viewGroup, false), this.s) : (PbLoadMoreItemViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, c.a.q0.i2.h.j jVar, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, pbLoadMoreItemViewHolder})) == null) {
            super.a0(i2, view, viewGroup, jVar, pbLoadMoreItemViewHolder);
            if (jVar.f19085f) {
                pbLoadMoreItemViewHolder.setTextWithNoDataImg(jVar.f19084e);
            } else {
                pbLoadMoreItemViewHolder.setText(jVar.f19084e, this.u);
            }
            pbLoadMoreItemViewHolder.setOnClickListener(this.t);
            pbLoadMoreItemViewHolder.onChangeSkinType();
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }
}
