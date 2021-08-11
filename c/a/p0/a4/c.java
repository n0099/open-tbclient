package c.a.p0.a4;

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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15359a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f15360b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15361c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15362d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15363e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f15364f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15365g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f15366h;

    /* renamed from: i  reason: collision with root package name */
    public PermissionJudgePolicy f15367i;

    /* renamed from: j  reason: collision with root package name */
    public View f15368j;
    public ImageView k;
    public PopupWindow l;
    public boolean m;
    public Handler n;
    public int o;
    public Runnable p;
    public Runnable q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15369e;

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
            this.f15369e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15369e.o == 1) {
                    TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 22));
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "1"));
                }
                this.f15369e.p(6, false);
                c.a.p0.y2.a.v().L(6, false, true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(this.f15369e.f15359a)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15370e;

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
            this.f15370e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15370e.o == 1) {
                    TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 23));
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
                }
                this.f15370e.p(5, false);
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
                this.f15370e.p(5, false);
                c.a.p0.y2.a.v().L(5, false, true);
                if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                    BdToast.d(this.f15370e.f15359a, this.f15370e.f15359a.getResources().getString(R.string.plugin_video_installing), 0).q();
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
            }
        }
    }

    /* renamed from: c.a.p0.a4.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0727c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15371e;

        /* renamed from: c.a.p0.a4.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0727c f15372a;

            public a(View$OnClickListenerC0727c view$OnClickListenerC0727c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0727c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15372a = view$OnClickListenerC0727c;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TiebaStatic.log(new StatisticItem("c12706"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.f15372a.f15371e.f15359a)));
                }
            }
        }

        public View$OnClickListenerC0727c(c cVar) {
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
            this.f15371e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f15371e.f15359a instanceof Activity)) {
                Activity activity = (Activity) this.f15371e.f15359a;
                if (this.f15371e.f15367i == null) {
                    this.f15371e.f15367i = new PermissionJudgePolicy();
                }
                this.f15371e.f15367i.clearRequestPermissionList();
                this.f15371e.f15367i.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                this.f15371e.f15367i.setOnPermissionsGrantedListener(new a(this));
                this.f15371e.f15367i.startRequestPermission(activity);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15373e;

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
            this.f15373e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (imageView = this.f15373e.f15365g) == null) {
                return;
            }
            c.a.e.e.m.g.k(this.f15373e.l, imageView);
            c.a.o0.s.d0.b.j().t("show_person_tab_feedback_tips", true);
            this.f15373e.m = true;
            this.f15373e.n.postDelayed(this.f15373e.q, 3000L);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15374e;

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
            this.f15374e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15374e.l();
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
            this.f15360b.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            if (this.o == 1) {
                RelativeLayout relativeLayout = this.f15361c;
                if (relativeLayout != null && relativeLayout.getParent() == null) {
                    this.f15360b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f15361c, (View.OnClickListener) null);
                }
                RelativeLayout relativeLayout2 = this.f15364f;
                if (relativeLayout2 != null && relativeLayout2.getParent() == null) {
                    this.f15360b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f15364f, (View.OnClickListener) null);
                }
                View view = this.f15368j;
                if (view == null || view.getParent() != null) {
                    return;
                }
                this.f15360b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f15368j, (View.OnClickListener) null);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.m.g.c(this.l);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f15362d != null) {
                if (2 == i2) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15362d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (this.f15360b.getBarBgView().getAlpha() < 0.5f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15362d, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15362d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                ImageView imageView = this.f15363e;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.drawable.icon_news_down_bar_one);
                }
            }
            if (this.f15365g != null) {
                if (2 == i2) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15365g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (this.f15360b.getBarBgView().getAlpha() < 0.5f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15365g, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15365g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                ImageView imageView2 = this.f15366h;
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
            this.f15359a = context;
            this.f15360b = navigationBar;
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
            this.f15361c = relativeLayout;
            this.f15362d = (ImageView) relativeLayout.findViewById(R.id.person_navigation_dressup_img);
            this.f15363e = (ImageView) this.f15361c.findViewById(R.id.person_navigation_dressup_red_tip);
            RelativeLayout relativeLayout2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
            this.f15364f = relativeLayout2;
            this.f15365g = (ImageView) relativeLayout2.findViewById(R.id.person_navigation_setting_img);
            this.f15366h = (ImageView) this.f15364f.findViewById(R.id.person_navigation_setting_red_tip);
            View inflate = LayoutInflater.from(this.f15359a).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
            this.f15368j = inflate;
            this.k = (ImageView) inflate.findViewById(R.id.person_navigation_scan_img);
        }
    }

    public void o(c.a.p0.a4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            RelativeLayout relativeLayout = this.f15361c;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new a(this));
            }
            RelativeLayout relativeLayout2 = this.f15364f;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new b(this));
            }
            View view = this.f15368j;
            if (view != null) {
                view.setOnClickListener(new View$OnClickListenerC0727c(this));
            }
        }
    }

    public void p(int i2, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 5 && (imageView2 = this.f15366h) != null) {
                imageView2.setVisibility(z ? 0 : 8);
            } else if (i2 != 6 || (imageView = this.f15363e) == null) {
            } else {
                imageView.setVisibility(z ? 0 : 8);
            }
        }
    }
}
