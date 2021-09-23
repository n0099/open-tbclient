package c.a.r0.v.k.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.q0.s.q.d2;
import c.a.r0.a0.m;
import c.a.r0.v.k.d.c;
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
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f26086e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f26087f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f26088g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26089h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f26090i;

    /* renamed from: j  reason: collision with root package name */
    public View f26091j;
    public AlaVideoContainer k;
    public View l;
    public d2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: c.a.r0.v.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1213a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26092e;

        public View$OnClickListenerC1213a(a aVar) {
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
            this.f26092e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26092e.o == null) {
                return;
            }
            this.f26092e.o.b(view, this.f26092e.m);
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
        this.p = new View$OnClickListenerC1213a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f26086e = inflate;
        this.f26087f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f26086e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f26088g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f26089h = (TextView) this.f26086e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f26086e.findViewById(R.id.ala_video_container);
        this.f26091j = this.f26086e.findViewById(R.id.divider_below_reply_number_layout);
        this.f26090i = (ThreadCommentAndPraiseInfoLayout) this.f26086e.findViewById(R.id.text_bottom);
        this.l = this.f26086e.findViewById(R.id.divider_line);
        this.f26087f.setOnClickListener(this);
        this.f26090i.setOnClickListener(this);
        this.f26090i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26086e : (View) invokeV.objValue;
    }

    public final void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            this.f26090i.onChangeSkinType();
            this.f26088g.onChangeSkinType();
            this.k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f26087f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (d2Var != null && m.k(d2Var.f0())) {
                SkinManager.setViewTextColor(this.f26089h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f26089h, R.color.CAM_X0105);
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
        this.f26087f.setVisibility(0);
        this.f26088g.setData(d2Var);
        if (this.f26088g.getHeaderImg() != null) {
            this.f26088g.getHeaderImg().setData(d2Var);
        }
        this.f26088g.setUserAfterClickListener(this.p);
        d2Var.Z2(false, true);
        this.f26089h.setText(d2Var.g1());
        this.k.getController().d(d2Var, str, "", false);
        this.k.getController().c();
        this.f26090i.setReplyTimeVisible(false);
        this.f26090i.setNeedAddReplyIcon(true);
        this.f26090i.setIsBarViewVisible(false);
        this.f26090i.setCommentNumEnable(false);
        this.f26090i.setOnClickListener(this);
        this.f26090i.setLiveShareEnable(false);
        this.f26090i.setShareVisible(true);
        this.f26090i.setShowPraiseNum(true);
        this.f26090i.setNeedAddPraiseIcon(true);
        this.f26090i.setFrom(2);
        if (this.f26090i.setData(d2Var)) {
            this.f26091j.setVisibility(8);
        } else {
            this.f26091j.setVisibility(0);
        }
        d(d2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f26090i == null || (threadUserInfoLayout = this.f26088g) == null) {
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
            if (view != this.f26087f && view != this.f26090i.getCommentContainer()) {
                if (view.getId() != R.id.video_container || (cVar = this.o) == null) {
                    return;
                }
                cVar.a(view, this.m);
                return;
            }
            d2 d2Var = this.m;
            if (d2Var != null) {
                m.a(d2Var.f0());
            }
            c cVar2 = this.o;
            if (cVar2 != null) {
                cVar2.a(view, this.m);
            }
        }
    }
}
