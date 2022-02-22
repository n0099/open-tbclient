package c.a.u0.o3.l;

import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.u0.z3.k0.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a extends c.a.d.a.d<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AboutActivity a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f20114b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f20115c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f20116d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20117e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f20118f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20119g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f20120h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f20121i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f20122j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: c.a.u0.o3.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1239a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20124f;

        public View$OnClickListenerC1239a(a aVar, d dVar) {
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
            this.f20124f = aVar;
            this.f20123e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f20124f.f20121i) {
                    UrlManager.getInstance().dealOneLink(this.f20124f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f20124f.f20122j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f20124f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f20124f.k) {
                    if (view != this.f20124f.f20118f) {
                        if (view != this.f20124f.f20120h) {
                            if (view != this.f20124f.f20119g) {
                                if (view == this.f20124f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f20124f.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f20123e.a(4);
                            System.arraycopy(this.f20124f.f20114b, 1, this.f20124f.f20114b, 0, this.f20124f.f20114b.length - 1);
                            this.f20124f.f20114b[this.f20124f.f20114b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f20124f.f20114b[0] >= this.f20124f.f20114b[this.f20124f.f20114b.length - 1] - 2000) {
                                this.f20124f.f20114b = new long[5];
                                this.f20123e.a(6);
                                this.f20124f.r();
                                return;
                            }
                            return;
                        }
                        this.f20123e.a(2);
                        return;
                    }
                    this.f20123e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f20124f.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f20124f.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20126f;

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
            this.f20126f = aVar;
            this.f20125e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f20126f.f20119g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f20125e.a(5);
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
        this.f20114b = new long[5];
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
            View$OnClickListenerC1239a view$OnClickListenerC1239a = new View$OnClickListenerC1239a(this, dVar);
            b bVar = new b(this, dVar);
            this.f20118f.setOnClickListener(view$OnClickListenerC1239a);
            this.f20120h.setOnClickListener(view$OnClickListenerC1239a);
            this.f20121i.setOnClickListener(view$OnClickListenerC1239a);
            this.f20122j.setOnClickListener(view$OnClickListenerC1239a);
            this.k.setOnClickListener(view$OnClickListenerC1239a);
            this.l.setOnClickListener(view$OnClickListenerC1239a);
            this.f20119g.setOnClickListener(view$OnClickListenerC1239a);
            this.f20119g.setOnLongClickListener(bVar);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setContentView(c.a.u0.o3.f.about_activity);
            this.f20116d = (RelativeLayout) this.a.findViewById(c.a.u0.o3.e.parent);
            this.f20119g = (ImageView) this.a.findViewById(c.a.u0.o3.e.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.u0.o3.e.view_navigation_bar);
            this.f20115c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20115c.setTitleText(this.a.getPageContext().getString(c.a.u0.o3.g.version_info));
            this.f20117e = (TextView) this.a.findViewById(c.a.u0.o3.e.text_versioninfo);
            this.f20118f = (SettingTextTestNewView) this.a.findViewById(c.a.u0.o3.e.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.about_guide);
            this.f20120h = tbSettingTextTipView;
            tbSettingTextTipView.hideArrow();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.tieba_protocol_text);
            this.f20121i = tbSettingTextTipView2;
            tbSettingTextTipView2.hideArrow();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.tieba_privacy_text);
            this.f20122j = tbSettingTextTipView3;
            tbSettingTextTipView3.hideArrow();
            this.k = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.k.setText(c.a.u0.o3.g.ybean_use_introduce);
            } else {
                this.k.setText(c.a.u0.o3.g.tdou_use_introduce);
            }
            this.k.hideArrow();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.hideArrow();
            this.n = (ProgressBar) this.a.findViewById(c.a.u0.o3.e.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !m.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            String str = this.a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.a.getPageContext().getString(c.a.u0.o3.g.setting_version_text) + " " + version;
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
                this.f20117e.setText(spannableString);
            } else {
                this.f20117e.setText(str);
            }
            this.m = (TextView) this.a.findViewById(c.a.u0.o3.e.text_version_protoco);
            u(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f20120h.setVisibility(8);
            }
            if (c.a.t0.s.j0.b.k().h("debug_plugin_switcher", false)) {
                t(0);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && c.a.t0.s.e.f()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.a, "ToolsSwitchPage", new HashMap())));
        }
    }

    public void s() {
        SettingTextTestNewView settingTextTestNewView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f20118f) == null) {
            return;
        }
        settingTextTestNewView.refresh();
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.a.findViewById(c.a.u0.o3.e.line0).setVisibility(i2);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f20116d, c.a.u0.o3.b.CAM_X0201);
            this.f20115c.onChangeSkinType(getPageContext(), i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f20116d);
            s();
        }
    }
}
