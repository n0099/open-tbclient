package c.a.p0.w2.m.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemVideoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h0 extends r<c.a.p0.w2.i.m, PbLoadMoreItemVideoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(c.a.p0.w2.q.c cVar, BdUniqueId bdUniqueId) {
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
        c0(i, view, viewGroup, (c.a.p0.w2.i.m) obj, (PbLoadMoreItemVideoViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public PbLoadMoreItemVideoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbLoadMoreItemVideoViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0601, viewGroup, false)) : (PbLoadMoreItemVideoViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view, ViewGroup viewGroup, c.a.p0.w2.i.m mVar, PbLoadMoreItemVideoViewHolder pbLoadMoreItemVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, mVar, pbLoadMoreItemVideoViewHolder})) == null) {
            super.S(i, view, viewGroup, mVar, pbLoadMoreItemVideoViewHolder);
            pbLoadMoreItemVideoViewHolder.c(this.o);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }
}
