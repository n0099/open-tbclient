package c.a.p0.a3.c;

import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.k;
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
/* loaded from: classes3.dex */
public class a extends c.a.e.a.d<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AboutActivity f15191a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f15192b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15193c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f15194d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15195e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f15196f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15197g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f15198h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f15199i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f15200j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: c.a.p0.a3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0719a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15201e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15202f;

        public View$OnClickListenerC0719a(a aVar, d dVar) {
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
            this.f15202f = aVar;
            this.f15201e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15202f.f15199i) {
                    UrlManager.getInstance().dealOneLink(this.f15202f.f15191a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f15202f.f15200j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f15202f.f15191a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f15202f.k) {
                    if (view != this.f15202f.f15196f) {
                        if (view != this.f15202f.f15198h) {
                            if (view != this.f15202f.f15197g) {
                                if (view == this.f15202f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f15202f.f15191a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f15201e.a(4);
                            System.arraycopy(this.f15202f.f15192b, 1, this.f15202f.f15192b, 0, this.f15202f.f15192b.length - 1);
                            this.f15202f.f15192b[this.f15202f.f15192b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f15202f.f15192b[0] >= this.f15202f.f15192b[this.f15202f.f15192b.length - 1] - 2000) {
                                this.f15202f.f15192b = new long[5];
                                this.f15201e.a(6);
                                this.f15202f.r();
                                return;
                            }
                            return;
                        }
                        this.f15201e.a(2);
                        return;
                    }
                    this.f15201e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f15202f.f15191a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f15202f.f15191a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15203e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15204f;

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
            this.f15204f = aVar;
            this.f15203e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f15204f.f15197g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f15203e.a(5);
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15192b = new long[5];
        this.f15191a = aboutActivity;
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
            View$OnClickListenerC0719a view$OnClickListenerC0719a = new View$OnClickListenerC0719a(this, dVar);
            b bVar = new b(this, dVar);
            this.f15196f.setOnClickListener(view$OnClickListenerC0719a);
            this.f15198h.setOnClickListener(view$OnClickListenerC0719a);
            this.f15199i.setOnClickListener(view$OnClickListenerC0719a);
            this.f15200j.setOnClickListener(view$OnClickListenerC0719a);
            this.k.setOnClickListener(view$OnClickListenerC0719a);
            this.l.setOnClickListener(view$OnClickListenerC0719a);
            this.f15197g.setOnClickListener(view$OnClickListenerC0719a);
            this.f15197g.setOnLongClickListener(bVar);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15191a.setContentView(R.layout.about_activity);
            this.f15194d = (RelativeLayout) this.f15191a.findViewById(R.id.parent);
            this.f15197g = (ImageView) this.f15191a.findViewById(R.id.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.f15191a.findViewById(R.id.view_navigation_bar);
            this.f15193c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15193c.setTitleText(this.f15191a.getPageContext().getString(R.string.version_info));
            this.f15195e = (TextView) this.f15191a.findViewById(R.id.text_versioninfo);
            this.f15196f = (SettingTextTestNewView) this.f15191a.findViewById(R.id.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f15191a.findViewById(R.id.about_guide);
            this.f15198h = tbSettingTextTipView;
            tbSettingTextTipView.hideArrow();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f15191a.findViewById(R.id.tieba_protocol_text);
            this.f15199i = tbSettingTextTipView2;
            tbSettingTextTipView2.hideArrow();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f15191a.findViewById(R.id.tieba_privacy_text);
            this.f15200j = tbSettingTextTipView3;
            tbSettingTextTipView3.hideArrow();
            this.k = (TbSettingTextTipView) this.f15191a.findViewById(R.id.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.k.setText(R.string.ybean_use_introduce);
            } else {
                this.k.setText(R.string.tdou_use_introduce);
            }
            this.k.hideArrow();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f15191a.findViewById(R.id.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.hideArrow();
            this.n = (ProgressBar) this.f15191a.findViewById(R.id.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.f15195e.setText(this.f15191a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f15191a.getPageContext().getString(R.string.setting_version_text) + " " + version);
            this.m = (TextView) this.f15191a.findViewById(R.id.text_version_protoco);
            u(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f15198h.setVisibility(8);
            }
            if (c.a.o0.s.d0.b.j().g("debug_plugin_switcher", false)) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f15196f) == null) {
            return;
        }
        settingTextTestNewView.refresh();
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f15191a.findViewById(R.id.line0).setVisibility(i2);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f15194d, R.color.CAM_X0201);
            this.f15193c.onChangeSkinType(getPageContext(), i2);
            this.f15191a.getLayoutMode().k(i2 == 1);
            this.f15191a.getLayoutMode().j(this.f15194d);
            s();
        }
    }
}
