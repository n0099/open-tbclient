package c.a.t0.a0.k.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.s0.s.q.d2;
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
    public View f15234e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f15235f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f15236g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15237h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f15238i;

    /* renamed from: j  reason: collision with root package name */
    public View f15239j;

    /* renamed from: k  reason: collision with root package name */
    public AlaVideoContainer f15240k;
    public View l;
    public d2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: c.a.t0.a0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0928a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15241e;

        public View$OnClickListenerC0928a(a aVar) {
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
            this.f15241e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15241e.o == null) {
                return;
            }
            this.f15241e.o.b(view, this.f15241e.m);
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
        this.p = new View$OnClickListenerC0928a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f15234e = inflate;
        this.f15235f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f15234e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f15236g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f15237h = (TextView) this.f15234e.findViewById(R.id.text_title);
        this.f15240k = (AlaVideoContainer) this.f15234e.findViewById(R.id.ala_video_container);
        this.f15239j = this.f15234e.findViewById(R.id.divider_below_reply_number_layout);
        this.f15238i = (ThreadCommentAndPraiseInfoLayout) this.f15234e.findViewById(R.id.text_bottom);
        this.l = this.f15234e.findViewById(R.id.divider_line);
        this.f15235f.setOnClickListener(this);
        this.f15238i.setOnClickListener(this);
        this.f15238i.getCommentContainer().setOnClickListener(this);
        this.f15240k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15234e : (View) invokeV.objValue;
    }

    public final void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            this.f15238i.onChangeSkinType();
            this.f15236g.onChangeSkinType();
            this.f15240k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f15235f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (d2Var != null && m.k(d2Var.g0())) {
                SkinManager.setViewTextColor(this.f15237h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f15237h, R.color.CAM_X0105);
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
        this.f15235f.setVisibility(0);
        this.f15236g.setData(d2Var);
        if (this.f15236g.getHeaderImg() != null) {
            this.f15236g.getHeaderImg().setData(d2Var);
        }
        this.f15236g.setUserAfterClickListener(this.p);
        d2Var.d3(false, true);
        this.f15237h.setText(d2Var.i1());
        this.f15240k.getController().d(d2Var, str, "", false);
        this.f15240k.getController().c();
        this.f15238i.setReplyTimeVisible(false);
        this.f15238i.setNeedAddReplyIcon(true);
        this.f15238i.setIsBarViewVisible(false);
        this.f15238i.setCommentNumEnable(false);
        this.f15238i.setOnClickListener(this);
        this.f15238i.setLiveShareEnable(false);
        this.f15238i.setShareVisible(true);
        this.f15238i.setShowPraiseNum(true);
        this.f15238i.setNeedAddPraiseIcon(true);
        this.f15238i.setFrom(2);
        if (this.f15238i.setData(d2Var)) {
            this.f15239j.setVisibility(8);
        } else {
            this.f15239j.setVisibility(0);
        }
        d(d2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f15238i == null || (threadUserInfoLayout = this.f15236g) == null) {
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
            if (view != this.f15235f && view != this.f15238i.getCommentContainer()) {
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
