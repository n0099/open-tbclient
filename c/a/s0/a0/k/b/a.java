package c.a.s0.a0.k.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.s.r.d2;
import c.a.s0.a0.k.d.c;
import c.a.s0.g0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f14736e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f14737f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f14738g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14739h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f14740i;

    /* renamed from: j  reason: collision with root package name */
    public View f14741j;

    /* renamed from: k  reason: collision with root package name */
    public AlaVideoContainer f14742k;
    public View l;
    public d2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: c.a.s0.a0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0903a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14743e;

        public View$OnClickListenerC0903a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14743e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14743e.o == null) {
                return;
            }
            this.f14743e.o.b(view, this.f14743e.m);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new View$OnClickListenerC0903a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f14736e = inflate;
        this.f14737f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f14736e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f14738g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f14739h = (TextView) this.f14736e.findViewById(R.id.text_title);
        this.f14742k = (AlaVideoContainer) this.f14736e.findViewById(R.id.ala_video_container);
        this.f14741j = this.f14736e.findViewById(R.id.divider_below_reply_number_layout);
        this.f14740i = (ThreadCommentAndPraiseInfoLayout) this.f14736e.findViewById(R.id.text_bottom);
        this.l = this.f14736e.findViewById(R.id.divider_line);
        this.f14737f.setOnClickListener(this);
        this.f14740i.setOnClickListener(this);
        this.f14740i.getCommentContainer().setOnClickListener(this);
        this.f14742k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14736e : (View) invokeV.objValue;
    }

    public final void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            this.f14740i.onChangeSkinType();
            this.f14738g.onChangeSkinType();
            this.f14742k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f14737f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (d2Var != null && m.k(d2Var.g0())) {
                SkinManager.setViewTextColor(this.f14739h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f14739h, R.color.CAM_X0105);
            }
        }
    }

    public void e() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (d2Var = this.m) == null || d2Var.J() == null) {
            return;
        }
        f(this.m, this.n);
    }

    public void f(d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, d2Var, str) == null) || d2Var == null || d2Var.J() == null) {
            return;
        }
        this.m = d2Var;
        this.n = str;
        this.f14737f.setVisibility(0);
        this.f14738g.setData(d2Var);
        if (this.f14738g.getHeaderImg() != null) {
            this.f14738g.getHeaderImg().setData(d2Var);
        }
        this.f14738g.setUserAfterClickListener(this.p);
        d2Var.d3(false, true);
        this.f14739h.setText(d2Var.i1());
        this.f14742k.getController().d(d2Var, str, "", false);
        this.f14742k.getController().c();
        this.f14740i.setReplyTimeVisible(false);
        this.f14740i.setNeedAddReplyIcon(true);
        this.f14740i.setIsBarViewVisible(false);
        this.f14740i.setCommentNumEnable(false);
        this.f14740i.setOnClickListener(this);
        this.f14740i.setLiveShareEnable(false);
        this.f14740i.setShareVisible(true);
        this.f14740i.setShowPraiseNum(true);
        this.f14740i.setNeedAddPraiseIcon(true);
        this.f14740i.setFrom(2);
        if (this.f14740i.setData(d2Var)) {
            this.f14741j.setVisibility(8);
        } else {
            this.f14741j.setVisibility(0);
        }
        d(d2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f14740i == null || (threadUserInfoLayout = this.f14738g) == null) {
            return;
        }
        threadUserInfoLayout.setPageUniqueId(bdUniqueId);
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.o = cVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view != this.f14737f && view != this.f14740i.getCommentContainer()) {
                if (view.getId() != R.id.video_container || (cVar = this.o) == null) {
                    return;
                }
                cVar.a(view, this.m);
                return;
            }
            d2 d2Var = this.m;
            if (d2Var != null) {
                m.a(d2Var.g0());
            }
            c cVar2 = this.o;
            if (cVar2 != null) {
                cVar2.a(view, this.m);
            }
        }
    }
}
