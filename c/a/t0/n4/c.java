package c.a.t0.n4;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f19918b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19919c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19920d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19921e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f19922f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19923g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19924h;

    /* renamed from: i  reason: collision with root package name */
    public PermissionJudgePolicy f19925i;

    /* renamed from: j  reason: collision with root package name */
    public View f19926j;
    public ImageView k;
    public PopupWindow l;
    public boolean m;
    public Handler n;
    public int o;
    public Runnable p;
    public Runnable q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19927e;

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
            this.f19927e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19927e.o == 1) {
                    TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 22));
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "1"));
                }
                this.f19927e.p(6, false);
                c.a.t0.l3.a.v().L(6, false, true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(this.f19927e.a)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19928e;

        public b(c cVar) {
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
            this.f19928e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19928e.o == 1) {
                    TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 23));
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
                }
                this.f19928e.p(5, false);
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
                this.f19928e.p(5, false);
                c.a.t0.l3.a.v().L(5, false, true);
                if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                    BdToast.d(this.f19928e.a, this.f19928e.a.getResources().getString(R.string.plugin_video_installing), 0).q();
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
            }
        }
    }

    /* renamed from: c.a.t0.n4.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1237c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19929e;

        /* renamed from: c.a.t0.n4.c$c$a */
        /* loaded from: classes8.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View$OnClickListenerC1237c a;

            public a(View$OnClickListenerC1237c view$OnClickListenerC1237c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC1237c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view$OnClickListenerC1237c;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TiebaStatic.log(new StatisticItem("c12706"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.a.f19929e.a)));
                }
            }
        }

        public View$OnClickListenerC1237c(c cVar) {
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
            this.f19929e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f19929e.a instanceof Activity)) {
                Activity activity = (Activity) this.f19929e.a;
                if (this.f19929e.f19925i == null) {
                    this.f19929e.f19925i = new PermissionJudgePolicy();
                }
                this.f19929e.f19925i.clearRequestPermissionList();
                this.f19929e.f19925i.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                this.f19929e.f19925i.setOnPermissionsGrantedListener(new a(this));
                this.f19929e.f19925i.startRequestPermission(activity);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19930e;

        public d(c cVar) {
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
            this.f19930e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (imageView = this.f19930e.f19923g) == null) {
                return;
            }
            c.a.d.f.m.g.k(this.f19930e.l, imageView);
            c.a.s0.s.i0.b.k().u("show_person_tab_feedback_tips", true);
            this.f19930e.m = true;
            this.f19930e.n.postDelayed(this.f19930e.q, 3000L);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19931e;

        public e(c cVar) {
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
            this.f19931e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19931e.l();
            }
        }
    }

    public c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.n = new Handler();
        this.p = new d(this);
        this.q = new e(this);
        this.o = i2;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19918b.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            if (this.o == 1) {
                RelativeLayout relativeLayout = this.f19919c;
                if (relativeLayout != null && relativeLayout.getParent() == null) {
                    this.f19918b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f19919c, (View.OnClickListener) null);
                }
                RelativeLayout relativeLayout2 = this.f19922f;
                if (relativeLayout2 != null && relativeLayout2.getParent() == null) {
                    this.f19918b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f19922f, (View.OnClickListener) null);
                }
                View view = this.f19926j;
                if (view == null || view.getParent() != null) {
                    return;
                }
                this.f19918b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f19926j, (View.OnClickListener) null);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.f.m.g.c(this.l);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f19920d != null) {
                if (2 == i2) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19920d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (this.f19918b.getBarBgView().getAlpha() < 0.5f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19920d, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19920d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                ImageView imageView = this.f19921e;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.drawable.icon_news_down_bar_one);
                }
            }
            if (this.f19923g != null) {
                if (2 == i2) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19923g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (this.f19918b.getBarBgView().getAlpha() < 0.5f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19923g, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19923g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                ImageView imageView2 = this.f19924h;
                if (imageView2 != null) {
                    SkinManager.setImageResource(imageView2, R.drawable.icon_news_down_bar_one);
                }
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void n(Context context, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, navigationBar) == null) {
            this.a = context;
            this.f19918b = navigationBar;
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
            this.f19919c = relativeLayout;
            this.f19920d = (ImageView) relativeLayout.findViewById(R.id.person_navigation_dressup_img);
            this.f19921e = (ImageView) this.f19919c.findViewById(R.id.person_navigation_dressup_red_tip);
            RelativeLayout relativeLayout2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
            this.f19922f = relativeLayout2;
            this.f19923g = (ImageView) relativeLayout2.findViewById(R.id.person_navigation_setting_img);
            this.f19924h = (ImageView) this.f19922f.findViewById(R.id.person_navigation_setting_red_tip);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
            this.f19926j = inflate;
            this.k = (ImageView) inflate.findViewById(R.id.person_navigation_scan_img);
        }
    }

    public void o(c.a.t0.n4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            RelativeLayout relativeLayout = this.f19919c;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new a(this));
            }
            RelativeLayout relativeLayout2 = this.f19922f;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new b(this));
            }
            View view = this.f19926j;
            if (view != null) {
                view.setOnClickListener(new View$OnClickListenerC1237c(this));
            }
        }
    }

    public void p(int i2, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 5 && (imageView2 = this.f19924h) != null) {
                imageView2.setVisibility(z ? 0 : 8);
            } else if (i2 != 6 || (imageView = this.f19921e) == null) {
            } else {
                imageView.setVisibility(z ? 0 : 8);
            }
        }
    }
}
