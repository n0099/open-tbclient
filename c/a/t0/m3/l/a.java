package c.a.t0.m3.l;

import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.setting.more.SettingTextTestNewView;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.kuaishou.weapon.un.x;
/* loaded from: classes7.dex */
public class a extends c.a.d.a.d<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AboutActivity a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f19380b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19381c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f19382d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19383e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f19384f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19385g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f19386h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f19387i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f19388j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: c.a.t0.m3.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1211a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19390f;

        public View$OnClickListenerC1211a(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19390f = aVar;
            this.f19389e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f19390f.f19387i) {
                    UrlManager.getInstance().dealOneLink(this.f19390f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f19390f.f19388j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f19390f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f19390f.k) {
                    if (view != this.f19390f.f19384f) {
                        if (view != this.f19390f.f19386h) {
                            if (view != this.f19390f.f19385g) {
                                if (view == this.f19390f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f19390f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f19389e.a(4);
                            System.arraycopy(this.f19390f.f19380b, 1, this.f19390f.f19380b, 0, this.f19390f.f19380b.length - 1);
                            this.f19390f.f19380b[this.f19390f.f19380b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f19390f.f19380b[0] >= this.f19390f.f19380b[this.f19390f.f19380b.length - 1] - 2000) {
                                this.f19390f.f19380b = new long[5];
                                this.f19389e.a(6);
                                this.f19390f.r();
                                return;
                            }
                            return;
                        }
                        this.f19389e.a(2);
                        return;
                    }
                    this.f19389e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f19390f.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f19390f.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19391e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19392f;

        public b(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19392f = aVar;
            this.f19391e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f19392f.f19385g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f19391e.a(5);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aboutActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19380b = new long[5];
        this.a = aboutActivity;
        q();
        p(dVar);
    }

    public void n() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (progressBar = this.n) == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    public void o() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (progressBar = this.n) == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    public final void p(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            View$OnClickListenerC1211a view$OnClickListenerC1211a = new View$OnClickListenerC1211a(this, dVar);
            b bVar = new b(this, dVar);
            this.f19384f.setOnClickListener(view$OnClickListenerC1211a);
            this.f19386h.setOnClickListener(view$OnClickListenerC1211a);
            this.f19387i.setOnClickListener(view$OnClickListenerC1211a);
            this.f19388j.setOnClickListener(view$OnClickListenerC1211a);
            this.k.setOnClickListener(view$OnClickListenerC1211a);
            this.l.setOnClickListener(view$OnClickListenerC1211a);
            this.f19385g.setOnClickListener(view$OnClickListenerC1211a);
            this.f19385g.setOnLongClickListener(bVar);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setContentView(c.a.t0.m3.f.about_activity);
            this.f19382d = (RelativeLayout) this.a.findViewById(c.a.t0.m3.e.parent);
            this.f19385g = (ImageView) this.a.findViewById(c.a.t0.m3.e.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.t0.m3.e.view_navigation_bar);
            this.f19381c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19381c.setTitleText(this.a.getPageContext().getString(c.a.t0.m3.g.version_info));
            this.f19383e = (TextView) this.a.findViewById(c.a.t0.m3.e.text_versioninfo);
            this.f19384f = (SettingTextTestNewView) this.a.findViewById(c.a.t0.m3.e.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(c.a.t0.m3.e.about_guide);
            this.f19386h = tbSettingTextTipView;
            tbSettingTextTipView.hideArrow();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(c.a.t0.m3.e.tieba_protocol_text);
            this.f19387i = tbSettingTextTipView2;
            tbSettingTextTipView2.hideArrow();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(c.a.t0.m3.e.tieba_privacy_text);
            this.f19388j = tbSettingTextTipView3;
            tbSettingTextTipView3.hideArrow();
            this.k = (TbSettingTextTipView) this.a.findViewById(c.a.t0.m3.e.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.k.setText(c.a.t0.m3.g.ybean_use_introduce);
            } else {
                this.k.setText(c.a.t0.m3.g.tdou_use_introduce);
            }
            this.k.hideArrow();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.a.findViewById(c.a.t0.m3.e.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.hideArrow();
            this.n = (ProgressBar) this.a.findViewById(c.a.t0.m3.e.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !m.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            String str = this.a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.a.getPageContext().getString(c.a.t0.m3.g.setting_version_text) + " " + version;
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("(");
                sb.append(c.a.d.f.p.b.a() ? WebKitFactory.OS_64 : "32");
                sb.append(c.a.d.f.p.b.b() ? "s" : x.o);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                String sb2 = sb.toString();
                SpannableString spannableString = new SpannableString(sb2);
                spannableString.setSpan(new AbsoluteSizeSpan(10, true), sb2.length() - 5, sb2.length(), 33);
                this.f19383e.setText(spannableString);
            } else {
                this.f19383e.setText(str);
            }
            this.m = (TextView) this.a.findViewById(c.a.t0.m3.e.text_version_protoco);
            u(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f19386h.setVisibility(8);
            }
            if (c.a.s0.s.h0.b.k().h("debug_plugin_switcher", false)) {
                t(0);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void s() {
        SettingTextTestNewView settingTextTestNewView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f19384f) == null) {
            return;
        }
        settingTextTestNewView.refresh();
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.a.findViewById(c.a.t0.m3.e.line0).setVisibility(i2);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19382d, c.a.t0.m3.b.CAM_X0201);
            this.f19381c.onChangeSkinType(getPageContext(), i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f19382d);
            s();
        }
    }
}
