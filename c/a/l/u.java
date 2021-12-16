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
import c.a.r0.s.r.d2;
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
public class u extends c implements q, p<d2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f3890i;

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f3891j;

    /* renamed from: k  reason: collision with root package name */
    public View f3892k;
    public View l;
    public View m;
    public ImageView n;
    public TextView o;
    public d2 p;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d2) && ((d2) customResponsedMessage.getData()) == this.a.p) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f3893e;

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
            this.f3893e = uVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3893e.n == null || this.f3893e.p == null || this.f3893e.o == null || this.f3893e.p.F2() || !this.f3893e.r) {
                return;
            }
            if (this.f3893e.p.m2() || !c.a.s0.d1.b.f().i()) {
                if (this.f3893e.p.n2() || !c.a.s0.d1.a.h().j()) {
                    c.a.s0.d1.b.f().l(this.f3893e.p);
                    this.f3893e.p.k4(false);
                    c.a.s0.d1.a.h().l(this.f3893e.p);
                    this.f3893e.p.l4(false);
                } else if (c.a.s0.d1.a.h().a(this.f3893e.p)) {
                    this.f3893e.p.l4(true);
                }
            } else if (c.a.s0.d1.b.f().a(this.f3893e.p)) {
                this.f3893e.p.k4(true);
            }
            this.f3893e.q();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, this.f3893e.p));
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
        this.f3892k = inflate;
        this.l = inflate.findViewById(R.id.multi_del_mask_top_view);
        this.f3891j = (LinearLayout) this.f3892k.findViewById(R.id.multi_del_bottom_layout);
        this.l.setAlpha(0.5f);
        View findViewById = this.f3892k.findViewById(R.id.multi_del_mask_bottom_view);
        this.m = findViewById;
        findViewById.setAlpha(0.5f);
        this.n = (ImageView) this.f3892k.findViewById(R.id.manage_select_img);
        this.f3890i = (RelativeLayout) this.f3892k.findViewById(R.id.multi_del_bottom_root);
        this.o = (TextView) this.f3892k.findViewById(R.id.manage_select_txt);
        f(this.f3892k);
        this.f3892k.setFocusable(true);
        this.f3892k.setOnClickListener(new b(this));
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
    public void onBindDataToView(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            this.p = d2Var;
            this.r = d2Var.getType() != d2.W3 && (d2Var == null || d2Var.J() == null || !d2Var.J().isForumBusinessAccount() || d2Var.isSelf()) && d2Var != null && (!d2Var.C2() || d2Var.isSelf());
            if (!c.a.s0.d1.b.f().i() && !c.a.s0.d1.a.h().j()) {
                this.f3809h.o(new a.C0165a(4, Boolean.TRUE));
                this.f3892k.setVisibility(8);
                return;
            }
            this.f3892k.setVisibility(0);
            this.f3809h.o(new a.C0165a(4, Boolean.FALSE));
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
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.l);
            d2.n(R.string.J_X06);
            d2.m(this.q ? 2 : 1);
            d2.f(R.color.CAM_X0201);
            c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(this.m);
            d3.n(R.string.J_X06);
            d3.m(2);
            d3.f(R.color.CAM_X0201);
            c.a.r0.s.v.c.d(this.o).A(R.string.F_X01);
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
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (d2Var = this.p) == null) {
            return;
        }
        int i2 = 4;
        this.l.setVisibility((d2Var.m2() || this.p.n2() || !this.r) ? 0 : 4);
        this.m.setVisibility((this.p.m2() || this.p.n2()) ? 0 : 0);
        if (this.q) {
            this.f3890i.setVisibility(0);
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
        this.f3890i.setVisibility(8);
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
            this.f3891j.setWeightSum(i2);
            if (this.f3891j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f3891j.getLayoutParams()).setMargins(m0Var.f3862f, m0Var.f3860d, m0Var.f3863g, m0Var.f3861e);
            }
        }
    }
}
