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
    public View f14858e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f14859f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f14860g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14861h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f14862i;

    /* renamed from: j  reason: collision with root package name */
    public View f14863j;
    public AlaVideoContainer k;
    public View l;
    public e2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: c.a.t0.a0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0941a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14864e;

        public View$OnClickListenerC0941a(a aVar) {
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
            this.f14864e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14864e.o == null) {
                return;
            }
            this.f14864e.o.b(view, this.f14864e.m);
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
        this.p = new View$OnClickListenerC0941a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f14858e = inflate;
        this.f14859f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f14858e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f14860g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f14861h = (TextView) this.f14858e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f14858e.findViewById(R.id.ala_video_container);
        this.f14863j = this.f14858e.findViewById(R.id.divider_below_reply_number_layout);
        this.f14862i = (ThreadCommentAndPraiseInfoLayout) this.f14858e.findViewById(R.id.text_bottom);
        this.l = this.f14858e.findViewById(R.id.divider_line);
        this.f14859f.setOnClickListener(this);
        this.f14862i.setOnClickListener(this);
        this.f14862i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14858e : (View) invokeV.objValue;
    }

    public final void d(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) {
            this.f14862i.onChangeSkinType();
            this.f14860g.onChangeSkinType();
            this.k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f14859f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (e2Var != null && m.k(e2Var.g0())) {
                SkinManager.setViewTextColor(this.f14861h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f14861h, R.color.CAM_X0105);
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
        this.f14859f.setVisibility(0);
        this.f14860g.setData(e2Var);
        if (this.f14860g.getHeaderImg() != null) {
            this.f14860g.getHeaderImg().setData(e2Var);
        }
        this.f14860g.setUserAfterClickListener(this.p);
        e2Var.d3(false, true);
        this.f14861h.setText(e2Var.i1());
        this.k.getController().d(e2Var, str, "", false);
        this.k.getController().c();
        this.f14862i.setReplyTimeVisible(false);
        this.f14862i.setNeedAddReplyIcon(true);
        this.f14862i.setIsBarViewVisible(false);
        this.f14862i.setCommentNumEnable(false);
        this.f14862i.setOnClickListener(this);
        this.f14862i.setLiveShareEnable(false);
        this.f14862i.setShareVisible(true);
        this.f14862i.setShowPraiseNum(true);
        this.f14862i.setNeedAddPraiseIcon(true);
        this.f14862i.setFrom(2);
        if (this.f14862i.setData(e2Var)) {
            this.f14863j.setVisibility(8);
        } else {
            this.f14863j.setVisibility(0);
        }
        d(e2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f14862i == null || (threadUserInfoLayout = this.f14860g) == null) {
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
            if (view != this.f14859f && view != this.f14862i.getCommentContainer()) {
                if (view.getId() != R.id.video_container || (cVar = this.o) == null) {
                    return;
                }
                cVar.a(view, this.m);
                return;
            }
            e2 e2Var = this.m;
            if (e2Var != null) {
                m.a(e2Var.g0());
            }
            c cVar2 = this.o;
            if (cVar2 != null) {
                cVar2.a(view, this.m);
            }
        }
    }
}
