package c.a.q0.i2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.q0.i2.k.e.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.GodReplyMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends m<b, GodReplyMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
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
    }

    @Override // c.a.q0.i2.k.e.m, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view, viewGroup, (b) obj, (GodReplyMoreViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public GodReplyMoreViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new GodReplyMoreViewHolder(LayoutInflater.from(this.f2966e).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false)) : (GodReplyMoreViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, b bVar, GodReplyMoreViewHolder godReplyMoreViewHolder) {
        InterceptResult invokeCommon;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, godReplyMoreViewHolder})) == null) {
            super.a0(i2, view, viewGroup, bVar, godReplyMoreViewHolder);
            if (godReplyMoreViewHolder != null && (textView = godReplyMoreViewHolder.moreView) != null) {
                View.OnClickListener onClickListener = this.s;
                if (onClickListener != null) {
                    textView.setOnClickListener(onClickListener);
                }
                if (godReplyMoreViewHolder.skinType != TbadkCoreApplication.getInst().getSkinType()) {
                    godReplyMoreViewHolder.skinType = TbadkCoreApplication.getInst().getSkinType();
                    SkinManager.setViewTextColor(godReplyMoreViewHolder.moreView, R.color.CAM_X0106);
                    SkinManager.setBackgroundResource(godReplyMoreViewHolder.moreView, R.drawable.more_all);
                    SkinManager.setBackgroundResource(godReplyMoreViewHolder.dividerLine, R.color.CAM_X0204);
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
