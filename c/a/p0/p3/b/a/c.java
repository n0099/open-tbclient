package c.a.p0.p3.b.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import c.a.d.a.d;
import c.a.d.a.f;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends d<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f16930b;

    /* renamed from: c  reason: collision with root package name */
    public View f16931c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f16932d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f16933e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f16934f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f16935g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f16936h;
    public View i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public SecretSettingActivity l;
    public View m;
    public String[] n;
    public TbSettingTextTipView o;
    public TbSettingTextTipView p;
    public TbSettingTextTipView q;
    public ScrollView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public View.OnClickListener w;
    public b x;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.x == null) {
                return;
            }
            if (view == this.a.f16931c) {
                this.a.x.onBackPressed();
            } else if (view == this.a.f16932d) {
                this.a.x.i();
            } else if (view == this.a.f16933e) {
                this.a.x.g();
            } else if (view == this.a.f16935g) {
                this.a.x.c();
            } else if (view == this.a.f16936h) {
                this.a.x.h();
            } else if (view == this.a.k) {
                this.a.x.e();
            } else if (view == this.a.j) {
                this.a.x.a();
            } else if (view == this.a.o) {
                this.a.x.f();
            } else if (view == this.a.p) {
                this.a.x.j();
            } else if (view == this.a.f16934f) {
                this.a.x.d();
            } else if (view == this.a.q) {
                this.a.x.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();

        void onBackPressed();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {secretSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.w = new a(this);
        this.l = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d075c);
        q(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.l.getLayoutMode().k(i == 1);
            this.l.getLayoutMode().j(this.f16930b);
            this.a.onChangeSkinType(this.l.getPageContext(), i);
            c.a.o0.r.v.c.d(this.s).v(R.color.CAM_X0108);
            c.a.o0.r.v.c.d(this.t).v(R.color.CAM_X0108);
            c.a.o0.r.v.c.d(this.u).v(R.color.CAM_X0108);
            c.a.o0.r.v.c.d(this.v).v(R.color.CAM_X0108);
            c.a.o0.r.v.c.d(this.r).f(R.color.CAM_X0204);
        }
    }

    public final void q(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, secretSettingActivity) == null) {
            this.f16930b = (LinearLayout) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091647);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.a = navigationBar;
            this.f16931c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setTitleText(secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a4));
            this.f16932d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09037e);
            this.f16933e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918ed);
            this.f16934f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0913a4);
            this.k = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918ee);
            this.f16935g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918ef);
            this.f16936h = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918f5);
            this.j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091fc3);
            this.i = secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0906d6);
            this.r = (ScrollView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091377);
            this.s = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091c65);
            this.t = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091c66);
            this.u = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091c67);
            this.v = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091c68);
            this.f16931c.setOnClickListener(this.w);
            this.f16932d.setOnClickListener(this.w);
            this.k.setOnClickListener(this.w);
            this.f16933e.setOnClickListener(this.w);
            this.f16934f.setOnClickListener(this.w);
            this.f16935g.setOnClickListener(this.w);
            this.f16936h.setOnClickListener(this.w);
            this.j.setOnClickListener(this.w);
            this.m = this.l.findViewById(R.id.obfuscated_res_0x7f0918f6);
            this.n = this.l.getResources().getStringArray(R.array.obfuscated_res_0x7f030013);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918f4);
            this.o = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.w);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918ec);
            this.p = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.w);
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918f0);
            this.q = tbSettingTextTipView3;
            tbSettingTextTipView3.setOnClickListener(this.w);
            UserData e2 = c.a.o0.z.b.d().e();
            if (e2 != null && e2.getBazhuGradeData() != null && !StringUtils.isNull(e2.getBazhuGradeData().getDesc()) && !StringUtils.isNull(e2.getBazhuGradeData().getLevel())) {
                this.f16934f.setVisibility(0);
            } else {
                this.f16934f.setVisibility(8);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16932d.g();
        }
    }

    public void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                return;
            }
            this.i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public void u(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            if (i2 == 3 && i == 3) {
                this.f16934f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a8d));
            } else if (i2 == 3) {
                this.f16934f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a8c));
            } else if (i == 3) {
                this.f16934f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a8e));
            } else {
                this.f16934f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a8b));
            }
        }
    }

    public void v(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            int i2 = i - 1;
            String[] strArr = this.n;
            if (strArr == null || i2 >= strArr.length || i2 < 0) {
                return;
            }
            if (TextUtils.equals(str, "like")) {
                this.f16933e.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.k.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.f16935g.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.j.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0266));
                } else {
                    this.j.setTip(this.n[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                u(c.a.o0.r.j0.b.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), c.a.o0.r.j0.b.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void w(c.a.p0.p3.b.a.a aVar) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || (strArr = this.n) == null) {
            return;
        }
        int length = strArr.length;
        int d2 = aVar.d() - 1;
        if (d2 < length && d2 >= 0) {
            this.k.setTip(this.n[d2]);
        }
        int c2 = aVar.c() - 1;
        if (c2 < length && c2 >= 0) {
            this.f16933e.setTip(this.n[c2]);
        }
        int e2 = aVar.e() - 1;
        if (e2 < length && e2 >= 0) {
            this.f16935g.setTip(this.n[e2]);
        }
        int g2 = aVar.g() - 1;
        if (g2 < length && g2 >= 0) {
            if (g2 == 0) {
                this.j.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0266));
            } else {
                this.j.setTip(this.n[g2]);
            }
        }
        u(aVar.a(), aVar.b());
    }
}
