package c.a.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.l.w0.a;
import c.a.s0.s.q.e2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class u extends c implements q, p<e2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f4221i;

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f4222j;
    public View k;
    public View l;
    public View m;
    public ImageView n;
    public TextView o;
    public e2 p;
    public boolean q;
    public boolean r;
    public CustomMessageListener s;

    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof e2) && ((e2) customResponsedMessage.getData()) == this.a.p) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f4223e;

        public b(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4223e = uVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4223e.n == null || this.f4223e.p == null || this.f4223e.o == null || this.f4223e.p.F2() || !this.f4223e.r) {
                return;
            }
            if (this.f4223e.p.m2() || !c.a.t0.d1.b.f().i()) {
                if (this.f4223e.p.n2() || !c.a.t0.d1.a.h().j()) {
                    c.a.t0.d1.b.f().l(this.f4223e.p);
                    this.f4223e.p.k4(false);
                    c.a.t0.d1.a.h().l(this.f4223e.p);
                    this.f4223e.p.l4(false);
                } else if (c.a.t0.d1.a.h().a(this.f4223e.p)) {
                    this.f4223e.p.l4(true);
                }
            } else if (c.a.t0.d1.b.f().a(this.f4223e.p)) {
                this.f4223e.p.k4(true);
            }
            this.f4223e.q();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, this.f4223e.p));
        }
    }

    public u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = true;
        this.s = new a(this, 2921402);
        View inflate = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.k = inflate;
        this.l = inflate.findViewById(R.id.multi_del_mask_top_view);
        this.f4222j = (LinearLayout) this.k.findViewById(R.id.multi_del_bottom_layout);
        this.l.setAlpha(0.5f);
        View findViewById = this.k.findViewById(R.id.multi_del_mask_bottom_view);
        this.m = findViewById;
        findViewById.setAlpha(0.5f);
        this.n = (ImageView) this.k.findViewById(R.id.manage_select_img);
        this.f4221i = (RelativeLayout) this.k.findViewById(R.id.multi_del_bottom_root);
        this.o = (TextView) this.k.findViewById(R.id.manage_select_txt);
        f(this.k);
        this.k.setFocusable(true);
        this.k.setOnClickListener(new b(this));
        g(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.s);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.s);
        }
    }

    @Override // c.a.l.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.l.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: o */
    public void onBindDataToView(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) {
            this.p = e2Var;
            this.r = e2Var.getType() != e2.Y3 && (e2Var == null || e2Var.J() == null || !e2Var.J().isForumBusinessAccount() || e2Var.isSelf()) && e2Var != null && (!e2Var.C2() || e2Var.isSelf());
            if (!c.a.t0.d1.b.f().i() && !c.a.t0.d1.a.h().j()) {
                this.f4156h.o(new a.C0195a(4, Boolean.TRUE));
                this.k.setVisibility(8);
                return;
            }
            this.k.setVisibility(0);
            this.f4156h.o(new a.C0195a(4, Boolean.FALSE));
            q();
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            if (!this.p.m2() && !this.p.n2()) {
                WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
            }
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.l);
            d2.n(R.string.J_X06);
            d2.m(this.q ? 2 : 1);
            d2.f(R.color.CAM_X0201);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.m);
            d3.n(R.string.J_X06);
            d3.m(2);
            d3.f(R.color.CAM_X0201);
            c.a.s0.s.u.c.d(this.o).A(R.string.F_X01);
            SkinManager.setViewTextColor(this.o, (this.p.m2() || this.p.n2()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.q = z;
        }
    }

    public final void q() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (e2Var = this.p) == null) {
            return;
        }
        int i2 = 4;
        this.l.setVisibility((e2Var.m2() || this.p.n2() || !this.r) ? 0 : 4);
        this.m.setVisibility((this.p.m2() || this.p.n2()) ? 0 : 0);
        if (this.q) {
            this.f4221i.setVisibility(0);
            if (this.r) {
                this.n.setVisibility(0);
                this.o.setVisibility(0);
                if (!this.p.m2() && !this.p.n2()) {
                    WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                } else {
                    WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                }
                SkinManager.setViewTextColor(this.o, (this.p.m2() || this.p.n2()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            return;
        }
        this.f4221i.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
    }

    public void r(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
        }
    }

    public void s(int i2, m0 m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, m0Var) == null) {
            this.f4222j.setWeightSum(i2);
            if (this.f4222j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f4222j.getLayoutParams()).setMargins(m0Var.f4198f, m0Var.f4196d, m0Var.f4199g, m0Var.f4197e);
            }
        }
    }
}
