package c.a.t0.a0.k.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.s0.s.q.e2;
import c.a.t0.a0.k.d.c;
import c.a.t0.g0.m;
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
    public View f14998e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f14999f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f15000g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15001h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f15002i;

    /* renamed from: j  reason: collision with root package name */
    public View f15003j;
    public AlaVideoContainer k;
    public View l;
    public e2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: c.a.t0.a0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0951a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15004e;

        public View$OnClickListenerC0951a(a aVar) {
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
            this.f15004e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15004e.o == null) {
                return;
            }
            this.f15004e.o.b(view, this.f15004e.m);
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
        this.p = new View$OnClickListenerC0951a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f14998e = inflate;
        this.f14999f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f14998e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f15000g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f15001h = (TextView) this.f14998e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f14998e.findViewById(R.id.ala_video_container);
        this.f15003j = this.f14998e.findViewById(R.id.divider_below_reply_number_layout);
        this.f15002i = (ThreadCommentAndPraiseInfoLayout) this.f14998e.findViewById(R.id.text_bottom);
        this.l = this.f14998e.findViewById(R.id.divider_line);
        this.f14999f.setOnClickListener(this);
        this.f15002i.setOnClickListener(this);
        this.f15002i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14998e : (View) invokeV.objValue;
    }

    public final void d(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) {
            this.f15002i.onChangeSkinType();
            this.f15000g.onChangeSkinType();
            this.k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f14999f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (e2Var != null && m.k(e2Var.h0())) {
                SkinManager.setViewTextColor(this.f15001h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f15001h, R.color.CAM_X0105);
            }
        }
    }

    public void e() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (e2Var = this.m) == null || e2Var.J() == null) {
            return;
        }
        f(this.m, this.n);
    }

    public void f(e2 e2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, e2Var, str) == null) || e2Var == null || e2Var.J() == null) {
            return;
        }
        this.m = e2Var;
        this.n = str;
        this.f14999f.setVisibility(0);
        this.f15000g.setData(e2Var);
        if (this.f15000g.getHeaderImg() != null) {
            this.f15000g.getHeaderImg().setData(e2Var);
        }
        this.f15000g.setUserAfterClickListener(this.p);
        e2Var.e3(false, true);
        this.f15001h.setText(e2Var.j1());
        this.k.getController().d(e2Var, str, "", false);
        this.k.getController().c();
        this.f15002i.setReplyTimeVisible(false);
        this.f15002i.setNeedAddReplyIcon(true);
        this.f15002i.setIsBarViewVisible(false);
        this.f15002i.setCommentNumEnable(false);
        this.f15002i.setOnClickListener(this);
        this.f15002i.setLiveShareEnable(false);
        this.f15002i.setShareVisible(true);
        this.f15002i.setShowPraiseNum(true);
        this.f15002i.setNeedAddPraiseIcon(true);
        this.f15002i.setFrom(2);
        if (this.f15002i.setData(e2Var)) {
            this.f15003j.setVisibility(8);
        } else {
            this.f15003j.setVisibility(0);
        }
        d(e2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f15002i == null || (threadUserInfoLayout = this.f15000g) == null) {
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
            if (view != this.f14999f && view != this.f15002i.getCommentContainer()) {
                if (view.getId() != R.id.video_container || (cVar = this.o) == null) {
                    return;
                }
                cVar.a(view, this.m);
                return;
            }
            e2 e2Var = this.m;
            if (e2Var != null) {
                m.a(e2Var.h0());
            }
            c cVar2 = this.o;
            if (cVar2 != null) {
                cVar2.a(view, this.m);
            }
        }
    }
}
