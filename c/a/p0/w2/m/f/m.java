package c.a.p0.w2.m.f;

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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class m extends r<c.a.o0.r.r.q, PbBjhRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.w2.i.f o;
    public int p;
    public boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(c.a.p0.w2.q.c cVar, BdUniqueId bdUniqueId) {
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

    public final void b0(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbBjhRecommendViewHolder) == null) || pbBjhRecommendViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbBjhRecommendViewHolder.a != skinType) {
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.j, R.color.CAM_X0204, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.y, R.color.CAM_X0203, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.t, R.color.CAM_X0204, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.v, R.color.CAM_X0302, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.o, R.color.CAM_X0105, 1, skinType);
            pbBjhRecommendViewHolder.q.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.r, R.color.CAM_X0101, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.w, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.x, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundSelector(pbBjhRecommendViewHolder.i, R.color.CAM_X0302, R.color.CAM_X0204, skinType);
            c.a.o0.r.v.c.d(pbBjhRecommendViewHolder.i).i(R.color.CAM_X0205, R.color.CAM_X0204);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).cornerRadius(c.a.d.f.p.n.f(this.i.x(), R.dimen.tbds10)).into(pbBjhRecommendViewHolder.n);
        }
        pbBjhRecommendViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: c0 */
    public PbBjhRecommendViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d015c, (ViewGroup) null), this.i.x());
            b0(pbBjhRecommendViewHolder);
            return pbBjhRecommendViewHolder;
        }
        return (PbBjhRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.w2.m.f.r, c.a.d.o.e.a
    /* renamed from: d0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.o0.r.r.q qVar, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, qVar, pbBjhRecommendViewHolder})) == null) {
            super.S(i, view, viewGroup, qVar, pbBjhRecommendViewHolder);
            if (qVar == null) {
                return null;
            }
            b0(pbBjhRecommendViewHolder);
            pbBjhRecommendViewHolder.j(qVar);
            pbBjhRecommendViewHolder.k(this.p);
            pbBjhRecommendViewHolder.o(this.q);
            c.a.p0.w2.i.f fVar = this.o;
            if (fVar != null) {
                pbBjhRecommendViewHolder.n(fVar.Q());
                pbBjhRecommendViewHolder.m(this.o.r0());
                if (this.o.O() != null && this.o.O().getBaijiahaoData() != null) {
                    pbBjhRecommendViewHolder.l(this.o.O().getBaijiahaoData().oriUgcNid);
                }
                int i2 = this.p;
                int i3 = 3;
                if (i2 == 2) {
                    i3 = 1;
                } else if (i2 == 1) {
                    i3 = 2;
                } else if (i2 != 3) {
                    i3 = 4;
                }
                if (qVar.threadType == 40) {
                    StatisticItem.make("c13536").param("tid", qVar.getTid()).param("fid", qVar.getFid()).param("obj_source", i3).param("obj_locate", qVar.e()).param("obj_id", this.o.Q()).param("obj_type", qVar.isBjhDynamicThread() ? 1 : 0).eventStat();
                } else {
                    StatisticItem.make("c13533").param("tid", qVar.getTid()).param("fid", qVar.getFid()).param("obj_source", i3).param("obj_locate", qVar.e()).param("obj_id", this.o.Q()).eventStat();
                }
                if (this.o.r0()) {
                    StatisticItem statisticItem = new StatisticItem("c13588");
                    if (qVar.getForumData() != null) {
                        statisticItem.param("fid", qVar.getForumData().c());
                    }
                    statisticItem.param("tid", qVar.getTid());
                    statisticItem.param("obj_param1", qVar.mRecomWeight);
                    statisticItem.param("obj_source", qVar.mRecomSource);
                    statisticItem.param("obj_locate", qVar.e());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("obj_id", this.o.Q());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (qVar.getThreadData().getBaijiahaoData() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, qVar.getThreadData().getBaijiahaoData().oriUgcNid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, qVar.getThreadData().getBaijiahaoData().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, qVar.getVideoRecStaticticType());
                    statisticItem.param("ab_tag", qVar.mRecomAbTag);
                    statisticItem.param("extra", qVar.mRecomExtra);
                    TiebaStatic.log(statisticItem);
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.p = i;
        }
    }

    public void f0(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.q = z;
        }
    }
}
