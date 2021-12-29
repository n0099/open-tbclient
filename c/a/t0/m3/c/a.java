package c.a.t0.m3.c;

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
import com.baidu.tieba.R;
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
    public long[] f19897b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19898c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f19899d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19900e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f19901f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19902g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f19903h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f19904i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f19905j;

    /* renamed from: k  reason: collision with root package name */
    public TbSettingTextTipView f19906k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: c.a.t0.m3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1197a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19908f;

        public View$OnClickListenerC1197a(a aVar, d dVar) {
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
            this.f19908f = aVar;
            this.f19907e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f19908f.f19904i) {
                    UrlManager.getInstance().dealOneLink(this.f19908f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f19908f.f19905j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f19908f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f19908f.f19906k) {
                    if (view != this.f19908f.f19901f) {
                        if (view != this.f19908f.f19903h) {
                            if (view != this.f19908f.f19902g) {
                                if (view == this.f19908f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f19908f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f19907e.a(4);
                            System.arraycopy(this.f19908f.f19897b, 1, this.f19908f.f19897b, 0, this.f19908f.f19897b.length - 1);
                            this.f19908f.f19897b[this.f19908f.f19897b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f19908f.f19897b[0] >= this.f19908f.f19897b[this.f19908f.f19897b.length - 1] - 2000) {
                                this.f19908f.f19897b = new long[5];
                                this.f19907e.a(6);
                                this.f19908f.r();
                                return;
                            }
                            return;
                        }
                        this.f19907e.a(2);
                        return;
                    }
                    this.f19907e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f19908f.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f19908f.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19909e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19910f;

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
            this.f19910f = aVar;
            this.f19909e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f19910f.f19902g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f19909e.a(5);
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
        this.f19897b = new long[5];
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
            View$OnClickListenerC1197a view$OnClickListenerC1197a = new View$OnClickListenerC1197a(this, dVar);
            b bVar = new b(this, dVar);
            this.f19901f.setOnClickListener(view$OnClickListenerC1197a);
            this.f19903h.setOnClickListener(view$OnClickListenerC1197a);
            this.f19904i.setOnClickListener(view$OnClickListenerC1197a);
            this.f19905j.setOnClickListener(view$OnClickListenerC1197a);
            this.f19906k.setOnClickListener(view$OnClickListenerC1197a);
            this.l.setOnClickListener(view$OnClickListenerC1197a);
            this.f19902g.setOnClickListener(view$OnClickListenerC1197a);
            this.f19902g.setOnLongClickListener(bVar);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setContentView(R.layout.about_activity);
            this.f19899d = (RelativeLayout) this.a.findViewById(R.id.parent);
            this.f19902g = (ImageView) this.a.findViewById(R.id.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.f19898c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19898c.setTitleText(this.a.getPageContext().getString(R.string.version_info));
            this.f19900e = (TextView) this.a.findViewById(R.id.text_versioninfo);
            this.f19901f = (SettingTextTestNewView) this.a.findViewById(R.id.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.about_guide);
            this.f19903h = tbSettingTextTipView;
            tbSettingTextTipView.hideArrow();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.tieba_protocol_text);
            this.f19904i = tbSettingTextTipView2;
            tbSettingTextTipView2.hideArrow();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(R.id.tieba_privacy_text);
            this.f19905j = tbSettingTextTipView3;
            tbSettingTextTipView3.hideArrow();
            this.f19906k = (TbSettingTextTipView) this.a.findViewById(R.id.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.f19906k.setText(R.string.ybean_use_introduce);
            } else {
                this.f19906k.setText(R.string.tdou_use_introduce);
            }
            this.f19906k.hideArrow();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.a.findViewById(R.id.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.hideArrow();
            this.n = (ProgressBar) this.a.findViewById(R.id.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !m.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            String str = this.a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.a.getPageContext().getString(R.string.setting_version_text) + " " + version;
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
                this.f19900e.setText(spannableString);
            } else {
                this.f19900e.setText(str);
            }
            this.m = (TextView) this.a.findViewById(R.id.text_version_protoco);
            u(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f19903h.setVisibility(8);
            }
            if (c.a.s0.s.g0.b.j().g("debug_plugin_switcher", false)) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f19901f) == null) {
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
            SkinManager.setBackgroundColor(this.f19899d, R.color.CAM_X0201);
            this.f19898c.onChangeSkinType(getPageContext(), i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f19899d);
            s();
        }
    }
}
