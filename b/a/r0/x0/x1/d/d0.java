package b.a.r0.x0.x1.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.x0.b1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.entelechy.adapter.FrsVideoActivityViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class d0 extends b.a.r0.x0.k<b.a.r0.l3.r, FrsVideoActivityViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l3.r f26626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d0 f26627f;

        public a(d0 d0Var, b.a.r0.l3.r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26627f = d0Var;
            this.f26626e = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12587").param("fid", this.f26627f.x));
                b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                j.w("frs_video_activity_tip" + this.f26627f.x, System.currentTimeMillis());
                b.a.r0.l3.r rVar = this.f26626e;
                if (rVar == null || StringUtils.isNull(rVar.f20805f)) {
                    return;
                }
                b.a.q0.m.a.k(this.f26627f.f2419e, this.f26626e.f20805f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean v0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j == 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j > 86400000) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimeMillis);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j);
            return calendar.get(7) > calendar2.get(7);
        }
        return invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: w0 */
    public FrsVideoActivityViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2419e).inflate(f1.frs_video_activity_item, (ViewGroup) null);
            FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
            SkinManager.setViewTextColor(frsVideoActivityViewHolder.mTitleTv, b1.CAM_X0105);
            SkinManager.setViewTextColor(frsVideoActivityViewHolder.mTypeTv, b1.CAM_X0301);
            SkinManager.setImageResource(frsVideoActivityViewHolder.mTipImageView, d1.icon_news_list_prompt);
            SkinManager.setImageResource(frsVideoActivityViewHolder.mMoreImageView, d1.icon_index_category_arrow_r);
            SkinManager.setBackgroundColor(frsVideoActivityViewHolder.topDivider, b1.CAM_X0204);
            SkinManager.setBackgroundColor(frsVideoActivityViewHolder.bottomDivider, b1.CAM_X0204);
            SkinManager.setBackgroundResource(inflate, d1.home_thread_card_item_bg);
            return frsVideoActivityViewHolder;
        }
        return (FrsVideoActivityViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    /* renamed from: x0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.l3.r rVar, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, rVar, frsVideoActivityViewHolder})) == null) {
            if (view == null || frsVideoActivityViewHolder == null) {
                return null;
            }
            view.setOnClickListener(new a(this, rVar));
            frsVideoActivityViewHolder.mTitleTv.setText(rVar != null ? rVar.f20804e : "");
            b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
            if (v0(j.l("frs_video_activity_tip" + this.x, 0L))) {
                frsVideoActivityViewHolder.mTipImageView.setVisibility(0);
            } else {
                frsVideoActivityViewHolder.mTipImageView.setVisibility(8);
            }
            return frsVideoActivityViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.x = str;
        }
    }
}
