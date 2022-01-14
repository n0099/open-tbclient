package c.a.t0.m3.k.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.t0.m3.e;
import c.a.t0.m3.g;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends d<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f19370b;

    /* renamed from: c  reason: collision with root package name */
    public View f19371c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f19372d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f19373e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f19374f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f19375g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f19376h;

    /* renamed from: i  reason: collision with root package name */
    public View f19377i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f19378j;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19379e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19379e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19379e.x == null) {
                return;
            }
            if (view == this.f19379e.f19371c) {
                this.f19379e.x.onBackPressed();
            } else if (view == this.f19379e.f19372d) {
                this.f19379e.x.i();
            } else if (view == this.f19379e.f19373e) {
                this.f19379e.x.g();
            } else if (view == this.f19379e.f19375g) {
                this.f19379e.x.c();
            } else if (view == this.f19379e.f19376h) {
                this.f19379e.x.h();
            } else if (view == this.f19379e.k) {
                this.f19379e.x.e();
            } else if (view == this.f19379e.f19378j) {
                this.f19379e.x.a();
            } else if (view == this.f19379e.o) {
                this.f19379e.x.f();
            } else if (view == this.f19379e.p) {
                this.f19379e.x.j();
            } else if (view == this.f19379e.f19374f) {
                this.f19379e.x.d();
            } else if (view == this.f19379e.q) {
                this.f19379e.x.b();
            }
        }
    }

    /* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.w = new a(this);
        this.l = secretSettingActivity;
        secretSettingActivity.setContentView(c.a.t0.m3.f.secret_setting_activity);
        o(secretSettingActivity);
    }

    public final void o(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, secretSettingActivity) == null) {
            this.f19370b = (LinearLayout) secretSettingActivity.findViewById(e.parent);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(e.view_navigation_bar);
            this.a = navigationBar;
            this.f19371c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setTitleText(secretSettingActivity.getPageContext().getString(g.secretSetting));
            this.f19372d = (TbSettingTextTipView) secretSettingActivity.findViewById(e.black_address_list);
            this.f19373e = (TbSettingTextTipView) secretSettingActivity.findViewById(e.privacy_attention_bar);
            this.f19374f = (TbSettingTextTipView) secretSettingActivity.findViewById(e.mark_setting);
            this.k = (TbSettingTextTipView) secretSettingActivity.findViewById(e.privacy_attention_group);
            this.f19375g = (TbSettingTextTipView) secretSettingActivity.findViewById(e.privacy_attention_live);
            this.f19376h = (TbSettingTextTipView) secretSettingActivity.findViewById(e.privacy_recommend_setting);
            this.f19378j = (TbSettingTextTipView) secretSettingActivity.findViewById(e.thread_reply_setting);
            this.f19377i = secretSettingActivity.findViewById(e.container_thread_reply_setting);
            this.r = (ScrollView) secretSettingActivity.findViewById(e.main_scroll);
            this.s = (TextView) secretSettingActivity.findViewById(e.secret_im);
            this.t = (TextView) secretSettingActivity.findViewById(e.secret_tiezi);
            this.u = (TextView) secretSettingActivity.findViewById(e.secret_tiezi_tip);
            this.v = (TextView) secretSettingActivity.findViewById(e.secret_ziliao);
            this.f19371c.setOnClickListener(this.w);
            this.f19372d.setOnClickListener(this.w);
            this.k.setOnClickListener(this.w);
            this.f19373e.setOnClickListener(this.w);
            this.f19374f.setOnClickListener(this.w);
            this.f19375g.setOnClickListener(this.w);
            this.f19376h.setOnClickListener(this.w);
            this.f19378j.setOnClickListener(this.w);
            this.m = this.l.findViewById(e.privacy_setting_container);
            this.n = this.l.getResources().getStringArray(c.a.t0.m3.a.privacy_setting_config);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(e.privacy_permission);
            this.o = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.w);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(e.privacy_ad_recommend);
            this.p = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.w);
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) secretSettingActivity.findViewById(e.privacy_forbidden_forum);
            this.q = tbSettingTextTipView3;
            tbSettingTextTipView3.setOnClickListener(this.w);
            UserData e2 = c.a.s0.a0.b.d().e();
            if (e2 != null && e2.getBazhuGradeData() != null && !StringUtils.isNull(e2.getBazhuGradeData().getDesc()) && !StringUtils.isNull(e2.getBazhuGradeData().getLevel())) {
                this.f19374f.setVisibility(0);
            } else {
                this.f19374f.setVisibility(8);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.l.getLayoutMode().k(i2 == 1);
            this.l.getLayoutMode().j(this.f19370b);
            this.a.onChangeSkinType(this.l.getPageContext(), i2);
            c.a.s0.s.u.c.d(this.s).v(c.a.t0.m3.b.CAM_X0108);
            c.a.s0.s.u.c.d(this.t).v(c.a.t0.m3.b.CAM_X0108);
            c.a.s0.s.u.c.d(this.u).v(c.a.t0.m3.b.CAM_X0108);
            c.a.s0.s.u.c.d(this.v).v(c.a.t0.m3.b.CAM_X0108);
            c.a.s0.s.u.c.d(this.r).f(c.a.t0.m3.b.CAM_X0204);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19372d.recycle();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
                this.f19377i.setVisibility(0);
                this.f19378j.setVisibility(0);
                return;
            }
            this.f19377i.setVisibility(8);
            this.f19378j.setVisibility(8);
        }
    }

    public void s(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (i3 == 3 && i2 == 3) {
                this.f19374f.setTip(this.l.getString(g.mark_tip_no));
            } else if (i3 == 3) {
                this.f19374f.setTip(this.l.getString(g.mark_tip_inside));
            } else if (i2 == 3) {
                this.f19374f.setTip(this.l.getString(g.mark_tip_outside));
            } else {
                this.f19374f.setTip(this.l.getString(g.mark_tip_all));
            }
        }
    }

    public void t(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            int i3 = i2 - 1;
            String[] strArr = this.n;
            if (strArr == null || i3 >= strArr.length || i3 < 0) {
                return;
            }
            if (TextUtils.equals(str, "like")) {
                this.f19373e.setTip(this.n[i3]);
            } else if (TextUtils.equals(str, "group")) {
                this.k.setTip(this.n[i3]);
            } else if (TextUtils.equals(str, "live")) {
                this.f19375g.setTip(this.n[i3]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i3 == 0) {
                    this.f19378j.setTip(this.l.getString(g.all_person));
                } else {
                    this.f19378j.setTip(this.n[i3]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                s(c.a.s0.s.h0.b.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), c.a.s0.s.h0.b.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void u(c.a.t0.m3.k.a.a aVar) {
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
            this.f19373e.setTip(this.n[c2]);
        }
        int e2 = aVar.e() - 1;
        if (e2 < length && e2 >= 0) {
            this.f19375g.setTip(this.n[e2]);
        }
        int g2 = aVar.g() - 1;
        if (g2 < length && g2 >= 0) {
            if (g2 == 0) {
                this.f19378j.setTip(this.l.getString(g.all_person));
            } else {
                this.f19378j.setTip(this.n[g2]);
            }
        }
        s(aVar.a(), aVar.b());
    }
}
