package c.a.r0.u0.m;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.g.d;
import c.a.d.m.e.c;
import c.a.q0.s.g0.f;
import c.a.q0.s.q.r1;
import c.a.q0.s.q.s1;
import c.a.q0.s.q.x;
import c.a.r0.u0.m.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements EnterForumAdView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean M;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public int B;
    public int C;
    public CustomMessageListener D;
    public boolean E;
    public boolean F;
    public Runnable G;
    public View H;
    public float I;
    public ImageView J;
    public boolean K;
    public boolean L;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public final EnterForumFragment f24349b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.s.g0.g f24350c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f24351d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.u0.c.a f24352e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.r0.u0.d.f> f24353f;

    /* renamed from: g  reason: collision with root package name */
    public r1 f24354g;

    /* renamed from: h  reason: collision with root package name */
    public ViewEventCenter f24355h;

    /* renamed from: i  reason: collision with root package name */
    public CommonTipView f24356i;

    /* renamed from: j  reason: collision with root package name */
    public View f24357j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.g0.h f24358k;
    public View l;
    public EnterForumAdView m;
    public View n;
    public GuidePopupWindow o;
    public c.a.d.f.g.c p;
    public int q;
    public c.a.r0.u0.m.d r;
    public c.a.r0.u0.d.c s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public f.g x;
    public f.g y;
    public AbsListView.OnScrollListener z;

    /* loaded from: classes6.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24359e;

        /* renamed from: c.a.r0.u0.m.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1389a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f24360e;

            public RunnableC1389a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24360e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f24360e.f24359e.f24351d.setSelection(0);
                }
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24359e = bVar;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f24359e.K) {
                return;
            }
            c.a.r0.s3.c.g().j(this.f24359e.f24349b.getUniqueId());
            if (this.f24359e.x != null) {
                this.f24359e.x.onListPullRefresh(z);
            }
            if (z) {
                b bVar = this.f24359e;
                if (bVar.E || bVar.s == null || !this.f24359e.s.a) {
                    return;
                }
                if (this.f24359e.s.f24106c > 0) {
                    this.f24359e.f24351d.smoothScrollToPosition(0, 0, 0);
                    this.f24359e.j0();
                    return;
                }
                c.a.d.f.m.e.a().post(new RunnableC1389a(this));
            }
        }
    }

    /* renamed from: c.a.r0.u0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1390b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1390b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.d.f.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.d.f.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24361e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24361e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24361e.p == null) {
                return;
            }
            this.f24361e.p.e();
            this.f24361e.p = null;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24362e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24362e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                EnterForumAdView.clickAd(this.f24362e.f24349b.getPageContext().getUniqueId(), this.f24362e.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f24363e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f24364f;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24364f = bVar;
            this.f24363e = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f24364f.I = motionEvent.getRawY();
                } else if (action == 1) {
                    if (this.f24364f.I <= (this.f24364f.a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.f24364f.I) {
                        this.f24364f.i0();
                        if (this.f24363e < 50.0f) {
                            this.f24364f.H.performClick();
                        }
                    } else {
                        this.f24364f.d0();
                    }
                    this.f24364f.I = 0.0f;
                    this.f24363e = 0.0f;
                } else if (action != 2) {
                    if (this.f24364f.I <= (this.f24364f.a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.f24364f.I) {
                        this.f24364f.i0();
                    } else {
                        this.f24364f.d0();
                    }
                    this.f24364f.I = 0.0f;
                    this.f24363e = 0.0f;
                } else {
                    if (motionEvent.getRawY() < this.f24364f.I) {
                        this.f24364f.m0(motionEvent.getRawY() - this.f24364f.I);
                        if (this.f24364f.J != null) {
                            this.f24364f.J.setVisibility(8);
                        }
                    }
                    if (Math.abs(motionEvent.getRawY() - this.f24364f.I) > this.f24363e) {
                        this.f24363e = Math.abs(motionEvent.getRawY() - this.f24364f.I);
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24365e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24365e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24365e.d0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f24366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f24367f;

        public g(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24367f = bVar;
            this.f24366e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.f24367f.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.f24367f.m.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        this.f24367f.I();
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(0, intValue, 0, 0);
                        this.f24367f.m.setLayoutParams(marginLayoutParams);
                        if (intValue / this.f24366e < 0.2d) {
                            if (this.f24367f.m.getParent() != this.f24367f.m.getRootView() && (viewGroup = (ViewGroup) this.f24367f.m.getRootView()) != null) {
                                ((ViewGroup) this.f24367f.m.getParent()).removeView(this.f24367f.m);
                                if (this.f24367f.m.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                    viewGroup.addView(this.f24367f.m, marginLayoutParams2);
                                }
                                viewGroup.bringChildToFront(this.f24367f.H);
                                viewGroup.bringChildToFront(this.f24367f.J);
                            }
                        } else if (this.f24367f.m.getParent() == this.f24367f.m.getRootView()) {
                            if (this.f24367f.m.getParent() != null) {
                                ViewGroup viewGroup2 = (ViewGroup) this.f24367f.m.getRootView();
                                ((ViewGroup) this.f24367f.m.getParent()).removeView(this.f24367f.m);
                            }
                            if (this.f24367f.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                this.f24367f.f24349b.getRootLayout().addView(this.f24367f.m, 0, marginLayoutParams3);
                            }
                        }
                    }
                }
                this.f24367f.K = false;
                this.f24367f.q0(((intValue - this.f24366e) * 2) + 0);
                this.f24367f.K = true;
                float abs = Math.abs(intValue / this.f24366e);
                this.f24367f.f24351d.setAlpha(abs);
                View u = this.f24367f.f24349b.getTabViewController().u();
                if (u != null) {
                    u.setAlpha(abs);
                }
                View findViewById = this.f24367f.f24349b.getRootLayout().getRootView().findViewById(R.id.tabcontainer_wrapper);
                if (findViewById != null) {
                    findViewById.setAlpha(abs);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f24368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f24369f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f24370g;

        public h(b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24370g = bVar;
            this.f24368e = i2;
            this.f24369f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.f24370g.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.f24370g.m.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        this.f24370g.I();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(0, 0, 0, 0);
                        this.f24370g.m.setLayoutParams(layoutParams2);
                    }
                }
                this.f24370g.f24350c.u();
                this.f24370g.f24351d.completePullRefresh();
                this.f24370g.f24350c.x(0, -this.f24370g.f24350c.k(), 0, 0);
                this.f24370g.K = false;
                this.f24370g.q0(0 - (this.f24368e * 2));
                this.f24370g.K = true;
                this.f24370g.f24351d.setVisibility(8);
                this.f24370g.H.setEnabled(true);
                FrameLayout frameLayout = (FrameLayout) this.f24369f;
                if (this.f24370g.H.getParent() == null) {
                    frameLayout.addView(this.f24370g.H, new FrameLayout.LayoutParams(-1, -1));
                }
                if (this.f24370g.J.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.bottomMargin = this.f24370g.a.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                    layoutParams3.gravity = 81;
                    frameLayout.addView(this.f24370g.J, layoutParams3);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24371e;

        public i(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24371e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f24371e.m0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24372e;

        public j(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24372e = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f24372e.m0(0.0f);
                this.f24372e.f24350c.u();
                this.f24372e.f24351d.completePullRefresh();
                this.f24372e.f24350c.x(0, -this.f24372e.f24350c.k(), 0, 0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24373e;

        public k(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24373e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f24373e.m0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24374e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f24375e;

            /* renamed from: c.a.r0.u0.m.b$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC1391a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f24376e;

                public RunnableC1391a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24376e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f24376e.f24375e.f24374e.K = false;
                    }
                }
            }

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24375e = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ViewGroup viewGroup = (ViewGroup) this.f24375e.f24374e.H.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f24375e.f24374e.H);
                        viewGroup.removeView(this.f24375e.f24374e.J);
                    }
                    this.f24375e.f24374e.J.setVisibility(0);
                    this.f24375e.f24374e.K = false;
                    this.f24375e.f24374e.l0();
                    this.f24375e.f24374e.C = 0;
                    this.f24375e.f24374e.q0(0);
                    this.f24375e.f24374e.K = true;
                    this.f24375e.f24374e.f24350c.u();
                    this.f24375e.f24374e.f24351d.completePullRefresh();
                    this.f24375e.f24374e.f24350c.x(0, -this.f24375e.f24374e.f24350c.k(), 0, 0);
                    c.a.d.f.m.e.a().postDelayed(new RunnableC1391a(this), 0L);
                    this.f24375e.f24374e.f24351d.setVisibility(0);
                }
            }
        }

        public l(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24374e = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                c.a.d.f.m.e.a().post(new a(this));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f24377e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f24378f;

        public m(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24378f = bVar;
            this.f24377e = -1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                if (this.f24378f.f24349b.isPrimary() && this.f24377e != 1 && i2 == 0) {
                    for (int i5 = i2; i5 < i2 + i3; i5++) {
                        Object itemAtPosition = this.f24378f.f24351d.getItemAtPosition(i5);
                        if (itemAtPosition != null && (itemAtPosition instanceof x)) {
                            x xVar = (x) itemAtPosition;
                            if (xVar.g() == 1 && this.f24378f.f24351d.getItemAtPosition(i5) == ListUtils.getItem(this.f24378f.f24353f, 0)) {
                                this.f24378f.w0(xVar, this.f24378f.f24351d.getChildAt(i5).findViewById(R.id.forum_intro));
                            }
                        }
                    }
                }
                this.f24378f.r.onScroll(absListView, i2, i3, i4);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                this.f24378f.r.onScrollStateChanged(absListView, i2);
                if (this.f24377e != i2) {
                    this.f24377e = i2;
                    if (i2 == 1) {
                        if (this.f24378f.s == null || !this.f24378f.s.a) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
                        }
                        this.f24378f.N();
                        return;
                    }
                    this.f24378f.E();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24379e;

        public n(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24379e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f24379e.s != null && this.f24379e.s.a) {
                b bVar = this.f24379e;
                if (bVar.E) {
                    EnterForumAdView unused = bVar.m;
                    EnterForumAdView.clickAd(this.f24379e.f24349b.getUniqueId(), this.f24379e.f24349b.getContext());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public p(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.u0.m.d.c
        public void a(AbsListView absListView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, absListView, i2, i3) == null) || this.a.K) {
                return;
            }
            this.a.B = -i2;
            b bVar = this.a;
            if (bVar.E) {
                bVar.e0();
            } else if (bVar.s == null || !this.a.s.a) {
            } else {
                this.a.l0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public q(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.d.m.e.c.a
        public void a(c.a.d.m.e.c cVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.a.C = i4;
                b bVar = this.a;
                if (bVar.E || bVar.s == null || !this.a.s.a || this.a.K) {
                    return;
                }
                this.a.l0();
                if (i4 > this.a.w) {
                    this.a.C = 0;
                    b bVar2 = this.a;
                    bVar2.u0(bVar2.f24349b.getTabViewController().s());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24380e;

        public r(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24380e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24380e.e0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24381e;

        public s(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24381e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24381e.O();
                this.f24381e.y0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements c.a.d.f.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public t(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.d.f.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tips)).setText(this.a.q);
                this.a.f24349b.getPageContext().getLayoutMode().j(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.d.f.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(973990148, "Lc/a/r0/u0/m/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(973990148, "Lc/a/r0/u0/m/b;");
        }
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment, view, viewEventCenter, recentlyVisitedForumModel, enterForumModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = true;
        this.y = new a(this);
        this.z = new m(this);
        this.A = new n(this);
        this.B = 0;
        this.C = 0;
        this.D = new o(this, 2921474);
        this.E = false;
        this.F = false;
        this.G = new r(this);
        this.K = false;
        this.f24349b = enterForumFragment;
        this.u = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + c.a.d.f.p.l.f(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.v = c.a.d.f.p.l.f(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.w = c.a.d.f.p.l.f(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.f24355h = viewEventCenter;
        R(view);
        c.a.r0.u0.c.a aVar = new c.a.r0.u0.c.a(this.f24349b.getPageContext(), this.f24355h, recentlyVisitedForumModel, enterForumModel, this);
        this.f24352e = aVar;
        this.f24351d.setAdapter((ListAdapter) aVar);
        W(TbadkCoreApplication.getInst().getSkinType());
        g0();
        this.o = new GuidePopupWindow(this.f24349b.getFragmentActivity());
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (U()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
                return;
            }
            c.a.r0.u0.d.c cVar = this.s;
            if (cVar != null && cVar.a) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
            }
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.r0.u0.c.a aVar = this.f24352e;
            if (aVar == null) {
                return false;
            }
            return aVar.f();
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.E) {
                this.F = true;
                return;
            }
            this.F = false;
            this.f24351d.completePullRefreshPostDelayed(0L);
        }
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.E ? -this.a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I();
        }
        return invokeV.intValue;
    }

    public final int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getResources().getDimensionPixelOffset(R.dimen.tbds934) : invokeV.intValue;
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdListView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f24351d : (BdListView) invokeV.objValue;
    }

    public final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (this.u - this.v) - (EnterForumDelegateStatic.f43487c.B() != null ? this.a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        }
        return invokeV.intValue;
    }

    public c.a.q0.g0.h M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f24358k : (c.a.q0.g0.h) invokeV.objValue;
    }

    public void N() {
        c.a.d.f.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.e();
        this.p = null;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.q0.g0.h hVar = this.f24358k;
            if (hVar != null) {
                hVar.dettachView(this.l);
                this.f24358k = null;
                this.l = null;
            }
            this.f24351d.setVisibility(0);
            if (this.f24349b.getTabViewController() != null) {
                this.f24349b.getTabViewController().F();
                this.f24349b.getTabViewController().L();
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.d.f.p.l.f(this.a, R.dimen.tbds240);
            View view = new View(this.a);
            this.H = view;
            view.setOnClickListener(new d(this));
            this.H.setOnTouchListener(new e(this));
            ImageView imageView = new ImageView(this.a);
            this.J = imageView;
            imageView.setOnClickListener(new f(this));
        }
    }

    public void Q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            EnterForumAdView enterForumAdView = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
            this.m = enterForumAdView;
            if (enterForumAdView != null) {
                l0();
                this.m.setTag(this.f24349b.getUniqueId());
                this.m.setAdData();
                this.m.setEventCenter(this.f24355h);
                this.m.setOnBackPressedListener(this);
            }
        }
    }

    public final void R(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            this.a = view.getContext();
            c.a.r0.u0.m.d dVar = new c.a.r0.u0.m.d();
            this.r = dVar;
            dVar.a(new p(this));
            this.f24351d = (BdListView) view.findViewById(R.id.listview);
            q0(0);
            this.f24351d.setBackgroundColor(0);
            this.f24351d.setVerticalScrollBarEnabled(false);
            this.f24351d.setOnScrollListener(this.z);
            this.f24351d.setFastScrollEnabled(false);
            this.f24351d.setMaxHeight(this.a.getResources().getDisplayMetrics().heightPixels);
            BdListView.setPullRefreshRatio(1.0f);
            if (this.f24349b.getTabViewController() != null) {
                this.f24349b.getTabViewController().Q(this);
            }
            c.a.q0.s.g0.g gVar = new c.a.q0.s.g0.g(this.f24349b.getPageContext());
            this.f24350c = gVar;
            gVar.w(new q(this));
            this.f24350c.U(true);
            this.f24350c.a(this.y);
            c.a.q0.s.g0.g gVar2 = this.f24350c;
            if (gVar2 != null) {
                gVar2.V(this.f24349b.getUniqueId());
            }
            this.f24351d.setPullRefresh(this.f24350c);
            FrameLayout frameLayout = new FrameLayout(this.f24349b.getPageContext().getPageActivity());
            View view2 = new View(this.f24349b.getPageContext().getPageActivity());
            this.n = view2;
            frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, this.v));
            this.f24351d.getAdapter2().e(frameLayout, 0);
            this.f24357j = new View(this.f24349b.getActivity());
            this.f24357j.setLayoutParams(new AbsListView.LayoutParams(-1, c.a.d.f.p.l.f(this.f24349b.getActivity(), R.dimen.ds50)));
            this.f24357j.setBackgroundResource(R.color.CAM_X0201);
            this.f24350c.N(this.A);
            this.f24350c.getView().setOnClickListener(this.A);
            this.n.setOnClickListener(this.A);
            P();
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ListUtils.isEmpty(this.f24353f) : invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TbadkCoreApplication.isLogin() && !c.a.q0.s.e0.b.j().g("has_guide_popup_window_been_shown", false) : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            BdListView bdListView = this.f24351d;
            return bdListView == null || bdListView.getChildCount() == 0 || this.f24351d.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f24352e.notifyDataSetChanged();
            View view = this.f24357j;
            if (view == null || view.getLayoutParams() == null) {
                return;
            }
            if (z) {
                this.f24357j.getLayoutParams().height = c.a.d.f.p.l.f(this.a, R.dimen.ds50);
                return;
            }
            this.f24357j.getLayoutParams().height = c.a.d.f.p.l.f(this.a, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
                this.f24351d.removeFooterView(this.f24357j);
                this.f24351d.addFooterView(this.f24357j);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.f24351d.removeFooterView(this.f24357j);
            }
            c.a.q0.s.g0.g gVar = this.f24350c;
            if (gVar != null) {
                gVar.C(i2);
            }
            c.a.q0.g0.h hVar = this.f24358k;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            GuidePopupWindow guidePopupWindow = this.o;
            if (guidePopupWindow != null) {
                guidePopupWindow.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f24357j, R.color.CAM_X0201);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            CommonTipView commonTipView = this.f24356i;
            if (commonTipView != null) {
                commonTipView.onDestroy();
            }
            c.a.r0.u0.c.a aVar = this.f24352e;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void Y(View view, int i2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048596, this, view, i2) == null) || view == (bdListView = this.f24351d)) {
            return;
        }
        bdListView.smoothScrollBy(-i2, 100);
        c.a.d.f.p.l.f(this.a, R.dimen.tbds240);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            N();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.f24349b.isAdded() && this.f24349b.isPrimary()) {
                M = false;
                c.a.r0.u0.c.a aVar = this.f24352e;
                if (aVar != null) {
                    aVar.h();
                    BdListView bdListView = this.f24351d;
                    if (bdListView != null) {
                        Object itemAtPosition = this.f24351d.getItemAtPosition(bdListView.getLastVisiblePosition());
                        if (itemAtPosition != null && (itemAtPosition instanceof x) && ((x) itemAtPosition).g() == 5) {
                            this.f24352e.m();
                        }
                    }
                }
                if (this.K) {
                    this.m.requestFocus();
                    this.m.requestFocusFromTouch();
                    return;
                }
                return;
            }
            N();
        }
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f24352e.i(i2);
        }
    }

    public void c0() {
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || TbadkCoreApplication.getCurrentAccount() != null || !c.a.q0.s.e0.b.j().g("enter_forum_login_tip", true) || (enterForumFragment = this.f24349b) == null || enterForumFragment.getActivity() == null || this.f24349b.getTabLayout() == null) {
            return;
        }
        if (this.f24356i == null) {
            this.f24356i = new CommonTipView(this.f24349b.getActivity());
        }
        this.f24356i.setText(R.string.enter_forum_login_tip);
        this.f24356i.show(this.f24349b.getTabLayout(), TbadkCoreApplication.getInst().getSkinType());
        c.a.q0.s.e0.b.j().t("enter_forum_login_tip", false);
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.H.setEnabled(false);
            int H = H();
            Math.abs(H / (L() - H));
            this.J.setVisibility(8);
            int i2 = ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin;
            ValueAnimator ofInt = ValueAnimator.ofInt(J(), H);
            ofInt.addUpdateListener(new k(this));
            ofInt.addListener(new l(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.E = false;
            l0();
            q0(0);
            if (this.F) {
                this.f24351d.completePullRefreshPostDelayed(0L);
            }
            this.F = false;
        }
    }

    public void f0(List<c.a.r0.u0.d.f> list, r1 r1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, list, r1Var, z) == null) {
            this.m.setAdData();
            EnterForumDelegateStatic.f43487c.D(this.a);
            this.f24353f = list;
            this.f24354g = r1Var;
            ArrayList arrayList = new ArrayList();
            boolean z2 = !ListUtils.isEmpty(list);
            boolean z3 = !ListUtils.isEmpty(list);
            x xVar = new x();
            xVar.i(4);
            arrayList.add(xVar);
            if (z3) {
                arrayList.add(new c.a.r0.u0.d.a(true));
                arrayList.add(new c.a.r0.u0.d.e(this.a.getResources().getString(R.string.my_attention_bar), z2));
                arrayList.addAll(list);
                arrayList.add(r1Var);
            } else {
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new c.a.r0.u0.d.e(this.a.getResources().getString(R.string.my_attention_bar), z2));
                }
                if (TbadkCoreApplication.isLogin()) {
                    x xVar2 = new x();
                    xVar2.i(11);
                    arrayList.add(xVar2);
                } else {
                    x xVar3 = new x();
                    xVar3.i(3);
                    arrayList.add(xVar3);
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new s1(this.a.getResources().getString(R.string.recommend_forum_title_vertical), true));
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.addAll(r1Var.k());
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new c.a.r0.u0.d.a(false));
                }
            }
            if (z) {
                x xVar4 = new x();
                xVar4.i(5);
                arrayList.add(xVar4);
            }
            O();
            this.f24352e.k(arrayList, z);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.f24349b.registerListener(this.D);
        }
    }

    public void h0(c.a.r0.u0.d.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048605, this, fVar, z) == null) {
            this.f24353f.remove(fVar);
            f0(this.f24353f, this.f24354g, z);
            V(z);
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ImageView imageView = this.J;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(J(), 0);
            ofInt.addUpdateListener(new i(this));
            ofInt.addListener(new j(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public void j0() {
        int dimensionPixelSize;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.K) {
            return;
        }
        this.E = true;
        l0();
        int dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.f24350c.k();
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            if (!enterForumAdView.isRecentlyShow()) {
                dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.a.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.m.isRecentlyExtend()) {
                dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
            dimensionPixelOffset += dimensionPixelSize;
        }
        q0(dimensionPixelOffset);
        c.a.d.f.m.e.a().removeCallbacks(this.G);
        c.a.d.f.m.e.a().postDelayed(this.G, 3000L);
    }

    public void k0(c.a.r0.u0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, cVar) == null) {
            this.s = cVar;
            c.a.r0.u0.c.a aVar = this.f24352e;
            if (aVar != null) {
                aVar.j(cVar);
            }
            if (cVar != null && cVar.a) {
                if (this.f24350c.getView() != null) {
                    this.f24350c.getView().setScaleX(0.5f);
                    this.f24350c.getView().setScaleY(0.5f);
                }
                this.f24350c.L(R.raw.ad_refresh_load);
                return;
            }
            if (this.f24350c.getView() != null) {
                this.f24350c.getView().setScaleX(1.0f);
                this.f24350c.getView().setScaleY(1.0f);
            }
            this.f24350c.L(R.raw.lottie_common_pull_refresh);
        }
    }

    public final void l0() {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.K || (enterForumAdView = this.m) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int I = I();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, this.E ? -this.a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I, 0, 0);
            this.m.setLayoutParams(layoutParams2);
            this.m.setAdViewHeight(layoutParams2.height - I);
        }
    }

    public final void m0(float f2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048610, this, f2) == null) {
            int H = H();
            int L = L() - H;
            float f3 = H;
            float abs = Math.abs(f3 / L);
            int i2 = (int) f2;
            EnterForumAdView enterForumAdView = this.m;
            if (enterForumAdView != null) {
                ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    I();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(0, i2, 0, 0);
                    this.m.setLayoutParams(marginLayoutParams);
                    if (Math.abs(marginLayoutParams.topMargin) < marginLayoutParams.height * 0.2d) {
                        if (this.m.getParent() != this.m.getRootView() && (viewGroup = (ViewGroup) this.m.getRootView()) != null) {
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                            if (this.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                viewGroup.addView(this.m, marginLayoutParams2);
                            }
                            viewGroup.bringChildToFront(this.H);
                            viewGroup.bringChildToFront(this.J);
                        }
                    } else if (this.m.getParent() == this.m.getRootView()) {
                        if (this.m.getParent() != null) {
                            ViewGroup viewGroup2 = (ViewGroup) this.m.getRootView();
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                        }
                        if (this.m.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                            this.f24349b.getRootLayout().addView(this.m, 0, marginLayoutParams3);
                        }
                    }
                }
            }
            this.f24351d.setVisibility(0);
            this.K = false;
            float f4 = i2;
            q0(((int) ((f4 * abs) - (abs * f3))) * 2);
            this.K = true;
            float abs2 = Math.abs(f4 / f3);
            this.f24351d.setAlpha(abs2);
            View u = this.f24349b.getTabViewController().u();
            if (u != null) {
                u.setAlpha(abs2);
            }
            View findViewById = this.f24349b.getRootLayout().getRootView().findViewById(R.id.tabcontainer_wrapper);
            if (findViewById != null) {
                findViewById.setAlpha(abs2);
            }
        }
    }

    public void n0(c.a.r0.u0.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) || aVar == null) {
            return;
        }
        if (StringUtils.isNull(aVar.d())) {
            this.L = false;
        } else {
            this.L = true;
        }
        this.o.setForumId(aVar.c());
        this.o.setNumber(aVar.b(), aVar.e());
        this.o.setBaName(aVar.a());
        this.o.setmForumName(aVar.d());
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || this.t == z) {
            return;
        }
        this.t = z;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f24351d.getLayoutParams();
        if (!z) {
            marginLayoutParams.topMargin += this.f24351d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        } else {
            marginLayoutParams.topMargin -= this.f24351d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        }
        this.f24351d.setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.tieba.enterForum.view.EnterForumAdView.c
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.K) {
            d0();
        }
    }

    public void p0(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, gVar) == null) {
            this.x = gVar;
        }
    }

    public final void q0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i2) == null) || this.K) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f24351d.getLayoutParams();
        marginLayoutParams.topMargin = ((i2 + this.u) - this.v) - (EnterForumDelegateStatic.f43487c.B() != null ? this.a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        this.f24351d.setLayoutParams(marginLayoutParams);
    }

    public void r0(BdUniqueId bdUniqueId) {
        c.a.r0.u0.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, bdUniqueId) == null) || (aVar = this.f24352e) == null) {
            return;
        }
        aVar.l(bdUniqueId);
    }

    public void s0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z) == null) || (enterForumAdView = this.m) == null) {
            return;
        }
        enterForumAdView.setRecentlyIsExtend(z);
    }

    public void t0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z) == null) || (enterForumAdView = this.m) == null) {
            return;
        }
        enterForumAdView.setRecentlyIsShow(z);
    }

    public void u0(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, view) == null) && (view instanceof FrameLayout) && !this.K) {
            this.f24350c.q();
            this.K = true;
            this.m.getAdImageView().getLocationInWindow(new int[2]);
            SkinManager.setImageResource(this.J, R.drawable.icon_jinba_retract_n);
            int J = J();
            ValueAnimator ofInt = ValueAnimator.ofInt(J, 0);
            ofInt.addUpdateListener(new g(this, J));
            ofInt.addListener(new h(this, J, view));
            ofInt.setDuration(300L);
            ofInt.start();
            this.m.requestFocus();
            this.m.requestFocusFromTouch();
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && T() && this.L) {
            this.o.setUserHeadImg();
            this.o.setUserNickName();
            this.o.setCancelable(false);
            c.a.q0.s.e0.b.j().t("has_guide_popup_window_been_shown", true);
            c.a.d.f.m.g.i(this.o, this.f24349b.getFragmentActivity());
        }
    }

    public void w0(x xVar, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, xVar, view) == null) || !TbadkCoreApplication.isLogin() || M || this.f24349b.getActivity() == null || this.f24349b.getPageContext() == null || !(xVar instanceof c.a.r0.u0.d.f)) {
            return;
        }
        c.a.r0.u0.d.f fVar = (c.a.r0.u0.d.f) xVar;
        if (fVar.F() != 0 && fVar.E() != 0 && !c.a.q0.s.e0.b.j().p("enter_forum_new_forum_long_press_guide", "").equals(fVar.p())) {
            this.q = R.string.create_forum_guide_tip;
        } else if (c.a.q0.s.e0.b.j().l("enter_forum_long_press_guide", 0L) != 0) {
            return;
        } else {
            this.q = R.string.forum_item_guide_tip;
        }
        if (view != null) {
            M = true;
            c.a.d.f.g.d dVar = new c.a.d.f.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new t(this));
            dVar.g(new C1390b(this));
            c.a.d.f.g.c b2 = dVar.b();
            this.p = b2;
            b2.o(false);
            this.p.p(true);
            this.p.q(this.f24349b.getActivity());
            int i2 = this.q;
            if (i2 == R.string.create_forum_guide_tip) {
                c.a.q0.s.e0.b.j().x("enter_forum_new_forum_long_press_guide", fVar.p());
            } else if (i2 == R.string.forum_item_guide_tip) {
                c.a.q0.s.e0.b.j().w("enter_forum_long_press_guide", 1L);
            }
            c.a.d.f.m.e.a().postDelayed(new c(this), 5000L);
        }
    }

    public void x0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view) == null) {
            if (this.f24358k == null) {
                this.f24358k = new c.a.q0.g0.h(this.f24349b.getPageContext().getContext(), new s(this));
            }
            this.l = view;
            this.f24358k.j(this.f24349b.getResources().getDimensionPixelSize(R.dimen.ds364));
            this.f24358k.attachView(view, false);
            this.f24358k.o();
            this.f24351d.setVisibility(8);
            if (this.f24349b.getTabViewController() != null) {
                this.f24349b.getTabViewController().F();
                this.f24349b.getTabViewController().L();
            }
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f24351d.startPullRefresh();
        }
    }
}
