package c.a.t0.t2.y.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.d.f.p.n;
import c.a.t0.t2.r.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatEnterForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class i extends c.a.d.n.e.a<x, VideoTabPbFloatEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f23590e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23590e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f23590e.m instanceof VideoPbCommentFloatFragment)) {
                VideoPbCommentFloatFragment videoPbCommentFloatFragment = (VideoPbCommentFloatFragment) this.f23590e.m;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", videoPbCommentFloatFragment.getPbModel().getForumId());
                statisticItem.param("tid", videoPbCommentFloatFragment.getPbModel().h1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", videoPbCommentFloatFragment.getPbModel().q0());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 16);
                statisticItem.param("obj_locate", videoPbCommentFloatFragment.getFromVideoPageType());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, BdUniqueId bdUniqueId, BaseFragment baseFragment) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, baseFragment};
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
        this.m = baseFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, x xVar, VideoTabPbFloatEnterForumViewHolder videoTabPbFloatEnterForumViewHolder) {
        b0(i2, view, viewGroup, xVar, videoTabPbFloatEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public VideoTabPbFloatEnterForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f3360e);
            FlowLabelLayout flowLabelLayout = new FlowLabelLayout(this.f3360e);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = n.f(this.f3360e, c.a.t0.t2.g.tbds156);
            layoutParams.topMargin = n.f(this.f3360e, c.a.t0.t2.g.M_H_X003);
            layoutParams.rightMargin = n.f(this.f3360e, c.a.t0.t2.g.M_W_X007);
            layoutParams.bottomMargin = n.f(this.f3360e, c.a.t0.t2.g.M_H_X005);
            frameLayout.addView(flowLabelLayout, layoutParams);
            return new VideoTabPbFloatEnterForumViewHolder(this.f3360e, frameLayout);
        }
        return (VideoTabPbFloatEnterForumViewHolder) invokeL.objValue;
    }

    public View b0(int i2, View view, ViewGroup viewGroup, x xVar, VideoTabPbFloatEnterForumViewHolder videoTabPbFloatEnterForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, xVar, videoTabPbFloatEnterForumViewHolder})) == null) {
            if (xVar != null) {
                videoTabPbFloatEnterForumViewHolder.setData(xVar.f22746e);
                videoTabPbFloatEnterForumViewHolder.setAfterListener(new a(this));
            }
            SkinManager.setBackgroundColor(view, c.a.t0.t2.f.CAM_X0204);
            videoTabPbFloatEnterForumViewHolder.changeSkinType();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
