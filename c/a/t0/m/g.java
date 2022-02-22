package c.a.t0.m;

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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.u0.a4.i;
import c.a.u0.a4.j;
import c.a.u0.q4.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.person.PersonInfoMoreDialog;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseWebViewActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f13297b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f13298c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13299d;

    /* renamed from: e  reason: collision with root package name */
    public View f13300e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13301f;

    /* renamed from: g  reason: collision with root package name */
    public View f13302g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f13303h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f13304i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f13305j;
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
    public c.a.t0.m.d z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f13306e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13306e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13306e.a == null) {
                return;
            }
            if (((this.f13306e.a instanceof TbWebViewActivity) && ((TbWebViewActivity) this.f13306e.a).isDisableGoBack && ((TbWebViewActivity) this.f13306e.a).needDealClickGoBack()) || this.f13306e.a.webViewGoBack()) {
                return;
            }
            this.f13306e.a.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f13307e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13307e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13307e.a == null) {
                return;
            }
            this.f13307e.a.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f13308e;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13308e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f13308e.f()) {
                    this.f13308e.G();
                } else if (this.f13308e.f13305j.getVisibility() == 0) {
                } else {
                    this.f13308e.J();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J();
            }
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.u0.q4.a.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w == null || this.a.a == null) {
                return;
            }
            this.a.w.dismiss();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.a).createNormalCfg(this.a.a.getResources().getString(j.user_feedback), null);
            createNormalCfg.setCallFrom(12);
            this.a.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes6.dex */
    public class f implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.u0.q4.a.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w == null) {
                return;
            }
            this.a.w.dismiss();
        }
    }

    public g(BaseWebViewActivity baseWebViewActivity) {
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
        this.f13297b = null;
        this.m = null;
        this.u = true;
        this.v = false;
        this.x = false;
        this.a = baseWebViewActivity;
        l();
    }

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void B(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (view = this.r) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
            v(true);
        } else {
            view.setVisibility(8);
            v(false);
        }
        this.q.refresh();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.x = true;
            D();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            NavigationBar navigationBar = this.f13298c;
            if (navigationBar == null || this.f13304i == null || this.f13305j == null) {
                return;
            }
            navigationBar.setBackgroundDrawable(null);
            this.f13298c.setBackgroundColor(c.a.u0.a4.d.transparent);
            this.f13298c.setBackgroundResource(c.a.u0.a4.f.transparent_bg);
            this.f13304i.setVisibility(8);
            this.f13305j.setVisibility(0);
            this.f13305j.setOnClickListener(this.a);
            this.f13299d.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13305j.getLayoutParams();
            layoutParams.width = n.f(this.a, c.a.u0.a4.e.tbds100);
            layoutParams.height = n.f(this.a, c.a.u0.a4.e.tbds100);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13303h, c.a.u0.a4.f.icon_pure_topbar_close44_svg, c.a.u0.a4.d.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13301f, c.a.u0.a4.f.ic_icon_pure_topbar_return40_svg, c.a.u0.a4.d.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13305j, c.a.u0.a4.f.icon_pure_topbar_share44_svg, c.a.u0.a4.d.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.u = z;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.w == null) {
                c.a.u0.q4.a aVar = new c.a.u0.q4.a(this.a);
                ArrayList arrayList = new ArrayList();
                a.b bVar = new a.b(this.a.getString(j.report_text), aVar);
                bVar.h(new e(this));
                arrayList.add(bVar);
                aVar.g(new f(this));
                aVar.f(arrayList);
                PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(this.a, aVar.b());
                this.w = personInfoMoreDialog;
                personInfoMoreDialog.setWindowDimAmount(0.7f);
            }
            this.w.show();
        }
    }

    public void H() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (navigationBar = this.f13298c) == null || navigationBar.getVisibility() != 0 || (imageView = this.f13303h) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.n == null) {
                this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f13297b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.e.d(null, this.a.getPageContext().getString(j.url_not_found)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(j.refresh), this.o)));
            }
            if (!l.A()) {
                this.n.resetImageOptipn(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, a2), this.a.getPageContext());
            } else {
                this.n.resetImageOptipn(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), this.a.getPageContext());
            }
            this.k.setVisibility(8);
            this.n.setVisibility(0);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.q.showWindowInRightBottomOfHost();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.m.setVisibility(0);
            this.m.playAnimation();
        }
    }

    public void L(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, shareItem) == null) || shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        if (shareItem.m) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a, shareItem, true, (SparseArray<String>) null);
            shareDialogConfig.mShowMoreForumShare = true;
            c.a.u0.k0.h.c().l(shareDialogConfig);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.a, shareItem, true, g())));
    }

    public void M(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, str) == null) {
            new BdTopToast(this.a).setIcon(z).setContent(str).show(this.f13297b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.d.f.m.g.d(this.q, this.a.getPageContext().getPageActivity());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public final SparseArray<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.l.setVisibility(8);
        }
    }

    public void i() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (noDataView = this.n) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.m.setVisibility(8);
            this.m.cancelAnimation();
        }
    }

    public void k(String str) {
        c.a.t0.m.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (dVar = this.z) == null) {
            return;
        }
        dVar.e(str);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.setContentView(c.a.u0.a4.h.base_webview_activity_new);
            this.f13297b = (ViewGroup) this.a.findViewById(c.a.u0.a4.g.root_view);
            this.f13298c = (NavigationBar) this.a.findViewById(c.a.u0.a4.g.view_navigation_bar);
            this.y = this.a.findViewById(c.a.u0.a4.g.night_mode_overlay);
            this.f13298c.showBottomLine();
            z("");
            if (this.a.isTranslucent()) {
                SkinManager.setBackgroundColor(this.f13297b, this.a.getResources().getColor(c.a.u0.a4.d.black_alpha0));
                this.f13297b.setOnClickListener(this.a);
                this.f13298c.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.a.findViewById(c.a.u0.a4.g.webview_container);
            this.k = linearLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.addRule(3, c.a.u0.a4.g.view_navigation_bar);
            this.k.setLayoutParams(layoutParams);
            this.l = (TextView) this.a.findViewById(c.a.u0.a4.g.webview_crash_tip);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.a.findViewById(c.a.u0.a4.g.webview_progress);
            this.m = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, i.lottie_full_screen_refresh);
            View addCustomView = this.f13298c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, c.a.u0.a4.h.widget_nb_item_back, new a(this));
            this.f13300e = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(c.a.u0.a4.g.widget_navi_back_button);
            this.f13301f = imageView;
            imageView.setContentDescription(this.a.getResources().getString(j.back));
            View addCustomView2 = this.f13298c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, c.a.u0.a4.h.widget_nb_item_finish, new b(this));
            this.f13302g = addCustomView2;
            ImageView imageView2 = (ImageView) addCustomView2.findViewById(c.a.u0.a4.g.widget_navi_back_button);
            this.f13303h = imageView2;
            imageView2.setContentDescription(this.a.getResources().getString(j.close));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f13303h.getLayoutParams();
            layoutParams2.leftMargin = n.f(this.a.getPageContext().getPageActivity(), c.a.u0.a4.e.ds4);
            this.f13303h.setLayoutParams(layoutParams2);
            View addCustomView3 = this.f13298c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, c.a.u0.a4.h.widget_nb_item_more, new c(this));
            this.p = addCustomView3;
            this.f13304i = (ImageView) addCustomView3.findViewById(c.a.u0.a4.g.widget_navi_more_button);
            this.f13305j = (ImageView) this.p.findViewById(c.a.u0.a4.g.widget_navi_share_button);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(c.a.u0.a4.h.tb_webview_pop_more, (ViewGroup) null);
            this.q = new MorePopupWindow(this.a.getPageContext().getPageActivity(), inflate, this.f13298c, this.a.getPageContext().getResources().getDrawable(c.a.u0.a4.f.bg_pull_down_right_n), new d(this));
            View findViewById = inflate.findViewById(c.a.u0.a4.g.webview_more_pop_item_share_friend_layout);
            this.r = findViewById;
            findViewById.setOnClickListener(this.a);
            if (c.a.t0.t.g.g.f(this.a.getPageContext().getPageActivity())) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            this.q.refresh();
            View findViewById2 = inflate.findViewById(c.a.u0.a4.g.webview_more_pop_item_open_browser_layout);
            this.t = findViewById2;
            findViewById2.setOnClickListener(this.a);
            View findViewById3 = inflate.findViewById(c.a.u0.a4.g.webview_more_pop_item_copy_link_layout);
            this.s = findViewById3;
            findViewById3.setOnClickListener(this.a);
            c.a.t0.m.d dVar = new c.a.t0.m.d(this.f13298c, this.k);
            this.z = dVar;
            dVar.a(new c.a.t0.m.c(this.f13301f, c.a.u0.a4.f.ic_icon_pure_topbar_return40_svg), new c.a.t0.m.c(this.f13303h, c.a.u0.a4.f.icon_pure_topbar_close44_svg), new c.a.t0.m.c(this.f13304i, c.a.u0.a4.f.icon_pure_topbar_more44_svg), new c.a.t0.m.c(this.f13305j, c.a.u0.a4.f.icon_pure_topbar_share44_svg), new c.a.t0.m.c(this.f13298c.getCenterText(), 0));
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            try {
                this.k.addView(this.a.createWebView());
                this.l.setVisibility(8);
                if (this.u) {
                    return true;
                }
                this.f13298c.setStatusBarVisibility(8);
                return true;
            } catch (Exception e2) {
                this.l.setVisibility(0);
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            NavigationBar navigationBar = this.f13298c;
            return navigationBar != null && navigationBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            ContinuousAnimationView continuousAnimationView = this.m;
            if (continuousAnimationView != null) {
                SkinManager.setLottieAnimation(continuousAnimationView, i.lottie_full_screen_refresh);
            }
            MorePopupWindow morePopupWindow = this.q;
            if (morePopupWindow != null) {
                morePopupWindow.onChangeSkinType(this.a, i2, SkinManager.getDrawable(c.a.u0.a4.f.bg_pull_down_right_n));
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.a.getPageContext(), i2);
            }
            if (!this.x) {
                NavigationBar navigationBar = this.f13298c;
                if (navigationBar != null) {
                    navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13301f, c.a.u0.a4.f.ic_icon_pure_topbar_return40_svg, c.a.u0.a4.d.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13303h, c.a.u0.a4.f.icon_pure_topbar_close44_svg, c.a.u0.a4.d.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13304i, c.a.u0.a4.f.icon_pure_topbar_more44_svg, c.a.u0.a4.d.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13305j, c.a.u0.a4.f.icon_pure_topbar_share44_svg, c.a.u0.a4.d.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (i2 == 1) {
                this.y.setVisibility(0);
            }
            c.a.t0.m.d dVar = this.z;
            if (dVar != null) {
                dVar.f(i2);
            }
        }
    }

    public void p(int i2, int i3, int i4, int i5) {
        c.a.t0.m.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048600, this, i2, i3, i4, i5) == null) || (dVar = this.z) == null) {
            return;
        }
        dVar.h(i2, i3, i4, i5);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.f13298c;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MorePopupWindow morePopupWindow = this.q;
            if (morePopupWindow != null) {
                c.a.d.f.m.g.d(morePopupWindow, this.a.getPageContext().getPageActivity());
            }
            c.a.t0.m.d dVar = this.z;
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.addRule(3, c.a.u0.a4.g.view_navigation_bar);
            this.k.setLayoutParams(layoutParams);
            ImageView imageView = this.f13301f;
            if (imageView != null) {
                imageView.setBackgroundDrawable(null);
            }
            ImageView imageView2 = this.f13303h;
            if (imageView2 != null) {
                imageView2.setBackgroundDrawable(null);
            }
            ImageView imageView3 = this.f13304i;
            if (imageView3 != null) {
                imageView3.setBackgroundDrawable(null);
            }
            ImageView imageView4 = this.f13305j;
            if (imageView4 != null) {
                imageView4.setBackgroundDrawable(null);
            }
            NavigationBar navigationBar = this.f13298c;
            if (navigationBar != null) {
                navigationBar.showBottomLine(true);
            }
            BaseWebViewActivity baseWebViewActivity = this.a;
            if (baseWebViewActivity != null) {
                baseWebViewActivity.getWindow().clearFlags(1024);
            }
        }
    }

    public void s(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || (view = this.f13302g) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.height = -1;
            this.k.setLayoutParams(layoutParams);
            NavigationBar navigationBar = this.f13298c;
            if (navigationBar != null) {
                navigationBar.getBackground().mutate().setAlpha(0);
                this.f13298c.showBottomLine(false);
            }
            SkinManager.setBackgroundResource(this.f13301f, c.a.u0.a4.f.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.f13303h, c.a.u0.a4.f.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.f13304i, c.a.u0.a4.f.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.f13305j, c.a.u0.a4.f.frs_star_navigation_bg);
            z("");
            this.a.getWindow().setFlags(1024, 1024);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.v = z;
        }
    }

    public void v(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (view = this.p) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (z) {
                this.k.getLayoutParams().height = -1;
                this.f13298c.setVisibility(0);
                return;
            }
            this.k.getLayoutParams().height = -1;
            this.f13298c.setVisibility(8);
        }
    }

    public void x(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i2) == null) || this.f13298c == null || (imageView = this.f13304i) == null) {
            return;
        }
        imageView.setVisibility(i2);
    }

    public void y() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.f13298c == null || (imageView = this.f13304i) == null || this.f13305j == null) {
            return;
        }
        imageView.setVisibility(8);
        this.f13305j.setVisibility(0);
        this.f13305j.setOnClickListener(this.a);
    }

    public void z(String str) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            NavigationBar navigationBar = this.f13298c;
            if (navigationBar != null) {
                this.f13299d = navigationBar.setCenterTextTitle(str);
                ImageView imageView2 = this.f13301f;
                if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.f13303h) != null && imageView.getVisibility() == 0) {
                    this.f13299d.setMaxWidth(n.f(this.a.getPageContext().getPageActivity(), c.a.u0.a4.e.ds152) * 2);
                }
                if (!this.x) {
                    SkinManager.setNavbarTitleColor(this.f13299d, c.a.u0.a4.d.CAM_X0105, c.a.u0.a4.d.s_navbar_title_color);
                } else {
                    this.f13299d.setTextColor(-1);
                }
            }
            c.a.t0.m.d dVar = this.z;
            if (dVar != null) {
                dVar.g();
            }
        }
    }
}
