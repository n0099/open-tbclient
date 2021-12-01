package c.a.r0.q2.u.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemVideoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b0 extends n<c.a.r0.q2.r.l, PbLoadMoreItemVideoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(c.a.r0.q2.y.b bVar, BdUniqueId bdUniqueId) {
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
                super((c.a.r0.q2.y.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.q2.u.f.n, c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (c.a.r0.q2.r.l) obj, (PbLoadMoreItemVideoViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: i0 */
    public PbLoadMoreItemVideoViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbLoadMoreItemVideoViewHolder(LayoutInflater.from(this.f2907e).inflate(c.a.r0.q2.j.new_pb_video_more, viewGroup, false)) : (PbLoadMoreItemVideoViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, c.a.r0.q2.r.l lVar, PbLoadMoreItemVideoViewHolder pbLoadMoreItemVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, pbLoadMoreItemVideoViewHolder})) == null) {
            super.Z(i2, view, viewGroup, lVar, pbLoadMoreItemVideoViewHolder);
            pbLoadMoreItemVideoViewHolder.setOnClickListener(this.s);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
