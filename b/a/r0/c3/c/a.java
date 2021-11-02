package b.a.r0.c3.c;

import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.k;
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
/* loaded from: classes4.dex */
public class a extends b.a.e.a.d<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AboutActivity f15211a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f15212b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15213c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f15214d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15215e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f15216f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15217g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f15218h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f15219i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: b.a.r0.c3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0766a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15221f;

        public View$OnClickListenerC0766a(a aVar, d dVar) {
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
            this.f15221f = aVar;
            this.f15220e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15221f.f15219i) {
                    UrlManager.getInstance().dealOneLink(this.f15221f.f15211a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f15221f.j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f15221f.f15211a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f15221f.k) {
                    if (view != this.f15221f.f15216f) {
                        if (view != this.f15221f.f15218h) {
                            if (view != this.f15221f.f15217g) {
                                if (view == this.f15221f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f15221f.f15211a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f15220e.a(4);
                            System.arraycopy(this.f15221f.f15212b, 1, this.f15221f.f15212b, 0, this.f15221f.f15212b.length - 1);
                            this.f15221f.f15212b[this.f15221f.f15212b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f15221f.f15212b[0] >= this.f15221f.f15212b[this.f15221f.f15212b.length - 1] - 2000) {
                                this.f15221f.f15212b = new long[5];
                                this.f15220e.a(6);
                                this.f15221f.r();
                                return;
                            }
                            return;
                        }
                        this.f15220e.a(2);
                        return;
                    }
                    this.f15220e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f15221f.f15211a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f15221f.f15211a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15223f;

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
            this.f15223f = aVar;
            this.f15222e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f15223f.f15217g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f15222e.a(5);
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15212b = new long[5];
        this.f15211a = aboutActivity;
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
            View$OnClickListenerC0766a view$OnClickListenerC0766a = new View$OnClickListenerC0766a(this, dVar);
            b bVar = new b(this, dVar);
            this.f15216f.setOnClickListener(view$OnClickListenerC0766a);
            this.f15218h.setOnClickListener(view$OnClickListenerC0766a);
            this.f15219i.setOnClickListener(view$OnClickListenerC0766a);
            this.j.setOnClickListener(view$OnClickListenerC0766a);
            this.k.setOnClickListener(view$OnClickListenerC0766a);
            this.l.setOnClickListener(view$OnClickListenerC0766a);
            this.f15217g.setOnClickListener(view$OnClickListenerC0766a);
            this.f15217g.setOnLongClickListener(bVar);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15211a.setContentView(R.layout.about_activity);
            this.f15214d = (RelativeLayout) this.f15211a.findViewById(R.id.parent);
            this.f15217g = (ImageView) this.f15211a.findViewById(R.id.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.f15211a.findViewById(R.id.view_navigation_bar);
            this.f15213c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15213c.setTitleText(this.f15211a.getPageContext().getString(R.string.version_info));
            this.f15215e = (TextView) this.f15211a.findViewById(R.id.text_versioninfo);
            this.f15216f = (SettingTextTestNewView) this.f15211a.findViewById(R.id.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f15211a.findViewById(R.id.about_guide);
            this.f15218h = tbSettingTextTipView;
            tbSettingTextTipView.hideArrow();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f15211a.findViewById(R.id.tieba_protocol_text);
            this.f15219i = tbSettingTextTipView2;
            tbSettingTextTipView2.hideArrow();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f15211a.findViewById(R.id.tieba_privacy_text);
            this.j = tbSettingTextTipView3;
            tbSettingTextTipView3.hideArrow();
            this.k = (TbSettingTextTipView) this.f15211a.findViewById(R.id.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.k.setText(R.string.ybean_use_introduce);
            } else {
                this.k.setText(R.string.tdou_use_introduce);
            }
            this.k.hideArrow();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f15211a.findViewById(R.id.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.hideArrow();
            this.n = (ProgressBar) this.f15211a.findViewById(R.id.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.f15215e.setText(this.f15211a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f15211a.getPageContext().getString(R.string.setting_version_text) + " " + version);
            this.m = (TextView) this.f15211a.findViewById(R.id.text_version_protoco);
            u(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f15218h.setVisibility(8);
            }
            if (b.a.q0.s.e0.b.j().g("debug_plugin_switcher", false)) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f15216f) == null) {
            return;
        }
        settingTextTestNewView.refresh();
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f15211a.findViewById(R.id.line0).setVisibility(i2);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f15214d, R.color.CAM_X0201);
            this.f15213c.onChangeSkinType(getPageContext(), i2);
            this.f15211a.getLayoutMode().k(i2 == 1);
            this.f15211a.getLayoutMode().j(this.f15214d);
            s();
        }
    }
}
