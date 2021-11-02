package b.a.r0.k2.y.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.e.e.p.l;
import b.a.r0.k2.r.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbEnterForumAndTopicViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f extends b.a.e.l.e.a<w, VideoPbEnterForumAndTopicViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // b.a.e.l.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, w wVar, VideoPbEnterForumAndTopicViewHolder videoPbEnterForumAndTopicViewHolder) {
        h0(i2, view, viewGroup, wVar, videoPbEnterForumAndTopicViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: g0 */
    public VideoPbEnterForumAndTopicViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f2419e);
            FlowLabelLayout flowLabelLayout = new FlowLabelLayout(this.f2419e);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = l.g(this.f2419e, b.a.r0.k2.g.M_W_X007);
            layoutParams.topMargin = l.g(this.f2419e, b.a.r0.k2.g.M_W_X004);
            layoutParams.rightMargin = l.g(this.f2419e, b.a.r0.k2.g.M_W_X007);
            layoutParams.bottomMargin = l.g(this.f2419e, b.a.r0.k2.g.M_W_X004);
            frameLayout.addView(flowLabelLayout, layoutParams);
            return new VideoPbEnterForumAndTopicViewHolder(this.f2419e, frameLayout);
        }
        return (VideoPbEnterForumAndTopicViewHolder) invokeL.objValue;
    }

    public View h0(int i2, View view, ViewGroup viewGroup, w wVar, VideoPbEnterForumAndTopicViewHolder videoPbEnterForumAndTopicViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, wVar, videoPbEnterForumAndTopicViewHolder})) == null) {
            if (wVar != null) {
                videoPbEnterForumAndTopicViewHolder.setData(wVar.f18825e);
            }
            videoPbEnterForumAndTopicViewHolder.changeSkinType();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
