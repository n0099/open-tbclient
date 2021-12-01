package c.a.r0.k3.b.a;

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
/* loaded from: classes6.dex */
public class c extends d<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f18671b;

    /* renamed from: c  reason: collision with root package name */
    public View f18672c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f18673d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f18674e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f18675f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f18676g;

    /* renamed from: h  reason: collision with root package name */
    public View f18677h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f18678i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f18679j;

    /* renamed from: k  reason: collision with root package name */
    public SecretSettingActivity f18680k;
    public View l;
    public String[] m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public ScrollView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public View.OnClickListener u;
    public b v;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18681e;

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
            this.f18681e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18681e.v == null) {
                return;
            }
            if (view == this.f18681e.f18672c) {
                this.f18681e.v.onBackPressed();
            } else if (view == this.f18681e.f18673d) {
                this.f18681e.v.h();
            } else if (view == this.f18681e.f18674e) {
                this.f18681e.v.g();
            } else if (view == this.f18681e.f18676g) {
                this.f18681e.v.c();
            } else if (view == this.f18681e.f18679j) {
                this.f18681e.v.e();
            } else if (view == this.f18681e.f18678i) {
                this.f18681e.v.a();
            } else if (view == this.f18681e.n) {
                this.f18681e.v.f();
            } else if (view == this.f18681e.f18675f) {
                this.f18681e.v.d();
            } else if (view == this.f18681e.o) {
                this.f18681e.v.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

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
        this.u = new a(this);
        this.f18680k = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        m(secretSettingActivity);
    }

    public final void m(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, secretSettingActivity) == null) {
            this.f18671b = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
            this.a = navigationBar;
            this.f18672c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
            this.f18673d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
            this.f18674e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
            this.f18675f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
            this.f18679j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
            this.f18676g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
            this.f18678i = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
            this.f18677h = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
            this.p = (ScrollView) secretSettingActivity.findViewById(R.id.main_scroll);
            this.q = (TextView) secretSettingActivity.findViewById(R.id.secret_im);
            this.r = (TextView) secretSettingActivity.findViewById(R.id.secret_tiezi);
            this.s = (TextView) secretSettingActivity.findViewById(R.id.secret_tiezi_tip);
            this.t = (TextView) secretSettingActivity.findViewById(R.id.secret_ziliao);
            this.f18672c.setOnClickListener(this.u);
            this.f18673d.setOnClickListener(this.u);
            this.f18679j.setOnClickListener(this.u);
            this.f18674e.setOnClickListener(this.u);
            this.f18675f.setOnClickListener(this.u);
            this.f18676g.setOnClickListener(this.u);
            this.f18678i.setOnClickListener(this.u);
            this.l = this.f18680k.findViewById(R.id.privacy_setting_container);
            this.m = this.f18680k.getResources().getStringArray(R.array.privacy_setting_config);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.f18679j.setVisibility(0);
            } else {
                this.f18679j.setVisibility(8);
            }
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
            this.n = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.u);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_forbidden_forum);
            this.o = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.u);
            UserData b2 = c.a.q0.a0.b.a().b();
            if (b2 != null && b2.getBazhuGradeData() != null && !StringUtils.isNull(b2.getBazhuGradeData().getDesc()) && !StringUtils.isNull(b2.getBazhuGradeData().getLevel())) {
                this.f18675f.setVisibility(0);
            } else {
                this.f18675f.setVisibility(8);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18673d.recycle();
        }
    }

    public void o(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.v = bVar;
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f18680k.getLayoutMode().k(i2 == 1);
            this.f18680k.getLayoutMode().j(this.f18671b);
            this.a.onChangeSkinType(this.f18680k.getPageContext(), i2);
            c.a.q0.s.u.c.d(this.q).v(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.r).v(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.s).v(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.t).v(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.p).f(R.color.CAM_X0204);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
            if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
                this.f18677h.setVisibility(0);
                this.f18678i.setVisibility(0);
                return;
            }
            this.f18677h.setVisibility(8);
            this.f18678i.setVisibility(8);
        }
    }

    public void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (i3 == 3 && i2 == 3) {
                this.f18675f.setTip(this.f18680k.getString(R.string.mark_tip_no));
            } else if (i3 == 3) {
                this.f18675f.setTip(this.f18680k.getString(R.string.mark_tip_inside));
            } else if (i2 == 3) {
                this.f18675f.setTip(this.f18680k.getString(R.string.mark_tip_outside));
            } else {
                this.f18675f.setTip(this.f18680k.getString(R.string.mark_tip_all));
            }
        }
    }

    public void r(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            int i3 = i2 - 1;
            String[] strArr = this.m;
            if (strArr == null || i3 >= strArr.length || i3 < 0) {
                return;
            }
            if (TextUtils.equals(str, "like")) {
                this.f18674e.setTip(this.m[i3]);
            } else if (TextUtils.equals(str, "group")) {
                this.f18679j.setTip(this.m[i3]);
            } else if (TextUtils.equals(str, "live")) {
                this.f18676g.setTip(this.m[i3]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i3 == 0) {
                    this.f18678i.setTip(this.f18680k.getString(R.string.all_person));
                } else {
                    this.f18678i.setTip(this.m[i3]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                q(c.a.q0.s.e0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), c.a.q0.s.e0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void s(c.a.r0.k3.b.a.a aVar) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || (strArr = this.m) == null) {
            return;
        }
        int length = strArr.length;
        int d2 = aVar.d() - 1;
        if (d2 < length && d2 >= 0) {
            this.f18679j.setTip(this.m[d2]);
        }
        int c2 = aVar.c() - 1;
        if (c2 < length && c2 >= 0) {
            this.f18674e.setTip(this.m[c2]);
        }
        int e2 = aVar.e() - 1;
        if (e2 < length && e2 >= 0) {
            this.f18676g.setTip(this.m[e2]);
        }
        int g2 = aVar.g() - 1;
        if (g2 < length && g2 >= 0) {
            if (g2 == 0) {
                this.f18678i.setTip(this.f18680k.getString(R.string.all_person));
            } else {
                this.f18678i.setTip(this.m[g2]);
            }
        }
        q(aVar.a(), aVar.b());
    }
}
