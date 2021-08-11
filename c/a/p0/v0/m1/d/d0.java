package c.a.p0.v0.m1.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.adapter.FrsVideoActivityViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class d0 extends c.a.p0.v0.k<c.a.p0.i3.q, FrsVideoActivityViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.i3.q f26088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d0 f26089f;

        public a(d0 d0Var, c.a.p0.i3.q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26089f = d0Var;
            this.f26088e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12587").param("fid", this.f26089f.x));
                c.a.o0.s.d0.b j2 = c.a.o0.s.d0.b.j();
                j2.w("frs_video_activity_tip" + this.f26089f.x, System.currentTimeMillis());
                c.a.p0.i3.q qVar = this.f26088e;
                if (qVar == null || StringUtils.isNull(qVar.f20150f)) {
                    return;
                }
                c.a.o0.m.a.k(this.f26089f.f2904e, this.f26088e.f20150f);
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

    public final boolean w0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (j2 == 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j2 > 86400000) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimeMillis);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return calendar.get(7) > calendar2.get(7);
        }
        return invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: x0 */
    public FrsVideoActivityViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2904e).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
            FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
            SkinManager.setViewTextColor(frsVideoActivityViewHolder.mTitleTv, R.color.CAM_X0105);
            SkinManager.setViewTextColor(frsVideoActivityViewHolder.mTypeTv, R.color.CAM_X0301);
            SkinManager.setImageResource(frsVideoActivityViewHolder.mTipImageView, R.drawable.icon_news_list_prompt);
            SkinManager.setImageResource(frsVideoActivityViewHolder.mMoreImageView, R.drawable.icon_index_category_arrow_r);
            SkinManager.setBackgroundColor(frsVideoActivityViewHolder.topDivider, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(frsVideoActivityViewHolder.bottomDivider, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
            return frsVideoActivityViewHolder;
        }
        return (FrsVideoActivityViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.v0.k, c.a.e.k.e.a
    /* renamed from: y0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.p0.i3.q qVar, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, qVar, frsVideoActivityViewHolder})) == null) {
            if (view == null || frsVideoActivityViewHolder == null) {
                return null;
            }
            view.setOnClickListener(new a(this, qVar));
            frsVideoActivityViewHolder.mTitleTv.setText(qVar != null ? qVar.f20149e : "");
            c.a.o0.s.d0.b j2 = c.a.o0.s.d0.b.j();
            if (w0(j2.l("frs_video_activity_tip" + this.x, 0L))) {
                frsVideoActivityViewHolder.mTipImageView.setVisibility(0);
            } else {
                frsVideoActivityViewHolder.mTipImageView.setVisibility(8);
            }
            return frsVideoActivityViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void z0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.x = str;
        }
    }
}
