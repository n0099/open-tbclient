package c.a.r0.q2.u.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i extends n<c.a.q0.s.q.q, PbBjhRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.q2.r.f s;
    public int t;
    public boolean u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.r0.q2.y.b bVar, BdUniqueId bdUniqueId) {
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

    public final void i0(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbBjhRecommendViewHolder) == null) || pbBjhRecommendViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbBjhRecommendViewHolder.mSkinType != skinType) {
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.mHeadView, c.a.r0.q2.f.CAM_X0204, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.mCrossLine, c.a.r0.q2.f.CAM_X0203, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.mTailDividerLine, c.a.r0.q2.f.CAM_X0204, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.mMoreVideoTv, c.a.r0.q2.f.CAM_X0302, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.contentView, c.a.r0.q2.f.CAM_X0105, 1, skinType);
            pbBjhRecommendViewHolder.videoPlayIcon.setImageDrawable(SvgManager.getInstance().getPureDrawable(c.a.r0.q2.h.ic_icon_pure_video_play12_svg, c.a.r0.q2.f.CAM_X0101, null));
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.videoDuringTv, c.a.r0.q2.f.CAM_X0101, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.mUserInfoTv, c.a.r0.q2.f.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.mVideoInfoTv, c.a.r0.q2.f.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundSelector(pbBjhRecommendViewHolder.mMainView, c.a.r0.q2.f.CAM_X0302, c.a.r0.q2.f.CAM_X0204, skinType);
            c.a.q0.s.u.c.d(pbBjhRecommendViewHolder.mMainView).i(c.a.r0.q2.f.CAM_X0205, c.a.r0.q2.f.CAM_X0204);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(c.a.r0.q2.f.cp_bg_line_d_alpha0, c.a.r0.q2.f.CAM_X0105).cornerRadius(c.a.d.f.p.l.f(this.m.getPbActivity(), c.a.r0.q2.g.tbds10)).into(pbBjhRecommendViewHolder.mVideoMaskIv);
        }
        pbBjhRecommendViewHolder.mSkinType = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: j0 */
    public PbBjhRecommendViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.f2907e).inflate(c.a.r0.q2.j.bjh_recommend_item, (ViewGroup) null), this.m.getPbActivity());
            i0(pbBjhRecommendViewHolder);
            return pbBjhRecommendViewHolder;
        }
        return (PbBjhRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.q2.u.f.n, c.a.d.m.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.q0.s.q.q qVar, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, qVar, pbBjhRecommendViewHolder})) == null) {
            super.Z(i2, view, viewGroup, qVar, pbBjhRecommendViewHolder);
            if (qVar == null) {
                return null;
            }
            i0(pbBjhRecommendViewHolder);
            pbBjhRecommendViewHolder.bindData(qVar);
            pbBjhRecommendViewHolder.setBjhFrom(this.t);
            pbBjhRecommendViewHolder.setRefreshCurrentPage(this.u);
            c.a.r0.q2.r.f fVar = this.s;
            if (fVar != null) {
                pbBjhRecommendViewHolder.setOriginTid(fVar.Q());
                pbBjhRecommendViewHolder.setOriginIsVideoThread(this.s.r0());
                if (this.s.O() != null && this.s.O().L() != null) {
                    pbBjhRecommendViewHolder.setNid(this.s.O().L().oriUgcNid);
                }
                int i3 = this.t;
                int i4 = 3;
                if (i3 == 2) {
                    i4 = 1;
                } else if (i3 == 1) {
                    i4 = 2;
                } else if (i3 != 3) {
                    i4 = 4;
                }
                if (qVar.d0 == 40) {
                    StatisticItem.make("c13536").param("tid", qVar.v1()).param("fid", qVar.U()).param("obj_source", i4).param("obj_locate", qVar.T4()).param("obj_id", this.s.Q()).param("obj_type", qVar.U1() ? 1 : 0).eventStat();
                } else {
                    StatisticItem.make("c13533").param("tid", qVar.v1()).param("fid", qVar.U()).param("obj_source", i4).param("obj_locate", qVar.T4()).param("obj_id", this.s.Q()).eventStat();
                }
                if (this.s.r0()) {
                    StatisticItem statisticItem = new StatisticItem("c13588");
                    if (qVar.Z() != null) {
                        statisticItem.param("fid", qVar.Z().getForumId());
                    }
                    statisticItem.param("tid", qVar.v1());
                    statisticItem.param("obj_param1", qVar.a1);
                    statisticItem.param("obj_source", qVar.Z0);
                    statisticItem.param("obj_locate", qVar.T4());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("obj_id", this.s.Q());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (qVar.getThreadData().L() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, qVar.getThreadData().L().oriUgcNid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, qVar.getThreadData().L().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, qVar.D1());
                    statisticItem.param("ab_tag", qVar.b1);
                    statisticItem.param("extra", qVar.c1);
                    TiebaStatic.log(statisticItem);
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.t = i2;
        }
    }

    public void m0(c.a.r0.q2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.s = fVar;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.u = z;
        }
    }
}
