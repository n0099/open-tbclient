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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class u extends c implements q, p<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f3486e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f3487f;

    /* renamed from: g  reason: collision with root package name */
    public View f3488g;

    /* renamed from: h  reason: collision with root package name */
    public View f3489h;
    public View i;
    public ImageView j;
    public TextView k;
    public ThreadData l;
    public boolean m;
    public boolean n;
    public CustomMessageListener o;

    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ThreadData) && ((ThreadData) customResponsedMessage.getData()) == this.a.l) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        public b(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.j == null || this.a.l == null || this.a.k == null || this.a.l.isTransportThread() || !this.a.n) {
                return;
            }
            if (this.a.l.isMarkToDel() || !c.a.p0.f1.b.f().i()) {
                if (this.a.l.isMarkToMove() || !c.a.p0.f1.a.h().j()) {
                    c.a.p0.f1.b.f().l(this.a.l);
                    this.a.l.setMarkToDel(false);
                    c.a.p0.f1.a.h().l(this.a.l);
                    this.a.l.setMarkToMove(false);
                } else if (c.a.p0.f1.a.h().a(this.a.l)) {
                    this.a.l.setMarkToMove(true);
                }
            } else if (c.a.p0.f1.b.f().a(this.a.l)) {
                this.a.l.setMarkToDel(true);
            }
            this.a.r();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, this.a.l));
        }
    }

    public u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = true;
        this.o = new a(this, 2921402);
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d058b, (ViewGroup) null);
        this.f3488g = inflate;
        this.f3489h = inflate.findViewById(R.id.obfuscated_res_0x7f09147f);
        this.f3487f = (LinearLayout) this.f3488g.findViewById(R.id.obfuscated_res_0x7f091479);
        this.f3489h.setAlpha(0.5f);
        View findViewById = this.f3488g.findViewById(R.id.obfuscated_res_0x7f09147e);
        this.i = findViewById;
        findViewById.setAlpha(0.5f);
        this.j = (ImageView) this.f3488g.findViewById(R.id.obfuscated_res_0x7f091389);
        this.f3486e = (RelativeLayout) this.f3488g.findViewById(R.id.obfuscated_res_0x7f09147a);
        this.k = (TextView) this.f3488g.findViewById(R.id.obfuscated_res_0x7f09138b);
        g(this.f3488g);
        this.f3488g.setFocusable(true);
        this.f3488g.setOnClickListener(new b(this));
        h(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.o);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.o);
        }
    }

    @Override // c.a.l.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // c.a.l.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            if (!this.l.isMarkToDel() && !this.l.isMarkToMove()) {
                WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080905, R.color.CAM_X0107, null);
            } else {
                WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080902, R.color.CAM_X0304, null);
            }
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f3489h);
            d2.n(R.string.J_X06);
            d2.m(this.m ? 2 : 1);
            d2.f(R.color.CAM_X0201);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.i);
            d3.n(R.string.J_X06);
            d3.m(2);
            d3.f(R.color.CAM_X0201);
            c.a.o0.r.v.c.d(this.k).A(R.string.F_X01);
            SkinManager.setViewTextColor(this.k, (this.l.isMarkToDel() || this.l.isMarkToMove()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: p */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            this.l = threadData;
            this.n = threadData.getType() != ThreadData.TYPE_FAKE_VIDEO && (threadData == null || threadData.getAuthor() == null || !threadData.getAuthor().isForumBusinessAccount() || threadData.isSelf()) && threadData != null && (!threadData.isTiePlusCantDeleteUnion() || threadData.isSelf());
            if (!c.a.p0.f1.b.f().i() && !c.a.p0.f1.a.h().j()) {
                this.f3406d.o(new a.C0196a(4, Boolean.TRUE));
                this.f3488g.setVisibility(8);
                return;
            }
            this.f3488g.setVisibility(0);
            this.f3406d.o(new a.C0196a(4, Boolean.FALSE));
            r();
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.m = z;
        }
    }

    public final void r() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (threadData = this.l) == null) {
            return;
        }
        int i = 4;
        this.f3489h.setVisibility((threadData.isMarkToDel() || this.l.isMarkToMove() || !this.n) ? 0 : 4);
        this.i.setVisibility((this.l.isMarkToDel() || this.l.isMarkToMove()) ? 0 : 0);
        if (this.m) {
            this.f3486e.setVisibility(0);
            if (this.n) {
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                boolean isMarkToDel = this.l.isMarkToDel();
                int i2 = R.color.CAM_X0304;
                if (!isMarkToDel && !this.l.isMarkToMove()) {
                    WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080905, R.color.CAM_X0107, null);
                } else {
                    WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f080902, R.color.CAM_X0304, null);
                }
                TextView textView = this.k;
                if (!this.l.isMarkToDel() && !this.l.isMarkToMove()) {
                    i2 = R.drawable.selector_comment_and_prise_item_text_color;
                }
                SkinManager.setViewTextColor(textView, i2);
                return;
            }
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.f3486e.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
        }
    }

    public void t(int i, m0 m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, m0Var) == null) {
            this.f3487f.setWeightSum(i);
            if (this.f3487f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f3487f.getLayoutParams()).setMargins(m0Var.f3460f, m0Var.f3458d, m0Var.f3461g, m0Var.f3459e);
            }
        }
    }
}
