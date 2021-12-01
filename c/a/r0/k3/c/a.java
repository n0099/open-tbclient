package c.a.r0.k3.c;

import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.setting.more.SettingTextTestNewView;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends c.a.d.a.d<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AboutActivity a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f18682b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f18683c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f18684d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18685e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f18686f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f18687g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f18688h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f18689i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f18690j;

    /* renamed from: k  reason: collision with root package name */
    public TbSettingTextTipView f18691k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: c.a.r0.k3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1103a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f18693f;

        public View$OnClickListenerC1103a(a aVar, d dVar) {
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
            this.f18693f = aVar;
            this.f18692e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f18693f.f18689i) {
                    UrlManager.getInstance().dealOneLink(this.f18693f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f18693f.f18690j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f18693f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f18693f.f18691k) {
                    if (view != this.f18693f.f18686f) {
                        if (view != this.f18693f.f18688h) {
                            if (view != this.f18693f.f18687g) {
                                if (view == this.f18693f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f18693f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f18692e.a(4);
                            System.arraycopy(this.f18693f.f18682b, 1, this.f18693f.f18682b, 0, this.f18693f.f18682b.length - 1);
                            this.f18693f.f18682b[this.f18693f.f18682b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f18693f.f18682b[0] >= this.f18693f.f18682b[this.f18693f.f18682b.length - 1] - 2000) {
                                this.f18693f.f18682b = new long[5];
                                this.f18692e.a(6);
                                this.f18693f.r();
                                return;
                            }
                            return;
                        }
                        this.f18692e.a(2);
                        return;
                    }
                    this.f18692e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f18693f.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f18693f.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f18695f;

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
            this.f18695f = aVar;
            this.f18694e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f18695f.f18687g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f18694e.a(5);
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
        this.f18682b = new long[5];
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
            View$OnClickListenerC1103a view$OnClickListenerC1103a = new View$OnClickListenerC1103a(this, dVar);
            b bVar = new b(this, dVar);
            this.f18686f.setOnClickListener(view$OnClickListenerC1103a);
            this.f18688h.setOnClickListener(view$OnClickListenerC1103a);
            this.f18689i.setOnClickListener(view$OnClickListenerC1103a);
            this.f18690j.setOnClickListener(view$OnClickListenerC1103a);
            this.f18691k.setOnClickListener(view$OnClickListenerC1103a);
            this.l.setOnClickListener(view$OnClickListenerC1103a);
            this.f18687g.setOnClickListener(view$OnClickListenerC1103a);
            this.f18687g.setOnLongClickListener(bVar);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setContentView(R.layout.about_activity);
            this.f18684d = (RelativeLayout) this.a.findViewById(R.id.parent);
            this.f18687g = (ImageView) this.a.findViewById(R.id.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.f18683c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f18683c.setTitleText(this.a.getPageContext().getString(R.string.version_info));
            this.f18685e = (TextView) this.a.findViewById(R.id.text_versioninfo);
            this.f18686f = (SettingTextTestNewView) this.a.findViewById(R.id.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.about_guide);
            this.f18688h = tbSettingTextTipView;
            tbSettingTextTipView.hideArrow();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.tieba_protocol_text);
            this.f18689i = tbSettingTextTipView2;
            tbSettingTextTipView2.hideArrow();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(R.id.tieba_privacy_text);
            this.f18690j = tbSettingTextTipView3;
            tbSettingTextTipView3.hideArrow();
            this.f18691k = (TbSettingTextTipView) this.a.findViewById(R.id.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.f18691k.setText(R.string.ybean_use_introduce);
            } else {
                this.f18691k.setText(R.string.tdou_use_introduce);
            }
            this.f18691k.hideArrow();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.a.findViewById(R.id.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.hideArrow();
            this.n = (ProgressBar) this.a.findViewById(R.id.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.f18685e.setText(this.a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.a.getPageContext().getString(R.string.setting_version_text) + " " + version);
            this.m = (TextView) this.a.findViewById(R.id.text_version_protoco);
            u(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f18688h.setVisibility(8);
            }
            if (c.a.q0.s.e0.b.j().g("debug_plugin_switcher", false)) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f18686f) == null) {
            return;
        }
        settingTextTestNewView.refresh();
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.a.findViewById(R.id.line0).setVisibility(i2);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f18684d, R.color.CAM_X0201);
            this.f18683c.onChangeSkinType(getPageContext(), i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f18684d);
            s();
        }
    }
}
