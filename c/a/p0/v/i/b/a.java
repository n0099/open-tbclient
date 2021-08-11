package c.a.p0.v.i.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.o0.s.q.c2;
import c.a.p0.a0.m;
import c.a.p0.v.i.d.c;
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
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f25252e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f25253f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f25254g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25255h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f25256i;

    /* renamed from: j  reason: collision with root package name */
    public View f25257j;
    public AlaVideoContainer k;
    public View l;
    public c2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: c.a.p0.v.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1180a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25258e;

        public View$OnClickListenerC1180a(a aVar) {
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
            this.f25258e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25258e.o == null) {
                return;
            }
            this.f25258e.o.b(view, this.f25258e.m);
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
        this.p = new View$OnClickListenerC1180a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f25252e = inflate;
        this.f25253f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f25252e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f25254g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f25255h = (TextView) this.f25252e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f25252e.findViewById(R.id.ala_video_container);
        this.f25257j = this.f25252e.findViewById(R.id.divider_below_reply_number_layout);
        this.f25256i = (ThreadCommentAndPraiseInfoLayout) this.f25252e.findViewById(R.id.text_bottom);
        this.l = this.f25252e.findViewById(R.id.divider_line);
        this.f25253f.setOnClickListener(this);
        this.f25256i.setOnClickListener(this);
        this.f25256i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25252e : (View) invokeV.objValue;
    }

    public final void d(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) {
            this.f25256i.onChangeSkinType();
            this.f25254g.onChangeSkinType();
            this.k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f25253f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (c2Var != null && m.k(c2Var.f0())) {
                SkinManager.setViewTextColor(this.f25255h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f25255h, R.color.CAM_X0105);
            }
        }
    }

    public void e() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (c2Var = this.m) == null || c2Var.J() == null) {
            return;
        }
        f(this.m, this.n);
    }

    public void f(c2 c2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, c2Var, str) == null) || c2Var == null || c2Var.J() == null) {
            return;
        }
        this.m = c2Var;
        this.n = str;
        this.f25253f.setVisibility(0);
        this.f25254g.setData(c2Var);
        if (this.f25254g.getHeaderImg() != null) {
            this.f25254g.getHeaderImg().setData(c2Var);
        }
        this.f25254g.setUserAfterClickListener(this.p);
        c2Var.T2(false, true);
        this.f25255h.setText(c2Var.e1());
        this.k.getController().d(c2Var, str, "", false);
        this.k.getController().c();
        this.f25256i.setReplyTimeVisible(false);
        this.f25256i.setNeedAddReplyIcon(true);
        this.f25256i.setIsBarViewVisible(false);
        this.f25256i.setCommentNumEnable(false);
        this.f25256i.setOnClickListener(this);
        this.f25256i.setLiveShareEnable(false);
        this.f25256i.setShareVisible(true);
        this.f25256i.setShowPraiseNum(true);
        this.f25256i.setNeedAddPraiseIcon(true);
        this.f25256i.setFrom(2);
        if (this.f25256i.setData(c2Var)) {
            this.f25257j.setVisibility(8);
        } else {
            this.f25257j.setVisibility(0);
        }
        d(c2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f25256i == null || (threadUserInfoLayout = this.f25254g) == null) {
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
            if (view != this.f25253f && view != this.f25256i.getCommentContainer()) {
                if (view.getId() != R.id.video_container || (cVar = this.o) == null) {
                    return;
                }
                cVar.a(view, this.m);
                return;
            }
            c2 c2Var = this.m;
            if (c2Var != null) {
                m.a(c2Var.f0());
            }
            c cVar2 = this.o;
            if (cVar2 != null) {
                cVar2.a(view, this.m);
            }
        }
    }
}
