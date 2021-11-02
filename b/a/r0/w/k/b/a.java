package b.a.r0.w.k.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.q0.s.q.d2;
import b.a.r0.b0.m;
import b.a.r0.w.k.d.c;
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
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f25098e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f25099f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f25100g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25101h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f25102i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public d2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: b.a.r0.w.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1223a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25103e;

        public View$OnClickListenerC1223a(a aVar) {
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
            this.f25103e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25103e.o == null) {
                return;
            }
            this.f25103e.o.b(view, this.f25103e.m);
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
        this.p = new View$OnClickListenerC1223a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f25098e = inflate;
        this.f25099f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f25098e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f25100g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f25101h = (TextView) this.f25098e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f25098e.findViewById(R.id.ala_video_container);
        this.j = this.f25098e.findViewById(R.id.divider_below_reply_number_layout);
        this.f25102i = (ThreadCommentAndPraiseInfoLayout) this.f25098e.findViewById(R.id.text_bottom);
        this.l = this.f25098e.findViewById(R.id.divider_line);
        this.f25099f.setOnClickListener(this);
        this.f25102i.setOnClickListener(this);
        this.f25102i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25098e : (View) invokeV.objValue;
    }

    public final void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            this.f25102i.onChangeSkinType();
            this.f25100g.onChangeSkinType();
            this.k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f25099f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (d2Var != null && m.k(d2Var.f0())) {
                SkinManager.setViewTextColor(this.f25101h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f25101h, R.color.CAM_X0105);
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
        this.f25099f.setVisibility(0);
        this.f25100g.setData(d2Var);
        if (this.f25100g.getHeaderImg() != null) {
            this.f25100g.getHeaderImg().setData(d2Var);
        }
        this.f25100g.setUserAfterClickListener(this.p);
        d2Var.Z2(false, true);
        this.f25101h.setText(d2Var.g1());
        this.k.getController().d(d2Var, str, "", false);
        this.k.getController().c();
        this.f25102i.setReplyTimeVisible(false);
        this.f25102i.setNeedAddReplyIcon(true);
        this.f25102i.setIsBarViewVisible(false);
        this.f25102i.setCommentNumEnable(false);
        this.f25102i.setOnClickListener(this);
        this.f25102i.setLiveShareEnable(false);
        this.f25102i.setShareVisible(true);
        this.f25102i.setShowPraiseNum(true);
        this.f25102i.setNeedAddPraiseIcon(true);
        this.f25102i.setFrom(2);
        if (this.f25102i.setData(d2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(d2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f25102i == null || (threadUserInfoLayout = this.f25100g) == null) {
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
            if (view != this.f25099f && view != this.f25102i.getCommentContainer()) {
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
