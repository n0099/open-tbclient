package c.a.s0.m3.b.a;

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
/* loaded from: classes7.dex */
public class c extends d<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f19455b;

    /* renamed from: c  reason: collision with root package name */
    public View f19456c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f19457d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f19458e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f19459f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f19460g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f19461h;

    /* renamed from: i  reason: collision with root package name */
    public View f19462i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f19463j;

    /* renamed from: k  reason: collision with root package name */
    public TbSettingTextTipView f19464k;
    public SecretSettingActivity l;
    public View m;
    public String[] n;
    public TbSettingTextTipView o;
    public TbSettingTextTipView p;
    public ScrollView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View.OnClickListener v;
    public b w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19465e;

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
            this.f19465e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19465e.w == null) {
                return;
            }
            if (view == this.f19465e.f19456c) {
                this.f19465e.w.onBackPressed();
            } else if (view == this.f19465e.f19457d) {
                this.f19465e.w.i();
            } else if (view == this.f19465e.f19458e) {
                this.f19465e.w.g();
            } else if (view == this.f19465e.f19460g) {
                this.f19465e.w.c();
            } else if (view == this.f19465e.f19461h) {
                this.f19465e.w.h();
            } else if (view == this.f19465e.f19464k) {
                this.f19465e.w.e();
            } else if (view == this.f19465e.f19463j) {
                this.f19465e.w.a();
            } else if (view == this.f19465e.o) {
                this.f19465e.w.f();
            } else if (view == this.f19465e.f19459f) {
                this.f19465e.w.d();
            } else if (view == this.f19465e.p) {
                this.f19465e.w.b();
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
        this.v = new a(this);
        this.l = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        n(secretSettingActivity);
    }

    public final void n(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, secretSettingActivity) == null) {
            this.f19455b = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
            this.a = navigationBar;
            this.f19456c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
            this.f19457d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
            this.f19458e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
            this.f19459f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
            this.f19464k = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
            this.f19460g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
            this.f19461h = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_recommend_setting);
            this.f19463j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
            this.f19462i = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
            this.q = (ScrollView) secretSettingActivity.findViewById(R.id.main_scroll);
            this.r = (TextView) secretSettingActivity.findViewById(R.id.secret_im);
            this.s = (TextView) secretSettingActivity.findViewById(R.id.secret_tiezi);
            this.t = (TextView) secretSettingActivity.findViewById(R.id.secret_tiezi_tip);
            this.u = (TextView) secretSettingActivity.findViewById(R.id.secret_ziliao);
            this.f19456c.setOnClickListener(this.v);
            this.f19457d.setOnClickListener(this.v);
            this.f19464k.setOnClickListener(this.v);
            this.f19458e.setOnClickListener(this.v);
            this.f19459f.setOnClickListener(this.v);
            this.f19460g.setOnClickListener(this.v);
            this.f19461h.setOnClickListener(this.v);
            this.f19463j.setOnClickListener(this.v);
            this.m = this.l.findViewById(R.id.privacy_setting_container);
            this.n = this.l.getResources().getStringArray(R.array.privacy_setting_config);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.f19464k.setVisibility(0);
            } else {
                this.f19464k.setVisibility(8);
            }
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
            this.o = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.v);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_forbidden_forum);
            this.p = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.v);
            UserData b2 = c.a.r0.a0.b.a().b();
            if (b2 != null && b2.getBazhuGradeData() != null && !StringUtils.isNull(b2.getBazhuGradeData().getDesc()) && !StringUtils.isNull(b2.getBazhuGradeData().getLevel())) {
                this.f19459f.setVisibility(0);
            } else {
                this.f19459f.setVisibility(8);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19457d.recycle();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.l.getLayoutMode().k(i2 == 1);
            this.l.getLayoutMode().j(this.f19455b);
            this.a.onChangeSkinType(this.l.getPageContext(), i2);
            c.a.r0.s.v.c.d(this.r).v(R.color.CAM_X0108);
            c.a.r0.s.v.c.d(this.s).v(R.color.CAM_X0108);
            c.a.r0.s.v.c.d(this.t).v(R.color.CAM_X0108);
            c.a.r0.s.v.c.d(this.u).v(R.color.CAM_X0108);
            c.a.r0.s.v.c.d(this.q).f(R.color.CAM_X0204);
        }
    }

    public void p(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.w = bVar;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
                this.f19462i.setVisibility(0);
                this.f19463j.setVisibility(0);
                return;
            }
            this.f19462i.setVisibility(8);
            this.f19463j.setVisibility(8);
        }
    }

    public void r(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (i3 == 3 && i2 == 3) {
                this.f19459f.setTip(this.l.getString(R.string.mark_tip_no));
            } else if (i3 == 3) {
                this.f19459f.setTip(this.l.getString(R.string.mark_tip_inside));
            } else if (i2 == 3) {
                this.f19459f.setTip(this.l.getString(R.string.mark_tip_outside));
            } else {
                this.f19459f.setTip(this.l.getString(R.string.mark_tip_all));
            }
        }
    }

    public void s(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            int i3 = i2 - 1;
            String[] strArr = this.n;
            if (strArr == null || i3 >= strArr.length || i3 < 0) {
                return;
            }
            if (TextUtils.equals(str, "like")) {
                this.f19458e.setTip(this.n[i3]);
            } else if (TextUtils.equals(str, "group")) {
                this.f19464k.setTip(this.n[i3]);
            } else if (TextUtils.equals(str, "live")) {
                this.f19460g.setTip(this.n[i3]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i3 == 0) {
                    this.f19463j.setTip(this.l.getString(R.string.all_person));
                } else {
                    this.f19463j.setTip(this.n[i3]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                r(c.a.r0.s.g0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), c.a.r0.s.g0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void t(c.a.s0.m3.b.a.a aVar) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || (strArr = this.n) == null) {
            return;
        }
        int length = strArr.length;
        int d2 = aVar.d() - 1;
        if (d2 < length && d2 >= 0) {
            this.f19464k.setTip(this.n[d2]);
        }
        int c2 = aVar.c() - 1;
        if (c2 < length && c2 >= 0) {
            this.f19458e.setTip(this.n[c2]);
        }
        int e2 = aVar.e() - 1;
        if (e2 < length && e2 >= 0) {
            this.f19460g.setTip(this.n[e2]);
        }
        int g2 = aVar.g() - 1;
        if (g2 < length && g2 >= 0) {
            if (g2 == 0) {
                this.f19463j.setTip(this.l.getString(R.string.all_person));
            } else {
                this.f19463j.setTip(this.n[g2]);
            }
        }
        r(aVar.a(), aVar.b());
    }
}
