package b.a.q0.m;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.m.g;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.r0.c4.a;
import b.a.r0.f0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonInfoMoreDialog;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseWebViewActivity f12722a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f12723b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f12724c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f12725d;

    /* renamed from: e  reason: collision with root package name */
    public View f12726e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f12727f;

    /* renamed from: g  reason: collision with root package name */
    public View f12728g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f12729h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f12730i;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public ContinuousAnimationView m;
    public NoDataView n;
    public View.OnClickListener o;
    public View p;
    public MorePopupWindow q;
    public View r;
    public View s;
    public View t;
    public boolean u;
    public boolean v;
    public PersonInfoMoreDialog w;
    public boolean x;
    public View y;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f12731e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12731e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12731e.f12722a == null) {
                return;
            }
            if (((this.f12731e.f12722a instanceof TbWebViewActivity) && ((TbWebViewActivity) this.f12731e.f12722a).isDisableGoBack && ((TbWebViewActivity) this.f12731e.f12722a).needDealClickGoBack()) || this.f12731e.f12722a.webViewGoBack()) {
                return;
            }
            this.f12731e.f12722a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f12732e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12732e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12732e.f12722a == null) {
                return;
            }
            this.f12732e.f12722a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f12733e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12733e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f12733e.f()) {
                    this.f12733e.D();
                } else if (this.f12733e.j.getVisibility() == 0) {
                } else {
                    this.f12733e.G();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12734a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12734a = eVar;
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12734a.G();
            }
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: b.a.q0.m.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0670e implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12735a;

        public C0670e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12735a = eVar;
        }

        @Override // b.a.r0.c4.a.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12735a.w == null || this.f12735a.f12722a == null) {
                return;
            }
            this.f12735a.w.dismiss();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f12735a.f12722a).createNormalCfg(this.f12735a.f12722a.getResources().getString(R.string.user_feedback), null);
            createNormalCfg.setCallFrom(12);
            this.f12735a.f12722a.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12736a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12736a = eVar;
        }

        @Override // b.a.r0.c4.a.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12736a.w == null) {
                return;
            }
            this.f12736a.w.dismiss();
        }
    }

    public e(BaseWebViewActivity baseWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12723b = null;
        this.m = null;
        this.u = true;
        this.v = false;
        this.x = false;
        this.f12722a = baseWebViewActivity;
        k();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            NavigationBar navigationBar = this.f12724c;
            if (navigationBar == null || this.f12730i == null || this.j == null) {
                return;
            }
            navigationBar.setBackgroundDrawable(null);
            this.f12724c.setBackgroundColor(R.color.transparent);
            this.f12724c.setBackgroundResource(R.drawable.transparent_bg);
            this.f12730i.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setOnClickListener(this.f12722a);
            this.f12725d.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = l.g(this.f12722a, R.dimen.tbds100);
            layoutParams.height = l.g(this.f12722a, R.dimen.tbds100);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12729h, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12727f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.u = z;
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.w == null) {
                b.a.r0.c4.a aVar = new b.a.r0.c4.a(this.f12722a);
                ArrayList arrayList = new ArrayList();
                a.b bVar = new a.b(this.f12722a.getString(R.string.report_text), aVar);
                bVar.h(new C0670e(this));
                arrayList.add(bVar);
                aVar.g(new f(this));
                aVar.f(arrayList);
                PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(this.f12722a, aVar.b());
                this.w = personInfoMoreDialog;
                personInfoMoreDialog.setWindowDimAmount(0.7f);
            }
            this.w.show();
        }
    }

    public void E() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (navigationBar = this.f12724c) == null || navigationBar.getVisibility() != 0 || (imageView = this.f12729h) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.n == null) {
                this.n = NoDataViewFactory.a(this.f12722a.getPageContext().getPageActivity(), this.f12723b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.e.d(null, this.f12722a.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f12722a.getResources().getString(R.string.refresh), this.o)));
            }
            if (!j.A()) {
                this.n.resetImageOptipn(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, a2), this.f12722a.getPageContext());
            } else {
                this.n.resetImageOptipn(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), this.f12722a.getPageContext());
            }
            this.k.setVisibility(8);
            this.n.setVisibility(0);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q.showWindowInRightBottomOfHost();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.m.setVisibility(0);
            this.m.playAnimation();
        }
    }

    public void I(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem) == null) || shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.f12722a.getPageContext().getPageActivity(), "share", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        if (shareItem.m) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f12722a, shareItem, true, (SparseArray<String>) null);
            shareDialogConfig.mShowMoreForumShare = true;
            h.c().l(shareDialogConfig);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.f12722a, shareItem, true, g())));
    }

    public void J(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, str) == null) {
            new BdTopToast(this.f12722a).setIcon(z).setContent(str).show(this.f12723b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g.d(this.q, this.f12722a.getPageContext().getPageActivity());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public final SparseArray<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sparseArray.put(2, "pb_wx_timeline");
            sparseArray.put(3, "pb_wx_friend");
            sparseArray.put(4, "pb_qq_zone");
            sparseArray.put(5, "pb_tencent_weibo");
            sparseArray.put(6, "pb_sina_weibo");
            sparseArray.put(7, "pb_renren");
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.l.setVisibility(8);
        }
    }

    public void i() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (noDataView = this.n) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m.setVisibility(8);
            this.m.cancelAnimation();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f12722a.setContentView(R.layout.base_webview_activity_new);
            this.f12723b = (ViewGroup) this.f12722a.findViewById(R.id.root_view);
            this.f12724c = (NavigationBar) this.f12722a.findViewById(R.id.view_navigation_bar);
            this.y = this.f12722a.findViewById(R.id.night_mode_overlay);
            this.f12724c.showBottomLine();
            w("");
            if (this.f12722a.isTranslucent()) {
                SkinManager.setBackgroundColor(this.f12723b, this.f12722a.getResources().getColor(R.color.black_alpha0));
                this.f12723b.setOnClickListener(this.f12722a);
                this.f12724c.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.f12722a.findViewById(R.id.webview_container);
            this.k = linearLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.k.setLayoutParams(layoutParams);
            this.l = (TextView) this.f12722a.findViewById(R.id.webview_crash_tip);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.f12722a.findViewById(R.id.webview_progress);
            this.m = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
            View addCustomView = this.f12724c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new a(this));
            this.f12726e = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
            this.f12727f = imageView;
            imageView.setContentDescription(this.f12722a.getResources().getString(R.string.back));
            View addCustomView2 = this.f12724c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new b(this));
            this.f12728g = addCustomView2;
            ImageView imageView2 = (ImageView) addCustomView2.findViewById(R.id.widget_navi_back_button);
            this.f12729h = imageView2;
            imageView2.setContentDescription(this.f12722a.getResources().getString(R.string.close));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f12729h.getLayoutParams();
            layoutParams2.leftMargin = l.g(this.f12722a.getPageContext().getPageActivity(), R.dimen.ds4);
            this.f12729h.setLayoutParams(layoutParams2);
            View addCustomView3 = this.f12724c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new c(this));
            this.p = addCustomView3;
            this.f12730i = (ImageView) addCustomView3.findViewById(R.id.widget_navi_more_button);
            this.j = (ImageView) this.p.findViewById(R.id.widget_navi_share_button);
            View inflate = LayoutInflater.from(this.f12722a.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
            this.q = new MorePopupWindow(this.f12722a.getPageContext().getPageActivity(), inflate, this.f12724c, this.f12722a.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new d(this));
            View findViewById = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
            this.r = findViewById;
            findViewById.setOnClickListener(this.f12722a);
            if (b.a.q0.t.g.g.e(this.f12722a.getPageContext().getPageActivity())) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            this.q.refresh();
            View findViewById2 = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
            this.t = findViewById2;
            findViewById2.setOnClickListener(this.f12722a);
            View findViewById3 = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
            this.s = findViewById3;
            findViewById3.setOnClickListener(this.f12722a);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            try {
                this.k.addView(this.f12722a.createWebView());
                this.l.setVisibility(8);
                if (this.u) {
                    return true;
                }
                this.f12724c.setStatusBarVisibility(8);
                return true;
            } catch (Exception e2) {
                this.l.setVisibility(0);
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            NavigationBar navigationBar = this.f12724c;
            return navigationBar != null && navigationBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            ContinuousAnimationView continuousAnimationView = this.m;
            if (continuousAnimationView != null) {
                SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
            }
            MorePopupWindow morePopupWindow = this.q;
            if (morePopupWindow != null) {
                morePopupWindow.onChangeSkinType(this.f12722a, i2, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f12722a.getPageContext(), i2);
            }
            if (this.x) {
                if (i2 == 1) {
                    this.y.setVisibility(0);
                    return;
                }
                return;
            }
            NavigationBar navigationBar = this.f12724c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f12722a.getPageContext(), i2);
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12727f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12729h, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f12730i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.f12724c;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MorePopupWindow morePopupWindow = this.q;
            if (morePopupWindow != null) {
                g.d(morePopupWindow, this.f12722a.getPageContext().getPageActivity());
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.k.setLayoutParams(layoutParams);
            ImageView imageView = this.f12727f;
            if (imageView != null) {
                imageView.setBackgroundDrawable(null);
            }
            ImageView imageView2 = this.f12729h;
            if (imageView2 != null) {
                imageView2.setBackgroundDrawable(null);
            }
            ImageView imageView3 = this.f12730i;
            if (imageView3 != null) {
                imageView3.setBackgroundDrawable(null);
            }
            ImageView imageView4 = this.j;
            if (imageView4 != null) {
                imageView4.setBackgroundDrawable(null);
            }
            NavigationBar navigationBar = this.f12724c;
            if (navigationBar != null) {
                navigationBar.showBottomLine(true);
            }
            BaseWebViewActivity baseWebViewActivity = this.f12722a;
            if (baseWebViewActivity != null) {
                baseWebViewActivity.getWindow().clearFlags(1024);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.height = -1;
            this.k.setLayoutParams(layoutParams);
            NavigationBar navigationBar = this.f12724c;
            if (navigationBar != null) {
                navigationBar.getBackground().mutate().setAlpha(0);
                this.f12724c.showBottomLine(false);
            }
            SkinManager.setBackgroundResource(this.f12727f, R.drawable.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.f12729h, R.drawable.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.f12730i, R.drawable.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.j, R.drawable.frs_star_navigation_bg);
            w("");
            this.f12722a.getWindow().setFlags(1024, 1024);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.v = z;
        }
    }

    public void s(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (view = this.p) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                this.k.getLayoutParams().height = -1;
                this.f12724c.setVisibility(0);
                return;
            }
            this.k.getLayoutParams().height = -1;
            this.f12724c.setVisibility(8);
        }
    }

    public void u(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.f12724c == null || (imageView = this.f12730i) == null) {
            return;
        }
        imageView.setVisibility(i2);
    }

    public void v() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.f12724c == null || (imageView = this.f12730i) == null || this.j == null) {
            return;
        }
        imageView.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setOnClickListener(this.f12722a);
    }

    public void w(String str) {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (navigationBar = this.f12724c) == null) {
            return;
        }
        this.f12725d = navigationBar.setCenterTextTitle(str);
        ImageView imageView2 = this.f12727f;
        if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.f12729h) != null && imageView.getVisibility() == 0) {
            this.f12725d.setMaxWidth(l.g(this.f12722a.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        if (!this.x) {
            SkinManager.setNavbarTitleColor(this.f12725d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            this.f12725d.setTextColor(-1);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void y(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (view = this.r) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
            s(true);
        } else {
            view.setVisibility(8);
            s(false);
        }
        this.q.refresh();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.x = true;
            A();
        }
    }
}
